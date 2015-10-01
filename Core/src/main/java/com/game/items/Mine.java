/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.items;

import com.game.abstr.AbstractItem;
import com.game.abstr.Game;
import com.game.abstr.GameState;
import com.game.abstr.Useable;

/**
 *
 * @author Bingo Player
 */
public class Mine extends AbstractItem
    implements Useable
{
    private boolean loaded;
    
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Mine()
    {
        super("mina", "Nebezpecna claymore mina.");
        loaded = true;
    }
    
    /**
     * Táto metóda vráti boolovskú hodnotu, či je mína aktívna.
     * @return true | false.
     */
    public boolean isLoaded()
    {
        return loaded;
    }

    @Override
    public GameState use(Game game)
    {
        this.loaded = false;
        
        return GameState.PLAYING;
    }
    
}
