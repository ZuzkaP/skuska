/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.commands;


import com.game.abstr.AbstractCommand;
import com.game.abstr.Game;

/**
 * Tento príkaz slúži na preskúmanie daného predmetu, ktorý je vstupným parametrom
 * metódy execute.
 *
 * @author Bingo Player
 */
public class Explore extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public Explore(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        // params na male pismenka
        params = params.toLowerCase();

        // oddel parameter
        String[] splitArray = params.split(" ");

        //output
        String out = new String();

        // skontroluj pole
        if (splitArray.length == 1 || splitArray.length == 0 || !splitArray[0].toLowerCase().equals(getName().toLowerCase())) {
            game.getUI().print("Nespravne vyuzitie prikazu PRESKUMAJ <attr>.\n\n");
            return;
        }

        // rozdel string
        for (int i = 1; i < splitArray.length; i++) {
            out += splitArray[i];
            out += " ";
        }

        out = out.substring(0, (out.length() - 1));
        out.trim();

        // vyhladaj predmet
        if (game.getCurrentRoom().getItem(out) != null)
            game.getUI().print("Miestnost :" + game.getCurrentRoom().getItem(out).getDescription() + "\n\n");
        else if (game.getBackpack().getItem(out) != null)
            game.getUI().print("Batoh :" + game.getBackpack().getItem(out).getDescription() + "\n\n");
        else
            game.getUI().print("Taky predmet sa v miestnosti/batohu nenachadza.\n\n");
    }
}
