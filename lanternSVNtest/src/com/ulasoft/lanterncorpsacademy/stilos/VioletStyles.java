package com.ulasoft.lanterncorpsacademy.stilos;

import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.MutableStyle;
import nextapp.echo.app.Style;

public class VioletStyles {

	public static final Style DEFAULT_STYLE_VIOLETA;
	static {
		MutableStyle style = (MutableStyle) GUIStyles.DEFAULT_STYLE;

		style.set(Button.PROPERTY_FOCUSED_BACKGROUND, GUIStyles.COLORVIOLETA);
		style.set(Button.PROPERTY_FOCUSED_BORDER, new Border(1, GUIStyles.BORDEVIOLETA, Border.STYLE_SOLID));

		DEFAULT_STYLE_VIOLETA = style;
	}

	public static final Style STYLE_VIOLETA;
	static {
		MutableStyle style = (MutableStyle) GUIStyles.STYLE;

		style.set(Button.PROPERTY_FOCUSED_BACKGROUND, GUIStyles.COLORVIOLETA);
		style.set(Button.PROPERTY_FOCUSED_BORDER, new Border(1, GUIStyles.BORDEVIOLETA, Border.STYLE_SOLID));

		style.set(Button.PROPERTY_ROLLOVER_BACKGROUND, GUIStyles.ROLLOVERVIOLETA);
		style.set(Button.PROPERTY_ROLLOVER_BORDER, new Border(1, Color.BLACK, Border.STYLE_SOLID));

		STYLE_VIOLETA = style;
	}
}
