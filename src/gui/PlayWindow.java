package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import engine.Game;
import engine.Player;

public class PlayWindow extends JFrame implements ActionListener {
	JPanel p;
	JButton b;	
	JTextField x;
	JTextField x2;
	
	public PlayWindow() throws HeadlessException {
	this.setSize(1925,1050);
		this.setTitle("Marvel: Ultimate War");
		ImageIcon image = new ImageIcon("channels4_profile.jpg");
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(new Color(0,0,0));
	 getContentPane().setLayout(null);

		p = new JPanel();
	p.setLayout(new FlowLayout());
	p.setBounds(0,25 ,1925, 200);
	p.setBackground(Color.black);
		x = new JTextField();
	
		x.setSize(250,150);
		x.setText("Enter First Player's Name");
		x.setFont(new Font("Monospaced Bold",Font.BOLD,45));
		x2 = new JTextField();
		x2.setSize(250,150);
		x2.setText("Enter Second Player's Name");
		x2.setFont(new Font("Monospaced Bold",Font.BOLD,45));
		ImageIcon image1 = new ImageIcon("teams.jpg");
		JLabel l = new JLabel();
		l.setIcon(image1);
		l.setBounds(0, 200, 1900,1000);
		
		b= new JButton();
		b.setText("Confirm");
		b.setSize(250, 148);
		b.setFont(new Font("Monospaced Bold",Font.BOLD,45));
		b.setBackground(Color.WHITE);
		b.setFocusable(false);
		p.add(x);
		p.add(x2); 
		p.add(b);
		this.add(p);
		b.addActionListener(this);
		this.add(l);
		
		

	   

		this.setVisible(true);
		
	}

	@SuppressWarnings({ "static-access", "static-access", "static-access" })
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b){
			
			
			Player x1= new Player(this.x.getText());
			Player x2= new Player(this.x2.getText());
			Game g = new Game(x1,x2);
			try {
				g.loadAbilities("Abilities.csv");
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			try {
				g.loadChampions("Champions.csv");
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			this.dispose();
			ChampChoose x = new ChampChoose(g);
		}
		
	}



	
	
	
	

}
