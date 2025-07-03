package com.example.servidorback.DTO;

public record UsuarioNovoDTO(
        long id,
        String nome,
        boolean admin,
        String senha
) {
}
