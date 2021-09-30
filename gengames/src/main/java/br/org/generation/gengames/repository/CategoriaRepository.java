package br.org.generation.gengames.repository;

import br.org.generation.gengames.model.Categoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //É utilizado para informar que essa classe é um repositório.
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Categoria> findAllByNomeContainingIgnoreCase (String nome);
	
	public List<Categoria> findAllByDescricaoContainingIgnoreCase (String descricao);
}
