package gotstrategygame;


public class Blacksmith 
{   
    private int level=1;
    private Barracks b;
    private Army army;
    public static int firstCost=600;
    private int cost=600;
    

    public Blacksmith(Barracks b) {
        this.b = b;
        this.army = b.getArmy();
        b.setArmorBonus(1);
        b.setAttackBonus(4);
        b.setHealthBonus(20);
    }
    
    public void upgradeBlacksmith(){
        if(army.getGold() >= cost){
        army.setGold(army.getGold() - cost);
        b.setAttackBonus(b.getAttackBonus() + 3 + level);
        b.setArmorBonus(b.getArmorBonus() + level);
        b.setHealthBonus(b.getHealthBonus() + 20 + 10*level);  
        level++;
        cost+=(200 + level*100);
        }
    }

    public int getLevel() {
        return level;
    }

    public int getCost() {
        return cost;
    }
       
    
}