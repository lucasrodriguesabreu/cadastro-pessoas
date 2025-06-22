package com.lucas.controllers;

import com.lucas.entities.PessoasEntity;
import com.lucas.services.PessoasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class PessoasController {

    private final PessoasService service;


    @PostMapping(value = "/cadastro/pessoa")
    public ResponseEntity<PessoasEntity> createPessoa(@RequestBody PessoasEntity pessoasEntity) {
        PessoasEntity saved = service.save(pessoasEntity);
//        service.save(pessoasEntity);
        return ResponseEntity.status(200).body(saved);
//        return ResponseEntity.ok().build();
    }
}
