package com.structuralpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private List<Component> children = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        children.add(c);
        c.setParent(this);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public void display(int depth) {
        String prefix = new String(new char[depth]).replace('\0', '-');
        System.out.println(prefix+this.name);
        for (Component component: children) {
            component.display(depth + 2);
        }
    }

}
