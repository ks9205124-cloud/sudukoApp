/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suduko;

import java.util.ArrayList;

/**
 *
 * @author khushi sharma
 */
public class tst {
    
    ArrayList<ArrayList<String>> myList = new ArrayList<>();
    
    public void listTest(){
        for (int i = 0; i < 10; i++) {
            ArrayList<String> _i = new ArrayList<>();
            _i.add(Integer.toString(i));
            myList.add(_i);
        }
        
        for (int i = 0; i < 10; i++) {
            System.err.println(myList.get(i));
        }
    } 
   
}
