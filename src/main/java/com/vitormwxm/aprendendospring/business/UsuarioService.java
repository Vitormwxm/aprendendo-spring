package com.vitormwxm.aprendendospring.business;

import com.vitormwxm.aprendendospring.infraestructure.entities.Usuario;
import com.vitormwxm.aprendendospring.infraestructure.exceptions.ConflictException;
import com.vitormwxm.aprendendospring.infraestructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service // indicamos para o spring que estamos utilizando uma service
@RequiredArgsConstructor // fazemos a injeção de dependência por meio de um construtor, e o Required vai fazer um construtor com bases nos campos declarados
public class UsuarioService {

    // @Autowired  // fazemos a injeção de dependência, ou seja podemos utilizar os métodos de UsuarioRepository dentro da nossa service
    // quando não usamos o Autowired, precisamos utilizar o private final para a injeção de dependências
    // final declara que esse campo é imutável
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario salvaUsuario(Usuario usuario) {

        try {
            emailExiste(usuario.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

            return usuarioRepository.save(usuario); // salva usuário
        } catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado" + e.getCause());
        }

    }

    public void emailExiste(String email) {
        try {

            boolean existe = verificaEmailExistente(email);

            if (existe) {
                throw new ConflictException("Email já cadastrado " + email);
            }
        } catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado" + e.getCause());
        }
    }

    public boolean verificaEmailExistente(String email) {
        return usuarioRepository.existsByEmail(email);
    }



}
