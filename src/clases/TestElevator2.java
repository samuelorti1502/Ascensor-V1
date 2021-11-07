package clases;

import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

/**
 *
 * @author Samuel David Ortiz
 */
public class TestElevator2 extends Thread {

    private int pisoActual;
    private int desPiso = 1;
    private final int maxPiso = 9;
    private final int minPiso = 1;
    private boolean puertas = false;
    String[] txtlbl;

    JToggleButton boton;
    JLabel lblPlanel;
    JLabel lblElevador;
    ArrayList<JToggleButton> controlList;
    ArrayList<JLabel> elevatorList;

    private ImageIcon Img;
    private Icon icono;

    public TestElevator2(JToggleButton boton, JLabel lblPlanel, JLabel lblElevador, ArrayList<JToggleButton> controlList, ArrayList<JLabel> elevatorList) {
        this.boton = boton;
        this.lblPlanel = lblPlanel;
        this.lblElevador = lblElevador;
        this.controlList = controlList;
        this.elevatorList = elevatorList;
        
        txtlbl = lblPlanel.getText().split(" ");
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
            label.setText("Nivel " + pisoActual);
            espera(1000);
        }
        //return pisoActual;
    }

    public void abajo(JLabel label) {
        int pisoA = Integer.valueOf(txtlbl[1]);
        while (pisoA-- > desPiso) {
            mostrar("Abajo..... Piso actual : " + pisoA);
            label.setText("Nivel " + pisoA);
            espera(1000);
        }
    }

    public void pisoDeseado(JToggleButton boton, JLabel lblPlanel, JLabel lblElevador, ArrayList<JToggleButton> controlList,
            ArrayList<JLabel> elevatorList) {

        System.out.println("Piso actual " + pisoActual);
        
        System.out.println("Nivel " + txtlbl[1]);

        Img = new ImageIcon(getClass().getResource("/images/close.png"));
        icono = new ImageIcon(Img.getImage().getScaledInstance(80, 80,
                Image.SCALE_DEFAULT));

        int piso;

        //Elevador elevador = new Elevador();
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
        if (desPiso < minPiso || desPiso > maxPiso || desPiso == Integer.valueOf(txtlbl[1])) {
            mostrar("Error");
            pisoDeseado(boton, lblPlanel, lblElevador, controlList, elevatorList);
        } else {
            lblElevador = (JLabel) elevatorList.get(0);
            lblElevador.setIcon(icono);
            espera(500);
            mostrar("Cerrando puertas");
            lblElevador.setVisible(false);
            //System.out.println("Puertas " + isPuertas());
            espera(1000);

            /*for (int i = 1; i < desPiso; i++) {
                lblElevador = (JLabel) elevatorList.get(i);
                lblElevador.setIcon(icono);
                espera(500);
            }*/
            if (desPiso < Integer.valueOf(txtlbl[1])) {
                abajo(lblPlanel);
            } else if (desPiso > Integer.valueOf(txtlbl[1])) {
                //label.setText(String.valueOf(arriba()));
                arriba(lblPlanel);
            }
        }
        mostrar("Abriendo puertas");
        System.out.println("piso actual label control " + Integer.valueOf(txtlbl[1]));
        System.out.println("piso Deseado " + desPiso);

        lblElevador = (JLabel) elevatorList.get(desPiso);
        /*lblElevador.setIcon(icono);
        espera(500);*/
        Img = new ImageIcon(getClass().getResource("/images/open.png"));
        icono = new ImageIcon(Img.getImage().getScaledInstance(80, 80,
                Image.SCALE_DEFAULT));

        lblElevador.setIcon(icono);
        espera(1000);

        lblElevador.setVisible(true);

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
    }

    // <editor-fold defaultstate="collapsed" desc="Getter y Setter">
    /**
     * @return the pisoActual
     */
    public int getPisoActual() {
        return pisoActual;
    }

    /**
     * @param pisoActual the pisoActual to set
     */
    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    /**
     * @return the desPiso
     */
    public int getDesPiso() {
        return desPiso;
    }

    /**
     * @param desPiso the desPiso to set
     */
    public void setDesPiso(int desPiso) {
        this.desPiso = desPiso;
    }

    /**
     * @return the maxPiso
     */
    public int getMaxPiso() {
        return maxPiso;
    }

    /**
     * @return the minPiso
     */
    public int getMinPiso() {
        return minPiso;
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

    // </editor-fold>  
    @Override
    public void run() {

        try {
            pisoDeseado(this.boton, this.lblPlanel, this.lblElevador, this.controlList, this.elevatorList);
        } catch (Exception ex) {
            Logger.getLogger(DynamicTxt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
