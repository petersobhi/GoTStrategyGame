/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gotstrategygame;

import binaryfile.MyPlayer;


/**
 *
 * @author Peter
 */
public class Game {
    
    public Army armyA;
    public Army armyB;
    public MyPlayer playerA = new MyPlayer();
    public MyPlayer playerB = new MyPlayer();
    
    private Place[][] map = new Place[10][10];
    
    public Game(Army armyA , Army armyB , MyPlayer playerA , MyPlayer playerB){
        this.armyA = armyA;
        this.armyB = armyB;
        this.playerA = playerA;
        this.playerB = playerB;
    }
    
    public void createMap(){
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                map[x][y]=new Place(x,y,this);
            }
        }
    }

    public Place[][] getMap() {
        return map;
    }
    
    
    
    public void moveUnitA(Unit u, Place p){
        p.setUnitA(u);
    }
    
    public void moveUnitB(Unit u, Place p){
        p.setUnitB(u);
    }
    
    public void deleteUnitA(Unit u){
        armyA.units.remove(u);
    }
    
    public void deleteUnitB(Unit u){
        armyB.units.remove(u);
    }
    
    public void moveFromPlaceToPlaceA(Place oldPlace, Place newPlace){
        newPlace.setUnitA( oldPlace.getUnitA() );
        oldPlace.setUnitA(null);
    }
    
}
