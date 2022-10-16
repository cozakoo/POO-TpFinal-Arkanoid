package arkanoid.pruebas;

import javax.swing.JOptionPane;
import java.util.Scanner;

import arkanoid.AdministradorJuego;
import arkanoid.ui.InterfazUsuario;

public class Prueba {

	public static void main(String[] args) {
		AdministradorJuego admin = AdministradorJuego.getInstance();
		
		InterfazUsuario interfazUsuario = new InterfazUsuario();
		boolean salir = false;
		int opcion;
		
		String nombre = JOptionPane.showInputDialog("Ingrese Nombre ");
		admin.getJugador().setNombre(nombre);
		opcion = Integer.parseInt(JOptionPane.showInputDialog("Menu\n1. Jugar\n2. Salir"));
		while (!salir) {
			switch (opcion) {
			case 1:
				JOptionPane.showMessageDialog
				(null, "Presione SPACE para misil", "Controles", JOptionPane.WARNING_MESSAGE);
				interfazUsuario.iniciar(admin);
			case 2:
				salir = true;
			}
		}

	}

}
