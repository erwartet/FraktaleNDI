package de.paulschnell.fraktale;

import java.awt.*;

public abstract class Igel {


    protected Canvas canvas;
    protected int x = 0;
    protected int y = 0;
    protected int phi = 0;
    protected double b = 0;
    public Igel(Canvas canvas) {
        this.canvas = canvas;
    }

    public abstract void vor(int laenge);

    public void setColor(Color color) {
        Graphics graphics = canvas.getGraphics();
        graphics.setColor(color);
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPhi(int phi) {
        this.phi = phi;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void nEck(int n, int laenge) {
        for (int i = 0; i < n; i++) {
            vor(laenge);
            rechts(360 / n);
        }
    }

    public void rechts(int winkel) {
        phi = phi + winkel;
        b = Math.PI * phi / 180;
    }

}
