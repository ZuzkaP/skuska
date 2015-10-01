/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.core;

import java.util.*;


/**
 * Táto trieda je implementáciou menu hry, pričom je definovaná pomocou visibility,
 * a reťazcov, ktoré sú reprezentované ako položky menu.
 * @author Bingo Player
 */
public class Menu 
{
    private final List<String> polozky;
    private boolean Visible;
    private final String prefix;
    
    /**
     * Tento konštruktor vytvorí novú referenciu triedy Menu, pričom sa uloží
     * pole reťazcov do zoznamu, pričom jednotlivé reťazce predstavujú danú
     * položku nachádzajúcu sa v menu.
     * @param polozky Pole všetkých reťazcov, ktoré predstavujú položky menu
     */
    public Menu( String polozky[] )
    {
        // inicializuj prefix
        this.prefix = "-> ";
        
        // polozky
        this.polozky = new ArrayList<>();
        this.polozky.addAll(Arrays.asList(polozky));
        
        // nastav visible
        Visible = false;
    }
    
    /**
     * Táto metóda vracia reťazec, ktorý je na základe vstupného čísla vrátený
     * ako zoznam na i-tom prvku v zozname reťazcov, pričom i je vstupné číslo.
     * @return reťazec.
     */
    public String Sender( )
    {
        if( this.Visible )
        {
            // pridaj reader
            Scanner reader = new Scanner( System.in );
            
            // prefix
            System.out.print( prefix );
            
            int Input = 0 ;
            
            // precitaj riadok
            try
            {
                Input = reader.nextInt();
            }
            catch( Exception e )
            {
                System.err.print(e.toString());
            }
 
                  
            // skontroluj ci vstup obsahuje cislice
            if( Input > polozky.size() || Input < 1 )
                return null;
            else
            {
                return polozky.get( Input - 1 );
            }
        }
        
        // default null
        return null;
    }
    
    /**
     * Vráti boolovskú hodnotu, ktorá je true ak je renderované práve menu, inak
     * false.
     * @return true | false.
     */
    public boolean getVisible()
    {
        return this.Visible;
    }
            
    /**
     * Nastaví visibilitu menu, pričom ak je vstupný parameter true, zobrazí sa 
     * menu, inak sa nezobrazí nič.
     * @param Visible Boolovská hodnota nastavenia visibility
     */
    public void setVisible( boolean Visible )
    {
        if( !Visible )
        {
            
        }
        else
        {         
            char escCode = 0x1B;
            
            // pridaj polozky
            for( int i = 0; i < polozky.size(); i++ )
            {
                // vypis polozky menu
                System.out.print( String.format( "%c" , escCode) );
                System.out.print( (i+1) + ". " + this.polozky.get(i) + "\n" );
            } 
        }
        
        // priznak visible
        this.Visible = Visible;
    }
}
