package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;

@SuppressWarnings("serial")
public class PanelSelectAtacar extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	public PanelSelectAtacar() {

		setInsets(new Insets(2, 2, 2, 2));
		Column col = new Column();
		col.setBackground(Color.WHITE);

		Button btnAtacarNPC = new Button("ATACAR NPC");
		btnAtacarNPC.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAtacarNPC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnAtacarNPCClicked();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		Button btnAtacar = new Button("ATACAR Personaje");
		btnAtacar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAtacar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAtacarClicked();
			}
		});

		if(app.getAtributos().getPersonaje().getPlanetaRef().getRefIdent() == //
			app.getAtributos().getPersonaje().getClaseLinternaRef().getRefIdent()){

			Desktop d = app.getDesktop();
			btnAtacarNPC.setEnabled(false);
			btnAtacar.setEnabled(false);
			Row row = new Row();
			Label lblTitle = new Label("No Puedes Atacar");
			d.setWindowPaneEmergente("No Puedes Atacar porque te encuentras en el Planeta Base");
			row.add(lblTitle);
			row.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
			col.add(row);
		}

		Row row = new Row();
		row.add(btnAtacarNPC);
		row.add(btnAtacar);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		add(col);

	}

	protected void btnAtacarNPCClicked() throws Exception {

		Desktop d = app.getDesktop();
		PanelAtacarNPC pnlMain = new PanelAtacarNPC();
		d.setPanelCentral(pnlMain);

	}

	protected void btnAtacarClicked(){		

		Desktop d = app.getDesktop();
		PanelAtacarPersonaje pnlMain = new PanelAtacarPersonaje();
		d.setPanelCentral(pnlMain);

	}

}
