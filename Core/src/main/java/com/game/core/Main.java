/*
 * Object oriented programming course
 * Department of Computers and Informatics at Technical University of Kosice
 * http://kpi.fei.tuke.sk
 */

package com.game.core;

import com.game.abstr.Game;

import java.io.IOException;

/**
 * Pôvodný scénar sa zmenil, preto je k projektu priložený nový, ktorý zabezpečí 
 * správny chod programu.
 * @author Bingo Player
 */
public class Main
{
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {    
        // vytvor hru
        Game game = new GameImpl();
        
        // inicializuj
        game.init();
        
        // start
        game.start();
        
        System.in.read();
    }
}
