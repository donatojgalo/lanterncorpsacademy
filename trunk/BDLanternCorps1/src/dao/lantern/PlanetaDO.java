package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public class PlanetaDO implements DataObject {

	public static final String NOMBRE = "nombre";
	public static final String SECTOR = "sector";
	public static final String COORDENADA_EN_X = "coordenada_en_x";
	public static final String COORDENADA_EN_Y = "coordenada_en_y";
//	public static final String CLASE_LINTERNA_ID = "claseLinternaId";
	

	
	// --------------------------------------------------------------------------------

	private int id;

	private String nombre;
	private String sector;
	private float coordenada_en_x;
	private float coordenada_en_y;

	private Reference<ClaseLinternaDO> claseLinternaRef = new Reference<ClaseLinternaDO>();
	// --------------------------------------------------------------------------------

	private List<PersonajeDO> personajeList = //
	new ArrayList<PersonajeDO>();


	private List<ObjetivoDO> objetivoList = //
		new ArrayList<ObjetivoDO>();
	
	// --------------------------------------------------------------------------------

	public PlanetaDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// --------------------------------------------------------------------------------

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// --------------------------------------------------------------------------------

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	
	// --------------------------------------------------------------------------------

	public float getCoordenadaEnX() {
		return coordenada_en_x;
	}

	public void setCoordenadaEnX(float coordenada_en_x) {
		this.coordenada_en_x = coordenada_en_x;
	}

	// --------------------------------------------------------------------------------

	public float getCoordenadaEnY() {
		return coordenada_en_y;
	}

	public void setCoordenadaEnY(float coordenada_en_y) {
		this.coordenada_en_y = coordenada_en_y;
	}
	
	// --------------------------------------------------------------------------------

	public Reference<ClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(Reference<ClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}
	
	// --------------------------------------------------------------------------------

	public List<PersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<PersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

	// --------------------------------------------------------------------------------

	public List<ObjetivoDO> getObjetivoList() {
		return objetivoList;
	}

	public void setObjetivoList(List<ObjetivoDO> objetivoList) {
		this.objetivoList = objetivoList;
	}

}
