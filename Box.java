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
    ArrayList<Integer> pos = new ArrayList<>();

    public void GeneratePos1Index() {
        for (int i = 0; i < ROW_COLUMN_COUNT; i = i + fc.ROWS()) {
            for (int j = 0; j < ROW_COLUMN_COUNT; j = j + fc.COLUMS()) {
                if (!rowInedx.contains(i)) {
                    rowInedx.add(i);
                } else {/*do nothig*/
                }
                if (!columnInedx.contains(i)) {
                    columnInedx.add(i);
                } else {/*do nothig*/
                }
                pos.add(ROW_COLUMN_COUNT * i + j);
//                indexReff.add(Integer.toString(transformRight(ROW_COLUMN_COUNT * i + j, UpDownshiftIndex(ROW_COLUMN_COUNT * i + j))));
//                System.err.println(UpDownshiftIndex(ROW_COLUMN_COUNT * i + j));
            }
        }
        for (int i = 0; i < pos.size(); i++) {
            indexReff.add(Integer.toString(transformDown(pos.get(i), ROW_COLUMN_COUNT + UpDownshiftIndex(pos.get(i)))));
//            System.err.println(indexs.get(i));
//            System.err.println(pos.get(i));
        }
        
    }

    public int LeftRightShiftIndex(int reffIndex) {
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Integer> arranger = new ArrayList<>();
        for (int i = 0; i < ROW_COLUMN_COUNT; i = i + fc.ROWS()) {
            index.add(i);
        }
        for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
            for (int i = 0; i < fc.ROWS(); i++) {
                if (reffIndex >= ROW_COLUMN_COUNT * j + index.get(i)) {
                    arranger.add(i);
                }
            }
        }
        return arranger.getLast();
    }

    public int UpDownshiftIndex(int reffIndex) {
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Integer> arranger = new ArrayList<>();
        for (int i = 0; i < ROW_COLUMN_COUNT; i = i + fc.COLUMS()) {
            index.add(i);
        }
        for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
            for (int i = 0; i < fc.COLUMS(); i++) {
                if (reffIndex >= ROW_COLUMN_COUNT * j + index.get(i)) {
                    arranger.add(i);
                }
            }
        }
        return arranger.getLast();
    }

    //bounding must be added  in later stages.
    public int transformLeft(int reffIndex, int numberOfTimesToShift) {
        ArrayList<Integer> bounds = new ArrayList<>();
        ArrayList<Integer> generatedIndexs = new ArrayList<>();

        for (int i = 0; i <= ROW_COLUMN_COUNT; i = i + fc.ROWS()) {
            if (i != ROW_COLUMN_COUNT) {
                for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
                    bounds.add(ROW_COLUMN_COUNT * j + i);
                }
            }
        }
        do {
            numberOfTimesToShift--;
            if (bounds.contains(reffIndex)) {
                int operand = fc.ROWS() - 1;
                reffIndex = reffIndex + 1 * operand;
            } else {
                reffIndex = reffIndex - 1;
            }

            if (!generatedIndexs.contains(reffIndex)) {
                generatedIndexs.add(reffIndex);
            }
        } while (numberOfTimesToShift > 0);
        
        return reffIndex;

    }

    public int transformRight(int reffIndex, int numberOfTimesToShift) {
        ArrayList<Integer> bounds = new ArrayList<>();
        ArrayList<Integer> generatedIndexs = new ArrayList<>();

        for (int i = 0; i <= ROW_COLUMN_COUNT; i = i + fc.ROWS()) {
            if (i != 0) {
                for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
                    bounds.add(ROW_COLUMN_COUNT * j + i - 1);

                }
            }
        }

        do {
            numberOfTimesToShift--;
            if (bounds.contains(reffIndex)) {
                int operand = fc.ROWS() - 1;
                reffIndex = reffIndex - 1 * operand;
            } else {
                reffIndex = reffIndex + 1;
            }

            if (!generatedIndexs.contains(reffIndex)) {
                generatedIndexs.add(reffIndex);
            }
        } while (numberOfTimesToShift > 0);

        return reffIndex;
    }

    public int transformUp(int reffIndex, int numberOfTimesToShift) {
        ArrayList<Integer> bounds = new ArrayList<>();
        ArrayList<Integer> generatedIndexs = new ArrayList<>();

        for (int i = 0; i <= ROW_COLUMN_COUNT; i = i + fc.COLUMS()) {
            if (i != ROW_COLUMN_COUNT) {
                for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
                    bounds.add(ROW_COLUMN_COUNT * i + j);
                }
            }
        }

        do {
            numberOfTimesToShift--;
            if (bounds.contains(reffIndex)) {
                int operand = fc.COLUMS() - 1;
                reffIndex = reffIndex + ROW_COLUMN_COUNT * operand;
            } else {
                reffIndex = reffIndex - ROW_COLUMN_COUNT;
            }

            if (!generatedIndexs.contains(reffIndex)) {
                generatedIndexs.add(reffIndex);
            }
        } while (numberOfTimesToShift > 0);

        return reffIndex;
    }

    public int transformDown(int reffIndex, int numberOfTimesToShift) {
        ArrayList<Integer> bounds = new ArrayList<>();
        ArrayList<Integer> generatedIndexs = new ArrayList<>();

        for (int i = 0; i <= ROW_COLUMN_COUNT; i = i + fc.COLUMS()) {
            if (i != 0) {
                for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
                    bounds.add(ROW_COLUMN_COUNT * i - ROW_COLUMN_COUNT + j);
                }
            }
        }
        do {
            numberOfTimesToShift--;
            if (bounds.contains(reffIndex)) {
                int operand = fc.COLUMS() - 1;
                reffIndex = reffIndex - ROW_COLUMN_COUNT * operand;
            } else {
                reffIndex = reffIndex + ROW_COLUMN_COUNT;
            }

            if (!generatedIndexs.contains(reffIndex)) {
                generatedIndexs.add(reffIndex);
            }
        } while (numberOfTimesToShift > 0);

        return reffIndex;
    }

}
