/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suduko;

import java.util.ArrayList;

public class Logic {

    public ArrayList<Integer> numberOfRandomNumberIndex = new ArrayList<>();
    public ArrayList<Integer> _numberOfRandomNumberIndex = new ArrayList<>();
    int ROW_COLUMN_COUNT;

    public Logic(int ROW_COLUMN_COUNT) {
        this.ROW_COLUMN_COUNT = ROW_COLUMN_COUNT;        
    }

    public void numberOfRandomNumberToGenerate(int number) {
        for (int i = 0; i < 100000; i++) {
            int reff = GenerateRandomNumber();
            if (!numberOfRandomNumberIndex.contains(reff) && numberOfRandomNumberIndex.size() < number) {
                numberOfRandomNumberIndex.add(reff);
            }
        }
    }
    
    public void _numberOfRandomNumberToGenerate(int number) {
        for (int i = 0; i < 100000; i++) {
            int reff = _GenerateRandomNumber();
            if (!_numberOfRandomNumberIndex.contains(reff) && _numberOfRandomNumberIndex.size() < number) {
                _numberOfRandomNumberIndex.add(reff);
            }
        }
    }
    
    private int _GenerateRandomNumber() {
        float i = (float) Math.random();
        int tst = ROW_COLUMN_COUNT;
        float reffFloat = (float) 1 / tst;
        for (int j = 0; j < tst + 1; j++) {
            float tt = (float) reffFloat * j + reffFloat;
            if (reffFloat * j > i && i < tt) {
                if (j != tst) {
                    return j;
                }
            }
        }
        return 0;
    }
    
    private int GenerateRandomNumber() {
        float i = (float) Math.random();
        int tst = ROW_COLUMN_COUNT * ROW_COLUMN_COUNT;
        float reffFloat = (float) 1 / tst;
        for (int j = 0; j < tst + 1; j++) {
            float tt = (float) reffFloat * j + reffFloat;
            if (reffFloat * j > i && i < tt) {
                if (j != tst) {
                    return j;
                }
            }
        }
        return 0;
    }

}
