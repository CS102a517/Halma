package xyz.chengzi.halma.view;

import xyz.chengzi.halma.controller.GameController;
import xyz.chengzi.halma.model.ChessBoard;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        setTitle("halma");
        setSize(900, 900);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
//原Halma
        ChessBoardComponent chessBoardComponent = new ChessBoardComponent(600, 16);
        ChessBoard chessBoard = new ChessBoard(16);
        GameController controller = new GameController(chessBoardComponent, chessBoard);
        add(chessBoardComponent);

        JLabel statusLabel = new JLabel("Start!");
        statusLabel.setLocation(0, 600);
        statusLabel.setSize(100, 15);
        add(statusLabel);
        controller.setPlayer(statusLabel);

        JButton button0 = new JButton("shift");
        button0.addActionListener((e) -> {
            controller.shift();
            if (controller.getB() == 0) {
                controller.setB(1);
            } else {
                controller.setB(0);
            }
        });
        button0.setLocation(170, 600);
        button0.setSize(70, 15);
        add(button0);

        JButton button = new JButton("green");
        button.addActionListener((e) -> {
            if (controller.getA() == 0) {
                controller.restartGame();
                controller.setSum(0);
            }
        });
        button.setLocation(367, 600);
        button.setSize(70, 15);
        add(button);

        JButton button2 = new JButton("red");
        button2.addActionListener((e) -> {
            if (controller.getA() == 0) {
                controller.restartGameRed();
                controller.setSum(0);
            }
        });
        button2.setLocation(250, 600);
        button2.setSize(55, 15);
        add(button2);

        JButton button3 = new JButton("blue");
        button3.addActionListener((e) -> {
            if (controller.getA() == 0) {
                controller.restartGameBlue();
                controller.setSum(0);
            }
        });
        button3.setLocation(306,600);
        button3.setSize(60,15);
        add(button3);

        JButton button4 = new JButton("black");
        button4.addActionListener((e) -> {
            if (controller.getA() == 0) {
                controller.restartGameBlack();
                controller.setSum(0);
            }
        });
        button4.setLocation(440,600);
        button4.setSize(65,15);
        add(button4);

        /*JButton button3 = new JButton("load");
        button3.addActionListener((e) -> controller.loadGameFromFile("C:\\Users\\0\\IdeaProjects\\cs102a\\project\\src\\Load.txt"));
        button3.setLocation(205, 600);
        button3.setSize(60, 15);
        add(button3);

        JButton button4 = new JButton("save");
        button4.addActionListener((e) -> controller.saveGameToFile("C:\\Users\\0\\IdeaProjects\\cs102a\\project\\src\\Load.txt"));
        button4.setLocation(275, 600);
        button4.setSize(65, 15);
        add(button4);*/

        JButton button5 = new JButton("jump");
        button5.addActionListener((e) -> {
            if (controller.getA() == 0) {
                controller.resetSelectedLocation();
                if (controller.getB() == 0) {
                    controller.nextPlayer();
                } else {
                    controller.nextPlayer4();
                }
                controller.setSum(0);
            }
        });
        button5.setLocation(101, 600);
        button5.setSize(65, 15);
        add(button5);
    }
}
/*class GameLayout extends JFrame{
    public GameLayout(){
        setTitle("BATTLE CODE");
        setSize(500, 220);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
    }

}*/
