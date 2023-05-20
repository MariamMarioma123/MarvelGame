package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import engine.Player;

public class GameOver extends JFrame {
	JLabel l= new JLabel();
	
	public GameOver(Player x) {
		this.setTitle("Marvel: Ultimate War");
		ImageIcon image = new ImageIcon("channels4_profile.jpg");
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(new Color(0,0,0));
		
		this.setSize(500,200);
		this.setVisible(true);l.setForeground(Color.WHITE);
		
		l.setText("Congratulations " + x.getName() + "YOU WIN!!");
		this.add(l);l.setFont(new Font("Monospaced Bold",Font.BOLD,20));//l.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

}
