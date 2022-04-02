package it.polimi.ingsw.model;

import it.polimi.ingsw.model.player.Assistant;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.player.TowerColor;
import it.polimi.ingsw.model.player.Wizard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;
    private Player p1;
    private Player p2;

    @BeforeEach
    void setUp() {
        game = Game.getInstance();

        p1 = new Player("Luca", Wizard.WIZ1, TowerColor.BLACK);
        p2 = new Player("Marco", Wizard.WIZ2,TowerColor.GRAY);

        game.addPlayer(p1);
        game.addPlayer(p2);
    }

    @AfterEach
    void tearDown() {
        Game.resetInstance();
    }

    @Test
    void getPlayerByName_ifPresent() {
        assertEquals("Luca",game.getPlayerByName("Luca").getPlayerName());
    }

    @Test
    void getPlayerByName_ifNotPresent() {
        assertNull(game.getPlayerByName("Tony"));
    }

    @Test
    void getPlayerByTowerColor_ifPresent() {
        assertEquals("Luca",game.getPlayerByTowerColor(TowerColor.BLACK).getPlayerName());
    }

    @Test
    void getPlayerByTowerColor_ifNotPresent() {
        assertNull(game.getPlayerByTowerColor(TowerColor.WHITE));
    }

    @Test
    void addPlayerWithSameWizardTest() {
        Player player = new Player("Matteo",Wizard.WIZ1,TowerColor.GRAY);
        assertFalse(game.addPlayer(player));
        assertFalse(game.getPlayers().contains(player));
    }

    @Test
    void addPlayerAlreadyPresentTest(){
        Player p = new Player("Matteo",Wizard.WIZ3,TowerColor.WHITE);
        assertTrue(game.addPlayer(p));
        assertFalse(game.addPlayer(p));
        assertTrue(game.getPlayers().contains(p));
    }

    @Test
    void depositTest() {
        assertEquals(18,game.getGeneralBank());
    }

    @Test
    void nextPlayerFirst(){
        game.setCurrentPlayer(game.getPlayers().get(1));
        assertEquals("Luca", game.nextPlayer().getPlayerName());
    }

    @Test
    void nextPlayerLast(){
        game.setCurrentPlayer(game.getPlayers().get(0));
        assertEquals("Marco", game.nextPlayer().getPlayerName());
    }

    /**
     * Testing
     */
    @Test
    void moveMotherNature(){
        game.getPlayers().get(0).playAssistant(Assistant.ELEPHANT);
        assertTrue(game.moveMotherNature(1, game.getPlayers().get(0)));
        assertFalse(game.moveMotherNature(0, game.getPlayers().get(0)));
        assertFalse(game.moveMotherNature(2, game.getPlayers().get(0)));
    }

    /**
     * This method tests addCoin.
     */
    @Test
    void addCoinTest() {
        boolean state;
        state = game.addCoin(p1,4);
        assertTrue(state);
        assertEquals(5,p1.getPlayerBank());
        assertEquals(14,game.getGeneralBank());
        state = game.addCoin(p1,16);
        assertFalse(state);
        assertEquals(5,p1.getPlayerBank());
        assertEquals(14,game.getGeneralBank());
        state = game.addCoin(p1,14);
        assertTrue(state);
        assertEquals(19,p1.getPlayerBank());
        assertEquals(0,game.getGeneralBank());
    }

    /**
     * This method tests removeCoin.
     */
    @Test
    void removeCoinTest() {
        boolean state;
        state = game.removeCoin(p1,2);
        assertFalse(state);
        assertEquals(p1.getPlayerBank(),1);
        game.addCoin(p1,9);
        state = game.removeCoin(p1,5);
        assertTrue(state);
        assertEquals(game.getGeneralBank(),14);
    }
}