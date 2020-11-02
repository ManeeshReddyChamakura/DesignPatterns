package com.structuralpatterns.adapter;

public class ShapeAdapter implements Shape{

    ComplexShape shape;

    ShapeAdapter(ComplexShape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.drawShape();
    }

    @Override
    public void fill() {
        shape.fillShape();
    }

}
