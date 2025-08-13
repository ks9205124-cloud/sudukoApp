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

//                this is hardCode version that only works for 9*9 suduko,above code is currently under development for easy use.
//                int testInt = ROW_COLUMN_COUNT * i + j;
//                if (j == 0) {
//                    if (i == 0) {
//                        indexReff.add(Integer.toString(testInt));
//                    } else if (i == fc.ROWS()) {
//                        indexReff.add(Integer.toString(transformRight(testInt)));
//                    } else if (i == fc.ROWS() + fc.ROWS()) {
//                        int tst = transformRight(testInt);
//                        indexReff.add(Integer.toString(transformRight(tst)));
//                    }
//                } else if (j == fc.COLUMS()) {
//                    int tstDown = transformDown(testInt);
//                    if (i == 0) {
//                        indexReff.add(Integer.toString(tstDown));
//                    } else if (i == fc.ROWS()) {
//                        indexReff.add(Integer.toString(transformRight(tstDown)));
//                    } else if (i == fc.ROWS() + fc.ROWS()) {
//                        int tst = transformRight(tstDown);
//                        indexReff.add(Integer.toString(transformRight(tst)));
//                    }
//                } else if (j == fc.COLUMS() + fc.COLUMS()) {
//                    int tst1 = transformDown(testInt);
//                    int tst2 = transformDown(tst1);
//                    if (i == 0) {
//                        indexReff.add(Integer.toString(tst2));
//                    } else if (i == fc.ROWS()) {
//                        indexReff.add(Integer.toString(transformRight(tst2)));
//                    } else if (i == fc.ROWS() + fc.ROWS()) {
//                        int tst = transformRight(tst2);
//                        indexReff.add(Integer.toString(transformRight(tst)));
//                    }
//                } else {
//                    System.err.println("sexy");
//                }
            }
        }
    }

    //bounding must be added  in later stages.
    public int transformLeft(int reffIndex, int numberOfTimesToShift) {
        return reffIndex - 1 * numberOfTimesToShift;
    }

    public int transformRight(int reffIndex, int numberOfTimesToShift) {
        return reffIndex + 1 * numberOfTimesToShift;
    }

    public int transformUp(int reffIndex, int numberOfTimesToShift) {
        return reffIndex - 9 * numberOfTimesToShift;
    }

    public int transformDown(int reffIndex, int numberOfTimesToShift) {
        return reffIndex + 9 * numberOfTimesToShift;
    }

}
