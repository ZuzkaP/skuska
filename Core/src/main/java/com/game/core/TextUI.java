/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.core;

import com.game.abstr.Game;
import com.game.abstr.GameState;
import com.game.abstr.UserInterface;

import java.util.Scanner;


/**
 * Táto trieda je konkrétnou implementáciou rozhrania UserInterface, pričom táto
 * trieda slúži na čitanie vstupného reťazca a vypisovanie výstpuných správ na
 * obrazovku pomocou štandardného výstupu.
 * @author Bingo Player
 */
public class TextUI 
    implements UserInterface
{
    private final String prefix;
    
    /**
     * Prázdny konštruktor vytvorí novú inštanciu tejto triedy, pričom je
     * inicializovaná členská premenná prefix.
     */
    public TextUI()
    {
        prefix = "-> ";
    }
    
    /**
     * Táto metóda slúži na vypisovanie sráv na obrazovku, pričom vstupným 
     * parametrom je reťazec, ktorý predstavuje výstupnú správu.
     * @param string Výstupný reťazec
     */
    @Override
    public void print( String string )
    {
        System.out.print( string );
    }
    
    /**
     * Táto metóda slúži na vypisovanie sráv na obrazovku, pričom vstupným 
     * parametrom je reťazec, ktorý predstavuje výstupnú správu.
     * @param string Výstupný reťazec
     */
    @Override
    public void println( String string )
    {
        System.out.println( string );
    }

    /**
     * Táto metóda zabezpečuje chod hry. Ak sa hra nachádza v stave PLAYING číta
     * sa vstupný reťazec znakov, ktorý je následne poslaný na kontrolu, či je
     * relevantný. Ak sa hra nachádza v stave QUIT, vykresľuje sa menu. Ak sa 
     * hra nachádza v stave GAMEOVER, resp. SOLVED vypíše sa hráčovi hláška
     * o aktuálnom stave hry a inicializuje sa nová hra.
     * @param arg0 Aktuálna hra
     */
    @Override
    public void loop(Game arg0)
    {
        // temp
        GameImpl game = (GameImpl)arg0;
        
        // testuj ci sa hra hraje
        while( arg0.getGameState() == GameState.PLAYING )
        {
            Scanner reader = new Scanner( System.in );
            System.out.print( prefix );
            String line = reader.nextLine();
            // vyhodnot prikaz
            game.processCommand( line );
            
            // renderuj
            game.getDrawer().render( game );
        }
        if( game.getGameState() == GameState.QUIT )
        {
            game.init();
            game.start();
        }
        else if( game.getGameState() == GameState.GAMEOVER )
        {
            print("\n\n\n###########Prehral si !###########\n\n\n");
            game.init();
            game.start();
            History.getHistory().clear();
        }
        else if( game.getGameState() == GameState.SOLVED )
        {
            print("\n\n\n######Uspesne si dokoncil hru!!######\n\n\n");
            game.init();
            game.start();
        }
            
    }

    /**
     *
     * @param arg0
     * @param arg1
     */
    @Override
    public void setCursorPosition(int arg0, int arg1) 
    {
        
    }

    /**
     *
     * @param arg0
     */
    @Override
    public void setBackgroundColor(int arg0)
    {
    }

    /**
     *
     * @param arg0
     */
    @Override
    public void setForegroundColor(int arg0) 
    {
    }
}
