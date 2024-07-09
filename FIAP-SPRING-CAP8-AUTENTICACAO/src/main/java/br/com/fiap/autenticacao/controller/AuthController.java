package br.com.fiap.autenticacao.controller;

import br.com.fiap.autenticacao.config.security.TokenService;
import br.com.fiap.autenticacao.dto.LoginDTO;
import br.com.fiap.autenticacao.dto.TokenDTO;
import br.com.fiap.autenticacao.dto.UsuarioCadastroDTO;
import br.com.fiap.autenticacao.dto.UsuarioExibicaoDTO;
import br.com.fiap.autenticacao.model.Usuario;
import br.com.fiap.autenticacao.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthorizationService service;

    @PostMapping("/login")
    public ResponseEntity login(
            @RequestBody
            @Valid
            LoginDTO usuarioDto
    ){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        usuarioDto.email(),
                        usuarioDto.senha());

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity registrar(@RequestBody @Valid UsuarioCadastroDTO usuarioCadastroDTO){

        UsuarioExibicaoDTO usuarioSalvo = null;
        usuarioSalvo = service.salvarUsuario(usuarioCadastroDTO);

        return ResponseEntity.ok(usuarioSalvo);

    }
}
