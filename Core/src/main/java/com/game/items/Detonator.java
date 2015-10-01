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
public class Detonator extends AbstractItem
    implements Moveable, Useable
{
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Detonator()
    {
        super("odpalovac", "Odpalovac dynamitu.");
    }

    @Override
    public GameState use(Game game) 
    {
        // kluc som pouzil
        // je v miestnosti truhlica ?
        if( game.getCurrentRoom().getItem( "tnt" ) != null )
        {
            TNT tnt = (TNT)game.getCurrentRoom().getItem( "tnt" );
            
            // odpal dynamit
            tnt.detonate( game );
            
            game.getUI().print("Predmet bol pouzity na odpalenie dynamitu.\n\n");
        }
        else
            game.getUI().print( "Neda sa pouzit, nenaslo sa TNT." );
        
        // vrat stav
        return GameState.PLAYING;
    }
}
