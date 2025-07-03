package com.example.servidorback.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Carrinho {

    @Id
    private Long id;

    @ManyToOne
    private Usuario pedinte;
    @OneToMany(mappedBy = "carrinho",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoNoCarrinho> produtosNoCarrinho;

    private double precoFinal;

    private Date dataCompra;

    public Carrinho(Usuario pedinte, List<ProdutoNoCarrinho> produtosNoCarrinho, Date dataCompra) {
        this.pedinte = pedinte;
        this.dataCompra = dataCompra;
        this.produtosNoCarrinho = produtosNoCarrinho;
        for (ProdutoNoCarrinho p : produtosNoCarrinho) {
            this.precoFinal += p.getPrecoGeral();
        }
    }

    public Carrinho() {
    }
}

