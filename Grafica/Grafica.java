package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Grafica extends JFrame {

	private JFrame finestra;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JLabel testo1;
	private JLabel testo2;
	private JLabel testo3;
	private JLabel testo4;
	
	public Grafica(){
		
		finestra = new JFrame("SIMULATOR");
		finestra.setSize(500, 70);
		finestra.setLayout(new GridLayout(2,2));
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestra.setLocationRelativeTo(null);
		
		p1 = new JPanel();
		p1.setBackground(Color.blue);
		p1.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		finestra.add(p1);

		p2 = new JPanel();
		p2.setBackground(Color.red);
		p2.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		finestra.add(p2);

		p3 = new JPanel();
		p3.setBackground(Color.white);
		p3.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		finestra.add(p3);

		p4 = new JPanel();
		p4.setBackground(Color.white);
		p4.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		finestra.add(p4);

		testo1 = new JLabel();
		testo1.setForeground(Color.white);
		p1.add(testo1);

		testo2 = new JLabel();
		testo2.setForeground(Color.white);
		p2.add(testo2);

		testo3 = new JLabel();
		testo3.setForeground(Color.blue);
		p3.add(testo3);

		
		testo4 = new JLabel();
		testo4.setForeground(Color.red);
		p4.add(testo4);
		
		
		finestra.setVisible(true);

		
	}
	
	
	public void setLabel1(String text)
	{
		testo1.setText(text);
	}
	
	public void setLabel2(String text)
	{
		testo2.setText(text);
	}
	
	public void setLabel3(String text)
	{
		testo3.setText(text);
	}
	
	public void setLabel4(String text)
	{
		testo4.setText(text);
	}


}
