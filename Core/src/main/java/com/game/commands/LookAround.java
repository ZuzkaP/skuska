/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.commands;

import com.game.abstr.AbstractCommand;
import com.game.abstr.Game;

/**
 * Tento príkaz slúži na vypísanie aktuálnej miestnosti, pričom sa vypíše jej opis,
 * predmety, ktoré sa v nej nachádzajú a všetky možné východy z miestnosti.
 *
 * @author Bingo Player
 */
public class LookAround extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public LookAround(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        params.trim();
        if (!params.toLowerCase().equals(getName().toLowerCase())) {
            game.getUI().print("Nespravne pouzitie prikazu ROZHLIADNI SA!\n\n");
            return;
        }

        // da sa ist na vychod ?
        if (game.getCurrentRoom() != null) {
            // presun sa na vychod
            game.getCurrentRoom().show(game.getUI());
        }
    }
}
