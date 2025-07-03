package com.example.servidorback.controller;


import com.example.servidorback.DTO.CarrinhoDTO;
import com.example.servidorback.DTO.ProdutoDTO;
import com.example.servidorback.model.Carrinho;
import com.example.servidorback.model.ProdutoNoCarrinho;
import com.example.servidorback.repository.CarrinhoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
@CrossOrigin(origins = "*")
public class CarrinhoController {

    @Autowired
    private final CarrinhoRepository carrinhoRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public CarrinhoController(CarrinhoRepository carrinhoRepository, ModelMapper modelMapper) {
        this.carrinhoRepository = carrinhoRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public Carrinho criar(@RequestBody CarrinhoDTO carrinhoDTO) {
        Carrinho carrinho = modelMapper.map(carrinhoDTO, Carrinho.class);
        return carrinhoRepository.save(carrinho);
    }

    @GetMapping("/comprasFeitas")
    public List<Carrinho> comprasFeitas() {
        return carrinhoRepository.findAll();
    }

    @DeleteMapping("/cancelarCompra")
    public void cancelarCompra(@RequestParam Long id) {
        carrinhoRepository.deleteById(id);
    }

    @PutMapping("/alterarCarrinho")
    public Carrinho atualizar(@RequestBody CarrinhoDTO carrinhoDTO, @RequestParam Long id) {
        Carrinho carrinho = modelMapper.map(carrinhoDTO, Carrinho.class);
        carrinho.setId(id);
        return carrinhoRepository.save(carrinho);
    }

}
