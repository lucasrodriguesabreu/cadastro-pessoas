package com.lucas.services;

import com.lucas.entities.PessoasEntity;
import com.lucas.repositories.PessoasRepository;
import com.lucas.validators.PessoasValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoasService {

    private final PessoasRepository repository;
    private final PessoasValidator validator;

    public PessoasEntity save(PessoasEntity pessoasEntity) {
        validator.validate(pessoasEntity);

        PessoasEntity pessoa = new PessoasEntity();
        pessoa.setNome(pessoasEntity.getNome());
        pessoa.setEmail(pessoasEntity.getEmail());
        pessoa.setTelefone(pessoasEntity.getTelefone());
        pessoa.setCpf(pessoasEntity.getCpf());

        repository.save(pessoasEntity);
        return pessoasEntity;
    }
}
