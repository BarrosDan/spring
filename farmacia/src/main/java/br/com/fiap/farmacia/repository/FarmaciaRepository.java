package br.com.fiap.farmacia.repository;

import br.com.fiap.farmacia.model.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {

    Optional<Farmacia> findByRegistroFarmacia(Long id);

}
