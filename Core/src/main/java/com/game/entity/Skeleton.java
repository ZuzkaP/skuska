/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.entity;

import com.game.abstr.AbstractEntity;

/**
 *
 * @author Bingo Player
 */
public class Skeleton extends AbstractEntity
{
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Skeleton()
    {
        super("kostlivec", "Velky kostlivec s velkym lukom.");
    }
}