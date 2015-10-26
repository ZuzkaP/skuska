/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.entity;


import com.game.abstr.AbstractEntity;

/**
 *
 * @author Zuzka
 */
public class FinalBoss extends AbstractEntity
{ 
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public FinalBoss()
    {
        super("finalboss", "Najtazsi super, ktory ta mohol stretnut...");
    }
}
