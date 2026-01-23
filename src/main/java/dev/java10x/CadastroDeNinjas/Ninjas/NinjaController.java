package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // TESTE
    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem";
    }

    // ===============================
    // CREATE - ADICIONAR NINJA
    // ===============================
    @PostMapping("/ninjas/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaModel ninja) {
        NinjaModel novoNinja = ninjaService.criarNinja(ninja);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " +
                        novoNinja.getNome() +
                        " (ID: " + novoNinja.getId() + ")");
    }

    // ===============================
    // READ - LISTAR TODOS
    // ===============================
    @GetMapping("/ninjas/listar")
    public ResponseEntity<List<NinjaModel>> listarNinjas() {
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    // ===============================
    // READ - LISTAR POR ID
    // ===============================
    @GetMapping("/ninjas/listar/{id}")
    public ResponseEntity<NinjaModel> listarNinjasPorId(@PathVariable Long id) {
        NinjaModel ninja = ninjaService.listarNinjasPorId(id);

        if (ninja == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(ninja);
    }

    // ===============================
    // UPDATE - ALTERAR NINJA
    // ===============================
    @PutMapping("/ninjas/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorId(
            @PathVariable Long id,
            @RequestBody NinjaModel ninjaAtualizado) {

        NinjaModel ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);

        if (ninja == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
        }

        return ResponseEntity.ok(
                "O ninja " + ninja.getNome() + " foi alterado com sucesso");
    }

    // ===============================
    // DELETE - DELETAR NINJA
    // ===============================
    @DeleteMapping("/ninjas/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        NinjaModel ninja = ninjaService.listarNinjasPorId(id);

        if (ninja == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id " + id + " não existe");
        }

        ninjaService.deletarNinjaPorID(id);

        return ResponseEntity.ok(
                "Ninja id " + id + " deletado com sucesso");
    }
}
