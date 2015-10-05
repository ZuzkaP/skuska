package com.game.builder;

import java.lang.reflect.InvocationTargetException;

public class GameObjectFactory<T> {
    public enum ObjectType {
        ITEM("com.game.item"),
        ENTITY("com.game.entity");

        private String pkg;
        ObjectType(String pkg) {
            this.pkg = pkg;
        }

        public String getPackage() {
            return pkg;
        }
    }

     public static <T> T getItemImplementation(ObjectType type, String item) {
        try {
            return (T)Class.forName(type.getPackage() + "." + item).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}