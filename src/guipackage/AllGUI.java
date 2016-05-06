/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipackage;

import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Peter
 */
public class AllGUI extends JFrame {
    public LoginGUI lg = new LoginGUI(this);
    public ChooseArmyGUI cag = new ChooseArmyGUI(this);
    public SignUpGUI sug = new SignUpGUI(this);
    public GameGUI gg;
            
    
    public AllGUI() throws IOException{
       
      setTitle("GOT");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setUndecorated(true);
      setResizable(false);
      getContentPane();
      setSize(1920,1080);
      setLayout(null);
      add(lg);
      lg.setVisible(true);
      add(cag);
      add(sug);
      cag.setVisible(false);
      sug.setVisible(false);
    
      
      setVisible(true);
    }
    
    
}
