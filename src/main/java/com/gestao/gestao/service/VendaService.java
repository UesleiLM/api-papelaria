package com.gestao.gestao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao.gestao.model.Produto;
import com.gestao.gestao.model.Venda;
import com.gestao.gestao.repository.IProduto;
import com.gestao.gestao.repository.IVenda;

@Service
public class VendaService {
	
	@Autowired
	private IVenda vendaRepository;
	
	@Autowired
	private IProduto produtoRepository;
	
	public Venda EfetuaVenda(Integer produto_id, int quantidade) {
		Produto produto = produtoRepository.findById(produto_id)
				
		.orElseThrow(() -> new RuntimeException("produto não encontrado!"));
		Venda venda = new Venda();
		venda.setProduto(produto);
		venda.setQuantidade(quantidade);
		venda.setTotal(produto.getValor() * quantidade);
		return vendaRepository.save(venda);
	}
}
