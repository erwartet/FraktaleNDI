package de.paulschnell.fraktale;

import java.awt.*;

public abstract class Igel {


    protected Canvas canvas;
    protected double x = 0;
    protected double y = 0;
    protected double phi = 0;
    protected double b = 0;
    protected int v = 0;

    public Igel(Canvas canvas) {
        this.canvas = canvas;
    }

    public abstract void vor(double laenge);

    public void setColor(Color color) {
        Graphics graphics = canvas.getGraphics();
        graphics.setColor(color);
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void nEck(int n, int laenge) {
        for (int i = 0; i < n; i++) {
            vor(laenge);
            rechts(360 / n);
        }
    }

    public void rechts(double winkel) {
        phi = phi + winkel;
        b = Math.PI * phi / 180;
    }

}
