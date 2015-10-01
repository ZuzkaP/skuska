/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.commands;

import com.game.abstr.AbstractCommand;
import com.game.abstr.Game;
import com.game.core.History;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Tento príkaz slúži na uloženie aktuálneho stavu hry do súboru.
 *
 * @author Bingo Player
 */
public class Save extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public Save(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        // temporary
        params.trim();
        String[] Output = params.split(" ");
        String out = new String();

        // pridaj working directory
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        s += "/";

        if (Output.length > 1)
            if (!Output[0].toLowerCase().equals(getName().toLowerCase())) {
                game.getUI().print("Nespravne vyuzitie prikazu ULOZ <path>!\n\n");
                return;
            }

        try {
            // skontroluj output
            if (Output.length == 1)
                History.getHistory().save(s + "save.txt");
            else if (Output.length > 2)
                game.getUI().print("Nespravne vyuzitie prikazu NACITAJ <path>.\n\n");
            else {
                // prirad prvy parameter nasledujuci za NACITAJ 
                out += Output[1];

                // zapis na dany subor
                History.getHistory().save(out);

                // subor bol ulozeny
            }
        } catch (IOException e) {
            System.err.print(e.toString());
        }

    }
}
