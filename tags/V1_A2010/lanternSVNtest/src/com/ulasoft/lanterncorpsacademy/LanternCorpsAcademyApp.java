package com.ulasoft.lanterncorpsacademy;

import com.ulasoft.lanterncorpsacademy.logic.Atributos;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Window;

@SuppressWarnings("serial")
public class LanternCorpsAcademyApp extends ApplicationInstance {

  public Desktop desktop;
  
  public Atributos atributos;

  public Window init() {
    Window window = new Window();
    window.setTitle("Lantern Corps Academy");
    desktop = new Desktop();
    window.setContent(getDesktop());
    return window;
  }

  public Desktop getDesktop() {
    return desktop;
  }

  // Esto funciona como una especie de "singleton" pero en lugar
  // de ser para todo el programa es una especie de "singleton"
  // por cada usuario, es decir, tiene una instancia de atributos
  // para cada usuario segun corresponda (o null si no ha hecho login,
  // ver panel login)
  public Atributos getAtributos() {
    return atributos;
  }

  public void setAtributos(Atributos atributos) {
    this.atributos = atributos;
  }
}