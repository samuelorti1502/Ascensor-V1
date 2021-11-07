/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.DynamicTxt;
import clases.TestElevator;
import clases.TestElevator2;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Samuel David Ortiz
 */
public class FrmAscensor extends javax.swing.JFrame {

    /**
     * Creates new form FrmAscensor
     */
    private JLabel titulo;
    private JLabel lblElevator;
    private JPanel mainPanel;
    private JPanel elevatorPanel;
    public ArrayList<JToggleButton> controlList;
    public ArrayList<JLabel> elevatorList;
    public JToggleButton c;
    private boolean seve = false;

    private ImageIcon Img;
    private Icon icono;

    private final String[] control = {"BOSS", "7", "6", "5", "4", "3", "2", "L", "S", ""};

    TestElevator testElevator = new TestElevator();
    TestElevator2 testElevator2;

    public FrmAscensor() {
        initComponents();

        controlList = new ArrayList<JToggleButton>();
        elevatorList = new ArrayList<JLabel>();

        //mostrarPiso();
        GUI();
        elevator();
        this.jTextField1.setVisible(false);
    }

    public void GUI() {

        // <editor-fold defaultstate="collapsed" desc="Escudo UMG">
        titulo = new JLabel();
        titulo.setSize(140, 140);
        titulo.setLocation(5, 5);
        Img = new ImageIcon(getClass().getResource("/images/umg.png"));
        //Img = new ImageIcon("./src/images/umg.png");
        icono = new ImageIcon(Img.getImage().getScaledInstance(140, 140,
                Image.SCALE_DEFAULT));

        titulo.setIcon(icono);
        titulo.setVisible(true);
        pnlTitulo.add(titulo, 0);
        // </editor-fold>  

        // <editor-fold defaultstate="collapsed" desc="Texto dinamico">
        String mensaje = "BIENVENIDO AL SIMULADOR DE ASCENSOR UMG SDOM V1 ";
        DynamicTxt texto = null;
        try {
            texto = new DynamicTxt(mensaje, 300, lblTexto, new JLabel());
        } catch (Exception ex) {
            Logger.getLogger(FrmAscensor.class.getName()).log(Level.SEVERE, null, ex);
        }
        texto.start();
        // </editor-fold>  

        // <editor-fold defaultstate="collapsed" desc="Panel de Control">
        GridLayout grid = new GridLayout(5, 2);
        grid.setVgap(1);
        grid.setVgap(2);

        mainPanel = new JPanel(grid);
        pnlControl.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 10; i++) {
            c = new JToggleButton();
            c.setText(control[i]);
            c.setSelected(false);
            controlList.add(c);

            c.addActionListener(new presionar());
            c.addMouseListener(new presionarBtn());

            mainPanel.add(c);
            //testElevator2 = new TestElevator2(c, jLabel1, controlList);
        }
        // </editor-fold>  

        // <editor-fold defaultstate="collapsed" desc="Panel Elevador">
        GridLayout gridE = new GridLayout(9, 1);
        gridE.setVgap(1);
        gridE.setVgap(2);

        elevatorPanel = new JPanel(gridE);
        pnlElevator.add(BorderLayout.CENTER, elevatorPanel);

        for (int i = 0; i < 9; i++) {

            lblElevator = new JLabel();
            lblElevator.setSize(70, pnlElevator.getHeight());
            lblElevator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblElevator.setLocation(5, 5);
            Img = new ImageIcon(getClass().getResource("/images/open.png"));
            icono = new ImageIcon(Img.getImage().getScaledInstance(70, 70,
                    Image.SCALE_DEFAULT));

            lblElevator.setIcon(icono);
            lblElevator.setVisible(true);
            lblElevator.setText(String.valueOf(i));
            elevatorPanel.add(lblElevator, 0);
            elevatorList.add(lblElevator);

        }
        // </editor-fold>  

    }

    public void mostrarPiso() {
        testElevator.mostrarPiso(1, jLabel1);
    }

    public void elevator() {
        JToggleButton jt = (JToggleButton) controlList.get(9);
        jt.setVisible(false);

        for (int i = 1; i < 9; i++) {

            JLabel jc = (JLabel) elevatorList.get(i);
            jc.setVisible(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlTitulo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTexto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnlControl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnlElevator = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblTexto.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(lblTexto, gridBagConstraints);

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlControl.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nivel 0");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jButton1.setText("↑↓");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pnlElevator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlElevator.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlElevator, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(96, 96, 96))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlElevator, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnlControl, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 2; j++) {
                int jci = j + (2 * i);

                JToggleButton jc = (JToggleButton) controlList.get(jci);
                String bs = jc.getText();
                if (jc.getText().equals("BOSS")) {
                    //System.out.println("Hola jefe");

                    break;
                } else {
                    if (jc.isSelected()) {
                        //testElevator.pisoDeseado(jc, jLabel1, controlList);
                        testElevator2 = new TestElevator2(jc, jLabel1, lblElevator, controlList, elevatorList);

                        //testElevator2.pisoDeseado(jc, jLabel1, lblElevator, controlList, elevatorList);
                        testElevator2.start();
                        testElevator2.interrupt();
                    } else {
                        //jc.setSelected(true);
                        //testElevator2.interrupt();
                    }
                }
            }
            //testElevator2.interrupt();

            //testElevator.mostrarPiso(1, jLabel1);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public String bossPass(JToggleButton boton) {
        return boton.getText();
    }

    public class presionar implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            //FrmPassBoss frmPass = new FrmPassBoss();
            //FrmAscensor frmAs = new FrmAscensor();
            for (int i = 0; i < 5; i++) {

                for (int j = 0; j < 2; j++) {
                    int jci = j + (2 * i);

                    JToggleButton jc = (JToggleButton) controlList.get(jci);
                    seleccionar(jc);
                }
            }
        }

        public void seleccionar(JToggleButton jc) {
            if (jc.isSelected()) {
                if (jc.getText().equals("BOSS")) {
                    jc.setSelected(false);

                    //frmPass.setVisible(true);
                    FrmAscensor.jTextField1.setVisible(true);
                    seve = true;

                    jc.setSelected(false);
                    jc.setText("Aceptar");
                    //break;
                } else {
                    if (seve) {
                        String a;
                        //System.out.println(" " + jc.getText());
                        //FrmPassBoss frmPass1 = new FrmPassBoss(jc.getText());
                        //frmPass.recibeTexto(jc.getText());
                        jc.setSelected(false);
                        String text = FrmAscensor.jTextField1.getText();
                        
                        if(jc.getText().equals("Aceptar")){
                            a = "";
                        }else{
                            a = jc.getText();
                        }
                        
                        //System.out.println("a = " + a);
                        
                        FrmAscensor.jTextField1.setText(text + a);
                        jc.setSelected(false);
                        if (jc.getText().equals("Aceptar")) {
                            FrmAscensor.jTextField1.setVisible(false);
                            //System.out.println("Texto = " + FrmAscensor.jTextField1.getText());
                            
                            //Comparar contraseñas
                            validar(FrmAscensor.jTextField1.getText());
                            
                            jc.setText("BOSS");
                            FrmAscensor.jTextField1.setText("");
                        } else {
                            //jc.setText("BOSS");
                        }
                    }
                }
            }
        }

        public boolean validar(String contraseña) {
            boolean isLogin = false;
            try {
                File myObj = new File("contraseña.txt");
                Scanner myReader = new Scanner(myObj);

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    
                    if(data.equals(contraseña)){
                        isLogin = true;
                        System.out.println("Contraseña correcta");
                    }else{
                        System.out.println("Contraseña incorrecta");
                    }
                    
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            return isLogin;
        }

        /*public void keyPressed(java.awt.event.KeyEvent evt){
            System.out.println("boton " + bossPass());
        }*/
    }

    public class presionarBtn extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i = 0; i < 5; i++) {

                for (int j = 0; j < 2; j++) {
                    int jci = j + (2 * i);
                    JToggleButton jc = (JToggleButton) controlList.get(jci);
                    if (jc.isSelected()) {
                        //System.out.println(" " + jc.getText());
                    }
                    //FrmPassBoss frmPass = new FrmPassBoss();
                    //frmPass.recibeTexto(jc.getText());
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAscensor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAscensor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAscensor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAscensor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAscensor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JPanel pnlControl;
    private javax.swing.JPanel pnlElevator;
    private javax.swing.JPanel pnlTitulo;
    // End of variables declaration//GEN-END:variables
}
