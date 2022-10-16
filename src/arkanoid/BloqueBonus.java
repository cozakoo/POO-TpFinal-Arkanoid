package arkanoid;

public class BloqueBonus extends Bloque {
	
	
	
	public BloqueBonus(int posX, int posY, int alto, int ancho) {
		
		super(posX, posY, alto, ancho);
	}
	
	
	public void jugar() {
		
	}
	
	
	
	public void morir() {
		this.setEstaVivo(false);
		Bonus nuevoBonus = new Bonus(this.getPosX(), this.getPosY(),8,8);
		AdministradorJuego admin = AdministradorJuego.getInstance();
		admin.cargarElemento(nuevoBonus);
		admin.getJugador().setPuntos(admin.getJugador().getPuntos()+100);
	}
	
	@Override
	public void chocarPared() {
		
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
	
	
}
