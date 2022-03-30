package presentatie;

import logica.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * rendement : GUI
 *
 * @author kristien.vanassche
 * @version 27/03/2022
 */
public class GUI {
    private JTextField textFieldBedragInvestering;
    private JTextField textFieldRend1;
    private JTextField textFieldRend2;
    private JTextField textFieldRend3;
    private JTextField textFieldRend4;
    private JTextField textFieldRend5;
    private JLabel labelMeetkundigRendement;
    private JButton meetkundigRendementButton;
    private JPanel panelMain;
    private JButton buttonOpbrengst;
    private JLabel labelOpbrengst;
    private JTextField textFieldNaam;
    private JLabel labelError;

    public GUI() {
        labelError.setForeground(Color.RED);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI - Belegging");
        frame.setContentPane(new GUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(600, 300);
        frame.setVisible(true);
    }
}
