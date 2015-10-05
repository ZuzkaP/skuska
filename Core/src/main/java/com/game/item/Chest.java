/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.item;

import com.game.abstr.AbstractItem;

/**
 *
 * @author Bingo Player
 */
public class Chest extends AbstractItem
{
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Chest()
    {
        super("truhlica", "Je to stara truhlica s visiacim zamkom.");
    }
  
}
