/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suduko;

import java.util.ArrayList;

public class Box {
    
    int ROW_COLUMN_COUNT;

    public int[][] index;
    public ArrayList<Integer> indexReff = new ArrayList<>();
    //generates rows and columns for  suduko.
    FactorGenerator fc;
    //generates the pos to add transformation on.
    ArrayList<Integer> posDefault = new ArrayList<>();
    //generates the number of times to shift.
    ArrayList<Integer> transfRow_ShiftIndexs = new ArrayList<>();
    ArrayList<Integer> transfColumn_ShiftIndes = new ArrayList<>();
    //temp data of columns generated.
    ArrayList<Integer> data_TransformedRow = new ArrayList<>();
    ArrayList<Integer> data_TransformedColumn = new ArrayList<>();

    ArrayList<ArrayList<Integer>> listOfList_PosDefalut = new ArrayList<>();
    ArrayList<ArrayList<String>> listOfList_reffIndex = new ArrayList<>();

    public Box(int ROW_COLUMN_COUNT) {

        this.ROW_COLUMN_COUNT = ROW_COLUMN_COUNT;
        fc = new FactorGenerator(ROW_COLUMN_COUNT);

        index = new int[ROW_COLUMN_COUNT][ROW_COLUMN_COUNT];
    }

    public void GeneratePos1Index() {
        posDefault.clear();

        transfColumn_ShiftIndes.clear();
        transfRow_ShiftIndexs.clear();

        data_TransformedColumn.clear();
        data_TransformedRow.clear();
        
        for (int rows = 0; rows < fc.ROWS(); rows++) {
            for (int columns = 0; columns < fc.COLUMS(); columns++) {
                for (int i = 0; i < ROW_COLUMN_COUNT; i = i + fc.ROWS()) {
                    for (int j = 0; j < ROW_COLUMN_COUNT; j = j + fc.COLUMS()) {
                        if (!posDefault.contains(ROW_COLUMN_COUNT * (i + rows) + (j + columns))) {
                            posDefault.add(ROW_COLUMN_COUNT * (i + rows) + (j + columns));
                        }
                    }

                }
            }
        }
        for (int i = 0; i < posDefault.size(); i++) {
            transfRow_ShiftIndexs.add(Y_Indexs(posDefault.get(i)));
            data_TransformedRow.add(transformDown(posDefault.get(i), ROW_COLUMN_COUNT + transfRow_ShiftIndexs.get(i)));
            transfColumn_ShiftIndes.add(X_Indexs(data_TransformedRow.get(i)));
            data_TransformedColumn.add(transformRight(data_TransformedRow.get(i), ROW_COLUMN_COUNT + transfColumn_ShiftIndes.get(i)));
            indexReff.add(data_TransformedColumn.get(i));
        }
    }

    public int X_Indexs(int reffIndex) {
        ArrayList<Integer> rowData = new ArrayList<>();
        ArrayList<Integer> bounds = new ArrayList<>();
        ArrayList<Integer> shiftIndex = new ArrayList<>();

        for (int i = 0; i < ROW_COLUMN_COUNT; i = i + fc.ROWS()) {
            rowData.add(i);
        }
        for (int arrayIndex = 0; arrayIndex < rowData.size(); arrayIndex++) {
            if (!bounds.contains(ROW_COLUMN_COUNT * rowData.get(arrayIndex))) {
                bounds.add(ROW_COLUMN_COUNT * rowData.get(arrayIndex));
            }
        }

        for (int i = 0; i < bounds.size(); i++) {
            if (reffIndex >= bounds.get(i)) {
                shiftIndex.add(i);
            }
        }
        return shiftIndex.getLast();
    }

    public int Y_Indexs(int reffIndex) {
        int myInt = 0;

        ArrayList<Integer> columnData = new ArrayList<>();
        ArrayList<Integer> bounds = new ArrayList<>();
        for (int i = 0; i < ROW_COLUMN_COUNT; i = i + fc.COLUMS()) {
            if (!columnData.contains(i)) {
                columnData.add(i);
            }
        }
        for (int i = 0; i < ROW_COLUMN_COUNT; i++) {
            if (!bounds.contains(ROW_COLUMN_COUNT * i)) {
                bounds.add(ROW_COLUMN_COUNT * i);
            }
        }
        for (int i = 0; i < bounds.size(); i++) {
            for (int j = 0; j < columnData.size(); j++) {
                if (reffIndex >= bounds.get(i) + columnData.get(j)) {
                    myInt = j;
                }
            }
        }
        return myInt;
    }

    //bounding must be added  in later stages.
    public int transformLeft(int reffIndex, int numberOfTimesToShift) {
        ArrayList<Integer> bounds = new ArrayList<>();
        ArrayList<Integer> generatedIndexs = new ArrayList<>();

        for (int i = 0; i <= ROW_COLUMN_COUNT; i = i + fc.COLUMS()) {
            if (i != ROW_COLUMN_COUNT) {
                for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
                    bounds.add(ROW_COLUMN_COUNT * j + i);
                }
            }
        }
        do {
            numberOfTimesToShift--;
            if (bounds.contains(reffIndex)) {
                int operand = fc.COLUMS() - 1;
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

        for (int i = 0; i <= ROW_COLUMN_COUNT; i = i + fc.COLUMS()) {
            if (i != 0) {
                for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
                    bounds.add(ROW_COLUMN_COUNT * j + i - 1);

                }
            }
        }

        do {
            numberOfTimesToShift--;
            if (bounds.contains(reffIndex)) {
                int operand = fc.COLUMS() - 1;
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

        for (int i = 0; i <= ROW_COLUMN_COUNT; i = i + fc.ROWS()) {
            if (i != ROW_COLUMN_COUNT) {
                for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
                    bounds.add(ROW_COLUMN_COUNT * i + j);
                }
            }
        }

        do {
            numberOfTimesToShift--;
            if (bounds.contains(reffIndex)) {
                int operand = fc.ROWS() - 1;
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

        for (int i = 0; i <= ROW_COLUMN_COUNT; i = i + fc.ROWS()) {
            if (i != 0) {
                for (int j = 0; j < ROW_COLUMN_COUNT; j++) {
                    bounds.add(ROW_COLUMN_COUNT * i - ROW_COLUMN_COUNT + j);
                }
            }
        }
        do {
            numberOfTimesToShift--;
            if (bounds.contains(reffIndex)) {
                int operand = fc.ROWS() - 1;
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
