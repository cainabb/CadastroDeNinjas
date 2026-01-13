package dev.java10x.CadastroDeNinjas.Ninjas;


import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity /*Transforma a CLASSE em uma ENTIDADE do Banco de Dados*/
@Table(name="tb_cadastro")
@AllArgsConstructor
@NoArgsConstructor
@Data //LOMBOK CRIA OS GETTERS E OS SETTERS
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nome_ninja")
    private String nome;
    @Column(name="idade_ninja")
    private int idade;
    @Column(unique = true)//CADA EMAIL TEM QUE SER ÚNICO, NÃO PODE TER 2 IGUAIS
    private String email;

    @ManyToOne /*UM NINJA TEM UMA ÚNICA MISSÃO, MANY NINJAS TEM ONE MISSION*/
    @JoinColumn(name="missoes_id") //Foreing Key ou Chave Estrangeira
    private MissoesModel missoes;

}
