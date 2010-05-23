package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IPersonajeDAO extends InterfaceDAO {


	public void loadClaseLinternaRef(IPersonajeDO personajeDO) throws SQLException;
	
	// --------------------------------------------------------------------------------

	public void loadPlanetaRef(IPersonajeDO personajeDO) throws SQLException;
	
	// --------------------------------------------------------------------------------

	public void loadGrupoRef(IPersonajeDO personajeDO) throws SQLException;
	
	// --------------------------------------------------------------------------------

	public void loadMisionPersonajeList(IPersonajeDO personajeDO) throws Exception;
	
	// --------------------------------------------------------------------------------

	public void loadHabilidadActivaList(IPersonajeDO personajeDO) throws Exception;
	// --------------------------------------------------------------------------------

	public List<IPersonajeDO> listByPersonajeId(int claseLinternaId) throws SQLException;
	
	// --------------------------------------------------------------------------------

	public List<IPersonajeDO> listRankin() throws SQLException;
	
	// --------------------------------------------------------------------------------
	
	public boolean checkIfAliasExists(String alias) throws SQLException;
	
	// --------------------------------------------------------------------------------
	
	public IPersonajeDO loadByAlias(String alias) throws SQLException;
	
}
