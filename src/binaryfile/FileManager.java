/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bisho
 */

public class FileManager {
    
    public ArrayList<Object> readF ( ) throws IOException, ClassNotFoundException
    {  
        ArrayList<Object> myObjects = new ArrayList ();
    
        ObjectInputStream myBin = new ObjectInputStream (new FileInputStream ("C:\\Users\\bisho\\Desktop\\m.bin"));
        myObjects = (ArrayList<Object>) (Object) myBin.readObject();
        return myObjects;
    }
    
    public void writeF (Object anObject) throws IOException
    {   
        ArrayList<Object> myObjects = new ArrayList();
        myObjects.add(anObject);
        ObjectOutputStream myBin = new ObjectOutputStream (new FileOutputStream ("C:\\Users\\bisho\\Desktop\\m.bin",true));
        myBin.writeObject(myObjects);
        myBin.close();
    }
    
}