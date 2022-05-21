package it.polimi.ingsw.view.gui.boardcomponent;

import it.polimi.ingsw.model.pawns.PawnColor;
import it.polimi.ingsw.model.place.ShortIsland;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.util.Objects;
import java.util.Random;

public class IslandGui extends Pane {
    private final ImageView island;

    public IslandGui(ShortIsland shortIsland, boolean motherNatureOn) {
        Random random = new Random();

        //Island picture
        island = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/islands/island1.png"))));
        island.setFitWidth(150);
        island.setFitHeight(150);
        getChildren().add(island);

        //TOWER
        if (shortIsland.getTower() != null) {
            ImageView tower = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/tower/" + shortIsland.getTower().toString().toLowerCase() + "_tower.png"))));
            tower.setPreserveRatio(true);
            tower.setFitHeight(30);
            tower.setLayoutX(island.getLayoutX() + 40);
            tower.setLayoutY(island.getLayoutY() + 40);
            Label towerNum = new Label(String.valueOf(shortIsland.getDimension()));
            towerNum.setFont(new Font(15));
            towerNum.setLayoutX(island.getLayoutX() + 42);
            towerNum.setLayoutY(island.getLayoutY() + 65);
            getChildren().addAll(tower, towerNum);
        }
        //MOTHER NATURE
        if (motherNatureOn) {
            ImageView motherNature = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pawns/mother_nature.png"))));
            motherNature.setPreserveRatio(true);
            motherNature.setFitHeight(50);
            motherNature.setLayoutX(island.getLayoutX() + 80);
            motherNature.setLayoutY(island.getLayoutY() + 35);
            getChildren().add(motherNature);
        }

        //BAN TILES
        if (shortIsland.getBanTiles() > 0) {
            ImageView banTile = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/various/ban.png"))));
            banTile.setPreserveRatio(true);
            banTile.setFitHeight(30);
            banTile.setLayoutX(island.getLayoutX() + 57);
            banTile.setLayoutY(island.getLayoutY() + 75);
            Label banNum = new Label(String.valueOf(shortIsland.getBanTiles()));
            banNum.setFont(new Font(15));
            banNum.setLayoutX(island.getLayoutX() + 67);
            banNum.setLayoutY(island.getLayoutY() + 100);
            getChildren().addAll(banTile, banNum);
        }

        //STUDENTS
        drawStudents(PawnColor.GREEN, shortIsland.getStudents().getFromColor(PawnColor.GREEN), 0);
        drawStudents(PawnColor.RED, shortIsland.getStudents().getFromColor(PawnColor.RED), 30);
        drawStudents(PawnColor.YELLOW, shortIsland.getStudents().getFromColor(PawnColor.YELLOW), 60);
        drawStudents(PawnColor.PINK, shortIsland.getStudents().getFromColor(PawnColor.PINK), 90);
        drawStudents(PawnColor.BLUE, shortIsland.getStudents().getFromColor(PawnColor.BLUE), 120);

    }

    private void drawStudents(PawnColor color, int numOfStudents, int offsetX) {
        ImageView imageColor = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/pawns/students/" + color.name().toLowerCase() + "_student.png"))));
        imageColor.setPreserveRatio(true);
        imageColor.setFitHeight(20);
        imageColor.setLayoutX(island.getLayoutX() + offsetX);
        imageColor.setLayoutY(island.getLayoutY() + 130);
        Label numOf = new Label(String.valueOf(numOfStudents));
        numOf.setFont(new Font(12));
        numOf.setLayoutX(island.getLayoutX() + offsetX + 6);
        numOf.setLayoutY(island.getLayoutY() + 148);

        getChildren().addAll(imageColor, numOf);
    }
}