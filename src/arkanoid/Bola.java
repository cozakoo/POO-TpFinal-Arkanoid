package arkanoid; 

public class Bola extends Elemento{
	
	public Bola() {

		this.setVelocidad(4);
		
		this.setDireccion(305);
	}
	
	public void jugar () {
		this.avanzar();
	}
	  
	@Override
	public void chocar(Elemento elemento) {
		if (elemento instanceof Bloque || elemento instanceof BloqueHorizontal || 
				elemento instanceof BloqueBonus){
			this.rebotar(elemento); 
		} 
		/*if(elemento instanceof BloqueDiamante) {
			this.setDireccion(direccion);
		}*/
		if (elemento instanceof Bomba) {
			this.setVelocidad(this.getVelocidad()+ (this.getVelocidad()/3));
		}	
		if (elemento instanceof Misil) {
			this.setVelocidad(this.getVelocidad()+ (this.getVelocidad()/2));
		}	
		if(elemento instanceof Paleta) {
			if(this.getDireccion()>0 && this.getDireccion()<90) {
				this.setDireccion(360-this.getDireccion());
			}
			if(this.getDireccion()<180 && this.getDireccion()>90) {
				this.setDireccion(180+(180-this.getDireccion()));
			}
		}
	}
	
	
	public void rebotar (Elemento elemento) {
		boolean listo = false;
		AdministradorJuego admin = AdministradorJuego.getInstance();
		if(this.getDireccion()<360 && this.getDireccion()>270 )  {
			if (this.getPosX() >= elemento.getPosX() && this.getPosX() <= elemento.getPosX() + elemento.getAncho() 
			&& this.getPosY()>=elemento.getPosY() && !listo){	
				this.setDireccion(0+(360-this.getDireccion()));
				listo = true;
			}
			if(this.getPosY() >= elemento.getPosY() && this.getPosY() <= elemento.getPosY()+elemento.getAlto()
			&& this.getPosX()>= elemento.getPosX() && !listo) {
					this.setDireccion(180+(360-this.getDireccion()));
					listo = true;
			}
		}
		if(this.getDireccion()<270 && this.getDireccion()>180 ) {
			if (this.getPosX() >= elemento.getPosX() && this.getPosX() <= elemento.getPosX() + elemento.getAncho()
			&& this.getPosY()<=elemento.getPosY()+elemento.getAlto() && !listo){								
					this.setDireccion(180-(this.getDireccion()-180));
					listo = true;
			}
			if(this.getPosY() >= elemento.getPosY() && this.getPosY() <=  elemento.getPosY()+elemento.getAlto()
			&& this.getPosX()<= elemento.getPosX() && !listo) {							
					this.setDireccion(360-(this.getDireccion()-180));
					listo = true;
			}
		}
		if(this.getDireccion()<180 && this.getDireccion()>90 ) {
			if (this.getPosX() >= elemento.getPosX() && this.getPosX() <= elemento.getPosX() + elemento.getAncho()
			&& this.getPosY()<=elemento.getPosY() && !listo){								
					this.setDireccion(180+(180-this.getDireccion()));
					listo = true;
			}
			if(this.getPosY() >= elemento.getPosY() && this.getPosY() <= elemento.getPosY()+ elemento.getAlto()
			&& this.getPosX()>= elemento.getPosX()+elemento.getAncho() && !listo) {								
				this.setDireccion(0+(180-this.getDireccion()));
				listo = true;
			}
		}
		if(this.getDireccion()<90 && this.getDireccion()>0 ) {
			if (this.getPosX() <= elemento.getPosX() && this.getPosX() <= elemento.getPosX() + elemento.getAncho()
			&& this.getPosY()>=elemento.getPosY()&& !listo){
				this.setDireccion(360-this.getDireccion());
				listo = true;
			}
			if(this.getPosY() >= elemento.getPosY() && this.getPosY() <= elemento.getPosY()+ elemento.getAlto()
			&& this.getPosX()>= elemento.getPosX()+elemento.getAlto()&& !listo) {
				this.setDireccion(180-this.getDireccion());
				listo = true;
			}
		}
	}

	

	public void chocoPared(Boolean chocoDerecha, boolean chocoIzquierda, boolean chocoArriba, boolean chocoAbajo) {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		boolean listo = false;
		if(chocoArriba == true && !listo) {
			if(this.getDireccion()<360 && this.getDireccion()>270) {							//techo para la derecha
					this.setDireccion(0+(360-this.getDireccion()));
					listo = true;
			}
			if(this.getDireccion()>180 && this.getDireccion()<270) {//techo para izq
					this.setDireccion(180-(this.getDireccion()-180));
					listo = true;
			}
		}
		if(chocoDerecha == true && !listo) {
			if(this.getDireccion()<360 && this.getDireccion()>270) {//pared derecha
					this.setDireccion(180+(360-this.getDireccion()));
					listo = true;
			}
			if(this.getDireccion()>0 && this.getDireccion()<90) {	//pared derecha para abajo
					this.setDireccion(180-this.getDireccion());
					listo = true;
			}
		}
		if(chocoIzquierda == true && !listo) {
			if(this.getDireccion()>180 && this.getDireccion()<270) {//pared izquierda
					this.setDireccion(360-(this.getDireccion()-180));
					listo = true;
			}
			if(this.getDireccion()<180 && this.getDireccion()>90) {	//pared izq para abajo
					this.setDireccion(180-this.getDireccion());
					listo = true;
			}
		}
		if(chocoAbajo == true && !listo) {
			admin.getJugador().setVidas(admin.getJugador().getVidas()-1);
			admin.getPaleta().setPosX((admin.getEscenario().getAncho() / 2) - 15);
			admin.getPaleta().setPosY(admin.getEscenario().getAlto() - 200);
			this.setPosX(admin.getEscenario().getAncho() / 2);
			this.setPosY(480);
			this.setAlto(10);
			this.setAncho(10);
			this.setVelocidad(4);
			admin.getJugador().setMisiles(2);
		}
		
	}
	
	
	
	@Override
	public void morir() {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		this.setPosX(admin.getEscenario().getAncho()/2);
		this.setPosY(35);
		this.setVelocidad(5);
		admin.getPaleta().morir();
	}
	
	
	
	
}
