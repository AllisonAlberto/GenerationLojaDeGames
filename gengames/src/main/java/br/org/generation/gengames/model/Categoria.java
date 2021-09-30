package br.org.generation.gengames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //É utilizada para informa que a classe também é uma entidade do bd.
@Table(name = "tb_categoria") //É utilizada para nomear a tabela.
public class Categoria {
	
	@Id //É utilizado para indicar que esse atributo é uma PK.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //É utilizado para informar como serão gerados os valores da PK.
	private long id;
	
	@NotNull(message = "O atributo nome é obrgatório!")
	@Size(min = 3, max = 50, message = "O atributo nome deverá ter no minimo três caracteres e no máximo cinquenta!")
	private String nome;
	
	@NotNull(message = "O atributo descrição é obrgatório!")
	@Size(min = 10, max = 510, message = "O atributo descrição deverá ter no minimo dez caracteres e no máximo quinhetos e dez!")
	private String descricao;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) //É utilizado para informar o tipo de relação entre as tabelas.
	@JsonIgnoreProperties("categoria") //É utilizado para evitar looping.
	private List<Produto> produto;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
}
