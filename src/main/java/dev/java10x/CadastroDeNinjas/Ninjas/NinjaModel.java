package dev.java10x.CadastroDeNinjas.Ninjas;


import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

@Entity /*Transforma a CLASSE em uma ENTIDADE do Banco de Dados*/
@Table(name="tb_cadastro")

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;

    @ManyToOne /*UM NINJA TEM UMA ÚNICA MISSÃO, MANY NINJAS TEM ONE MISSION*/
    @JoinColumn(name="missoes_id") //Foreing Key ou Chave Estrangeira
    private MissoesModel missoes;


    public NinjaModel(String nome) {
        this.nome = nome;
    }

    public NinjaModel(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
