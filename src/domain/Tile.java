/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Luiz
 */
public class Tile {

    public Tile() {
        occupied = false;
    }

    boolean occupied;
    Pieces piece;

    private void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Pieces getPiece() {
        return piece;
    }

    public void setPiece(Pieces piece) {
        if (piece != null) {
            this.piece = piece;
            setOccupied(true);
        }
    }

    public boolean isOccupied() {
        return occupied;
    }

}
