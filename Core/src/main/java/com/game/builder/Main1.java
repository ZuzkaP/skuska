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
public class Main1 {

    public static void main(String[] args) {

        MethodChainingBuilder.getInstance().game("Vitaj v tejto izbe. Zrejme hladas svoju princeznu. Nachadza sa niekde na tomto hrade. Vela stastia.")
                .player("Nebojacny Juraj")
                .newRoom("r1", "Vsupna izba")
                .newRoom("r2", "Hala")
                .entity("boss")
                .newItem("axe")
                .newItem("key")
                .newRoom("r3", "Prazdna izba")
                .newRoom("r4", "Balkon")
                .newRoom("r5", "Zamknuta izba")
                .entity("princess")
                .exit();

    }
}
