package xyz.chengzi.halma.model;

import xyz.chengzi.halma.listener.GameListener;
import xyz.chengzi.halma.listener.Listenable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChessBoard implements Listenable<GameListener> {
    private List<GameListener> listenerList = new ArrayList<>();
    private Square[][] grid;
    private int dimension;

    public ChessBoard(int dimension) {
        this.grid = new Square[dimension][dimension];
        this.dimension = dimension;

        initGrid();
    }

    private void initGrid() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                grid[i][j] = new Square(new ChessBoardLocation(i, j));//i是列
            }
        }
    }

    public void placeInitialPieces() {
        // TODO: This is only a demo implementation
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                grid[i][j].setPiece(null);
            }
        }
        grid[0][0].setPiece(new ChessPiece(Color.RED));
        grid[0][1].setPiece(new ChessPiece(Color.RED));
        grid[0][2].setPiece(new ChessPiece(Color.RED));
        grid[0][3].setPiece(new ChessPiece(Color.RED));
        grid[0][4].setPiece(new ChessPiece(Color.RED));
        grid[1][0].setPiece(new ChessPiece(Color.RED));
        grid[1][1].setPiece(new ChessPiece(Color.RED));
        grid[1][2].setPiece(new ChessPiece(Color.RED));
        grid[1][3].setPiece(new ChessPiece(Color.RED));
        grid[1][4].setPiece(new ChessPiece(Color.RED));
        grid[2][0].setPiece(new ChessPiece(Color.RED));
        grid[2][1].setPiece(new ChessPiece(Color.RED));
        grid[2][2].setPiece(new ChessPiece(Color.RED));
        grid[2][3].setPiece(new ChessPiece(Color.RED));
        grid[3][0].setPiece(new ChessPiece(Color.RED));
        grid[3][1].setPiece(new ChessPiece(Color.RED));
        grid[3][2].setPiece(new ChessPiece(Color.RED));
        grid[4][0].setPiece(new ChessPiece(Color.RED));
        grid[4][1].setPiece(new ChessPiece(Color.RED));
        grid[dimension - 1][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 4].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 5].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 4].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 5].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 4].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 4][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 4][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 4][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 5][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 5][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        listenerList.forEach(listener -> listener.onChessBoardReload(this));
    }

    //4人
    public void placeInitialPieces4() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                grid[i][j].setPiece(null);
            }
        }
        grid[0][0].setPiece(new ChessPiece(Color.RED));
        grid[0][1].setPiece(new ChessPiece(Color.RED));
        grid[0][2].setPiece(new ChessPiece(Color.RED));
        grid[0][3].setPiece(new ChessPiece(Color.RED));
        grid[1][0].setPiece(new ChessPiece(Color.RED));
        grid[1][1].setPiece(new ChessPiece(Color.RED));
        grid[1][2].setPiece(new ChessPiece(Color.RED));
        grid[1][3].setPiece(new ChessPiece(Color.RED));
        grid[2][0].setPiece(new ChessPiece(Color.RED));
        grid[2][1].setPiece(new ChessPiece(Color.RED));
        grid[2][2].setPiece(new ChessPiece(Color.RED));
        grid[3][0].setPiece(new ChessPiece(Color.RED));
        grid[3][1].setPiece(new ChessPiece(Color.RED));
        grid[dimension - 1][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 1][dimension - 4].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 2][dimension - 4].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 3][dimension - 3].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 4][dimension - 1].setPiece(new ChessPiece(Color.GREEN));
        grid[dimension - 4][dimension - 2].setPiece(new ChessPiece(Color.GREEN));
        grid[0][dimension - 1].setPiece(new ChessPiece(Color.BLACK));
        grid[0][dimension - 2].setPiece(new ChessPiece(Color.BLACK));
        grid[0][dimension - 3].setPiece(new ChessPiece(Color.BLACK));
        grid[0][dimension - 4].setPiece(new ChessPiece(Color.BLACK));
        grid[1][dimension - 1].setPiece(new ChessPiece(Color.BLACK));
        grid[1][dimension - 2].setPiece(new ChessPiece(Color.BLACK));
        grid[1][dimension - 3].setPiece(new ChessPiece(Color.BLACK));
        grid[1][dimension - 4].setPiece(new ChessPiece(Color.BLACK));
        grid[2][dimension - 1].setPiece(new ChessPiece(Color.BLACK));
        grid[2][dimension - 2].setPiece(new ChessPiece(Color.BLACK));
        grid[2][dimension - 3].setPiece(new ChessPiece(Color.BLACK));
        grid[3][dimension - 1].setPiece(new ChessPiece(Color.BLACK));
        grid[3][dimension - 2].setPiece(new ChessPiece(Color.BLACK));
        grid[dimension - 1][0].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 1][1].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 1][2].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 1][3].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 2][0].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 2][1].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 2][2].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 2][3].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 3][0].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 3][1].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 3][2].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 4][0].setPiece(new ChessPiece(Color.BLUE));
        grid[dimension - 4][1].setPiece(new ChessPiece(Color.BLUE));
        listenerList.forEach(listener -> listener.onChessBoardReload(this));
    }

    public void setVoid() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                grid[i][j].setPiece(null);
            }
            listenerList.forEach(listener -> listener.onChessBoardReload(this));
        }
    }
    //判断棋子是否存在
   /* public int pieceExist(ChessBoardLocation location){
        if(getGridAt(location)==null){
            return 0;
        }else if(){
            return 1;
        }else if()
    }*/

    public Square getGridAt(ChessBoardLocation location) {
        return grid[location.getRow()][location.getColumn()];
    }

    public Square getGridExist(ChessBoardLocation location, ChessBoardLocation lo2) {
        return grid[(location.getRow() + lo2.getRow()) / 2][(location.getColumn() + lo2.getColumn()) / 2];
    }

    public ChessPiece getChessPieceexist(ChessBoardLocation location, ChessBoardLocation lo2) {
        return getGridExist(location, lo2).getPiece();
    }

    public ChessPiece getChessPieceAt(ChessBoardLocation location) {
        return getGridAt(location).getPiece();
    }

    public void setChessPieceAt(ChessBoardLocation location, ChessPiece piece) {
        getGridAt(location).setPiece(piece);
        listenerList.forEach(listener -> listener.onChessPiecePlace(location, piece));
    }

    public ChessPiece removeChessPieceAt(ChessBoardLocation location) {
        ChessPiece piece = getGridAt(location).getPiece();
        getGridAt(location).setPiece(null);
        listenerList.forEach(listener -> listener.onChessPieceRemove(location));
        return piece;
    }

    public void moveChessPiece(ChessBoardLocation src, ChessBoardLocation dest) {
        if (!(isValidMove(src, dest) || isJumpMove(src, dest))) {
            throw new IllegalArgumentException("Illegal halma move");
        }
        setChessPieceAt(dest, removeChessPieceAt(src));
    }

    public int getDimension() {
        return dimension;
    }

    //判断进对方
    public boolean isOppred2(ChessBoardLocation location) {
        if( getGridAt(location) == grid[0][0] ||
                getGridAt(location) == grid[0][1] ||
                getGridAt(location) == grid[0][2] ||
                getGridAt(location) == grid[0][3] ||
                getGridAt(location) == grid[0][4] ||
                getGridAt(location) == grid[1][0] ||
                getGridAt(location) == grid[1][1] ||
                getGridAt(location) == grid[1][2] ||
                getGridAt(location) == grid[1][3] ||
                getGridAt(location) == grid[1][4] ||
                getGridAt(location) == grid[2][0] ||
                getGridAt(location) == grid[2][1] ||
                getGridAt(location) == grid[2][2] ||
                getGridAt(location) == grid[2][3] ||
                getGridAt(location) == grid[3][0] ||
                getGridAt(location) == grid[3][1] ||
                getGridAt(location) == grid[3][2] ||
                getGridAt(location) == grid[4][0] ||
                getGridAt(location) == grid[4][1]){
            return true;
        }else{
            return false;
        }
    }

    public boolean isOppgreen4(ChessBoardLocation location) {
        if( getGridAt(location) == grid[dimension - 1][dimension - 1] ||
                getGridAt(location) == grid[dimension - 1][dimension - 2] ||
                getGridAt(location) == grid[dimension - 1][dimension - 3] ||
                getGridAt(location) == grid[dimension - 1][dimension - 4] ||
                getGridAt(location) == grid[dimension - 2][dimension - 1] ||
                getGridAt(location) == grid[dimension - 2][dimension - 2] ||
                getGridAt(location) == grid[dimension - 2][dimension - 3] ||
                getGridAt(location) == grid[dimension - 2][dimension - 4] ||
                getGridAt(location) == grid[dimension - 3][dimension - 1] ||
                getGridAt(location) == grid[dimension - 3][dimension - 2] ||
                getGridAt(location) == grid[dimension - 3][dimension - 3] ||
                getGridAt(location) == grid[dimension - 2][dimension - 1] ||
                getGridAt(location) == grid[dimension - 2][dimension - 2]){
            return true;
        }else{
            return false;
        }
    }

    public boolean isOppred4(ChessBoardLocation location) {
        if( getGridAt(location) == grid[0][0] ||
                getGridAt(location) == grid[0][1] ||
                getGridAt(location) == grid[0][2] ||
                getGridAt(location) == grid[0][3] ||
                getGridAt(location) == grid[1][0] ||
                getGridAt(location) == grid[1][1] ||
                getGridAt(location) == grid[1][2] ||
                getGridAt(location) == grid[1][3] ||
                getGridAt(location) == grid[2][0] ||
                getGridAt(location) == grid[2][1] ||
                getGridAt(location) == grid[2][2] ||
                getGridAt(location) == grid[3][0] ||
                getGridAt(location) == grid[3][1]){
            return true;
        }else{
            return false;
        }
    }

    public boolean isOppgreen2(ChessBoardLocation location) {
        if( getGridAt(location) == grid[dimension - 1][dimension - 1] ||
                getGridAt(location) == grid[dimension - 1][dimension - 2] ||
                getGridAt(location) == grid[dimension - 1][dimension - 3] ||
                getGridAt(location) == grid[dimension - 1][dimension - 4] ||
                getGridAt(location) == grid[dimension - 1][dimension - 5] ||
                getGridAt(location) == grid[dimension - 2][dimension - 1] ||
                getGridAt(location) == grid[dimension - 2][dimension - 2] ||
                getGridAt(location) == grid[dimension - 2][dimension - 3] ||
                getGridAt(location) == grid[dimension - 2][dimension - 4] ||
                getGridAt(location) == grid[dimension - 2][dimension - 5] ||
                getGridAt(location) == grid[dimension - 3][dimension - 1] ||
                getGridAt(location) == grid[dimension - 3][dimension - 2] ||
                getGridAt(location) == grid[dimension - 3][dimension - 3] ||
                getGridAt(location) == grid[dimension - 3][dimension - 4] ||
                getGridAt(location) == grid[dimension - 4][dimension - 1] ||
                getGridAt(location) == grid[dimension - 4][dimension - 2] ||
                getGridAt(location) == grid[dimension - 4][dimension - 3] ||
                getGridAt(location) == grid[dimension - 5][dimension - 1] ||
                getGridAt(location) == grid[dimension - 5][dimension - 2]){
            return true;
        }else{
            return false;
        }
    }

    public boolean isOppblack4(ChessBoardLocation location) {
        if( getGridAt(location) == grid[0][dimension - 1] ||
                getGridAt(location) == grid[0][dimension - 2] ||
                getGridAt(location) == grid[0][dimension - 3] ||
                getGridAt(location) == grid[0][dimension - 4] ||
                getGridAt(location) == grid[1][dimension - 1] ||
                getGridAt(location) == grid[1][dimension - 2] ||
                getGridAt(location) == grid[1][dimension - 3] ||
                getGridAt(location) == grid[1][dimension - 4] ||
                getGridAt(location) == grid[2][dimension - 1] ||
                getGridAt(location) == grid[2][dimension - 2] ||
                getGridAt(location) == grid[2][dimension - 3] ||
                getGridAt(location) == grid[3][dimension - 1] ||
                getGridAt(location) == grid[3][dimension - 2]){
            return true;
        }else{
            return false;
        }
    }

    public boolean isOppblue4(ChessBoardLocation location) {
        if( getGridAt(location) == grid[dimension - 1][0] ||
                getGridAt(location) == grid[dimension - 1][1] ||
                getGridAt(location) == grid[dimension - 1][2] ||
                getGridAt(location) == grid[dimension - 1][3] ||
                getGridAt(location) == grid[dimension - 2][0] ||
                getGridAt(location) == grid[dimension - 2][1] ||
                getGridAt(location) == grid[dimension - 2][2] ||
                getGridAt(location) == grid[dimension - 2][3] ||
                getGridAt(location) == grid[dimension - 3][0] ||
                getGridAt(location) == grid[dimension - 3][1] ||
                getGridAt(location) == grid[dimension - 3][2] ||
                getGridAt(location) == grid[dimension - 4][0] ||
                getGridAt(location) == grid[dimension - 4][1]){
            return true;
        }
        return false;
    }

    public boolean isValidMove(ChessBoardLocation src, ChessBoardLocation dest) {
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        int srcRow = src.getRow(), srcCol = src.getColumn(), destRow = dest.getRow(), destCol = dest.getColumn();
        int rowDistance = destRow - srcRow, colDistance = destCol - srcCol;
        if (srcRow == destRow && Math.abs(srcCol - destCol) == 2 && getChessPieceexist(src, dest) != null) {
            return true;
        }
        if (srcCol == destCol && Math.abs(srcRow - destRow) == 2 && getChessPieceexist(src, dest) != null) {
            return true;
        }
        if (Math.abs(rowDistance) == 2 && Math.abs(colDistance) == 2 && getChessPieceexist(src, dest) != null) {
            return true;
        }
        if (rowDistance != 0 && colDistance != 0 && Math.abs((double) rowDistance / colDistance) != 1.0) {
            return false;
        }
        if (Math.abs(rowDistance) <= 1 && Math.abs(colDistance) <= 1) return true;
        else return false;
    }

    public boolean isSameMove(ChessBoardLocation src, ChessBoardLocation dest) {
        if (getChessPieceAt(src) == getChessPieceAt(dest)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isJumpMove(ChessBoardLocation src, ChessBoardLocation dest) {
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        int srcRow = src.getRow(), srcCol = src.getColumn(), destRow = dest.getRow(), destCol = dest.getColumn();
        int rowDistance = destRow - srcRow, colDistance = destCol - srcCol;
        if (srcRow == destRow && Math.abs(srcCol - destCol) == 2 && getChessPieceexist(src, dest) != null) {
            return true;
        }
        if (srcCol == destCol && Math.abs(srcRow - destRow) == 2 && getChessPieceexist(src, dest) != null) {
            return true;
        }
        if (Math.abs(rowDistance) == 2 && Math.abs(colDistance) == 2 && getChessPieceexist(src, dest) != null) {
            return true;
        } else {
            return false;
        }
    }

    //多次跳
    public boolean isJumpmuch(ChessBoardLocation src, ChessBoardLocation dest) {
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        ChessBoardLocation mid = new ChessBoardLocation((src.getRow() + dest.getRow()) / 2, (src.getColumn() + dest.getColumn()) / 2);
        ChessBoardLocation s1 = new ChessBoardLocation(dest.getRow() - 1, dest.getColumn());
        ChessBoardLocation s2 = new ChessBoardLocation(dest.getRow() + 1, dest.getColumn());
        ChessBoardLocation s3 = new ChessBoardLocation(dest.getRow() - 1, dest.getColumn() - 1);
        ChessBoardLocation s4 = new ChessBoardLocation(dest.getRow() + 1, dest.getColumn() - 1);
        ChessBoardLocation s5 = new ChessBoardLocation(dest.getRow() - 1, dest.getColumn() + 1);
        ChessBoardLocation s6 = new ChessBoardLocation(dest.getRow() + 1, dest.getColumn() + 1);
        ChessBoardLocation s7 = new ChessBoardLocation(dest.getRow(), dest.getColumn() - 1);
        ChessBoardLocation s8 = new ChessBoardLocation(dest.getRow(), dest.getColumn() + 1);
        int srcRow = src.getRow(), srcCol = src.getColumn(), destRow = dest.getRow(), destCol = dest.getColumn();
        int rowDistance = destRow - srcRow, colDistance = destCol - srcCol;
        if (isJumpMove(src, dest)) {
            //判断dest周围有没有棋子
            /*src = dest;
            if (getChessPieceexist(src, s1) == null && getChessPieceexist(src, s2) == null && getChessPieceexist(src, s3) == null && getChessPieceexist(src, s4) == null && getChessPieceexist(src, s5) == null && getChessPieceexist(src, s6) == null && getChessPieceexist(src, s7) == null && getChessPieceexist(src, s8) == null) {
                return false;
            } else
                return false;*/
            if (s1 == mid && (getChessPieceAt(s2) != null || getChessPieceAt(s3) != null || getChessPieceAt(s4) != null || getChessPieceAt(s5) != null || getChessPieceAt(s6) != null || getChessPieceAt(s7) != null || getChessPieceAt(s8) != null)) {
                return true;
            } else if (s2 == mid && (getChessPieceAt(s1) != null || getChessPieceAt(s3) != null || getChessPieceAt(s4) != null || getChessPieceAt(s5) != null || getChessPieceAt(s6) != null || getChessPieceAt(s7) != null || getChessPieceAt(s8) != null)) {
                return true;
            } else if (s3 == mid && (getChessPieceAt(s1) != null || getChessPieceAt(s2) != null || getChessPieceAt(s4) != null || getChessPieceAt(s5) != null || getChessPieceAt(s6) != null || getChessPieceAt(s7) != null || getChessPieceAt(s8) != null)) {
                return true;
            } else if ((s4 == mid && getChessPieceAt(s1) != null || getChessPieceAt(s3) != null || getChessPieceAt(s2) != null || getChessPieceAt(s5) != null || getChessPieceAt(s6) != null || getChessPieceAt(s7) != null || getChessPieceAt(s8) != null)) {
                return true;
            } else if ((s5 == mid && getChessPieceAt(s2) != null || getChessPieceAt(s3) != null || getChessPieceAt(s4) != null || getChessPieceAt(s1) != null || getChessPieceAt(s6) != null || getChessPieceAt(s7) != null || getChessPieceAt(s8) != null)) {
                return true;
            } else if ((s6 == mid && getChessPieceAt(s2) != null || getChessPieceAt(s3) != null || getChessPieceAt(s4) != null || getChessPieceAt(s5) != null || getChessPieceAt(s1) != null || getChessPieceAt(s7) != null || getChessPieceAt(s8) != null)) {
                return true;
            } else if ((s7 == mid && getChessPieceAt(s2) != null || getChessPieceAt(s3) != null || getChessPieceAt(s4) != null || getChessPieceAt(s5) != null || getChessPieceAt(s6) != null || getChessPieceAt(s1) != null || getChessPieceAt(s8) != null)) {
                return true;
            } else if ((s8 == mid && getChessPieceAt(s2) != null || getChessPieceAt(s3) != null || getChessPieceAt(s4) != null || getChessPieceAt(s5) != null || getChessPieceAt(s6) != null || getChessPieceAt(s7) != null || getChessPieceAt(s1) != null)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void loadGame(int[][] gamePieces) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                switch (gamePieces[i][j]) {
                    case 1:
                }
            }
        }
    }

    @Override
    public void registerListener(GameListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void unregisterListener(GameListener listener) {
        listenerList.remove(listener);
    }
}
