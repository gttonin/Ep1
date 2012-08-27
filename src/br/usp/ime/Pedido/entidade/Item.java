package br.usp.ime.Pedido.entidade;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Generated;

@Entity
public class Item  {
	@Id @GeneratedValue
	private int id;
	private String descricao;
	private int qtd;
	private double valorUnitario;
	private double valorItem;
	
	public double getValorItem() {
		return valorItem;
	}


	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public double getvalorItem (){
		return qtd*valorUnitario;
	}
	

	public Item (int id, String descricao, int qtd, double valorUnitario){
		this.setId(id);
		this.setDescricao(descricao);
		this.setQtd(qtd);
		this.setValorUnitario(valorUnitario);
	}
}
