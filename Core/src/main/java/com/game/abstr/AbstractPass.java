/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.abstr;

/**
 *
 * @author Matt
 */
public abstract class AbstractPass extends AbstractItem {

    public AbstractPass(String name, String description) {
        super(name, description);
    }

    /**
     *
     * @param key
     */
    public abstract void insertKey(Item key);

    /**
     *
     * @param key
     * @return vybraty objekt z Pass
     */
    public abstract Item takeKey(String key);
    
}
