package com.gestao.gestao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.gestao.DTO.VendaDTO;
import com.gestao.gestao.model.Venda;
import com.gestao.gestao.repository.IVenda;
import com.gestao.gestao.service.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private IVenda vendaRepository;
	
	@PostMapping
	public ResponseEntity<Venda> CriarVenda(@RequestBody VendaDTO vendaDTO){
		Venda venda = vendaService.EfetuaVenda(vendaDTO.getProduto_id(), vendaDTO.getQuantidade());
		return ResponseEntity.ok(venda);
	}
	
	@RequestMapping(value = "/visualizarvendas")
	public List<Venda> ListarVendas(){
		return (List <Venda>) vendaRepository.findAll();
	}
}
