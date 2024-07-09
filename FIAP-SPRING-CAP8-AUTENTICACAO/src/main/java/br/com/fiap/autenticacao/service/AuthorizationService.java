package br.com.fiap.autenticacao.service;

import br.com.fiap.autenticacao.dto.UsuarioCadastroDTO;
import br.com.fiap.autenticacao.dto.UsuarioExibicaoDTO;
import br.com.fiap.autenticacao.model.Usuario;
import br.com.fiap.autenticacao.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }

    public UsuarioExibicaoDTO salvarUsuario(UsuarioCadastroDTO usuariodto){
        String senhaCriptografada = new
                BCryptPasswordEncoder().encode(usuariodto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuariodto, usuario);
        usuario.setSenha(senhaCriptografada);

        Usuario usuarioSalvo = repository.save(usuario);

        return new UsuarioExibicaoDTO(usuarioSalvo);
    }

}
