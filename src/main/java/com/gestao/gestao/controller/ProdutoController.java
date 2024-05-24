package com.gestao.gestao.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.gestao.model.Produto;
import com.gestao.gestao.repository.IProduto;

@RestController

public class ProdutoController {
	
	@Autowired
	private IProduto produtoRepository;

	@RequestMapping(value = "/")
	public String mensagem() {
		return "quer tc?";
	}
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public List<Produto> ListarProdutos(){
		return (List<Produto>) produtoRepository.findAll();
	}
	
	@RequestMapping(value = "/cadastroproduto", method = RequestMethod.POST)
	public Produto CadastraProduto(@RequestBody Produto produto) {
		Produto novoProduto = produtoRepository.save(produto); 
		return novoProduto;
	}
}
