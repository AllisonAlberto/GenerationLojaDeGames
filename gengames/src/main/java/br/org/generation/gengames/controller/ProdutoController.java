package br.org.generation.gengames.controller;

import br.org.generation.gengames.model.Produto;
import br.org.generation.gengames.repository.ProdutoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable long id){
		return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Produto>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(produtoRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@GetMapping("/preco/{preco}")
	public ResponseEntity<List<Produto>> getByDescricao(@PathVariable float preco){
		return ResponseEntity.ok(produtoRepository.findAllByPreco(preco));
	}
	
	@GetMapping("/qtde/{qtde}")
	public ResponseEntity<List<Produto>> getByDescricao(@PathVariable int qtde){
		return ResponseEntity.ok(produtoRepository.findAllByQtde(qtde));
	}
	
	@PostMapping
	public ResponseEntity<Produto> post (@RequestBody Produto produtos){
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produtos));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put (@RequestBody Produto produtos){
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produtos));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		produtoRepository.deleteById(id);
	}
	
}
