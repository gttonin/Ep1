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
import br.usp.ime.Pedido.entidade.Pedido;

@Component
 	
public class PedidoDao {
	private static Session sessao;
	private Transaction transacao;
		
	
	@SuppressWarnings("unchecked")
	public void salvaPedido(Pedido pedido) {
		   	        
	    Transaction transacao = sessao.beginTransaction();
	    sessao.save(pedido);
		transacao.commit();
	}
	public void removePedido(Pedido pedido) {
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(pedido);
		transacao.commit();
	}
	
	public void atualizaPedido(Pedido pedido) {
		Transaction transacao = sessao.beginTransaction();
		sessao.update(pedido);
		transacao.commit();
	}
	
		
}

