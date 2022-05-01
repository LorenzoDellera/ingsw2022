package it.polimi.ingsw.constants;

import java.util.List;

/**
 * This class contains constants that are common to all games
 */
public class Constants {

    /**
     * This class cannot be instantiated
     */
    private Constants(){}

    public static final String CHARACTER_JSON_PATH = "src/main/resources/json/Character.json";
    public static final String GAME_LIMIT_MAP_PATH = "src/main/resources/json/GameLimit.json";
    public static final List<Integer> NUM_PLAYER_AVAILABLE = List.of(2,3,4);
    public static final List<String> GAME_MODE_AVAILABLE = List.of("Simple","Expert");
    public static final int CHARACTER_IN_USE = 3;
    public static final int STUDENTS_OF_EACH_COLOR = 24;
    public static final int INIT_SACK_STUDENTS_PER_COLOR = 2;
    public static final int INITIAL_CASH_PER_PLAYER = 1;
    public static final int MAX_HALL_PER_COLOR = 10;
    public static final int MAX_PROFESSOR_PER_COLOR = 1;
    public static final int MAX_ISLAND = 12;
    public static final int MAX_NUM_OF_COINS = 20;
    public static final List<String> COLORS = List.of("GREEN", "RED", "YELLOW", "PINK", "BLUE");
    public static final int MAX_ENTRANCE = 9;
    public static final int ISLAND_WIDTH_1 = 21;
    public static final int ISLAND_HIGH = 7;


}
