package com.br.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.exception.ResourceNotFoundException;
import com.br.model.Automovel;
import com.br.repository.AutomovelRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cautomovel/")
@RestController
public class AutomovelController {

	//Cria o repositorio JPA para ser usado pelo controlador
	@Autowired
	private AutomovelRepository aRep;
	
	//Listar
	@GetMapping("/automovel")
	public List<Automovel> listar(){
		return this.aRep.findAll();
	}

	//Consultar
	@GetMapping("/automovel/{id}")
	public ResponseEntity<Automovel> consultar(@PathVariable Long id){
		
		Automovel automovel = this.aRep.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Automovel não encontrado: " + id));
		
		return ResponseEntity.ok(automovel);
	}
	
	
	//Inserir
	@PostMapping("/automovel")
	public Automovel inserir(@RequestBody Automovel automovel) {
		
		return aRep.save(automovel);
		
	}
	
	//Alterar
	@PutMapping("/automovel/{id}")
	public ResponseEntity<Automovel> alterar(@PathVariable Long id, @RequestBody Automovel automovel){
		
		Automovel auto = this.aRep.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Automovel não encontrado: " + id));
		
		auto.setCodigo(automovel.getCodigo());
		auto.setNome(automovel.getNome());
		auto.setModelo(automovel.getModelo());
		auto.setDataFabricacao(automovel.getDataFabricacao());
		auto.setQuantidade(automovel.getQuantidade());
		auto.setPrecoVenda(automovel.getPrecoVenda());
		auto.setTrioEletrico(automovel.isTrioEletrico());
		auto.setMarca(automovel.getMarca());
		
		Automovel atualizado = aRep.save(auto);
		
		return ResponseEntity.ok(atualizado);
		
		
	}
	
	
	//Excluir
	@DeleteMapping("/automovel/{id}")
	public ResponseEntity<Map<String,Boolean>> excluir(@PathVariable Long id){
		
		Automovel automovel = this.aRep.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Automovel não encontrado: " + id));
		
		aRep.delete(automovel);
		
		Map<String,Boolean> resposta = new HashMap<>();
		resposta.put("Automovel excluído!", Boolean.TRUE);
		return ResponseEntity.ok(resposta);
		
		
	}
}
