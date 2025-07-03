package com.example.servidorback.DTO;

import com.example.servidorback.model.Produto;

public record ProdutoNoCarrinhoDTO(
        Long id,
        Produto produto,
        int quantidade,
        double precoGeral
) {
}
