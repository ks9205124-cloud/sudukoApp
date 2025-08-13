/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suduko;

import java.util.ArrayList;

public class Box {

    public int[][] index;
    public ArrayList<String> indexReff = new ArrayList<>();

    int ROW_COLUMN_COUNT;
    FactorGenerator fc;

    public Box(int ROW_COLUMN_COUNT) {

        this.ROW_COLUMN_COUNT = ROW_COLUMN_COUNT;
        fc = new FactorGenerator(ROW_COLUMN_COUNT);

        index = new int[ROW_COLUMN_COUNT][ROW_COLUMN_COUNT];

    }

    ArrayList<Integer> rowInedx = new ArrayList<>();
    ArrayList<Integer> columnInedx = new ArrayList<>();

    public void GeneratePos1Index() {
        for (int i = 0; i < ROW_COLUMN_COUNT; i = i + fc.ROWS()) {
            for (int j = 0; j < ROW_COLUMN_COUNT; j = j + fc.COLUMS()) {
                if (!rowInedx.contains(i)) {
                    rowInedx.add(i);
                    //System.err.println(rowInedx);
                } else {/*do nothig*/
                }
                if (!columnInedx.contains(i)) {
                    columnInedx.add(i);
                    //System.err.println(rowInedx);
                } else {/*do nothig*/
                }
                int pos1 = ROW_COLUMN_COUNT * i + j;
                indexReff.add(Integer.toString(transformRight(pos1, 0)));
                indexReff.add(Integer.toString(transformDown(pos1, 0)));
            }
        }
    }

    //bounding must be added  in later stages.
    public int transformLeft(int reffIndex, int numberOfTimesToShift) {
        boolean check = false;

        for (int i = 0; i <= ROW_COLUMN_COUNT; i = i + fc.ROWS()) {
            if (i != ROW_COLUMN_COUNT) {
                for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
                    if (ROW_COLUMN_COUNT * i  + j == reffIndex) {
                        check = true;
                    }
                }
            }
        }

        if (check == true) {
            int operand = fc.ROWS()- 1;
            return reffIndex + 1 * operand;
        } else {
            return reffIndex - 1 * numberOfTimesToShift;
        }
    }

    public int transformRight(int reffIndex, int numberOfTimesToShift) {
        boolean check = false;

        for (int i = 0; i <= ROW_COLUMN_COUNT; i = i + fc.ROWS()) {
            if (i != 0) {
                for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
                    if (ROW_COLUMN_COUNT * i - ROW_COLUMN_COUNT + j == reffIndex) {
                        check = true;
                    }
                }
            }
        }

        if (check == true) {
            int operand = fc.ROWS()- 1;
            return reffIndex - 1 * operand;
        } else {
            return reffIndex + 1 * numberOfTimesToShift;
        }
        //return reffIndex + 1 * numberOfTimesToShift;
    }

    public int transformUp(int reffIndex, int numberOfTimesToShift) {
        boolean check = false;

        for (int i = 0; i <= ROW_COLUMN_COUNT; i = i + fc.COLUMS()) {
            if (i != ROW_COLUMN_COUNT) {
                for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
                    if (ROW_COLUMN_COUNT * i  + j == reffIndex) {
                        check = true;
                    }
                }
            }
        }

        if (check == true) {
            int operand = fc.COLUMS() - 1;
            return reffIndex + 9 * operand;
        } else {
            return reffIndex - 9 * numberOfTimesToShift;
        }
    }

    public int transformDown(int reffIndex, int numberOfTimesToShift) {
        boolean check = false;

        for (int i = 0; i <= ROW_COLUMN_COUNT; i = i + fc.COLUMS()) {
            if (i != 0) {
                for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
                    if (ROW_COLUMN_COUNT * i - ROW_COLUMN_COUNT + j == reffIndex) {
                        check = true;
                    }
                }
            }
        }

        if (check == true) {
            int operand = fc.COLUMS() - 1;
            return reffIndex - 9 * operand;
        } else {
            return reffIndex + 9 * numberOfTimesToShift;
        }
    }
}
