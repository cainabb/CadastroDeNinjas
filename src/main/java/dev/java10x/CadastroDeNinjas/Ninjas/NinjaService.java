 package dev.java10x.CadastroDeNinjas.Ninjas;

import org.hibernate.tuple.PropertyFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

 @Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    //AQUI É A INJEÇÃO DE DEPEDENCIA, É PADRÃO FAZER POR CONSTRUTOR E NÃO PELO @DATA
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //LISTAR TODOS OS NINJA
    public List<NinjaModel> listarNinjas(){
    return  ninjaRepository.findAll();
    }

    //LISTAR NINJAS POR ID
    public NinjaModel listarNinjasPorId(Long id){
        //USO O OPTIONAL PQ PODE OU NÃO HAVER UM NINJA COM AQUELE ID
        Optional<NinjaModel> ninjaPorId= ninjaRepository.findById(id);

        //.orElse = Vai returnar um ninja por ID, se não tiver retorna null;
        return ninjaPorId.orElse(null);

    }

    //CRIAR UM NOVO NINJA
     //AO INVES DO METÓDO SER, LONG ID, STRING NOME, STRING EMAIL E ETC, PASSO LOGO TUDO O QUE TEM NO
     //NinjaModel para o usuário preencher
     public NinjaModel criarNinja(NinjaModel ninja){
        //O QUE O JPA ESTÁ FAZENDO AQUI É A QUERY NO BANCO DE DADOS ASSIM:
         //VALUES (ID,'nome','email'...) ATRAVÉS DO ninja QUE O USUÁRIO PASSOU
        return ninjaRepository.save(ninja);

     }

     //DELETAR UM NINJA - tem que ser um método VOID
     public void deletarNinjaPorID(Long ID){
       ninjaRepository.deleteById(ID);
     }

     //ATUALIZAR NINJA
     public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;

     }



}
