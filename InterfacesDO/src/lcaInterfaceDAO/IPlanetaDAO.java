package lcaInterfaceDAO;

import java.sql.SQLException;

import dao.api.InterfaceDAO;

public interface IPlanetaDAO extends InterfaceDAO {

	public abstract void loadPersonajeList(IPlanetaDO planetaDO)
			throws Exception;
	
	public abstract void loadUnidadEjercitoList(IPlanetaDO planetaDO)
	throws Exception;

	public abstract void loadRecursoPlanetaList(IPlanetaDO planetaDO)
			throws Exception;

	float getPlanetDistance(int oringenId, int destinoId) throws SQLException;
	
	public void loadPersonajeRef(IPlanetaDO planetaDO) throws SQLException;

}