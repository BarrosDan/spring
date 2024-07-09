package br.com.fiap.remedio.service;

import br.com.fiap.remedio.dto.RemedioDTO;
import br.com.fiap.remedio.dto.RemedioExibicaoDTO;
import br.com.fiap.remedio.exception.RemedioNaoEncontradoException;
import br.com.fiap.remedio.model.Remedio;
import br.com.fiap.remedio.repository.RemedioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemedioService {

    @Autowired
    private RemedioRepository remedioRepository;

    public RemedioExibicaoDTO cadastrar(RemedioDTO remedioDTO){
        Remedio remedio = new Remedio();
        BeanUtils.copyProperties(remedioDTO,remedio);
        Remedio remedioCriado = remedioRepository.save(remedio);

        return  new RemedioExibicaoDTO(remedioCriado);
    }

    public RemedioExibicaoDTO buscarPorNumero(Long numeroRemedio){
        Optional<Remedio> remedioOptional = remedioRepository.findByNumeroRemedio(numeroRemedio);

        if (remedioOptional.isPresent()){
            return new RemedioExibicaoDTO(remedioOptional.get());
        } else {
            throw new RemedioNaoEncontradoException("Remédio não Encontrado");
        }
    }

    public List<RemedioExibicaoDTO> listarTodosOsRemedios(){
        return remedioRepository
                .findAll()
                .stream()
                .map(RemedioExibicaoDTO::new)
                .toList();
    }

    public void excluir(Long numeroRemedio){
        Optional<Remedio> remedioOptional = remedioRepository.findByNumeroRemedio(numeroRemedio);

        if (remedioOptional.isPresent()){
            remedioRepository.delete(remedioOptional.get());
        }else {
            throw new RemedioNaoEncontradoException("Remedio Nao Encontrado");
        }
    }

    public RemedioExibicaoDTO atualizar(RemedioDTO remedioDTO){
        Remedio remedio = new Remedio();
        BeanUtils.copyProperties(remedioDTO, remedio);
        Remedio remedioAtualizado = remedioRepository.save(remedio);

        return new RemedioExibicaoDTO(remedioAtualizado);
    }

}
