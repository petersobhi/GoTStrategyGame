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
public class Hero extends Unit {
    private int level;
    private int unitsKilled;
    private int maxUnitsKilled=5;
    private Monster monster;

    public Hero(String name,int attackDamage, int armor, int maxHealth, int cost, int unitType) {
        super(name,attackDamage, armor, maxHealth, cost, unitType);
        level=1;
    }

   
    
    public void attack(){
    
    }
            
    public void levelUp(){
        if (unitsKilled==maxUnitsKilled){
            level++;
            maxUnitsKilled += level;
            unitsKilled=0;
        }
    }
}
