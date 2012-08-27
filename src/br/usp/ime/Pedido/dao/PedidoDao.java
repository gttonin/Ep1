package br.usp.ime.Pedido.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.criterion.Order;

import java.math.BigDecimal;
import java.util.List;

import br.usp.ime.Pedido.dao.*;
import br.usp.ime.Pedido.entidade.*;



import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.Pedido.entidade.Item;
import br.usp.ime.Pedido.entidade.Pedido;

@Component
 	
public class PedidoDao {
	private static Session sessao;
	private Transaction transacao;
		
	
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
	
	
	@SuppressWarnings("unchecked")
	public void salva(Pedido p, String[] descricao, String[] qtd, String[] valorUnitario) {
			for (int i = 0; i < descricao.length; i++) {
				Item item = new Item();
				item.setDescricao(descricao[i]);
				item.setQtd(Integer.parseInt(qtd[i]));
				String valor = valorUnitario[i];
				valor = valor.replaceAll("\\.", "");
				valor = valor.replaceAll(",", "\\.");
				System.out.println(valor);
				item.setValorUnitario(new BigDecimal(valor));
				item.setPedido(p);
				p.addItem(item);
			}
			
			new PedidoDao();
			salva(p, descricao, qtd, valorUnitario);
		}

		public List<Pedido> listar() {
			return new PedidoDao().listar();
		}
}

