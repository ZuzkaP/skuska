/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.items;

import com.game.abstr.AbstractItem;
import com.game.abstr.Moveable;

/**
 *
 * @author Matt
 */
public class Chalice extends AbstractItem implements Moveable {

    /**
     *vytvara objekt kalich
     */
    public Chalice(){
        super("Kalich vodnara", "kalich plny vody ktora sa nevylieva, isto je specialny");
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return (" "+this.name +"-"+this.description); 
    }
}
