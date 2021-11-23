package io.jnsdev.cobertura.repository;

import io.jnsdev.cobertura.model.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Autor Jairo Nascimento
 * @Created 22/11/2021 - 19:20
 */
@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {
}
