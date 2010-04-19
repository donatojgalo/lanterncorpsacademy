package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;

public class PlanetaDAO extends BaseDAO {

	public PlanetaDAO(){
		// Empty
	}
	
	@Override
	public int countAll() throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT COUNT(*) FROM ");
	    strbuf.append(getTableName());

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    rs.next();

	    return rs.getInt("count");
	}

	@Override
	public void createTable() throws SQLException {
		StringBuffer strbuf;

		// ----------------------------------------

		strbuf = new StringBuffer();

		strbuf.append("DROP TABLE IF EXISTS ");
		strbuf.append(getTableName());
		strbuf.append(" CASCADE");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		// ----------------------------------------

		strbuf = new StringBuffer();

		strbuf.append("DROP SEQUENCE IF EXISTS ");
		strbuf.append("seq_");
		strbuf.append(getTableName());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		// ----------------------------------------
		
		strbuf = new StringBuffer();
		
		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(PlanetaDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(PlanetaDO.NOMBRE);
		strbuf.append(" VARCHAR(100),    ");
		strbuf.append(PlanetaDO.SECTOR);
		strbuf.append(" VARCHAR(100),    ");
		strbuf.append(PlanetaDO.COORDENADA_EN_X);
		strbuf.append(" FLOAT,     ");
		strbuf.append(PlanetaDO.COORDENADA_EN_Y);
		strbuf.append(" FLOAT     ");
		strbuf.append(")");
		
		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		// ----------------------------------------

		strbuf = new StringBuffer();

		strbuf.append("CREATE SEQUENCE ");
		strbuf.append("seq_");
		strbuf.append(getTableName());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());
		
	}

	@Override
	public void delete(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_DELETE);
	    checkClass(dataObject, PlanetaDO.class, CHECK_DELETE);

	    PlanetaDO planetaDO = (PlanetaDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("DELETE FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(PlanetaDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(planetaDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.del(dataObject);
		
	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_INSERT);
	    checkClass(dataObject, PlanetaDO.class, CHECK_INSERT);
	    
	    PlanetaDO planetaDO = (PlanetaDO) dataObject;
	    planetaDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(planetaDO.getId());
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(planetaDO.getNombre()));
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(planetaDO.getSector()));
	    strbuf.append(", ");
	    strbuf.append(planetaDO.getCoordenadaEnX());
	    strbuf.append(", ");
	    strbuf.append(planetaDO.getCoordenadaEnY());
	    strbuf.append(", ");
	    strbuf.append(")");
	    System.err.println(strbuf.toString());
	    connection.createStatement().execute(strbuf.toString());
	    dtaSession.add(dataObject);
		
	}

	private int getNextId() throws SQLException {
	    StringBuffer strbuf = new StringBuffer();
	    strbuf.append("SELECT nextval(");
	    strbuf.append(singleQuotes("seq_" + getTableName()));
	    strbuf.append(")");

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    if (!rs.next()) {
	      throw new IllegalStateException("!rs.next()");
	    }

	    return rs.getInt("nextval");
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

}
