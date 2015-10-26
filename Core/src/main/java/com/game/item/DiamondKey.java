/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.item;

import com.game.abstr.AbstractItem;
import com.game.meta.*;

/**
 *
 * @author Zuzka
 */
public class DiamondKey extends AbstractItem
    implements Moveable, Useable
{ 
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public DiamondKey()
    {
        super("diamantovy kluc", "Stary zhrdzaveny kluc.");
    }

    @Override
    public GameState use(Game game) 
    {
        // kluc som pouzil
        // je v miestnosti truhlica ?
        if( game.getCurrentRoom().getItem("diamantova truhlica") != null  )
        {
            game.getCurrentRoom().getItem("diamantova truhlica").setName("otvorena diamantova truhlica");
            game.getCurrentRoom().addItem( new NanoSword() );
            game.getCurrentRoom().addItem( new Axe());
            
            // odstran kluc
            if( game.getCurrentRoom().getItem(getName()) != null )
                game.getCurrentRoom().removeItem(this);
            else
                game.getPlayer().getBackpack().remove( getName() );
            
            game.getUI().print("Pouzil si kluc na otvorenie diamantovej truhlice.\n\n");
        }
        else
                game.getUI().print( "Tento kluc sa tu pouzit neda.\n\n" );
        
        // vrat stav
        return GameState.PLAYING;
    }
}
