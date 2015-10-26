/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * @author 
 */
package com.game.impl;

import com.game.meta.*;

/**
 * Táto trieda je konkrétnou implementáciou rozhrania Game, pričom táto trieda
 * je definovaná stavom hry. Obsahuje niekoľko členských premenných. Obsahuje
 * referencie na užívateľské rozhranie, parser, menu, aktuálnej miestnosti, batohu 
 * a vykresľovača.
 * @author Zuzka
 */
public class GameImpl implements Game
{
    // data
    private GameState state;
    private Room currentRoom;
    private Player player;
    private UserInterface ui;
    private Parser parser;

    
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy.
     */
    public GameImpl()
    {
        currentRoom = null;
        state = GameState.QUIT;
        parser = new ParserImpl();
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void setUI(UserInterface userInterface) {
        this.ui = userInterface;
    }

    @Override
    public UserInterface getUI() {
        return ui;
    }

    @Override
    public Parser getParser() {
        return parser;
    }

    /**
     *
     * Metóda vráti aktuálny stav hry.
     * @return stav hry.
     */
    @Override
    public GameState getGameState()
    {
        return state;
    }
    
    /**
     * Táto metóda slúži na nastavenie aktuálneho stavu hry. Na výber je možmé
     * nastaviť niekoľko stavov : PLAYING, GAMEOVER, SOLVED, QUIT.
     * @param stav Nový stav hry
     */
    @Override
    public void setGameState( GameState stav )
    {
        this.state = stav;
    }
    
    /**
     * Vráti referenciu na aktuálnu miestnosť, v ktorej sa hráč práve nachádza.
     * @return aktuálnu miestnosť.
     */
    @Override
    public Room getCurrentRoom() 
    {
        return currentRoom;
    }

    /**
     * Táto metóda slúži na nastavenie novej aktuálnej miestnosti, pričom sa 
     * testuje vstupný parameter, ktorý ak je referenciou na null, program
     * vypíše výnimku.
     * @param room Nová miestnosť
     * @throws NullPointerException
     */
    @Override
    public void setCurrentRoom(Room room) throws NullPointerException
    {
        // zobraz aktualne miestnosti
        if( room != null )
        {
            room.setMapOfRooms(currentRoom.getMapOfRooms());
            currentRoom = room;
        }
        else 
            throw new NullPointerException();
    }

    /**
     * Táto metóda vráti referenciu na batoh.
     * @return batoh.
     */
    @Override
    public Player getPlayer()
    {
        return player;
    }
}
