package arkanoid;

public class BloqueHorizontal extends Bloque{
	
	public BloqueHorizontal(int posX, int posY, int alto, int ancho) {
		super(posX, posY, alto, ancho);
	}
	
	@Override
	public void jugar() {
	
		this.avanzar();
	}
	
	
	public void morir() {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		this.setEstaVivo(false);
		Bomba bomba = new Bomba(this.getPosX(),this.getPosY(),5,5);
		admin.getElementos().add(bomba);

	}
	
	@Override
	public void chocarPared() {
		this.setDireccion(this.getDireccion()+180);
	}
	
	@Override
	public void avanzar() {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		this.setVelocidad(4);
		if(this.getDireccion()==0) {
			this.setPosX(this.getPosX()+this.getVelocidad());
			if((this.getPosX()+this.getAncho())==(admin.getEscenario().getAncho())) {
				this.setDireccion(180);
			}
		}
		if(this.getDireccion()==180) {
			this.setPosX(this.getPosX()-this.getVelocidad());
			if(this.getPosX()==0)
				this.setDireccion(0);
		}
	}
	
}
