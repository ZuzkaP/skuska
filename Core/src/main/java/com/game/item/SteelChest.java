/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.item;

import com.game.abstr.AbstractItem;

/**
 *
 * @author Zuzka
 */
public class SteelChest extends AbstractItem
{
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public SteelChest()
    {
        super("kovova truhlica", "Je to stara truhlica s visiacim zamkom.");
    }
}

