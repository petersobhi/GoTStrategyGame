package binaryfile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import binaryfile.Iload;
import gotstrategygame.Unit;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bisho
 */
public class MyPlayer implements Serializable,Iload,Isave{
    private String name;
    private String password;
    private double score;
    
    static ArrayList<MyPlayer> allPlayers = new ArrayList<MyPlayer>();
    
    public MyPlayer ()
    {
        
    }
    
    public MyPlayer (String name,String password)
    {
        setName(name);
        setPassword(password);
    }
    
    public String getName() {
        return name;
    }
    
    public String getPassword() {
        return password;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    @Override
    public String toString ()
    {
        return "player name : "+name+"\npassword : "+password+"\n";
    }
    
    public void score (Unit u)
    {
       if (u.getUnitType()==1)this.score+=25;
       if (u.getUnitType()==2)this.score+=30;
       if (u.getUnitType()==3)this.score+=15;
       if (u.getUnitType()==4)this.score+=100;
       if (u.getUnitType()==5)this.score+=70;
    }
    
    @Override
    public void saveMe (MyPlayer newPlayer)
    {   
        
            try {
                if (isThereAPlayer())loadPlayers();
            } catch (IOException ex) {
                Logger.getLogger(MyPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyPlayer.class.getName()).log(Level.SEVERE, null, ex);
           }
            
        allPlayers.add(newPlayer);
        try {
            FileOutputStream fileOut = new FileOutputStream("m.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(allPlayers);
            out.close();
            fileOut.close();
        } catch (Exception ee) {
           // System.err.println("couldnt be saved");
        }
        allPlayers.clear();
    }
    
    @Override
    public ArrayList<MyPlayer> loadPlayers () throws FileNotFoundException, IOException, ClassNotFoundException
    {               
            FileInputStream fileIn =  new FileInputStream("m.bin");
            ObjectInputStream in  = new ObjectInputStream(fileIn);

            allPlayers = (ArrayList<MyPlayer>)  in.readObject();
            
            return allPlayers;
        
    }
    
    public void resetPassword (String userName,String newPassword)
    {
        try {
              loadPlayers();
            } catch (IOException ex) {
                Logger.getLogger(MyPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (MyPlayer x : allPlayers)
            {
                if (x.getName().equals(userName))
                {
                    x.setPassword(password);
                }
            }
            try {
            FileOutputStream fileOut = new FileOutputStream("m.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(allPlayers);
            out.close();
            fileOut.close();
            } catch (Exception ee) {
            //System.err.println("couldnt be saved");
            }
            allPlayers.clear();
    }
    
    public HashMap<String , String> getMyHashMap (ArrayList<MyPlayer> myPlayers)
    {
        HashMap <String , String> myMap = new HashMap <String , String>();
        
        for (MyPlayer i : myPlayers)
        {   
            myMap.put(i.getName(),i.getPassword());
        }
        return myMap;
    }
    
    public boolean isThereAPlayer ()
    {
        File file = new File ("m.bin");
        boolean empty = file.length()==0;
        
        return !empty;
    }
    
}
