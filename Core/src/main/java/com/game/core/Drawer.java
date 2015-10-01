package com.game.core;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.game.abstr.Game;

/**
 * Táto abstraktná trieda je základom pre vykresľovač.
 *
 * @author Bingo Player
 */
public abstract class Drawer {

    /**
     * Táto metóda slúži na aktuálne zobrazenie stavu hry. Hra sa nachádza v
     * niekoľkých stavoch : Menu, Hra.
     *
     * @param hra Aktuálna hra
     */
    public abstract void render(Game hra);
}
