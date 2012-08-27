package br.usp.ime.Pedido.entidade;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Entity;
@Entity
public class Cliente {
	
	@Id @GeneratedValue 	
	private Long idcli;
	
	private String Nome;
	
	
	
	public Long getIdcli() {
		return idcli;
	}
	public void setIdcli(Long idcli) {
		this.idcli = idcli;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}

	
	
	
}
