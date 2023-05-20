package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Damageable;
import model.world.Direction;
import model.world.Hero;
import engine.Game;
import engine.PriorityQueue;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;

public class Board extends JFrame implements ActionListener {
 Game game;
 JPanel p1= new JPanel();
 JPanel p2= new JPanel();
 JPanel turn= new JPanel();
 JLabel first=new JLabel();
 JLabel second= new JLabel();
 JLabel firstAb=new JLabel();
 JLabel secondAb= new JLabel();
  JButton [] abs= new  JButton [3] ;
 
 
 
 JLabel champ1=new JLabel();
 JLabel champ2= new JLabel();
 JLabel champ3=new JLabel();
 JLabel champ4= new JLabel();
 JLabel champ5= new JLabel();
 JLabel champ6= new JLabel();
 
	JButton c00 = new JButton();
	JButton c01= new JButton();
	JButton c02= new JButton();
	JButton c03= new JButton();
	JButton c04= new JButton();
	JButton c10= new JButton();
	JButton c11= new JButton();
	JButton c12= new JButton();
	JButton c13= new JButton();
	JButton c14= new JButton();
	JButton c20= new JButton();
	JButton c21= new JButton();
	JButton c22= new JButton();
	JButton c23= new JButton();
	JButton c24= new JButton();
	JButton c30= new JButton();
	JButton c31= new JButton();
	JButton c32= new JButton();
	JButton c33= new JButton();
	JButton c34= new JButton();
	JButton c40= new JButton();
	JButton c41= new JButton();
	JButton c42= new JButton();
	JButton c43= new JButton();
	JButton c44= new JButton();
	JPanel grid= new JPanel();
	JButton leaderAbility1= new JButton();
	JButton left= new JButton();
	JButton attack1= new JButton();
	JButton right= new JButton();
	JButton castAbility1= new JButton();
	JButton castAbility2= new JButton();
	JButton castAbility3= new JButton();
	JButton up= new JButton();
	JButton endT1= new JButton();
	JButton down= new JButton();
	JLabel ch11= new JLabel();
	 JLabel ch12= new JLabel();
	 JLabel ch13= new JLabel();
	 JLabel ch21= new JLabel();
	 JLabel ch22= new JLabel();
	 JLabel ch23= new JLabel();
	boolean attack;
	JButton move= new JButton();
	boolean mmove;
	
	public Board(Game game){
		this.game= game;
		this.setLayout(null);
		this.setSize(1925,1050);
		this.setTitle("Marvel: Ultimate War");
		ImageIcon image = new ImageIcon("channels4_profile.jpg");
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(Color.white);
		
		grid.setBounds(500, 200, 925, 850);
	grid.setLayout(null);
	grid.add(c00);grid.add(c01);grid.add(c02);grid.add(c03);grid.add(c04);
	grid.add(c10);grid.add(c11);grid.add(c12);grid.add(c13);grid.add(c14);
	grid.add(c20);grid.add(c21);grid.add(c22);grid.add(c23);grid.add(c24);
	grid.add(c30);grid.add(c31);grid.add(c32);grid.add(c33);grid.add(c34);	
	grid.add(c40);grid.add(c41);grid.add(c42);grid.add(c43);grid.add(c44);	
	
	
	
		 c00.setBounds(0, 0,185, 160);
		 c01.setBounds(185, 0,185, 160);
		 c02.setBounds(370, 0,185, 160);
		 c03.setBounds(555, 0,185, 160);
		 c04.setBounds(740, 0,185, 160);
		 c10.setBounds(0, 160,185, 160);
		 c11.setBounds(185, 160,185, 160);
		 c12.setBounds(370, 160,185, 160);
		 c13.setBounds(555, 160,185, 160);
		 c14.setBounds(740, 160,185, 160);
		 c20.setBounds(0, 320,185, 160);
		 c21.setBounds(185, 320,185, 160);
		 c22.setBounds(370, 320,185, 160);
		 c23.setBounds(555, 320,185, 160);
		 c24.setBounds(740, 320,185, 160);
		 c30.setBounds(0, 480,185, 160);
		 c31.setBounds(185, 480,185, 160);
		 c32.setBounds(370, 480,185, 160);
		 c33.setBounds(555, 480,185, 160);
		 c34.setBounds(740, 480,185, 160);
		 c40.setBounds(0, 640,185, 160);
		 c41.setBounds(185, 640,185, 160);
		 c42.setBounds(370, 640,185, 160);
		 c43.setBounds(555, 640,185, 160);
		 c44.setBounds(740, 640,185, 160);
		
		
		 first.setText(game.getFirstPlayer().getName());
		 second.setText(game.getSecondPlayer().getName());
		 first.setBounds(75,0, 150, 200);first.setFont(new Font("Monospaced Bold",Font.BOLD,30));
		 second.setBounds(75,0, 150, 200);second.setFont(new Font("Monospaced Bold",Font.BOLD,30));
		 firstAb.setBounds(75,10, 250, 250);firstAb.setFont(new Font("Monospaced Bold",Font.BOLD,15));
		 secondAb.setBounds(75,10, 250, 250);secondAb.setFont(new Font("Monospaced Bold",Font.BOLD,15));
		endT1.setBounds(200, 900, 175, 50);endT1.setFont(new Font("Monospaced Bold",Font.BOLD,15));
		down.setFont(new Font("Monospaced Bold",Font.BOLD,15));
		 if (game.isFirstLeaderAbilityUsed())
			 firstAb.setText("Leader Ability Used");
		 else  firstAb.setText("Leader Ability Not Used");

		 if (game.isSecondLeaderAbilityUsed())
			 secondAb.setText("Leader Ability Used");
		 else  secondAb.setText("Leader Ability Not Used");
		 
		 
		  
		 p1.add(first);p1.setLayout(null);
		 p2.add(second);p2.setLayout(null);
		 leaderAbility1.setBounds(75, 800, 250, 75);
		 left.setBounds(75, 750,100, 100);
		 leaderAbility1.setText("Use Leader Ability");leaderAbility1.setBackground(Color.white);leaderAbility1.setFocusable(false);
		 left.setText("left");left.setBackground(Color.white);left.setFocusable(false);
		 leaderAbility1.setFont(new Font("Monospaced Bold",Font.PLAIN,20));
		 left.setFont(new Font("Monospaced Bold",Font.PLAIN,20));
		 attack1.setBounds(75, 900, 75, 75); attack1.setText("Attack");
		 right.setBounds(275, 750, 100, 100);right.setText("right");
		 castAbility1.setBounds(75, 700, 125, 75); castAbility1.setText("Cast Ability");
		 up.setBounds(175, 700, 100, 100);up.setText("up");
		 move.setBounds(100, 600, 100, 75);move.setText("Move"); move.setFont(new Font("Monospaced Bold",Font.PLAIN,20));
		 down.setIcon(new ImageIcon("d.jpg"));down.setBounds(175, 800, 100, 100);
			endT1.setText("End Turn");down.setText("down");
			right.setIcon(new ImageIcon("r3.jpg"));up.setIcon(new ImageIcon("u.jpg"));left.setIcon(new ImageIcon("l.jpg"));
		 
		 
		p1.add(leaderAbility1);p1.add(attack1);p1.add(castAbility1);p1.add(firstAb);
		p2.add(left);p2.add(right);p2.add(up);p2.add(secondAb);p2.add(move);
		
		c00.addActionListener(this);c10.addActionListener(this);c20.addActionListener(this);c30.addActionListener(this);
		c01.addActionListener(this);c11.addActionListener(this);c21.addActionListener(this);c31.addActionListener(this);
		c02.addActionListener(this);c12.addActionListener(this);c22.addActionListener(this);c32.addActionListener(this);
		c03.addActionListener(this);c13.addActionListener(this);c23.addActionListener(this);c33.addActionListener(this);
		c04.addActionListener(this);c14.addActionListener(this);c24.addActionListener(this);c34.addActionListener(this);
		c40.addActionListener(this);c41.addActionListener(this);c42.addActionListener(this);c43.addActionListener(this);
		c44.addActionListener(this);leaderAbility1.addActionListener(this);left.addActionListener(this);
		attack1.addActionListener(this);right.addActionListener(this);castAbility1.addActionListener(this);
		up.addActionListener(this);
		endT1.addActionListener(this);down.addActionListener(this);
		p1.add(endT1);p2.add(down);
		
		
		ArrayList<JLabel> champs= new ArrayList<JLabel>();
		 champs.add(champ1); champs.add(champ4);
		 champs.add(champ2); champs.add(champ5);
		 champs.add(champ3); champs.add(champ6);
		
		
		turn.setLayout(new FlowLayout()); 
		PriorityQueue pq = game.getTurnOrder();
		PriorityQueue temp= new PriorityQueue(6);
		
			for(int i =0;i<6;i++){
				
				Champion current = (Champion) game.getTurnOrder().peekMin();
				temp.insert(current);
			
				if(current.getName().equals("Captain America"))
				champs.get(i).setIcon(new ImageIcon("ca.jpg"));
			
			if(current.getName().equals("Hela"))
				champs.get(i).setIcon(new ImageIcon("hel.jpg"));
			
			if(current.getName().equals("Deadpool"))
				champs.get(i).setIcon(new ImageIcon("dp.jpg"));
			
			if (current.getName().equals("Dr Strange"))
				champs.get(i).setIcon(new ImageIcon("dr.jpg"));
			
			if (current.getName().equals("Electro"))
				champs.get(i).setIcon(new ImageIcon("el.jpg"));
			
			if (current.getName().equals("Ironman"))
				champs.get(i).setIcon(new ImageIcon("iron.jpg"));
			
			if (current.getName().equals("Ghost Rider"))
				champs.get(i).setIcon(new ImageIcon("gt.jpg"));
			
			if (current.getName().equals("Hulk"))
				champs.get(i).setIcon(new ImageIcon("hu.jpg"));
			
			if (current.getName().equals("Iceman"))
				champs.get(i).setIcon(new ImageIcon("ice.jpg"));
			
			if (current.getName().equals("Loki"))
				champs.get(i).setIcon(new ImageIcon("lo.jpeg"));
			
			if (current.getName().equals("Venom"))
				champs.get(i).setIcon(new ImageIcon("ven.jpg"));
			
			if (current.getName().equals("Quicksilver"))
				champs.get(i).setIcon(new ImageIcon("quick.jpg"));
			
			if (current.getName().equals("Spiderman"))
				champs.get(i).setIcon(new ImageIcon("spi.jpg"));
			
			if (current.getName().equals("Thor"))
				champs.get(i).setIcon(new ImageIcon("thor.jpg"));
			
			if (current.getName().equals("Yellow Jacket"))
				champs.get(i).setIcon(new ImageIcon("yj.jpg"));
			turn.add(champs.get(i));
			current = (Champion) game.getTurnOrder().remove();	
			}
		while(!temp.isEmpty()){
			game.getTurnOrder().insert(temp.remove());
		}
			
		
		
		
		
		
		ArrayList<JLabel> j= new ArrayList<JLabel>();
		 j.add(ch11);
		 j.add(ch12);
		 j.add(ch13);
		 for(int k=0;k<game.getFirstPlayer().getTeam().size();k++){
		 String championType="";
		 if(game.getFirstPlayer().getTeam().get(k) instanceof AntiHero)
			 championType="A";
		 else if(game.getFirstPlayer().getTeam().get(k) instanceof Hero)
			 championType="H";
		 else championType="V";
		 String s="Name: "+ game.getFirstPlayer().getTeam().get(k).getName()+ " "+ "Type: "+ championType+" "+"CurrentHP: " +game.getFirstPlayer().getTeam().get(k).getCurrentHP()
		+ " "+"Mana: "+ game.getFirstPlayer().getTeam().get(k).getMana()+ " "+ "ActionPoints: "+game.getFirstPlayer().getTeam().get(k).getCurrentActionPoints()+ " "; 
		 String abilityType="";
		 String areaEffect="";
		 String amount="";
		 String amountName="";
		 for(int i=0;i<game.getFirstPlayer().getTeam().get(k).getAbilities().size();i++){
			 if(game.getFirstPlayer().getTeam().get(k).getAbilities().get(i) instanceof DamagingAbility){
				 amountName="DamageAmount: ";
				 abilityType="DMG";
				 amount=""+((DamagingAbility)(game.getFirstPlayer().getTeam().get(k).getAbilities().get(i))).getDamageAmount();}
			 else if(game.getFirstPlayer().getTeam().get(k).getAbilities().get(i) instanceof HealingAbility){
				 abilityType="HEL";
				 amountName="HealAmount: ";
				 amount=""+((HealingAbility)(game.getFirstPlayer().getTeam().get(k).getAbilities().get(i))).getHealAmount();}
			 else{ abilityType="CC";
			 
			 amountName="EffectName: "+((CrowdControlAbility)(game.getFirstPlayer().getTeam().get(k).getAbilities().get(i))).getEffect().getName()+ " ";
			 amount="DurationOfEffect: "+ ((CrowdControlAbility)(game.getFirstPlayer().getTeam().get(k).getAbilities().get(i))).getEffect().getDuration();}
			
			 AreaOfEffect e=game.getFirstPlayer().getTeam().get(k).getAbilities().get(i).getCastArea();
			 switch(e){
		    case  SINGLETARGET: areaEffect="SingleTarget";break;
			case  TEAMTARGET: areaEffect="TeamTarget";break;
			case  SURROUND: areaEffect="Surround";break;
			case DIRECTIONAL: areaEffect="Directional";break;
			case SELFTARGET:areaEffect="SelfTarget";break;}
			 
			 s+= "Ability"+ i + " "+ "Name: "+ game.getFirstPlayer().getTeam().get(k).getAbilities().get(i).getName()+ " "+
		 "AbilityType: "+ abilityType+ " "+ "AreaOfEffect: "+areaEffect+ " "+ "CastRange: " + game.getFirstPlayer().getTeam().get(0).getAbilities().get(i).getCastRange()+
		 " "+"ManaCost: " + game.getFirstPlayer().getTeam().get(k).getAbilities().get(i).getManaCost()+ " "+ "ActionCosts: "+game.getFirstPlayer().getTeam().get(0).getAbilities().get(i).getRequiredActionPoints()+
		 " "+ "CurrentCoolDown: "+ game.getFirstPlayer().getTeam().get(k).getAbilities().get(i).getCurrentCooldown() +" "+ 
		 "BaseCoolDown: "+ game.getFirstPlayer().getTeam().get(k).getAbilities().get(i).getBaseCooldown() +" "+ amountName+ amount+" ";}
		 
		 for(int n=0;n<game.getFirstPlayer().getTeam().get(k).getAppliedEffects().size();n++)
			 s+="EffectName: "+game.getFirstPlayer().getTeam().get(k).getAppliedEffects().get(n).getName()+ " "+"EffectDuration: "+game.getFirstPlayer().getTeam().get(k).getAppliedEffects().get(n).getDuration(); 
		 j.get(k).setText(s);}
		 j.get(0).setBounds(00,0,300,100);
		 j.get(1).setBounds(100,400,300,100);
		 j.get(2).setBounds(100,600,300,100);
		 p1.add(j.get(0));
		 p1.add(j.get(1));
		 p1.add(j.get(2));
		JLabel c1= new JLabel();c1.setVerticalAlignment(JLabel.BOTTOM);c1.setHorizontalAlignment(JLabel.CENTER);
		JLabel c2= new JLabel();c2.setVerticalAlignment(JLabel.BOTTOM);c2.setHorizontalAlignment(JLabel.CENTER);
		JLabel c3= new JLabel();c3.setVerticalAlignment(JLabel.BOTTOM);c3.setHorizontalAlignment(JLabel.CENTER);
		JLabel c4= new JLabel();c4.setVerticalAlignment(JLabel.BOTTOM);c4.setHorizontalAlignment(JLabel.CENTER);
		JLabel c5= new JLabel();c5.setVerticalAlignment(JLabel.BOTTOM);c5.setHorizontalAlignment(JLabel.CENTER);
		ArrayList<JLabel> cov= new ArrayList<JLabel>();
		cov.add(c5);
		cov.add(c1);
		cov.add(c2);
		cov.add(c3);
		cov.add(c4);
		
		
		//placing covers 
		 
		 ImageIcon im = new ImageIcon("ob.jpg");
		 
		 
		 for(int i=0;i<5;i++){
			 for(int jj =0;jj<5;jj++){
				 
				 int index=0;
				 if(game.getBoard()[i][jj]!=null&&game.getBoard()[i][jj]instanceof Cover  ){
					cov.get(index).setText(((Cover)game.getBoard()[i][jj]).getCurrentHP()+"");
				
					
					 if(i==1&&jj==0){
						 c10.setIcon(im);
						 c10.add(cov.get(index));
					 }if(i==1&&jj==1){
						 c11.setIcon(im);
						 c11.add(cov.get(index));
					 }if(i==1&&jj==2){
						 c12.setIcon(im);
						 c12.add(cov.get(index));
					 }if(i==1&&jj==3){
						 c13.setIcon(im);
						 c13.add(cov.get(index));
					 }if(i==1&&jj==4){
						 c14.setIcon(im);
						 c14.add(cov.get(index));
					 }
					 if(i==2&&jj==0){
						 c20.setIcon(im);
						 c20.add(cov.get(index));
					 }if(i==2&&jj==1){
						 c21.setIcon(im);
						 c21.add(cov.get(index));
					 }if(i==2&&jj==2){
						 c22.setIcon(im);
						 c22.add(cov.get(index));
					 }if(i==2&&jj==3){
						 c23.setIcon(im);
						 c23.add(cov.get(index));
					 }if(i==2&&jj==4){
						 c24.setIcon(im);
						 c24.add(cov.get(index));
					 }
					 
					 if(i==3&&jj==0){
						 c30.setIcon(im);
						 c30.add(cov.get(index));
					 }if(i==3&&jj==1){
						 c31.setIcon(im);
						 c31.add(cov.get(index));
					 }if(i==3&&jj==2){
						 c32.setIcon(im);
						 c32.add(cov.get(index));
					 }if(i==3&&jj==3){
						 c33.setIcon(im);
						 c33.add(cov.get(index));
					 }if(i==3&&jj==4){
						 c34.setIcon(im);
						 c34.add(cov.get(index));
					 }
						index++;
					
			 }}}
		 ImageIcon champ=null;
		 for(int i=0;i<game.getFirstPlayer().getTeam().size();i++){
			
			 if(game.getFirstPlayer().getTeam().get(i).getName().equals("Captain America"))
				 champ= new ImageIcon("ca.jpg");
			 else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Hela"))
				 champ= new ImageIcon("hel.jpg");
			 else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Deadpool"))
				 champ= new ImageIcon("dp.jpg");
		     else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Dr Strange"))
		    	 champ= new ImageIcon("dr.jpg");
			 else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Electro"))
				 champ= new ImageIcon("el.jpg");
		     else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Ironman"))
		    	 champ= new ImageIcon("iron.jpg");
			 else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Ghost Rider"))
				 champ= new ImageIcon("gt.jpg");
			 else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Hulk"))
				 champ= new ImageIcon("hu.jpg");
			 else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Iceman"))
				 champ= new ImageIcon("ice.jpg");
			 else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Loki"))
				 champ= new ImageIcon("lo.jpeg");
			 else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Quicksilver"))
				 champ= new ImageIcon("quick.jpg");
			 else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Spiderman"))
				 champ= new ImageIcon("spi.jpg");
		     else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Thor"))
		    	 champ= new ImageIcon("thor.jpg");
		     else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Venom"))
		    	 champ= new ImageIcon("ven.jpg");
		     else if (game.getFirstPlayer().getTeam().get(i).getName().equals("Yellow Jacket"))
		    	 champ= new ImageIcon("yj.jpg");
		     if(i==0)
		    	 c41.setIcon(champ);
		     else if(i==1)
		    	 c42.setIcon(champ);
		     else if(i==2)
		    	 c43.setIcon(champ);
		    	 
		    	 
					 
					 
		 }
		 for(int i=0;i<game.getSecondPlayer().getTeam().size();i++){
				
			 if(game.getSecondPlayer().getTeam().get(i).getName().equals("Captain America"))
				 champ= new ImageIcon("ca.jpg");
			 else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Hela"))
				 champ= new ImageIcon("hel.jpg");
			 else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Deadpool"))
				 champ= new ImageIcon("dp.jpg");
		     else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Dr Strange"))
		    	 champ= new ImageIcon("dr.jpg");
			 else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Electro"))
				 champ= new ImageIcon("el.jpg");
		     else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Ironman"))
		    	 champ= new ImageIcon("iron.jpg");
			 else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Ghost Rider"))
				 champ= new ImageIcon("gt.jpg");
			 else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Hulk"))
				 champ= new ImageIcon("hu.jpg");
			 else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Iceman"))
				 champ= new ImageIcon("ice.jpg");
			 else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Loki"))
				 champ= new ImageIcon("lo.jpeg");
			 else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Quicksilver"))
				 champ= new ImageIcon("quick.jpg");
			 else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Spiderman"))
				 champ= new ImageIcon("spi.jpg");
		     else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Thor"))
		    	 champ= new ImageIcon("thor.jpg");
		     else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Venom"))
		    	 champ= new ImageIcon("ven.jpg");
		     else if (game.getSecondPlayer().getTeam().get(i).getName().equals("Yellow Jacket"))
		    	 champ= new ImageIcon("yj.jpg");
		     if(i==0)
		    	 c01.setIcon(champ);
		     else if(i==1)
		    	 c02.setIcon(champ);
		     else if(i==2)
		    	 c03.setIcon(champ);
		    	 
		    	 
					 
					 
		 }
				 
		//placing champs		 
			
		 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
			 
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		this.add(grid);
		p1.setBounds((int)JPanel.LEFT_ALIGNMENT,(int)JPanel.TOP_ALIGNMENT ,400, 1050);
		 p2.setBounds(1525,(int)JPanel.TOP_ALIGNMENT ,400, 1050);
		 turn.setBounds(300,(int)JPanel.TOP_ALIGNMENT ,1300, 200);
		 p1.setBackground(Color.WHITE);
		 p2.setBackground(Color.WHITE);
		 turn.setBackground(Color.WHITE);
		 this.add(p1); this.add(p2); this.add(turn);
		
		 
		 
		 
		 
		 
		 
		 
		 
		 this.setVisible(true);
		
		
		
		
		
		
		
		
		
		
	}

public static void main(String [] args){
		
		
		
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==leaderAbility1 ){
			
			 try {
				game.useLeaderAbility();
			} catch (LeaderNotCurrentException e1) {
				Excep p = new Excep("Leader Not Current");
				
			
				//e1.printStackTrace();
			} catch (LeaderAbilityAlreadyUsedException e1) {
				Excep p = new Excep("Leader Used Ability");
				//e1.printStackTrace();
			}
				
			 if (game.isFirstLeaderAbilityUsed())
				 firstAb.setText("Leader Ability Used");
			 else  firstAb.setText("Leader Ability Not Used");
			 
			 if(game.checkGameOver()!=null){
				 GameOver x = new GameOver(game.checkGameOver());
			 }

			 
			
		}
	
			
		
		if(e.getSource()==endT1 ){
			
			game.endTurn();
			
		}
		
			
		
		if(e.getSource()==attack1){
			attack = true; 		}
		
		int currx = game.getCurrentChampion().getLocation().x;
		int curry = game.getCurrentChampion().getLocation().y;
		
		
		if(attack){
			
				if(e.getSource()==left){
			{ 
			try {
				game.attack(Direction.LEFT);
			} catch (NotEnoughResourcesException e1) {
				Excep p = new Excep("NOT ENOUGH RESOURCES");
				e1.printStackTrace();
			} catch (ChampionDisarmedException e1) {
				Excep p = new Excep("CHAMPION DISARMED");
				e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				Excep p = new Excep("INVALID TARGET");
				e1.printStackTrace();
			}attack = false;
			
			for (int i = 0; i < game.getCurrentChampion().getAttackRange() && game.getBoard()[currx][curry]==null; i++) {
				curry--;}}}
			
						 
				 
			
			
			
			
			
		
		if(e.getSource()==right)
		{ 
		try {
			game.attack(Direction.RIGHT);
		} catch (NotEnoughResourcesException e1) {
			Excep p = new Excep("NOT ENOUGH RESOURCES");
			e1.printStackTrace();
		} catch (ChampionDisarmedException e1) {
			Excep p = new Excep("CHAMPION DISARMED");
			e1.printStackTrace();
		} catch (InvalidTargetException e1) {
			Excep p = new Excep("INVALID TARGET");
			e1.printStackTrace();
		}attack = false;
		for (int i = 0; i < game.getCurrentChampion().getAttackRange() && game.getBoard()[currx][curry]==null; i++) {
			curry++;}
		}
		
	
		if(e.getSource()==up)
		{ 
		try {
			game.attack(Direction.UP);
		} catch (NotEnoughResourcesException e1) {
			Excep p = new Excep("NOT ENOUGH RESOURCES");
			e1.printStackTrace();
		} catch (ChampionDisarmedException e1) {
			Excep p = new Excep("CHAMPION DISARMED");
			e1.printStackTrace();
		} catch (InvalidTargetException e1) {
			Excep p = new Excep("INVALID TARGET");
			e1.printStackTrace();
		}attack = false;for (int i = 0; i < game.getCurrentChampion().getAttackRange() && game.getBoard()[currx][curry]==null; i++) {
			currx++;}
		}
		
		if(e.getSource()==down)
		{ 
		try {
			game.attack(Direction.DOWN);
		} catch (NotEnoughResourcesException e1) {
			Excep p = new Excep("NOT ENOUGH RESOURCES");
			e1.printStackTrace();
		} catch (ChampionDisarmedException e1) {
			Excep p = new Excep("CHAMPION DISARMED");
			e1.printStackTrace();
		} catch (InvalidTargetException e1) {
			Excep p = new Excep("INVALID TARGET");
			e1.printStackTrace();
		}attack = false;
		for (int i = 0; i < game.getCurrentChampion().getAttackRange() && game.getBoard()[currx][curry]==null; i++) {
			currx--;}}
		if(currx==0&&curry==0){
			 c00.setIcon(null);
			
		 }
		if(currx==0&&curry==1){
			 c01.setIcon(null);
			
		 }if(currx==0&&curry==2){
			 c02.setIcon(null);
		
		 }if(currx==0&&curry==3){
			 c03.setIcon(null);
		 }
		 if(currx==0&&curry==4){
			
			 c04.setIcon(null);
		 }
		 
		 if(currx==1&&curry==0){
			 c10.setIcon(null);
		 }if(currx==1&&curry==1){
			 c11.setIcon(null);
		 }if(currx==1&&curry==2){
			 c12.setIcon(null);
		 }if(currx==1&&curry==3){
			 c13.setIcon(null);
		 }if(currx==1&&curry==4){
			 c14.setIcon(null);
		 }
		 if(currx==2&&curry==0){
			 c20.setIcon(null);
		 }if(currx==2&&curry==1){
			 c21.setIcon(null);
		 }if(currx==2&&curry==2){
			 c22.setIcon(null);
		 }if(currx==2&&curry==3){
			 c23.setIcon(null);
		 }if(currx==2&&curry==4){
			 c24.setIcon(null);
		 }
		 
		 if(currx==3&&curry==0){
			 c30.setIcon(null);
		 }if(currx==3&&curry==1){
			 c31.setIcon(null);
		 }if(currx==3&&curry==2){
			 c32.setIcon(null);
		 }if(currx==3&&curry==3){
			 c33.setIcon(null);
		 }if(currx==3&&curry==4){
			 c34.setIcon(null);
		 }
		 
		 
		 if(currx==4&&curry==1){
			 c41.setIcon(null);
		 }if(currx==4&&curry==2){
			 c42.setIcon(null);
		 }
		 if(currx==4&&curry==3){
			 c43.setIcon(null);
		 }
		 if(currx==4&&curry==4){
			 c44.setIcon(null);
		 }
		
		}
		
		
		//moving 
		 ImageIcon c= null;
		 
		 
		 if(e.getSource()==move){
			 mmove = true;
		 }
		 
		 
		 
		 if(mmove){
			 
			 int newx= currx;
			 int newy=curry;
			 
			 
			 
		 if(e.getSource()==up){
			 try {
				game.move(Direction.UP);
			} catch (NotEnoughResourcesException e1) {
				Excep p = new Excep("NOT ENOUGH RESOURCES");
				
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnallowedMovementException e1) {
				Excep p = new Excep("UNALLOWED MOVEMENT");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 newx++;
			
		 }
		 if(e.getSource()==down){
			 try {
				game.move(Direction.DOWN);
			} catch (NotEnoughResourcesException e1) {
				Excep p = new Excep("NOT ENOUGH RESOURCES");
				
				e1.printStackTrace();
			} catch (UnallowedMovementException e1) {
				// TODO Auto-generated catch block
				Excep p = new Excep("UNALLOWED MOVEMENT");
				e1.printStackTrace();
			}
			 newx--;
			
		 }if(e.getSource()==right){
			 try {
				game.move(Direction.RIGHT);
			} catch (NotEnoughResourcesException e1) {
				Excep p = new Excep("NOT ENOUGH RESOURCES");
				
				e1.printStackTrace();
			} catch (UnallowedMovementException e1) {
				Excep p = new Excep("UNALLOWED MOVEMENT");
				e1.printStackTrace();
			}
			 newy++;
			
		 }if(e.getSource()==left){
			 try {
				game.move(Direction.LEFT);
			} catch (NotEnoughResourcesException e1) {
				Excep p = new Excep("NOT ENOUGH RESOURCES");
				e1.printStackTrace();
			} catch (UnallowedMovementException e1) {
				Excep p = new Excep("UNALLOWED MOVEMENT");
				e1.printStackTrace();
			}
			 newy--;
			
		 }
		 
		 
		 //getting image and removing old one from button
		 if(currx==0&&curry==0){
			 c= (ImageIcon) c00.getIcon();
			 c00.setIcon(null);
			 }if(currx==0&&curry==1){
			 c= (ImageIcon) c01.getIcon();
			 c01.setIcon(null);
			 }if(currx==0&&curry==2){
			 c= (ImageIcon) c02.getIcon();
			 c02.setIcon(null);
		 }if(currx==0&&curry==3){
			 c= (ImageIcon) c03.getIcon();
			 c03.setIcon(null);
		 }if(currx==0&&curry==4){
			 c= (ImageIcon) c04.getIcon();
			 c04.setIcon(null);
		 } if(currx==1&&curry==0){
			 c= (ImageIcon) c10.getIcon();
			 c10.setIcon(null);
		 }if(currx==1&&curry==1){
			 c= (ImageIcon) c11.getIcon();
			 c11.setIcon(null);
		 }if(currx==1&&curry==2){
			 c= (ImageIcon) c12.getIcon();
			 c12.setIcon(null);
		 }if(currx==1&&curry==3){
			 c= (ImageIcon) c13.getIcon();
			 c13.setIcon(null);
		 }if(currx==1&&curry==4){
			 c= (ImageIcon) c14.getIcon();
			 c14.setIcon(null);
		 }if(currx==2&&curry==0){
			 c= (ImageIcon) c20.getIcon();
			 c20.setIcon(null);
		 }if(currx==2&&curry==1){
			 c= (ImageIcon) c21.getIcon();
			 c21.setIcon(null);
		 }if(currx==2&&curry==2){
			 c= (ImageIcon) c22.getIcon();
			 c22.setIcon(null);
		 }if(currx==2&&curry==3){
			 c= (ImageIcon) c23.getIcon();
			 c23.setIcon(null);
		 }if(currx==2&&curry==4){
			 c= (ImageIcon) c24.getIcon();
			 c24.setIcon(null);
		 } if(currx==3&&curry==0){
			 c= (ImageIcon) c30.getIcon();
			 c30.setIcon(null);
		 }if(currx==3&&curry==1){
			 c= (ImageIcon) c31.getIcon();
			 c31.setIcon(null);
		 }if(currx==3&&curry==2){
			 c= (ImageIcon) c32.getIcon();
			 c32.setIcon(null);
		 }if(currx==3&&curry==3){
			 c= (ImageIcon) c33.getIcon();
			 c33.setIcon(null);
		 }if(currx==3&&curry==4){
			 c= (ImageIcon) c34.getIcon();
			 c34.setIcon(null);
		 }if(currx==4&&curry==0){
			 c= (ImageIcon) c40.getIcon();
			 c40.setIcon(null);
		 }if(currx==4&&curry==1){
			 c= (ImageIcon) c31.getIcon();
			 c41.setIcon(null);
		 }if(currx==4&&curry==2){
			 c= (ImageIcon) c32.getIcon();
			 c42.setIcon(null);
		 }if(currx==4&&curry==3){
			 c= (ImageIcon) c33.getIcon();
			 c43.setIcon(null);
		 }if(currx==4&&curry==4){
			 c= (ImageIcon) c34.getIcon();
			 c44.setIcon(null);
		 }
		
		 
			 
		 //adding icon in new cell using new positions
		 	 if(newx==0&&newy==0){
		 		 c00.setIcon(c);
		 	 }if(newx==0&&newy==1){
				 c01.setIcon(c);
			 }if(newx==0&&newy==2){
				 c02.setIcon(c);
			 }if(newx==0&&newy==3){
				 c03.setIcon(c);}
			 if(newx==0&&newy==4){
				 c04.setIcon(c);
			 }
			 if(newx==1&&newy==0){
				 c10.setIcon(c);
			 }if(newx==1&&newy==1){
				 c11.setIcon(c);
			 }if(newx==1&&newy==2){
				 c12.setIcon(c);
			 }if(newx==1&&newy==3){
				 c13.setIcon(c);
			 }if(newx==1&&newy==4){
				 c14.setIcon(c);
			 }
			 
			 if(newx==2&&newy==0){
				 c20.setIcon(c);
			 }if(newx==2&&newy==1){
				 c21.setIcon(c);
			 }if(newx==2&&newy==2){
				 c22.setIcon(c);
			 }if(newx==2&&newy==3){
				 c23.setIcon(c);
			 }if(newx==2&&newy==4){
				 c24.setIcon(c);
			 }
			 
			 if(newx==3&&newy==0){
				 c30.setIcon(c);
			 }if(newx==3&&newy==1){
				 c31.setIcon(c);
			 }if(newx==3&&newy==2){
				 c32.setIcon(c);
			 }if(newx==3&&newy==3){
				 c33.setIcon(c);
			 }if(newx==3&&newy==4){
				 c34.setIcon(c);
			 }
			 if(newx==4&&newy==0){
				 c40.setIcon(c);
			 }if(newx==4&&newy==1){
				 c41.setIcon(c);
			 }if(newx==4&&newy==2){
				 c42.setIcon(c);
			 }if(newx==4&&newy==3){
				 c43.setIcon(c);
			 }if(newx==4&&newy==4){
				 c44.setIcon(c);
			 }
		 
		 
		 mmove=false;
		 
		  }
	
		 { //cleaning board
			for(int i=0;i<5;i++) {
				
			for(int j =0;j<5;j++){
				
				if(((Damageable)game.getBoard()[i][j]).getCurrentHP()==0){
			 if(i==0&&j==0){
				
				 c00.setIcon(null);
				 }if(i==0&&j==1){
				
				 c01.setIcon(null);
				 }if(i==0&&j==2){
				
				 c02.setIcon(null);
			 }if(i==0&&j==3){
				
				 c03.setIcon(null);
			 }if(i==0&&j==4){
				
				 c04.setIcon(null);
			 } if(i==1&&j==0){
			
				 c10.setIcon(null);
			 }if(i==1&&j==1){
				
				 c11.setIcon(null);
			 }if(i==1&&j==2){
				
				 c12.setIcon(null);
			 }if(i==1&&j==3){
				
				 c13.setIcon(null);
			 }if(i==1&&j==4){
				
				 c14.setIcon(null);
			 }if(i==2&&j==0){
				
				 c20.setIcon(null);
			 }if(i==2&&j==1){
				
				 c21.setIcon(null);
			 }if(i==2&&j==2){
				
				 c22.setIcon(null);
			 }if(i==2&&j==3){
				
				 c23.setIcon(null);
			 }if(i==2&&j==4){
				
				 c24.setIcon(null);
			 } if(i==3&&j==0){
				 
				 c30.setIcon(null);
			 }if(i==3&&j==1){
				 c31.setIcon(null);
			 }if(i==3&&j==2){
				 c32.setIcon(null);
			 }if(i==3&&j==3){
				 c33.setIcon(null);
			 }if(i==3&&j==4){
				 c34.setIcon(null);
			 }if(i==4&&j==0){
				 c40.setIcon(null);
			 }if(i==4&&j==1){
				 c41.setIcon(null);
			 }if(i==4&&j==2){
				 c42.setIcon(null);
			 }if(i==4&&j==3){
				 c43.setIcon(null);
			 }if(i==4&&j==4){
				 c44.setIcon(null);}
			}}}
			 
			
			
			
			
			
			
			
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

