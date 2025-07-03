package com.example.servidorback.repository;

import com.example.servidorback.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByDisponibilidadeTrue();

    Produto findByNome(String nome);

}