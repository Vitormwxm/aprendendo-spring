package com.vitormwxm.aprendendospring.infraestructure.repository;

import com.vitormwxm.aprendendospring.infraestructure.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndereRepository extends JpaRepository<Endereco, Long> {
}
