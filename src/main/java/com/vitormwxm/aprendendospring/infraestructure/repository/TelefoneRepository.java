package com.vitormwxm.aprendendospring.infraestructure.repository;

import com.vitormwxm.aprendendospring.infraestructure.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
