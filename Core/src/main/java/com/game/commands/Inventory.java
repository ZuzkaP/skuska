/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.commands;

import com.game.abstr.AbstractCommand;
import com.game.abstr.Game;
import com.game.core.BackpackImpl;

/**
 * Tento príkaz slúži na vypísanie všetkých predmetov, ktoré sa nachádzajú v
 * batohu.
 *
 * @author Bingo Player
 */
public class Inventory extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public Inventory(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        // params na male pismenka
        params = params.toLowerCase();
        params.trim();

        // skontroluj output
        if (!params.equals(getName().toLowerCase())) {
            game.getUI().print("Nespravne pouzitie prikazu INVENTAR\n\n");
            return;
        }

        // temporary
        BackpackImpl temp = (BackpackImpl) game.getBackpack();

        // zisti stav inventara
        if (temp.getCount() == 0)
            game.getUI().print("Batoh je prazdny.\n\n");
        else {
            game.getUI().print("V batohu sa nachadza :\n");

            // prehladaj batoh
            for (int i = 0; i < temp.getCount(); i++)
                game.getUI().print(temp.getItems().get(i).getName() + "\n");

            game.getUI().print("\n");
        }
    }
}
