/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.core;

import com.game.abstr.Room;
import com.game.abstr.Tunnel;

/**
 *
 * @author Matt
 */
public class TunnelImpl extends RoomImpl implements Tunnel {

    /**
     *
     * @param Lvl
     * @param desc
     */
    public TunnelImpl(int Lvl, String desc) {
        super(String.valueOf(Lvl), desc);
    }

    /**
     *
     * @param room
     * @return
     */
    @Override
    public Room GetUp(Room room) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param room
     * @return
     */
    @Override
    public Room GetDown(Room room) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
