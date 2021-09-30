package br.org.generation.gengames.controller;

import br.org.generation.gengames.model.Categoria;
import br.org.generation.gengames.repository.CategoriaRepository;

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

@RestController //É utilizada para informar que essa classe é um controller.
@RequestMapping("/categorias") //É utilizada para informar a URL.
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriasController {
	
	@Autowired //É utilizado para Injeção de dependência
	private CategoriaRepository categoriasRepository;
	
	@GetMapping //É utilizado para chamar o metodo getAll quando obtiver uma GET pela URL "/categorias"
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(categoriasRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById (@PathVariable long id){ //É utilizado para o metodo capturar o valor que vem pela URL
		return categoriasRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> getByNome (@PathVariable String nome){
		return ResponseEntity.ok(categoriasRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> getByDescricao (@PathVariable String descricao){
		return ResponseEntity.ok(categoriasRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria){ //É utilizado para pegar o que vem no corpo da requisição
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriasRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(categoriasRepository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		categoriasRepository.deleteById(id);
	}
	
}
