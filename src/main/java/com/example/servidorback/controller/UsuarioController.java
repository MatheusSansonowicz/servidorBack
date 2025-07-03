package com.example.servidorback.controller;


import com.example.servidorback.DTO.UsuarioDTO;
import com.example.servidorback.DTO.UsuarioLoginDTO;
import com.example.servidorback.model.Usuario;
import com.example.servidorback.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public UsuarioController(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registrarUsuario")
    public Usuario novoUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO loginDTO) {
        Optional<Usuario> usuarioBuscado =
                usuarioRepository.findByNome(loginDTO.getNome());

        if (usuarioBuscado.isPresent()) {
            Usuario usuario = usuarioBuscado.get();
            if (usuario.getSenha().equals(loginDTO.senha()))
                return ResponseEntity.ok(modelMapper.map(usuario,
                        UsuarioDTO.class));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Credenciais inválidas");
    }

}
