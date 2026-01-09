package com.vitormwxm.aprendendospring.business;

import com.vitormwxm.aprendendospring.infraestructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // indicamos para o spring que estamos utilizando uma service
@RequiredArgsConstructor // fazemos a injeção de dependência por meio de um construtor, e o Required vai fazer um construtor com bases nos campos declarados
public class UsuarioService {

    // @Autowired  // fazemos a injeção de dependência, ou seja podemos utilizar os métodos de UsuarioRepository dentro da nossa service
    // quando não usamos o Autowired, precisamos utilizar o private final para a injeção de dependências
    // final declara que esse campo é imutável
    private final UsuarioRepository usuarioRepository;

}
