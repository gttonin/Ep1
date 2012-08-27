package br.usp.ime.Pedido.entidade;

import java.math.BigDecimal;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Generated;

@Entity
public class Item  {
	@Id @GeneratedValue
	private int id;
	
	private String descricao;
	private int qtd;
	private BigDecimal valorUnitario;
	protected BigDecimal valorItem;
	private Pedido pedido;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pedido", updatable = true, insertable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)

	
	public BigDecimal getValorItem() {
		return valorItem;
	}


	public void setValorItem(BigDecimal valorItem) {
		this.valorItem = valorItem;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

		

	public Item() {
		super();
		// TODO Auto-generated constructor stub
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

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	
	public BigDecimal getvalorItem() {
		BigDecimal valor = new BigDecimal(0);

		 	valorItem = valorItem.add(getValorUnitario().multiply(new BigDecimal(getQtd())));
		
		return valorItem;
	}
	
	
	public Item (int id, String descricao, int qtd, BigDecimal valorUnitario){
		this.setId(id);
		this.setDescricao(descricao);
		this.setQtd(qtd);
		this.setValorUnitario(valorUnitario);
	}
}
