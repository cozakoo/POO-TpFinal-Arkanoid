package arkanoid;

import java.awt.Rectangle;

public abstract class Elemento {
	private int posX;
	private int posY;
	private int alto;
	private int ancho;
	private Boolean estaVivo = true;
	private int velocidad = 5;
	private int direccion;
	private Tamanio tamanio;
	private Posicion posicion;
	private Boolean chocoDerecha;
	private Boolean chocoIzquierda;
	private Boolean chocoArriba;
	private Boolean chocoAbajo;
	
	
	public Elemento() {
		
	}
	
	public Rectangle getArea() {
		return new Rectangle(this.getPosX(),this.getPosY(),this.getAncho(), this.getAlto());
	}

	public void chocoPared(Boolean chocoDerecha, boolean chocoIzquierda, boolean chocoArriba, boolean chocoAbajo) {
		
	}
	
	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public void avanzar() {
		double angulo = Math.toRadians(this.direccion);
		int deltaX = (int)(Math.cos(angulo) * this.velocidad);
		int deltaY = (int)(Math.sin(angulo) * this.velocidad);
		this.posX += deltaX;
		this.posY += deltaY;
	}
	
	public Boolean getEstaVivo() {
		return estaVivo;
	}


	public void setEstaVivo(Boolean estaVivo) {
		this.estaVivo = estaVivo;
	}


	public int getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}


	public abstract void jugar();
		
	
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
	
	public void chocarPared() {
		
	}
	
	public void chocar(Elemento elemento) {
		
	}
	
	public void morir() {
		
	}
	
	public void rebotar(Elemento elemento) {
		
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Boolean getChocoDerecha() {
		return chocoDerecha;
	}

	public void setChocoDerecha(Boolean chocoDerecha) {
		this.chocoDerecha = chocoDerecha;
	}

	public Boolean getChocoIzquierda() {
		return chocoIzquierda;
	}

	public void setChocoIzquierda(Boolean chocoIzquierda) {
		this.chocoIzquierda = chocoIzquierda;
	}

	public Boolean getChocoArriba() {
		return chocoArriba;
	}

	public void setChocoArriba(Boolean chocoArriba) {
		this.chocoArriba = chocoArriba;
	}

	public Boolean getChocoAbajo() {
		return chocoAbajo;
	}

	public void setChocoAbajo(Boolean chocoAbajo) {
		this.chocoAbajo = chocoAbajo;
	}
	
	
	
	
	
}
