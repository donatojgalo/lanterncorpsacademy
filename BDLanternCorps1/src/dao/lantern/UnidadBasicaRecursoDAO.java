package dao.lantern;

import java.sql.SQLException;
import java.util.List;

import lcaInterfaceDAO.IUnidadBasicaRecursoDAO;
import lcaInterfaceDAO.IUnidadBasicaRecursoDO;

import dao.api.BaseDAO;
import dao.api.DataObject;

public class UnidadBasicaRecursoDAO extends BaseDAO implements
		IUnidadBasicaRecursoDAO {

	@Override
	public int countAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void createTable() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(DataObject bean) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(DataObject bean) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DataObject> listAll(int lim, int off) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataObject loadById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DataObject bean) throws SQLException {
		// TODO Auto-generated method stub

	}

	List<IUnidadBasicaRecursoDO> listByRecursoId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}