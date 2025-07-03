package com.example.servidorback.DTO;

import com.example.servidorback.model.Carrinho;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.List;

public record UsuarioDTO(
        long id,
        String nome,
        boolean admin,
        String senha
) {
}
