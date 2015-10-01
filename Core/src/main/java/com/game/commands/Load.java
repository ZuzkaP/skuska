/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.commands;

import com.game.abstr.AbstractCommand;
import com.game.abstr.Game;
import com.game.core.GameImpl;
import com.game.core.History;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Tento príkaz slúži na načítanie predošlého stavu hry zo súboru.
 *
 * @author Bingo Player
 */
public class Load extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public Load(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        params.trim();
        // temporary
        String[] Output = params.split(" ");

        String out = new String();

        if (!Output[0].toLowerCase().equals(getName().toLowerCase())) {
            game.getUI().print("Zle vyuzitie prikazu ULOZ <path>!\n\n");
            return;
        }

        // pridaj working directory
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        s += "/";

        game.getUI().print("Hra sa nacita...\n\n");

        // skontroluj output
        if (Output.length == 1) {
            try {
                GameImpl hra = (GameImpl) game;

                // nova hra
                hra.initLevels();

                // zmaz historiu
                History.getHistory().clear();

                // nacitaj zo suboru
                History.getHistory().load("save.txt");

                for (int i = 0; i < History.getHistory().getList().size(); i++) {
                    // vykonaj prikazy
                    if (hra.getParser().getCommand(History.getHistory().getList().get(i)) != null)
                        hra.getParser().getCommand(History.getHistory().getList().get(i)).execute(game, History.getHistory().getList().get(i));
                }
            } catch (IOException e) {
                System.err.print(e.toString());
            }
        } else {
            // prirad prvy parameter nasledujuci za NACITAJ 
            out += Output[1];

            // zapis na dany subor
            try {
                GameImpl hra = (GameImpl) game;

                hra.initLevels();

                History.getHistory().clear();

                History.getHistory().load(out);

                for (int i = 0; i < History.getHistory().getList().size(); i++) {
                    // vykonaj prikazy
                    if (hra.getParser().getCommand(History.getHistory().getList().get(i)) != null)
                        hra.getParser().getCommand(History.getHistory().getList().get(i)).execute(game, History.getHistory().getList().get(i));
                }
            } catch (IOException e) {
                System.err.print(e.toString());
            }
        }
    }

}
