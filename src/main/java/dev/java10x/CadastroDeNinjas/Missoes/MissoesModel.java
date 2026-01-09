package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaController;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Table (name= "tb_missoes")
@NoArgsConstructor //LOMBOK CRIAR UM NO ARGS CONSTRUCTOR
@AllArgsConstructor //LOMBOK CRIA UM ALLARGS CONSTRUCTOR
@Data //LOMBOK CRIA GETTERS E SETTERS


public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String dificuldade;

    @OneToMany (mappedBy = "missoes") //ONE MISSÕES PARA MANY NINJAS
    private List<NinjaModel> ninjas;





}
