package grafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import start.Simulator;
import timer.Timer;

import node.Monitor;
import node.Node;

public class Grafica extends JFrame implements ActionListener {

	private JFrame finestra;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	
	JButton buttonStart; 
	JButton buttonStop;
	JButton buttonRestart;
	
	public Grafica(){

		finestra = new JFrame("SIMULATOR");
		finestra.setSize(300, 300);
		finestra.setLayout(new GridLayout(0, 1));
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestra.setLocationRelativeTo(null);	
		
		JPanel panelSuperiore = new JPanel( new FlowLayout() );
	    
		buttonStart = new JButton("Start");
		buttonStop = new JButton("Stop");
		buttonRestart = new JButton("Restart");
		
		panelSuperiore.add(buttonStart);
		panelSuperiore.add(buttonStop);
		panelSuperiore.add(buttonRestart);
		finestra.add(panelSuperiore);

		buttonStart.addActionListener(this);
		buttonStop.addActionListener(this);
		buttonRestart.addActionListener(this);
		
		finestra.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent evt){
		
		Object src = evt.getSource();

		if (src.equals(buttonStart)){
			Simulator.setFlag(true, "start");
		}
		else if (src.equals(buttonStop)){
			Simulator.setFlag(false, "start");

		}
		else if (src.equals(buttonRestart)){
			Timer.resetTime();
		}
			
	}
	
	public int newDisplay(String title)
	{
		int i = 0;
		JPanel panel = new JPanel( new GridLayout(1,2));
		panel.add(new JLabel(title,JLabel.CENTER));		
		labels.add(new JLabel());	
		i = labels.size() - 1;
		panel.add(labels.get(i));
		finestra.add(panel);
		
		return i;
	}
	public void newDisplay( Node n )
	{
		int i = this.newDisplay( n.name );
		((Monitor) n).newDisplay(this);
		((Monitor) n).setPos(i);
		
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
