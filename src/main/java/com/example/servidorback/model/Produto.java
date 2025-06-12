package com.example.servidorback.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;
    private boolean disponibilidade;

    @Column(columnDefinition = "TEXT")
    private String imagem;
}
