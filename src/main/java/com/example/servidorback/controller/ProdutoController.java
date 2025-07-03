package com.example.servidorback.controller;

import com.example.servidorback.DTO.ProdutoDTO;
import com.example.servidorback.model.Produto;
import com.example.servidorback.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private final ProdutoRepository produtoRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public ProdutoController(ProdutoRepository produtoRepository,
                             ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping ("/novo")
    public Produto criar(@RequestBody ProdutoDTO npDTO) {
        Produto produto = modelMapper.map(npDTO, Produto.class);
        return produtoRepository.save(produto);
    }

    @GetMapping("/listartudo")
    public ResponseEntity<List<Produto>> listarTodosAdm() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @GetMapping("/procurarPorNome/{nome}")
    public ResponseEntity<Produto> procurarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(produtoRepository.findByNome(nome));
    }

    @PutMapping("/editar/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<ProdutoDTO> produtoSelecionado(@PathVariable String nome) {
        ProdutoDTO produtoDTO = converterParaDTO(produtoRepository.findByNome(nome));
        return ResponseEntity.ok(produtoDTO);

    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }

    @GetMapping
    public List<Produto> mostrarTodos() {
        return produtoRepository.findByDisponibilidadeTrue();
    }

    private ProdutoDTO converterParaDTO(Produto produto) {
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    private Produto converterParaProduto(ProdutoDTO produtoDTO) {
        return modelMapper.map(produtoDTO, Produto.class);
    }

}
