package dev.java10x.CadastroDeNinjas.Missoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //MOSTRAR TODAS AS MISSÕES
    @GetMapping("/missoes/listar")
    public List<MissoesModel>listarMissoes(){
        return missoesService.listarMissoes();
    }

    //MOSTRAR MISSÕES POR ID
    @GetMapping("/missoes/listar/{id}")
    public MissoesModel missoesPorId(@PathVariable Long id){
        return missoesService.missoesPorID(id);
    }


}


