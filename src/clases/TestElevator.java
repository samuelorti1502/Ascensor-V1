package clases;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Samuel David Ortiz
 */
public class TestElevator {

    private int pisoActual = 1;
    private int desPiso = 1;
    private final int maxPiso = 9;
    private final int minPiso = 1;

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

    public void arriba() {
        while (pisoActual++ < desPiso) {
            mostrar("Arriba..... Piso actual : " + pisoActual);
            espera(1000);
        }
    }

    public void abajo() {
        while (pisoActual-- < desPiso) {
            mostrar("Abajo..... Piso actual : " + pisoActual);
            espera(1000);
        }
    }

    public void pisoDeseado(JTextField texto) {
        //System.out.print("Ingrese el piso al que desea ir: ");
        desPiso = Integer.valueOf(texto.getText());
        if (desPiso < minPiso || desPiso > maxPiso || desPiso == pisoActual) {
            mostrar("Error");
            pisoDeseado(texto);
        } else {
            mostrar("Cerrando puertas");
            espera(1000);
            if(desPiso < pisoActual){
                abajo();
            }else if( desPiso > pisoActual){
                arriba();
            }
        }

    }
}
