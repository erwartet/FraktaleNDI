package de.paulschnell.fraktale;

import java.awt.*;

public class IgelInt extends Igel {

    public IgelInt(Canvas canvas) {
        super(canvas);
    }

    public void vor(int laenge) {
        int dx = x + (int) (laenge * Math.sin(b));
        int dy = y - (int) (laenge * Math.cos(b));
        Graphics stift = canvas.getGraphics();
        stift.drawLine(x, y, dx, dy);
        x = dx;
        y = dy;
    }
}
