/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import domain.Board;
import domain.Tile;
import chess.main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Luiz
 */
public class BoardController implements Initializable {

    @FXML
    GridPane boardGrid;
    Button[][] buttons = new Button[8][8];
    main main;

    public void setMain(main main) {
        this.main = main;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Testt");
        Board board = new Board(new Tile[8][8]);
        addButtons(board);
        System.out.println("I've got some button");
    }

    private void addButtons(Board board) {
        Tile[][] tiles = board.getTiles();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                System.out.println("i: " + i + ", j: " + j);
                buttons[i][j] = new Button();
                buttons[i][j].setId("btn"); //css
                if (tiles[i][j].isOccupied()) {
                    switch (i) {
                        case 0://first
                        case 7://or last row
                            switch (j) {
                                case 0://first
                                case 7://or last tile
                                    buttons[i][j].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/img/chess-rok.png"))));
                                    break;
                                case 1://second
                                case 6://or seventh tile
                                    buttons[i][j].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/img/chess-knight.png"))));
                                    break;
                                case 2://third
                                case 5://or sixth tile
                                    buttons[i][j].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/img/bishop.png"))));
                                    break;
                                case 3:
                                    buttons[i][j].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/img/chess-queen.png"))));
                                    break;
                                case 4:
                                    buttons[i][j].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/img/chess-king.png"))));
                                    break;
                            }
                            break;
                        case 1://second
                        case 6://or seventh row (pawns)
                            buttons[i][j].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/img/chess-pawn.png"))));
                            break;
                        default:
                            break;
                    }
                    buttons[i][j].setOnAction((ActionEvent event) -> {
                        System.out.println("Não me toque"); //TODO: logic
                    });
                } else {
                    buttons[i][j] = new Button("Empty");//do nothing
                    buttons[i][j].setId("btn"); //css
                }
                boardGrid.add(buttons[i][j], j, i);
            }
        }
    }
}
