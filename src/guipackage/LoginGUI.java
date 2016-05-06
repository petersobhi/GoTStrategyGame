/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipackage;

import binaryfile.MyPlayer;
import com.sun.glass.ui.Cursor;
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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.metal.MetalBorders;

/**
 *
 * @author Biro
 */
public class LoginGUI extends JPanel {
    //private JLabel L = new JLabel("WeLcome To Game Of The Thrones Strategy Game");

    private JLabel background=new JLabel(new ImageIcon("login screen.png"));
    
    private JLabel username= new JLabel("Username");
    private JLabel password= new JLabel("Password");
    private JTextField username2 = new JTextField(12);
    private JPasswordField password2 = new JPasswordField(12);
    private JCheckBox rembmer= new JCheckBox("Rembmer Username");
    private JButton login= new JButton("Log In");
    private JButton signup = new JButton("Sign Up");
    private JButton exit = new JButton("Exit");
    
    private JPanel loginErrorP = new JPanel();
    private JLabel loginError = new JLabel("");
    
    private JLabel playerTurn = new JLabel("Player one enter your info");
      
    
    AllGUI allGui;
    int counter;
   
    /*
    private JButton username= new JButton("Username");
    private JButton password= new JButton("Password");
    private JButton username2 = new JButton("Username");
    private JButton password2 = new JButton("Password");
    private JButton rembmer= new JButton("Rembmer Username");
    private JButton login= new JButton("Log In");
    */
    
    public LoginGUI(AllGUI allGui)
    {
        this.allGui = allGui;
        /*
      setTitle("GOT");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setUndecorated(true);
      setResizable(false);
      getContentPane();
                */
      //Container Holder = getContentPane();
      setSize(1920,1080);
      JPanel myj = new JPanel();
      setLayout(null);
      
      playerTurn.setBounds(800, 220, 400, 100);
      add(playerTurn);
      playerTurn.setForeground(Color.black);
      playerTurn.setFont(new Font("Corbel", Font.BOLD, 25));
      
      GridBagConstraints gbc = new GridBagConstraints();
      
      myj.setLayout(new GridBagLayout());
      add(myj);
      

      myj.setBounds(710,300,500,250);
      gbc.gridx =0;
      gbc.gridy = 0;
      gbc.gridwidth =1;
      gbc.insets = new Insets(20, 15, 5, 15);
      gbc.fill = GridBagConstraints.NONE;
      myj.add(username,gbc); 
      
      gbc.gridx =1;
      gbc.gridy = 0;
      gbc.gridwidth =2;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      myj.add(username2,gbc);
      
      gbc.insets = new Insets(5, 15, 5, 15);
      gbc.gridx =0;
      gbc.gridy = 1;
      gbc.gridwidth =1;
      gbc.fill = GridBagConstraints.NONE;
      myj.add(password,gbc);
      
      gbc.gridx =1;
      gbc.gridy = 1;
      gbc.gridwidth =2;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      myj.add(password2,gbc);
      
      gbc.gridx =0;
      gbc.gridy = 2;
      gbc.gridwidth =2;
      gbc.fill = GridBagConstraints.NONE;
      //myj.add(rembmer,gbc);
      
      
      gbc.gridx=1;
      gbc.gridy=2;
      gbc.gridwidth=2;
      gbc.weighty = 0.2;
      gbc.weightx = 0.3;
      gbc.fill = GridBagConstraints.BOTH;
      myj.add(loginErrorP,gbc);
      
      gbc.gridx =1;
      gbc.gridy = 4;
      gbc.gridwidth = 1;
      gbc.weighty = 0.4;
      //gbc.weightx =1;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      myj.add(login,gbc);
      
      gbc.gridx = 0;
      gbc.gridy = 4;
      gbc.gridwidth =1;
      gbc.fill = GridBagConstraints.NONE;
      myj.add(signup,gbc);
      
      gbc.gridx = 2;
      gbc.gridy = 4;
      gbc.gridwidth =1;
      gbc.ipadx = 18;
      gbc.fill = GridBagConstraints.NONE;
      myj.add(exit,gbc);
      
      
      myj.setBackground(new Color (0.0f,0.0f,0.0f,0.25f));
      myj.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
      
      add(background);
      

      username.setFont(new Font("Game of Thrones",Font.PLAIN,18));
      username.setForeground(Color.black);

      username2.setFont(new Font("Corbel",Font.PLAIN,24));
      username2.setBackground(new Color(107,89,77));
      username2.setForeground(Color.BLACK);
      username2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
     

      password.setFont(new Font("Game of Thrones",Font.PLAIN,18));
      password.setForeground(Color.black);

      password2.setFont(new Font("Corbel",Font.PLAIN,24));
      password2.setBackground(new Color(107,89,77));
      password2.setForeground(Color.BLACK);
      password2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

      login.setFont(new Font("Game of Thrones",Font.PLAIN,22));
      login.setBorderPainted(false);
      login.setBackground(new Color(0f,0f,0f));
      login.setForeground(Color.GRAY);
      
      loginErrorP.setLayout(null);
      loginErrorP.setBackground(new Color(107,89,77));
      loginError.setBounds(0, 0, 300, 30);
      loginErrorP.add(loginError);
      loginError.setForeground(Color.red);
      loginError.setFont(new Font("Corbel",Font.PLAIN,18));
      
      Handler hand = new Handler();
      
      login.addActionListener(hand);
       username2.addActionListener(hand);
       password2.addActionListener(hand);
       username2.addFocusListener(hand);
       password2.addFocusListener(hand);
      
      
      signup.setFont(new Font("Game of Thrones",Font.PLAIN,17));
      signup.setBorderPainted(false);
      signup.setBackground(new Color(0f,0f,0f));
      signup.setForeground(Color.GRAY);
      signup.addActionListener(new ActionListener() {
            @Override
          public void actionPerformed(ActionEvent e) {
              allGui.lg.setVisible(false);
              allGui.sug.setVisible(true);
          }
      });
      
      
      exit.setFont(new Font("Game of Thrones",Font.PLAIN,17));
      exit.setBorderPainted(false);
      exit.setBackground(new Color(0f,0f,0f));
      exit.setForeground(Color.GRAY);
      exit.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              System.exit(0);
          }
      });
      
      rembmer.setBackground(new Color(107,89,77));
      rembmer.setFont(new Font("Corbel",Font.PLAIN,19));
      rembmer.setForeground(Color.BLACK);
      background.setBounds(0,0,1920,1080);
      setVisible(true);
    }
    
    private class Handler implements ActionListener , FocusListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
           
            
            
            if (e.getSource() == login)
            {
                String userName = username2.getText();
                String password = String.valueOf(password2.getPassword());
                String info;
                MyPlayer newPlayer = new MyPlayer (userName,password);
                HashMap <String,String> map = new HashMap<String,String>();
                if (!userName.equals("") && !password.equals(""))
                {
                if (newPlayer.isThereAPlayer())
                {
                    
                    try {
                        map = newPlayer.getMyHashMap(newPlayer.loadPlayers());
                    } catch (IOException ex) {
                        Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                info = map.get(userName);
                if (info==null)loginError.setText("The username is incorrect");
                else 
                {
                if (info.equals(password)) {
                counter++;
                username2.setText("");
                password2.setText("");
                playerTurn.setText("Player two enter your turn");
                }  
                else loginError.setText("The Password is incorrect");
                
                }
                
                }
                else loginError.setText("The username or the password is incorrect");
                }else loginError.setText("Please enter username and password");
            }
            
            if (counter == 2){
                allGui.lg.setVisible(false);allGui.cag.setVisible(true);
            }
            
        }

        @Override
        public void focusGained(FocusEvent e) {
             if(e.getSource() == username2 || e.getSource() == password2){
                loginError.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {}
        
    }
    
}
