package de.paulschnell.fraktale;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Zeichenfenster extends JFrame {

    private final Canvas canvas;
    private final JPanel contentPane;
    private final Choice chAuswahl;
    private final JCheckBox chbxGenauerIgel;
    private final JSlider sliderGeschwindigkeit;
    private final JSlider sliderTiefe;
    private JLabel lblTiefeZahl = null;
    private JTextField tfWinkel;

    private Igel igel;
    private Fraktale fraktale;

    private int tiefe = 100;
    private int geschwindigkeit = 0;

    /**
     * Create the frame.
     */
    public Zeichenfenster() {
        setTitle("Fraktale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1306, 774);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        canvas = new Canvas();
        canvas.setBackground(Color.WHITE);
        canvas.setBounds(10, 10, 992, 720);
        contentPane.add(canvas);

        chAuswahl = new Choice();
        chAuswahl.add("Koch Flocke");
        chAuswahl.add("Koch");
        chAuswahl.add("Sirpinski Dreieck");
        chAuswahl.add("Pythagoras Baum");
        chAuswahl.setBounds(1020, 10, 255, 202);
        contentPane.add(chAuswahl);

        Button btnStart = new Button("Start");
        btnStart.addActionListener(e -> {
            switch (chAuswahl.getSelectedIndex()) {
                case 0 -> fraktale.kochFlocke(tiefe * 3 / 2);
                case 1 -> {
                    igel.rechts(90);
                    fraktale.koch(tiefe * 2);
                }
                case 2 -> fraktale.sierpinski(500, tiefe * 4 + 1);
                case 3 -> {
                    igel.setX((double) (canvas.getWidth() / 2));
                    int winkel = Integer.parseInt(tfWinkel.getText());
                    fraktale.pythagoras(tiefe, winkel);
                }
            }
        });
        btnStart.setForeground(new Color(255, 255, 255));
        btnStart.setBackground(new Color(0, 100, 0));
        btnStart.setBounds(1020, 612, 255, 56);
        contentPane.add(btnStart);

        Button btnLoeschen = new Button("Löschen");
        btnLoeschen.addActionListener(e -> {
            Graphics graphics = canvas.getGraphics();
            graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            resetIgel();
        });
        btnLoeschen.setForeground(new Color(255, 255, 255));
        btnLoeschen.setBackground(new Color(139, 0, 0));
        btnLoeschen.setBounds(1020, 674, 255, 56);
        contentPane.add(btnLoeschen);

        chbxGenauerIgel = new JCheckBox("Genauer Igel");
        chbxGenauerIgel.setSelected(true);
        chbxGenauerIgel.addActionListener(e -> {
            if (chbxGenauerIgel.isSelected()) {
                igel = new IgelDouble(canvas);
            } else {
                igel = new IgelInt(canvas);
            }
            resetIgel();
        });
        chbxGenauerIgel.setBounds(1025, 571, 113, 35);
        contentPane.add(chbxGenauerIgel);

        sliderGeschwindigkeit = new JSlider();
        sliderGeschwindigkeit.addChangeListener(e -> {
            geschwindigkeit = (100 - sliderGeschwindigkeit.getValue()) * 2;
        });
        sliderGeschwindigkeit.setValue(100);
        sliderGeschwindigkeit.setMaximum(100);
        sliderGeschwindigkeit.setBounds(1025, 538, 255, 26);
        contentPane.add(sliderGeschwindigkeit);

        JLabel lblGeschwindigkeit = new JLabel("Geschwindigkeit");
        lblGeschwindigkeit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGeschwindigkeit.setBounds(1025, 522, 142, 20);
        contentPane.add(lblGeschwindigkeit);

        lblTiefeZahl = new JLabel("100");
        lblTiefeZahl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTiefeZahl.setBounds(1229, 440, 46, 19);
        lblTiefeZahl.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblTiefeZahl);

        sliderTiefe = new JSlider();
        sliderTiefe.addChangeListener(e -> {
            tiefe = sliderTiefe.getValue();
            lblTiefeZahl.setText(Integer.toString(tiefe));
        });
        sliderTiefe.setValue(100);
        sliderTiefe.setMaximum(100);
        sliderTiefe.setBounds(1025, 460, 255, 26);
        contentPane.add(sliderTiefe);

        JLabel lblTiefe = new JLabel("Tiefe");
        lblTiefe.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTiefe.setBounds(1027, 444, 142, 20);
        contentPane.add(lblTiefe);

        tfWinkel = new JTextField("35");
        tfWinkel.setBounds(1081, 389, 86, 20);
        contentPane.add(tfWinkel);
        tfWinkel.setColumns(10);

        JLabel lblWinkel = new JLabel("Winkel:");
        lblWinkel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWinkel.setBounds(1025, 387, 142, 20);
        contentPane.add(lblWinkel);

        fraktale = new Fraktale();
        igel = new IgelDouble(canvas);
        resetIgel();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Zeichenfenster frame = new Zeichenfenster();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void resetIgel() {
        igel.setX(canvas.getWidth() / 3);
        igel.setY(canvas.getHeight() - canvas.getHeight() / 4);
        igel.setPhi(0);
        igel.setB(0);
        igel.setV(geschwindigkeit);
        fraktale.setIgel(igel);
    }

}
