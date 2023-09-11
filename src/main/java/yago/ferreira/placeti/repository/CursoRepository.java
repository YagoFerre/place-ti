package yago.ferreira.placeti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yago.ferreira.placeti.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
