package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IOrdenDAO extends InterfaceDAO{

	public abstract List<IOrdenDO> listByMisionId(int misionId)
			throws SQLException;

	public abstract void loadMisionRef(IOrdenDO ordenDO) throws SQLException;

	public abstract void loadObjetivoRef(IOrdenDO ordenDO) throws SQLException;
	
	public List<IOrdenDO> listByObjetivoId(int objetivoId) throws SQLException;

}