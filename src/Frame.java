package verifica_davide;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame extends JFrame implements ActionListener
{
	ArrayList<Integer> numeri=new ArrayList<>();
	Font font= new Font("Bodoni MT", Font.PLAIN, 18);
	
	JButton aggiungi= new JButton ("Aggiungi");
	JButton rimuovi= new JButton ("Rimuovi");
	JButton visualizza= new JButton ("Visualizza");


	JLabel label0= new JLabel ("Inserisci numero");
	JLabel label= new JLabel ("");
		
	JTextArea n= new JTextArea(4,15);
	JTextArea r= new JTextArea(4,15);
	
	JPanel rim;
	
	public Frame() 
	{
		super("Frame");
		rim=new JPanel();
		setVisible(false);
	
		setSize (400, 300);
		Container cont= this.getContentPane();
			
		cont.add(aggiungi);
		aggiungi.setFont(font);
		aggiungi.setBounds(30,120, 150, 40);
			
		cont.add(rimuovi);
		rimuovi.setFont(font);
		rimuovi.setBounds(190,120, 150, 40);
		
		cont.add(visualizza);
		visualizza.setFont(font);
		visualizza.setBounds(30 ,60, 150, 40);
			
		cont.add(label0);
		label0.setBounds(40, 10, 250, 50);
		label0.setFont(font);
		
		cont.add(n);
		n.setBounds(200,25 ,65, 20);
		n.setFont(font);
		
		cont.add(r);
		r.setBounds(200,83 ,150, 20);
		r.setFont(font);
			
		aggiungi.addActionListener(this);
		rimuovi.addActionListener(this);
		visualizza.addActionListener(this);
			
		cont.add(label);
		setVisible(true);
	}
	void ordinecrescente(int numero) 
	{
		int posizione=0;
		while (posizione<numeri.size() && numero>numeri.get(posizione)) 
		{
			posizione++;
		}
		numeri.add(posizione,numero);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == aggiungi) 
		{
			int numero=Integer.parseInt(n.getText());
			ordinecrescente(numero);
		}
		if (e.getSource() == visualizza)
		{
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<numeri.size(); i++)
			{
				int numero=numeri.get(i);
				sb.append(String.valueOf(numero+","));

			}
			r.setText(sb.toString());
		}
		else if (e.getSource() == rimuovi) //cancella il contenuto dell'array e il contenuto dei JText
		{
			r.setText("");
			n.setText("");
			numeri.clear();
		}	
	}
}
