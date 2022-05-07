package it.polimi.ingsw.view.cli;

import it.polimi.ingsw.model.pawns.PawnColor;
import it.polimi.ingsw.model.place.ShortIsland;

import java.util.ArrayList;
import java.util.List;


public class IslandCli {
    private final List<String> lines = new ArrayList<>();

    public IslandCli(ShortIsland island, int number, int mn){
        boolean motherNature = number == mn;
        lines.add(headerBuilder(number, motherNature));
        lines.add(stringRow(island.getStudents().getFromColor(PawnColor.GREEN), CLISymbol.GREEN_START, CLISymbol.GREEN_END));
        lines.add(stringRow(island.getStudents().getFromColor(PawnColor.RED), CLISymbol.RED_START, CLISymbol.RED_END));
        lines.add(stringRow(island.getStudents().getFromColor(PawnColor.YELLOW), CLISymbol.YELLOW_START, CLISymbol.YELLOW_END));
        lines.add(stringRow(island.getStudents().getFromColor(PawnColor.PINK), CLISymbol.PINK_START, CLISymbol.PINK_END));
        lines.add(stringRow(island.getStudents().getFromColor(PawnColor.BLUE), CLISymbol.BLUE_START, CLISymbol.BLUE_END));
        lines.add(bottomBuilder(island));
    }

    private String stringRow(int numColor, String start, String end){

        StringBuilder string = new StringBuilder();
        if(numColor >= 10){
            string.append(start).append(empties(CLISymbol.REPETITION - 1));
        } else {
            string.append(start).append(empties(CLISymbol.REPETITION));
        }
        if(numColor == 0){
            string.append("     ");
        } else {
            string.append(numColor).append(" x ").append("@");
        }
        string.append(empties(CLISymbol.REPETITION));
        string.append(end);
        return string.toString();
    }


    private String headerBuilder(int number, boolean motherNature){
        StringBuilder string = new StringBuilder();
        if(motherNature){
            if(number>=10){
                string.append(CLISymbol.HEAD_START).append(number).append(" ").append(CLISymbol.HEAD_MN).append(CLISymbol.HEAD_END);
            } else {
                string.append(CLISymbol.HEAD_START).append(number).append("  ").append(CLISymbol.HEAD_MN).append(CLISymbol.HEAD_END);
            }
        } else {
            if(number>=10){
                string.append(CLISymbol.HEAD_START).append(number).append(" ").append(CLISymbol.HEAD).append(CLISymbol.HEAD_END);

            } else {
                string.append(CLISymbol.HEAD_START).append(number).append("  ").append(CLISymbol.HEAD).append(CLISymbol.HEAD_END);
            }
        }
        return string.toString();
    }

    private String bottomBuilder(ShortIsland island){
        StringBuilder bottom = new StringBuilder();
        if(island.getTower() != null){
            String color = colorTower(island);
            bottom.append(CLISymbol.BOTTOM_START).append(color).append(CLISymbol.BOTTOM_END);
        } else {
            bottom.append(CLISymbol.BOTTOM_START).append(CLISymbol.BOTTOM).append(CLISymbol.BOTTOM_END);
        }
        return bottom.toString();
    }

    private String empties(int rep){
        int i;
        StringBuilder string = new StringBuilder();
        for (i = 0; i < rep; i++){
            string.append(" ");
        }
        return string.toString();
    }


    private String colorTower(ShortIsland island){
        StringBuilder string = new StringBuilder();
        if(island.getTower()!=null && island.getTower().name().equals("WHITE")){
            string.append("_#").append("WHITE(").append(island.getDimension()).append(")");
        } else if(island.getTower()!=null && island.getTower().name().equals("BLACK")){
            string.append("_#").append("BLACK(").append(island.getDimension()).append(")");
        } else {
            string.append("_#").append("GRAY(").append(island.getDimension()).append(")").append("_");
        }
        return string.toString();
    }

    public List<String> getLines() {return lines;}






}