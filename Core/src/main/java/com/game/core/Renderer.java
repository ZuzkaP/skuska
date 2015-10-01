/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.core;

import com.game.abstr.Game;
import com.game.abstr.GameState;

/**
 * Táto trieda je implementáciou abstraktnej triedy Drawer, pričom táto trieda
 * slúži na vykresľovanie aktuálneho stavu hry.
 * @author Bingo Player
 */
public class Renderer extends Drawer
{
    
    /**
     * Tento prázdny konštruktor vráti referenciu na Renderer.
     */
    public Renderer()
    {   
    }
    
    /**
     * Táto metóda slúži na vykresľovanie daného obsahu hry, pričom sa testuje,
     * či sa hra nachádza v stave Menu, alebo Hra.
     * @param hra Aktuálna hra
     */
    @Override
    public void render( Game hra )
    {
        // temp
        GameImpl game = (GameImpl)hra;
        
        while( game.getMenu().getVisible() )
        {
            // citaj vstup
            String in = game.getMenu().Sender();
            
            // ak je nula pokracuj
            if( in == null )
                continue;
            
            // rozhodni ktora polozka bola vybrana
            switch (in) 
            {
                case "Nova hra":
                    game.getMenu().setVisible( false );
                    game.setGameState( GameState.PLAYING );
                    break;
                    
                case "Nastavenia":
                    break;
                    
                case "Ukoncit hru":
                    System.exit(0);
                    break;
            }
        }
        
        // hrame ?
        if( game.getGameState() == GameState.PLAYING )
        {
            
        }
        
    }    
}
