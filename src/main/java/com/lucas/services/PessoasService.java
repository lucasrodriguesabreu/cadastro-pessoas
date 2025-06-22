package com.lucas.services;

import com.lucas.entities.PessoasEntity;
import com.lucas.exceptions.CpfException;
import com.lucas.exceptions.EmailException;
import com.lucas.repositories.PessoasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoasService {

    private final PessoasRepository repository;

    public PessoasEntity save(PessoasEntity pessoasEntity) {
        if (pessoasEntity.getId() != null && repository.existsById(pessoasEntity.getId())) {
            throw new IllegalArgumentException("Essa pessoa já existe.");
        }

        if (repository.existsByCpf(pessoasEntity.getCpf())) {
            throw new CpfException("CPF já cadastrado.");
        }

        if(repository.existsByEmail(pessoasEntity.getEmail())) {
            throw new EmailException("Email já cadastrado.");
        }

        PessoasEntity pessoa = new PessoasEntity();
        pessoa.setNome(pessoasEntity.getNome());
        pessoa.setEmail(pessoasEntity.getEmail());
        pessoa.setTelefone(pessoasEntity.getTelefone());
        pessoa.setCpf(pessoasEntity.getCpf());

        repository.save(pessoasEntity);
        return pessoasEntity;
    }
}
