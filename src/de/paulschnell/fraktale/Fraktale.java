package de.paulschnell.fraktale;

public class Fraktale {

    private Igel igel;

    public Fraktale(Igel igel) {
        this.igel = igel;
    }

    private void koch(int k) {
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


    public void dreieck(int k) {

    }

    public void sierpinski(int k) {

    }

}
