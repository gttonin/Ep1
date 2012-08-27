package br.usp.ime.Pedido.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.usp.ime.Pedido.dao.PedidoDao;
import br.usp.ime.Pedido.entidade.Pedido;


@Resource
public class PedidoController {

		private Result result;
		private Pedido pedido;
		private PedidoDao   dao;
		

		public PedidoController(Result result) {
			this.result = result;
		}

		public void cadastra(Pedido p, String[] nome, String[] qtd, String[] valorUnitario)
		{

			dao = new PedidoDao();
			dao.salva(p, nome, qtd, valorUnitario);

			result.include("total", p.calculaValorTotal());
			result.include("pedido", p);
			result.redirectTo(this).listaPedidoCliente();

		}

		public List<Pedido> lista() {
		return	new PedidoDao().listar();
		}

		
		public void listaPedidoCliente() {

		}

		public Result getResult() {
			return result;
		}

		public void setResult(Result result) {
			this.result = result;
		}

		public Pedido getPedido() {
			return pedido;
		}

		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}

	}

