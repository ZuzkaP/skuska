/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.entity;
import com.game.abstr.AbstractEntity;
import com.game.meta.*;


/**
 *
 * @author Zuzka
 */
public class Princess extends AbstractEntity
    implements Moveable, Useable
{ 
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Princess()
    {
        super("princezna", "Krasna princezna nevsednych rozmerov..");
    }

    @Override
    public GameState use(Game game)
    {  
        // koniec hry
        game.setGameState(GameState.SOLVED);
        
        // vrat vyrieseni stav
        return GameState.SOLVED;
    }
}
