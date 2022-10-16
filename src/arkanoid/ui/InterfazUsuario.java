package arkanoid.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import arkanoid.AdministradorJuego;
import arkanoid.JuegoListener;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazUsuario extends JFrame implements JuegoListener, KeyListener{
	
	private AdministradorJuego admin = AdministradorJuego.getInstance();;
	private Pantalla pantalla;
	
	public InterfazUsuario() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla = new Pantalla();
		pantalla.setBackground(Color.DARK_GRAY);
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(pantalla, BorderLayout.CENTER);
		this.setSize(700,700);
		this.setTitle("A R K A N O I D");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Juego");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmIniciar = new JMenuItem("Iniciar");
		mntmIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// aca iniciarmos el juego
			}
		});
		mnNewMenu.add(mntmIniciar);
		
		JMenuItem mntmFinalizar = new JMenuItem("Finalizar");
		mnNewMenu.add(mntmFinalizar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnNewMenu.add(mntmSalir);
		
	
	}
	
	
	public void iniciar(AdministradorJuego admin){
		System.out.println();
		this.admin = admin;
		
		this.admin.addJuegoListener(this);
		this.pantalla.addKeyListener(this);
		this.pantalla.setAdministradorJuego(admin);		
		this.setVisible(true);
		

		admin.comenzar();
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		//AdministradorJuego admin = AdministradorJuego.getInstance();
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			if(admin.getPaleta().getPosX()<admin.getEscenario().getAncho()) {	
				admin.getPaleta().setPosX(admin.getPaleta().getPosX() + admin.getPaleta().getVelocidad());
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(admin.getPaleta().getPosX()>0) {
				admin.getPaleta().setPosX(admin.getPaleta().getPosX() - admin.getPaleta().getVelocidad());
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//AdministradorJuego admin = AdministradorJuego.getInstance();
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			if(admin.getPaleta().getPosX()<admin.getEscenario().getAncho()) {	
				admin.getPaleta().setPosX(admin.getPaleta().getPosX() + admin.getPaleta().getVelocidad());
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(admin.getPaleta().getPosX()>0) {
				admin.getPaleta().setPosX(admin.getPaleta().getPosX() - admin.getPaleta().getVelocidad());
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			admin.getPaleta().dispararMisil();
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actualizar() {
		
		this.pantalla.mostrar();
		
	}
	
	



}
