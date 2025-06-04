package main.java.service;

import java.time.LocalTime;

import org.hibernate.Session;

import main.java.model.Central;
import main.java.model.Registro;

public class RegistroService {
	
	public void persistir(Registro registro) {
	    Session session = ConnectionUtil.getSessionFactory().openSession();
	    session.beginTransaction();

	    Central centralAdjunta = session.merge(registro.getCentral());
	    registro.setCentral(centralAdjunta);

	    session.persist(registro);

	    session.getTransaction().commit();
	    session.close();
	}

	
	public Registro obtener(long id) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Registro registro = session.find(Registro.class, id);
		session.close();
		return registro;
	}
	
	public void actualizar(long id, LocalTime momento, long watios) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Registro registro = session.find(Registro.class, id);
		
		registro.setMomento(momento);
		registro.setWatios(watios);
		
		session.merge(registro);
		session.getTransaction().commit();
		session.close();
	}
	
	public void eliminar(long id) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.remove(session.find(Registro.class, id));
		session.getTransaction().commit();
		session.close();
	}

}
