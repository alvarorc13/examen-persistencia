package main.java.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "central")
public class Central {

	@Id
	@Column(name = "id_central")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String codigo;
	
	@Enumerated
	private TipoCentral tipoCentral;

    @OneToMany(mappedBy = "central", cascade = CascadeType.MERGE)
	private Set<Registro> registros;

	public Central(String codigo, TipoCentral tipoCentral) {
		super();
		this.codigo = codigo;
		this.tipoCentral = tipoCentral;
		this.registros = new HashSet<>();
	}

	public Central() {
		super();
	}

	public void addRegistro(Registro r) {
		this.registros.add(r);
	}

	public double calcularProduccionMedia() {
		return this.registros.stream().mapToDouble(Registro::getWatios).average().orElse(0);
//		return this.registros.stream().mapToDouble(r -> r.getWatios()).average().orElse(0);
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj || obj != null && obj instanceof Central && this.hashCode() == obj.hashCode();
	}

	@Override
	public String toString() {
		return "Central [id=" + id + ", codigo=" + codigo + ", tipoCentral=" + tipoCentral + ", registros=" + registros
				+ "]";
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoCentral getTipoCentral() {
		return tipoCentral;
	}

	public void setTipoCentral(TipoCentral tipoCentral) {
		this.tipoCentral = tipoCentral;
	}

	public Set<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(Set<Registro> registros) {
		this.registros = registros;
	}

}
