package com.example.servidorback.DTO;

import com.example.servidorback.model.ProdutoNoCarrinho;

import java.util.List;

public record CarrinhoDTO(
        Long id,
        List<ProdutoNoCarrinhoDTO> produtos,
        double precoFinal,
        UsuarioDTO pedinte
) {
}
