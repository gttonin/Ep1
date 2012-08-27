package br.usp.ime.Pedido.controller;

import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.usp.ime.Pedido.dao.ClienteDao;
import br.usp.ime.Pedido.entidade.Cliente;


@Resource
public class ClienteController {
	
	private ClienteDao dao;
	
	public ClienteController (ClienteDao dao) {
		this.dao = dao;
	}
	
			
	public ArrayList<Cliente> cliente() {
		//return new ArrayList<Cliente> ();
		retun dao.cliente();
	}

	
}