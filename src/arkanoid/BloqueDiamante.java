package arkanoid;

public class BloqueDiamante extends Bloque{
	private int golpesRestantes = 2;
	
	public BloqueDiamante(int posX, int posY, int alto, int ancho) {
		super(posX, posY, alto, ancho);
	}
	
	@Override
	public void jugar() {
		
	}



	public int getGolpesRestantes() {
		return golpesRestantes;
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
	@Override
	public void chocar(Elemento elemento) {
		if (this.golpesRestantes == 1) {
			if (elemento instanceof Bola) {
				this.morir();
			}
			if (elemento instanceof Misil) {
				this.morir();
			}
		}
		else {
			this.setGolpesRestantes(this.getGolpesRestantes()-1); 
		} 
			
	}
	
	public void setGolpesRestantes(int golpesRestantes) {
		this.golpesRestantes = golpesRestantes;
	}
	
}
