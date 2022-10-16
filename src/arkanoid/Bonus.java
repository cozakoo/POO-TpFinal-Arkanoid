package arkanoid;

import java.util.Random;


public class Bonus extends Elemento{
	private int posX;
	private int posY;
	private int alto;
	private int ancho;
	
	public Bonus(int posX, int posY, int alto, int ancho) {
		this.posX = posX;
		this.posY = posY;
		this.alto = alto;
		this.ancho = ancho;
	}
	
	
	@Override
	public void jugar() {
		this.avanzar();
	}
	
	public void avanzar() {
		this.setPosY(this.getPosY()+this.getVelocidad());
	}
	
	public void morir() {
		this.setEstaVivo(false);

	}
	
	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public int getAlto() {
		return alto;
	}


	public void setAlto(int alto) {
		this.alto = alto;
	}


	public int getAncho() {
		return ancho;
	}


	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	@Override
	public void chocar(Elemento elemento) {
		if (elemento instanceof Paleta) {
			this.darBeneficio();
			this.morir();
		}		
	}
	
	public void darBeneficio () {
		Random aleatorio = new Random();
		int numero = aleatorio.nextInt(3);
		switch (numero) {
			case 0 :
				BonusBola bonusBola = new BonusBola(this.getPosX(), this.getPosY(), 0,0);
				bonusBola.jugar();
			case 1 :
				BonusMisil bonusMisil = new BonusMisil(this.getPosX(), this.getPosY(), 0,0);
				bonusMisil.jugar();
			case 2 :
				BonusPaleta bonusPaleta = new BonusPaleta(this.getPosX(), this.getPosY(), 0,0);
				bonusPaleta.jugar();
		}
	}
}

