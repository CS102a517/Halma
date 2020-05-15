package xyz.chengzi.halma.view;

import xyz.chengzi.halma.controller.GameController;
import xyz.chengzi.halma.listener.GameListener;
import xyz.chengzi.halma.listener.InputListener;
import xyz.chengzi.halma.listener.Listenable;
import xyz.chengzi.halma.model.ChessBoard;
import xyz.chengzi.halma.model.ChessBoardLocation;
import xyz.chengzi.halma.model.ChessPiece;
import xyz.chengzi.halma.model.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ChessBoardComponent extends JComponent implements Listenable<InputListener>, GameListener {
    private static final Color BOARD_COLOR_1 = new Color(255, 255, 30);
    private static final Color BOARD_COLOR_2 = new Color(170, 170, 170);
    private static final Color BOARD_COLOR_3 = new Color(255, 255, 255);

    private List<InputListener> listenerList = new ArrayList<>();
    private SquareComponent[][] gridComponents;
    private int dimension;
    private int gridSize;


    public ChessBoardComponent(int size, int dimension) {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        setLayout(null); // Use absolute layout
        setSize(size, size);

        this.gridComponents = new SquareComponent[dimension][dimension];
        this.dimension = dimension;
        this.gridSize = size / dimension;
        initGridComponents();
    }

    private void initGridComponents() {
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                if ((row + col) % 2 == 0) {
                    gridComponents[row][col] = new SquareComponent(gridSize,
                            BOARD_COLOR_1);
                } else {
                    gridComponents[row][col] = new SquareComponent(gridSize,
                            BOARD_COLOR_2);
                }
                gridComponents[row][col].setLocation(row * gridSize, col * gridSize);
                add(gridComponents[row][col]);
            }
        }
    }

    public SquareComponent getGridAt(ChessBoardLocation location) {
        return gridComponents[location.getRow()][location.getColumn()];
    }

    public void setChessAtGrid(ChessBoardLocation location, Color color) {
        removeChessAtGrid(location);
        getGridAt(location).add(new ChessComponent(color));
    }

    public void removeChessAtGrid(ChessBoardLocation location) {
        // Note: re-validation is required after remove / removeAll
        getGridAt(location).removeAll();
        getGridAt(location).revalidate();
    }

    private ChessBoardLocation getLocationByPosition(int x, int y) {
        return new ChessBoardLocation(x / gridSize, y / gridSize);
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);

        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
            JComponent clickedComponent = (JComponent) getComponentAt(e.getX(), e.getY());
            ChessBoardLocation location = getLocationByPosition(e.getX(), e.getY());
            for (InputListener listener : listenerList) {
                if (clickedComponent.getComponentCount() == 0) {
                    listener.onPlayerClickSquare(location, (SquareComponent) clickedComponent);
                } else {
                    listener.onPlayerClickChessPiece(location, (ChessComponent) clickedComponent.getComponent(0));

                }
            }
        }
    }


    @Override
    public void onChessPiecePlace(ChessBoardLocation location, ChessPiece piece) {
        setChessAtGrid(location, piece.getColor());
        repaint();
    }

    /* public boolean onChessPieceExist(ChessBoardLocation location, ChessPiece piece) {
         if (piece.getColor() == Color.RED || piece.getColor() == Color.GREEN) {
             return true;
         } else {
             return false;
         }
     }*/

    @Override
    public void onChessPieceRemove(ChessBoardLocation location) {
        removeChessAtGrid(location);
        repaint();
    }

    @Override
    public void onChessBoardReload(ChessBoard board) {
        for (int row = 0; row < board.getDimension(); row++) {
            for (int col = 0; col < board.getDimension(); col++) {
                ChessBoardLocation location = new ChessBoardLocation(row, col);
                ChessPiece piece = board.getChessPieceAt(location);
                if (piece != null) {
                    setChessAtGrid(location, piece.getColor());
                } else {
                    removeChessAtGrid(location);
                }
            }
        }
        repaint();
    }

    @Override
    public void registerListener(InputListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void unregisterListener(InputListener listener) {
        listenerList.remove(listener);
    }
}
