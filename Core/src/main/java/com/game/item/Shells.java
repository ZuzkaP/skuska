/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.item;
import com.game.abstr.AbstractItem;
import com.game.meta.Game;
import com.game.meta.Moveable;
/**
 *
 * @author Zuzka
 */
public class Shells extends AbstractItem
    implements Moveable
{
    private int rounds;
    
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Shells()
    {
        super("naboje", "Broky do brokovnice.");
        rounds = 10;
    }

    /**
     * Táto metóda pripočíta k členskej premennej rounds počet nových nábojov.
     * @param n Počet nových nábojov
     */
    public void stuck(int n)
    {
        this.rounds += n;
    }
    
    /**
     * Táto metóda vráti aktuálny počet nábojov.
     * @return počet nábojov.
     */
    public int getRounds()
    {
        return this.rounds;        
    }

    /**
     *
     * @param game
     */
    public void shoot(Game game) 
    {
        // odober naboje
        this.rounds--;
        
        if( this.rounds <= 0 )
        {
            game.getPlayer().getBackpack().remove( getName() );
            this.rounds = 0;
        }
    }
    
}
