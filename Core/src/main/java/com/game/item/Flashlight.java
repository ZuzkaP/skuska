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
 * @author Bingo Player
 */
public class Flashlight  extends AbstractItem
    implements Moveable, Useable
{
    private int rounds;
    private boolean load;
    
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Flashlight()
    {
        super("baterka", "Baterka na obmedzene pouzitie.");
        rounds = 1;
        load = false;
    }
    
    /**
     * Táto metóda slúži na zapnutie baterky.
     */
    public void turnOn()
    {
        this.load = true;
    }
    
    /**
     * Táto metóda slúži na nabitie baterky a inkrementovanie jej použitia o 1.
     */
    public void charge()
    {
        this.rounds += 1;
        turnOn();
    }

    @Override
    public GameState use(Game game) 
    {
        if( load )
        {
            this.rounds--;

            if( game.getCurrentRoom().getDescription() != null )
               if( game.getCurrentRoom().getDescription().contains("baterk") )
                {
                    game.getUI().print("Pouzil si baterku a objavil si nove veci.\n\n");
                    game.getCurrentRoom().addItem( new SteelKey() );
                    game.getCurrentRoom().addItem( new Shells() );
                }
            
            if( rounds <= 0 )
            {
                load = false;
                rounds = 0;
            } 
                
        }
        
        // vrat stav
        return GameState.PLAYING;
    }
}
