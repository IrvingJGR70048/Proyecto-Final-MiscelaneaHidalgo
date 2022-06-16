//package main;

import java.io.Serializable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Uriel
 */
public class datos implements Serializable{
   
   private  String[] info = new String[8];; 

    public datos(String[] infonew) {
        this.info = infonew;
    }

    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] infonew) {
        this.info = infonew;
    }
     
}
