/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.command;

import com.game.abstr.AbstractCommand;
import com.game.meta.Game;
import com.game.impl.GameImpl;

/**
 * Tento príkaz slúži na vypísanie všetkých príkazov, ktoré sú v hre implementované.
 *
 * @author Bingo Player
 */
public class Prikazy extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public Prikazy(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        // params na male pismenka
        params = params.toLowerCase();
        params.trim();

        // skontroluj output
        if (!params.equals(getName().toLowerCase())) {
            System.out.println("Nespravne pouzitie prikazu PRIKAZY\n\n");
            return;
        }

        GameImpl temp = (GameImpl) game;

        for (int i = 0; i < temp.getParser().getCommands().size(); i++) {
            String info= temp.getParser().getCommands().get(i).getName();
            if(info.length() >6)
                info += " \t- ";
            else
                info +=" \t\t- ";
            System.out.println(info+temp.getParser().getCommands().get(i).getDescription());
        }

        System.out.println("\n\n");
    }

}
