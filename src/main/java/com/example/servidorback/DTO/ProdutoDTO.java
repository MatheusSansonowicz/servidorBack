package com.example.servidorback.DTO;

import com.example.servidorback.model.Produto;
import jakarta.persistence.Column;

public record ProdutoDTO(String nome,
        String descricao,
        String categoria,
        double preco,
        boolean disponibilidade,
        String imagem
) {


}
