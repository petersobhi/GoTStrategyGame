/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipackage;

import gotstrategygame.Game;
import gotstrategygame.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javafx.scene.paint.Color.color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Peter
 */
public class StrategyGUI extends JPanel {
    
    Game game;
    Map mp;
    MyUnits muA;
    MyUnits muB;
    Unit tempUA;
    Unit tempUB;
    JLabel tempULabel = new JLabel();
    
    
    public StrategyGUI(Game game){
        this.game = game;
        muA = new MyUnits(game.armyA);
        muA.setBounds(0,900,1120,180);
        muB = new MyUnits(game.armyB);
        muB.setBounds(0, 0, 1120, 180);
        this.setLayout(null);
        this.add(muA);
        this.add(muB);
        Map mp = new Map();
        this.add(mp);
        this.add(tempULabel);
        tempULabel.setBounds(50, 180, 400, 20);
        tempULabel.setForeground(Color.WHITE);
        this.setSize(1120, 1080);
        
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                game.getMap()[i][j].start();
            }
        }
        
        //styling
          //this.setBackground(new Color(30,30,30));
        this.setBackground(Color.black);

        }
    
    public void refresh(Game game){
        this.game = game;
    }
    
    
    private class Map extends JPanel{
        Color myColor;
        
        @Override
        public void paint(Graphics g){
            myColor = g.getColor();
            super.paint(g);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(i==0 & j==0)
                        myColor = g.getColor();
                    if(game.getMap()[i][j].getUnitA() != null){
                    g.setColor(Color.black);
                    g.setFont(new Font("Arial",Font.PLAIN,11));
                    g.drawString(game.getMap()[i][j].getUnitA().getName(),i*100+1, j*70+50);
                    int hp =  game.getMap()[i][j].getUnitA().getHealth();
                    int maxhp =  game.getMap()[i][j].getUnitA().getMaxHealth();
                    g.setColor(Color.white);
                    g.fillRect(i*100+5, j*70+55, 90, 10);
                    g.setColor(Color.red);
                    g.fillRect(i*100+5, j*70+55, hp*90/maxhp  , 10);
                    g.setColor(myColor);
                    }
                    
                    //test
                    if(game.getMap()[i][j].getUnitB() != null){
                    g.setColor(Color.blue);
                    g.setFont(new Font("Arial",Font.PLAIN,11));
                    g.drawString(game.getMap()[i][j].getUnitB().getName(),i*100+1, j*70+10);
                    int hp =  game.getMap()[i][j].getUnitB().getHealth();
                    int maxhp =  game.getMap()[i][j].getUnitB().getMaxHealth();
                    g.setColor(Color.white);
                    g.fillRect(i*100+5, j*70+15, 90, 9);
                    g.setColor(Color.ORANGE);
                    g.fillRect(i*100+5, j*70+15, hp*90/maxhp  , 10);
                    g.setColor(myColor);
                    }
                    g.drawRect(i*100, j*70, 100, 70);
                }
            }
            repaint();
        }
        
        public Map(){
            
            game.createMap();
            this.setBounds(50,200,1001,700);
            this.setBackground(new Color(0 ,128,64));
            this.setBorder(BorderFactory.createLineBorder(Color.green, 5));
            this.addMouseListener(new MouseListener() {
            
                public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                int x =e.getX()/100;
                int y =e.getY()/70;
                
                //Paste:
                if(! (game.getMap()[x][y].getUnitA() != null && game.getMap()[x][y].getUnitB() != null)){
                if(tempUA != null  && game.getMap()[x][y].getUnitA() == null){
                game.moveUnitA(tempUA, game.getMap()[x][y]);
                muA.refresh();
                tempUA=null;
                tempULabel.setText("");
                }
                
                //Copy:
                else if(tempUA == null && (game.getMap()[x][y].getUnitA() != null)){
                    tempUA= game.getMap()[x][y].getUnitA();
                    game.getMap()[x][y].setUnitA(null);
                    tempULabel.setText("Click on a place to move "+tempUA.getName());
                    muA.refresh();
                }
                
                }
                }
                
                if(e.getButton() == MouseEvent.BUTTON3){
                int x =e.getX()/100;
                int y =e.getY()/70;
                if(! (game.getMap()[x][y].getUnitA() != null && game.getMap()[x][y].getUnitB() != null)){
                //Paste:
                if(tempUB != null  && game.getMap()[x][y].getUnitB() == null){
                game.moveUnitB(tempUB, game.getMap()[x][y]);
                muB.refresh();
                tempUB=null;
                tempULabel.setText("");
                }
                
                //Copy:
                else if(tempUB == null && (game.getMap()[x][y].getUnitB() != null)){
                    tempUB= game.getMap()[x][y].getUnitB();
                    game.getMap()[x][y].setUnitB(null);
                    tempULabel.setText("Click on a place to move "+tempUB.getName());
                    muB.refresh();
                }
                }
                
                }
                
                }
                public void mousePressed(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}
            });
            
            
            
            
            
        }
        
        
    }
    
    
    
    
    public class MyUnits extends JPanel{
      
        GridBagConstraints gbc = new GridBagConstraints();
        Army usedArmy;
        
        private MyUnits(Army usedArmy){
        this.usedArmy = usedArmy;
        gbc.insets = new Insets(3, 3, 3, 3);
        this.setLayout(new GridBagLayout());
        //this.setBounds(0,900,1120,180);
        
        //Style:
                this.setBackground(Color.black);
                
        }
        
        public void refresh(){
            removeAll();
            setVisible(false);
            setVisible(true);
            int x=0;
            for (int i = 0; i < usedArmy.getUnits().size() ; i++) {
                gbc.gridx=x;
                x++;
                if(x==4)
                    x=0;
                gbc.gridy=i/4;
                JButton mu = new JButton(usedArmy.getUnits().get(i).getName());
                
                //Style:
                if(usedArmy == game.armyA)
                mu.setBackground(new Color(128,80,53));
                if(usedArmy == game.armyB)
                mu.setBackground(new Color(18,80,53));
                mu.setFont(new Font("Harrington",Font.BOLD,20));
                
                add(mu,gbc);
                mu.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton temp = (JButton) e.getSource();
                        String uname = temp.getText();
                        
                           
                                for (Unit u : usedArmy.getUnits()){
                                    if(u.getName().equals(uname)){
                                        if(usedArmy == game.armyA && tempUA == null){
                                            tempUA = u;
                                            game.deleteUnitA(u);
                                        }
                                            
                                        if(usedArmy == game.armyB && tempUB == null){
                                            tempUB = u;
                                            game.deleteUnitB(u);
                                        }
                                            
                                        tempULabel.setText("Click on a place to move "+uname);
                                        break;
                                    }
                               
                            }
                        
                    }
                });
            }
        }
    }        
}
