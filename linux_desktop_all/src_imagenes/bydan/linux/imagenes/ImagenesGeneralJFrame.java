package bydan.linux.imagenes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.image.BufferedImage;
import java.io.IOException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ImagenesGeneralJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JLabel lblA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImagenesGeneralJFrame frame = new ImagenesGeneralJFrame();
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
	public ImagenesGeneralJFrame() {
		setTitle("IMAGEN");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 706, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		JLabel lblNombre = new JLabel("Nombre");
		contentPane.add(lblNombre, "cell 0 0,alignx trailing");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		contentPane.add(textFieldNombre, "cell 1 0,growx");
		textFieldNombre.setColumns(10);
		
		lblA = new JLabel("");
		contentPane.add(lblA, "cell 0 1 2 1");
		
		try {
			this.cargarImagen("Test","01_basico/01_definicion.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargarImagen(String sNombre,String sPath) throws IOException {
		
		textFieldNombre.setText(sNombre);
		
		BufferedImage bImage = ImageIO.read(AuxiliarImagenes.class.getResource(sPath));
		
		ImageIcon iImage = new ImageIcon(bImage);
		
		lblA.setIcon(iImage);
	}
}
