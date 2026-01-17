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
    @PostMapping("/criar")
    public String criarninja (){
        return "Ninja Criado";
    }

    // MOSTRAR TODOS OS NINJAS - READ
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }


    // PROCURAR NINJA POR ID - CREATE
    @GetMapping("/todosID")
    public String MostrarTodosOsNinjasPorID(){
        return "Mostar todos os ninjas por ID";
    }

    // ALTERAR DADOS DO NINJA - UPDATE
    @PutMapping("/alterar")
    public String alterarNinjasPorID(){
        return "Alterar ninja por ID";
    }
    // DELETAR NINJA - DELETE
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorID(){
        return "Ninja deletado por ID";
    }



}
