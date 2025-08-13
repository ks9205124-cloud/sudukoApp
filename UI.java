/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suduko;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI extends JFrame {

    //rigid ui objects.
    JLabel nameLabel = new JLabel("My Suduko");
    JButton ERASER = new JButton();
    private final JButton backButton = new JButton("Back");
    //no. keys
    private JButton[] sudukoButton;
    //default no. key
    private String myString = "1";
    //no of times eraser can be used.
    public int ERASER_COUNT = 3;
    //diffrentiates no keys and eraser by enabling multiple use of eraser and single use aof no. keys(acts as a tag)
    public boolean IS_ERASER = false;
    //link btw ui and grid(removes eraser button when ERASER_COUNT is less than eqal to one)
    JPanel MENU_BAR_BOTTOM;

    public int ROW_COLUMN_COUNT;

    public void CreateSuduko(int WIDTH, int HEIGHT, int ROW_COLUMN_COUNT) {

        this.ROW_COLUMN_COUNT = ROW_COLUMN_COUNT;

        ERASER.setText("ERASER *" + ERASER_COUNT);

        sudukoButton = new JButton[ROW_COLUMN_COUNT];

        setName("My Suduko");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //layout for main frame
        setLayout(new BorderLayout(25, 25));

        //layout for JPanel_TOP : MENU_BAR_TOP
        JPanel MENU_BAR_TOP = new JPanel(new BorderLayout());
        MENU_BAR_TOP.add(nameLabel, BorderLayout.WEST);
        MENU_BAR_TOP.add(backButton, BorderLayout.EAST);
        add(MENU_BAR_TOP, BorderLayout.NORTH);

        //layout for JPanel_CENTER : SUDUKO_GRID
        Grid myGrid = new Grid(ROW_COLUMN_COUNT, ROW_COLUMN_COUNT, this, MENU_BAR_BOTTOM) {
            @Override
            public String GetText() {
                return Get_myString();
            }

        };
        //Logic lg = new Logic(ROW_COLUMN_COUNT);
        Box bx = new Box(ROW_COLUMN_COUNT);
        bx.GeneratePos1Index();

        myGrid.SET_ONE_TIME_USE(ROW_COLUMN_COUNT, ROW_COLUMN_COUNT);
        myGrid.SetGrid(ROW_COLUMN_COUNT, ROW_COLUMN_COUNT);

        for (int i = 0; i < bx.indexReff.size(); i++) {
            myGrid.SetName(Integer.parseInt(bx.indexReff.get(i)), "7");
        }

        //Point myPoint = lg.PickRandomPoint();
        //myGrid.SetName(myPoint.x, myPoint.y, lg.GenerateRandomNumber());       
        add(myGrid, BorderLayout.CENTER);
        //we are going to set up a grid..

        //layout for JPanel_BOTTOM : MENU_BAR_BOTTOM
        JPanel MENU_BAR_BOTTOM = new JPanel(new FlowLayout(FlowLayout.LEADING, 20, 20));
        this.MENU_BAR_BOTTOM = MENU_BAR_BOTTOM;
        //no. of buttons to create.
        for (int i = 0; i <= ROW_COLUMN_COUNT - 1; i++) {
            int reffInt = i + 1;
            sudukoButton[i] = new JButton(String.valueOf(reffInt));
            MENU_BAR_BOTTOM.add(sudukoButton[i]);

            ActionListener actionListener = (event) -> {
                if (event.getSource() == sudukoButton[reffInt - 1]) {
                    IS_ERASER = false;
                    Set_myString(sudukoButton[reffInt - 1].getText());
                }
            };
            sudukoButton[i].addActionListener(actionListener);
        }
        MENU_BAR_BOTTOM.add(ERASER);
        ActionListener actionListener = (event) -> {
            if (event.getSource() == ERASER) {
                if (ERASER_COUNT > 0) {
                    IS_ERASER = true;
                    Set_myString("");
                } else {
                    IS_ERASER = false;
                    Set_myString("1");
                    RemoveEraser(MENU_BAR_BOTTOM);
                }
            }
        };
        ERASER.addActionListener(actionListener);
        add(MENU_BAR_BOTTOM, BorderLayout.SOUTH);

        setVisible(true);

    }

    public void RemoveEraser(JPanel MENU_BAR_BOTTOM) {
        IS_ERASER = false;
        Set_myString("1");
        MENU_BAR_BOTTOM.remove(ERASER);
        MENU_BAR_BOTTOM.revalidate();
        MENU_BAR_BOTTOM.repaint();
    }

    public String Get_myString() {
        return myString;
    }

    public void Set_myString(String SampleString) {
        myString = SampleString;
    }

    @Override
    public Insets getInsets() {
        return new Insets(35, 15, 35, 15);
    }

}
