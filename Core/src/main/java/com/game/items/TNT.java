/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.items;

import com.game.abstr.AbstractItem;
import com.game.abstr.Game;
import com.game.abstr.Moveable;
/**
 *
 * @author Bingo Player
 */
public class TNT extends AbstractItem
     implements Moveable
{
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public TNT()
    {
        super("tnt", "Velmi ucinny dynamit.");
    }

    /**
     * Táto metóda slúži na kvázi odpálenie dynamitu.
     * @param game Aktuálna hra
     */
    public void detonate(Game game) 
    {
        if( game.getBackpack().getItem( "odpalovac" ) != null || game.getCurrentRoom().getItem( "odpalovac" ) != null )
        {
            if( game.getCurrentRoom().getName() != null )
            {
                if( game.getCurrentRoom().getName().equals( "telm" ) )
                {
                    game.getUI().print("Odpalil si titanovu skrinku, ktora odhalila nove predmety.\n\n");
                    
                    game.getCurrentRoom().addItem( new Sword());
                    game.getCurrentRoom().addItem( new Shells());
                    game.getCurrentRoom().addItem( new Flashlight());
                    game.getCurrentRoom().removeItem(this);
                }
            }
            else
            {
                if( game.getCurrentRoom().getItem( "zombie" ) != null )
                {
                    game.getCurrentRoom().removeItem( game.getCurrentRoom().getItem( "zombie" ) );
                }
                else if( game.getCurrentRoom().getItem( "skeleton" ) != null )
                {
                    game.getCurrentRoom().removeItem( game.getCurrentRoom().getItem( "skeleton" ) );
                }
                else if( game.getCurrentRoom().getItem( "prasa" ) != null )
                {
                    game.getCurrentRoom().removeItem( game.getCurrentRoom().getItem( "prasa" ) );
                } 
                else if( game.getCurrentRoom().getItem( "boss1" ) != null )
                {
                    game.getCurrentRoom().removeItem( game.getCurrentRoom().getItem( "boss1" ) );
                }
                else if( game.getCurrentRoom().getItem( "boss2" ) != null )
                {
                    game.getCurrentRoom().removeItem( game.getCurrentRoom().getItem( "boss2" ) );
                }
                
                game.getCurrentRoom().removeItem(this);
            }
        }
        else
            game.getUI().print( "Nenasiel sa odpalovac." );
            
    }
}
