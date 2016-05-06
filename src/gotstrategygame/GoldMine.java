package gotstrategygame;

import java.util.logging.Level;
import java.util.logging.Logger;


public class GoldMine extends Thread
{   
    private int gold = 20000;
    static public int firstCost=700;
    private int cost = 700;
    private int increment = 3;
    private int level = 1;
    Army army;
    
    public GoldMine(Army army) {
        this.army = army;
        this.start();
    }
    
    public int getGold(){
        return gold;
    }

    public int getLevel() {
        return level;
    }

    public int getIncrement() {
        return increment;
    }
    
    
    
    public int getCost(){
        return cost;
    }
    
    public void increaseGold()
    {
        if(gold >= 0){
        army.setGold(army.getGold() + increment);
        gold-=increment;
        }else this.stop();
    }
    
    public void upgrade(){
        if(army.getGold() >= cost){
        army.setGold(army.getGold() - cost);
        cost += (200+100*level);
        increment+=(3+level);
        level++;
        }
    }
    
    @Override
    public void run(){
        while(true){
        increaseGold();
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GoldMine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}