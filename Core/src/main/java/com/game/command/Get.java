/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.command;


import com.game.abstr.AbstractCommand;
import com.game.meta.Game;
import com.game.meta.Moveable;
import com.game.item.Shells;

/**
 * Tento príkaz slúži pri braní predmetov z miestnosti, pričom podmienkou je,
 * aby daný predmet implementoval rozhranie Moveable.
 *
 * @author Bingo Player
 */
public class Get extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public Get(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        // params na male pismenka
        params = params.toLowerCase();

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
        out.trim();

        if (game.getPlayer().getBackpack().getItem("puta") != null && !out.equals("zelezna tyc"))
            System.out.println("\nSi v putach !\n\n");
        else {
            // prehladaj aktualnu miestnost ci sa tam nachadza predmet
            if (game.getCurrentRoom().getItem(out) == null)
                System.out.println("Tento predmet tu nikde nevidim.\n\n");
            else {
                if (!(game.getCurrentRoom().getItem(out) instanceof Moveable))
                    System.out.println("Tento predmet" + "<" + game.getCurrentRoom().getItem(out).getName() + "> sa neda prenasat.\n\n");
                else {
                    if (game.getPlayer().getBackpack().getItems().size() == game.getPlayer().getBackpack().getCapacity())
                        System.out.println("Predmet sa uz do batohu nezmesti.\n\n");
                    else {
                        if (out.equals("naboje")) {
                            if (game.getPlayer().getBackpack().getItem("naboje") != null) {
                                Shells n = (Shells) game.getPlayer().getBackpack().getItem("naboje");
                                n.stuck(10);

                                // vypis novo pridany predmet
                                System.out.println("Do inventara bol pridany predmet : " + game.getCurrentRoom().getItem(out).getName() + "\n\n");

                                // vezmi predmet z miestnosti
                                game.getCurrentRoom().removeItem(game.getCurrentRoom().getItem(out));
                            } else {
                                game.getPlayer().getBackpack().add(game.getCurrentRoom().getItem(out));

                                // vypis novo pridany predmet
                                System.out.println("Do inventara bol pridany predmet : " + game.getCurrentRoom().getItem(out).getName() + "\n\n");

                                // vezmi predmet z miestnosti
                                game.getCurrentRoom().removeItem(game.getCurrentRoom().getItem(out));
                            }
                        } else {
                            game.getPlayer().getBackpack().add(game.getCurrentRoom().getItem(out));

                            // vypis novo pridany predmet
                            System.out.println("Do inventara bol pridany predmet : " + game.getCurrentRoom().getItem(out).getName() + "\n\n");

                            // vezmi predmet z miestnosti
                            game.getCurrentRoom().removeItem(game.getCurrentRoom().getItem(out));
                        }

                    }
                }
            }
        }
    }
}
