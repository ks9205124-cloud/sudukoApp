/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suduko;

import java.awt.*;
import java.util.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Grid extends JPanel {

    //instantiate grid of buttons.
    JButton[][] gridButton;
    ArrayList<JButton> testButtonList = new ArrayList<>();
    //boolean to turn gridBurron on or off
    boolean[][] oneTimeUse;
    //adds responsive feel in ui
    UI Ui;    
    
    public Grid(int ROWS, int COLUMNS, UI Ui, JPanel MENU_BAR_BOTTOM) {

        //obejct is passed to link(IS_ERASABLE boolean) ie not create a new instance of ui class
        this.Ui = Ui;
        //gridLayout for suduko boxes entry
        GridLayout gr = new GridLayout(ROWS, COLUMNS);
        super(gr);
        //length of gridButton and oneTimeUse
        gridButton = new JButton[ROWS][COLUMNS];
        oneTimeUse = new boolean[ROWS][COLUMNS];        
    }

    public void SetGrid(int ROWS, int COLUMNS) {

        for (int i = 0; i <= ROWS - 1; i++) {
            for (int j = 0; j <= COLUMNS - 1; j++) {
                int _reffNo_i = i;
                int _reffNo_j = j;
                //instantiate the buttons.
                gridButton[i][j] = new JButton("");

                add(gridButton[i][j]);
                
                testButtonList.add(gridButton[i][j]);
                
                //input logic
                ActionListener actionListener = (event) -> {
                    if (event.getSource() == gridButton[_reffNo_i][_reffNo_j]) {
                        
                        //removes erase button at erase count 1
                        if (Ui.ERASER_COUNT == 1 && Ui.IS_ERASER == true) {
                            Ui.MENU_BAR_BOTTOM.remove(Ui.ERASER);
                            Ui.MENU_BAR_BOTTOM.revalidate();
                            Ui.MENU_BAR_BOTTOM.repaint();
                        }
                        //set string not equal to null
                        if (Ui.ERASER_COUNT <= 0) {
                            Ui.RemoveEraser(Ui.MENU_BAR_BOTTOM);
                        }
                        //combination of two bool to determine correct sequence of input
                        if (Ui.IS_ERASER == true && oneTimeUse[_reffNo_i][_reffNo_j] == Boolean.TRUE) {
                            Ui.ERASER_COUNT--;
                            Ui.ERASER.setText("ERASER *" + Ui.ERASER_COUNT);
                            oneTimeUse[_reffNo_i][_reffNo_j] = Boolean.TRUE;
                            SetText(_reffNo_i, _reffNo_j);
                            System.out.println(Ui.ERASER_COUNT);

                        } else if (Ui.IS_ERASER == true && oneTimeUse[_reffNo_i][_reffNo_j] == Boolean.FALSE) {
                            Ui.ERASER_COUNT--;
                            Ui.ERASER.setText("ERASER *" + Ui.ERASER_COUNT);
                            oneTimeUse[_reffNo_i][_reffNo_j] = Boolean.TRUE;
                            SetText(_reffNo_i, _reffNo_j);

                        } else if (Ui.IS_ERASER == false && oneTimeUse[_reffNo_i][_reffNo_j] == Boolean.TRUE) {
                            oneTimeUse[_reffNo_i][_reffNo_j] = Boolean.FALSE;
                            SetText(_reffNo_i, _reffNo_j);

                        } else {
                            return;
                        }
                    }
                };
                gridButton[i][j].addActionListener(actionListener);

            }

        }

    }
    
    //oneTimeUse 2Darray is set to be true by default here.
    public void SET_ONE_TIME_USE(int ROWS, int COLUMNS) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                Arrays.fill(oneTimeUse[i], Boolean.TRUE);
                Arrays.fill(oneTimeUse[j], Boolean.TRUE);

                //System.out.println(i + "," + j + oneTimeUse[i][j]);
            }
        }
    }
    //name of button is set here.
    public void SetText(int i, int j) {
        gridButton[i][j].setText(GetText());

    }
//    public void SetName(int i, int j,int myName) {
//        gridButton[i][j].setText(Integer.toString(myName));
//
//    }
    public void SetName(int index,String myName){
        testButtonList.get(index).setText(myName);
    }
    //override it later
    public String GetText() {
        return "sexy";
    }
    
   
}

