package yago.ferreira.placeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yago.ferreira.placeti.entity.Turma;
import yago.ferreira.placeti.repository.TurmaRepository;

import java.util.List;
import java.util.Optional;

// Segundo passo criar uma turma com os campos: codigo, nome e curso: { id: 1 (esse id deve ser o mesmo id do curso que deseja relacionar) }
// Na rota http://localhost:8080/turmas/ lembre-se ao criar uma turma no campo curso: { id } <-- esse id deve ser o mesmo do id do curso!

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    @Autowired
    private TurmaRepository turmaRepository;

    // Buscar todas as turmas
    @GetMapping("/")
    public List<Turma> listarTurmas() {
        return turmaRepository.findAll();
    }

    // Buscar uma turma por ID
    @GetMapping("/{id}")
    public ResponseEntity<Turma> obterTurmaPorId(@PathVariable Long id) {
        Optional<Turma> turma = turmaRepository.findById(id);
        if (turma.isPresent()) {
            return ResponseEntity.ok(turma.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar uma nova turma
    @PostMapping("/")
    public Turma criarTurma(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    // Atualizar uma turma existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizarTurma(@PathVariable Long id, @RequestBody Turma novaTurma) {
        Optional<Turma> turmaExistente = turmaRepository.findById(id);

        if (turmaExistente.isPresent()) {
            Turma turma = turmaExistente.get();
            turma.setCodigo(novaTurma.getCodigo());
            turma.setNome(novaTurma.getNome());

            turmaRepository.save(turma);
            return ResponseEntity.ok(turma);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Excluir uma turma por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTurma(@PathVariable Long id) {
        Optional<Turma> turma = turmaRepository.findById(id);

        if (turma.isPresent()) {
            turmaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

