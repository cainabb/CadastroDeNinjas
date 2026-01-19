 package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

 @Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    //AQUI É A INJEÇÃO DE DEPEDENCIA, É PADRÃO FAZER POR CONSTRUTOR E NÃO PELO @DATA
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarNinjas(){
    return  ninjaRepository.findAll();
    }

    public NinjaModel listarNinjasPorId(Long id){
        //USO O OPTIONAL PQ PODE OU NÃO HAVER UM NINJA COM AQUELE ID
        Optional<NinjaModel> ninjaPorId= ninjaRepository.findById(id);

        //.orElse = Vai returnar um ninja por ID, se não tiver retorna null;
        return ninjaPorId.orElse(null);

    }





}
