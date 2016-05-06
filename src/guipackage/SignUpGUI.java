/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipackage;



import binaryfile.MyPlayer;
import guipackage.AllGUI;
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

public class SignUpGUI extends JPanel{
    
    private JLabel background=new JLabel(new ImageIcon("signup screen.png"));
    
    private JLabel username= new JLabel("Username");
    private JLabel password= new JLabel("Password");
    private JTextField username2 = new JTextField(10);
    private JPasswordField password2 = new JPasswordField(10);
    private JLabel repassword= new JLabel("Re Enter Password");
    private JPasswordField repassword2 = new JPasswordField(10);
    private JButton signup = new JButton("Sign Up");
    private JButton back = new JButton("Back");
    private JLabel passwordError = new JLabel("The two password doesn`t match");
    private JLabel usernameError = new JLabel("this username is already used");
    
    JPanel panel = new JPanel();
    AllGUI allGui;
    public SignUpGUI(AllGUI allGui){
       this.allGui=allGui; 
      
      /*
      setTitle("SignUp");
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setUndecorated(true);
      setResizable(false);
      getContentPane();
              */
      setVisible(true);
      setSize(1920,1080);
      //Container Holder = getContentPane();
      
      setLayout(null);
      
  
      
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(5, 15, 5, 15);
      panel.setLayout(new GridBagLayout());
      add(panel);
      panel.setBounds(680,300,550,270);
      
      gbc.gridx =0;
      gbc.gridy = 0;
      gbc.gridwidth =1;
      panel.add(username,gbc); 
      
      gbc.gridx =1;
      gbc.gridy = 0;
      gbc.gridwidth =2;
      panel.add(username2,gbc);
      
      gbc.gridx=1;
      gbc.gridy=1;
      gbc.gridwidth=1;
      panel.add(usernameError,gbc);
      
      gbc.gridx =0;
      gbc.gridy = 2;
      gbc.gridwidth =1;
      panel.add(password,gbc);
      
      gbc.gridx =1;
      gbc.gridy = 2;
      gbc.gridwidth =2;
      panel.add(password2,gbc);
      
      gbc.gridx =0;
      gbc.gridy = 2;
      gbc.gridwidth =1;
      panel.add(password,gbc);
      
      gbc.gridx =1;
      gbc.gridy = 2;
      gbc.gridwidth =2;
      panel.add(password2,gbc);
      
      
      gbc.gridx =0;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      panel.add(repassword,gbc);
      
      gbc.gridx = 1;
      gbc.gridy = 3;
      gbc.gridwidth =1;
      panel.add(repassword2,gbc);
      
      gbc.gridx=1;
      gbc.gridy=4;
      gbc.gridwidth=2;
     panel.add(passwordError,gbc);
      
      gbc.gridx = 0;
      gbc.gridy = 5;
      gbc.gridwidth =1;
      gbc.ipadx = 18;
      panel.add(back,gbc);
      
      gbc.gridx = 1;
      gbc.gridy = 5;
      gbc.gridwidth =1;
      gbc.ipadx = 18;
      panel.add(signup,gbc);
      
      panel.setBackground(new Color (0.0f,0.0f,0.0f,0.25f));
      panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
      
      
      background.setBounds(0,0,1920,1080);
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

      repassword.setFont(new Font("Game of Thrones",Font.PLAIN,13));
      repassword.setForeground(Color.black);

      repassword2.setFont(new Font("Corbel",Font.PLAIN,24));
      repassword2.setBackground(new Color(107,89,77));
      repassword2.setForeground(Color.BLACK);
      repassword2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
      
      passwordError.setForeground(Color.white);
      usernameError.setForeground(Color.white);
      passwordError.setFont(new Font("Arial",Font.BOLD,13));
      usernameError.setFont(new Font("Arial",Font.BOLD,13));
      passwordError.setVisible(false);
      usernameError.setVisible(false);
      
      
      signup.setFont(new Font("Game of Thrones",Font.PLAIN,17));
      signup.setBorderPainted(false);
      signup.setBackground(new Color(0f,0f,0f));
      signup.setForeground(Color.GRAY);
      signup.addActionListener(new Handler());
      
      
      back.setFont(new Font("Game of Thrones",Font.PLAIN,17));
      back.setBorderPainted(false);
      back.setBackground(new Color(0f,0f,0f));
      back.setForeground(Color.GRAY);
      back.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              username2.setText(null);
              password2.setText(null);
              repassword2.setText(null);
              usernameError.setVisible(false);
              passwordError.setVisible(false);
              allGui.sug.setVisible(false);
              allGui.lg.setVisible(true);
          }
      });
      
    }
    
    public class Handler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
              if (e.getSource() == signup)
              { 
                
                String userName = username2.getText();
                String password = String.valueOf(password2.getPassword());
                String repassword = String.valueOf(repassword2.getPassword());
                System.out.print(repassword);
                MyPlayer newPlayer = new MyPlayer () ;
                HashMap <String,String> map = new HashMap<String,String>();
                if (!userName.equals("") && !password.equals("") && !repassword.equals("") )
                {
                if (password.equals(repassword))
                {
                    if (newPlayer.isThereAPlayer())
                    {
                        try {
                            map = newPlayer.getMyHashMap(newPlayer.loadPlayers());
                        } catch (IOException ex) {
                            Logger.getLogger(SignUpGUI.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(SignUpGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       if ((map.containsKey(userName))!=false)
                       {
                          usernameError.setVisible(true);  
                       }
                       else 
                       {
                           newPlayer = new MyPlayer (userName,password);
                           newPlayer.saveMe(newPlayer);
                           username2.setText(null);
                           password2.setText(null);
                           repassword2.setText(null);
                           allGui.sug.setVisible(false);
                           allGui.lg.setVisible(true);
                       }
                       
                    }
                    
                    else 
                    {
                        newPlayer = new MyPlayer (userName,password);
                        newPlayer.saveMe(newPlayer);
                        
                        allGui.sug.setVisible(false);
                        allGui.lg.setVisible(true);  
                    }
                    
                }
                else   passwordError.setVisible(true);
                     
              }
                
              }
        }
    }
}
