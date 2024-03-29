package Object;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_nivelHabilidad")
@Proxy(lazy = false)
public class NivelHabilidad{
	
	// --------------------------------------------------------------------------------

	private int id;
	private int nivelDeHabilidad;
	private float efectividad;
	private double costoDeEnergia;
	private int probabilidad;
	
	// --------------------------------------------------------------------------------
	
	private Habilidad habilidadRef;
	
	// --------------------------------------------------------------------------------

	public NivelHabilidad() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// --------------------------------------------------------------------------------
	
	public int getNivel_de_habilidad() {
		return nivelDeHabilidad;
	}

	public void setNivel_de_habilidad(int nivelDeHabilidad) {
		this.nivelDeHabilidad = nivelDeHabilidad;
	}

	// --------------------------------------------------------------------------------
	
	public float getEfectividad() {
		return efectividad;
	}

	public void setEfectividad(int efectividad) {
		this.efectividad = efectividad;
	}

	// --------------------------------------------------------------------------------
	

	public double getCosto_de_energia() {
		return costoDeEnergia;
	}

	public void setCosto_de_energia(double costoDeEnergia) {
		this.costoDeEnergia = costoDeEnergia;
	}
	
	// --------------------------------------------------------------------------------
	
	public int getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}
	
	// --------------------------------------------------------------------------------

	@ManyToOne
	public Habilidad getHabilidadRef() {
		return habilidadRef;
	}

	public void setHabilidadRef(Habilidad habilidadRef) {
		this.habilidadRef = habilidadRef;
	}
	
}
