package xyz.chengzi.halma.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import xyz.chengzi.halma.controller.GameController;

public class Layout extends JFrame {
    /*private JButton btn1, btn2, btn3;

    public Layout() {
        super("choose the number of players");
        setLayout(new GridLayout(3, 1, 1, 3));
        btn1 = new JButton("2");
        add(btn1);
        btn2 = new JButton("4");
        add(btn2);
        btn3 = new JButton("6");
        add(btn3);
    }

    public static void main(String[] args) {
        Layout num = new Layout();
        num.setVisible(true);
        num.pack();
        num.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }*/
    private JButton plainJButton1;
    private JButton plainJButton2;
    private JButton plainJButton3;
    private JButton plainJButton4;
    //private int JFrameSize;

    private JTextField question;

    // ButtonFrame adds JButtons to JFrame
    public Layout() {
        super("BATTLE CODE");
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(4, 1));

        plainJButton1 = new JButton("2 against mode");
        jp.add(plainJButton1);

        plainJButton2 = new JButton("4 against mode");
        jp.add(plainJButton2);

        plainJButton3 = new JButton("6 against mode");
        jp.add(plainJButton3);

        plainJButton4 = new JButton("Man-machine battle mode");
        jp.add(plainJButton4);

        add(jp, BorderLayout.SOUTH);
        question = new JTextField("Please select the battle mode !");
        question.setEditable(false);
        question.setHorizontalAlignment(JTextField.CENTER);
        add(question, BorderLayout.CENTER);


        // create new ButtonHandler for button event handling
        ButtonHandler handler = new ButtonHandler();
        plainJButton1.addActionListener(handler);
        plainJButton2.addActionListener(handler);
        plainJButton3.addActionListener(handler);
        plainJButton4.addActionListener(handler);
        question.addActionListener(handler);
    }

    //inner class for button event handling
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == plainJButton1) {

            } else if (event.getSource() == plainJButton2) {

            } else if (event.getSource() == plainJButton3) {

            } else if (event.getSource() == plainJButton4) {

            }
        }
    }

   /* public int getJFrameSize() {
        return JFrameSize;
    }*/

   /* public void setJFrameSize(int JFrameSize) {
        this.JFrameSize = JFrameSize;
    }*/
}
