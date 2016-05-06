package gotstrategygame;
import guipackage.AllGUI;
import guipackage.GameGUI;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GoTstrategygame {
 
    
    public static void main(String[] args) throws IOException{
       //LoginGUI g = new LoginGUI();   
       //SignUp s = new SignUp();
         AllGUI ag = new AllGUI();
        
      /*   
        
       Scanner s;
       s = new Scanner(System.in);
       int choiceArmy;
       int choiceUnit=0;
       String filepath=null;
       TextFileManager tfm = new TextFileManager();
       
       
        
        System.out.println("Welcome to GOT Strategy game");
        System.out.println("Choose your army");
        System.out.println("1 - Stark");
        System.out.println("2 - Lannisters");
        System.out.println("3 - Targeryan");
        
        choiceArmy = s.nextInt();
        
        switch(choiceArmy){
            case 1:
                System.out.println("Winter is conming!");
                filepath= "army_units/stark.txt";
                break;
            case 2:
                System.out.println("A Lannister always pays his debts!");
                filepath= "army_units/lannister.txt";
                break;
            case 3:
                System.out.println("With fire and blood!");
                filepath = "army_units/targeryen.txt";
                break;
            
        }
        
        
        Army armyA = new Army(2000,choiceArmy,filepath);
        System.out.println(armyA.getGold());
        armyA.buyBarracks();
        System.out.println(armyA.getGold());
        
        
        armyA.buyGoldMine();
        System.out.println(armyA.getGold());
        
        int k=0;
        while(k!=5){
            System.out.println(armyA.getGold());
            k = s.nextInt();
        }
        
       
        System.out.println("Choose your units");
        for (int i=1 ; i<6 ; i++){
            System.out.println(i + " - " + armyA.getUnitsNames(i-1) + " - (Cost: " + armyA.getUnitsPrices(i-1)+ " Gold)");
        }
        System.out.println("6 - Exit");
        System.out.println("Army Gold = "+ armyA.getGold());
        while(true){
            System.out.print("Enter your choice: ");
            choiceUnit = s.nextInt();
            if (choiceUnit != 6){
                    int cost = tfm.readPrices(filepath)[choiceUnit-1];
                    if (armyA.getGold() - cost < 0 )
                        System.out.println("not enough gold");
                    else{
                    switch(choiceUnit){
                        case 1:
                            armyA.b.buySoldier();
                            break;                                            
                        case 2:
                            armyA.b.buyArcher();
                            break;
                        case 3:
                            armyA.b.buyMagician();
                            break;
                        case 4:
                            armyA.b.buyHero();
                            break;
                        case 5:
                            armyA.b.buyMonster();
                            break;
                        case 6: 
                            break;
                    }
                    System.out.println(armyA.getUnitsNames(choiceUnit-1)+" was added to your army");
                    }
                    System.out.println("Army Gold = "+ armyA.getGold());
            }
            else
                break;
    }
        
        /*
           ------ Used in attack ------
        Unit selectedUnit = null;
        for (Unit x : armyA.units)
        {
            if (x.unitType == 3){
                selectedUnit = x;
                break;
            }
        }
        
        System.out.println(selectedUnit.health);
           */ 
        /*
        System.out.println();
        System.out.println();
        System.out.println("Your Units :");
        for (Unit x : armyA.units)
        {
            System.out.println();
            System.out.println("Unit Type: "+armyA.getUnitsNames(x.unitType-1));
            System.out.println("Damage: "+x.attackDamage);
            System.out.println("Armor: "+x.armor);
            System.out.println("Health: "+x.health);
            System.out.println("Max Health: "+x.maxHealth);
        }
        */
       
      
        
    }
    
}
 