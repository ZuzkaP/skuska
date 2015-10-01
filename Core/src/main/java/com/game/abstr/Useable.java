/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.abstr;

/**
 * Toto rozhranie slúži pri implementácii predmetov, ktoré majú vlastnosť, že
 * sú použíteľné, pričom sa využíva práve metóda use.
 * @author Bingo Player
 */
public interface Useable 
{
    /**
     * Táto metóda slúži na vykonanie funkcie daného predmetu, ktorý ak je
     * inštanciou tejto triedy, môže využívať svoju funkciu.
     * @param game Aktuálna hra
     * @return stav hry.
     */
    GameState use(Game game);
}
