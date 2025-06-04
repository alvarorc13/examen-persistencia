package main.java;

import java.time.LocalDate;
import java.time.LocalTime;

import main.java.model.Central;
import main.java.model.Registro;
import main.java.model.Sistema;
import main.java.model.TipoCentral;
import main.java.service.CentralService;
import main.java.service.ConnectionUtil;
import main.java.service.RegistroService;

public class Principal {

	public static void main(String[] args) {
//		ConnectionUtil.getSessionFactory().openSession();
//		System.out.println("Conectado");
//		
//		CentralService cs = new CentralService();
//		RegistroService rs = new RegistroService();
		
//		Creando tablas y persistiendo algunos objetos
		
		Central c1 = new Central("A1", TipoCentral.NUCLEAR);
		Central c2 = new Central("A2", TipoCentral.COMBINADA);
		Central c3 = new Central("A3", TipoCentral.EOLICA);
		Central c4 = new Central("A4", TipoCentral.FOTOVOLTAICA);
//
//		cs.persistir(c1);
//		cs.persistir(c2);
//		cs.persistir(c3);
//		cs.persistir(c4);
//
		Registro r1 = new Registro(LocalTime.now(), 1000, c1);
		Registro r2 = new Registro(LocalTime.now(), 2000, c1);
		Registro r3 = new Registro(LocalTime.now(), 3000, c1);
		Registro r4 = new Registro(LocalTime.now(), 4000, c1);
//		
//		rs.persistir(r1);
//		rs.persistir(r2);
//		rs.persistir(r3);
//		rs.persistir(r4);
		
//		Obteniendo registros en la bbdd
		
//		System.out.println(cs.obtener(1));
//		System.out.println(cs.obtener(2));
//		
//		System.out.println(rs.obtener(1));
//		System.out.println(rs.obtener(2));
		
//		Actualizando registros
		
//		cs.actualizar(1, "B1");
//		System.out.println(cs.obtener(1));
//		
//		System.out.println(rs.obtener(1));
//		rs.actualizar(1, LocalTime.now(), 2000);
//		System.out.println(rs.obtener(1));
		
//		Eliminando datos
//		rs.eliminar(1);
//		System.out.println(rs.obtener(1));
		
		
		Sistema sistema = new Sistema();
		
		sistema.addCentral(c1);
		sistema.addCentral(c2);
		sistema.addCentral(c3);
		sistema.addCentral(c4);
		
		sistema.addRegistro(c1, r1);
		sistema.addRegistro(c1, r2);
		sistema.addRegistro(c1, r3);
		sistema.addRegistro(c1, r4);
		
		System.out.println(sistema.calcularProduccionMediaCentral(c1));
		System.out.println(sistema.obtenerCentralesAgrupadasPorTipo());
		System.out.println(sistema.obtenerCentralMayorProduccion());
		System.out.println(sistema.obtenerRegistroMenorProduccion());

	}

}
