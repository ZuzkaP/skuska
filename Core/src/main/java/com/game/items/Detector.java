/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.items;

import com.game.abstr.*;

/**
 *
 * @author Bingo Player
 */
public class Detector extends AbstractItem
    implements Moveable, Useable
{
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Detector()
    {
        super("detektor", "Detektor min.");
    }
    
    @Override
    public GameState use(Game game)
    {
        if( game.getCurrentRoom().getItem("mina") != null )
        {
            Mine item = (Mine)game.getCurrentRoom().getItem("mina");
            item.use(game);
            game.getUI().print("Predmet bol pouzity spravne.\n\n");
        }
        return GameState.PLAYING;
    }
}
