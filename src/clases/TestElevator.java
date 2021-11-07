package clases;

import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author Samuel David Ortiz
 */
public class TestElevator extends Thread{

    private int pisoActual = 1;
    private int desPiso = 1;
    private final int maxPiso = 9;
    private final int minPiso = 1;
    private boolean puertas = false;

    private ImageIcon Img;
    private Icon icono;

    public void mostrarPiso(Object a, JLabel piso) {
        piso.setText("Nivel " + String.valueOf(a));
    }

    void mostrar(Object o) {
        System.out.println(o);
    }

    public void espera(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
        }
    }

    public void arriba(JLabel label) {
        while (pisoActual++ < desPiso) {
            mostrar("Arriba..... Piso actual : " + pisoActual);
            //label.setText(String.valueOf(pisoActual));
            //System.out.println("label = " + label.getText());
            label.setText("Arriba..... Piso actual : " + pisoActual);
            espera(1000);
        }
        //return pisoActual;
    }

    public void abajo() {
        while (pisoActual-- > desPiso) {
            mostrar("Abajo..... Piso actual : " + pisoActual);
            espera(1000);
        }
    }

    public void pisoDeseado(JToggleButton boton, JLabel label, ArrayList<JToggleButton> controlList) {
        //System.out.print("Ingrese el piso al que desea ir: ");
        //desPiso = Integer.valueOf(texto.getText());

        Img = new ImageIcon(getClass().getResource("/images/close.png"));
        icono = new ImageIcon(Img.getImage().getScaledInstance(140, 140,
                Image.SCALE_DEFAULT));

        System.out.println("Piso " + boton.getText());
        int piso;

        Elevador elevador = new Elevador();

        switch (boton.getText()) {
            case "S":
                piso = 0;
                break;
            case "L":
                piso = 1;
                break;
            default:
                piso = Integer.valueOf(boton.getText());
        }

        setDesPiso(piso);
        if (desPiso < minPiso || desPiso > maxPiso || desPiso == pisoActual) {
            mostrar("Error");
            pisoDeseado(boton, label, controlList);
        } else {
            //JLabel lbl = (JLabel) elevatorList.get(0);
            mostrar("Cerrando puertas");
            elevador.start();
            setPuertas(false);
            System.out.println("Puertas " + isPuertas());
            espera(1000);
            if (desPiso < pisoActual) {
                abajo();
            } else if (desPiso > pisoActual) {
                //label.setText(String.valueOf(arriba()));
                arriba(label);
            }
        }
        setPuertas(true);
        System.out.println("Puertas " + isPuertas());
        mostrar("Abriendo puertas");

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 2; j++) {
                JToggleButton jc = (JToggleButton) controlList.get(j + (2 * i));
                if (jc.isSelected()) {
                    jc.setSelected(false);
                } else {
                    jc.setSelected(false);
                }
            }
        }
        //pisoDeseado(boton, label);
    }

    public void imagen(ImageIcon Img, Icon icono, JLabel o) {
        Img = new ImageIcon(getClass().getResource("/images/umg.png"));
        icono = new ImageIcon(Img.getImage().getScaledInstance(140, 140,
                Image.SCALE_DEFAULT));

        o.setIcon(icono);
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public int getDesPiso() {
        return desPiso;
    }

    public void setDesPiso(int desPiso) {
        this.desPiso = desPiso;
    }

    /**
     * @return the puertas
     */
    public boolean isPuertas() {
        return puertas;
    }

    /**
     * @param puertas the puertas to set
     */
    public void setPuertas(boolean puertas) {
        this.puertas = puertas;
    }
}

    class Elevador extends Thread {

        @Override
        public void run() {
            TestElevator testElevator = new TestElevator();

        }
    }
