package main.java;

import java.time.LocalTime;

import main.java.model.Central;
import main.java.model.Registro;
import main.java.model.TipoCentral;
import main.java.service.CentralService;
import main.java.service.ConnectionUtil;
import main.java.service.RegistroService;

public class Principal {

	public static void main(String[] args) {
		ConnectionUtil.getSessionFactory().openSession();
		System.out.println("Conectado");
		
		CentralService cs = new CentralService();
		RegistroService rs = new RegistroService();
		
		
//		Central c1 = new Central("A1", TipoCentral.NUCLEAR);
//		Central c2 = new Central("A2", TipoCentral.COMBINADA);
//		Central c3 = new Central("A3", TipoCentral.EOLICA);
//		Central c4 = new Central("A4", TipoCentral.FOTOVOLTAICA);

//		cs.persistir(c1);
//		cs.persistir(c2);
//		cs.persistir(c3);
//		cs.persistir(c4);

//		Registro r1 = new Registro(LocalTime.now(), 1000, c1);
//		Registro r2 = new Registro(LocalTime.now(), 1000, c1);
//		Registro r3 = new Registro(LocalTime.now(), 1000, c1);
//		Registro r4 = new Registro(LocalTime.now(), 1000, c1);
		
//		rs.persistir(r1);
//		rs.persistir(r2);
//		rs.persistir(r3);
//		rs.persistir(r4);
		
		
		
	}

}
