package arkanoid;

public class Bomba extends Elemento{
	private int posX;
	private int posY;
	private int alto;
	private int ancho;
	
	
	public Bomba(int posX, int posY, int alto, int ancho) {
		this.setPosX(posX);
		this.setPosY(posY);
		this.setAlto(alto);
		this.setAncho(ancho);
	}

	
	@Override
	public void jugar() {
		this.avanzar();	
	}

	
	public void avanzar() {
		this.setPosY(this.getPosY()+this.getVelocidad());
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
		if(elemento instanceof Bola || elemento instanceof Paleta) {
			this.setAlto(10);
			this.setAlto(10);
			this.morir();
		}
		
	}
	
	
	@Override
	public void chocarPared() {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		if(this.getPosY()==admin.getEscenario().getAlto()) {
			this.setAlto(10);
			this.setAlto(10);
			this.morir();
		}
	}
	
	@Override
	public void morir() {
		// TODO Auto-generated method stub
		super.morir();
	}
	
	
	
	
	
	
	
}
