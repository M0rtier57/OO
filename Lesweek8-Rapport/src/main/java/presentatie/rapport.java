package presentatie;
import logica.Rapport;
import logica.Vak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class rapport {
    private JPanel rapport;
    private JFormattedTextField punt1;
    private JFormattedTextField punt2;
    private JFormattedTextField punt3;
    private JFormattedTextField punt4;
    private JFormattedTextField punt5;
    private JFormattedTextField punt6;
    private JLabel vak1;
    private JLabel vak2;
    private JLabel vak3;
    private JLabel vak4;
    private JLabel vak5;
    private JLabel vak6;
    private JLabel maxscore;
    private JLabel resultaat;
    private JPanel Rapport;

    public rapport() {
        this.vak1.setVisible(false);
        this.punt1.setVisible(false);
        this.vak2.setVisible(false);
        this.punt2.setVisible(false);
        this.vak3.setVisible(false);
        this.punt3.setVisible(false);
        this.vak4.setVisible(false);
        this.punt4.setVisible(false);
        this.vak5.setVisible(false);
        this.punt5.setVisible(false);
        this.vak6.setVisible(false);
        this.punt6.setVisible(false);

        Vak Vak1 = new Vak("Vak1", 6);
        Vak Vak2 = new Vak("Vak2", 3);
        Vak Vak3 = new Vak("Vak3", 12);
        Vak Vak4 = new Vak("Vak4", 3);
        Vak Vak5 = new Vak("Vak5", 6);
        Vak Vak6 = new Vak("Vak6", 12);

        this.maxscore.setText("Max score: " + String.valueOf(Vak.MAX_SCORE));
        Vak[] vakken = {Vak1, Vak2, Vak3, Vak4};
        if(vakken.length == 0) throw new IllegalArgumentException("er moet minstens 1 vak zijn");
        if(vakken.length >= 1 ) {
            this.vak1.setText(vakken[0].toString());
            this.vak1.setVisible(true);
            this.punt1.setVisible(true);
        }
        if(vakken.length >= 2 ) {
            this.vak2.setText(vakken[1].toString());
            this.vak2.setVisible(true);
            this.punt2.setVisible(true);
        }
        if(vakken.length >= 3 ) {
            this.vak3.setText(vakken[2].toString());
            this.vak3.setVisible(true);
            this.punt3.setVisible(true);
        }
        if(vakken.length >= 4 ) {
            this.vak4.setText(vakken[3].toString());
            this.vak4.setVisible(true);
            this.punt4.setVisible(true);
        }
        if(vakken.length >= 5 ) {
            this.vak5.setText(vakken[4].toString());
            this.vak5.setVisible(true);
            this.punt5.setVisible(true);
        }
        if(vakken.length == 6 ) {
            this.vak6.setText(vakken[5].toString());
            this.vak6.setVisible(true);
            this.punt6.setVisible(true);
        }
        if(vakken.length > 6) throw new IllegalArgumentException("Er kunnen maximaal 6 vakken zijn");


        Rapport rapport1 = new Rapport(vakken);
        resultaat.setText(rapport1.toString());

        punt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vak1.setScore(Integer.parseInt(punt1.getText()));
                resultaat.setText(rapport1.toString());

                if(Vak1.getScore() < 10) {
                    punt1.setBackground(Color.orange);
                }
                if(Vak1.getScore() >= 10) {
                    punt1.setBackground(Color.green);
                }
                if(Vak1.getScore() < 0 || Vak1.getScore() > 20) {
                    punt1.setBackground(Color.red);
                    resultaat.setText("Score moet binnen bereik[0,20] liggen");
                } else {
                    resultaat.setText(rapport1.toString());
                }
            }
        });
        punt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vak2.setScore(Integer.parseInt(punt2.getText()));
                resultaat.setText(rapport1.toString());

                if(Vak2.getScore() < 10) {
                    punt2.setBackground(Color.orange);
                }
                if(Vak2.getScore() >= 10) {
                    punt2.setBackground(Color.green);
                }
                if(Vak2.getScore() < 0 || Vak3.getScore() > 20) {
                    punt2.setBackground(Color.red);
                    resultaat.setText("Score moet binnen bereik[0,20] liggen");
                } else {
                    resultaat.setText(rapport1.toString());
                }
            }
        });
        punt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vak3.setScore(Integer.parseInt(punt3.getText()));
                resultaat.setText(rapport1.toString());

                if(Vak3.getScore() < 10) {
                    punt3.setBackground(Color.orange);
                }
                if(Vak3.getScore() >= 10) {
                    punt3.setBackground(Color.green);
                }
                if(Vak3.getScore() < 0 || Vak3.getScore() > 20) {
                    punt3.setBackground(Color.red);
                    resultaat.setText("Score moet binnen bereik[0,20] liggen");
                } else {
                    resultaat.setText(rapport1.toString());
                }
            }
        });
        punt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vak4.setScore(Integer.parseInt(punt4.getText()));
                resultaat.setText(rapport1.toString());

                if(Vak4.getScore() < 10) {
                    punt4.setBackground(Color.orange);
                }
                if(Vak4.getScore() >= 10) {
                    punt4.setBackground(Color.green);
                }
                if(Vak4.getScore() < 0 || Vak4.getScore() > 20) {
                    punt4.setBackground(Color.red);
                    resultaat.setText("Score moet binnen bereik[0,20] liggen");
                } else {
                    resultaat.setText(rapport1.toString());
                }
            }
        });
        punt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vak5.setScore(Integer.parseInt(punt5.getText()));
                resultaat.setText(rapport1.toString());

                if(Vak5.getScore() < 10) {
                    punt5.setBackground(Color.orange);
                }
                if(Vak5.getScore() >= 10) {
                    punt5.setBackground(Color.green);
                }
                if(Vak5.getScore() < 0 || Vak5.getScore() > 20) {
                    punt5.setBackground(Color.red);
                    resultaat.setText("Score moet binnen bereik[0,20] liggen");
                } else {
                    resultaat.setText(rapport1.toString());
                }
            }
        });
        punt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vak6.setScore(Integer.parseInt(punt6.getText()));


                if(Vak6.getScore() < 10) {
                    punt6.setBackground(Color.orange);
                }
                if(Vak6.getScore() >= 10) {
                    punt6.setBackground(Color.green);
                }
                if(Vak6.getScore() < 0 || Vak6.getScore() > 20) {
                    punt6.setBackground(Color.red);
                    resultaat.setText("Score moet binnen bereik[0,20] liggen");
                } else {
                    resultaat.setText(rapport1.toString());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rapport");
        frame.setContentPane(new rapport().rapport);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
