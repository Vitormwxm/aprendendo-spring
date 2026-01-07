package com.vitormwxm.aprendendospring.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id gerado automaticamente pelo nosso código
    private Long id;
    @Column(name = "rua", length = 100) // essa anotação nos diz qual o nome da nossa coluna e outras informações que podemos colocar aqui
    private  String rua;
    @Column(name = "numero")
    private  Long numero;
    @Column(name = "complemento", length = 10)
    private  String complemento;
    @Column(name = "cidade", length = 100)
    private  String cidade;
    @Column(name = "estado", length = 2)
    private  String estado;
    @Column(name = "cep", length = 9)
    private  String cep;

}
