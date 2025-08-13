/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suduko;

import java.awt.*;

public class Logic {

    int ROW_COLUMN_COUNT;

    public Logic(int ROW_COLUMN_COUNT) {
        this.ROW_COLUMN_COUNT = ROW_COLUMN_COUNT;
    }

    Point PickRandomPoint() {
        return new Point(_GenerateRandomNumber(), _GenerateRandomNumber());
    }

    //we have to seprate function because GenerateRandomNumber will not generate 0 but _GenerateRandomNumber will.
    int GenerateRandomNumber() {
        float i = (float) Math.random();
        float reffFloat = (float) 1 / ROW_COLUMN_COUNT;
        for (int j = 0; j < ROW_COLUMN_COUNT + 1; j++) {
            float tt = (float) reffFloat * j + reffFloat;
            if (reffFloat * j > i && i < tt) {
                return j;
            }
        }
        return 0;
    }

    //created to access array data
    private int _GenerateRandomNumber() {
        float i = (float) Math.random();
        float reffFloat = (float) 1 / ROW_COLUMN_COUNT;
        for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
            float tt = (float) reffFloat * j + reffFloat;
            if (reffFloat * j > i && i < tt) {
                return j;
            }
        }
        return 0;
    }
    
}

