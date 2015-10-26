/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.item;
import com.game.abstr.AbstractItem;
import com.game.meta.*;
/**
 *
 * @author Zuzka
 */
public class IronHole extends AbstractItem
    implements Useable, Moveable
{
    /**
     * Tento bezparametrický konštruktor vytvorí novú inštanciu tejto triedy,
     * pričom sa defaultne nastaví názov a opis predmetu.
     */
    public IronHole()
    {
        super("zelezna tyc", "Velka zelezna tyc.");
    }

    @Override
    public GameState use(Game game)
    {
        if( game.getPlayer().getBackpack().getItem("puta") != null )
        {
            // odober puta z inventara
            game.getPlayer().getBackpack().remove("puta");
            
            // odober zeleznu tyc
            if( game.getPlayer().getBackpack().getItem(getName()) != null )
                game.getPlayer().getBackpack().remove(getName());
            else
                game.getCurrentRoom().removeItem( this);
            
            game.getUI().print("Pouzil si tyc na odstranenie put.\n\n");
        }
            
        return GameState.PLAYING;
    }
}
