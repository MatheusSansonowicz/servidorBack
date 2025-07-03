package com.example.servidorback.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProdutoNoCarrinho {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;
    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private int quantidade;
    private double precoGeral;

    public ProdutoNoCarrinho(Carrinho carrinho,Produto produto, int quantidade) {
        this.carrinho = carrinho;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoGeral = produto.getPreco()*quantidade;
    }

    public ProdutoNoCarrinho() {

    }
}
