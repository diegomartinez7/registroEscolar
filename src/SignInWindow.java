import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class SignInWindow extends JFrame {

	private JPanel contentPane;
	private JTextField userText;
	private JPasswordField passwordField;

	public SignInWindow() {
		setTitle("Registro de usuario");
		setResizable(false);
		setUndecorated(true);  //removemos la barra superior
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 550);  //primero las dimensiones ancho x alto
		setLocationRelativeTo(null);  //luego centramos la ventana
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.setBackground(new Color(233, 150, 122));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel closeLabel = new JLabel("X");
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				closeLabel.setForeground(new Color(255, 242, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				closeLabel.setForeground(Color.black);  //new Color(0, 0, 0)
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane nos permite mostrar una ventana emergente
				if(JOptionPane.showConfirmDialog(null,"¿Desea salir de la aplicación?",
					"Confirmación", JOptionPane.YES_NO_OPTION) == 0) {  //0 es un "sí"
					System.exit(0);  //salimos de la aplicación
				}
			}
		});
		closeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setForeground(new Color(0, 0, 0));
		closeLabel.setBounds(654, 11, 46, 14);
		contentPane.add(closeLabel);
		
		JLabel tituloLabel = new JLabel("Creación de usuario");
		tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLabel.setBounds(0, 81, 700, 25);
		contentPane.add(tituloLabel);
		
		JLabel notebookLabel = new JLabel("");
		notebookLabel.setHorizontalAlignment(SwingConstants.CENTER);
		notebookLabel.setBounds(0, 123, 700, 97);
		notebookLabel.setIcon(Helper.getScaledImage("img/registration_form.png", 85, 90));
		contentPane.add(notebookLabel);
		
		JPanel userPanel = new JPanel();
		userPanel.setBackground(new Color(250, 235, 215));
		userPanel.setBounds(182, 253, 338, 42);
		userPanel.setLayout(null);
		contentPane.add(userPanel);
		
		userText = new JTextField();
		userText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userText.setBackground(new Color(250, 235, 215));
		userText.setBorder(null);
		userText.setBounds(76, 0, 252, 42);
		userPanel.add(userText);
		
		JLabel userLabel = new JLabel("");
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setBounds(10, 0, 56, 42);
		userLabel.setIcon(Helper.getScaledImage("img/user.png", 40, 35));
		userPanel.add(userLabel);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBackground(new Color(250, 235, 215));
		passwordPanel.setBounds(182, 306, 337, 42);
		passwordPanel.setLayout(null);
		contentPane.add(passwordPanel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBackground(new Color(250, 235, 215));
		passwordField.setBorder(null);
		passwordField.setBounds(76, 0, 252, 42);
		passwordPanel.add(passwordField);
		
		JLabel passwordLabel = new JLabel("");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(10, 0, 56, 42);
		passwordLabel.setIcon(Helper.getScaledImage("img/password.png", 40, 35));
		passwordPanel.add(passwordLabel);
		
		JButton signinButton = new JButton("");
		signinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//Imagen de botón durante hover
				signinButton.setIcon(Helper.getImage("img/btn_registro_hover.png"));
				//Colocamos el cursor de tipo "mano"
				signinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//Imagen de botón original
				signinButton.setIcon(Helper.getImage("img/btn_registro.png"));
				//Colocamos el cursor default
				signinButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//Comprobamos que usuario y contraseña sean correctos
				if(userText.getText().equals("") || passwordField.getText().equals("")) {
					//Mandamos una ventana emergente con un mensaje de éxito
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
				}
				else {
					try {
						FileWriter usersFile = new FileWriter("usuarios.txt", true);
						String account = userText.getText()+";"+passwordField.getText()+"\n";
						usersFile.write(account);
						usersFile.close();
						
						//Mandamos un mensaje de advertencia
						JOptionPane.showMessageDialog(null, "Registro exitoso",
							"Advertencia", JOptionPane.WARNING_MESSAGE);
						
						changeWindow();
					}
					catch(Exception error) {
						JOptionPane.showMessageDialog(null, "Lo sentimos, ocurrió un error durante la creación del usuario");
					}
				}
			}
		});
		signinButton.setBorder(new LineBorder(Color.BLACK, 2, true));
		signinButton.setIcon(Helper.getImage("img/btn_registro.png"));
		signinButton.setBounds(269, 390, 163, 46);
		contentPane.add(signinButton);
		
		JLabel returnLabel = new JLabel("");
		returnLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//Imagen de botón durante hover
				returnLabel.setIcon(Helper.getImage("img/return_hover.png"));
				//Colocamos el cursor de tipo "mano"
				returnLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//Imagen de botón original
				returnLabel.setIcon(Helper.getImage("img/return.png"));
				//Colocamos el cursor default
				returnLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changeWindow();
			}
		});
		returnLabel.setIcon(Helper.getImage("img/return.png"));
		returnLabel.setBounds(615, 461, 67, 78);
		contentPane.add(returnLabel);
	}
	
	public void changeWindow() {
		MainWindow login = new MainWindow();
		login.setVisible(true);
		SignInWindow.this.dispose();
	}
}