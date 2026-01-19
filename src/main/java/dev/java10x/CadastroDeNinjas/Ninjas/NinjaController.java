package dev.java10x.CadastroDeNinjas.Ninjas;


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
    public NinjaModel criarNinja (@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);

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
    public String alterarNinjasPorID(){
        return "Alterar ninja por ID";
    }
    // DELETAR NINJA - DELETE
    @DeleteMapping("/ninjas/deletar/{id}")
    //O @PathVariable joga o Long id para dentro da url {id}
    public void deletarNinjaPorID(@PathVariable Long id){
    ninjaService.deletarNinjaPorID(id);
    }




}
