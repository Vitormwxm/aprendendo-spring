package com.vitormwxm.aprendendospring.infraestructure.repository;


import com.vitormwxm.aprendendospring.infraestructure.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// todas as entidades tem que ter um repository
// Sempre uma interface
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email); // verifica se o email do usuário existe no banco de dados

    Optional<Usuario> findByEmail(String email);
}
