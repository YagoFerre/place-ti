package yago.ferreira.placeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yago.ferreira.placeti.entity.Curso;
import yago.ferreira.placeti.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

// Primeiro passo criar um curso com os campos: nome, quantidadeAlunos e nivelCurso na rota http://localhost:8080/cursos/

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    // Buscar todos os cursos
    @GetMapping("/")
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    // Buscar curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> obterCursoPorId(@PathVariable Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);

        if (curso.isPresent()) {
            return ResponseEntity.ok(curso.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar novo curso
    @PostMapping("/")
    public Curso criarCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    // Atualizar um curso existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable Long id, @RequestBody Curso novoCurso) {
        Optional<Curso> cursoExistente = cursoRepository.findById(id);

        if (cursoExistente.isPresent()) {
            Curso curso = cursoExistente.get();
            curso.setNome(novoCurso.getNome());
            curso.setQuantidadeAlunos(novoCurso.getQuantidadeAlunos());
            curso.setNivelCurso(novoCurso.getNivelCurso());

            cursoRepository.save(curso);
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Excluir um curso por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCurso(@PathVariable Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);

        if (curso.isPresent()) {
            cursoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
