package com.example.servidorback.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private String descricao;
    private String categoria;
    private double preco;
    private boolean disponibilidade;

    @Column(columnDefinition = "TEXT")
    private String imagem;

}
