package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Excep extends JFrame {
	JLabel l= new JLabel();

	public Excep(String s ){
		
		this.setTitle("Marvel: Ultimate War");
		ImageIcon image = new ImageIcon("channels4_profile.jpg");
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(new Color(0,0,0));
		
		this.setSize(300,200);
		this.setVisible(true);l.setForeground(Color.WHITE);
		l.setText(s);this.add(l);l.setFont(new Font("Monospaced Bold",Font.BOLD,20));//l.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	
	
	
	
	
	
}
