package com.structuralpatterns.composite;

abstract class Component {
    protected String name;
    protected Component parent;
    public Component(String name) {
        this.name = name;
    }
    public abstract void add(Component c);
    public abstract void remove(Component c);
    public abstract void display(int depth);
    public void setParent(Component parent) {
        this.parent = parent;
    }
    public void displayParent() {
        if (parent == null) {
            System.out.println("null");
            return;
        }
        System.out.print(this.parent.name + "->");
        this.parent.displayParent();
    }
}