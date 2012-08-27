package br.usp.ime.Pedido.entidade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Teste {
	
	public static void main (String [] args){
		AnnotationConfiguration configuration = new AnnotationConfiguration ();
		configuration.configure ();
		
		SessionFactory factory =configuration.buildSessionFactory();
		Session session = factory.openSession();
		
	}

}
