package com.vitormwxm.aprendendospring.infraestructure.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // aponta para o spring que isso é uma tabela no banco de dados
@Table (name = "usuario") // se não passar o nome da tabela ele utiliza o nome da classe
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id gerado automaticamente pelo nosso código
    private Long id;
    @Column(name = "nome", length = 100) // essa anotação nos diz qual o nome da nossa coluna e outras informações que podemos colocar aqui
    private  String nome;
    @Column(name = "email", length = 100)
    private  String email;
    @Column(name = "senha", length = 100)
    private  String senha;

    // Anotação para uma relação 1 para muitos
    @OneToMany(cascade = CascadeType.ALL) // quando excluir um usuário os dados serão removidos das duas tabelas
    @JoinColumn(name = "usuario_id", referencedColumnName = "id") // faz um join usando a coluna usuario_id de endereço
    private List<Endereco> enderecos;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
