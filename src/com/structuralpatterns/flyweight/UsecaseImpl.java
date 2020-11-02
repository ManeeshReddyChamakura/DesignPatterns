package com.structuralpatterns.flyweight;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Zombie {
    int x;
    int y;
    String name;
    Color color;
    int radius = 10;
    int height;


    public Zombie(int x, int y, String name, Color color, int height) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.color = color;
        this.height = height;
    }

    public void draw(Graphics g) {
        // draw the head
        g.setColor(this.color);
        int centerX = this.x - this.radius, centerY = this.y - this.radius;
        g.fillOval(centerX, centerY, 2*this.radius, 2*this.radius);


        g.setColor(Color.BLACK);
        int stickStartX = this.x, stickStartY = this.y + radius, stickEndX= this.x, stickEndY= this.y + this.radius + this.height;
        g.drawLine(stickStartX, stickStartY, stickEndX, stickEndY);
        // System.out.printf("(%d, %d) to  (%d, %d)\n", this.x, this.y+radius, this.x, this.y+radius+height);

        // calculate coordinates for left hand
        int leftHandStartX= stickStartX, leftHandStartY = stickStartY + this.height/3;
        int leftHandEndX = stickStartX - this.height/3, leftHandEndY = stickStartY + this.height*2/3;
        // System.out.printf("(%d, %d) to  (%d, %d)\n", leftHandStartX, leftHandStartY, leftHandEndX, leftHandEndY);
        g.drawLine(leftHandStartX, leftHandStartY, leftHandEndX, leftHandEndY);

        // calculate coordinates for right hand
        int rightHandStartX= leftHandStartX, rightHandStartY = leftHandStartY;
        int rightHandEndX = stickStartX + this.height/3, rightHandEndY = leftHandEndY;
        // System.out.printf("(%d, %d) to (%d, %d)\n", leftHandStartX, leftHandStartY, leftHandEndX, leftHandEndY);
        g.drawLine(rightHandStartX, rightHandStartY, rightHandEndX, rightHandEndY);


        // calculate coordinates for left leg
        int leftLegStartX= stickEndX, leftLegStartY = stickEndY;
        int leftLegEndX = stickEndX - this.height/3, leftLegEndY = stickEndY + this.height*2/3;
        // System.out.printf("(%d, %d) to  (%d, %d)\n", leftLegStartX, leftLegStartY, leftLegEndX, leftLegEndY);
        g.drawLine(leftLegStartX, leftLegStartY, leftLegEndX, leftLegEndY);

        // calculate coordinates for right leg
        int rightLegStartX= stickEndX, rightLegStartY = stickEndY;
        int rightLegEndX = stickEndX + this.height/3, rightLegEndY = stickEndY + this.height*2/3;
        // System.out.printf("(%d, %d) to  (%d, %d)\n", rightLegStartX, rightLegStartY, rightLegEndX, rightLegEndY);
        g.drawLine(rightLegStartX, rightLegStartY, rightLegEndX, rightLegEndY);
    }
}


class DrawZombie extends JFrame {

    static java.util.List<Zombie> zombies = new java.util.ArrayList<>();

    public void createZombie(int x, int y, String name, Color color, int height) {
        Zombie zombie = new Zombie(x, y, name, color, height);
        zombies.add(zombie);
    }

    @Override
    public synchronized void paint(Graphics g) {
        int len = zombies.size();
        for (int i=0; i<len; i++) {
            Zombie zombie = zombies.get(i);
            zombie.draw(g);
        }
    }

}

public class UsecaseImpl {
    public static final int CANVAS_SIZE = 1000;
    public static int MAX_HEIGHT = 100, MIN_HEIGHT= 30;
    public static int MIN_X =30, MAX_X = CANVAS_SIZE - 100;
    public static int MIN_Y = 30, MAX_Y = CANVAS_SIZE - 100;
    static java.util.Random random = new java.util.Random();
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        DrawZombie shapes = new DrawZombie();
        JButton b=new JButton("Click Me..");
        /* This method specifies the location and size
         * of button. In method setBounds(x, y, width, height)
         * x,y) are cordinates from the top left
         * corner and remaining two arguments are the width
         * and height of the button.
         */
        b.setBounds(50,50,90, 50);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime runtime = Runtime.getRuntime();
                runtime.gc();
                long bytes = runtime.totalMemory() - runtime.freeMemory();
                System.out.println("Space used in bytes:" + bytes);
                System.out.println("Space used in Mb:"+ bytesToMegaBytes(bytes));
            }
        });

        //Adding button onto the frame
        shapes.add(b);
        shapes.setLayout(null);
        // set the dimensions of the window
        shapes.setSize(new Dimension(CANVAS_SIZE, CANVAS_SIZE));
        // to terminate the program
        shapes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the visiblity of the frame
        shapes.setVisible(true);
        // set resizeable to false
        shapes.setResizable(false);

        Color[] colors = { Color.GRAY, Color.RED, Color.CYAN, Color.GREEN };

        String[] names = {"THIN", "LEAN", "STRONG", "HULK"};


        for (int i=0; i<1000000; i++){
            int x = random.nextInt(colors.length);
            shapes.createZombie(getRandomX(), getRandomY(), names[x], colors[x], getRandomHeight());
        }

        // runtime.gc();

        // long bytes = runtime.totalMemory() - runtime.freeMemory();
        // System.out.println("Space used in bytes:" + bytes);
        // System.out.println("Space used in Mb:"+ bytesToMegaBytes(bytes));

    }

    public static long bytesToMegaBytes(long bytes) {
        return (bytes)/(1024 * 1024);
    }

    public static int getRandomHeight() {
        return random.nextInt(MAX_HEIGHT - MIN_HEIGHT + 1) + MIN_HEIGHT;
    }

    public static int getRandomX() {
        return random.nextInt(MAX_X - MIN_X + 1) + MIN_X;
    }

    public static int getRandomY() {
        return random.nextInt(MAX_Y - MIN_Y + 1) + MIN_Y;
    }

    public static int getRandomColorInt() {
        return random.nextInt(256);
    }
}
