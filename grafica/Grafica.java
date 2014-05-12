package grafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

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
	
	boolean reset_flag;
	
	
	boolean lettore_cd = false;
	
	public Grafica(){

		finestra = new JFrame("SIMULATOR");
		finestra.setSize(300, 400);
		finestra.setLayout(new GridLayout(0, 1));
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestra.setLocationRelativeTo(null);	
		
		
		JPanel panelSuperiore = new JPanel(new FlowLayout());
	    panelSuperiore.setBorder(BorderFactory.createEtchedBorder());

		JPanel panelSottoSuperiore = new JPanel( new FlowLayout() );
	    panelSottoSuperiore.setBorder(BorderFactory.createEtchedBorder());
		
		buttonStart = new JButton("Start");
		buttonStop = new JButton("Stop");
		buttonRestart = new JButton("Restart");
		
		buttonStart.setFocusPainted(false);
		buttonStart.setBackground(Color.lightGray);
		buttonStop.setFocusPainted(false);
		buttonStop.setBackground(Color.lightGray);
		buttonRestart.setFocusPainted(false);
		buttonRestart.setBackground(Color.lightGray);

		
		JLabel txt = new JLabel();
		txt.setText("CAR PARKING SIMULATOR");
		txt.setForeground(Color.red);
		
		JLabel sttxt = new JLabel();
		sttxt.setText("assuming that 1 h ~ 500 ms");

		JLabel ststtxt = new JLabel();
		ststtxt.setText("click \"start\" button to start simulation");
		
		
		panelSuperiore.add(txt);
		panelSuperiore.add(sttxt);
		panelSuperiore.add(ststtxt);
		
		panelSottoSuperiore.add(buttonStart);
		panelSottoSuperiore.add(buttonStop);
		panelSottoSuperiore.add(buttonRestart);
		
		
		finestra.add(panelSuperiore);
		finestra.add(panelSottoSuperiore);
		
		buttonStart.addActionListener(this);
		buttonStop.addActionListener(this);
		buttonRestart.addActionListener(this);
		
		finestra.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent evt){
		
		
		Random rand = new Random();
		// Java 'Color' class takes 3 floats, from 0 to 1.
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		
		Object src = evt.getSource();
		
		//buttonStart pressed
		if (src.equals(buttonStart)){
			Simulator.setFlag(true, "start");
			buttonStart.setBackground(new Color(r = rand.nextFloat(), g = rand.nextFloat(), b = rand.nextFloat()));
			buttonStart.setForeground(new Color(r = rand.nextFloat(), g = rand.nextFloat(), b = rand.nextFloat()));
			buttonStop.setBackground(Color.lightGray);
			buttonStop.setForeground(Color.black);
			buttonRestart.setBackground(Color.lightGray);
			buttonRestart.setForeground(Color.black);

			buttonStop.setCursor(new Cursor((int)(Math.random()*14)));
			buttonStart.setCursor(new Cursor((int)(Math.random()*14)));
			buttonRestart.setCursor(new Cursor((int)(Math.random()*14)));

			try {
				if(lettore_cd == false)
				Runtime.getRuntime().exec("eject");
				else
					Runtime.getRuntime().exec("eject -t");
				
				lettore_cd = !lettore_cd;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//buttonStop pressed
		else if (src.equals(buttonStop)){
			Simulator.setFlag(false, "start");
			buttonStop.setBackground(new Color(r = rand.nextFloat(), g = rand.nextFloat(), b = rand.nextFloat()));
			buttonStop.setForeground(new Color(r = rand.nextFloat(), g = rand.nextFloat(), b = rand.nextFloat()));
			buttonRestart.setBackground(Color.lightGray);
			buttonRestart.setForeground(Color.black);
			buttonStart.setBackground(Color.lightGray);
			buttonStart.setForeground(Color.black);

			buttonStop.setCursor(new Cursor((int)(Math.random()*14)));
			buttonStart.setCursor(new Cursor((int)(Math.random()*14)));
			buttonRestart.setCursor(new Cursor((int)(Math.random()*14)));

			
			try {
				if(lettore_cd == false)
				Runtime.getRuntime().exec("eject");
				else
					Runtime.getRuntime().exec("eject -t");
				
				lettore_cd = !lettore_cd;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//buttonRestart pressed
		else if (src.equals(buttonRestart)){
			Simulator.setFlag(true, "restart");
			buttonRestart.setBackground(new Color(r = rand.nextFloat(), g = rand.nextFloat(), b = rand.nextFloat()));
			buttonRestart.setForeground(new Color(r = rand.nextFloat(), g = rand.nextFloat(), b = rand.nextFloat()));
			buttonStop.setBackground(Color.lightGray);
			buttonStop.setForeground(Color.black);
			buttonStart.setBackground(Color.lightGray);
			buttonStart.setForeground(Color.black);

			buttonStop.setCursor(new Cursor((int)(Math.random()*14)));
			buttonStart.setCursor(new Cursor((int)(Math.random()*14)));
			buttonRestart.setCursor(new Cursor((int)(Math.random()*14)));

			
			try {
				if(lettore_cd == false)
				Runtime.getRuntime().exec("eject");
				else
					Runtime.getRuntime().exec("eject -t");
				
				lettore_cd = !lettore_cd;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
			
	}
	
	public boolean isReset_flag() {
		return reset_flag;
	}

	public void setReset_flag(boolean reset_flag) {
		this.reset_flag = reset_flag;
	}

	//add new display to the device
	public int newDisplay(String title)
	{
		int i = 0;
		JPanel panel = new JPanel( new GridLayout(1,2));
		panel.add(new JLabel(title,JLabel.CENTER));		
		panel.setBorder(BorderFactory.createBevelBorder(0));
		labels.add(new JLabel());
		i = labels.size() - 1;
		panel.add(labels.get(i));
		finestra.add(panel);
		
		return i;
	}
	
	//add new display to the device
	public void newDisplay( Node n )
	{
		int i = this.newDisplay( n.name );
		((Monitor) n).newDisplay(this);
		((Monitor) n).setPos(i);
		
	}
	
	//add new display to the device
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
	
	//change text "string" to label "position"
	public void setLabel( String string, int position )
	{
		labels.get(position).setText(string);
	}
}
