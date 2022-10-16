package arkanoid;

public class BonusPaleta extends Elemento {
	
	public BonusPaleta (int posX, int posY, int alto, int ancho) {
		this.setPosX(posX);
		this.setPosY(posY);
		this.setAlto(alto);
		this.setAncho(ancho);
	}
	
	@Override
	public void jugar() {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		admin.getPaleta().setAncho(admin.getPaleta().getAncho()+admin.getPaleta().getAncho()/3);
		this.morir();
	}

	public void morir () {
		this.setEstaVivo(false);
	}
	
	@Override
	public void chocar(Elemento elemento) {
		
	}
	
	@Override
	public void chocarPared() {
	
	}
	
	
}
