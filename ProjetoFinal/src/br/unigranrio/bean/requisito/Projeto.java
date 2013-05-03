package br.unigranrio.bean.requisito;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projeto")
public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	
	public Projeto() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length=50)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
