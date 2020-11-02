package com.structuralpatterns.adapter;

interface ComplexShape {
    public void drawShape();
    public void fillShape();
}

class Circle implements ComplexShape {
    @Override
    public void drawShape() {
        System.out.println("drawing a complex circle");
    }

    @Override
    public void fillShape() {
        System.out.println("filling a complex circle");
    }
}


class Ellipse implements ComplexShape {
    @Override
    public void drawShape() {
        System.out.println("drawing a complex Ellipse");
    }

    @Override
    public void fillShape() {
        System.out.println("filling a complex Ellipse");
    }
}


class Rhombus implements ComplexShape {
    @Override
    public void drawShape() {
        System.out.println("drawing a complex Rhombus");
    }

    @Override
    public void fillShape() {
        System.out.println("filling a complex Rhombus");
    }
}