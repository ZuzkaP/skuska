/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.command;

import com.game.abstr.AbstractCommand;
import com.game.meta.Game;
import com.game.meta.Item;
import com.game.meta.Useable;

/**
 * Tento príkaz slúži na volanie metódy use rozhranie Useable, pričom podmienkou
 * je, že daný predmet musí byť inštanciou rozhrania Useable.
 *
 * @author Bingo Player
 */
public class Use extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public Use(String nazov, String description) {
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
            System.out.println("Nespravne pouzitie prikazu POUZI <attr>\n\n");
            return;
        }

        // prirad slova do novej premennej
        for (int i = 1; i < Output.length; i++) {
            out += Output[i];
            out += " ";
        }

        // odstran na konci medzery
        out = out.substring(0, (out.length() - 1));

        // prehladaj aktualnu miestnost ci sa tam nachadza predmet

        Item item = null;


        if (game.getPlayer().getBackpack().getItem("puta") != null && !out.equals("zelezna tyc"))
            System.out.println("Si v putach !\n\n");
        else {
            // nachadza sa predmet v miestnosti alebo v batohu ?
            if (game.getCurrentRoom().getItem(out) == null && game.getPlayer().getBackpack().getItem(out) == null)
                System.out.println("Taky predmet tu nikde nevidim.\n\n");
            else {
                // vrat item
                item = game.getCurrentRoom().getItem(out) != null ? game.getCurrentRoom().getItem(out) : game.getPlayer().getBackpack().getItem(out);

                // je item pouzitelny ?
                if (item instanceof Useable) {
                    ((Useable) item).use(game);
                } else
                    System.out.println("Tento predmet <" + item.getName() + "> je nepouzitelny.\n\n");
            }
        }
    }
}
