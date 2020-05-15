package xyz.chengzi.halma.controller;

import xyz.chengzi.halma.listener.InputListener;
import xyz.chengzi.halma.model.ChessBoard;
import xyz.chengzi.halma.model.ChessBoardLocation;
import xyz.chengzi.halma.model.ChessPiece;
import xyz.chengzi.halma.view.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GameController implements InputListener {
    private ChessBoardComponent view;
    private ChessBoard model;

    private ChessBoardLocation selectedLocation;
    private ChessBoardLocation lo;
    private int b = 0;//几人
    private int sum = 0;
    private int a = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private Color currentPlayer;
    private JLabel player;

    //private Layout playerNum;//弹窗


    public GameController(ChessBoardComponent chessBoardComponent, ChessBoard chessBoard) {
        this.view = chessBoardComponent;
        this.model = chessBoard;

        this.currentPlayer = Color.RED;
        view.registerListener(this);
        model.registerListener(view);
        model.placeInitialPieces();

    }

    public void restartGame() {
        this.currentPlayer = Color.GREEN;
        if (b == 0) {
            model.placeInitialPieces();
        } else {
            model.placeInitialPieces4();
        }
        player.setText("green turn");
    }

    public void restartGameRed() {
        this.currentPlayer = Color.RED;
        if (b == 0) {
            model.placeInitialPieces();
        } else {
            model.placeInitialPieces4();
        }
        player.setText("red turn");
    }

    public void restartGameBlue() {
        this.currentPlayer = Color.BLUE;
        if (b == 0) {
            model.placeInitialPieces4();
            player.setText("blue turn");
        }

    }

    public void restartGameBlack() {
        this.currentPlayer = Color.BLACK;
        if (b == 1) {
            model.placeInitialPieces4();
            player.setText("black turn");
        }

    }

    public void shift() {
        if (b == 0) {
            model.placeInitialPieces4();
            this.currentPlayer = Color.red;
        } else {
            model.placeInitialPieces();
            this.currentPlayer = Color.red;
        }
        player.setText("red turn");
    }

    public ChessBoardLocation getSelectedLocation() {
        return selectedLocation;
    }

    public void setPlayer(JLabel player) {
        this.player = player;
    }

    public void setSelectedLocation(ChessBoardLocation location) {
        this.selectedLocation = location;
    }


    public void resetSelectedLocation() {
        setSelectedLocation(null);

    }

    public boolean hasSelectedLocation() {
        return selectedLocation != null;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getA() {
        return a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public Color nextPlayer() {
        if (currentPlayer == Color.GREEN) {
            player.setText("red turn");
        }
        if (currentPlayer == Color.RED) {
            player.setText("green turn");
        }
        if (currentPlayer == Color.RED) return currentPlayer = Color.GREEN;
        return currentPlayer = Color.RED;
    }

    //4
    public Color nextPlayer4() {
        if (currentPlayer == Color.RED) {
            player.setText("blue turn");
            return currentPlayer = Color.BLUE;
        } else if (currentPlayer == Color.BLUE) {
            player.setText("green turn");
            return currentPlayer = Color.GREEN;
        } else if (currentPlayer == Color.GREEN) {
            player.setText("black turn");
            return currentPlayer = Color.BLACK;
        } else {
            player.setText("red turn");
            return currentPlayer = Color.red;
        }
    }

    public void saveGameToFile(String path) {
        int[][] gamePieces = new int[16][16];
        String line;
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if (true)
                        bf.write(gamePieces[i][j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadGameFromFile(String path) {
        int[][] gamePieces = new int[16][16];
        String line;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            while ((line = bf.readLine()) != null) {
                for (int i = 0; i < 16; i++) {
                    for (int j = 0; j < 16; j++) {
                        gamePieces[i][j] = Integer.parseInt(line.substring(i * 16 + j, i * 16 + j + 1));
                    }
                }
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.loadGame(gamePieces);
    }

    @Override
    public void onPlayerClickSquare(ChessBoardLocation location, SquareComponent component) {
        if (a == 1 && (!(c == 1 && !model.isOppred2(location))) && (!(d == 1 && !model.isOppgreen2(location))) && (!(e == 1 && !model.isOppred4(location))) && (!(f == 1 && !model.isOppgreen4(location))) && (!(g == 1 && !model.isOppblack4(location))) && (!(h == 1 && !model.isOppblue4(location)))) {
            c = 0;
            d = 0;
            e = 0;
            f = 0;
            g = 0;
            h = 0;
            if (hasSelectedLocation() && model.isValidMove(getSelectedLocation(), location) && !model.isJumpMove(getSelectedLocation(), location) && sum == 0) {
                model.moveChessPiece(selectedLocation, location);
                resetSelectedLocation();
                if (b == 0) {
                    nextPlayer();
                } else {
                    nextPlayer4();
                }
                sum = 0;
                a = 0;
            }
            if (hasSelectedLocation() && model.isValidMove(getSelectedLocation(), location) && model.isJumpMove(getSelectedLocation(), location) && sum == 0) {
                model.moveChessPiece(selectedLocation, location);
                lo = location;
                resetSelectedLocation();
                sum = 1;
                a = 0;
            }
            if (hasSelectedLocation() && sum == 1) {
                if (model.isJumpMove(getSelectedLocation(), location)) {
                    model.moveChessPiece(getSelectedLocation(), location);
                    lo = location;
                    resetSelectedLocation();
                    sum = 1;
                    a = 0;
                }
            }
        }
    }

    @Override
    public void onPlayerClickChessPiece(ChessBoardLocation location, ChessComponent component) {
        ChessPiece piece = model.getChessPieceAt(location);
        if (model.isOppred2(location) && currentPlayer == Color.green && b == 0) {
            c = 1;
            //System.out.println(0);
        }
        if (model.isOppgreen2(location) && currentPlayer == Color.red && b == 0) {
            d = 1;
            //System.out.println(1);
        }
        if (model.isOppred4(location) && currentPlayer == Color.green && b == 1) {
            e = 1;
            //System.out.println(2);
        }
        if (model.isOppgreen4(location) && currentPlayer == Color.red && b == 1) {
            f = 1;
            //System.out.println(3);
        }
        if (model.isOppblack4(location) && currentPlayer == Color.blue && b == 1) {
            g = 1;
            // System.out.println(4);
        }
        if (model.isOppblue4(location) && currentPlayer == Color.black && b == 1) {
            h = 1;
            // System.out.println(5);
        }
        if (piece.getColor() == currentPlayer && (!hasSelectedLocation() || location.equals(getSelectedLocation()))) {
            if (!hasSelectedLocation() && sum == 0) {
                setSelectedLocation(location);
                a = 1;
                //System.out.println(a);
            } else if (!hasSelectedLocation() && sum == 1) {
                a = 1;
                //System.out.println(a);
                if (lo.getColumn() == location.getColumn() && lo.getRow() == location.getRow()) {
                    setSelectedLocation(location);
                } else {
                    component.setSelected(!component.isSelected());
                    component.repaint();
                    //resetSelectedLocation();

                }
            } else {
                resetSelectedLocation();
                a = 0;
                //System.out.println(a);
                //System.out.println(1);
            }
            component.setSelected(!component.isSelected());
            component.repaint();
        }
    }
}