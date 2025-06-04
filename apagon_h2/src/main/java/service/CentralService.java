package main.java.service;

import org.hibernate.Session;

import main.java.model.Central;

public class CentralService {
	
	public void persistir(Central central) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
				
		session.persist(central);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public Central obtener(long id) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Central central = session.find(Central.class, id);
		session.close();
		return central;
	}
	
	public void actualizar(long id, String codigo) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Central central = session.find(Central.class, id);
		
		central.setCodigo(codigo);
		session.merge(central);
		session.getTransaction().commit();
		session.close();
	}
	
	public void eliminar(long id) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.remove(session.find(Central.class, id));
		session.getTransaction().commit();
		session.close();
	}

}
