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
public class Wrench extends AbstractItem
    implements Moveable, Useable
{ 
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Wrench()
    {
        super("wrench", "Odstranovac min.");
    }

    @Override
    public GameState use(Game game)
    {
        if( game.getCurrentRoom().getItem( "mina" ) != null )
        {
            Mine mina = (Mine)game.getCurrentRoom().getItem( "mina" );
            if( !mina.isLoaded() )
            {
                game.getUI().print("Uspesne si odstranil minu.\n\n");
                game.getCurrentRoom().removeItem( game.getCurrentRoom().getItem( "mina" ) );
            }
            else
            {
                game.getUI().print("Mina nebola odistena pomocou detektoru.\n\n");
                game.setGameState(GameState.GAMEOVER);
            }
        }
            
        return GameState.PLAYING;
    }
}
