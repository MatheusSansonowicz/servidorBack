package com.example.servidorback.DTO;

public record ProdutoAdmDTO(Long id,
                            String nome,
                            String descricao,
                            String categoria,
                            double preco,
                            boolean disponibilidade,
                            String imagem) {
}
