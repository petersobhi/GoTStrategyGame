/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipackage;

import gotstrategygame.*;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JFrame;
import com.sun.glass.ui.Cursor;
import gotstrategygame.Barracks;
import gotstrategygame.TextFileManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import static java.lang.Thread.sleep;
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
public class GameGUI extends JPanel implements Runnable {
    
    Game game;

    
    JPanel left = new JPanel();
    JPanel middle = new JPanel();
    JPanel right = new JPanel();
    
    
    StrategyGUI sGui;
    ArmyGUI aaGui;
    ArmyGUI abGui;
    

    
    public GameGUI(AllGUI allGui, Game game) throws IOException{
      this.game = game;
      
      
      sGui = new StrategyGUI(game);
      
      aaGui = new ArmyGUI(game.armyA,game.playerA,sGui);
      abGui = new ArmyGUI(game.armyB,game.playerB,sGui);
      Thread t1 = new Thread(aaGui);
      Thread t2 = new Thread(abGui);
      t1.start();
      t2.start();
      setLayout(null);
      setVisible(true);
      setSize(1920,1080);
      setBackground(Color.BLACK);
      
      this.add(left);
      this.add(middle);
      this.add(right);
      middle.setLayout(null);
         middle.add(sGui);
      left.setLayout(null);
      left.add(aaGui);
      left.setBounds(0, 0, 410, 1080);
      right.setLayout(null);
      right.add(abGui);
      right.setBounds(1510, 0, 410, 1080);
      middle.setBounds(410, 0, 1100, 1080);      
      
      
      
      
      
      
      
      
      
      /*Styling :
      
        left.setBackground(new Color(30,177,219));
        right.setBackground(Color.BLUE);
        bar.setBackground(Color.YELLOW);
       barracks.setBackground(Color.pink);
       info.setBackground(Color.orange);
       gold.setForeground(new Color(30,177,219));
       gold.setFont(new Font("Harrington",Font.BOLD,20));
      */
      
      
      
    }

    @Override
    public void run() {
        sGui.refresh(game);
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

