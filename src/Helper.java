import java.awt.Image;

import javax.swing.ImageIcon;

public class Helper {
	//Los métodos estáticos pueden invocarse sin crear un objeto de tipo Helper
	public static ImageIcon getImage(String url) {
		//Regresamos un objeto de tipo ImageIcon
		return new ImageIcon(Helper.class.getResource(url));
	}
	
	public static ImageIcon getScaledImage(String url, int width, int height) {
		//Creamos una imagen escalada con las dimensiones de width x height
		Image img = new ImageIcon(Helper.class.getResource(url))
				.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		//Regresamos un objeto de tipo ImageIcon
		return new ImageIcon(img);
	}
}