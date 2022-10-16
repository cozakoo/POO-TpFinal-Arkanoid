package arkanoid.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import arkanoid.AdministradorJuego;
import arkanoid.Bloque;
import arkanoid.BloqueDiamante;
import arkanoid.BloqueHorizontal;
import arkanoid.Bola;
import arkanoid.Bomba;
import arkanoid.Bonus;
import arkanoid.Elemento;
import arkanoid.Misil;
import arkanoid.Paleta;

public class Pantalla extends Canvas implements KeyListener {

	private AdministradorJuego admin;
	private BufferStrategy stragegy;
	
	public Pantalla(){
		this.addKeyListener(this);
		
	}

	private BufferStrategy getStragegy() {
		if (this.stragegy == null && this.isVisible()) {
			
			this.createBufferStrategy(2);
			this.stragegy = this.getBufferStrategy();
		}
		
		return this.stragegy;
	}

	@Override
	public void paint(Graphics arg0) {
		mostrar();
		System.out.println("mostrando");
	}
	
	@Override
	public Dimension getPreferredSize() {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		return new Dimension(admin.getEscenario().getAncho(),admin.getEscenario().getAlto());
	}
	
	public void mostrar() {		
		AdministradorJuego admin = AdministradorJuego.getInstance();
		if (this.getStragegy() == null)return;
		Graphics g = this.stragegy.getDrawGraphics(); //this.getGraphics();		
		g.clearRect(0,  0, this.getWidth(), this.getHeight());
		
		for(int i = 0; i < admin.getElementos().size(); i++) {
			Elemento e = (Elemento)admin.getElementos().get(i);
			Rectangle r = e.getArea();
			if(e instanceof Bloque) {
				g.setColor(Color.red);
 			}
			if (e instanceof Bomba) {
				g.setColor(Color.red);
			}
			if(e instanceof Bonus) {
				g.setColor(Color.magenta); 
			}
			if(e instanceof Misil) {
				g.setColor(Color.yellow);
 			}
			if(e instanceof BloqueDiamante) {
				g.setColor(Color.green);
			}
			if(e instanceof BloqueHorizontal) {
				g.setColor(Color.CYAN);
			}
			g.fillRect((int)r.getX(), (int)r.getY(),(int)r.getWidth(),  (int)r.getHeight());
			//g.setColor(Color.red);
			//g.drawString(e.getClass().getName(), e.getPosX(), e.getPosY());
		}	
		for(int i = 0; i < admin.getElementos().size(); i++) {
			Elemento e = (Elemento)admin.getElementos().get(i);
			if(e instanceof Paleta) {
				g.setColor(Color.BLUE);
				g.fillRoundRect(e.getPosX(), e.getPosY(),e.getAncho(),e.getAlto(), 15, 15);
			}
			if(e instanceof Bola) {
				g.setColor(Color.yellow);
				g.fillOval(e.getPosX(), e.getPosY(), e.getAlto(), e.getAncho());
			}
		}
		stragegy.show();
		
	}
	
 	
	public AdministradorJuego getModelo() {
		return admin;
	}


	public void setAdministradorJuego(AdministradorJuego admin) {
		this.admin = admin;
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
			
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
