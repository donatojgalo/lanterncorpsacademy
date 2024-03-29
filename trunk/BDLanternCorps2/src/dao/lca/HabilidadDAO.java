package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;


public class HabilidadDAO extends BaseDAO {

	public HabilidadDAO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

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
		strbuf.append(HabilidadDO.ID);
		strbuf.append(" INT PRIMARY KEY,	");
		strbuf.append(HabilidadDO.NOMBRE);
		strbuf.append(" VARCHAR(20) UNIQUE NOT NULL,	");
		strbuf.append(HabilidadDO.COSTO_DE_APRENDIZAJE);
		strbuf.append(" INT CHECK (" + HabilidadDO.COSTO_DE_APRENDIZAJE + " >= 0 ) DEFAULT 0,	");
		strbuf.append(HabilidadDO.TIPO);
		strbuf.append(" INT NOT NULL");
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

	// --------------------------------------------------------------------------------

	@Override
	public void delete(DataObject dataObject) throws SQLException {
		
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, HabilidadDO.class, CHECK_DELETE);

		HabilidadDO habilidadDO = (HabilidadDO) dataObject;

		StringBuffer strbuf = new StringBuffer();
		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadDO.ID);
		strbuf.append(" = ");
		strbuf.append(habilidadDO.getId());

		System.err.println(strbuf.toString());
		connection.createStatement().execute(strbuf.toString());
		dtaSession.del(dataObject);
	}

	// --------------------------------------------------------------------------------

	private int getNextId() throws SQLException {
		
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT nextval(");
		strbuf.append(singleQuotes("seq_" + getTableName()));
		strbuf.append(")");

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());

		if (!rs.next()) {
			throw new IllegalStateException("!rs.next()");
		}
		return rs.getInt("nextval");
	}

	// --------------------------------------------------------------------------------

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, HabilidadDO.class, CHECK_INSERT);

		HabilidadDO habilidadDO = (HabilidadDO) dataObject;
		habilidadDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();
		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(habilidadDO.getId());
		strbuf.append(", ");
		strbuf.append(singleQuotes(habilidadDO.getNombre()));
		strbuf.append(", ");
		strbuf.append(habilidadDO.getCosto_de_aprendizaje());
		strbuf.append(", ");
		strbuf.append(habilidadDO.getTipo());
		strbuf.append(")");
		
		System.err.println(strbuf.toString());
		connection.createStatement().execute(strbuf.toString());
		dtaSession.add(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public List<DataObject> listAll(int lim, int off) throws SQLException {
		
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		if (lim >= 0 && off >= 0) {
			strbuf.append(" LIMIT  ");
			strbuf.append(lim);
			strbuf.append(" OFFSET ");
			strbuf.append(off);
		}

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());
		List<DataObject> ret = new ArrayList<DataObject>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	// --------------------------------------------------------------------------------

	private HabilidadDO resultSetToDO(ResultSet rs) throws SQLException {

		HabilidadDO ret = (HabilidadDO) dtaSession.getDtaByKey( //
				HabilidadDO.class, rs.getInt(HabilidadDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new HabilidadDO();
		ret.setId(rs.getInt(HabilidadDO.ID));
		ret.setNombre(rs.getNString(HabilidadDO.NOMBRE));
		ret.setCosto_de_aprendizaje(rs.getInt(HabilidadDO.COSTO_DE_APRENDIZAJE));

		return (HabilidadDO) dtaSession.add(ret);
	}

	@Override
	public List<DataObject> listAll() throws SQLException {
		return listAll(-1, -1);
	}

	// --------------------------------------------------------------------------------

	@Override
	public int countAll() throws SQLException {
		
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT COUNT(*) FROM ");
		strbuf.append(getTableName());

		System.err.println(strbuf.toString());

		ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());
		rs.next();
		
		return rs.getInt("count");
	}

	// --------------------------------------------------------------------------------

	@Override
	public DataObject loadById(int id) throws SQLException {
		
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadDO.ID);
		strbuf.append(" = ");
		strbuf.append(id);

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());

		if (rs.next()) {
			return resultSetToDO(rs);
		}
		return null;
	}

	// --------------------------------------------------------------------------------

	@Override
	public void update(DataObject dataObject) throws SQLException {
		
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, HabilidadDO.class, CHECK_UPDATE);

		HabilidadDO habilidadDO = (HabilidadDO) dataObject;

		StringBuffer strbuf = new StringBuffer();
		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");
		strbuf.append(HabilidadDO.NOMBRE);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(habilidadDO.getNombre()));
		strbuf.append(", ");
		strbuf.append(HabilidadDO.COSTO_DE_APRENDIZAJE);
		strbuf.append(" = ");
		strbuf.append(habilidadDO.getCosto_de_aprendizaje());
		strbuf.append(", ");
		strbuf.append(HabilidadDO.TIPO);
		strbuf.append(" = ");
		strbuf.append(habilidadDO.getTipo());
		strbuf.append(", ");
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadDO.ID);
		strbuf.append(" = ");
		strbuf.append(habilidadDO.getId());

		System.err.println(strbuf.toString());
		connection.createStatement().execute(strbuf.toString());
	}

	// --------------------------------------------------------------------------------

	public void loadHabilidadClaseLinternaList(HabilidadDO habilidadDO) throws Exception {
		
		checkCache(habilidadDO, CHECK_UPDATE);
		HabilidadClaseLinternaDAO habilidadClaseLinternaDAO = (HabilidadClaseLinternaDAO) FactoryDAO
				.getDAO(HabilidadClaseLinternaDAO.class, connectionBean);

		habilidadDO.setHabilidadClaseLinternaList(habilidadClaseLinternaDAO
				.listByHabilidadId(habilidadDO.getId()));

	}
	
	// --------------------------------------------------------------------------------

	public void loadNivelHabilidadList(HabilidadDO habilidadDO) throws Exception {
	
		checkCache(habilidadDO, CHECK_UPDATE);
		NivelHabilidadDAO nivelHabilidadDAO = (NivelHabilidadDAO) FactoryDAO
				.getDAO(NivelHabilidadDAO.class, connectionBean);

		habilidadDO.setNivelHabilidadList(nivelHabilidadDAO
				.listByHabilidadId(habilidadDO.getId()));
	
	}
	
	// --------------------------------------------------------------------------------

	public void loadHabilidadActivaList(HabilidadDO habilidadDO) throws Exception {
		checkCache(habilidadDO, CHECK_UPDATE);
		HabilidadActivaDAO habilidadActivaDAO = (HabilidadActivaDAO) FactoryDAO
				.getDAO(HabilidadActivaDAO.class, connectionBean);

		habilidadDO.setHabilidadActivaList(habilidadActivaDAO
				.listByHabilidadId(habilidadDO.getId()));
	}

}
