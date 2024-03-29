package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadActivaDAO;
import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.INivelHabilidadDAO;
import lcaInterfaceDAO.INivelHabilidadDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.paneles.PanelViajarPlaneta;

import dao.api.DataObject;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import echopoint.model.CircleSection;
import echopoint.model.MapSection;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class Viajar {
	
	protected static final int VERDE = 1;
	protected static final int AMARILLO = 2;
	protected static final int ROJO = 3;
	protected static final int NEGRO = 4;
	protected static final int AZUL = 5;
	protected static final int INDIGO = 6;
	protected static final int VIOLETA = 7;

	private static LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
	private static Atributos atrib = app.getAtributos();

	public static List<MapSection> cargarPlanetas(PanelViajarPlaneta panel) throws Exception {
		
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IPlanetaDAO planetDAO = (IPlanetaDAO) GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);

		IPlanetaDO origen = (IPlanetaDO) planetDAO.loadById(atrib
				.getPersonaje().getPlanetaRef().getRefIdent());
		
		panel.getLblActual().setText("Estás en: "+origen.getNombre()+", Sector: "+origen.getSector());
		
		
		List<DataObject> planetasDOList = planetDAO.listAll();
		
		ConnectionFactory.closeConnection(connectionBean.getConnection());
		
		List<MapSection> planetas = new ArrayList<MapSection>();
		
		IPlanetaDO planeta = (IPlanetaDO) GlobalDOFactory
		.getDO(IPlanetaDO.class);


	for (int i = 0; i < (planetasDOList.size()); i++) {

		planeta = (IPlanetaDO) planetasDOList.get(i);

		CircleSection pl = new CircleSection((int) planeta
			.getCoordenadaEnX(), (int) planeta.getCoordenadaEnY(),
			15, Integer.toString(planeta.getId()));

			if (i < 7) {
				
				switch (planeta.getId()) {
				case VERDE:
					if ((atrib.getPersonaje().getClaseLinternaRef().getRefIdent() != planeta.getId())) {
						continue;
					}
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de los Green Lantern Corps");
					break;
				
				case AMARILLO:
					if ((atrib.getPersonaje().getClaseLinternaRef().getRefIdent() != planeta.getId())) {
						continue;
					}
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de los Sinestro Corps");
					break;
				case ROJO:
					if ((atrib.getPersonaje().getClaseLinternaRef().getRefIdent() != planeta.getId())) {
						continue;
					}
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de los Red Lantern Corps");
					break;
				
				case NEGRO:
					if ((atrib.getPersonaje().getClaseLinternaRef().getRefIdent() != planeta.getId())) {
						continue;
					}
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de los Black Lantern Corps");
					break;
				
				case AZUL:
					if ((atrib.getPersonaje().getClaseLinternaRef().getRefIdent() != planeta.getId())) {
						continue;
					}
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de los Blue Lantern Corps");
					break;
				
				case INDIGO:
					if ((atrib.getPersonaje().getClaseLinternaRef().getRefIdent() != planeta.getId())) {
						continue;
					}
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de la Tribu Indigo");
					break;
				
				case VIOLETA:
					if ((atrib.getPersonaje().getClaseLinternaRef().getRefIdent() != planeta.getId())) {
						continue;
					}
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de las Star Sapphires");
					break;
				
			  }
			}

		else {
				pl.setAltText(planeta.getNombre() + " - Sector: "
			+ planeta.getSector() + "."); 
			}
			
			if ((atrib.getPersonaje().getPlanetaRef().getRefIdent() != planeta.getId())) {
				System.err.println("PLANETA ID:"+planeta.getId());
				planetas.add(pl);				
				}
				
	}
 
 return planetas;

}

	public static boolean viajarA(String planetaid) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		
		IPersonajeDO personaje = atrib.getPersonaje();
		
		IPlanetaDAO planetDAO = (IPlanetaDAO) GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);

		IHabilidadActivaDAO habActivaDAO = (IHabilidadActivaDAO) GlobalDAOFactory.getDAO(IHabilidadActivaDAO.class, connectionBean);
		
		IHabilidadDAO habilidadDAO = (IHabilidadDAO) GlobalDAOFactory.getDAO(IHabilidadDAO.class, connectionBean);
		
		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		
		INivelHabilidadDAO nivHabilidadDAO = (INivelHabilidadDAO) GlobalDAOFactory.getDAO(INivelHabilidadDAO.class, connectionBean);

//		List<IHabilidadActivaDO> habList = new ArrayList<IHabilidadActivaDO>();
		
		IHabilidadDO vuelo = habilidadDAO.loadByNombre("Vuelo");
		
		IHabilidadActivaDO vueloActive = (IHabilidadActivaDO) habActivaDAO.loadByHabilidadId(vuelo.getId(), personaje.getId());
		
		INivelHabilidadDO vueloInfo = nivHabilidadDAO.loadNivelHabStats(vuelo.getId(), vueloActive.getNivel_habilidad());
		
			
		//habList = habActivaDAO.listByPersonajeId(personaje.getId());
						
		IPlanetaDO planetaDestino = (IPlanetaDO) planetDAO.loadById(Integer.parseInt(planetaid));
		
		float distancia = planetDAO.getPlanetDistance(personaje.getPlanetaRef().getRefIdent(), planetaDestino.getId());
		
		System.err.println("Dist: "+distancia);
		
		double costo = (distancia/10)*2*vueloInfo.getCosto_de_energia();
		
		System.err.println("Costo: "+costo);
		
		if (personaje.getEnergiaDelAnillo()<costo)
			return false;
		else {
			
			personaje.getPlanetaRef().setRefIdent(planetaDestino.getId());
			
			double energiaNueva =personaje.getEnergiaDelAnillo() - costo;
			
			System.err.println("Energ nueva: "+energiaNueva);
			
			personaje.setEnergiaDelAnillo((int) energiaNueva);
			
			Desktop d =app.getDesktop();
			atrib.setPersonaje(personaje);
			atrib.updateMenuStatus(d.getMenuHead().getMenuStatus());
						
			personajeDAO.update(personaje);
			
			System.err.println("PLANETA ID travel:"+atrib.getPersonaje().getPlanetaRef().getRefIdent());
			
			ConnectionFactory.closeConnection(connectionBean.getConnection());
			
			return true;
		}
		
	}

	
	
}
