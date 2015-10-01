/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.items;

import com.game.abstr.AbstractItem;

/**
 *
 * @author Bingo Player
 */
public class Zombie extends AbstractItem
{

    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Zombie()
    {
        super("zombie", "Krvilacny pojedac zvyskou ludi.");
    }
}
