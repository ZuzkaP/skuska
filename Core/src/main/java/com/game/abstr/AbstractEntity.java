/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.abstr;

import com.game.meta.Entity;

/**
 * Táto abstraktná trieda reprezentuje Entity.
 * Využíva metódy na nastavenie a vrátenie názvu a opisu predmetu.
 *
 * @author Zuzka
 */
public abstract class AbstractEntity implements Entity {

    protected String name;
    protected String description;

    /**
     * @param name        Názov objektu
     * @param description Opis objektu
     */
    public AbstractEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Nastaví sa nová hodnota Stringu, ktorý popisuje názov objektu, v tomto prípade daného Item-u.
     *
     * @param name Meno objektu
     */
    public void setName(String name) throws NullPointerException {
        if (name != null)
            this.name = name;
        else
            throw new NullPointerException();
    }

    /**
     * Nastaví sa nová hodnota Stringu, ktorý popisuje opis objektu, v tomto prípade daného Item-u.
     *
     * @param description Opis objektu
     */
    public void setDescription(String description) throws NullPointerException {
        if (description != null)
            this.description = description;
        else
            throw new NullPointerException();
    }

    /**
     * Metóda vracia názov daneho objektu, v tomto prípade daného Item-u.
     *
     * @return názov predmetu.
     */
    public String getName() {
        return name;
    }

    /**
     * Metóda vracia opis daného objektu, v tomto prípade daného Item-u.
     *
     * @return opis predmetu.
     */
    public String getDescription() {
        return description;
    }


    public String toString() {
        return (this.name + " - " + this.description);
    }
}
