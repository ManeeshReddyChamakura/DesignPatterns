package com.behavioralpatterns.visitor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Line line = new Line(1, 2, 3, 4);
        Triangle triangle = new Triangle(1, 2, 3, 4, 5, 6);
        Rectangle rectangle = new Rectangle(1, 2, 10, 20);
        Application app = new Application();
        app.add(line);
        app.add(triangle);
        app.add(rectangle);
        app.exportAll();
    }
}

/**
 * defines the common methods for all the shapes
 */
interface Shape {
    public void draw();
    public void fill();
    public void accept(Visitor v);
}


/**
 * Line concrete class contains the implementation for implementing draw and fill and other extra behaviours
 */
class Line implements Shape {
    int x1, y1, x2, y2;

    Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw() {
        System.out.println("drawing a line");
    }

    @Override
    public void fill() {
        System.out.println("filling a line");
    }

    @Override
    public void accept(Visitor v) {
        v.visitLine(this);
    }


}

class Triangle implements Shape {

    int x1, y1, x2, y2, x3, y3;

    Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public void draw() {
        System.out.println("drawing a triangle");
    }

    @Override
    public void fill() {
        System.out.println("filling a triangle");
    }

    @Override
    public void accept(Visitor v) {
        v.visitTriangle(this);
    }
}

class Rectangle implements Shape {

    int x1, y1;
    int width, height;

    Rectangle(int x1, int y1, int width, int height) {
        this.x1 =x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("drawing a Rectangle");
    }

    @Override
    public void fill() {
        System.out.println("filling a Rectangle");
    }

    @Override
    public void accept(Visitor v) {
        v.visitRectangle(this);
    }
}


interface Visitor {
    public void visitLine(Line line);
    public void visitTriangle(Triangle triangle);
    public void visitRectangle(Rectangle rectangle);
}


class ExportVisitor2 {

}
class ExportVisitor implements Visitor {

    @Override
    public void visitLine(Line line) {
        System.out.printf("Exporting line data: (%d, %d) to (%d, %d)", line.x1, line.y1, line.x2, line.y2);
        System.out.println();
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        System.out.printf("Exporting Triangle data: (%d, %d) to (%d, %d) to (%d, %d)", triangle.x1, triangle.y1, triangle.x2, triangle.y2, triangle.x3, triangle.y3);
        System.out.println();
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.printf("Exporting Rectangle data: left corner (%d, %d) with width:%d and height:%d", rectangle.x1, rectangle.y1, rectangle.width, rectangle.height);
        System.out.println();
    }
}

class Application {
    List<Shape> shapes = new ArrayList<>();

    public void add(Shape s) {
        shapes.add(s);
    }

    /**
     * this mechanism is called double dispatch, which means we pass the visitor to the concrete class and then concrete class would redirect the call to
     * the appropriate visitor method
     * (or)
     * one more way of doing this is we can keep a list of conditional which compares the instance type and calls appropriate visitor method
     * In for each loop below
     *  for (Shape s: shapes) {
     *      if (s instanceof Line) {
     *          visitor.exportLine(s);
     *      } else if (s instanceof Triangle) {
     *          visitor.exportTriangle(s);
     *      }
     *      //...
     *  }
     *  Above would also work and we don't even need to change our concrete shape classes(where we implemented accept method)
     *  But as more and more classes get added we would need to increase our conditionals and add one each time.
     *  But rather we've gone with a different approach where we delegate the responsibility of the visit to each concrete shape class as it would be a simple
     *  redirect from the respective method
     *  And if we need to add any extra shape class then it would be simple redirect and we don't need to worry about anything
     */
    public void exportAll() {
        ExportVisitor visitor = new ExportVisitor();
        for (Shape s: shapes) {
            s.accept(visitor);
        }
    }
}