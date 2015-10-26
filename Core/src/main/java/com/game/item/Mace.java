/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.item;
import com.game.abstr.AbstractItem;
import com.game.meta.*;

/**
 *
 * @author Zuzka
 */
public class Mace extends AbstractItem
    implements Moveable, Useable
{  
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Mace()
    {
        super("palcat", "Velky ostnaty palcat.");
    }

    @Override
    public GameState use(Game game) 
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
        else
            game.getUI().print("Na tento typ prisery je " + getName() + " nepouzitelny.\n\n");
        
        return GameState.PLAYING;
    }
}
