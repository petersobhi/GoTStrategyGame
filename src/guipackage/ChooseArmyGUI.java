/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipackage;

import binaryfile.MyPlayer;
import javax.swing.JFrame;
import com.sun.glass.ui.Cursor;
import gotstrategygame.Army;
import gotstrategygame.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.metal.MetalBorders;

/**
 *
 * @author Peter
 */
public class ChooseArmyGUI extends JPanel {
    
     private JLabel background = new JLabel(new ImageIcon("army screen.png"));
     private JPanel panel = new JPanel();
     private JLabel q = new JLabel("Player One Choose your army");
     private JPanel qc = new JPanel();
     private JRadioButton sta = new JRadioButton(new ImageIcon("sta.jpg"));
     private JRadioButton lan = new JRadioButton(new ImageIcon("lan.jpg"));
     private JRadioButton tar = new JRadioButton(new ImageIcon("tar.jpg"));
     private ButtonGroup grp = new ButtonGroup();
     private JLabel msg = new JLabel("                           ");
     private JPanel msgc = new JPanel();
     private JButton launch = new JButton("Next");
     private JButton exit = new JButton("Sign Out");
     Army armyA;
     Army armyB;
     int counter=0;
     
    public ChooseArmyGUI(AllGUI allGui){
        /*
        setTitle("GOT");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setUndecorated(true);
      setResizable(false);
      getContentPane();
        */
      setLayout(null);
      setVisible(true);
      setSize(1920,1080);
      grp.add(sta);
      grp.add(lan);
      grp.add(tar);
      background.setBounds(0,0,1920,1080);
      
      panel.setBounds(560,300,800,500);
      add(panel);
      panel.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      
      panel.setBackground(new Color(255,255,255,50));
      gbc.insets = new Insets(10, 30, 10, 30);
      
      gbc.gridx =0;
      gbc.gridy =0;
      gbc.gridwidth = 3;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      panel.add(qc,gbc);
      
      gbc.gridx =0;
      gbc.gridy =1;
      gbc.gridwidth = 1;
      gbc.fill = GridBagConstraints.NONE;
      panel.add(sta,gbc);
      
      gbc.gridx =1;
      gbc.gridy =1;
      gbc.gridwidth = 1;
      panel.add(lan,gbc);
      
      gbc.gridx =2;
      gbc.gridy =1;
      gbc.gridwidth = 1;
      panel.add(tar,gbc);
      
      gbc.gridx =0;
      gbc.gridy =2;
      gbc.gridwidth = 3;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      panel.add(msgc,gbc);
      
      gbc.gridx = 0;
      gbc.gridy = 3;
      gbc.gridwidth =1;
      gbc.ipadx = 18;
      gbc.fill = GridBagConstraints.NONE;
      panel.add(exit,gbc);
      
      gbc.gridx = 2;
      gbc.gridy = 3;
      gbc.gridwidth =1;
      gbc.ipadx = 18;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      panel.add(launch,gbc);
      
      msgc.setLayout(new GridBagLayout());
      gbc.gridx =0;
      gbc.gridy =0;
      gbc.gridwidth = 1;
      gbc.fill = GridBagConstraints.NONE;
      msgc.add(msg,gbc);
       qc.setLayout(new GridBagLayout());
      qc.add(q,gbc);
      msgc.setBackground(new Color(111,113,124));
      qc.setBackground(new Color(111,113,124));
      
      q.setFont(new Font("Game Of Thrones",Font.PLAIN,20));
      q.setForeground(Color.BLACK);

      msg.setFont(new Font("Game Of Thrones",Font.PLAIN,20));
      msg.setForeground(Color.BLACK);
      
      sta.setBackground(Color.GRAY);
      tar.setBackground(Color.GRAY);
      lan.setBackground(Color.GRAY);
      sta.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));
        lan.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));
        tar.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));
      
     //sta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, false));
     sta.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
       sta.setBackground(Color.BLACK);
      tar.setBackground(Color.GRAY);
      lan.setBackground(Color.GRAY);
      msg.setText("Winter is coming");
        }
    });
     lan.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            sta.setBackground(Color.GRAY);
            tar.setBackground(Color.GRAY);
            lan.setBackground(Color.BLACK);
             msg.setText("A Lannister always pays his debts");
        }
    });
     tar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            sta.setBackground(Color.GRAY);
            tar.setBackground(Color.BLACK);
            lan.setBackground(Color.GRAY);
            msg.setText("Fire and Blood");
        }
    });
     
       exit.setFont(new Font("Game of Thrones",Font.PLAIN,17));
      exit.setBorderPainted(false);
      exit.setBackground(new Color(0,0,0));
      exit.setForeground(Color.GRAY);
      exit.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              allGui.lg.setVisible(true);
              allGui.cag.setVisible(false);
          }
      });
         
       launch.setFont(new Font("Game of Thrones",Font.PLAIN,20));
      launch.setBorderPainted(false);
      launch.setBackground(new Color(0,0,0));
      launch.setForeground(Color.GRAY);
      launch.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
                
                  if(sta.isSelected()){
                  
                  //Game game = new Game();
                  if (counter==0){
                      try {
                          armyA = new Army(5000,1,"army_units/stark.txt");
                      } catch (IOException ex) {
                          Logger.getLogger(ChooseArmyGUI.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  counter++;
                  q.setText("Player Two Choose your Army");
                  launch.setText("Launch");
                  grp.clearSelection();
                  }
                  }
                  
                  
                  if(sta.isSelected()){
                  if (counter==1 ){
                      try {
                          armyB = new Army(5000,1,"army_units/stark.txt");
                      } catch (IOException ex) {
                          Logger.getLogger(ChooseArmyGUI.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  counter++;
                  }
                  }    
                  //test
                  //game.armyB = new Army(5000,1,"army_units/lannister.txt");

                  
                 
                  //System.out.println("stark not found");
                  
      
              
                  if(lan.isSelected()){
                  
                   if (counter==0){
                       try {
                           armyA = new Army(5000,2,"army_units/lannister.txt");
                       } catch (IOException ex) {
                           Logger.getLogger(ChooseArmyGUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
                  counter++;
                  q.setText("Player Two Choose your Army");
                  launch.setText("Launch");
                  grp.clearSelection();
                  }
                  }
                  if(lan.isSelected()){
                  if (counter==1){
                      try {
                          armyB = new Army(5000,2,"army_units/lannister.txt");
                      } catch (IOException ex) {
                          Logger.getLogger(ChooseArmyGUI.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  counter++;
                  }
                  
                  }
                  
                  if(tar.isSelected()){
                  
                  if (counter==0){
                      try {
                          armyA = new Army(5000,3,"army_units/targeryen.txt");
                      } catch (IOException ex) {
                          Logger.getLogger(ChooseArmyGUI.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  counter++;
                  q.setText("Player Two Choose your Army");
                  launch.setText("Launch");
                  grp.clearSelection();
                  }
                  }
                  if(tar.isSelected()){
                  if (counter==1){
                      try {
                          armyB = new Army(5000,3,"army_units/targeryen.txt");
                      } catch (IOException ex) {
                          Logger.getLogger(ChooseArmyGUI.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  counter++;
                  }
                  
                  
                  
                  }
                  
                  if(counter==2){
                  
                      try {
                          allGui.gg = new GameGUI(allGui,new Game(armyA,armyB,new MyPlayer(),new MyPlayer()));
                      } catch (IOException ex) {
                          Logger.getLogger(ChooseArmyGUI.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  Thread t = new Thread(allGui.gg);
                  t.start();
                  allGui.cag.setVisible(false);
                  allGui.add(allGui.gg);
                  }
          }
      });
      
   
      add(background);
    }
}
