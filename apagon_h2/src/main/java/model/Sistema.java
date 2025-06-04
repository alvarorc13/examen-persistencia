package main.java.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Sistema {
	
	private Set<Central> centrales;
	
	public Sistema() {
		super();
		this.centrales = new HashSet<>();
	}
	
	public void addCentral(Central c) {
		this.centrales.add(c);
	}
	
	
	public void addRegistro(Central c, Registro r) {
		c.addRegistro(r);
	}
	
	public void addRegistro(String codigoCentral, Registro r) {
		this.centrales.stream().filter(c -> c.getCodigo().equals(codigoCentral)).findFirst().ifPresent(c -> c.addRegistro(r));
	}
	
	public Central obtenerCentralMayorProduccion() {
		return this.centrales.stream().sorted((c1, c2) -> -Double.compare(c1.calcularProduccionMedia(), c2.calcularProduccionMedia())).findFirst().get();
	}
	
	public Registro obtenerRegistroMenorProduccion() {
		return this.centrales.stream().flatMap(c -> c.getRegistros().stream()).sorted((r1, r2) -> Double.compare(r1.getWatios(), r2.getWatios())).findFirst().get();
//		return this.centrales.stream().flatMap(c -> c.getRegistros().stream()).min((r1, r2) -> Double.compare(r1.getWatios(), r2.getWatios())).orElse(null);

	}
	
	public Map<String, Set<Central>> obtenerCentralesAgrupadasPorTipo() {
		return this.centrales.stream().collect(Collectors.groupingBy(c -> c.getTipoCentral().toString(), Collectors.toSet()));
		
	}
	
	public double calcularProduccionMediaCentral(Central c) {
		return c.calcularProduccionMedia();
	}

}
