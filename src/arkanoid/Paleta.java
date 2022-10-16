package arkanoid;

public class Paleta extends Elemento{
	
	
	public Paleta() {
		this.setAlto(10);
		this.setAncho(60);
		this.setDireccion(0);
		this.setVelocidad(15);
	}
	
	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Override
	public void chocar(Elemento elemento) {
		if (elemento instanceof Bola) {
			//no hace nada
		}
		if (elemento instanceof Bomba) {
			this.setAncho(this.getAncho()- (this.getAncho()/5));
		}
		
	}
	
	@Override
	public void chocarPared() {
		
	}
	
	@Override
	public void morir() {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		this.setPosX(admin.getEscenario().getAncho()/2);
	}
	
	public void dispararMisil() {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		if(admin.getJugador().getMisiles()!=0) {
			Misil misil = new Misil();
			admin.cargarElemento(misil);
			admin.getJugador().setMisiles(admin.getJugador().getMisiles()-1);
		}
		
	}
	
	
	
}
