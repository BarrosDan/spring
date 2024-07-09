package br.com.fiap.farmacia.controller;

import br.com.fiap.farmacia.dto.FarmaciaDTO;
import br.com.fiap.farmacia.dto.FarmaciaExibicaoDTO;
import br.com.fiap.farmacia.service.FarmaciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {

    @Autowired
    private FarmaciaService service;

    @PostMapping
    public FarmaciaExibicaoDTO criar(@RequestBody @Valid FarmaciaDTO farmaciaDTO){ return service.criar(farmaciaDTO);}

    @GetMapping("{registroFarmacia}")
    public ResponseEntity<FarmaciaExibicaoDTO> buscarPorRegistro(@PathVariable Long registroFarmacia){
        return ResponseEntity.ok(service.buscarPorRegistro(registroFarmacia));
    }
    @GetMapping
    public ResponseEntity<List<FarmaciaExibicaoDTO>> listarTodasAsFarmacias(){
        return ResponseEntity.ok(service.listarTodasAsFarmacias());
    }

    @DeleteMapping("{registroFarmacia}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long registroFarmacia){ service.excluir(registroFarmacia);}

    public FarmaciaExibicaoDTO atualizar(@RequestBody FarmaciaDTO farmaciaDTO){return service.atualizar(farmaciaDTO);}

}
