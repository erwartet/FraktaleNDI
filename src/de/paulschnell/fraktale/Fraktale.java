package de.paulschnell.fraktale;

public class Fraktale {

    private Igel igel;

    public Fraktale() {
        this.igel = null;
    }

    public void setIgel(Igel igel) {
        this.igel = igel;
    }

    public void koch(int k) {
        if (k > 10) {
            koch(k / 3);
            igel.rechts(-60);
            koch(k / 3);
            igel.rechts(120);
            koch(k / 3);
            igel.rechts(-60);
            koch(k / 3);
        } else {
            igel.vor(k * 3);
        }
    }

    public void kochFlocke(int k) {
        koch(k);
        igel.rechts(120);
        koch(k);
        igel.rechts(120);
        koch(k);
    }


    public void dreieck(double k) {
        igel.rechts(30);
        igel.vor(k);
        igel.rechts(120);
        igel.vor(k);
        igel.rechts(120);
        igel.vor(k);
        igel.rechts(90);
    }

    public void sierpinski(double k, int tiefe) {
        if (k > tiefe) {
            sierpinski(k / 2, tiefe);
            igel.rechts(30);
            igel.vor(k / 2);
            igel.rechts(-30);
            sierpinski(k / 2, tiefe);
            igel.rechts(150);
            igel.vor(k / 2);
            igel.rechts(-150);
            sierpinski(k / 2, tiefe);
            igel.rechts(-90);
            igel.vor(k / 2);
            igel.rechts(90);
        } else {
            dreieck(k);
        }
    }


    public void quadrat(double c) {
        igel.vor(c);
        igel.rechts(90);
        igel.vor(c);
        igel.rechts(90);
        igel.vor(c);
        igel.rechts(90);
        igel.vor(c);
        igel.rechts(90);
        igel.vor(c);
    }

    public void pythagoras(double c, double alpha) {
        double beta = 90 - alpha;
        double a = Math.abs(c * Math.sin(alpha * Math.PI / 180));
        double b = Math.abs(c * Math.cos(alpha * Math.PI / 180));

        if (c > 3) {
            quadrat(c);

            igel.rechts(-alpha);
            pythagoras(b, alpha);

            igel.rechts(90);
            igel.vor(b);
            igel.rechts(90);
            igel.vor(b);
            igel.rechts(-90);

            pythagoras(a, alpha);

            igel.rechts(180);
            igel.vor(a + b);
            igel.rechts(90 + alpha);
        } else {
            quadrat(c);
        }
    }

    //    public void pythagoras(double c, int winkel2) {
    //        int w1 = winkel2;
    //        int w2 = 90 - winkel2;
    //
    //        double a = (c * Math.cos(w1 * Math.PI / 180));
    //        double b = (c * Math.sin(w1 * Math.PI / 180));
    //
    //        if (c > Math.PI * 3) {
    //            quadrat(c);
    //
    //
    //            igel.rechts(-w1);
    //            pythagoras(b, winkel2);
    //
    //
    //            igel.rechts(90);
    //            igel.vor(b);
    //            igel.rechts(90);
    //            igel.vor(b);
    //            igel.rechts(-90);
    //
    //
    //            pythagoras(a, winkel2);
    //
    //
    //            igel.rechts(180);
    //            igel.vor(a + b);
    //            igel.rechts(90 + w2);
    //
    //
    //        } else {
    //            quadrat(c);
    //        }
    //    }

    public int gausscheSumme(int n) {
        if (n == 0) {
            return 1;
        } else {
            return gausscheSumme(n - 1) + n;
        }
    }

}
