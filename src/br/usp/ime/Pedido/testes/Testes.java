package br.usp.ime.Pedido.testes;

import java.math.BigDecimal;

import junit.framework.Assert;


import org.junit.Before;
import org.junit.Test;

import br.usp.ime.Pedido.entidade.Item;
import br.usp.ime.Pedido.entidade.Pedido;

public class Testes {
	
		Pedido p;

		@Before
		public void inicia() {
			p = new Pedido();
		}
		
		@Test
		public void listaVazia() {
			Item i = new Item();
			i.setDescricao("");
			i.setQtd(0);
			i.setValorUnitario(new BigDecimal(00.00));
			p.setCliente("");
			Assert.assertEquals(new BigDecimal(0.00), p.calculaValorTotal());

		}
		

		@Test
		public void listaComApenasUmItem (){
			Item i = new Item();
			i.setDescricao("Cd");
			i.setQtd(1);
			i.setValorUnitario(new BigDecimal(30.00));

			p.setCliente("Joao");
			p.addItem(i);
			Assert.assertEquals(new BigDecimal(40.00), p.calculaValorTotal());

		}

		
		@Test
		public void listaComApenasUmItemEQtdMaior (){
			Item i = new Item();
			i.setDescricao("Cd");
			i.setQtd(2);
			i.setValorUnitario(new BigDecimal(30.00));

			p.setCliente("Joao");
			p.addItem(i);
			Assert.assertEquals(new BigDecimal(40.00), p.calculaValorTotal());

		}
		@Test
		public void listaComMaisItens() {
			Item i = new Item();
			i.setDescricao("Cd1");
			i.setQtd(1);
			i.setDescricao("Cd2");
			i.setQtd(1);
			i.setValorUnitario(new BigDecimal(50.00));
			i.setValorUnitario(new BigDecimal(60.00));
			p.setCliente("Joao");
			p.addItem(i);
			Assert.assertEquals(new BigDecimal(30.00), p.calculaValorTotal());

		}
		
		@Test
		public void listaComMaisItensEMaisQtd() {
			Item i = new Item();
			i.setDescricao("Cd1");
			i.setQtd(3);
			i.setDescricao("Cd2");
			i.setQtd(3);
			i.setValorUnitario(new BigDecimal(50.00));
			i.setValorUnitario(new BigDecimal(60.00));
			p.setCliente("Joao");
			p.addItem(i);
			Assert.assertEquals(new BigDecimal(30.00), p.calculaValorTotal());

		}

	}
