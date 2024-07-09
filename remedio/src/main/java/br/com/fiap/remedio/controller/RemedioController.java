package br.com.fiap.remedio.controller;

import br.com.fiap.remedio.dto.RemedioDTO;
import br.com.fiap.remedio.dto.RemedioExibicaoDTO;
import br.com.fiap.remedio.service.RemedioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioService service;

    @PostMapping
    public RemedioExibicaoDTO cadastrar(@RequestBody @Valid RemedioDTO remedioDTO){
        return  service.cadastrar(remedioDTO);
    }

    @GetMapping("{numeroRemedio}")
    public ResponseEntity<RemedioExibicaoDTO> buscarPorNumero(@PathVariable Long numeroRemedio){
        return ResponseEntity.ok(service.buscarPorNumero(numeroRemedio));
    }

    @GetMapping
    public ResponseEntity<List<RemedioExibicaoDTO>> listarTodosOsRemedios(){
        return ResponseEntity.ok(service.listarTodosOsRemedios());
    }

    @DeleteMapping("{numeroRemedio}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long numeroRemedio){service.excluir(numeroRemedio);}

    @PutMapping
    public RemedioExibicaoDTO atualizar(@RequestBody RemedioDTO remedioDTO){ return service.atualizar(remedioDTO);}

}
