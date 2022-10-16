package arkanoid;

public class BonusMisil extends Elemento {	
		
		public BonusMisil (int posX, int posY, int alto, int ancho) {
			this.setPosX(posX);
			this.setPosY(posY);
			this.setAlto(alto);
			this.setAncho(ancho);
		}
		
		@Override
		public void jugar() {
			AdministradorJuego admin = AdministradorJuego.getInstance();
			admin.getJugador().setMisiles(admin.getJugador().getMisiles()+5);
			this.morir();
		}

		public void morir () {
			this.setEstaVivo(false);
		}	
}
