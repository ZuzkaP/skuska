/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Táto trieda návrhového vzoru singleton (jedináčik) slúži na ukladanie stavu
 * hry do zoznamu, pričom je možné uložiť resp. načítať posledný stav hry zo
 * súboru.
 * @author Bingo Player
 */
public class History 
{
    // data - singleton metoda - jedinacik
    private static History ref = null;
    private final List<String> history;
 
    private History()
    {
        history = new ArrayList<> ();
    }
    
  
    /**
     * Táto statická metóda slúži na vytvorenie referencie triedy Histoy
     * podľa modelu singleton - jedináčik.
     * @return referencia na triedu History.
     */
    public static History getHistory()
    {
        // je ref null ?
        if( ref == null )
            ref = new History();
       
        // vrat ref
        return ref;
    }
    
    /**
     * Táto statická metóda vracia referenciu na zoznam všetkých Stringov, ktoré
     * sa v histórii nachadzájú.
     * @return zoznam reťazcov.
     */
    public List<String> getList()
    {
        return history;
    }
    
    /**
     * Táto statická metóda slúži na pridanie nového prvku do zoznamu, čiže
     * pridanie nového reťazca.
     * @param line Reťazec reprezentujúci názov príkazum, ktorý má byť pridaný do zoznamu
     */
    public void add( String line ) throws NullPointerException
    {
        // skontroluj vstup
        if( line != null && !line.isEmpty() )
            history.add( line );
        else
            throw new NullPointerException();
    }
    
    /**
     * Táto statická metóda slúži na zmazanie celého zozmamu histórie.
     */
    public void clear()
    {
        // zmaz prikazy
        history.clear();
    }
    
    /**
     * Táto metóda slúži na uloženie aktuálneho stavu hry do súboru, pričom sa
     * ukladá postupnosť vetkých príkazov, ktoré hráč zadával počas celého behu
     * programu, ktoré boli uložené do histórie.
     * @param path Názo výstupného súboru
     * @throws java.io.IOException
     */
    public void save( String path ) throws IOException
    {
        try
        {
            // vstup
            OutputStream file;
            BufferedWriter bw;
            
            // otvor subor
            file = new FileOutputStream( path );
            bw = new BufferedWriter( new OutputStreamWriter( file, Charset.forName( "UTF-8" ) ) );
            
            // citaj riadky
            for( int i = 0; i < history.size(); i++ )
            {
                bw.write( history.get(i) );
                bw.newLine();
            }
            
            // zavri subor
            bw.close();
            bw = null;
            file = null;
            
            // vypis
            System.out.print( "Subor bol uspesne ulozeny do > '" + path + "'.\n\n" );
        }
        catch( NullPointerException | IOException e )
        {
            System.err.print( e.toString() );
        }
    }
    
    /**
     * Táto metóda slúži na načítanie celej postupnosti príkazov, ktorá bola
     * uložená do súboru ako postupnosť predošlej hry.
     * @param path
     * @throws java.io.IOException
     */
    public void load( String path ) throws IOException
    {
        try
        {
            // citaj zo suboru
            InputStream file;
            BufferedReader bf;
            
            // riadok
            String line = new String();
            
            // otvoril som subor ?
            file = new FileInputStream( path );
            bf = new BufferedReader( new InputStreamReader( file, Charset.forName( "UTF-8" ) ) );
            
            // citaj
            while( (line = bf.readLine()) != null )
            {
                history.add( line );
            }
            
            // zavri subor
            bf.close();
            bf = null;
            file = null;
            
            // vypis
            System.out.print( "Subor bol uspesne nacitany z > '" + path + "'.\n\n" );
        }
        catch( NullPointerException | IOException e )
        {
            System.err.print( e.toString() );
        }
    }
    
}
