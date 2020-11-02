package com.structuralpatterns.composite;

public class Main {
    public static void main(String[] args) {
        Component root = new Composite("root");
        root.setParent(null);

        root.add(new Leaf("image.png"));
        root.add(new Leaf("image2.png"));
        Component box = new Composite("screenshots");
        root.add(box);
        box.add(new Leaf("scrn1.png"));
        Component leaf = new Leaf("scrn2.png");
        box.add(leaf);
        root.add(new Leaf("readme.md"));

        leaf.displayParent();
    }
}
