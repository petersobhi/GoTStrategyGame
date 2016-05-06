    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gotstrategygame;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Merna
 */
public class Place extends Thread {
    
    int x;
    int y;
    private Unit unitA;
    private Unit unitB;
    private Game myGame;
    
    public Place(int x,int y,Game myGame){
        this.x = x;
        this.y = y;
        this.myGame=myGame;
    }

    public Unit getUnitA() {
        return unitA;
    }

    public void setUnitA(Unit unitA) {
        this.unitA = unitA;
    }

    public Unit getUnitB() {
        return unitB;
    }

    public void setUnitB(Unit unitB) {
        this.unitB = unitB;
    }


    public void battle(){
        if(unitA!=null){
        if (unitA.unitType==3)
         {  
            // unitA = (Magician)unitA;
             
             Place myPlace[] = {myGame.getMap()[x][y+1]
                                ,myGame.getMap()[x+1][y+1]
                                ,myGame.getMap()[x+1][y]
                                ,myGame.getMap()[x+1][y-1]
                                ,myGame.getMap()[x][y-1]
                                ,myGame.getMap()[x-1][y-1]
                                ,myGame.getMap()[x-1][y]
                                ,myGame.getMap()[x-1][y+1]};
             unitA.attack(unitB, myPlace);
             if(unitB!=null)
             unitB.attack(unitA);
             if(unitA.getHealth() <= 0)
             unitA=null;
         }
        else if (unitA!=null && unitB!=null){
                unitA.attack(unitB);
                unitB.attack(unitA);
                if(unitB.getHealth() <= 0)
                {
                    myGame.playerA.score(unitB);
                    System.out.println("player A score : "+myGame.playerA.getScore());
                    unitB=null;
                }
                if(unitA.getHealth() <= 0)
                {
                    myGame.playerB.score(unitA);
                    System.out.println("player B score : "+myGame.playerB.getScore());
                    unitA=null;
                }
         
        }
        
        }
    }
    
    @Override
    public void run(){
        while(true){
        battle();
        try {
            sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Place.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
   
}
    
  

