package com.structuralpatterns.adapter;

import java.util.ArrayList;
import java.util.List;

interface Shape {
    public void draw();
    public void fill();
}

class Line implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing a line");
    }

    @Override
    public void fill() {
        System.out.println("filling a line");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing a triangle");
    }

    @Override
    public void fill() {
        System.out.println("filling a triangle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing a Rectangle");
    }

    @Override
    public void fill() {
        System.out.println("filling a Rectangle");
    }
}


class Container {
    List<Shape> shapes = new ArrayList<>();
    public void add(Shape s) {
        shapes.add(s);
    }
    public void draw() {
        for (Shape s: shapes) {
            s.draw();
        }
    }
    public void fill() {
        for (Shape s: shapes) {
            s.fill();
        }
    }
}