package bydan.linux.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import bydan.linux.base.Comando;
import bydan.linux.base.Constantes;
import bydan.linux.base.Funciones;
import bydan.linux.ventanas.comandos.ConfiguracionJFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class MenuGeneralJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
										
					Funciones.CargarConfiguracion();
					
					MenuGeneralJFrame frame = new MenuGeneralJFrame();
					
					frame.setVisible(true);																														
					    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuGeneralJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][]", "[][][][][]"));
		
		JButton btnAplicaciones = new JButton("Aplicaciones");
		btnAplicaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAplicacionesJFrame menuAplicacionesJFrame=new MenuAplicacionesJFrame();
				
				menuAplicacionesJFrame.show();
			}
		});
		contentPane.add(btnAplicaciones, "cell 3 1");
		
		JButton btnComandos = new JButton("Comandos");
		btnComandos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuComandosJFrame menuComandosJFrame=new MenuComandosJFrame();
				
				menuComandosJFrame.show();
			}
		});
		contentPane.add(btnComandos, "cell 3 2,alignx center");
		
		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfiguracionJFrame configuracionJFrame = new ConfiguracionJFrame();
				
				configuracionJFrame.show();				
			}
		});
		contentPane.add(btnConfiguracion, "cell 3 3");
		
		JButton btnWifislax = new JButton("Wifislax");
		btnWifislax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuWifislaxJFrame menuWifislaxJFrame = new MenuWifislaxJFrame();
				
				menuWifislaxJFrame.show();	
			}
		});
		contentPane.add(btnWifislax, "flowy,cell 3 4,alignx center");
		
		JButton btnKali = new JButton("Kali");
		contentPane.add(btnKali, "cell 3 4,alignx center");
	}
}
