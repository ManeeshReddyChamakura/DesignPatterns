package com.creationalpatterns.singleton;

class Singleton {
    int num;
    private static volatile Singleton instance;
    private Singleton(int num) {
        this.num = num;
    }
    public static Singleton getInstance() {
//        // lazy or delayed the creation of the object
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                instance = new Singleton(-1);
            }
        }
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
    }
}
