package arkanoid;

public class Misil extends Elemento{
	private int posX;
	private int posY;
	private int alto;
	private int ancho;
	
	
	public Misil() {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		this.setPosX(admin.getPaleta().getPosX()+(admin.getPaleta().getAncho()/2));
		this.setPosY(admin.getPaleta().getPosY());
		this.setAlto(7);
		this.setAncho(3);
		this.setVelocidad(9);
	}
	
	@Override
	public void jugar() {
		this.avanzar();
	}
	
	public void avanzar() {
		this.setPosY(this.getPosY()-this.getVelocidad());
	}
	
	
	
	@Override
	public void chocar(Elemento elemento) {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		if(elemento instanceof Bola) {
			admin.getBola().setVelocidad(admin.getBola().getVelocidad()+(admin.getBola().getVelocidad())/2);
		}
		this.morir();
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
	public void chocarPared() {
		if(this.getPosY()==0) {
			this.morir();
		}
	}
	
	@Override
	public void morir() {
		this.setEstaVivo(false);
	}
	
	
	
	
	
	
	
	
	
	
}
