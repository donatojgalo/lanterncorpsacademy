package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.ETableNavigation;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableSelModel;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

public class PanelConstructor {

	public PanelConstructor() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	public static Row initTopRow(String texto) {

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);
		Label lblTitle = new Label(texto);
		lblTitle.setForeground(Color.WHITE);
		Estilo.setFont(lblTitle, GUIStyles.BOLD, 16);
		row.add(lblTitle);
		return row;

	}

	// --------------------------------------------------------------------------------

	public static Row initTopRow(String texto, int size) {

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);
		Label lblTitle = new Label(texto);
		lblTitle.setForeground(Color.WHITE);
		Estilo.setFont(lblTitle, GUIStyles.BOLD, size);
		row.add(lblTitle);
		return row;

	}

	// --------------------------------------------------------------------------------

	public static Row initTopRow(String texto, Color color, int size) {

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);
		Label lblTitle = new Label(texto);
		lblTitle.setForeground(color);
		Estilo.setFont(lblTitle, GUIStyles.BOLD, size);
		row.add(lblTitle);
		return row;

	}

	// --------------------------------------------------------------------------------

	public static Component initTable(TestTableModel tableDtaModel, //
			TableColModel initTableColModel, boolean isPageable) {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);

		// ----------------------------------------
		// The table models
		// ----------------------------------------

		TableColModel tableColModel = initTableColModel;
		TableSelModel tableSelModel = new TableSelModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(10);

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
		Estilo.setFont(table, GUIStyles.NORMAL);
		col.add(table);

		// ----------------------------------------
		// The navigation control
		// ----------------------------------------

		if (isPageable) {

			Row row = new Row();
			row.setAlignment(Alignment.ALIGN_CENTER);

			ETableNavigation tableNavigation = new ETableNavigation(tableDtaModel);
			row.add(tableNavigation);

			col.add(row);

		}

		return col;
	}

	// --------------------------------------------------------------------------------

	public static Component initTable(TestTableModel tableDtaModel, //
			TableColModel initTableColModel, boolean isPageable, int pageSize) {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);

		// ----------------------------------------
		// The table models
		// ----------------------------------------

		TableColModel tableColModel = initTableColModel;
		TableSelModel tableSelModel = new TableSelModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(pageSize);

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
		Estilo.setFont(table, GUIStyles.NORMAL);
		col.add(table);

		// ----------------------------------------
		// The navigation control
		// ----------------------------------------

		if (isPageable) {

			Row row = new Row();
			row.setAlignment(Alignment.ALIGN_CENTER);

			ETableNavigation tableNavigation = new ETableNavigation(tableDtaModel);
			row.add(tableNavigation);

			col.add(row);

		}

		return col;
	}

	// --------------------------------------------------------------------------------

	public static Component initTable(TestTableModel tableDtaModel, //
			TableColModel initTableColModel, boolean isPageable, //
			int pageSize, int fontSize) {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);

		// ----------------------------------------
		// The table models
		// ----------------------------------------

		TableColModel tableColModel = initTableColModel;
		TableSelModel tableSelModel = new TableSelModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(pageSize);

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
		Estilo.setFont(table, GUIStyles.NORMAL, fontSize);
		col.add(table);

		// ----------------------------------------
		// The navigation control
		// ----------------------------------------

		if (isPageable) {

			Row row = new Row();
			row.setAlignment(Alignment.ALIGN_CENTER);

			ETableNavigation tableNavigation = new ETableNavigation(tableDtaModel);
			row.add(tableNavigation);

			col.add(row);

		}

		return col;
	}

}
