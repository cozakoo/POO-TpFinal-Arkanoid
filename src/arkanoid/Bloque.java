package arkanoid;

public class Bloque extends Elemento{
	private int posX;
	private int posY;
	private int alto;
	private int ancho;
	
	public Bloque (int posX, int posY, int alto, int ancho){
		this.setPosX(posX);
		this.setPosY(posY);
		this.setAlto(alto);
		this.setAncho(ancho);
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
	
	public void jugar() {
		
	}
	
	@Override
	public void chocar(Elemento elemento) {
		if (elemento instanceof Bola) {
			this.morir();
		}
		if (elemento instanceof Misil) {
			this.morir();
		}
	}
	
	@Override
	public void chocarPared() {
		
	}
	
	@Override
	public void morir() {
		this.setEstaVivo(false);
		AdministradorJuego admin = AdministradorJuego.getInstance();
		admin.getJugador().setPuntos(admin.getJugador().getPuntos()+100);
	}
	
}



