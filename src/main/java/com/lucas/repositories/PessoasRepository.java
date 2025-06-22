package com.lucas.repositories;

import com.lucas.entities.PessoasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoasRepository extends JpaRepository<PessoasEntity, Long> {

     Optional<PessoasEntity> findById(Long id);
     boolean existsById(Long id);
     boolean existsByCpf(String cpf);
     boolean existsByEmail(String email);
     void deleteById(Long id);
     void save(Long id);
}
