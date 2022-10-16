package arkanoid;


public class Escenario {
	private int alto;
	private int ancho;
	

	public Escenario () {
		this.alto = 700;
		this.ancho = 600;
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

	public void crear() {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		//fila 1
		Bloque bloque19 = new Bloque(65,100,15, 40);
		admin.cargarElemento(bloque19);
		Bloque bloque20 = new Bloque(110,100,15, 40);
		admin.cargarElemento(bloque20);
		Bloque bloque21 = new Bloque(155,100,15, 40);
		admin.cargarElemento(bloque21);
		Bloque bloque1 = new Bloque(200,100,15, 40);
		admin.cargarElemento(bloque1);
		Bloque bloque2 = new Bloque(245,100,15,40);
		admin.cargarElemento(bloque2);
		Bloque bloque3 = new Bloque(290,100,15,40);
		admin.cargarElemento(bloque3);
		BloqueBonus bloque8 = new BloqueBonus(335,100,15,40);
		admin.cargarElemento(bloque8);
		BloqueBonus bloque5 = new BloqueBonus(380,100,15, 40);
		admin.cargarElemento(bloque5);
		Bloque bloque6 = new Bloque(425,100,15,40);
		admin.cargarElemento(bloque6);
		Bloque bloque7 = new Bloque(470,100,15,40);
		admin.cargarElemento(bloque7);
		Bloque bloque4 = new Bloque(515,100,15,40);
		admin.cargarElemento(bloque4);
		//fila2
		Bloque bloque22 = new Bloque(65,120,15, 40);
		admin.cargarElemento(bloque22);
		Bloque bloque23 = new Bloque(110,120,15, 40);
		admin.cargarElemento(bloque23);
		Bloque bloque24 = new Bloque(155,120,15, 40);
		admin.cargarElemento(bloque24);
		Bloque bloque9 = new Bloque(200,120,15,40);
		admin.cargarElemento(bloque9);
		Bloque bloque10 = new Bloque(245,120,15,40);
		admin.cargarElemento(bloque10);
		Bloque bloque11 = new Bloque(290,120,15,40);
		admin.cargarElemento(bloque11);
		BloqueBonus bloque12 = new BloqueBonus(335,120,15,40);
		admin.cargarElemento(bloque12);
		BloqueBonus bloque13 = new BloqueBonus(380,120,15, 40);
		admin.cargarElemento(bloque13);
		Bloque bloque14 = new Bloque(425,120,15,40);
		admin.cargarElemento(bloque14);
		Bloque bloque15 = new Bloque(470,120,15,40);
		admin.cargarElemento(bloque15);
		Bloque bloque16 = new Bloque(515,120,15,40);
		admin.cargarElemento(bloque16);
		//BloqueDiamante bloque10 = new BloqueDiamante(220,90,15,30);
		//admin.cargarElemento(bloque10);
		
		BloqueHorizontal bloque17 = new BloqueHorizontal(200,180,15,40);
		bloque17.setDireccion(0);
		admin.cargarElemento(bloque17);		
		BloqueHorizontal bloque18 = new BloqueHorizontal(admin.getEscenario().getAncho()-40, 160, 15, 40);
		bloque18.setDireccion(180);
		admin.cargarElemento(bloque18);
		
		//fila3
		Bloque bloque25 = new Bloque(65,140,15, 40);
		admin.cargarElemento(bloque25);
		Bloque bloque26 = new Bloque(110,140,15, 40);
		admin.cargarElemento(bloque26);
		Bloque bloque27 = new Bloque(155,140,15, 40);
		admin.cargarElemento(bloque27);
		Bloque bloque28 = new Bloque(200,140,15, 40);
		admin.cargarElemento(bloque28);
		Bloque bloque29 = new Bloque(245,140,15,40);
		admin.cargarElemento(bloque29);
		Bloque bloque30 = new Bloque(290,140,15,40);
		admin.cargarElemento(bloque30);
		Bloque bloque31 = new Bloque(335,140,15,40);
		admin.cargarElemento(bloque31);
		Bloque bloque32 = new Bloque(380,140,15, 40);
		admin.cargarElemento(bloque32);
		Bloque bloque33 = new Bloque(425,140,15,40);
		admin.cargarElemento(bloque33);
		Bloque bloque34 = new Bloque(470,140,15,40);
		admin.cargarElemento(bloque34);
		Bloque bloque35 = new Bloque(515,140,15,40);
		admin.cargarElemento(bloque35);
		
		//bloque Diamante
	/*	BloqueDiamante bloque36 = new BloqueDiamante(admin.getEscenario().getAncho()/2,200,15,40);
		admin.cargarElemento(bloque36);*/
	}
	
	
	
	
	
	
	
	
	
	
}
