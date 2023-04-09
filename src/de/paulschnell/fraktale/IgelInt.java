package de.paulschnell.fraktale;

import java.awt.*;

public class IgelInt extends Igel {

    public IgelInt(Canvas canvas) {
        super(canvas);
    }

    public void vor(double laenge) {
        int dx = (int) x + (int) (laenge * Math.sin(b));
        int dy = (int) y - (int) (laenge * Math.cos(b));
        Graphics stift = canvas.getGraphics();
        stift.setColor(new Color(1.0f, 0.3435f, 0.0f));
        stift.drawLine((int) x, (int) y, dx, dy);
        x = dx;
        y = dy;

        try {
            Thread.sleep(v);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
