package arkanoid;

public class BonusBola extends Elemento {
	
	
	public BonusBola (int posX, int posY, int alto, int ancho) {
		this.setPosX(posX);
		this.setPosY(posY);
		this.setAlto(alto);
		this.setAncho(ancho);
	}
	
	@Override
	public void jugar() {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		admin.getBola().setVelocidad(admin.getBola().getVelocidad()-(admin.getBola().getVelocidad()/5)*2);
		this.morir();
	}

	public void morir () {
		this.setEstaVivo(false);
	}

}

