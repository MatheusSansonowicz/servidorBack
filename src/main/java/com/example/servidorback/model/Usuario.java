package com.example.servidorback.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String nome;
    private boolean admin;

    @Column(unique = true)
    private String senha;

    @OneToMany(mappedBy = "pedinte")
    private List<Carrinho> carrinhos;
}