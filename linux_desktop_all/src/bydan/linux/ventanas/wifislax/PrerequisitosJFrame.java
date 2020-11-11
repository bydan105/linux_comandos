package bydan.linux.ventanas.wifislax;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bydan.linux.base.Comando;
import bydan.linux.base.Constantes;
import bydan.linux.ventanas.comandos.ProcesosJFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrerequisitosJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPrerequisito;
	private JTextArea textAreaPrerequisito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrerequisitosJFrame frame = new PrerequisitosJFrame();
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
	public PrerequisitosJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "cell 0 0,grow");
		
		JPanel panelPrerequisitos = new JPanel();
		tabbedPane.addTab("Prerequisitos", null, panelPrerequisitos, null);
		panelPrerequisitos.setLayout(new MigLayout("", "[][]", "[][][][][][grow]"));
		
		JLabel lblVerificar = new JLabel("Verificar");
		panelPrerequisitos.add(lblVerificar, "cell 0 0");
		
		JButton btnIfconfig = new JButton("ifconfig");
		btnIfconfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sComando="";
				
				sComando="ifconfig "+Constantes.NOMBRE_WLAN+"\r\n";
				sComando+="iwconfig";
				
				textFieldPrerequisito.setText("ifconfig "+Constantes.NOMBRE_WLAN+"");
				
				
				textAreaPrerequisito.setText(sComando);
				
			}
		});
		panelPrerequisitos.add(btnIfconfig, "cell 1 0");
		
		JLabel lblLevantarbajar = new JLabel("Levantar/Bajar");
		panelPrerequisitos.add(lblLevantarbajar, "cell 0 1");
		
		JButton btnIfconfigup = new JButton("ifconfig_up");
		btnIfconfigup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sComando="";
				
				sComando="ifconfig "+Constantes.NOMBRE_WLAN+" up\r\n";
				sComando+="ifconfig "+Constantes.NOMBRE_WLAN+" down";
				
				textFieldPrerequisito.setText("ifconfig "+Constantes.NOMBRE_WLAN+" up");
				
				
				textAreaPrerequisito.setText(sComando);
			}
		});
		panelPrerequisitos.add(btnIfconfigup, "cell 1 1");
		
		JLabel lblDetenerServicios = new JLabel("Detener Servicios");
		panelPrerequisitos.add(lblDetenerServicios, "cell 0 2");
		
		JButton btnNetworkmanager = new JButton("network_manager");
		btnNetworkmanager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="/etc/init.d/network-manager stop";
				
				textFieldPrerequisito.setText(sComando);
				
				sComando+="\r\n/etc/init.d/network-manager start";
				
				textAreaPrerequisito.setText(sComando);
			}
		});
		panelPrerequisitos.add(btnNetworkmanager, "cell 1 2");
		
		JLabel lblCambiarMac = new JLabel("Cambiar MAC");
		panelPrerequisitos.add(lblCambiarMac, "cell 0 3");
		
		JButton btnMacchanger = new JButton("mac_changer");
		btnMacchanger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sComando="";
				
				sComando="macchanger --mac=11:22:33:44:55 "+Constantes.NOMBRE_WLAN_MONITOR+"";
				
				textFieldPrerequisito.setText(sComando);
				
				sComando="ifconfig "+Constantes.NOMBRE_WLAN_MONITOR+" down";
				sComando+="\r\nmacchanger --mac=15:48:B5:7H:E4 "+Constantes.NOMBRE_WLAN_MONITOR+"";
				sComando+="\r\nifconfig "+Constantes.NOMBRE_WLAN_MONITOR+" up";
				
				textAreaPrerequisito.setText(sComando);
			}
		});
		panelPrerequisitos.add(btnMacchanger, "cell 1 3");
		
		textFieldPrerequisito = new JTextField();
		panelPrerequisitos.add(textFieldPrerequisito, "cell 0 4 2 1,growx");
		textFieldPrerequisito.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panelPrerequisitos.add(scrollPane, "cell 0 5 2 1,grow");
		
		textAreaPrerequisito = new JTextArea();
		scrollPane.setViewportView(textAreaPrerequisito);
	}

}
