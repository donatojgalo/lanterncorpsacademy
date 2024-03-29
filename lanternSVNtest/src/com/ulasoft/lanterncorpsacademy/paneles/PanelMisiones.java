package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.IMisionDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Font;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.RadioButton;
import nextapp.echo.app.Row;
import nextapp.echo.app.button.ButtonGroup;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.ETableNavigation;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableSelModel;
import com.minotauro.echo.table.renderer.BaseCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.minotauro.echo.table.renderer.NestedCellRenderer;
import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Mision;

@SuppressWarnings("serial")
public class PanelMisiones extends Panel {

	private TestTableModel tableDtaModel;
	ButtonGroup btnGroupClases = new ButtonGroup();
	List<IMisionDO> mision;
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
	.getActive();

	public PanelMisiones() {

		Row row1 = new Row();
//		row1.setStyle(GUIStyles.STYLECENTERROW);

		Column col = new Column();
		col.setInsets(new Insets(5, 5, 5, 5));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);

		col.add(initTable());

		Row row = new Row();
		Button btnSalir = new Button("SALIR");
		btnSalir.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSalirClicked();
			}
		});
		row.add(btnSalir);

		Button btnDescripcion = new Button("Descripcion");
		btnDescripcion.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnDescripcion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnDescripcionClicked();
			}
		});

		row.add(btnDescripcion);

		Button btnRealizarMision = new Button("Realizar Mision");
		btnRealizarMision.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnRealizarMision.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnRealizarMisionClicked();
			}
		});

		row.add(btnRealizarMision);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		col.setBorder(new Border(3, new Color(0x00, 0x00, 0x00),
				Border.STYLE_SOLID));
		row1.add(col);
		add(row1);
	}

	protected void btnRealizarMisionClicked() {

	}

	protected void btnDescripcionClicked() {

	}

	protected void btnSalirClicked() {
		PanelMain pnlMain = new PanelMain();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);
	}

	private Component initTable() {
		setInsets(new Insets(2, 2, 2, 2));

		Column col = new Column();
		// col.setCellSpacing(new Extent(1));
		col.setBackground(Color.WHITE);

		col.add(initTopRow());

		// ----------------------------------------
		// The table models
		// ----------------------------------------

		TableColModel tableColModel = initTableColModel();
		TableSelModel tableSelModel = new TableSelModel();

		tableDtaModel = new TestTableModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(10);

		try {
			mision=Mision.obtenerMisiones(app.getAtributos().getPersonaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ----------------------------------------
		// The table
		// ----------------------------------------

		ETable table = new ETable();
		table.setTableDtaModel(tableDtaModel);
		table.setTableColModel(tableColModel);
		table.setTableSelModel(tableSelModel);

		table.setEasyview(true);

		table.setBorder(new Border(1, Color.BLACK, Border.STYLE_NONE));
		table.setInsets(new Insets(5, 2, 5, 2));
		col.add(table);

		// ----------------------------------------
		// The navigation control
		// ----------------------------------------

		ETableNavigation tableNavigation = new ETableNavigation(tableDtaModel);
		col.add(tableNavigation);
		return col;
	}

	private Row initTopRow() {
		Row row = new Row();
		row.setCellSpacing(new Extent(5));
		Label lblTitle = new Label("Lista de Misiones");
		lblTitle.set(PROPERTY_FONT, Font.ARIAL);
		lblTitle.set(PROPERTY_FONT, Color.BLACK);

		row.add(lblTitle);
		row.setAlignment(Alignment.ALIGN_CENTER);

		return row;
	}

	// --------------------------------------------------------------------------------

	private TableColModel initTableColModel() {
		TableColModel tableColModel = new TableColModel();

		TableColumn tableColumn;

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IMisionDO mision = (IMisionDO) element;
				return mision.getNombre();
			}
		};

		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Nombre de Mision");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IMisionDO mision = (IMisionDO) element;
				return mision.getPuntos_de_entrenamiento_ganados();
			}
		};

		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Ptos de Entrenamiento Ofrecidos");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IMisionDO mision = (IMisionDO) element;
				return mision.getExperiencia_ganada();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Experiencia Obtenida");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);
		
		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Actions");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(initNestedCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		return tableColModel;
	}

	// --------------------------------------------------------------------------------
	// Setup command bar renderer
	// --------------------------------------------------------------------------------

	private NestedCellRenderer initNestedCellRenderer() {
		NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer(
					//
					final ETable table, final Object value, final int col,
					final int row) {

				boolean editable = ((TestTableModel) table.getTableDtaModel())
						.getEditable();

				RadioButton ret = new RadioButton();
//				ret.setStyle(GUIStyles.DEFAULT_STYLE);
				ret.setEnabled(editable);
				ret.setGroup(btnGroupClases);
				ret.setToolTipText("Seleccion");

				ret.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnRadioClicked(row);
					}
				});
				return ret;
			}
		});

		return nestedCellRenderer;
	}

	// --------------------------------------------------------------------------------

	private void btnRadioClicked(int row) {
	}
}
