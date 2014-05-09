package grafica;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Grafica extends JFrame {

	private JFrame finestra;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	
	public Grafica(){
		
		finestra = new JFrame("SIMULATOR");
		finestra.setSize(500, 100);
		finestra.setLayout(new GridLayout());
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestra.setLocationRelativeTo(null);	
		finestra.setVisible(true);
	}
	public int newDisplay(String title, Color background, Color foreground)
	{
		JPanel panel = new JPanel( new GridLayout(2,1));
		JPanel panelTitolo = new JPanel();
		panelTitolo.setBackground(background);
		
		labels.add(new JLabel(title));
		labels.get(labels.size() - 1).setForeground(foreground);
		panelTitolo.add(labels.get(labels.size() - 1));
		
		JPanel panelValore = new JPanel();
		panelValore.setBackground(foreground);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		labels.add(new JLabel());	
		int i = labels.size() - 1;
		labels.get(i).setForeground(background);
		panelValore.add(labels.get(i));
	
		panel.add(panelTitolo);
		panel.add(panelValore);
		finestra.add(panel);
		
		return i;
	}
	public void setLabel( String string, int position )
	{
		labels.get(position).setText(string);
	}
}
