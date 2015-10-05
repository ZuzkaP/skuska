/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.item;

import com.game.abstr.AbstractItem;
import com.game.meta.Game;
import com.game.meta.GameState;
import com.game.meta.Useable;

/**
 *
 * @author Bingo Player
 */
public class Generator  extends AbstractItem
    implements Useable
{
    private boolean on;
    
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Generator()
    {
        super("generator", "Elektricky generator.");
        on = false;
    }
    
    /**
     * Táto metóda vráti boolovskú hodnotu reprezentujúcu stav generátora.
     * @return true | false.
     */
    public boolean getActive()
    {
        return on;
    }
    
    @Override
    public GameState use(Game game)
    {
        // zapni generator
        on = !on;
        
        String z = new String();
        if( on )
            z = "zapnuty";
        else
            z = "vypnuty";
        
        game.getUI().print("Generator je :" + z + ".\n\n" );
        
        // vrat stav
        return GameState.PLAYING;
    }
}
