/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.item;
import com.game.abstr.AbstractItem;
import com.game.meta.*;
import com.game.impl.RoomImpl;

/**
 *
 * @author Bingo Player
 */
public class LockPick extends AbstractItem
    implements Moveable, Useable
{
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public LockPick()
    {
        super("sperhak", "Stary pouzity sperhak.");
    }

    @Override
    public GameState use(Game game) 
    {
        // kluc som pouzil
        // je v miestnosti truhlica ?
        if( game.getCurrentRoom().getEast() != null  )
        {
            if( game.getCurrentRoom().getEast().getName() != null )
                if( game.getCurrentRoom().getEast().getName().equalsIgnoreCase(getName()) )
                {
                    // vrat izbu
                    RoomImpl room = (RoomImpl)game.getCurrentRoom().getEast();

                    // odomkni miestnost
                    room.setName(null);
                    
                    // odstran kluc
                    if( game.getCurrentRoom().getItem(getName()) != null )
                        game.getCurrentRoom().removeItem(this);
                    else
                        game.getPlayer().getBackpack().remove( getName() );
                    
                    game.getUI().print("Predmet bol pouzity spravne.\n\n");
                    
                    return GameState.PLAYING;
                }     
        }
        if( game.getCurrentRoom().getWest() != null )
        {
            if( game.getCurrentRoom().getWest().getName() != null )
                if( game.getCurrentRoom().getWest().getName().equalsIgnoreCase(getName()) )
                {
                    // vrat izbu
                    RoomImpl room = (RoomImpl)game.getCurrentRoom().getWest();

                    // odomkni miestnost
                    room.setName(null);
                    
                    // odstran kluc
                    if( game.getCurrentRoom().getItem(getName()) != null )
                        game.getCurrentRoom().removeItem(this);
                    else
                        game.getPlayer().getBackpack().remove( getName() );
                    
                    game.getUI().print("Predmet bol pouzity spravne.\n\n");
                    
                    return GameState.PLAYING;
                }      
        }
        if( game.getCurrentRoom().getNorth() != null )
        {
            if( game.getCurrentRoom().getNorth().getName() != null )
                if( game.getCurrentRoom().getNorth().getName().equalsIgnoreCase(getName()) )
                {
                    // vrat izbu
                    RoomImpl room = (RoomImpl)game.getCurrentRoom().getNorth();

                    // odomkni miestnost
                    room.setName(null);
                    
                    // odstran kluc
                    if( game.getCurrentRoom().getItem(getName()) != null )
                        game.getCurrentRoom().removeItem(this);
                    else
                        game.getPlayer().getBackpack().remove( getName() );
                    
                    game.getUI().print("Predmet bol pouzity spravne.\n\n");
                    
                    return GameState.PLAYING;
                }    
        }
        if( game.getCurrentRoom().getSouth() != null )
        {
            if( game.getCurrentRoom().getSouth().getName() != null )
                if( game.getCurrentRoom().getSouth().getName().equalsIgnoreCase(getName()) )
                {
                    // vrat izbu
                    RoomImpl room = (RoomImpl)game.getCurrentRoom().getSouth();

                    // odomkni miestnost
                    room.setName(null);
                    
                    // odstran kluc
                    if( game.getCurrentRoom().getItem(getName()) != null )
                        game.getCurrentRoom().removeItem(this);
                    else
                        game.getPlayer().getBackpack().remove( getName() );
                    
                    game.getUI().print("Predmet bol pouzity spravne.\n\n");
                    
                    return GameState.PLAYING;
                }
        }
        
        game.getUI().print( "Tento predmet sa tu pouzit neda.\n\n" );
        
        // vrat stav
        return GameState.PLAYING;
    }
}
