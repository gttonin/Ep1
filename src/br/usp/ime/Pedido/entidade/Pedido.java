package br.usp.ime.Pedido.entidade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import br.usp.ime.academicdevoir.entidade.ListaQuestao;
import br.usp.ime.academicdevoir.entidade.Questao;

import com.google.common.collect.Lists;

@Entity
public class Pedido {
	
	
	@Id @GeneratedValue
	private int id;
	
	private ArrayList<Item> itens= new ArrayList();
	
	@Temporal (TemporalType.DATE)
	
	private Date date = new Date();
	
	private double ValorTotal;
	
	
	public void CalculaValorTotal () {
		
			
		for (int i=0; i==itens.size(); i++ ) {
			itens.get(i);
			
			Item.getvalorItem();
			
			
			
			
			
			
			
			

			
			
		}
		
		
	}
	
	
	@OneToMany (mappedBy = "pedido")
	private Collection<Cliente> cliente;
	
	
	@OneToMany (mappedBy = "pedido")
	private Collection<Item> item;
	
	
	//private Collection<Item> item= new ArrayList<Item>();
	
	
	/*public List<Item> getItem() {
		List<Item> item = new ArrayList<Item>();
		for (ListaItem listaItem : listaItem) {
			item.add(listaItem.getItem());
		}
		return item;
	}*/
	
	public Collection<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(Collection<Cliente> cliente) {
		this.cliente = cliente;
	}	

	public Collection<Item> getItem() {
		return item;
	}

	public void setItem(Collection<Item> item) {
		this.item = item;
	}
	
	
	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getValorTotal() {
		return ValorTotal;
	}


	public void setValorTotal(double valorTotal) {
		ValorTotal = valorTotal;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<Item> getItens() {
		return itens;
	
	}


	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

    
 
}	
	
	
	
	
	
