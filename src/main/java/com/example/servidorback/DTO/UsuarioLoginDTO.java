package com.example.servidorback.DTO;

public record UsuarioLoginDTO(
        String nome,
        String senha
) {
    public String getNome() {
        return null;
    }
}
