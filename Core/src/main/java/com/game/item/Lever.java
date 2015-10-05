/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.item;
import com.game.abstr.AbstractItem;
import com.game.meta.*;
import com.game.impl.RoomImpl;

/**
 *
 * @author Bingo Player
 */
public class Lever extends AbstractItem
    implements Useable
{
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Lever()
    {
        super("paka", "Drevena paka.");
    }

    @Override
    public GameState use(Game game) 
    {
        game.getCurrentRoom().removeItem(this);
        if( game.getCurrentRoom().getEast() != null )
        {
            game.getUI().print("Pouzil si paku na otvorenie tajnych dveri.[1/2]");
            game.getCurrentRoom().getEast().getEast().addItem(new Lever());
        }
        else
        {
            RoomImpl room = (RoomImpl)game.getCurrentRoom().getWest().getSouth();
            room.setName(null);
            game.getUI().print("Pouzil si paku na otvorenie tajnych dveri. [2/2]\n\n");
        }
        
        // vrat stav
        return GameState.PLAYING;
    }
}
