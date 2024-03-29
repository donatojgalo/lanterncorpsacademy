package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class ObjetivoDAO extends BaseDAO {

	public ObjetivoDAO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

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

		PlanetaDAO p = new PlanetaDAO();
		p.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(ObjetivoDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(ObjetivoDO.DESCRIPCION);
		strbuf.append(" VARCHAR(100),    ");
		strbuf.append(ObjetivoDO.NUMERO_DE_NPC);
		strbuf.append(" INT CHECK("+ ObjetivoDO.NUMERO_DE_NPC + " > 0 ) ,     ");
		strbuf.append(ObjetivoDO.PLANETA_ID);
		strbuf.append(" INT NOT NULL REFERENCES    ");
		strbuf.append(p.getTableName());
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
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, ObjetivoDO.class, CHECK_INSERT);

		ObjetivoDO objetivoDO = (ObjetivoDO) dataObject;

		objetivoDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(objetivoDO.getId());
		strbuf.append(", ");
		strbuf.append(singleQuotes(objetivoDO.getDescripcion()));
		strbuf.append(", ");
		strbuf.append(objetivoDO.getNumeroDeNpc());
		strbuf.append(", ");
		strbuf.append(objetivoDO.getPlanetaRef().getRefIdent());
		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.add(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, ObjetivoDO.class, CHECK_UPDATE);

		ObjetivoDO objetivoDO = (ObjetivoDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(ObjetivoDO.DESCRIPCION);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(objetivoDO.getDescripcion()));

		strbuf.append(", ");

		strbuf.append(ObjetivoDO.NUMERO_DE_NPC);
		strbuf.append(" = ");
		strbuf.append(objetivoDO.getNumeroDeNpc());

		strbuf.append(", ");

		strbuf.append(ObjetivoDO.PLANETA_ID);
		strbuf.append(" = ");
		strbuf.append(objetivoDO.getPlanetaRef().getRefIdent());

		strbuf.append(" WHERE ");
		strbuf.append(ObjetivoDO.ID);
		strbuf.append(" = ");
		strbuf.append(objetivoDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());
	}

	// --------------------------------------------------------------------------------

	@Override
	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, ObjetivoDO.class, CHECK_DELETE);

		ObjetivoDO objetivoDO = (ObjetivoDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(ObjetivoDO.ID);
		strbuf.append(" = ");
		strbuf.append(objetivoDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public DataObject loadById(int id) throws SQLException {
		ObjetivoDO objetivoDO;

		objetivoDO = (ObjetivoDO) dtaSession.getDtaByKey( //
				ObjetivoDO.class, id);

		if (objetivoDO != null) {
			return objetivoDO;
		} else {
			StringBuffer strbuf = new StringBuffer();

			strbuf.append("SELECT * FROM ");
			strbuf.append(getTableName());

			strbuf.append(" WHERE ");
			strbuf.append(ObjetivoDO.ID);
			strbuf.append(" = ");
			strbuf.append(id);

			System.err.println(strbuf.toString());

			ResultSet rs = //
			connection.createStatement().executeQuery(strbuf.toString());

			if (rs.next()) {
				objetivoDO = resultSetToDO(rs);
				return (ObjetivoDO) dtaSession.add(objetivoDO);
			}

			return null;
		}
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

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<DataObject> ret = new ArrayList<DataObject>();
		ObjetivoDO objetivoDO;

		while (rs.next()) {

			objetivoDO = (ObjetivoDO) dtaSession.getDtaByKey( //
					ObjetivoDO.class, rs.getInt(ObjetivoDO.ID));

			if (objetivoDO == null) {
				objetivoDO = (ObjetivoDO) dtaSession.add(resultSetToDO(rs));
			}

			ret.add(objetivoDO);
		}

		return ret;
	}

	// --------------------------------------------------------------------------------

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

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		rs.next();

		return rs.getInt("count");
	}

	// --------------------------------------------------------------------------------

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

	// --------------------------------------------------------------------------------

	private ObjetivoDO resultSetToDO(ResultSet rs) throws SQLException {
		ObjetivoDO ret = new ObjetivoDO();

		ret.setId(rs.getInt(ObjetivoDO.ID));
		ret.setDescripcion(rs.getString(ObjetivoDO.DESCRIPCION));
		ret.setNumeroDeNpc(rs.getInt(ObjetivoDO.NUMERO_DE_NPC));
		Reference<PlanetaDO> p = new Reference<PlanetaDO>();
		p.setRefIdent(rs.getInt(ObjetivoDO.NUMERO_DE_NPC));
		ret.setPlanetaRef(p);

		return ret;
	}

	// --------------------------------------------------------------------------------
	
	{
//	public void loadOrdenList(ObjetivoDO objetivoDO) throws Exception {
//		checkCache(objetivoDO, CHECK_UPDATE);
//		checkClass(objetivoDO, ObjetivoDO.class, CHECK_UPDATE);
//
//		OrdenDAO ordenDAO = (OrdenDAO) FactoryDAO.getDAO( //
//				OrdenDAO.class, connectionBean);
//
//		objetivoDO.setOrdenList(ordenDAO.listByIdObjetivoId(objetivoDO.getId()));
//	}
	}

	// --------------------------------------------------------------------------------
	
	public void loadPlanetaRef(ObjetivoDO objetivoDO) throws SQLException {

		checkClass(objetivoDO, ObjetivoDO.class, CHECK_UPDATE);

		PlanetaDAO misionDAO = new PlanetaDAO();
		misionDAO.init(connectionBean);

		Reference<PlanetaDO> ref = objetivoDO.getPlanetaRef();
		if (ref.getRefIdent() == 0) {
			return;
		}

		PlanetaDO misionDO = //
		(PlanetaDO) misionDAO.loadById(ref.getRefIdent());

		ref.setRefValue(misionDO);
	}

}
