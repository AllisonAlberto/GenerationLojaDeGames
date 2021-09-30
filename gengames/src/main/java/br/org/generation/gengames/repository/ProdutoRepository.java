package br.org.generation.gengames.repository;

import br.org.generation.gengames.model.Produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findAllByNomeContainingIgnoreCase (String nome);
	
	public List<Produto> findAllByDescricaoContainingIgnoreCase (String descricao);
	
	public List<Produto> findAllByPreco (float preco);
	
	public List<Produto> findAllByQtde (int qtde);

}
