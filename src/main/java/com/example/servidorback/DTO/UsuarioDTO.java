package com.example.servidorback.DTO;

import com.example.servidorback.model.Usuario;

public record UsuarioDTO(
        long id,
        String nome,
        boolean admin
) {
    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}
