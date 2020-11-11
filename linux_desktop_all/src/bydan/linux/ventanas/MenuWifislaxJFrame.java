package bydan.linux.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bydan.linux.ventanas.comandos.BasicoGeneralJFrame;
import bydan.linux.ventanas.wifislax.OpenWirelessJFrame;
import bydan.linux.ventanas.wifislax.PrerequisitosJFrame;
import bydan.linux.ventanas.wifislax.WepWirelessJFrame;
import bydan.linux.ventanas.wifislax.WpaWirelessJFrame;
import bydan.linux.ventanas.wifislax.WpsWirelessJFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuWifislaxJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWifislaxJFrame frame = new MenuWifislaxJFrame();
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
	public MenuWifislaxJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 422);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnResumen = new JMenu("Resumen");
		menuBar.add(mnResumen);
		
		JMenu mnManual = new JMenu("Manual");
		menuBar.add(mnManual);
		
		JMenuItem mntmPrerequisitos = new JMenuItem("Prerequisitos");
		mntmPrerequisitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrerequisitosJFrame prerequisitosJFrame=new PrerequisitosJFrame();
				
				prerequisitosJFrame.show();
			}
		});
		mnManual.add(mntmPrerequisitos);
		
		JMenuItem mntmOpenWireless = new JMenuItem("OPEN Wireless");
		mntmOpenWireless.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenWirelessJFrame openWirelessJFrame=new OpenWirelessJFrame();
				
				openWirelessJFrame.show();
			}
		});
		mnManual.add(mntmOpenWireless);
		
		JMenuItem mntmWepWireless = new JMenuItem("WEP Wireless");
		mntmWepWireless.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WepWirelessJFrame wepWirelessJFrame=new WepWirelessJFrame();
				
				wepWirelessJFrame.show();
			}
		});
		mnManual.add(mntmWepWireless);
		
		JMenuItem mntmWpsWireless = new JMenuItem("WPS Wireless");
		mntmWpsWireless.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WpsWirelessJFrame wpsWirelessJFrame=new WpsWirelessJFrame();
				
				wpsWirelessJFrame.show();
			}
		});
		mnManual.add(mntmWpsWireless);
		
		JMenuItem mntmWpawpaWireless = new JMenuItem("WPA-WPA2 Wireless");
		mntmWpawpaWireless.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WpaWirelessJFrame wpaWirelessJFrame=new WpaWirelessJFrame();
				
				wpaWirelessJFrame.show();
			}
		});
		mnManual.add(mntmWpawpaWireless);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
