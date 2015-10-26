/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.command;


import com.game.abstr.AbstractCommand;
import com.game.meta.Game;

/**
 * Tento príkaz slúži na preskúmanie daného predmetu, ktorý je vstupným parametrom
 * metódy execute.
 *
 * @author Zuzka
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
            System.out.println("Nespravne vyuzitie prikazu PRESKUMAJ <attr>.\n\n");
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
            System.out.println("Miestnost :" + game.getCurrentRoom().getItem(out).getDescription() + "\n\n");
        else if (game.getPlayer().getBackpack().getItem(out) != null)
            System.out.println("Batoh :" + game.getPlayer().getBackpack().getItem(out).getDescription() + "\n\n");
        else
            System.out.println("Taky predmet sa v miestnosti/batohu nenachadza.\n\n");
    }
}
