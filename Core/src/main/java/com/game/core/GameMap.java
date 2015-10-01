/*
 
 */

package com.game.core;

import com.game.abstr.UserInterface;

/**
 * Táto trieda slúži na vykresľovaie aktuálnej mapy hry, ktorp hráč
 * svojím postupom v hre odhalil.
 * @author Bingo Player
 */
public class GameMap 
{
    private final int MAX_X = 50;
    private final int MAX_Y = MAX_X;
    private final int room = 1;
    private final int bonusRoom = 2;
    private final int chodba_X = 3;
    private final int chodba_Y = 4;
    private final int[][] map;
    private int curX;
    private int curY;
    
    /**
     * Tento konštuktor zabezpečí vytvorenie novej inštancie tejto triedy, pričom
     * je potrebné zadať aj vstupné parametre predstavujúce počiatočnú pozíciu hráča.
     * @param x začiatočná pozícia X
     * @param y začiatočná pozícia Y
     */
    public GameMap(int x, int y)
    {
        this.curX = x;
        this.curY = y;
        
        map = new int[MAX_X][MAX_Y];
        
        for( int i = 0; i < MAX_X; i++ )
            for( int j = 0; j < MAX_Y; j++ )
                map[i][j] = 0;
        
        map[curX][curY] = room;
    }
    
    /**
     * Táto metóda zabezbečuje nastavenie značky M na severnú pozíciu od hráčovej
     * aktuálnej pozície.
     */
    public void registerNorthStep()
    {
        if(this.curY > 0)
        {
            map[this.curX][--this.curY] = chodba_Y;
            map[this.curX][--this.curY] = room;
        }
    }
    
    /**
     * Táto metóda zabezbečuje nastavenie značky M na južnú pozíciu od hráčovej
     * aktuálnej pozície.
     */
    public void registerSouthStep()
    {
        if(this.curY < MAX_Y)
        {
            map[this.curX][++this.curY] = chodba_Y;
            map[this.curX][++this.curY] = room;
        }
    }
    
    /**
     * Táto metóda zabezbečuje nastavenie značky M na východnú pozíciu od hráčovej
     * aktuálnej pozície.
     */
    public void registerEastStep()
    {
        if(this.curX < MAX_X)
        {
            map[++this.curX][this.curY] = chodba_X;
            map[++this.curX][this.curY] = room;
        }
    }
    
    /**
     * Táto metóda zabezbečuje nastavenie značky M na západnú pozíciu od hráčovej
     * aktuálnej pozície.
     */
    public void registerWestStep()
    {
        if(this.curX > 0)
        {
            map[--this.curX][this.curY] = chodba_X;
            map[--this.curX][this.curY] = room;
        }
    }
    
    /**
     * Táto metóda zebezpečuje nastavenie značky B na pozíciu danú užívateľom. 
     * @param x pozícia X skrytej miestnosti
     * @param y pozícia Y skrytej miestnosti
     */
    public void registerSecretRoom(int x, int y)
    {
        if(map[x][y] != room) 
            map[x][y] = bonusRoom;
    }
    
    /**
     * Táto metóda zmaže obsah celej mapy.
     */
    public void clearMap()
    {
        for(int i = 0; i < MAX_X; i++)
            for(int j = 0; j < MAX_Y; j++)
                map[i][j] = 0;
    }
    
    /**
     * Táto metóda zobrazí aktuálnu mapu hry.
     * @param ui užívateľské rozhranie
     * @throws NullPointerException
     */
    public void showMap(UserInterface ui) throws NullPointerException
    {
        if( ui == null )
            throw new NullPointerException();
        else
        {
            ui.print("****************************************\n");
            for(int i = 0; i < MAX_X; i++)
            {                   
                ui.print("\n");
                for(int j = 0; j < MAX_Y; j++)
                {  
                    if(map[j][i] == 0)
                        ui.print(" ");
                    else if(curX == j && curY == i)
                        ui.print("P");
                    else if(map[j][i] == room)
                        ui.print("M");
                    else if(map[j][i] == bonusRoom)
                        ui.print("B");
                    else if(map[j][i] == chodba_X)
                        ui.print("-");
                    else if(map[j][i] == chodba_Y)
                        ui.print("|");
                }
            }
            ui.print("\n****************************************");
            ui.print("\nLegenda : P - Hrac, M - miestnost, B - bonusova miestnost\n\n");
        }
    }
}
