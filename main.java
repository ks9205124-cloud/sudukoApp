/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package suduko;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main extends JFrame {

    public static void main(String[] args) {
        JFrame jf = new JFrame("Suduko");

        JLabel nameLabel = new JLabel("Enter a number 'n' to generate n*n suduko");
        JTextField txtField = new JTextField();
        txtField.setPreferredSize(new Dimension(150, 25));
        JButton GenerateSuduko = new JButton("Generate");

        jf.setSize(700, 100);

        FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 25,25);
        JPanel MENU_BAR_TOP = new JPanel(fl);
        MENU_BAR_TOP.add(nameLabel);
        MENU_BAR_TOP.add(txtField);
        MENU_BAR_TOP.add(GenerateSuduko);

        ActionListener actionListenerTop = (event) -> {
            if (event.getSource() == GenerateSuduko) {
                try {
                    UI ui = new UI();
                    ui.CreateSuduko(900, 700, Integer.parseInt(txtField.getText()));
                    jf.dispose();
                } catch (NumberFormatException ex) {
                    txtField.setText("eneter-non prime Int");
                }
            }
        };

        GenerateSuduko.addActionListener(actionListenerTop);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(MENU_BAR_TOP, BorderLayout.NORTH);
        jf.setVisible(true);

        // TODO code application logic here
    }

    @Override
    public Insets getInsets() {
        return new Insets(35, 15, 35, 15);
    }
}
