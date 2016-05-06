/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gotstrategygame;


import java.util.Timer;

/**
 *
 * @author Peter
 */
public class Archer extends Unit {
    int arrows;
    int maxArrows;

    public Archer(String name, int attackDamage, int armor, int maxHealth, int cost, int unitType, int maxArrows) {
        super(name,attackDamage, armor, maxHealth, cost, unitType);
        this.maxArrows = maxArrows;
        this.arrows = maxArrows;
    }


   
   
    @Override
    public void attack(Unit u){
        shootArrows();
        u.health -= this.attackDamage - u.armor; 
    }
    
    
    public void shootArrows(){
        if(arrows<=0)
            this.attackDamage=3;
        arrows--;
        
    }
}

