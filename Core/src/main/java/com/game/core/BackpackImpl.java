/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.core;

import com.game.abstr.Backpack;
import com.game.abstr.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Táto trieda je konkrétna implementácia rozhrania Backpack, ktorá je definovaná
 * počtom predmetov, ktoré sa maximálne vojdu do batoha.
 *
 * @author Bingo Player
 */
public class BackpackImpl implements Backpack {
    // data
    private final List<Item> items;
    private final int maxItems;

    /**
     * Konštruktor triedy, ktorý vytvorí batoh s konkrétnou kapacitou.
     *
     * @param count Maximálny počet prvkov, ktoré je možné vložiť do zoznamu
     */
    public BackpackImpl(int count) {
        // inicializuj list
        items = new ArrayList<>();

        // max pocet itemov
        maxItems = count;
    }

    /**
     * Táto metóda slúži na pridanie nového Item-u do batohu, pričom sa
     * kontroluje veľkosť batohu porovnaním s jeho kapacitou, v prípade, že sa
     * do batohu ešte Item zmestí návratová hodnota je true, inak false.
     *
     * @param item Predmet, ktorý má byť vložený do batohu
     * @return true | false v závislosti od predchádzajúcich podmienok.
     */
    @Override
    public boolean add(Item item) throws NullPointerException {
        // skontroluj ci je este volne miesto
        if (getCount() == getCapacity()) {
            return false;
        }

        // da sa vziat predmet ?

        // pridaj predmet
        if (item != null)
            items.add(item);
        else
            throw new NullPointerException();

        // vrat true
        return true;
    }

    /**
     * Táto metóda slúži na odobranie Item-u z batohu hráča, pričom je vrátená
     * referencia na vymazaný Item, resp. je vrátená hodnota null, ak Item sa v
     * batohu nenachádza
     *
     * @param name Názov predmetu
     * @return referencia na vymazaný prvok.
     */
    @Override
    public Item remove(String name) {
        // prehladaj zoznam
        for (int i = 0; i < getCount(); i++)
            if (items.get(i).getName().equalsIgnoreCase(name))
                return items.remove(i);

        // default vracaj null
        return null;
    }

    /**
     * Táto metóda slúži na vrátenie konkrétneho Itemu. Algoritmus vyhľadá Item
     * podľa názvu objektu a vráti jeho referenciu ak sa v batohu nachádza, inak
     * vráti referenciu na null.
     *
     * @param name Názov predmetu
     * @return nájdený Item z batohu, inak null.
     */
    @Override
    public Item getItem(String name) {
        // prehladaj zoznam
        for (int i = 0; i < getCount(); i++)
            if (items.get(i).getName().equalsIgnoreCase(name))
                return items.get(i);

        // defaultne vracaj null
        return null;
    }

    /**
     * Táto metóda vráti kapacitu batohu.
     *
     * @return kapacita batohu.
     */
    @Override
    public int getCapacity() {
        return this.maxItems;
    }


    /**
     * Vráti počet prvkov, ktoré sa nachádzajú v batohu.
     *
     * @return počet prvkov v batohu.
     */
    public int getCount() {
        return items.size();
    }

    /**
     * Táto metóda vráti referenciu na zoznam všetkých Item-ov, ktoré sa
     * nachádzajú v batohu.
     *
     * @return zoznam prvkov v batohu.
     */
    @Override
    public List<Item> getItems() {
        return items;
    }

}
