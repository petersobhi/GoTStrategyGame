package gotstrategygame;

public class Building 
{
    private int health;
    private int defence;
    private int cost;
    
    public Building (int health,int defence,int cost)
    {
        setBuildingInfo(health,defence,cost);
    }
    
    public void setBuildingInfo(int health,int defence,int cost)
    {
        this.health=health;
        this.defence=defence;
        this.cost=cost;
    }
    
    public int getBuildingHealth()
    {
            return this.health;

    }
    
    public int getBuildingDefence()
    {
        return this.defence;
    }
    
    public int getBuildingCost()
    {
        return this.cost;
    }
    
    public void buyBuilding(Army myArmy)
    {
        int Goldarmy=myArmy.getGold();
        Goldarmy-=this.cost;
        
       
    }
}


