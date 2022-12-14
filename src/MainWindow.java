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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField userText;
	private JPasswordField passwordField;
	protected String fileName = "usuarios.txt";
	public String userName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setTitle("¬°Bienvenido!");
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
				if(JOptionPane.showConfirmDialog(null,"¬ŅDesea salir de la aplicaci√≥n?",
					"Confirmaci√≥n", JOptionPane.YES_NO_OPTION) == 0) {  //0 es un "s√≠"
					System.exit(0);  //salimos de la aplicaci√≥n
				}
			}
		});
		closeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setForeground(new Color(0, 0, 0));
		closeLabel.setBounds(654, 11, 46, 14);
		contentPane.add(closeLabel);
		
		JLabel tituloLabel = new JLabel("Registro escolar personalizado");
		tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLabel.setBounds(0, 81, 700, 25);
		contentPane.add(tituloLabel);
		
		JLabel notebookLabel = new JLabel("");
		notebookLabel.setHorizontalAlignment(SwingConstants.CENTER);
		notebookLabel.setBounds(0, 123, 700, 97);
		notebookLabel.setIcon(Helper.getImage("img/notebook.png"));
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
		
		JButton loginButton = new JButton("");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//Imagen de bot√≥n durante hover
				loginButton.setIcon(Helper.getImage("img/btn_inicio_sesion_hover.png"));
				//Colocamos el cursor de tipo "mano"
				loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//Imagen de bot√≥n original
				loginButton.setIcon(Helper.getImage("img/btn_inicio_sesion.png"));
				//Colocamos el cursor default
				loginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//Comprobamos que usuario y contrase√Īa sean correctos
				if(checkUser(userText.getText(), passwordField.getText())) {
					//Mandamos una ventana emergente con un mensaje de √©xito
					JOptionPane.showMessageDialog(null, "Credenciales correctas.\nBienvenid@ " + userName);
					
					DashboardWindow dashboard = new DashboardWindow();
					dashboard.setVisible(true);
					MainWindow.this.dispose();
				}
				else {
					//Mandamos un mensaje de advertencia
					JOptionPane.showMessageDialog(null, "Usuario o contrase√Īa incorrectos",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		loginButton.setBorder(new LineBorder(Color.BLACK, 2, true));
		loginButton.setIcon(Helper.getImage("img/btn_inicio_sesion.png"));
		loginButton.setBounds(269, 390, 163, 46);
		contentPane.add(loginButton);
		
		JLabel signinLabel = new JLabel("");
		signinLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//Imagen de bot√≥n durante hover
				signinLabel.setIcon(Helper.getImage("img/add_user_hover.png"));
				//Colocamos el cursor de tipo "mano"
				signinLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//Imagen de bot√≥n original
				signinLabel.setIcon(Helper.getImage("img/add_user.png"));
				//Colocamos el cursor default
				signinLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInWindow signIn = new SignInWindow();
				signIn.setVisible(true);
				MainWindow.this.dispose();
			}
		});
		signinLabel.setIcon(Helper.getImage("img/add_user.png"));
		signinLabel.setBounds(615, 461, 75, 78);
		contentPane.add(signinLabel);
	}
	
	public boolean checkUser(String userInput, String passwordInput) {
		ArrayList<String[]> auxAccounts = this.getDataFromFile(); // 0 para usuarios
		boolean bandStatus = false;
		
		for(String account[] : auxAccounts) {
			if(account[0].equals(userInput)) {
				if(account[1].equals(passwordInput)) {
					bandStatus = true;
					this.userName = account[0];
					break;
				}
			}
		}
		
		return bandStatus;
	}
	
	
	private ArrayList<String[]> getDataFromFile() {
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		try {
			File file = new File(this.fileName);
			Scanner sc = new Scanner(file);
			sc.useDelimiter("\n");
			
			while(sc.hasNext()) {
				String tokens[] = sc.next().split(";");
				tokens[1] = tokens[1].replaceAll("\\R", "");
				data.add(tokens);
			}
			
			sc.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		
		return data;
	}
}