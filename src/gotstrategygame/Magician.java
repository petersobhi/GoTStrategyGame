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
public class Magician extends Unit {
    private int mana;
    private int maxMana;

    public Magician(String name,int attackDamage, int armor, int maxHealth, int cost, int unitType, int maxMana) {
        super(name,attackDamage, armor, maxHealth, cost, unitType);
        this.maxMana = maxMana;
        this.mana = maxMana;
    }

    

    
   public void attack (Unit u,Place myPlaces[])
   {
       if(u!=null)
       super.attack(u);
       heal(myPlaces);
      // System.out.println("fff");
   }
    
    public void heal(Place myPlaces[])
    {
        
        for (int i=0;i<8;i++)
       {
           if ( myPlaces[i].getUnitA()!=null)
           if (myPlaces[i].getUnitA().health<=myPlaces[i].getUnitA().maxHealth)
           myPlaces[i].getUnitA().health+=5;
       }
    }
    
    
}
