package com.ulasoft.lanterncorpsacademy.menus;

import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.paneles.PanelAboutGame;
import com.ulasoft.lanterncorpsacademy.paneles.PanelAsignarPrecio;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMedia;
import com.ulasoft.lanterncorpsacademy.paneles.PanelRanking;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class MenuInicial extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	public MenuInicial() {

		Row row = new Row();
		row.setStyle(GUIStyles.STYLECENTERROW);

		Column col = new Column();
		col.setStyle(GUIStyles.STYLECENTERROW);

		Button btnRanking = new Button("Ver Clasificación");
		btnRanking.setStyle(GUIStyles.DEFAULT_STYLE);
		btnRanking.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRankingClicked();
			}
		});
		col.add(btnRanking);
		
		Button btnMedia = new Button("Multimedia");
		btnMedia.setStyle(GUIStyles.DEFAULT_STYLE);
		btnMedia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnMediaClicked();
			}
		});
		col.add(btnMedia);

		Button btnAboutGame = new Button("Acerca del Juego");
		btnAboutGame.setStyle(GUIStyles.DEFAULT_STYLE);
		btnAboutGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAboutGameClicked();
			}
		});
		col.add(btnAboutGame);

		Button btnPrueba = new Button("Prueba AP");
		btnPrueba.setStyle(GUIStyles.DEFAULT_STYLE);
		btnPrueba.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnPruebaClicked();
			}
		});
		col.add(btnPrueba);

		row.add(col);
		add(row);
		
	}

	// ------------------------------------------------------------------------------

	private void btnRankingClicked() {

		PanelRanking pnlMain = new PanelRanking();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}
	
	// --------------------------------------------------------------------------------

	private void btnMediaClicked() {

		PanelMedia pnlMain = new PanelMedia();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------
	
	private void btnAboutGameClicked() {

		PanelAboutGame pnlMain = new PanelAboutGame("1");
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}

	private void btnPruebaClicked() {

		PanelAsignarPrecio pnlMain = new PanelAsignarPrecio();
		Desktop d = app.getDesktop();
		d.setWindowData(pnlMain, "Asignar Precio", 250, 370);

	}

}