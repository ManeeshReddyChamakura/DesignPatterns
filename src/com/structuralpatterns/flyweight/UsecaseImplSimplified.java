package com.structuralpatterns.flyweight;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

class RealZombie {
    int x;
    int y;
    int height;
    final ZombieType type;

    public RealZombie(int x, int y, ZombieType type, int height) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.height = height;
    }

    public synchronized void draw(Graphics g) {
        type.draw(g, x, y, height);
    }

}

class ZombieType {
    private String name;
    private Color color;
    private Color stickcolor;
    int radius = 10;

    public ZombieType(String name, Color color, Color stickcolor) {
        this.name = name;
        this.color = color;
        this.stickcolor = stickcolor;
    }

    public synchronized void draw(Graphics g, int x, int y, int height) {
        // draw the head
        g.setColor(this.color);
        int centerX = x - this.radius, centerY = y - this.radius;
        g.fillOval(centerX, centerY, 2*this.radius, 2*this.radius);


        g.setColor(Color.BLACK);
        int stickStartX = x, stickStartY = y + radius, stickEndX= x, stickEndY= y + this.radius + height;
        g.drawLine(stickStartX, stickStartY, stickEndX, stickEndY);
        // System.out.printf("(%d, %d) to  (%d, %d)\n", this.x, this.y+radius, this.x, this.y+radius+height);

        // calculate coordinates for left hand
        int leftHandStartX= stickStartX, leftHandStartY = stickStartY + height/3;
        int leftHandEndX = stickStartX - height/3, leftHandEndY = stickStartY + height*2/3;
        // System.out.printf("(%d, %d) to  (%d, %d)\n", leftHandStartX, leftHandStartY, leftHandEndX, leftHandEndY);
        g.drawLine(leftHandStartX, leftHandStartY, leftHandEndX, leftHandEndY);

        // calculate coordinates for right hand
        int rightHandStartX= leftHandStartX, rightHandStartY = leftHandStartY;
        int rightHandEndX = stickStartX + height/3, rightHandEndY = leftHandEndY;
        // System.out.printf("(%d, %d) to (%d, %d)\n", leftHandStartX, leftHandStartY, leftHandEndX, leftHandEndY);
        g.drawLine(rightHandStartX, rightHandStartY, rightHandEndX, rightHandEndY);


        // calculate coordinates for left leg
        int leftLegStartX= stickEndX, leftLegStartY = stickEndY;
        int leftLegEndX = stickEndX - height/3, leftLegEndY = stickEndY + height*2/3;
        // System.out.printf("(%d, %d) to  (%d, %d)\n", leftLegStartX, leftLegStartY, leftLegEndX, leftLegEndY);
        g.drawLine(leftLegStartX, leftLegStartY, leftLegEndX, leftLegEndY);

        // calculate coordinates for right leg
        int rightLegStartX= stickEndX, rightLegStartY = stickEndY;
        int rightLegEndX = stickEndX + height/3, rightLegEndY = stickEndY + height*2/3;
        // System.out.printf("(%d, %d) to  (%d, %d)\n", rightLegStartX, rightLegStartY, rightLegEndX, rightLegEndY);
        g.drawLine(rightLegStartX, rightLegStartY, rightLegEndX, rightLegEndY);
    }
}



class ZombieFactory {
    static Map<String, ZombieType> zombieTypes = new HashMap<>();

    public synchronized static ZombieType getZombieType(String name, Color color, Color stickcolor) {
        ZombieType zombie = zombieTypes.get(name);
        if (zombie == null) {
            zombie = new ZombieType(name, color, stickcolor);
            zombieTypes.put(name, zombie);
        }
        return zombie;
    }
}

class DrawRealZombie extends JFrame {

    static java.util.List<RealZombie> zombies = new java.util.ArrayList<>();

    public synchronized void createZombie(int x, int y, String name, Color color, Color stickcolor, int height) {
        ZombieType zombietype = ZombieFactory.getZombieType(name, color, stickcolor);
        RealZombie zombie = new RealZombie(x, y, zombietype, height);
        zombies.add(zombie);
    }

    @Override
    public synchronized void paint(Graphics g) {
        int len = zombies.size();
        for (int i=0; i<len; i++) {
            RealZombie zombie = zombies.get(i);
            zombie.draw(g);
        }
    }

}

public class UsecaseImplSimplified {
    public static final int CANVAS_SIZE = 1000;
    public static int MAX_HEIGHT = 100, MIN_HEIGHT= 30;
    public static int MIN_X =30, MAX_X = CANVAS_SIZE - 100;
    public static int MIN_Y = 30, MAX_Y = CANVAS_SIZE - 100;
    static java.util.Random random = new java.util.Random();
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        DrawRealZombie shapes = new DrawRealZombie();
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


        // in our game example zombies would have few colors only
        // for random colors new Color(getRandomColorInt(), getRandomColorInt(), getRandomColorInt())
        Color[] colors = { Color.GRAY, Color.RED, Color.CYAN, Color.GREEN };

        String[] names = {"THIN", "LEAN", "STRONG", "HULK"};


        int zombiesCount = 1000000;
        for (int i=0; i<zombiesCount; i++){
            int x = random.nextInt(colors.length);
            shapes.createZombie(getRandomX(), getRandomY(), names[x], colors[x], Color.BLACK, getRandomHeight());
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
