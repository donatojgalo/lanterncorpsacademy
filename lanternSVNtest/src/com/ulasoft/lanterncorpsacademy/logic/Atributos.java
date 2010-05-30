package com.ulasoft.lanterncorpsacademy.logic;

import lcaInterfaceDAO.IMisionPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IUsuarioDAO;
import lcaInterfaceDAO.IUsuarioDO;

import com.ulasoft.lanterncorpsacademy.menus.Menud;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMain;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class Atributos {

	public Atributos() {

	}

	private IPersonajeDO personaje;
	private IUsuarioDO usuario;
	
	public void updateAtts () throws Exception {
		ConnectionBean connectionBean=ConnectionFactory.getConnectionBean();
		personaje = (IPersonajeDO) GlobalDOFactory.getDO(IPersonajeDO.class);
		usuario = (IUsuarioDO) GlobalDOFactory.getDO(IUsuarioDO.class);
        
		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
        IUsuarioDAO usDAO = (IUsuarioDAO) GlobalDAOFactory.getDAO(IUsuarioDAO.class, connectionBean);
        usuario = (IUsuarioDO) usDAO.loadById(usuario.getId());
        personaje= (IPersonajeDO) personajeDAO.loadById(personaje.getId());
		
		System.err.println("PERSONAJE ID en atts:"+personaje.getId());
		
		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}
	
	public void updateMenud(Menud menud) throws Exception {
		
//		ConnectionBean connectionBean=ConnectionFactory.getConnectionBean();
//		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
//		//personaje = (IPersonajeDO) GlobalDOFactory.getDO(IPersonajeDO.class);
//		
		System.err.println("PERSONAJE ID en atts menud:" + personaje.getId());
		System.err.println("PERSONAJE salud en atts menud:"
				+ personaje.getSalud());
		// personaje= (IPersonajeDO) personajeDAO.loadById(personaje.getId());
		menud.getSalud().setCurrValue(
				(personaje.getSalud()) * 100
						/ (200 + 50 * (personaje.getNivel() - 1)));
		menud.getEnergia().setCurrValue(
				personaje.getEnergiaDelAnillo() * 100
						/ (100 + 10 * (personaje.getNivel() - 1)));
		menud.getExperiencia().setCurrValue(
				personaje.getExperiencia() * 100 / 15 * 
				 2^(personaje.getNivel() - 1));
		menud.getLblTrainsValue().setText(
				Integer.toString(personaje.getPuntosDeEntrenamiento()));
		menud.getLblNiveLabelValue().setText(
				Integer.toString(personaje.getNivel()));
		
//		ConnectionFactory.closeConnection(connectionBean.getConnection());
		System.err.println("PERSONAJE ID en atts menud2:" + personaje.getId());
		
	}

	public void updatePanelMain(PanelMain main) throws Exception {
		
		ConnectionBean connectionBean=ConnectionFactory.getConnectionBean();
		IPlanetaDAO planetaDAO = (IPlanetaDAO) GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);
		//IPlanetaDO planeta = (IPlanetaDO) GlobalDOFactory.getDO(IPlanetaDO.class);
		IMisionPersonajeDAO misionPersonDAO = (IMisionPersonajeDAO) GlobalDAOFactory
				.getDAO(IMisionPersonajeDAO.class, connectionBean);
		
		IPlanetaDO planeta= (IPlanetaDO) planetaDAO.loadById(personaje.getPlanetaRef().getRefIdent());
		int misionCount= misionPersonDAO.countByPersonajeId(personaje.getId());
		ConnectionFactory.closeConnection(connectionBean.getConnection());
		
		System.err.println("PLANETA ID en atts main:" + planeta.getId());
		main.getLblPlanetaValue().setText(planeta.getNombre());
		main.getLblSectorValue().setText(planeta.getSector());
		main.getLblFechaValue().setText(personaje.getUltimaFechaIngreso().toString());
		main.getLblMisionesValue().setText(Integer.toString(misionCount));
		
	}

public void guardarAtts() throws Exception {
	ConnectionBean connectionBean=ConnectionFactory.getConnectionBean();
	    
	IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
//    IUsuarioDAO usDAO = (IUsuarioDAO) GlobalDAOFactory.getDAO(IUsuarioDAO.class, connectionBean);
//    usuario = (IUsuarioDO) usDAO.loadById(usuario.getId());
    personajeDAO.update(personaje);
	
	System.err.println("PERSONAJE ID en atts save:"+personaje.getId());
	
	ConnectionFactory.closeConnection(connectionBean.getConnection());
		
	}
	
	
	
	
	
	
	
	public IPersonajeDO getPersonaje() {
		return personaje;
	}

	public void setPersonaje(IPersonajeDO personaje) {
		this.personaje = personaje;
	}

	public IUsuarioDO getUsuario() {
		return usuario;
	}

	public void setUsuario(IUsuarioDO usuario) {
		this.usuario = usuario;
	}

	



}