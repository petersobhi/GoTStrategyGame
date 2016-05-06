package gotstrategygame;


abstract public class Unit {
    String name;
    int attackDamage;
    int armor;
    int maxHealth;
    int health;
    int cost;
    int unitType;
   
    Unit (String name,int attackDamage,int armor, int maxHealth, int cost, int unitType){
        this.name = name;
        this.attackDamage = attackDamage;
        this.armor = armor;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.cost = cost;
        this.unitType = unitType;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getUnitType() {
        return unitType;
    }
    
    

    public String getName() {
        return name;
    }
   
           
    
    public void attack(Unit u){
        if(u.health >=0){
             u.health -= (this.attackDamage - (this.attackDamage*u.armor/100));
        }
    }
    
    public void attack (Unit u,Place myPlaces[])
   {
       this.attack(u);
   }
    
}

