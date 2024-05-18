package com.WebApi.com.MapsApi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingObjectsGame extends JFrame implements ActionListener {
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static final int OBJECT_SIZE = 20;
    private static final int MOVE_SPEED = 3;

    private Timer timer;
    private int obj1X, obj1Y, obj2X, obj2Y, obj3X, obj3Y;
    private int obj1DX, obj1DY, obj2DX, obj2DY, obj3DX, obj3DY;

    public BouncingObjectsGame() {
        setTitle("Bouncing Objects Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        // Initialize object positions
        obj1X = WIDTH / 4;
        obj1Y = HEIGHT / 2;
        obj2X = WIDTH / 2;
        obj2Y = HEIGHT / 4;
        obj3X = 3 * WIDTH / 4;
        obj3Y = HEIGHT / 2;

        // Initialize object velocities
        obj1DX = MOVE_SPEED;
        obj1DY = MOVE_SPEED;
        obj2DX = MOVE_SPEED;
        obj2DY = MOVE_SPEED;
        obj3DX = MOVE_SPEED;
        obj3DY = MOVE_SPEED;

        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Draw objects
        g.setColor(Color.RED);
        g.fillRect(obj1X, obj1Y, OBJECT_SIZE, OBJECT_SIZE);

        g.setColor(Color.GREEN);
        g.fillRect(obj2X, obj2Y, OBJECT_SIZE, OBJECT_SIZE);

        g.setColor(Color.YELLOW);
        g.fillRect(obj3X, obj3Y, OBJECT_SIZE, OBJECT_SIZE);
    }

    public void actionPerformed(ActionEvent e) {
        // Update object positions
        obj1X += obj1DX;
        obj1Y += obj1DY;

        obj2X += obj2DX;
        obj2Y += obj2DY;

        obj3X += obj3DX;
        obj3Y += obj3DY;

        // Check for collisions with the edges
        if (obj1X <= 0 || obj1X >= WIDTH - OBJECT_SIZE) {
            obj1DX *= -1;
        }
        if (obj1Y <= 0 || obj1Y >= HEIGHT - OBJECT_SIZE) {
            obj1DY *= -1;
        }

        if (obj2X <= 0 || obj2X >= WIDTH - OBJECT_SIZE) {
            obj2DX *= -1;
        }
        if (obj2Y <= 0 || obj2Y >= HEIGHT - OBJECT_SIZE) {
            obj2DY *= -1;
        }

        if (obj3X <= 0 || obj3X >= WIDTH - OBJECT_SIZE) {
            obj3DX *= -1;
        }
        if (obj3Y <= 0 || obj3Y >= HEIGHT - OBJECT_SIZE) {
            obj3DY *= -1;
        }

        // Check for collisions between objects and swap them
        if (checkCollision(obj1X, obj1Y, obj2X, obj2Y)) {
            int tempX = obj1DX;
            int tempY = obj1DY;
            obj1DX = obj2DX;
            obj1DY = obj2DY;
            obj2DX = tempX;
            obj2DY = tempY;
        }

        if (checkCollision(obj2X, obj2Y, obj3X, obj3Y)) {
            int tempX = obj2DX;
            int tempY = obj2DY;
            obj2DX = obj3DX;
            obj2DY = obj3DY;
            obj3DX = tempX;
            obj3DY = tempY;
        }

        if (checkCollision(obj3X, obj3Y, obj1X, obj1Y)) {
            int tempX = obj3DX;
            int tempY = obj3DY;
            obj3DX = obj1DX;
            obj3DY = obj1DY;
            obj1DX = tempX;
            obj1DY = tempY;
        }

        repaint();
    }

    private boolean checkCollision(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        int distanceSquared = dx * dx + dy * dy;
        return distanceSquared <= OBJECT_SIZE * OBJECT_SIZE;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BouncingObjectsGame::new);
    }
}
