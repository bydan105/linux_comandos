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

public class WpsWirelessJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldWpsWireless;
	private JTextArea textAreaWpsWireless;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WpsWirelessJFrame frame = new WpsWirelessJFrame();
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
	public WpsWirelessJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[]", "[grow]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "cell 0 0,grow");
		
		JPanel panelWpsWireless = new JPanel();
		tabbedPane.addTab("WPS Wireless", null, panelWpsWireless, null);
		panelWpsWireless.setLayout(new MigLayout("", "[grow][]", "[][][][][][][grow]"));
		
		JLabel label = new JLabel("Detener Procesos");
		panelWpsWireless.add(label, "cell 0 0");
		
		JButton button = new JButton("check kill");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airmon-ng check kill\r\n";
				
				textFieldWpsWireless.setText(sComando);
				
				sComando+="kill 1745\r\n";
				sComando+="kill 4578\r\n";
				sComando+="NetworkService start\r\n";
				
				textAreaWpsWireless.setText(sComando);
			}
		});
		panelWpsWireless.add(button, "cell 1 0");
		
		JLabel lblLevantardetenerMonitor = new JLabel("Levantar/Detener Monitor");
		panelWpsWireless.add(lblLevantardetenerMonitor, "cell 0 1");
		
		JButton btnAirmonng = new JButton("airmon-ng");
		btnAirmonng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airmon-ng start "+Constantes.NOMBRE_WLAN+" 1";
				
				textFieldWpsWireless.setText(sComando);
				
				sComando+="\r\nairmon-ng stop "+Constantes.NOMBRE_WLAN_MONITOR+"";
				
				textAreaWpsWireless.setText(sComando);
			}
		});
		panelWpsWireless.add(btnAirmonng, "cell 1 1");
		
		JLabel lblMostrarInterfaces = new JLabel("Mostrar Interfaces");
		panelWpsWireless.add(lblMostrarInterfaces, "cell 0 2");
		
		JButton btnAirmonng_1 = new JButton("airmon-ng2");
		btnAirmonng_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airmon-ng";
				
				textFieldWpsWireless.setText(sComando);
				
				sComando+="";
				
				textAreaWpsWireless.setText(sComando);
			}
		});
		panelWpsWireless.add(btnAirmonng_1, "cell 1 2");
		
		JLabel lblEscucharWireless = new JLabel("Escuchar Wireless");
		panelWpsWireless.add(lblEscucharWireless, "cell 0 3");
		
		JButton btnWash = new JButton("wash");
		btnWash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="wash -i "+Constantes.NOMBRE_WLAN_MONITOR+"";
				
				textFieldWpsWireless.setText(sComando);
				
				sComando="";
				
				textAreaWpsWireless.setText(sComando);
			}
		});
		panelWpsWireless.add(btnWash, "flowx,cell 1 3");
		
		JLabel lblCrackear = new JLabel("Crackear");
		panelWpsWireless.add(lblCrackear, "cell 0 4");
		
		JButton btnAirodumpng = new JButton("airodump-ng");
		btnAirodumpng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";				
				
				sComando="airodump-ng -c "+Constantes.CANAL+" --bssid "+Constantes.MAC_AP+" -w psk_wpa "+Constantes.NOMBRE_WLAN_MONITOR+"";
				
				textFieldWpsWireless.setText(sComando);
				
				sComando="";
				
				textAreaWpsWireless.setText(sComando);
			}
		});
		panelWpsWireless.add(btnAirodumpng, "cell 1 3");
		
		JButton btnReaver = new JButton("reaver");
		btnReaver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";				
				
				sComando="reaver -i "+Constantes.NOMBRE_WLAN_MONITOR+" -c "+Constantes.CANAL+" -b "+Constantes.MAC_AP+" -vv";
				
				textFieldWpsWireless.setText(sComando);
				
				sComando="";
				
				textAreaWpsWireless.setText(sComando);
			}
		});
		panelWpsWireless.add(btnReaver, "flowx,cell 1 4");
		
		JButton btnBully = new JButton("bully");
		btnBully.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";				
				
				sComando="bully "+Constantes.NOMBRE_WLAN_MONITOR+" -b "+Constantes.MAC_AP+" -e "+Constantes.BSSID+" -c "+Constantes.CANAL+"";
				
				textFieldWpsWireless.setText(sComando);
				
				sComando="";
				
				textAreaWpsWireless.setText(sComando);
			}
		});
		panelWpsWireless.add(btnBully, "cell 1 4");
		
		textFieldWpsWireless = new JTextField();
		panelWpsWireless.add(textFieldWpsWireless, "cell 0 5 2 1,growx");
		textFieldWpsWireless.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panelWpsWireless.add(scrollPane, "cell 0 6 2 1,grow");
		
		textAreaWpsWireless = new JTextArea();
		scrollPane.setViewportView(textAreaWpsWireless);
	}

}
