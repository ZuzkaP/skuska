/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.items;
import com.game.abstr.*;
/**
 *
 * @author Bingo Player
 */
public class Key extends AbstractItem
    implements Moveable, Useable
{  
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Key()
    {
        super("kluc", "Stary zhrdzaveny kluc.");
    }

    @Override
    public GameState use(Game game) 
    {
        // kluc som pouzil
        // je v miestnosti truhlica ?
        if( game.getCurrentRoom().getItem("truhlica") == null )
        {
           game.getUI().print( "Kluc nie je mozne pouzit.\n\n" );
        }
        else
        {
            // odstran kluc
            if( game.getCurrentRoom().getItem(getName()) != null )
                game.getCurrentRoom().removeItem(this);
            else
                game.getBackpack().remove( getName() );
            
            // truhlica
            game.getCurrentRoom().getItem("truhlica").setName("otvorena truhlica");
            
            // vypis hlasku
            game.getUI().print( "Pouzil si " + getName() + " na otvorenie truhlice.\n\n" );
            
            // vytvor novu polozku v miestnosti
            game.getCurrentRoom().addItem( new Detector());
            game.getCurrentRoom().addItem( new Wrench() );
            game.getCurrentRoom().addItem( new Shotgun() );
            game.getCurrentRoom().addItem( new Shells() );
        }
        
        // vrat stav
        return GameState.PLAYING;
    }
}
