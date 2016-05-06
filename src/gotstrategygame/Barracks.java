
package gotstrategygame;

import java.io.File;
import java.io.IOException;


public class Barracks
{
    
    public String filepath;
    private Army army;
    static public int firstCost=500;
    private int cost = 500;
    private int attackBonus=0;
    private int armorBonus=0;
    private int healthBonus=0;

    
    public Barracks(Army army,String filepath) {
        this.army = army;
        this.filepath = filepath;
    }

    public Army getArmy() {
        return army;
    }
    
    
    
    public int getCost() {
        return cost;
    }
    
    public void buySoldier() throws IOException
    {
        TextFileManager tfm = new TextFileManager();
        String[] info = tfm.readAll(new File(filepath));
        String name= info[0];
        int attackDamage = Integer.parseInt(info[1])+attackBonus;
        int armor = Integer.parseInt(info[2])+armorBonus;
        int maxHealth = Integer.parseInt(info[3])+healthBonus;
        int unitCost = Integer.parseInt(info[4]);
        if(army.getGold()-unitCost >= 0){
            army.addUnit(new Soldier(name,attackDamage,armor,maxHealth,unitCost,1));
            army.setGold(army.getGold()-unitCost);
            }
        }
    
    public void buyArcher() throws IOException
    {
        TextFileManager tfm = new TextFileManager();
        String[] info = tfm.readAll(new File(filepath));
        String name= info[5];
        int attackDamage = Integer.parseInt(info[6])+attackBonus;
        int armor = Integer.parseInt(info[7])+armorBonus;
        int maxHealth = Integer.parseInt(info[8])+healthBonus;
        int unitCost = Integer.parseInt(info[9]);
        int arrows = 20;
        if(army.getGold()-unitCost >= 0){
            army.addUnit(new Archer(name,attackDamage,armor,maxHealth,unitCost,2,arrows));
            army.setGold(army.getGold()-unitCost);
            }
        }
    
    public void buyMagician() throws IOException
    {
        TextFileManager tfm = new TextFileManager();
        String[] info = tfm.readAll(new File(filepath));
        String name= info[10];
        int attackDamage = Integer.parseInt(info[11])+attackBonus;
        int armor = Integer.parseInt(info[12])+armorBonus;
        int maxHealth = Integer.parseInt(info[13])+healthBonus;
        int unitCost = Integer.parseInt(info[14]);
        int mana = 20;
        if(army.getGold()-unitCost >= 0){
            army.addUnit(new Magician(name,attackDamage,armor,maxHealth,unitCost,3,mana));
            army.setGold(army.getGold()-unitCost);
            }
        }
    
     public void buyHero() throws IOException
    {
        TextFileManager tfm = new TextFileManager();
        String[] info = tfm.readAll(new File(filepath));
        String name= info[15];
        int attackDamage = Integer.parseInt(info[16])+attackBonus;
        int armor = Integer.parseInt(info[17])+armorBonus;
        int maxHealth = Integer.parseInt(info[18])+healthBonus;
        int unitCost = Integer.parseInt(info[19]);
        if(army.getGold()-unitCost >= 0){
            army.addUnit(new Hero(name,attackDamage,armor,maxHealth,unitCost,4));
            army.setGold(army.getGold()-unitCost);
            }
        }
     
    public void buyMonster() throws IOException
    {
        TextFileManager tfm = new TextFileManager();
        String[] info = tfm.readAll(new File(filepath));
        String name= info[20];
        int attackDamage = Integer.parseInt(info[21])+attackBonus;
        int armor = Integer.parseInt(info[22])+armorBonus;
        int maxHealth = Integer.parseInt(info[23])+healthBonus;
        int unitCost = Integer.parseInt(info[24]);
        if(army.getGold()-unitCost >= 0){
            army.addUnit(new Monster(name,attackDamage,armor,maxHealth,unitCost,5));
            army.setGold(army.getGold()-unitCost);
            }
        }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getArmorBonus() {
        return armorBonus;
    }

    public void setArmorBonus(int armorBonus) {
        this.armorBonus = armorBonus;
    }

    public int getHealthBonus() {
        return healthBonus;
    }

    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }
    
    
}
    