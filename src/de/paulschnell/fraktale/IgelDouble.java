package de.paulschnell.fraktale;

import java.awt.*;
import java.awt.geom.Line2D;

public class IgelDouble extends Igel {

    public IgelDouble(Canvas canvas) {
        super(canvas);
    }

    public void vor(double laenge) {
        Graphics stift = canvas.getGraphics();
        Graphics2D graphics = (Graphics2D) stift;
        graphics.setColor(new Color(1.0f, 0.3435f, 0.0f));

        double dx = x + laenge * Math.sin(b);
        double dy = y - laenge * Math.cos(b);
        graphics.draw(new Line2D.Double(x, y, dx, dy));

        //        graphics.draw(new Line2D.Double( x + 1, y + 1, xe + 1, ye + 1));
        //        graphics.draw(new Line2D.Double(x + 1, y - 1, xe + 1, ye - 1));

        x = dx;
        y = dy;

        try {
            Thread.sleep(v);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
