package grafica;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

class backImage extends JComponent {
	 
	Image i;
	 
	//Creating Constructer
	public backImage(Image i) {
		this.i = i;
	}
	 
	//Overriding the paintComponent method
	@Override
	public void paintComponent(Graphics g) {
	 
	g.drawImage(i, 0, 0, null);  // Drawing image using drawImage method
	 
	}
}