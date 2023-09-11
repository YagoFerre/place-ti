package yago.ferreira.placeti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yago.ferreira.placeti.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}