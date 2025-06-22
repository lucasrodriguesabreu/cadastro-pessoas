package com.lucas.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "tb_pessoas")
public class PessoasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "nome", nullable = false)
    public String nome;

    @Column(name = "email", nullable = false)
    public String email;

    @Column(name = "telefone", nullable = false)
    public String telefone;

    @Column(name = "cpf", nullable = false, unique = true)
    public String cpf;
}
