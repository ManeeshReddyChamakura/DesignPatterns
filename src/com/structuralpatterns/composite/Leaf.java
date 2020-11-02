package com.structuralpatterns.composite;

public class Leaf extends Component{

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        System.out.println("Cannot add in leaf");
    }

    @Override
    public void remove(Component c) {
        System.out.println("Cannot remove in leaf");
    }

    @Override
    public void display(int depth) {
        System.out.println(new String(new char[depth]).replace('\0', '-') + this.name);
    }
}
