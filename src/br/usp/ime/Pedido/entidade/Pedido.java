package br.usp.ime.Pedido.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;


@Entity
public class Pedido {
	
	
	@Id @GeneratedValue	
	@Column(name = "id")
	private int id;
	
	private String cliente;
	
	@Temporal (TemporalType.DATE)	
	private Date date = new Date();
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
	//@Cascade(CascadeType.ALL)
	private List<Item> itens;
	
	
	
	

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}


	//private Collection<Item> item= new ArrayList<Item>();
	
	
	/*public List<Item> getItem() {
		List<Item> item = new ArrayList<Item>();
		for (ListaItem listaItem : listaItem) {
			item.add(listaItem.getItem());
		}
		return item;
	}
	
	@OneToMany (mappedBy = "pedido")
	private Collection<Cliente> cliente;
	
	
	@OneToMany (mappedBy = "pedido")
	private Collection<Item> item;
	
	*/
	

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public BigDecimal calculaValorTotal() {
		BigDecimal valorTotal = new BigDecimal(0);

		for (Item i : itens) {
			valorTotal = valorTotal.add(i.getValorUnitario().multiply(new BigDecimal(i.getQtd())));
		}

		return valorTotal;

	}

	public Pedido() {
		itens = new ArrayList<Item>();
	}
	

	public void addItem(Item i) {
		itens.add(i);
	}
 
}	
	
	
	
	
	
