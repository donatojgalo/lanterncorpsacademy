package com.ulasoft.lanterncorpsacademy.paneles;

import java.awt.Font;
import java.sql.SQLException;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.PasswordField;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Registro;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

import echopoint.layout.HtmlLayoutData;

@SuppressWarnings("serial")
public class PanelRegistro1 extends Panel {

	public HtmlLayoutData hld = new HtmlLayoutData("main");
	private IUsuarioDO usuario;
	private IPersonajeDO personaje;
	private TextField txtAlias;
	private TextField txtNombre;
	private TextField txtCorreo;
	private PasswordField fldPass;
	private PasswordField fldConfirmPass;
	private Grid grid;
	private Column col;
	private Row errorRow;

	Desktop desktop;
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public PanelRegistro1(IUsuarioDO usuarioNuevo, IPersonajeDO personajeNuevo)
			throws Exception {

		usuario = usuarioNuevo;
		personaje = personajeNuevo;

		Row row1 = new Row();
		row1.setStyle(GUIStyles.STYLECENTERROW);

		col = new Column();
		col.setInsets(new Insets(5, 5, 5, 5));
		col.setCellSpacing(new Extent(20));
		col.setBackground(Color.WHITE);
		col.setStyle(GUIStyles.STYLECENTERROW);

		Label lblTitle = new Label("REGISTRO DE USUARIO");
		lblTitle.setTextAlignment(Alignment.ALIGN_CENTER);
		col.add(lblTitle);

		Label lblSubTitle = new Label("Datos Personales:");
		lblSubTitle.setTextAlignment(Alignment.ALIGN_CENTER);
		col.add(lblSubTitle);

		grid = new Grid();
		grid.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));

		Label lblAlias = new Label("Nombre de Usuario");
		grid.add(lblAlias);
		txtAlias = new TextField();
		txtAlias.setToolTipText("Nombre con el que otros jugadores te verán en el universo.");
		txtAlias.setWidth(new Extent(400));
		txtAlias.setText(personaje.getAlias());
		grid.add(txtAlias);

		Label lblNombre = new Label("Nombre");
		grid.add(lblNombre);
		txtNombre = new TextField();
		txtNombre.setWidth(new Extent(400));
		txtNombre.setText(usuario.getNombre());
		grid.add(txtNombre);

		Label lblCorreo = new Label("Correo");
		grid.add(lblCorreo);
		txtCorreo = new TextField();
		txtCorreo.setWidth(new Extent(400));
		txtCorreo.setText(usuario.getCorreo());
		grid.add(txtCorreo);

		Label lblPass = new Label("Contraseña");
		grid.add(lblPass);
		fldPass = new PasswordField();
		fldPass.setWidth(new Extent(400));
		grid.add(fldPass);

		Label lblConfirmPass = new Label("Confirmar Contraseña");
		grid.add(lblConfirmPass);
		fldConfirmPass = new PasswordField();
		fldConfirmPass.setWidth(new Extent(400));
		grid.add(fldConfirmPass);

		grid.setColumnWidth(1, new Extent(800));
		col.add(grid);

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		Button btnNext = new Button("Siguiente");
		btnNext.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnNextClicked();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		Button btnCancel = new Button("Cancelar");
		btnCancel.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnCancelClicked();
			}
		});

		row.add(btnCancel);
		row.add(btnNext);
		col.add(row);

		row1.add(col);
		add(row1);

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	private void btnNextClicked() throws ClassNotFoundException, Exception {

		usuario.setNombre(txtNombre.getText());
		usuario.setCorreo(txtCorreo.getText());

		if ((txtAlias.getText()) == "") {
			Desktop d = app.getDesktop();
			d.setWindowPaneEmergente("Escoge el Alias para tu Personaje!");
			return;
		}

		personaje.setAlias(txtAlias.getText());

		if (Registro.verificarAlias(personaje.getAlias())) {
			Desktop d = app.getDesktop();
			d.setWindowPaneEmergente("Ya existe un jugador con ese Alias.");
			return;
		}

		if (!(fldConfirmPass.getText().equals(fldPass.getText()))) { // JUL:defensive..
			if (col.getComponentCount() > 3) {
				System.out.println("COL:" + col.getComponentCount());
				col.remove(errorRow);
			}
			errorRow = new Row();
			Label lblErr = new Label("Por favor confirme su contraseña.");
			lblErr.set(PROPERTY_FONT, Font.BOLD);
			errorRow.add(lblErr);
			errorRow.setAlignment(Alignment.ALIGN_CENTER);
			col.add(errorRow);
			fldPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			fldConfirmPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			return;
		}

		try {

			if (Registro.verificarCorreo(usuario.getCorreo())) {
				if (col.getComponentCount() > 3) {
					System.out.println("COL:" + col.getComponentCount());
					col.remove(errorRow);
				}
				errorRow = new Row();
				errorRow.add(new Label("Ya existe una cuenta con ese correo."));
				col.add(errorRow);
				txtCorreo.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Si no hay campos vacíos proceder a la siguiente etapa del registro

		if (!(checkEmptyFields())) {
			usuario.setClave(fldPass.getText());
			PanelRegistro2 pnlregistro2 = new PanelRegistro2(usuario, personaje);
			desktop = app.getDesktop();
			desktop.setPanelCentral(pnlregistro2);
		}

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	private void btnCancelClicked() {

		Desktop d = app.getDesktop();
		PanelLogin pnlMain = new PanelLogin();
		d.setPanelCentral(pnlMain);

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	private boolean checkEmptyFields() {

		boolean flg = false;
		if (txtAlias.getText() == "") {
			txtAlias.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			flg = true;
		}

		if (txtNombre.getText() == "") {
			txtNombre.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			flg = true;
		}

		if (txtCorreo.getText() == "") {
			txtCorreo.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			flg = true;
		}
		if (fldPass.getText() == "") {
			fldPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			flg = true;
		}
		if (fldConfirmPass.getText() == "") {
			fldConfirmPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			flg = true;
		}

		if (flg) {
			if (col.getComponentCount() > 3) {
				System.out.println("COL:" + col.getComponentCount());
				col.remove(errorRow);
			}
			errorRow = new Row();
			Label lblErr = new Label("Todos los campos son obligatorios.");
			lblErr.set(PROPERTY_FONT, Font.BOLD);
			errorRow.add(lblErr);
			errorRow.setAlignment(Alignment.ALIGN_CENTER);
			col.add(errorRow);
			return true;
		}

		return false;
	}

}
