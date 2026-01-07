package com.vitormwxm.aprendendospring.infraestructure.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private  String nome;
    private  String email;
    private  String senha;
}
