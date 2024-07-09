package br.com.fiap.farmacia.service;

import br.com.fiap.farmacia.dto.FarmaciaDTO;
import br.com.fiap.farmacia.dto.FarmaciaExibicaoDTO;
import br.com.fiap.farmacia.exception.FarmaciaNaoEncontradaException;
import br.com.fiap.farmacia.model.Farmacia;
import br.com.fiap.farmacia.repository.FarmaciaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmaciaService {

    @Autowired
    private FarmaciaRepository farmaciaRepository;

    public FarmaciaExibicaoDTO criar(FarmaciaDTO farmaciaDTO){
        Farmacia farmacia = new Farmacia();
        BeanUtils.copyProperties(farmaciaDTO,farmacia);
        Farmacia farmaciaCriada = farmaciaRepository.save(farmacia);

        return new FarmaciaExibicaoDTO(farmaciaCriada);
    }

    public FarmaciaExibicaoDTO buscarPorRegistro(Long registroFarmacia){
        Optional<Farmacia> farmaciaOptional = farmaciaRepository.findByRegistroFarmacia(registroFarmacia);

        if (farmaciaOptional.isPresent()){
            return new FarmaciaExibicaoDTO(farmaciaOptional.get());
        } else {
            throw  new FarmaciaNaoEncontradaException("Farmácia não encontrada");
        }
    }

    public List<FarmaciaExibicaoDTO> listarTodasAsFarmacias(){
        return farmaciaRepository
                .findAll()
                .stream()
                .map(FarmaciaExibicaoDTO::new)
                .toList();
    }

    public void excluir(Long registroFarmacia){
        Optional<Farmacia> farmaciaOptional = farmaciaRepository.findByRegistroFarmacia(registroFarmacia);

        if (farmaciaOptional.isPresent()){
            farmaciaRepository.delete(farmaciaOptional.get());
        } else {
            throw new FarmaciaNaoEncontradaException("Farnácia não encontrada");
        }
    }

    public FarmaciaExibicaoDTO atualizar(FarmaciaDTO farmaciaDTO){
        Farmacia farmacia = new Farmacia();
        BeanUtils.copyProperties(farmaciaDTO, farmacia);
        Farmacia farmaciaAtualizada = farmaciaRepository.save(farmacia);

        return new FarmaciaExibicaoDTO(farmaciaAtualizada);
    }

}
