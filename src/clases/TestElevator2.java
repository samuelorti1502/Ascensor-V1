package clases;

import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/**
 *
 * @author Samuel David Ortiz
 */
public class TestElevator2 extends Thread {

    private int pisoActual;
    private int desPiso = 1;
    private final int maxPiso = 9;
    private final int minPiso = 0;
    private boolean puertas = false;
    String[] txtlbl;

    JToggleButton boton;
    JLabel lblPlanel;
    JLabel lblElevador;
    ArrayList<JToggleButton> controlList;
    ArrayList<JLabel> elevatorList;

    private ImageIcon Img;
    private Icon icono;

    SoundClass soundsT;

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
        int pisoA = Integer.valueOf(txtlbl[1]);
        pisoActual = pisoA;
        
        lblElevador.setLocation(5, 5);
        Img = new ImageIcon(getClass().getResource("/images/close.png"));
        icono = new ImageIcon(Img.getImage().getScaledInstance(70, 70,
                Image.SCALE_DEFAULT));
        
        lblElevador.setIcon(null);
        
        while (pisoActual++ < desPiso) {
            mostrar("Arriba..... Piso actual : " + pisoActual);
            label.setText("Nivel " + pisoActual);

            soundsT = new SoundClass();
            soundsT.tiposonido(2);

            lblElevador = (JLabel) elevatorList.get(pisoActual);
            
            lblElevador.setIcon(icono);
            lblElevador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblElevador.setVisible(true);

            try {
                soundsT.start();
            } catch (IllegalThreadStateException e) {
                System.out.println("e = " + e.toString());
            }

            espera(2000);
            if (pisoActual == desPiso) {
                lblElevador.setVisible(true);
            } else {
                lblElevador.setVisible(false);
            }

            soundsT.interrupt();

            //espera(1000);
        }

        //System.out.println("Has llegado a tu destino");
    }

    public void abajo(JLabel label) {
        int pisoA = Integer.valueOf(txtlbl[1]);

        Img = new ImageIcon(getClass().getResource("/images/close.png"));
        icono = new ImageIcon(Img.getImage().getScaledInstance(70, 70,
                Image.SCALE_DEFAULT));

        while (pisoA-- > desPiso) {
            mostrar("Abajo..... Piso actual : " + pisoA);
            label.setText("Nivel " + pisoA);

            soundsT = new SoundClass();
            soundsT.tiposonido(2);

            lblElevador = (JLabel) elevatorList.get(pisoA);
            lblElevador.setIcon(icono);
            lblElevador.setVisible(true);

            try {
                soundsT.start();
            } catch (IllegalThreadStateException e) {
                System.out.println("e = " + e.toString());
            }

            espera(2000);

            if (pisoA == desPiso) {
                lblElevador.setVisible(true);
            } else {
                lblElevador.setVisible(false);
            }

            soundsT.interrupt();
        }
    }

    public void pisoDeseado(JToggleButton boton, JLabel lblPlanel, JLabel lblElevador, ArrayList<JToggleButton> controlList,
            ArrayList<JLabel> elevatorList) {
        
        lblElevador.setVisible(false);
        //System.out.println("Piso actual " + pisoActual);
        //System.out.println("Nivel " + txtlbl[1]);
        Img = new ImageIcon(getClass().getResource("/images/close.png"));
        icono = new ImageIcon(Img.getImage().getScaledInstance(70, 70,
                Image.SCALE_DEFAULT));

        int piso;
        int lblAc = Integer.valueOf(txtlbl[1]);
        String btn = boton.getText();

        System.out.println("boton.getText() = " + btn);
        switch (btn) {
            case "S":
                piso = 0;
                break;
            case "L":
                piso = 1;
                break;
            case "BOSS":
                piso = 8;
                break;
            default:
                piso = Integer.valueOf(btn);
                break;
        }

        setDesPiso(piso);
        if (desPiso < minPiso || desPiso > maxPiso || desPiso == lblAc) {
            mostrar("Error");
            pisoDeseado(boton, lblPlanel, lblElevador, controlList, elevatorList);
        } else {
            lblElevador = (JLabel) elevatorList.get(lblAc);
            lblElevador.setIcon(icono);

            try {
                soundsT = new SoundClass();
                soundsT.tiposonido(0);
                soundsT.start();
                //espera(2000);
            } catch (IllegalThreadStateException e) {
                System.out.println("e = " + e.toString());
            }

            espera(2000);
            mostrar("Cerrando puertas");
            lblElevador.setVisible(false);
            espera(1000);

            /*for (int i = 1; i < desPiso; i++) {
                lblElevador = (JLabel) elevatorList.get(i);
                lblElevador.setIcon(icono);
                espera(500);
            }*/
            if (desPiso < lblAc) {
                abajo(lblPlanel);

                soundsT = new SoundClass();
                soundsT.tiposonido(0);

                try {
                    soundsT.start();
                    espera(2000);
                } catch (IllegalThreadStateException e) {
                    System.out.println("e = " + e.toString());
                }

            } else if (desPiso > lblAc) {
                //label.setText(String.valueOf(arriba()));

                arriba(lblPlanel);
                soundsT = new SoundClass();
                soundsT.tiposonido(0);

                try {
                    soundsT.start();
                    espera(2000);
                } catch (IllegalThreadStateException e) {
                    System.out.println("e = " + e.toString());
                }

                //lblElevador.setVisible(true);
            }
        }
        mostrar("Abriendo puertas");
        /*System.out.println("piso actual label control " + lblAc);
        System.out.println("piso Deseado " + desPiso);*/

        lblElevador = (JLabel) elevatorList.get(desPiso);
        /*lblElevador.setIcon(icono);
        espera(500);*/
        Img = new ImageIcon(getClass().getResource("/images/open.png"));
        icono = new ImageIcon(Img.getImage().getScaledInstance(70, 70,
                Image.SCALE_DEFAULT));

        lblElevador.setIcon(icono);
        //espera(1000);

        lblElevador.setVisible(true);

        for (int i = 0; i < 5; i++) {

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
            Logger.getLogger(TestElevator2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
