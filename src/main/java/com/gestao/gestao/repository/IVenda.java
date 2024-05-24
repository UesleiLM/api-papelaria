package com.gestao.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.gestao.gestao.model.Venda;

public interface IVenda extends JpaRepository<Venda, Integer>{
	
	
}
