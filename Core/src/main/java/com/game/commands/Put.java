/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.commands;

import com.game.abstr.AbstractCommand;
import com.game.abstr.Game;

/**
 * Tento príkaz slúži na vkladanie predmetov batohu do miestnosti.
 *
 * @author Bingo Player
 */
public class Put extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public Put(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        // params na male pismenka
        params = params.toLowerCase();
        params.trim();

        // temporary
        String[] Output = params.split(" ");
        String out = new String();

        // skontroluj output
        if (Output.length == 1 || Output.length == 0 || !Output[0].toLowerCase().equals(getName().toLowerCase())) {
            game.getUI().print("Nespravne pouzitie prikazu POLOZ <attr>\n\n");
            return;
        }

        // prirad slova do novej premennej
        for (int i = 1; i < Output.length; i++) {
            out += Output[i];
            out += " ";
        }

        // odstran na konci medzery
        out = out.substring(0, (out.length() - 1));
        out.trim();

        if (game.getBackpack().getItem("puta") != null)
            game.getUI().print("Si v putach !");
        else {
            // prehladaj aktualnu miestnost ci sa tam nachadza predmet
            if (game.getBackpack().getItem(out) == null)
                game.getUI().print("Takyto predmet u seba nemas.\n\n");
            else {
                // poloz predmet do miestnosti
                game.getCurrentRoom().addItem(game.getBackpack().remove(out));

                // vypis novo pridany predmet
                game.getUI().print("Do miestnosti bol pridany predmet : " + game.getCurrentRoom().getItem(out).getName() + "\n\n");
            }
        }
    }
}
