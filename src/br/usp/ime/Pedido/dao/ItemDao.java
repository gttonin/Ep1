package br.usp.ime.Pedido.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.criterion.Order;


import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.Pedido.entidade.Item;

@Component
 
	
public class ItemDao {
	private static Session sessao;
	private Transaction transacao;
		
	
	@SuppressWarnings("unchecked")
	public void salvaCliente(Item item) {
		   	        
	    Transaction transacao = sessao.beginTransaction();
	    sessao.save(item);
		transacao.commit();
	}
	public void removeCliente(Item item) {
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(item);
		transacao.commit();
	}
	
	public void atualizaCliente(Item item) {
		Transaction transacao = sessao.beginTransaction();
		sessao.update(item);
		transacao.commit();
	}
	
		
}
