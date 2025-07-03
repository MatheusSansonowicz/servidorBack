package com.example.servidorback.controller;


import com.example.servidorback.DTO.UsuarioDTO;
import com.example.servidorback.DTO.UsuarioLoginDTO;
import com.example.servidorback.DTO.UsuarioNovoDTO;
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
    public Usuario novoUsuario(@RequestBody UsuarioNovoDTO usuarioDTO) {
        Usuario usuario = this.convertPModel(usuarioDTO);
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO loginDTO) {
        Optional<Usuario> usuarioBuscado =
                usuarioRepository.findByNome(loginDTO.nome());

        if (usuarioBuscado.isPresent()) {
            Usuario usuario = usuarioBuscado.get();
            if (usuario.getSenha().equals(loginDTO.senha())) {
                UsuarioDTO usuarioDTO = this.convertPDTO(usuario);
                return ResponseEntity.ok(usuarioDTO);
            }

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Credenciais inválidas");
    }

    private Usuario convertPModel(UsuarioNovoDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setSenha(usuarioDTO.senha());
        usuario.setNome(usuarioDTO.nome());
        usuario.setAdmin(usuarioDTO.admin());
        return usuario;
    }

    private UsuarioDTO convertPDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.isAdmin());
        return usuarioDTO;
    }

}
