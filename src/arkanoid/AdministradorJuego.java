package arkanoid;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.bind.Marshaller.Listener;
import java.awt.Rectangle;

public class AdministradorJuego {
	private static AdministradorJuego instance = new AdministradorJuego();
	private Escenario escenario;
	private Paleta paleta = new Paleta();
	private Bola bola;
	private Jugador jugador = new Jugador(3, 0, 2);
	private ArrayList<Elemento> elementos = new ArrayList<Elemento>();
	private ArrayList<JuegoListener> listener = new ArrayList<JuegoListener>();
	private Boolean esFinJuego = false;

	private AdministradorJuego() {

	}

	public void actualizar() {

	}

	public static AdministradorJuego getInstance() {
		return instance;
	}

	public void addJuegoListener(JuegoListener listener) {
		this.listener.add(listener);
	}

	public void notificarCambios() {
		for (JuegoListener l : this.listener) {
			l.actualizar();
		}
	}

	public void comenzar() {

		this.crearEscenario();
		notificarCambios();
		
		while (!this.getEsFinJuego()) {
			this.darTurno();
			this.esperar();
			this.analizarTurno();
			this.esperar();
			this.depurarElementos();
			this.esperar();
			
			this.notificarCambios();

			this.esperar();
			int elementosRestantes = 0;
			for (int i = 0; i < this.elementos.size(); i++) {
				Elemento e1 = this.elementos.get(i);
				
				if(e1 instanceof Bloque || e1 instanceof BloqueBonus || e1 instanceof BloqueHorizontal
				|| e1 instanceof BloqueDiamante){
					elementosRestantes++;
				}
				
			}
			if (elementosRestantes == 0) {
				this.terminar();
			}
			if (this.getJugador().getVidas() == 0) {
				this.terminar();
			}
		}
	}

	public void esperar() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void crearEscenario() {
		this.escenario = new Escenario();
		Bola bola = new Bola();
		bola.setPosX(this.getEscenario().getAncho() / 2);
		bola.setPosY(480);
		bola.setAlto(10);
		bola.setAncho(10);
		this.bola = bola;
		elementos.add(this.bola);
		Escenario e = this.escenario;
		this.getPaleta().setPosX((e.getAncho() / 2) - 15);
		this.getPaleta().setPosY(e.getAlto() - 200);
		elementos.add(this.paleta);
		this.escenario.crear();
	}

	public void cargarElemento(Elemento elemento) {
		elementos.add(elemento);
	}

	

	public Boolean getEsFinJuego() {
		return esFinJuego;
	}

	public void setEsFinJuego(Boolean esFinJuego) {
		this.esFinJuego = esFinJuego;
	}

	public void terminar() {
		if (this.jugador.getVidas() == 0) {
			JOptionPane.showMessageDialog(null,"G A M E  O V E R");
			String totalPuntos = String.valueOf(this.getJugador().getPuntos());
			JOptionPane.showMessageDialog
			(null, totalPuntos, "Puntos totales", JOptionPane.WARNING_MESSAGE);	
			this.setEsFinJuego(true);
		} 
		else {
			String nombreJugador = this.getJugador().getNombre();
			JOptionPane.showMessageDialog
			(null, "Felicidades, ganaste!", nombreJugador, JOptionPane.WARNING_MESSAGE);
			String totalPuntos = String.valueOf(this.getJugador().getPuntos());
			JOptionPane.showMessageDialog
			(null, totalPuntos, "Puntos totales", JOptionPane.WARNING_MESSAGE);	
			this.setEsFinJuego(true);
		}
	}

	public void darTurno() {
		for (int i = 0; i < this.elementos.size(); i++) {
			Elemento e = this.elementos.get(i);
			e.jugar();
		}
	}

	public void analizarTurno() {
		for (int i = 0; i < this.elementos.size(); i++) {
			Elemento e = this.elementos.get(i);

			boolean chocoDerecha = false;
			boolean chocoIzquierda = false;
			boolean chocoArriba = false;
			boolean chocoAbajo = false;
			if (e.getPosX() >= escenario.getAncho()) {
				chocoDerecha = true;
			}
			if (e.getPosX() <= 0) {
				chocoIzquierda = true;
			}
			if (e.getPosY() >= escenario.getAlto()) {
				chocoAbajo = true;
			}
			if (e.getPosY() <= 0) {
				chocoArriba = true;
			}
			e.chocoPared(chocoDerecha, chocoIzquierda, chocoArriba, chocoAbajo);
		}
		this.verificarColision();
		
	}
	

	public void verificarColision() {
		for (int i = 0; i < this.elementos.size(); i++) {
			Elemento e = this.elementos.get(i);
			Rectangle r1 = e.getArea();
			for (int j = i + 1; j < this.elementos.size(); j++) {
				Elemento e2 = this.elementos.get(j);
				Rectangle r2 = e2.getArea();
				if (r1.intersects(r2)) {
					e.chocar(e2);
					e2.chocar(e);
				}
			}
		}
	}

	public void depurarElementos() {
		for (int i = 0; i < this.elementos.size(); i++) {
			if (this.elementos.get(i).getEstaVivo() == false) {
				this.elementos.remove(i);
			}
		}
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public Paleta getPaleta() {
		return paleta;
	}

	public Bola getBola() {
		return bola;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

}
