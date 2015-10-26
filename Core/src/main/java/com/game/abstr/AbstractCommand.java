/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.abstr;

import com.game.meta.Command;

/**
 * Toto je abstraktná trieda, ktorá reprezentuje Command. 
 * Využíva metódy nastavenia a vrátenia opisu a názvu príkazu.
 * Obsahuje jednu metódu, ktorá slúži na vykonanie konkrétného príkazu.
 * @author Zuzka
 */
public abstract class AbstractCommand implements Command {
    private final String nazov;
    private final String description;
    
    /**
     *
     * @param name Názov objektu
     * @param description Opis objektu
     */
    public AbstractCommand(String name, String description)
    {
        this.nazov = name;
        this.description = description;
    }
    
    /**
     * Metóda vracia názov daneho objektu, v tomto prípade daného Command-u.
     * @return meno objektu.
     */
    public String getName()
    {
        return nazov;
    }
    
    /**
     * Metóda vracia opis daného objektu, v tomto prípade daného Command-u.
     * @return opis objektu.
     */
    public String getDescription()
    {
        return description;
    }

}
