/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gotstrategygame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class TextFileManager {
    public String[] readNames(String filepath) throws FileNotFoundException, IOException{
        String[] names=new String[5];
        BufferedReader br = new BufferedReader(new FileReader(new File(filepath)));
       
       String line=null;
       int y=0;
       names[y]=line;
       while((line=br.readLine())!=null){
           StringTokenizer st = new StringTokenizer(line,":");
           line=st.nextToken();
           names[y]=line;
           y++;
       }
        
        return names;
    }
    
    public int[] readPrices(String filepath) throws FileNotFoundException, IOException{
        int[] prices=new int[5];
        BufferedReader br = new BufferedReader(new FileReader(new File(filepath)));

        int y=0;

          String line;
           while((line=br.readLine())!=null){
               StringTokenizer st = new StringTokenizer(line,":");
               for(int i=0;i<4;i++)
                   st.nextToken();

                    prices[y] = Integer.parseInt(st.nextToken());
                    y++;
        }

        return prices;
}



public String[] readAll(File f) throws FileNotFoundException, IOException{
    String[] info=new String[25];
    BufferedReader br = new BufferedReader(new FileReader(f));
    
    int y=0;
        
      String line;
       while((line=br.readLine())!=null){
           StringTokenizer st = new StringTokenizer(line,":");
           
           while(st.hasMoreElements()){
               
               info[y] = st.nextToken();
               y++;
       }
    
}

return info;
}
}