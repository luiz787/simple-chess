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
public class Board {

    public Board(Tile[][] tiles) {
        this.tiles = tiles;
        for (int i=0; i<this.tiles[0].length; i++){
            for (int j=0; j<this.tiles.length; j++){
                this.tiles[i][j] = new Tile();
                switch (i){
                    case 0://first
                    case 7://or last row
                        switch (j){
                            case 0://first
                            case 7://or last tile
                                this.tiles[i][j].setPiece(Pieces.ROOK);
                                break;
                            case 1://second
                            case 6://or seventh tile
                                this.tiles[i][j].setPiece(Pieces.KNIGHT);
                                break;
                            case 2://third
                            case 5://or sixth tile
                                this.tiles[i][j].setPiece(Pieces.BISHOP);
                                break;
                            case 3:
                                this.tiles[i][j].setPiece(Pieces.QUEEN);
                                break;
                            case 4:
                                this.tiles[i][j].setPiece(Pieces.KING);
                                break;
                        }
                        break;
                    case 1://second
                    case 6://or seventh row (pawns)
                        this.tiles[i][j].setPiece(Pieces.PAWN);
                        break;
                    default:
                        break;
                }                
            }
        }
    }
    
    Tile[][] tiles;

    public Tile[][] getTiles() {
        return tiles;
    }
}
