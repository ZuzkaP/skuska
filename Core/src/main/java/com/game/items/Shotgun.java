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
public class Shotgun extends AbstractItem
    implements Moveable, Useable
{
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Shotgun()
    {
        super("brokovnica", "Rychlopalna brokovnica.");
    }
  
    @Override
    public GameState use(Game game)
    {
        if( game.getBackpack().getItem( "naboje" ) != null )
        {
            if( game.getCurrentRoom().getItem( "zombie" ) != null )
            {
                game.getCurrentRoom().removeItem( game.getCurrentRoom().getItem( "zombie" ) );
            }
            else if( game.getCurrentRoom().getItem( "kostlivec" ) != null )
            {
                game.getCurrentRoom().removeItem( game.getCurrentRoom().getItem( "kostlivec" ) );
            }
            else if( game.getCurrentRoom().getItem( "prasa" ) != null )
            {
                game.getCurrentRoom().removeItem( game.getCurrentRoom().getItem( "prasa" ) );
            } 
            else if( game.getCurrentRoom().getItem( "boss" ) != null )
            {
                game.getCurrentRoom().removeItem( game.getCurrentRoom().getItem( "boss" ) );
            }
            else if( game.getCurrentRoom().getItem( "finalboss " ) != null )
                game.getUI().print("Na tento typ prisery je " + getName() + " nepouzitelny.\n\n");
            
            Shells item = (Shells)game.getBackpack().getItem("naboje");
            item.shoot( game );
            game.getUI().print("Vystrelil si z brokovnice. Zostava : " + String.valueOf(item.getRounds()) + " nabojov.\n\n");
        }
        else
            game.getUI().print("Nie su naboje.");
        
        return GameState.PLAYING;
    }
}
