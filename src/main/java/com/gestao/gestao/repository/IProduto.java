package com.gestao.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.gestao.gestao.model.Produto;

public interface IProduto extends JpaRepository<Produto, Integer>{
}
