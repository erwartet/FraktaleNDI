package de.paulschnell.fraktale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Zeichenfenster extends JFrame {

    private final Canvas canvas;
    private final JPanel contentPane;
    private final JCheckBox chbxWiederhohlt;
    private final JCheckBox chbxGenauerIgel;
    private final JSlider sliderGeschwindigkeit;
    private final JSlider sliderTiefe;
    private final JLabel lblTiefeZahl;

    private Igel igel;
    private Fraktale fraktale;

    /**
     * Create the frame.
     */
    public Zeichenfenster() {
        setTitle("Fraktale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 820, 582);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        canvas = new Canvas();
        canvas.setBackground(Color.WHITE);
        canvas.setBounds(10, 10, 523, 523);
        contentPane.add(canvas);

        chbxWiederhohlt = new JCheckBox("Wiederhohlt");
        chbxWiederhohlt.setBounds(539, 374, 113, 35);
        contentPane.add(chbxWiederhohlt);

        Choice chAuswahl = new Choice();
        chAuswahl.add("Koch Flocke");
        chAuswahl.add("Sirpinski Dreieck");
        chAuswahl.add("Pythagoras Baum");
        chAuswahl.setBounds(539, 10, 255, 202);
        contentPane.add(chAuswahl);

        Button btnStart = new Button("Start");
        btnStart.addActionListener(e -> {
            fraktale = new Fraktale(igel);
            switch (chAuswahl.getSelectedIndex()) {
                case 0:
                    fraktale.kochFlocke(30);
                    break;
                case 1:
                    fraktale.sierpinski(100);
                    break;
                case 2:
                    fraktale.pythagoras(120, 30);
                    break;
                default:
                    break;
            }
        });
        btnStart.setForeground(new Color(255, 255, 255));
        btnStart.setBackground(new Color(0, 100, 0));
        btnStart.setBounds(539, 415, 255, 56);
        contentPane.add(btnStart);

        Button btnLoeschen = new Button("Löschen");
        btnLoeschen.addActionListener(e -> {
            Graphics graphics = canvas.getGraphics();
            graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            resetIgel();
        });
        btnLoeschen.setForeground(new Color(255, 255, 255));
        btnLoeschen.setBackground(new Color(139, 0, 0));
        btnLoeschen.setBounds(539, 477, 255, 56);
        contentPane.add(btnLoeschen);

        chbxGenauerIgel = new JCheckBox("Genauer Igel");
        chbxGenauerIgel.addActionListener(e -> {
            if (chbxGenauerIgel.isSelected()) {

            } else {
                igel = new IgelInt(canvas);
            }
            resetIgel();
        });
        chbxGenauerIgel.setBounds(539, 336, 113, 35);
        contentPane.add(chbxGenauerIgel);

        sliderGeschwindigkeit = new JSlider();
        sliderGeschwindigkeit.setValue(100);
        sliderGeschwindigkeit.setBounds(539, 303, 255, 26);
        contentPane.add(sliderGeschwindigkeit);

        JLabel lblGeschwindigkeit = new JLabel("Geschwindigkeit");
        lblGeschwindigkeit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGeschwindigkeit.setBounds(539, 287, 142, 20);
        contentPane.add(lblGeschwindigkeit);

        sliderTiefe = new JSlider();
        sliderTiefe.setValue(100);
        sliderTiefe.setBounds(539, 225, 255, 26);
        contentPane.add(sliderTiefe);

        JLabel lblTiefe = new JLabel("Tiefe");
        lblTiefe.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTiefe.setBounds(541, 209, 142, 20);
        contentPane.add(lblTiefe);

        lblTiefeZahl = new JLabel("100");
        lblTiefeZahl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTiefeZahl.setBounds(747, 205, 47, 26);
        contentPane.add(lblTiefeZahl);

        igel = new IgelInt(canvas);
        resetIgel();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Zeichenfenster frame = new Zeichenfenster();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void resetIgel() {
        igel.setX(canvas.getWidth() / 4);
        igel.setY(canvas.getHeight() - canvas.getHeight() / 4);
        igel.setPhi(0);
        igel.setB(0);
    }

}
