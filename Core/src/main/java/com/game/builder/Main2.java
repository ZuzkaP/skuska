/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.builder;

/**
 *
 * @author Robo
 */
public class Main2 {
    public static void main(String[] args) {
        
        NestedFunctionBuilder.getInstance().game("Vitaj v tejto izbe. Zrejme hladas svoju princeznu. Nachadza sa niekde na tomto hrade. Vela stastia.",
               player("Nebojacny Juraj"), 
               newRoom("r1","Vsupna izba"),roomWithBoth(roomWithItems("r2", "Hala",item("axe"),item("key")),
                       entity("princess")),
               newRoom("r3", "Prazdna izba"),
               newRoom("r4", "Balkon"),
               roomWithEntity("r5", "Zamknuta izba",entity("princess")));
        
        NestedFunctionBuilder.getInstance().exit("Huraaa! Nasiel si princeznu", "Utiekol si s nou z hradu.");
    }
}
