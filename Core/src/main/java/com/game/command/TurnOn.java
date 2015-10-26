/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.command;

import com.game.abstr.AbstractCommand;
import com.game.meta.Game;
import com.game.item.Generator;

/**
 * Tento príkaz slúži na zapínanie/vypínanie generátora v hre.
 *
 * @author Zuzka
 */
public class TurnOn extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public TurnOn(String nazov, String description) {
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
            System.out.println("Nespravne pouzitie prikazu ZAPNI/VYPNI GENERATOR!\n\n");
            return;
        }

        // prirad slova do novej premennej
        for (int i = 1; i < Output.length; i++) {
            out += Output[i];
            out += " ";
        }

        // odstran na konci medzery
        out = out.substring(0, (out.length() - 1));

        if (out.equalsIgnoreCase("generator")) {
            if (game.getCurrentRoom().getItem("generator") != null) {
                Generator g = (Generator) game.getCurrentRoom().getItem("generator");
                g.use(game);
            } else
                System.out.println("Generator sa nenachadza v tejto miestnosti.");
        } else
            System.out.println("Zapnut/vypnut je mozne iba generator.");
    }

}