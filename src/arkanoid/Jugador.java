package arkanoid;

public class Jugador {
	private String nombre;
	private int vidas;
	private int puntos;
	private int misiles;
	
	
	public Jugador(int vidas, int puntos, int misiles) {
		this.vidas = vidas;
		this.puntos = puntos;
		this.misiles = misiles;
	}
	
	
	public int getMisiles() {
		return misiles;
	}

	public void setMisiles(int misiles) {
		this.misiles = misiles;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	
	
	
	
	
	
	
}
