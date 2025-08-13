/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package suduko;

public class main {

    public static void main(String[] args) {
        // TODO code application logic here
        //here 900,700 defines width and height of the respective grid
        //while 9 is the number of gridBoxes to generate//
        UI ui = new UI();
        ui.CreateSuduko(900, 700, 9);
    }
    
}
