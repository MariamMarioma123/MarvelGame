package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import model.world.Champion;
import engine.Game;
import engine.Player;

public class ChampChoose extends JFrame implements ActionListener {
	JButton leader = new JButton();
	JButton p1 = new JButton();
	JButton p2 = new JButton();
	JButton b1= new JButton();
	JButton b2= new JButton();
	JButton b3= new JButton();
	JButton b4= new JButton();
	JButton b5= new JButton();
	JButton b6= new JButton();
	JButton b7= new JButton();
	JButton b8= new JButton();
	JButton b9= new JButton();
	JButton b10= new JButton();
	JButton b11= new JButton();
	JButton b12= new JButton();
	JButton b13= new JButton();
	JButton b14= new JButton();
	JButton b15= new JButton();
	JPanel p= new JPanel();
	Game game;
	Player play= null;
	int counter = 3;
	boolean setLeader;
	int lead = 1;
	JButton proceed= new JButton();
	JPanel pic= new JPanel();
	
	JLabel label1= new JLabel();
	JLabel label2= new JLabel();
	JLabel label3= new JLabel();
	TextArea a = new TextArea();
	 ArrayList<Champion> team1;
	 ArrayList<Champion> team2;
	 Player first;
	 Player second; 
	
	public ChampChoose(Game g) throws HeadlessException {
		super();
		this.game=g;
		this.setLayout(null);
		this.setSize(1925,1400);
		this.setTitle("Marvel: Ultimate War");
		ImageIcon image = new ImageIcon("channels4_profile.jpg");
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(new Color(0,0,0));
		
		
		a.setBounds(0,0,410, 980);
		a.setFont(new Font("Monospaced Bold",Font.PLAIN,25));
		a.setBackground(Color.BLACK);
		a.setForeground(Color.white);
		a.setEditable(false);
		a.setText("\n"+
		"      Details about Champions:" 
		+"\n"+"\n"+ "1-Type: Hero, Name: Captain America, MaxHP: 1500, Mana:1000, Actions: 6, Speed: 80, AttackRange:  1, AttackDamage: 100, Ability1 name: Shield throw, Ability2 name: I can do this all day, Ability3 name: Shield Up."
		+"\n"+" \n " +"2-Type: AntiHero, Name: Deadpool, MaxHP: 1350, Mana: 700, Actions: 6, Speed:  80, AttackRange: 3, AttackDamage: 90, Ability1 name: Try Harder, Ability2 name: 8 bullets left, Ability3 name: Can't Catch Me." 
		+"\n"+ " \n "+"3-Type: Hero, Name: Dr Strange, MaxHP: 1100, Mana: 1500, Actions: 6, Speed: 60, AttackRange: 2, AttackDamage: 60, Ability1 name: The eye of agamotto, Ability2 name: Thousand Hand, Ability3 name: Mirror Dimension."
		+"\n"+ " \n "+"4-Type: Villain, Name: Electro, MaxHP: 1200, Mana: 1200, Actions: 5, Speed: 75, AttackRange: 3, AttackDamage: 110, Ability1 name: Fully Charged, Ability2 name: EMP, Ability3 name: Lightning Strike."
		+"\n"+ " \n "+"5-Type: AntiHero, Name: Ghost Rider, MaxHP: 1800, Mana: 600, Actions: 6, Speed: 85, AttackRange: 1, AttackDamage: 140, Ability1 name: Death stare, Ability2 name: Fire Breath, Ability3 name: Fire Breath."
		+"\n"+ " \n " +"6-Type: Villain, Name: Hela, MaxHP: 1500, Mana: 750, Actions: 5, Speed: 75, AttackRange: 1, AttackDamage: 150, Ability1 name: Godess of Death, Ability2 name: Thorn Shield, Ability3 name: Thorn Shower. "
		+"\n"+ " \n " +"7-Type: Hero, Name: Hulk, MaxHP: 2250, Mana: 550, Actions: 5, Speed: 55, AttackRange: 1, AttackDamage: 200, Ability1 name: Rage, Ability2 name: Hulk  Smash, Ability3 name: Sun is getting real low."
		+"\n"+ "\n" +"8-Type: Hero, Name: Iceman, MaxHP: 1000, Mana: 900, Actions: 5, Speed: 65, AttackRange: 2, AttackDamage: 120, Ability1 name: Frost bite, Ability2 name: SubZero, Ability3 name: Hail Storm.   "
		+"\n"+ " \n " +"9-Type: Hero, Name: Ironman, MaxHP: 1200, Mana: 800, Actions: 7, Speed: 85, AttackRange: 3, AttackDamage: 90, Ability1 name: I am Ironman, Ability2 name: Unibeam, Ability3 name: 3000."
		+"\n"+ " \n " +"10-Type: Villain, Name: Loki, MaxHP: 1150, Mana: 900, Actions: 5, Speed: 70, AttackRange: 1, AttackDamage: 150, Ability1 name: God of Mischief, Ability2 name: The Hidden Dagger, Ability3 name: Fake Death.   "
		+"\n"+ " \n " +"11-Type: Villain, Name: Quicksilver, MaxHP: 1200, Mana: 650, Actions: 8, Speed: 99, AttackRange: 1, AttackDamage: 70, Ability1 name: Time in a bottle, Ability2 name: Good as new, Ability3 name: 1 sec 100 punch.   "
		+"\n"+ " \n " +"12-Type: Hero, Name: Spiderman, MaxHP: 1400, Mana: 750, Actions: 7, Speed: 85, AttackRange: 1, AttackDamage: 120, Ability1 name: give me that, Ability2 name: web trap, Ability3 name: Spiderverse."
		+"\n"+ " \n " +"13-Type: Hero, Name: Thor, MaxHP: 1800, Mana: 800, Actions: 7, Speed: 90, AttackRange: 1, AttackDamage: 130, Ability1 name: God of Thunder, Ability2 name: Mjollnir Throw, Ability3 name: Bring Me Thanos.  "
		+"\n"+ " \n " +"14-Type: AntiHero, Name: Venom, MaxHP: 1650, Mana: 700, Actions: 5, Speed: 70, AttackRange: 1, AttackDamage: 140, Ability1 name: Head Bite, Ability2 name: We are venom, Ability3 name: Symbiosis."
		+"\n"+ " \n " +"15-Type: Villain, Name: Yellow Jacket, MaxHP: 1050, Mana: 800, Actions: 6, Speed: 60, AttackRange: 2, AttackDamage: 80, Ability1 name: Laser Sting, Ability2 name: QuANTaMANia, Ability3 name: Pym Particle Upsize.");
		
		ImageIcon i = new ImageIcon("m.jpeg");
		label1.setIcon(i);
		label1.setBounds(470, 10, 1370, 430);
		
		
		p.setLayout(null);
		p.setBackground(Color.black);
		p.setBounds(410, 550, 1400, 600);
		p.add(p1);p.add(p2);p.add(proceed);p.add(leader);
		
		
		
		proceed.setBounds(1150, 200, 150, 100);
		proceed.setText("Proceed");proceed.setFont(new Font("Monospaced Bold",Font.BOLD,25));
		proceed.setBackground(Color.white);proceed.setFocusable(false);
		
		leader.setText("Set Leader");leader.setFont(new Font("Monospaced Bold",Font.BOLD,25));
		leader.setBackground(Color.white);leader.setFocusable(false);leader.setBounds(590, 270, 230, 100);
		
		p1.setText("Player 1");p1.setFont(new Font("Monospaced Bold",Font.BOLD,25));
		p1.setBackground(Color.white);p1.setFocusable(false);p2.setBounds(720, 100, 150, 100);
		p2.setText("Player 2");p2.setFont(new Font("Monospaced Bold",Font.BOLD,25));
		p2.setBackground(Color.white);p2.setFocusable(false);p1.setBounds(550, 100, 150, 100);
		
		
		b1.setText("Captain America");b1.setBounds(0+10, JButton.TOP, 161, 70);
		b2.setText("Deadpool");b2.setBounds(161+20, JButton.TOP, 161, 70);
		b3.setText("Dr Strange");b3.setBounds(322+30, JButton.TOP, 161, 70);
		b4.setText("Electro");b4.setBounds(483+40, JButton.TOP, 161, 70);
		b5.setText("Ghost Rider");b5.setBounds(644+50, JButton.TOP, 161, 70);
		b6.setText("Hela");b6.setBounds(805+60, JButton.TOP, 161, 70);
		b7.setText("Hulk");b7.setBounds(966+70, JButton.TOP, 161, 70);
		b8.setText("Iceman");b8.setBounds(1127+80, JButton.TOP, 161, 70);
		b9.setText("Ironman");b9.setBounds(966+123, 70+10, 161, 70);
		b10.setText("Loki");b10.setBounds(0+33+20, 70+10, 161, 70);
		b11.setText("Quicksilver");b11.setBounds(161+43+20, 70+10, 161, 70);
		b12.setText("Spiderman");b12.setBounds(322+53+20, 70+10, 161, 70);
		b13.setText("Thor");b13.setBounds(483+63+20, 70+10, 161, 70);
		b14.setText("Venom");b14.setBounds(644+73+20, 70+10, 161, 70);
		b15.setText("Yellow Jacket");b15.setBounds(805+83+20, 70+10, 161, 70);
		
		b1.setBackground(Color.WHITE);b1.setFocusable(false); b1.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b2.setBackground(Color.WHITE);b2.setFocusable(false); b2.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b3.setBackground(Color.WHITE);b3.setFocusable(false); b3.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b4.setBackground(Color.WHITE);b4.setFocusable(false); b4.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b5.setBackground(Color.WHITE);b5.setFocusable(false); b5.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b6.setBackground(Color.WHITE);b6.setFocusable(false); b6.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b7.setBackground(Color.WHITE);b7.setFocusable(false); b7.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b8.setBackground(Color.WHITE);b8.setFocusable(false); b8.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b9.setBackground(Color.WHITE);b9.setFocusable(false); b9.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b10.setBackground(Color.WHITE);b10.setFocusable(false); b10.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b11.setBackground(Color.WHITE);b11.setFocusable(false); b11.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b12.setBackground(Color.WHITE);b12.setFocusable(false); b12.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b13.setBackground(Color.WHITE);b13.setFocusable(false); b13.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b14.setBackground(Color.WHITE);b14.setFocusable(false); b14.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		b15.setBackground(Color.WHITE);b15.setFocusable(false); b15.setFont(new Font("Monospaced Bold",Font.PLAIN,15));
		
		
		
		
		leader.addActionListener(this);p1.addActionListener(this);p2.addActionListener(this);
		proceed.addActionListener(this);
		b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);
		b4.addActionListener(this);b5.addActionListener(this);b6.addActionListener(this);
		b7.addActionListener(this);b8.addActionListener(this);b9.addActionListener(this);
		b10.addActionListener(this);b11.addActionListener(this);b12.addActionListener(this);
		b13.addActionListener(this);b14.addActionListener(this);b15.addActionListener(this);

		JPanel panel= new JPanel();
		panel.setBounds(470, 460, 1700, 155);
		panel.setBackground(Color.black);
		panel.setLayout(null);
		
		panel.add(b1);	panel.add(b2);	panel.add(b3);	panel.add(b4);	panel.add(b5);panel.add(b6);panel.add(b7);
		panel.add(b8);
		panel.add(b9);panel.add(b10);panel.add(b11);panel.add(b12);panel.add(b13);panel.add(b14);panel.add(b15);
		
		this.add(label1);
		this.add(panel);this.add(p);this.add(a);
		leader.setVisible(false); 
		this.setVisible(true);
		
	
	}

	@SuppressWarnings({ "static-access" })
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==p1){
			p1.setVisible(false);
		play= game.getFirstPlayer();
		 counter = 3; leader.setVisible(true);lead=1;
		
		}
		
		if(e.getSource()==p2){
			p2.setVisible(false);
		 play= game.getSecondPlayer();
		counter = 3; leader.setVisible(true);lead= 1;
		}
		
		if(e.getSource()==leader&&play!=null )
		{ setLeader=true;}
		
		
		if (e.getSource()==b1&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(0));
			game.getTurnOrder().insert(game.getAvailableChampions().get(0));
			b1.setVisible(false); counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(0));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b2&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(1));
			game.getTurnOrder().insert(game.getAvailableChampions().get(1));
			b2.setVisible(false); counter--;if(setLeader){
				play.setLeader(game.getAvailableChampions().get(1));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b3&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(2));
			game.getTurnOrder().insert(game.getAvailableChampions().get(2));
			b3.setVisible(false); counter--;if(setLeader){
				play.setLeader(game.getAvailableChampions().get(2));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b4&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(3));
			game.getTurnOrder().insert(game.getAvailableChampions().get(3));
			b4.setVisible(false); counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(3));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b5&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(4));
			game.getTurnOrder().insert(game.getAvailableChampions().get(4));
			b5.setVisible(false); counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(4));
				setLeader=false; lead--;
			}
		}
		
		if (e.getSource()==b6&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(5));
			game.getTurnOrder().insert(game.getAvailableChampions().get(5));
			b6.setVisible(false);counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(5));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b7&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(6));
			game.getTurnOrder().insert(game.getAvailableChampions().get(6));
			b7.setVisible(false);counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(6));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b8&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(7));
			game.getTurnOrder().insert(game.getAvailableChampions().get(7));
			b8.setVisible(false);counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(7));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b9&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(8));
			game.getTurnOrder().insert(game.getAvailableChampions().get(8));
			b9.setVisible(false);counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(8));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b10&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(9));
			game.getTurnOrder().insert(game.getAvailableChampions().get(9));
			b10.setVisible(false);counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(9));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b11&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(10));
			game.getTurnOrder().insert(game.getAvailableChampions().get(10));
			b11.setVisible(false);counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(10));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b12&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(11));
			game.getTurnOrder().insert(game.getAvailableChampions().get(11));
			b12.setVisible(false);counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(11));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b13&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(12));
			game.getTurnOrder().insert(game.getAvailableChampions().get(12));
			b13.setVisible(false);counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(12));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b14&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(13));
			game.getTurnOrder().insert(game.getAvailableChampions().get(13));
			b14.setVisible(false);counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(13));
				setLeader=false; lead--;
			}
		}
		if (e.getSource()==b15&& counter >0&&play!=null){
			play.getTeam().add(game.getAvailableChampions().get(14));
			game.getTurnOrder().insert(game.getAvailableChampions().get(14));
			b15.setVisible(false);counter--;
			if(setLeader){
				play.setLeader(game.getAvailableChampions().get(14));
				setLeader=false; lead--;
			}
		}
		
	
		if(lead==0){
			leader.setVisible(false);
		}
		if(e.getSource()==proceed &&play!=null){
			this.dispose();
			//game.prepareChampionTurns();
			Board b = new Board(new Game(game.getFirstPlayer(),game.getSecondPlayer()));
			b.setVisible(true);
		}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String [] args){
		
		//ChampChoose f= new ChampChoose();
		
		
		
		
		
	}

}
