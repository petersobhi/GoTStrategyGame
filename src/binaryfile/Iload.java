package binaryfile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bisho
 */
public interface Iload {
    public ArrayList<MyPlayer> loadPlayers()throws FileNotFoundException, IOException, ClassNotFoundException;
}
