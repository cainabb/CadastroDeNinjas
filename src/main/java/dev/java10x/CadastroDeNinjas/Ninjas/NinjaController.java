package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem";
    }



    //ADICIONAR NINJA - CREATE
    @PostMapping("/ninjas/criar")
    //@RequestBody
    public ResponseEntity<String> criarNinja (@RequestBody NinjaModel ninja){
        NinjaModel novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com Sucesso: "+novoNinja.getNome()+", "+novoNinja.getId()+".");

    }

    // MOSTRAR TODOS OS NINJAS - READ
    @GetMapping("/ninjas/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }


    // PROCURAR NINJA POR ID - CREATE
    //http://localhost:8080/listar/2 --> o 2 foi um exemplo
    @GetMapping("/ninjas/listar/{id}")
    //@PathVariable faz com que a URL do site seja passada pelo usuário, Path Caminho, Variable Variável
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    // ALTERAR DADOS DO NINJA - UPDATE
    @PutMapping("/ninjas/alterar")
    public NinjaModel alterarNinjasPorID(){
        return alterarNinjasPorID();
    }

    // DELETAR NINJA - DELETE
    @DeleteMapping("/ninjas/deletar/{id}")
    //O @PathVariable joga o Long id para dentro da url {id}
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id){
        if (ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorID(id);
            return ResponseEntity.status(HttpStatus.OK).body("Ninja id "+id+" deletado com sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com id "+id+" não existe");
        }
     }




    //ALTERAR DADOS DO NINJA
    @PutMapping("ninjas/alterar/{id}")
    public NinjaModel alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);

    }




}
