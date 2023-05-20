package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FirstWindow extends JFrame implements ActionListener {
	JButton b;
public FirstWindow() throws HeadlessException {
	super();
	this.setSize(1925,1050);
	
	
	this.setTitle("Marvel: Ultimate War");
	ImageIcon image = new ImageIcon("channels4_profile.jpg");
	this.setIconImage(image.getImage());
	this.getContentPane().setBackground(new Color(0,0,0));
	JLabel l = new JLabel();
	b = new JButton();
	b.setText("PLAY");
	
	b.setFont(new Font("Monospaced Bold",Font.BOLD,25));
	b.setBounds(900, 750, 150, 75);
	b.setBackground(Color.WHITE);
	b.setFocusable(false);
	l.setIcon(image);
	
	l.setHorizontalAlignment(JLabel.CENTER);
	l.setVerticalAlignment(JLabel.CENTER);
	
	b.addActionListener(this);
	this.add(b);
	this.add(l);
	this.setVisible(true);
	
	
	
	
	}
public static void main(String [] args){
	
	FirstWindow frame= new FirstWindow();
	//loadAbilities("Abilities.csv");
	
	
	
	
	
	
}
@Override
public void actionPerformed(ActionEvent e) {
	
	if (e.getSource()==b){
		this.dispose();
		PlayWindow x = new PlayWindow();
	}
	
}
}
