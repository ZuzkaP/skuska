/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.core;

import com.game.abstr.Command;
import com.game.abstr.Parser;
import com.game.commands.*;

import java.util.ArrayList;

/**
 * Táto trieda je implementácia rozhrania Parser, pričom táto trieda je nevyhnutná
 * pri práci s čítaním príkazov. Všetky príkazy sú uložené v zozname.
 * @author Bingo Player
 */
public class ParserImpl 
    implements Parser
{

    /**
     * Konštruktor parsera vytvorí novú inštanciu tejto triedy, pričom sa sa 
     * vytvorí nový zoznam reprezentujúci zoznam príkazov a zároveň sa pridajú
     * všetky známe príkazy do zoznamu.
     */
    public ParserImpl()
    {
        // pridaj prikazy
        prikazy = new ArrayList<>();
        prikazy.add( new Version( "VERZIA" , "Zobrazi informacie o autovori." ) );
        prikazy.add( new Quit( "KONIEC", "Ukonci hru a vrati spat do menu." ) );
        prikazy.add( new Prikazy( "PRIKAZY", "Zobrazi vsetky prikazy.") );
        prikazy.add( new South( "JUH", "Posunie hraca smerom na juh, ak je to mozne." ) );
        prikazy.add( new North( "SEVER", "Posunie hraca smerom na sever, ak je to mozne." ) );
        prikazy.add( new East( "VYCHOD", "Posunie hraca smerom na vychod, ak je to mozne." ) );
        prikazy.add( new West( "ZAPAD", "Posunie hraca smerom na zapad, ak je to mozne." ) );
        prikazy.add( new LookAround( "ROZHLIADNI SA", "Vypise informacie o aktualnej miestnosti a moznych vychodoch." ) );
        prikazy.add( new Explore( "PRESKUMAJ", "Preskuma dany predmet." ) );
        prikazy.add( new Get( "VEZMI", "Vezme predmet z miestnosti ktory je prenasatelny." ) );
        prikazy.add( new Put( "POLOZ", "Polozi dany predmet do miestnosti." ) );
        prikazy.add( new Inventory( "INVENTAR", "Zobrazi aktualny stav hracovho inventara." ) );
        prikazy.add( new Use( "POUZI", "Pomocou tohto prikazu je mozne pouzivat predmety," ) );
        prikazy.add( new Load( "NACITAJ", "Nacita posledny znamy hracov stav." ) );
        prikazy.add( new Save( "ULOZ", "Ulozi aktualne rozohranu hru." ) );
        prikazy.add( new TurnOn( "ZAPNI", "Zapni generator." ) );
        prikazy.add( new TurnOn( "VYPNI", "Vypni generator." ) );
        prikazy.add( new Restart( "RESTART", "Restartuje hru a hrac zacne odznova.") );
        prikazy.add( new Map( "MAPA", "Zobrazi aktualnu mapu hry, teda miestnosti, ktore uz hrac odhalil." ) );
    }
    
    private final ArrayList<Command> prikazy;
    
    /**
     * Táto metóda na základe vstupného parametra vyhľadá Command, ktorý je 
     * reprezentovaný vstupným parametrom typu String. Vrátena je referencia na
     * Command resp. null ak sa príkaz nenašiel.
     * @param arg0 Vstupný reťazec reprezentujúci názov príkazu načítaný z štandardného vstupu
     * @return command.
     */
    @Override
    public Command getCommand( String arg0 )
    {
        // prehladavaj
        for( int i = 0; i < prikazy.size(); i++ )
        {   
            if( prikazy.get(i).getName().equalsIgnoreCase( arg0 ) )
                return prikazy.get(i);
            else if ( arg0.toUpperCase().contains( prikazy.get(i).getName() ) )
            {       
                    return prikazy.get(i);
            }      
        }
        // defaultne vracia nulu
        return null;
    }
    
    
    /**
     * Táto metóda slúži na vrátenie referencie na zoznam všetkých príkazov.
     * @return zoznam príkazov.
     */
    public ArrayList<Command> getCommands()
    {
        return prikazy;
    }

}
