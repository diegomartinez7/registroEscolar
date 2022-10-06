import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class DashboardWindow extends JFrame {

	private JPanel contentPane;

	public DashboardWindow() {
		setTitle("Panel de control");
		setResizable(false);
		setUndecorated(true);  //removemos la barra superior
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850, 650);  //primero las dimensiones ancho x alto
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
		closeLabel.setBounds(804, 11, 46, 14);
		contentPane.add(closeLabel);
		
		JPanel dashboardPanel = new JPanel();
		dashboardPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		dashboardPanel.setBackground(new Color(250, 128, 114));
		dashboardPanel.setBounds(0, 0, 257, 650);
		contentPane.add(dashboardPanel);
		dashboardPanel.setLayout(null);
		
		JLabel dashboardLabel = new JLabel("");
		dashboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dashboardLabel.setIcon(Helper.getScaledImage("img/dashboard.png", 95, 100));
		dashboardLabel.setBounds(10, 55, 237, 100);
		dashboardPanel.add(dashboardLabel);
		
		JPanel materiaPanel = new JPanel();
		materiaPanel.setBackground(new Color(250, 128, 114));
		materiaPanel.setBounds(10, 219, 237, 61);
		dashboardPanel.add(materiaPanel);
		materiaPanel.setLayout(null);
		
		JLabel materiaImage = new JLabel("");
		materiaImage.setHorizontalAlignment(SwingConstants.CENTER);
		materiaImage.setIcon(Helper.getImage("img/books.png"));
		materiaImage.setBounds(11, 0, 70, 61);
		materiaPanel.add(materiaImage);
		
		JLabel materiaLabel = new JLabel("Materia");
		materiaLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		materiaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		materiaLabel.setBounds(85, 0, 142, 61);
		materiaPanel.add(materiaLabel);
		
		JPanel alumnoPanel = new JPanel();
		alumnoPanel.setBackground(new Color(250, 128, 114));
		alumnoPanel.setBounds(10, 291, 237, 61);
		dashboardPanel.add(alumnoPanel);
		alumnoPanel.setLayout(null);
		
		JLabel alumnoImage = new JLabel("");
		alumnoImage.setHorizontalAlignment(SwingConstants.CENTER);
		alumnoImage.setBounds(10, 0, 70, 61);
		alumnoPanel.add(alumnoImage);
		
		JLabel alumnoLabel = new JLabel("Alumno");
		alumnoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		alumnoLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		alumnoLabel.setBounds(85, 0, 142, 61);
		alumnoPanel.add(alumnoLabel);
		
		JPanel calificacionesPanel = new JPanel();
		calificacionesPanel.setBackground(new Color(250, 128, 114));
		calificacionesPanel.setBounds(10, 363, 237, 61);
		dashboardPanel.add(calificacionesPanel);
		calificacionesPanel.setLayout(null);
		
		JLabel calificacionesImage = new JLabel("");
		calificacionesImage.setHorizontalAlignment(SwingConstants.CENTER);
		calificacionesImage.setBounds(10, 0, 70, 61);
		calificacionesPanel.add(calificacionesImage);
		
		JLabel calificacionesLabel = new JLabel("Calificaciones");
		calificacionesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		calificacionesLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		calificacionesLabel.setBounds(85, 0, 142, 61);
		calificacionesPanel.add(calificacionesLabel);
	}
}
