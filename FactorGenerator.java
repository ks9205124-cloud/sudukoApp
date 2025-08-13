/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suduko;

public class FactorGenerator {

    int number;
    private int myRow;
    private int myColumn;

    public FactorGenerator(int number) {
        this.number = number;
        GenerateFactor();
    }

    // sirf do factor chahiye and factor1 and factor2 ko multiply karne par same number chahiye!!
    private void GenerateFactor() {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j < +number; j++) {
                if (number % i == 0 && i != 1 && i != number) {
                    if (number % j == 0 && j != 1 && j != number) {
                        if (i * i == number) {
                            myRow = i;
                            myColumn = i;
                            return;
                        } else if (i * j == number) {
                            if (i >= j) {
                                myRow = i;
                                myColumn = j;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public int ROWS() {
        return myRow;
    }
    public int COLUMS() {
        return myColumn;
    }
}
