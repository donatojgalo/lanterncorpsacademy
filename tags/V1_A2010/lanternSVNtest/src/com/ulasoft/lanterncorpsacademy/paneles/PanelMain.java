package com.ulasoft.lanterncorpsacademy.paneles;

import java.sql.Date;

import lcaInterfaceDAO.IPlanetaDO;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Font;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;

import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.ImgLoad;

@SuppressWarnings("serial")
public class PanelMain extends Panel {

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();
	private Label lblAlias;
	private IPlanetaDO planeta;
	private Date fecha;
	private Label lblFechaValue;
	private Label lblMisionesValue;
	private Label lblSectorValue;
	private Label lblPlanetaValue;

	public PanelMain() {
		Row row = new Row();
		row.setStyle(GUIStyles.STYLE3);
		// row.setCellSpacing(new Extent(250));
		// row.add(new Label(""));
		Grid grid = new Grid(2);
		grid.setBackground(Color.WHITE);
		Label lblImagen = new Label();
		lblImagen.setIcon(new ResourceImageReference(ImgLoad.panelMain(app
				.getAtributos().getPersonaje())//
				, new Extent(236), new Extent(360)));
		grid.add(lblImagen);
		Column col = new Column();
		lblAlias = new Label("alias");
		lblAlias.set(PROPERTY_FONT, Font.BOLD);
		lblAlias.set(PROPERTY_FONT, Color.BLACK);

	
		lblPlanetaValue = new Label("PL");
		lblSectorValue = new Label("00");
		lblFechaValue = new Label("Ult Ing");
		lblMisionesValue = new Label("00");

		LanternCorpsAcademyApp lca = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
				.getActive();
		Atributos atrib = lca.getAtributos();

		try {
			atrib.updatePanelMain(this);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		col.add(lblAlias);
		col.add(new Label("Ubicación"));
		col.add(new Label("Planeta:"));
		col.add(lblPlanetaValue);
		col.add(new Label("Sector:"));
		col.add(lblSectorValue);
		col.add(new Label("Estadísticas"));
		// col.add(new Label("Combates Ganados:"));
		// col.add(new Label("Combates Perdidos:"));
		col.add(new Label("Misiones Realizadas:"));
		col.add(lblMisionesValue);
		col.add(new Label("Ultimo Ingreso"));
		col.add(new Label("Fecha:"));
		col.add(lblFechaValue);

		grid.add(col);
		row.add(grid);
		row.set(PROPERTY_WIDTH, new Extent(700));
		row.set(PROPERTY_HEIGHT, new Extent(800));
		add(row);

		// setWidth(new Extent(400));
		// setHeight(new Extent(500));
	}



	// public PanelMain() {
	//
	// SplitPane splitPane= new
	// SplitPane(SplitPane.ORIENTATION_HORIZONTAL_LEFT_RIGHT);
	// splitPane.setBackground(Color.LIGHTGRAY);
	// splitPane.set(PROPERTY_WIDTH, new Extent(400));
	// splitPane.set(PROPERTY_HEIGHT, new Extent(300));
	//		
	// ContentPane contenPane = new ContentPane();
	// ImageMap imageMap = new ImageMap(new ResourceImageReference(
	// "com/ulasoft/lanterncorpsacademy/imagenes/GreenLanternRebirthHC1.jpg"));
	// imageMap.setWidth(new Extent(200));
	// imageMap.setHeight(new Extent(300));
	//	    
	// contenPane.add(imageMap);
	//	    
	// splitPane.add(contenPane);
	//		
	// ContentPane contentPane2 = new ContentPane();
	// Grid grid = new Grid(2);
	// Row row = new Row();
	//
	// Label lblUbicacion = new Label("Ubicacion:");
	//
	// Label lblPlaneta = new Label("PLaneta:");
	// lblPlanetaValue = new Label("PL");
	//
	// Label lblSector = new Label("Sector");
	// lblSectorValue = new Label(" ");
	//
	// Label lblFecha = new Label("Ultimo Ingreso:");
	// lblFechaValue = new Label("Ult Ing");
	//
	// lblUbicacion.setTextAlignment(Alignment.ALIGN_CENTER);
	// row.add(lblUbicacion);
	//		
	// LanternCorpsAcademyApp app = (LanternCorpsAcademyApp)
	// LanternCorpsAcademyApp.getActive();
	// Atributos atrib = app.getAtributos();
	//
	// // try {
	// // atrib.updatePanelMain(this);
	// // } catch (Exception e) {
	// // e.printStackTrace();
	// // }
	//				
	// grid.add(lblPlaneta);
	// grid.add(lblPlanetaValue);
	// grid.add(lblSector);
	// grid.add(lblSectorValue);
	// grid.add(lblFecha);
	// grid.add(lblFechaValue);
	//			
	// grid.setStyle(GUIStyles.DEFAULT_STYLE);
	// grid.setHeight(new Extent(300));
	// contentPane2.add(grid);
	// splitPane.add(contentPane2);
	// add(splitPane);
	//		
	// }

	public Label getLblAlias() {
		return lblAlias;
	}



	public void setLblAlias(Label lblAlias) {
		this.lblAlias = lblAlias;
	}



	public IPlanetaDO getPlaneta() {
		return planeta;
	}

	public void setPlaneta(IPlanetaDO planeta) {
		this.planeta = planeta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Label getLblFechaValue() {
		return lblFechaValue;
	}

	public void setLblFechaValue(Label lblFechaValue) {
		this.lblFechaValue = lblFechaValue;
	}

	public Label getLblMisionesValue() {
		return lblMisionesValue;
	}

	public void setLblMisionesValue(Label lblMisionesValue) {
		this.lblMisionesValue = lblMisionesValue;
	}

	public Label getLblSectorValue() {
		return lblSectorValue;
	}

	public void setLblSectorValue(Label lblSectorValue) {
		this.lblSectorValue = lblSectorValue;
	}

	public Label getLblPlanetaValue() {
		return lblPlanetaValue;
	}

	public void setLblPlanetaValue(Label lblPlanetaValue) {
		this.lblPlanetaValue = lblPlanetaValue;
	}

}