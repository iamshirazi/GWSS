/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.shirazi.ics4u.u7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author 1shirazimat
 */
public class PlayerClient {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        String[] sponsors = {"abc", "def"};
        
        Player a = new Player("Fred", 20, sponsors);
        Player b = new Player("Jeff", 20, sponsors);
        
        File file = new File("players.dat");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        
        out.writeObject(a);
        out.writeObject(b);
        
        out.close();
        
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fis);
        
        Player aa = (Player) in.readObject();
        System.out.println(aa.toString());
        Player bb = (Player) in.readObject();
        System.out.println(bb.toString());
        
    }
    
}
