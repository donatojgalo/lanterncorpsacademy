package dao.lca;

import java.util.ArrayList;
import java.util.List;

import dao.api.Reference;

import lcaInterfaceDAO.IObjetivoDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IRecursoPlanetaDO;


public class PlanetaDO implements IPlanetaDO {

	public static final String NOMBRE = "nombre";
	public static final String SECTOR = "sector";
	public static final String COORDENADA_EN_X = "coordenadaEnX";
	public static final String COORDENADA_EN_Y = "coordenadaEnY";
	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private String sector;
	private float coordenadaEnX;
	private float coordenadaEnY;

	// --------------------------------------------------------------------------------

	private List<IPersonajeDO> personajeList = new ArrayList<IPersonajeDO>();
	private List<IObjetivoDO> objetivoList = new ArrayList<IObjetivoDO>();
	
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
		return coordenadaEnX;
	}

	public void setCoordenadaEnX(float coordenadaEnX) {
		this.coordenadaEnX = coordenadaEnX;
	}

	// --------------------------------------------------------------------------------

	public float getCoordenadaEnY() {
		return coordenadaEnY;
	}

	public void setCoordenadaEnY(float coordenadaEnY) {
		this.coordenadaEnY = coordenadaEnY;
	}
	
	// --------------------------------------------------------------------------------

	public List<IPersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<IPersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------


	public List<IObjetivoDO> getObjetivoList() {
		return objetivoList;
	}

	public void setObjetivoList(List<IObjetivoDO> objetivoList) {
		this.objetivoList = objetivoList;
	}

	@Override
	public Reference<IPersonajeDO> getPlanetaEsCasaRef() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IRecursoPlanetaDO> getRecursoPlanetaList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlanetaEsCasaRef(Reference<IPersonajeDO> planetaEsCasaRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRecursoPlanetaList(List<IRecursoPlanetaDO> recursoPlanetaList) {
		// TODO Auto-generated method stub
		
	}

}
