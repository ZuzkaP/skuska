/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.abstr;

/**
 *typ miestnsti majuci susedne iba dve miestnosti-hore a dole
 * @author Matt
 */
public interface Tunnel {

    /**
     *izba nahor
     * @param room sucasna izba
     * @return izba nahor
     */
    public Room GetUp(Room room);

    /**
     *izba nadol
     * @param room sucasna izba
     * @return izba nahor
     */
    public Room GetDown(Room room);

}
