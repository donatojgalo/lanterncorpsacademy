package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IGrupoDAO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import nextapp.echo.app.TextField;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class CrearGrupo {

	public static String obtenerNombreGrupo(IPersonajeDO personaje) //
			throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IGrupoDAO grupoDAO = (IGrupoDAO) //
				GlobalDAOFactory.getDAO(IGrupoDAO.class, connectionBean);
		IGrupoDO grupoDO;

		if(personaje.getGrupoRef() == null || //
				personaje.getGrupoRef().getRefIdent() == 0) {

			connectionBean.getConnection().close();
			return "";

		} else {

			grupoDO = (IGrupoDO) //
				grupoDAO.loadById(personaje.getGrupoRef().getRefIdent());

		}

//		if(personaje.getGrupoRef().getRefIdent() != 0) {
//
//			grupoDO = (IGrupoDO) //
//					grupoDAO.loadById(personaje.getGrupoRef().getRefIdent());
//
//			if (grupoDO == null) {
//				connectionBean.getConnection().close();
//				return "";
//			}
//		}
//		else {
//			connectionBean.getConnection().close();
//			return "";
//		}

		connectionBean.getConnection().close();
		return grupoDO.getNombre();
	}

	public static List<IPersonajeDO> obtenerPersonajesClase(IPersonajeDO personaje) //
			throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		List<IPersonajeDO> personajesClase;
		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		personajesClase = personajeDAO.listByClaseLinternaId( //
				personaje.getClaseLinternaRef().getRefIdent());

		connectionBean.getConnection().close();
		return personajesClase;
	}

	public static TestTableModel asignarPersonaje(TestTableModel tableDtaModel, //
			List<IPersonajeDO> personajes, IPersonajeDO personaje) {

		for (int posicion = 0; posicion < personajes.size(); posicion++) {
			if((personajes.get(posicion).getId() == personaje.getId())) {
				continue;
			}
//			(personajes.get(posicion)).setId(posicion + 1);
			tableDtaModel.add(personajes.get(posicion));
		}
		return tableDtaModel;
	}

	public static void crearGrupo(IPersonajeDO personaje, List<IPersonajeDO> personajes, //
			List<Integer> seleccion, TextField txtGrupo) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IGrupoDAO grupoDAO = (IGrupoDAO) //
				GlobalDAOFactory.getDAO(IGrupoDAO.class, connectionBean);
		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		IGrupoDO grupoDO = (IGrupoDO) //
				GlobalDOFactory.getDO(IGrupoDO.class);

		List<IPersonajeDO> listPersonaje = new ArrayList<IPersonajeDO>();
		grupoDO.setNombre(txtGrupo.getText());
		grupoDO.setEstado(true);
		listPersonaje.add(personaje);

		for(int pos = 0; pos < seleccion.size(); pos++) {
			listPersonaje.add(personajes.get(seleccion.get(pos).intValue()));
		}

		grupoDO.setPersonajeList(listPersonaje);
		grupoDO.setClaseLinternaRef(personaje.getClaseLinternaRef());
		grupoDAO.insert(grupoDO);
		Reference<IGrupoDO> grupoRef = new Reference<IGrupoDO>();
		grupoRef.setRefIdent(grupoDO.getId());

		for(int pos = 0; pos < listPersonaje.size(); pos++) {

			listPersonaje.get(pos).setGrupoRef(grupoRef);
			personajeDAO.update(listPersonaje.get(pos));
			personajeDAO = (IPersonajeDAO) //
					GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		}

		connectionBean.getConnection().close();
	}

	public static void crearGrupo2(IPersonajeDO personaje, //
			TextField txtGrupo) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IGrupoDAO grupoDAO = (IGrupoDAO) //
				GlobalDAOFactory.getDAO(IGrupoDAO.class, connectionBean);
		IGrupoDO grupoDO = (IGrupoDO) //
				GlobalDOFactory.getDO(IGrupoDO.class);

		List<IPersonajeDO> personajeList = new ArrayList<IPersonajeDO>();
		grupoDO.setPersonajeList(personajeList);
		grupoDO.setClaseLinternaRef(personaje.getClaseLinternaRef());
		grupoDO.setNombre(txtGrupo.getText());
		grupoDO.setEstado(false);
		grupoDAO.insert(grupoDO);

		insertarNuevoMiembro(personaje, grupoDO);

		connectionBean.getConnection().close();
	}

	public static void insertarNuevoMiembro(IPersonajeDO personaje, //
			IGrupoDO grupoDO) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IGrupoDAO grupoDAO = (IGrupoDAO) //
				GlobalDAOFactory.getDAO(IGrupoDAO.class, connectionBean);
		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);

		grupoDO.getPersonajeList().add(personaje);

		if (grupoDO.getPersonajeList().size() > 1 && !grupoDO.isEstado()) {
			grupoDO.setEstado(true);
		}

		grupoDAO.update(grupoDO);

		Reference<IGrupoDO> grupoRef = new Reference<IGrupoDO>();
		grupoRef.setRefIdent(grupoDO.getId());
		personaje.setGrupoRef(grupoRef);

		personajeDAO.update(personaje);
		personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);

		connectionBean.getConnection().close();
	}

	public static boolean checkNombreGrupoIsEmpty(TextField txtGrupo) {

		if (txtGrupo.getText().equals("")) {
			return true;
		}
		return false;
	}

}
