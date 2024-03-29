package com.ulasoft.lanterncorpsacademy.paneles;

import java.sql.Date;

import lcaInterfaceDAO.IPlanetaDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.ImgLoad;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelMain extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private IPlanetaDO planeta;
	private Date fecha;
	private Label lblFechaValue;
	private Label lblSectorValue;
	private Label lblPlanetaValue;

	public PanelMain() {

		Column col = new Column();
		col.setCellSpacing(new Extent(10));

		Column colPane = new Column();
		colPane.setInsets(new Insets(10, 10, 10, 10));
		colPane.setCellSpacing(new Extent(10));
		Column colInf [] = new Column [3];
		for (int i = 0; i < colInf.length; i++) {
			colInf[i] = new Column();
		}

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setCellSpacing(new Extent(10));

		Grid grid = new Grid(2);
		grid.setBackground(Color.WHITE);

		Label lblImagen = new Label();
		lblImagen.setIcon(new ResourceImageReference(ImgLoad.panelMain( //
				app.getAtributos().getPersonaje()), //
				new Extent(200), new Extent(325)));
		grid.add(lblImagen);

		lblPlanetaValue = new Label("PL");
		lblSectorValue = new Label("00");
		lblFechaValue = new Label("Ult Ing");

		try {
			app.getAtributos().updatePanelMain(this);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		Label lblUbicacion = new Label("Ubicación Actual");
		Estilo.setFont(lblUbicacion, GUIStyles.BOLD);
		colInf[0].add(lblUbicacion);

		Estilo.setFont(lblPlanetaValue, GUIStyles.NORMAL);
		colInf[0].add(lblPlanetaValue);

		Estilo.setFont(lblSectorValue, GUIStyles.NORMAL);
		colInf[0].add(lblSectorValue);

		Label lblDueno = new Label("Dueño:");
		Estilo.setFont(lblDueno, GUIStyles.NORMAL);
		colInf[0].add(lblDueno);

		colPane.add(colInf[0]);

		Label lblEstadisticas = new Label("Estadísticas");
		Estilo.setFont(lblEstadisticas, GUIStyles.BOLD);
		colInf[1].add(lblEstadisticas);

		Label lblCombatesGanados = new Label("Combates Ganados:");
		Estilo.setFont(lblCombatesGanados, GUIStyles.NORMAL);
		colInf[1].add(lblCombatesGanados);

		Label lblCombatesPerdidos = new Label("Combates Perdidos:");
		Estilo.setFont(lblCombatesPerdidos, GUIStyles.NORMAL);
		colInf[1].add(lblCombatesPerdidos);

		Label lblPlanetasConquistados = new Label("Planetas Conquistados:");
		Estilo.setFont(lblPlanetasConquistados, GUIStyles.NORMAL);
		colInf[1].add(lblPlanetasConquistados);

		colPane.add(colInf[1]);

		Label lblUltimoAcceso = new Label("Último Acceso");
		Estilo.setFont(lblUltimoAcceso, GUIStyles.BOLD);
		colInf[2].add(lblUltimoAcceso);

		Estilo.setFont(lblFechaValue, GUIStyles.NORMAL);
		colInf[2].add(lblFechaValue);

		colPane.add(colInf[2]);

		grid.add(colPane);
		col.add(grid);

		Button btnPlanetaCasa = new Button("Definir Planeta Casa");
		btnPlanetaCasa.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnPlanetaCasa.setWidth(new Extent(160));
		btnPlanetaCasa.setHeight(new Extent(20));
		btnPlanetaCasa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnPlanetaCasaClicked();
			}
		});
		row.add(btnPlanetaCasa);

		Button btnAsignarDefensas = new Button("Asignar Defensas");
		btnAsignarDefensas.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAsignarDefensas.setWidth(new Extent(160));
		btnAsignarDefensas.setHeight(new Extent(20));
		btnAsignarDefensas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnAsignarDefensasClicked();
			}
		});
		row.add(btnAsignarDefensas);

		if (lblPlanetaValue.getText().equals("Planeta: " + getPlaneta().getNombre())) {

			btnPlanetaCasa.setEnabled(false);
			btnAsignarDefensas.setEnabled(false);

		}

		col.add(row);
		add(col);
	}

	// --------------------------------------------------------------------------------

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