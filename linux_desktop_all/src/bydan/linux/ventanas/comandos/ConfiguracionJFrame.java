package bydan.linux.ventanas.comandos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import bydan.linux.base.Constantes;
import bydan.linux.base.Funciones;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ConfiguracionJFrame extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelGeneral;
	private JCheckBox chckbxEjecutarBash;
	private JCheckBox chckbxComandosLogArchivo;
	private JCheckBox chckbxComandosResultadosArchivos;
	private JCheckBox chckbxUbuntu;
	private JPanel panelWifislax;
	private JLabel lblWlan;
	private JLabel lblWlanMonitor;
	private JLabel lblMacAp;
	private JLabel lblMacCliente;
	private JLabel lblBssidAp;
	private JTextField textFieldWlan;
	private JTextField textFieldWlanMonitor;
	private JTextField textFieldMacAp;
	private JTextField textFieldBssidAp;
	private JTextField textFieldMacCliente;
	private JLabel lblCanal;
	private JTextField textFieldCanal;
	private JCheckBox chckbxEjecutarXterm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfiguracionJFrame frame = new ConfiguracionJFrame();
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
	public ConfiguracionJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow][][][][][]"));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "cell 0 0 1 5,grow");
		
		panelGeneral = new JPanel();
		tabbedPane.addTab("General", null, panelGeneral, null);
		panelGeneral.setLayout(new MigLayout("", "[]", "[][][]"));
		
		chckbxEjecutarBash = new JCheckBox("Ejecutar Bash");
		chckbxEjecutarBash.setSelected(true);
		panelGeneral.add(chckbxEjecutarBash, "cell 0 0");
		
		chckbxEjecutarXterm = new JCheckBox("Ejecutar XTerm");
		panelGeneral.add(chckbxEjecutarXterm, "flowy,cell 0 1");
		
		chckbxComandosLogArchivo = new JCheckBox("Comandos Log Archivo");
		chckbxComandosLogArchivo.setSelected(false);
		panelGeneral.add(chckbxComandosLogArchivo, "cell 0 1");
		
		chckbxComandosResultadosArchivos = new JCheckBox("Comandos Resultados Archivos");
		chckbxComandosResultadosArchivos.setSelected(false);
		panelGeneral.add(chckbxComandosResultadosArchivos, "cell 0 1");
		
		chckbxUbuntu = new JCheckBox("Ubuntu");
		panelGeneral.add(chckbxUbuntu, "cell 0 2");
		
		panelWifislax = new JPanel();
		tabbedPane.addTab("Wifislax", null, panelWifislax, null);
		panelWifislax.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));
		
		lblWlan = new JLabel("WLAN");
		panelWifislax.add(lblWlan, "cell 0 0,alignx trailing");
		
		textFieldWlan = new JTextField();
		panelWifislax.add(textFieldWlan, "cell 1 0,growx");
		textFieldWlan.setColumns(10);
		
		lblWlanMonitor = new JLabel("WLAN MONITOR");
		panelWifislax.add(lblWlanMonitor, "cell 0 1,alignx trailing");
		
		textFieldWlanMonitor = new JTextField();
		panelWifislax.add(textFieldWlanMonitor, "cell 1 1,growx");
		textFieldWlanMonitor.setColumns(10);
		
		lblMacAp = new JLabel("MAC AP");
		panelWifislax.add(lblMacAp, "cell 0 2,alignx trailing");
		
		textFieldMacAp = new JTextField();
		panelWifislax.add(textFieldMacAp, "cell 1 2,growx");
		textFieldMacAp.setColumns(10);
		
		lblBssidAp = new JLabel("BSSID AP");
		panelWifislax.add(lblBssidAp, "cell 0 3,alignx trailing");
		
		textFieldBssidAp = new JTextField();
		panelWifislax.add(textFieldBssidAp, "cell 1 3,growx");
		textFieldBssidAp.setColumns(10);
		
		lblMacCliente = new JLabel("MAC CLIENTE");
		panelWifislax.add(lblMacCliente, "cell 0 4,alignx trailing");
		
		textFieldMacCliente = new JTextField();
		panelWifislax.add(textFieldMacCliente, "cell 1 4,growx");
		textFieldMacCliente.setColumns(10);
		
		lblCanal = new JLabel("CANAL");
		panelWifislax.add(lblCanal, "cell 0 5,alignx trailing");
		
		textFieldCanal = new JTextField();
		panelWifislax.add(textFieldCanal, "cell 1 5,growx");
		textFieldCanal.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar en Memoria");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				Constantes.CON_EJECUTAR_BASH=chckbxEjecutarBash.isSelected();
				Constantes.CON_COMANDO_ARCHIVO=chckbxComandosLogArchivo.isSelected();
				Constantes.CON_RESULTADO_COMANDO_ARCHIVO=chckbxComandosResultadosArchivos.isSelected();
				Constantes.UBUNTU=chckbxUbuntu.isSelected();
				
				
				Constantes.NOMBRE_WLAN=textFieldWlan.getText();
				Constantes.NOMBRE_WLAN_MONITOR=textFieldWlanMonitor.getText();
				Constantes.MAC_AP=textFieldMacAp.getText();
				Constantes.BSSID=textFieldBssidAp.getText();
				Constantes.MAC_CLIENTE=textFieldMacCliente.getText();	
				*/
				
				cargarConstantesProperties();
				
				ConfiguracionJFrame.this.dispose();
			}
		});
		contentPane.add(btnGuardar, "flowx,cell 0 5");
		
		JButton btnDefecto = new JButton("Cargar Defecto");
		btnDefecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//GENERALES
				Constantes.CON_EJECUTAR_BASH=true;
				Constantes.CON_EJECUTAR_XTERMINAL=false;
				Constantes.CON_COMANDO_ARCHIVO=false;
				Constantes.CON_RESULTADO_COMANDO_ARCHIVO=false;
				Constantes.UBUNTU=false;
				
				chckbxEjecutarBash.setSelected(Constantes.CON_EJECUTAR_BASH);
				chckbxEjecutarXterm.setSelected(Constantes.CON_EJECUTAR_XTERMINAL);
				chckbxComandosLogArchivo.setSelected(Constantes.CON_COMANDO_ARCHIVO);
				chckbxUbuntu.setSelected(Constantes.UBUNTU);
				
				
				
				//WIFISLAX
				Constantes.NOMBRE_WLAN="wlan0";
				Constantes.NOMBRE_WLAN_MONITOR="wlan0mon";
				Constantes.MAC_AP="00:21:63:DF:D0:A7";
				Constantes.BSSID="Andinatel";
				Constantes.MAC_CLIENTE="00:11:22:33:44:55";	
				Constantes.CANAL="5";
				
				textFieldWlan.setText(Constantes.NOMBRE_WLAN);
				textFieldWlanMonitor.setText(Constantes.NOMBRE_WLAN_MONITOR);
				textFieldMacAp.setText(Constantes.MAC_AP);
				textFieldBssidAp.setText(Constantes.BSSID);
				textFieldMacCliente.setText(Constantes.MAC_CLIENTE);
				textFieldCanal.setText(Constantes.CANAL);
			}
		});
		contentPane.add(btnDefecto, "cell 0 5");
		
		this.CargaInicial();
	}

	public void CargaInicial(){
		Properties properties = new Properties();
		InputStream inputStream = null;
		
		try {
		    //load a propertieserties file from class path, inside static method
			inputStream =Funciones.class.getResourceAsStream("config.properties");
			
			if(inputStream!=null){
				
				properties.load(inputStream);
		    	    
			    
			    chckbxEjecutarBash.setSelected(Boolean.parseBoolean(properties.getProperty("CON_EJECUTAR_BASH")));
			    chckbxEjecutarXterm.setSelected(Boolean.parseBoolean(properties.getProperty("CON_EJECUTAR_XTERMINAL")));
			    chckbxComandosLogArchivo.setSelected(Boolean.parseBoolean(properties.getProperty("CON_COMANDO_ARCHIVO")));
			    chckbxComandosResultadosArchivos.setSelected(Boolean.parseBoolean(properties.getProperty("CON_RESULTADO_COMANDO_ARCHIVO")));	    
			    chckbxUbuntu.setSelected(Boolean.parseBoolean(properties.getProperty("UBUNTU")));
			    
			    textFieldWlan.setText(properties.getProperty("NOMBRE_WLAN"));
			    textFieldWlanMonitor.setText(properties.getProperty("NOMBRE_WLAN_MONITOR"));
			    textFieldMacAp.setText(properties.getProperty("MAC_AP"));
			    textFieldBssidAp.setText(properties.getProperty("BSSID"));
			    textFieldMacCliente.setText(properties.getProperty("MAC_CLIENTE"));
			    textFieldCanal.setText(properties.getProperty("CANAL"));
			    
			    this.cargarConstantesProperties();
			    
			} else {
				 System.out.println("No existe archivo config.properties");
			}
		} 
		catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
	
	public void cargarConstantesProperties() {
		
		Constantes.CON_EJECUTAR_BASH=chckbxEjecutarBash.isSelected();
		Constantes.CON_EJECUTAR_XTERMINAL=chckbxEjecutarXterm.isSelected();
		Constantes.CON_COMANDO_ARCHIVO=chckbxComandosLogArchivo.isSelected();
		Constantes.CON_RESULTADO_COMANDO_ARCHIVO=chckbxComandosResultadosArchivos.isSelected();
		Constantes.UBUNTU=chckbxUbuntu.isSelected();
		
		
		Constantes.NOMBRE_WLAN=textFieldWlan.getText();
		Constantes.NOMBRE_WLAN_MONITOR=textFieldWlanMonitor.getText();
		Constantes.MAC_AP=textFieldMacAp.getText();
		Constantes.BSSID=textFieldBssidAp.getText();
		Constantes.MAC_CLIENTE=textFieldMacCliente.getText();
		Constantes.CANAL=textFieldCanal.getText();
	}
}
