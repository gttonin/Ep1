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
import org.springframework.transaction.*;

import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.Pedido.entidade.Cliente;

@Component
 	
public class ClienteDao {
	private static Session sessao;

    private static Transaction transacao;
	
	@SuppressWarnings("unchecked")
	
	
	public void salvaCliente(Cliente cliente) {
		   	        
	    Transaction transacao = sessao.beginTransaction();
	    sessao.save(cliente);
		transacao.commit();
	}
	public void removeCliente(Cliente cliente) {
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(cliente);
		transacao.commit();
	}
	
	public void atualizaCliente(Cliente cliente) {
		Transaction transacao = sessao.beginTransaction();
		sessao.update(cliente);
		transacao.commit();
	}
	
		
}
