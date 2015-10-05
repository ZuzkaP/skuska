package com.game.impl;

import com.game.command.*;
import com.game.meta.Command;
import com.game.meta.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom� on 5.10.2015.
 */
public class ParserImpl implements Parser {
    /**
     * Kon�truktor parsera vytvor� nov� in�tanciu tejto triedy, pri�om sa sa
     * vytvor� nov� zoznam reprezentuj�ci zoznam pr�kazov a z�rove� sa pridaj�
     * v�etky zn�me pr�kazy do zoznamu.
     */
    public ParserImpl() {
        prikazy = new ArrayList<>();
        prikazy.add(new Version("VERZIA", "Zobrazi informacie o autovori."));
        prikazy.add(new Quit("KONIEC", "Ukonci hru a vrati spat do menu."));
        prikazy.add(new Prikazy("PRIKAZY", "Zobrazi vsetky prikazy."));
        prikazy.add(new South("JUH", "Posunie hraca smerom na juh, ak je to mozne."));
        prikazy.add(new North("SEVER", "Posunie hraca smerom na sever, ak je to mozne."));
        prikazy.add(new East("VYCHOD", "Posunie hraca smerom na vychod, ak je to mozne."));
        prikazy.add(new West("ZAPAD", "Posunie hraca smerom na zapad, ak je to mozne."));
        prikazy.add(new Explore("PRESKUMAJ", "Preskuma dany predmet."));
        prikazy.add(new Get("VEZMI", "Vezme predmet z miestnosti ktory je prenasatelny."));
        prikazy.add(new Put("POLOZ", "Polozi dany predmet do miestnosti."));
        prikazy.add(new Inventory("INVENTAR", "Zobrazi aktualny stav hracovho inventara."));
        prikazy.add(new Use("POUZI", "Pomocou tohto prikazu je mozne pouzivat predmety,"));
        prikazy.add(new TurnOn("ZAPNI", "Zapni generator."));
        prikazy.add(new TurnOn("VYPNI", "Vypni generator."));
    }

    private final ArrayList<Command> prikazy;

    /**
     * T�to met�da na z�klade vstupn�ho parametra vyh�ad� Command, ktor� je
     * reprezentovan� vstupn�m parametrom typu String. Vr�tena je referencia na
     * Command resp. null ak sa pr�kaz nena�iel.
     *
     * @param arg0 Vstupn� re�azec reprezentuj�ci n�zov pr�kazu na��tan� z �tandardn�ho vstupu
     * @return command.
     */
    @Override
    public Command getCommand(String arg0) {
        // prehladavaj
        for (Command aPrikazy : prikazy) {
            if (aPrikazy.getName().equalsIgnoreCase(arg0))
                return aPrikazy;
            else if (arg0.toUpperCase().contains(aPrikazy.getName())) {
                return aPrikazy;
            }
        }
        return null;
    }


    /**
     * T�to met�da sl��i na vr�tenie referencie na zoznam v�etk�ch pr�kazov.
     *
     * @return zoznam pr�kazov.
     */
    @Override
    public List<Command> getCommands() {
        return prikazy;
    }
}
