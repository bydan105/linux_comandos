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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpenWirelessJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldOpenWireless;
	private JTextArea textAreaOpenWireless;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenWirelessJFrame frame = new OpenWirelessJFrame();
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
	public OpenWirelessJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "cell 0 0,grow");
		
		JPanel panelOpenWireless = new JPanel();
		tabbedPane.addTab("Open Wireless", null, panelOpenWireless, null);
		panelOpenWireless.setLayout(new MigLayout("", "[][grow]", "[][][][][][][grow]"));
		
		JLabel lblDetenerProcesos = new JLabel("Detener Procesos");
		panelOpenWireless.add(lblDetenerProcesos, "cell 0 0");
		
		JButton btnCheckKill = new JButton("check kill");
		btnCheckKill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airmon-ng check kill\r\n";
				
				textFieldOpenWireless.setText(sComando);
				
				sComando+="kill 1745\r\n";
				sComando+="kill 4578\r\n";
				sComando+="NetworkService start\r\n";
				
				textAreaOpenWireless.setText(sComando);
			}
		});
		panelOpenWireless.add(btnCheckKill, "cell 1 0");
		
		JLabel lblLevantarMonitor = new JLabel("Levantar Monitor");
		panelOpenWireless.add(lblLevantarMonitor, "cell 0 1");
		
		JButton btnairmon_ng = new JButton("airmon-ng");
		btnairmon_ng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airmon-ng start "+Constantes.NOMBRE_WLAN+"\r\n";
				
				textFieldOpenWireless.setText(sComando);
				
				sComando+="airmon-ng stop "+Constantes.NOMBRE_WLAN_MONITOR+"\r\n";
				
				textAreaOpenWireless.setText(sComando);
			}
		});
		panelOpenWireless.add(btnairmon_ng, "cell 1 1");
		
		JLabel lblMostrarInterfaces = new JLabel("Mostrar Interfaces");
		panelOpenWireless.add(lblMostrarInterfaces, "cell 0 2");
		
		JButton btnAirmonng = new JButton("airmon-ng2");
		btnAirmonng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airmon-ng\r\n";
				
				textFieldOpenWireless.setText(sComando);
				
				sComando="";
				
				textAreaOpenWireless.setText(sComando);
			}
		});
		panelOpenWireless.add(btnAirmonng, "cell 1 2");
		
		JLabel lblListeningWireless = new JLabel("Escuchar Wireless");
		panelOpenWireless.add(lblListeningWireless, "cell 0 3");
		
		JButton btnAirodumpng = new JButton("airodump-ng ");
		btnAirodumpng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="airodump-ng "+Constantes.NOMBRE_WLAN_MONITOR+"\r\n";
				
				textFieldOpenWireless.setText(sComando);
				
				sComando="";
				
				textAreaOpenWireless.setText(sComando);
			}
		});
		panelOpenWireless.add(btnAirodumpng, "cell 1 3");
		
		JLabel lblConexionSimulada = new JLabel("Simular Conexion");
		panelOpenWireless.add(lblConexionSimulada, "cell 0 4");
		
		JButton btnAireplayng = new JButton("aireplay-ng");
		btnAireplayng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="aireplay-ng --fakeauth 10 -e "+Constantes.BSSID+" -a "+Constantes.MAC_AP+" --ignore-negative-one "+Constantes.NOMBRE_WLAN_MONITOR+"\r\n";
				
				textFieldOpenWireless.setText(sComando);
				
				sComando+="aireplay-ng --fakeauth 10 -e "+Constantes.BSSID+" "+Constantes.NOMBRE_WLAN_MONITOR+"\r\n";
				
				textAreaOpenWireless.setText(sComando);
			}
		});
		panelOpenWireless.add(btnAireplayng, "cell 1 4");
		
		textFieldOpenWireless = new JTextField();
		panelOpenWireless.add(textFieldOpenWireless, "cell 0 5 2 1,growx");
		textFieldOpenWireless.setColumns(10);
		
		textAreaOpenWireless = new JTextArea();
		panelOpenWireless.add(textAreaOpenWireless, "cell 0 6 2 1,grow");
	}

}
