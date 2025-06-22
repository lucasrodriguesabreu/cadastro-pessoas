package com.lucas.validators;

import com.lucas.entities.PessoasEntity;
import com.lucas.exceptions.CpfException;
import com.lucas.exceptions.EmailException;
import com.lucas.repositories.PessoasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoasValidator {

    private final PessoasRepository repository;

    public void validate(PessoasEntity pessoasEntity) {
        if (pessoasEntity.getId() != null && repository.existsById(pessoasEntity.getId())) {
            throw new IllegalArgumentException("Essa pessoa já existe.");
        }
        if (repository.existsByCpf(pessoasEntity.getCpf())) {
            throw new CpfException("CPF já cadastrado.");
        }
        if (repository.existsByEmail(pessoasEntity.getEmail())) {
            throw new EmailException("Email já cadastrado.");
        }
    }
}
