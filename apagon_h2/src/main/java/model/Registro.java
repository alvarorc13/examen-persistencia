package main.java.model;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "registro")
public class Registro {

	@Id
	@Column(name = "id_registro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRegistro;

	@Column
	private LocalTime momento;
	
	public Registro() {
		super();
	}

	@Column
	private long watios;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_central", foreignKey = @ForeignKey(name = "central_id_fk"), nullable = false, updatable = false)
	private Central central;

	public Registro(LocalTime momento, long watios, Central central) {
		super();
		this.momento = momento;
		this.watios = watios;
		this.central = central;
	}

//	@Override
//	public String toString() {
//		return "Registro [idRegistro=" + idRegistro + ", momento=" + momento + ", watios=" + watios + ", central="
//				+ central + "]";
//	}

	public long getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(long idRegistro) {
		this.idRegistro = idRegistro;
	}

	public LocalTime getMomento() {
		return momento;
	}

	public void setMomento(LocalTime momento) {
		this.momento = momento;
	}

	public long getWatios() {
		return watios;
	}

	public void setWatios(long watios) {
		this.watios = watios;
	}

	public Central getCentral() {
		return central;
	}

	public void setCentral(Central central) {
		this.central = central;
	}

}
