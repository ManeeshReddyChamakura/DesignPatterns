package com.structuralpatterns.adapter;

public class Main {
    public static void main(String[] args) {
        Shape line = new Line();
        Shape triangle = new Triangle();
        Shape rectangle = new Rectangle();
        Container container = new Container();
        // add the shapes to container
        container.add(line);
        container.add(triangle);
        container.add(rectangle);
        container.draw();

        // create a complex shape
        ComplexShape circle = new Circle();
        container.add(new ShapeAdapter(circle));
        container.draw();
    }
}
