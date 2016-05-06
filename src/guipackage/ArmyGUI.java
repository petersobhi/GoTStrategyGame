/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipackage;

import binaryfile.MyPlayer;
import gotstrategygame.Army;
import gotstrategygame.Barracks;
import gotstrategygame.Blacksmith;
import gotstrategygame.Game;
import gotstrategygame.GoldMine;
import gotstrategygame.TextFileManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Peter
 */
public class ArmyGUI extends JPanel implements Runnable{
    JPanel bar = new JPanel();
    
    JLabel gold = new JLabel("Gold: ");
    JLabel goldMineGold = new JLabel("Goldmine: ");
    JLabel score = new JLabel("Score: ");
    
    
    JButton buyBarracks = new JButton("Barracks (Goldmine required)");
    JButton buyGoldMine = new JButton("Buy Goldmine - Cost: "+GoldMine.firstCost);
    JButton buyBlacksmith = new JButton("Blacksmith (Barracks required)");
    
    JPanel barracks = new JPanel();
    JButton[] unit = new JButton[5];
    
    JPanel info = new JPanel();
    JLabel[] infoLabel = new JLabel[5];
    JLabel infoPic = new JLabel();
    
    
    boolean checkGoldMine = false;
    boolean checkBarracks = false;
    boolean checkBlacksmith = false;
    boolean checkHero = false;
    boolean checkMonster = false;
    Game game;
    StrategyGUI sGui;
    Army myArmy;
    MyPlayer myPlayer;
    public ArmyGUI(Army myArmy,MyPlayer myPlayer,StrategyGUI sGui){
        
      this.myPlayer = myPlayer;
      this.myArmy = myArmy;
      this.sGui = sGui;
     this.setSize(410, 1080);
     bar.setLayout(null);
     this.setVisible(true);
      bar.add(gold);
      bar.add(goldMineGold);
      bar.add(score);
      gold.setBounds(20, 10, 300, 50);
      goldMineGold.setBounds(20, 60, 300, 50);
      score.setBounds(20, 110, 300, 40);
      
      this.setLayout(null);
      this.add(bar);
      bar.setBounds(0,0,800,150);
      this.add(barracks);
      this.add(info);
      this.add(buyBarracks);
      this.add(buyGoldMine);
      this.add(buyBlacksmith);
      
      buyBarracks.setBounds(40, 200, 300, 70);
      buyGoldMine.setBounds(40, 280, 300, 70);
      buyBlacksmith.setBounds(40, 360, 300, 70);
      
       
      barracks.setBounds(90, 500, 200, 300);
      barracks.setLayout(new GridLayout(5, 0));
      
      
      info.setBounds(5, 870, 400, 210);
      info.setLayout(null);
      info.setVisible(false);
      
      barracks.setVisible(false);
      
        for (int i = 0; i < 5; i++) {
            unit[i] = new JButton(myArmy.getUnitsNames(i)/* + " Price: "+ game.armyA.getUnitsPrices(i)*/);
            barracks.add(unit[i]);
        }
        unit[4].setText("Hero Required");
        unit[4].setEnabled(false);
        
        for (int i = 0; i < 5; i++) {
            infoLabel[i] = new JLabel("");
            infoLabel[i].setFont(new Font("Arial",Font.BOLD,15));
            infoLabel[i].setBounds(10, i*40, 260 , 40);
            info.add(infoLabel[i]);
        }
        
        info.add(infoPic);
        infoPic.setBounds(230, 15, 200, 200);
        
        ButtonHandler btnh = new ButtonHandler();
        
         buyBarracks.addActionListener(btnh);
         buyGoldMine.addActionListener(btnh);
         buyBlacksmith.addActionListener(btnh);
         unit[0].addActionListener(btnh);
         unit[1].addActionListener(btnh);
         unit[2].addActionListener(btnh);
         unit[3].addActionListener(btnh);
         unit[4].addActionListener(btnh);
         
         unit[0].addMouseListener(btnh);
         unit[1].addMouseListener(btnh);
         unit[2].addMouseListener(btnh);
         unit[3].addMouseListener(btnh);
         unit[4].addMouseListener(btnh);
        
         //Style:
         this.setBackground(Color.black);
         bar.setBackground(new Color(58, 69, 112));
         gold.setForeground(Color.white);
         goldMineGold.setForeground(Color.white);
         score.setForeground(Color.white);
         gold.setFont(new Font("Calibri", Font.PLAIN, 20));
         goldMineGold.setFont(new Font("Calibri", Font.PLAIN, 20));
         score.setFont(new Font("Calibri", Font.PLAIN, 20));
         
         buyBarracks.setBorder(BorderFactory.createLineBorder(Color.white, 3));
         buyBarracks.setForeground(Color.white);
         buyBarracks.setBackground(new Color(132,117,124));
         buyBarracks.setFont(new Font("Calibri",Font.PLAIN, 16));
         buyGoldMine.setBorder(BorderFactory.createLineBorder(Color.white, 3));
         buyGoldMine.setForeground(Color.white);
         buyGoldMine.setBackground(new Color(132,117,124));
         buyGoldMine.setFont(new Font("Calibri",Font.PLAIN, 16));
         buyBlacksmith.setBorder(BorderFactory.createLineBorder(Color.white, 3));
         buyBlacksmith.setForeground(Color.white);
         buyBlacksmith.setBackground(new Color(132,117,124));
         buyBlacksmith.setFont(new Font("Calibri",Font.PLAIN, 16));
         
         for (int i = 0; i < 5; i++) {
            unit[i].setBorder(BorderFactory.createLineBorder(Color.white, 1));
            unit[i].setForeground(Color.white);
            unit[i].setBackground(new Color(58, 69, 112));
            unit[i].setFont(new Font("Game Of Thrones",Font.PLAIN,10));
            
            }
         infoLabel[0].setFont(new Font ("Corbel",Font.BOLD,20));
         infoLabel[1].setIcon(new ImageIcon("pics/attack.png"));
         infoLabel[2].setIcon(new ImageIcon("pics/armor2.png"));
         infoLabel[3].setIcon(new ImageIcon("pics/health.png"));
         infoLabel[4].setIcon(new ImageIcon("pics/gold.png"));
         
      
      
      
    }

    @Override
    public void run() {
        
        while(true){
        //sGui.mu.refresh();
        goldCheck();
        
        if(checkGoldMine == true){
            gold.setText("Gold: "+myArmy.getGold()+" (+ "+myArmy.gm.getIncrement()+" per second)");
            goldMineGold.setText("Goldmine: "+myArmy.gm.getGold());
        }else gold.setText("Gold: "+myArmy.getGold());
        score.setText("Score: "+myPlayer.getScore());
        try {
            sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    public void goldCheck(){
        for (int i = 0; i < 3; i++) {
            if(myArmy.getGold() < myArmy.getUnitsPrices(i))
                unit[i].setEnabled(false);
            else unit[i].setEnabled(true);
        }
        if(checkHero == false){
            if(myArmy.getGold() < myArmy.getUnitsPrices(3)){
                unit[3].setEnabled(false);
            }else unit[3].setEnabled(true);
        }
        if(checkMonster == false && checkHero == true){
            if(myArmy.getGold() < myArmy.getUnitsPrices(4)){
                unit[4].setEnabled(false);
            }else unit[4].setEnabled(true);
        }
        
        
        if(checkGoldMine == false){
        if ( myArmy.getGold() <= myArmy.gm.firstCost){
            buyGoldMine.setEnabled(false);
       }else buyGoldMine.setEnabled(true);
        }
        
        else if(checkGoldMine == true){
            if ( myArmy.getGold() <= myArmy.gm.getCost()){
            buyGoldMine.setEnabled(false);
       }else buyGoldMine.setEnabled(true);
        }
         
       
        /*
       if ( myArmy.getGold() <= myArmy.b.firstCost){
            buyBarracks.setEnabled(false);
       }else buyBarracks.setEnabled(true);
       */
       
       if(checkBlacksmith == false){
        if ( myArmy.getGold() <= myArmy.bs.firstCost){
            buyBlacksmith.setEnabled(false);
       }else buyBlacksmith.setEnabled(true);
       }
       else if(checkBlacksmith == true){
            if ( myArmy.getGold() <= myArmy.bs.getCost()){
            buyBlacksmith.setEnabled(false);
       }else buyBlacksmith.setEnabled(true);
                }
       
       if(checkBarracks == false)
           buyBlacksmith.setEnabled(false);
       if(checkGoldMine == false)
           buyBarracks.setEnabled(false);
                
    }
    
    
    private class ButtonHandler implements ActionListener, MouseListener{
        @Override
        public void actionPerformed(ActionEvent e) {
                
            
            
                if(e.getSource() == buyBarracks){
                myArmy.buyBarracks();
                barracks.setVisible(true);
                checkBarracks = true;
                buyBarracks.setEnabled(false);
                buyBarracks.setText("Unavailable");
                buyBlacksmith.setEnabled(true);
                buyBlacksmith.setText("Buy Blacksmith - Cost: "+Blacksmith.firstCost);
                }
                
                if(e.getSource() == buyGoldMine){
                    if(checkGoldMine== false){
                            myArmy.buyGoldMine();
                            checkGoldMine = true;
                            buyGoldMine.setText("Upgrade Goldmine - Cost: "+myArmy.gm.getCost()+" - Level: "+myArmy.gm.getLevel());
                            buyBarracks.setEnabled(true);
                            buyBarracks.setText("Buy Barracks - Cost: "+Barracks.firstCost);
                        
                    }
                    else if(checkGoldMine == true){
                        myArmy.gm.upgrade();
                        buyGoldMine.setText("Upgrade Goldmine - Cost: "+myArmy.gm.getCost()+" - Level: "+myArmy.gm.getLevel());
                    }
                }
                
                if(e.getSource() == buyBlacksmith){
                    if(checkBlacksmith == false && checkBarracks == true){
                        myArmy.buyBlacksmith();
                        checkBlacksmith = true;
                        buyBlacksmith.setText("Upgrade Blacksmith - Colst: "+myArmy.bs.firstCost+" - Level: 1");
                    }
                    
                    else if(checkBlacksmith == true){
                        myArmy.bs.upgradeBlacksmith();
                        buyBlacksmith.setText("Upgrade Blacksmith - Colst: "+myArmy.bs.getCost()+" - Level: "+myArmy.bs.getLevel());
                    }
                    
                }
                    
                
                
                if(e.getSource() == unit[0]){
                    try {
                        myArmy.b.buySoldier();
                    } catch (IOException ex) {
                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if(e.getSource() == unit[1]){
                    try {
                        myArmy.b.buyArcher();
                    } catch (IOException ex) {
                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if(e.getSource() == unit[2]){
                    try {
                        myArmy.b.buyMagician();
                    } catch (IOException ex) {
                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                barracks.setVisible(true);
                }
                
                if(e.getSource() == unit[3]){
                    try {
                        myArmy.b.buyHero();
                        unit[3].setEnabled(false);
                        checkHero = true;
                        unit[4].setEnabled(true);
                        unit[4].setText(myArmy.getUnitsNames(4));
                        unit[3].setText("Unavailable");
                    } catch (IOException ex) {
                        Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                  
                    }
                }
                    
                    
                 if(e.getSource() == unit[4]){
                        try {
                            myArmy.b.buyMonster();
                            unit[4].setEnabled(false);
                            checkMonster = true;
                            unit[4].setText("Unavailable");
                        } catch (IOException ex) {
                            Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                 }
                 sGui.muA.refresh();
                 sGui.muB.refresh();
                }
                
       

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            TextFileManager tfm = new TextFileManager();
            String[] inf;
            info.setVisible(true);
            
            if (e.getSource() == unit[0]){
                try {
                    inf = tfm.readAll(new File(myArmy.getFilepath()));
                    String name= inf[0];
                    int attackDamage = Integer.parseInt(inf[1]);
                    int armor = Integer.parseInt(inf[2]);
                    int maxHealth = Integer.parseInt(inf[3]);
                    int unitCost = Integer.parseInt(inf[4]);
                    infoLabel[0].setText(name);
                    
                    infoLabel[1].setText("  "+attackDamage+" (Bonus: "+myArmy.b.getAttackBonus()+")");
                    infoLabel[2].setText("  "+armor+" (Bonus: "+myArmy.b.getArmorBonus()+")");
                    infoLabel[3].setText("  "+maxHealth+" (Bonus: "+myArmy.b.getHealthBonus()+")");
                    infoLabel[4].setText("  "+unitCost);
                    String picPath = null;
                    switch(name){
                        case "Northern Soldier": picPath="pics/s1.jpg"; break;
                        case "King's Guards": picPath= "pics/l1.jpg"; break;
                        case "Unsullied Soldier": picPath="pics/t1.png"; break;
                    }
                    infoPic.setIcon(new ImageIcon(picPath));
                } catch (IOException ex) {
                    System.out.println("TFM ERROR");
                }
             }
            
            if (e.getSource() == unit[1]){
                try {
                    inf = tfm.readAll(new File(myArmy.getFilepath()));
                    String name= inf[5];
                    int attackDamage = Integer.parseInt(inf[6]);
                    int armor = Integer.parseInt(inf[7]);
                    int maxHealth = Integer.parseInt(inf[8]);
                    int unitCost = Integer.parseInt(inf[9]);
                    infoLabel[0].setText(name);
                    infoLabel[1].setText("  "+attackDamage+" (Bonus: "+myArmy.b.getAttackBonus()+")");
                    infoLabel[2].setText("  "+armor+" (Bonus: "+myArmy.b.getArmorBonus()+")");
                    infoLabel[3].setText("  "+maxHealth+" (Bonus: "+myArmy.b.getHealthBonus()+")");
                    infoLabel[4].setText("  "+unitCost);
                    String picPath = null;
                    switch(name){
                        case "Northern Archer": picPath="pics/s2.jpg"; break;
                        case "Lannisters' Archer": picPath= "pics/l2.jpg"; break;
                        case "Targeryens' Archer": picPath="pics/t2.jpg"; break;
                    }
                    infoPic.setIcon(new ImageIcon(picPath));
                } catch (IOException ex) {
                    System.out.println("TFM ERROR");
                }
             }
            
            if (e.getSource() == unit[2]){
                try {
                    inf = tfm.readAll(new File(myArmy.getFilepath()));
                    String name= inf[10];
                    int attackDamage = Integer.parseInt(inf[11]);
                    int armor = Integer.parseInt(inf[12]);
                    int maxHealth = Integer.parseInt(inf[13]);
                    int unitCost = Integer.parseInt(inf[14]);
                    infoLabel[0].setText(name);
                    infoLabel[1].setText("  "+attackDamage+" (Bonus: "+myArmy.b.getAttackBonus()+")");
                    infoLabel[2].setText("  "+armor+" (Bonus: "+myArmy.b.getArmorBonus()+")");
                    infoLabel[3].setText("  "+maxHealth+" (Bonus: "+myArmy.b.getHealthBonus()+")");
                    infoLabel[4].setText("  "+unitCost);
                    String picPath = null;
                    switch(name){
                        case "Northern Magician": picPath="pics/s3.png"; break;
                        case "Lannisters' Magician": picPath= "pics/l3.png"; break;
                        case "Targeryens' Magician": picPath="pics/t3.png"; break;
                    }
                    infoPic.setIcon(new ImageIcon(picPath));
                } catch (IOException ex) {
                    System.out.println("TFM ERROR");
                }
             }
            
            if (e.getSource() == unit[3]){
                try {
                    inf = tfm.readAll(new File(myArmy.getFilepath()));
                    String name= inf[15];
                    int attackDamage = Integer.parseInt(inf[16]);
                    int armor = Integer.parseInt(inf[17]);
                    int maxHealth = Integer.parseInt(inf[18]);
                    int unitCost = Integer.parseInt(inf[19]);
                    infoLabel[0].setText(name);
                    infoLabel[1].setText("  "+attackDamage+" (Bonus: "+myArmy.b.getAttackBonus()+")");
                    infoLabel[2].setText("  "+armor+" (Bonus: "+myArmy.b.getArmorBonus()+")");
                    infoLabel[3].setText("  "+maxHealth+" (Bonus: "+myArmy.b.getHealthBonus()+")");
                    infoLabel[4].setText("  "+unitCost);
                    String picPath = null;
                    switch(name){
                        case "John Snow": picPath="pics/s4.png"; break;
                        case "Taywan Lannister": picPath= "pics/l4.png"; break;
                        case "Denarys Targeryan": picPath="pics/t4.png"; break;
                    }
                    infoPic.setIcon(new ImageIcon(picPath));
                } catch (IOException ex) {
                    System.out.println("TFM ERROR");
                }
             }
            
            if (e.getSource() == unit[4]){
                try {
                    inf = tfm.readAll(new File(myArmy.getFilepath()));
                    String name= inf[20];
                    int attackDamage = Integer.parseInt(inf[21]);
                    int armor = Integer.parseInt(inf[22]);
                    int maxHealth = Integer.parseInt(inf[23]);
                    int unitCost = Integer.parseInt(inf[24]);
                    infoLabel[0].setText(name);
                    infoLabel[1].setText("  "+attackDamage+" (Bonus: "+myArmy.b.getAttackBonus()+")");
                    infoLabel[2].setText("  "+armor+" (Bonus: "+myArmy.b.getArmorBonus()+")");
                    infoLabel[3].setText("  "+maxHealth+" (Bonus: "+myArmy.b.getHealthBonus()+")");
                    infoLabel[4].setText("  "+unitCost);
                    String picPath = null;
                    switch(name){
                        case "Wolf": picPath="pics/s5.png"; break;
                        case "Lion": picPath= "pics/l5.png"; break;
                        case "Dragon": picPath="pics/t5.png"; break;
                    }
                    infoPic.setIcon(new ImageIcon(picPath));
                } catch (IOException ex) {
                    System.out.println("TFM ERROR");
                }
             }
            
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
                    /*infoLabel[0].setText("");
                    infoLabel[1].setText("");
                    infoLabel[2].setText("");
                    infoLabel[3].setText("");
                    infoLabel[4].setText("");
                    infoPic.setIcon(null);
                    */
                    info.setVisible(false);
        }
    }
    }



