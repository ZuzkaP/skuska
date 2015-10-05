/*

 */

package com.game.item;

import com.game.abstr.AbstractItem;
import com.game.impl.RoomImpl;
import com.game.meta.*;
/**
 *
 * @author Bingo Player
 */
public class Teleport  extends AbstractItem
    implements Moveable, Useable
{
    private Room prev;
    
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public Teleport()
    {
        super("teleport", "--------------.");
        prev = null;
    }
    
    private void teleport(Game game)
    {
        if( "telm".equals(game.getCurrentRoom().getName()) )
        {
            game.setCurrentRoom( prev );
            game.getUI().print("Pouzil si teleport a vratil si sa spat z tajnej miestnosti.\n\n");
        }
        else 
        {
            game.getUI().print("Pouzil si teleport a dostal si sa do tajnej miestnosti.\n\n");
            prev = game.getCurrentRoom();
            Room tel = new RoomImpl("telm", "Ha! Objavil si skrytu miestnost! Je to stary rusky sklad este z druhej svetovej..."
                + "Skus sa rozhliadnut ci nenajdes nieco dolezite. Davaj vsak pozor tieto miestnosti byvaju zradne."); 
            tel.addItem( new Generator() );
            game.setCurrentRoom( tel );
        }
    }

    @Override
    public GameState use(Game game) 
    {
        teleport(game);
        
        // vrat stav
        return GameState.PLAYING;
    }
}
