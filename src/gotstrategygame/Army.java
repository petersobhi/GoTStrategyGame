/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gotstrategygame;
/**
 *
 * @author Peter
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Army {
    private int gold;
    private int armyType;
    private String filepath;
    public Barracks b;
    public GoldMine gm;
    public Blacksmith bs;
    private String[] unitsNames = new String[5];
    private int[] unitsPrices = new int[5];
    ArrayList<Unit> units = new ArrayList();
    TextFileManager tfm =   new TextFileManager();

    public String getFilepath() {
        return filepath;
    }
    
    
    
    public Army(int gold, int armyID,String filepath) throws IOException{
        this.gold = gold;
        this.armyType = armyID;
        this.filepath = filepath;
        this.unitsNames = tfm.readNames(filepath);
        this.unitsPrices = tfm.readPrices(filepath);
    }

    public void buyBarracks(){
        if(b==null && gold >= b.firstCost){
        b=new Barracks(this,filepath);
        gold -= b.getCost();
        }
    }
    
     public void buyGoldMine(){
        if(gm==null && gold >= gm.firstCost){
        gm=new GoldMine(this);
        gold -= gm.getCost();
        }
    }
     
     public void buyBlacksmith(){
        if(bs==null && b!=null && gold >= bs.firstCost){
        bs=new Blacksmith(b);
        gold -= bs.getCost();
        }
    }
    
    public int getGold() {
        return gold;
    }


    public String getUnitsNames(int i) {
        return unitsNames[i];
    }
    
    public int getUnitsPrices(int i){
        return unitsPrices[i];
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }
    
    
    
    
    
    
    public void addUnit(Unit u){
        units.add(u);
    }

    public int setGold(int gold) {
        if (gold>= 0){
        this.gold = gold;
        return 0;
        }
        else return -1;
    }

    public void setUnitsNames(String[] unitsNames) {
        this.unitsNames = unitsNames;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }
    
}
