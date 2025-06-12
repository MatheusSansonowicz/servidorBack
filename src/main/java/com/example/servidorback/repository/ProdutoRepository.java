package com.example.servidorback.repository;

import com.example.servidorback.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Override
    <S extends Produto> S save(S entity);
}