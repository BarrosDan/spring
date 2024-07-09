package br.com.fiap.remedio.repository;

import br.com.fiap.remedio.model.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
    Optional<Remedio> findByNumeroRemedio(Long id);
}
