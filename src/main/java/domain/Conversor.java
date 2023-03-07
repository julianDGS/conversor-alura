package domain;

import com.formdev.flatlaf.FlatDarkLaf;
import enums.*;
import java.awt.Image;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author Julian
 */
public class Conversor extends javax.swing.JFrame {
    
    
    public Conversor() {
        initComponents();
        setSize(500, 500);

        //Iconos
        Image iconFrame = new ImageIcon(getClass().getResource("/Images/frame.png")).getImage();
        this.setIconImage(iconFrame);
        this.setTitle("Conversor");
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(0, 43, 54));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 380));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONVERSOR");
        jLabel1.setAlignmentX(0.5F);

        jLabel5.setBackground(new java.awt.Color(45, 198, 83));
        jLabel5.setOpaque(true);

        jButton1.setText("Moneda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Temperatura");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String result = this.conversorMoneda();
        if (result != null) JOptionPane.showMessageDialog(this, result, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        this.continuar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String result = this.conversorTemperatura();
        if (result != null) JOptionPane.showMessageDialog(this, result, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        this.continuar();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private String conversorMoneda(){
        String[] monedas = Arrays.stream(TiposMoneda.values()).map(moneda -> moneda.toString()).toArray(String[]::new);
        String from = (String) JOptionPane.showInputDialog(this,"Seleccione moneda a convertir", "Convertir Moneda", 
                JOptionPane.QUESTION_MESSAGE, null, monedas, null);
        String fromValue = (String) JOptionPane.showInputDialog(this, "Cantidad a convertir", "Convertir Moneda", JOptionPane.QUESTION_MESSAGE,
                null, null, null);
        String to = (String) JOptionPane.showInputDialog(this,"Convertir a:", "Convertir Moneda", 
                JOptionPane.QUESTION_MESSAGE, null, monedas, null);
        if(from == null || to == null || !validacion(fromValue)){
            JOptionPane.showMessageDialog(null, "Debe seleccionar ambas divisas y proporcionar un valor correcto", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            NumberFormat ft = new DecimalFormat("#.## " + to);
            float fromCurrencyToDolar = TiposMoneda.valueOf(from).getValor();
            float toCurrency = TiposMoneda.valueOf(to).getValor();
            float value = Float.parseFloat(fromValue);
            float resultConvert = (value/fromCurrencyToDolar)*toCurrency;
            return value + " " + from + " equivalen a: " + ft.format(resultConvert);
        }
        return null;
    }
    
    private String conversorTemperatura(){
        String[] temp = Arrays.stream(Temperaturas.values()).map(t -> t.toString()).toArray(String[]::new);
        String from = (String) JOptionPane.showInputDialog(this,"Seleccione temperatura a convertir", "Convertir Temperatura", 
                JOptionPane.QUESTION_MESSAGE, null, temp, null);
        String fromValue = (String) JOptionPane.showInputDialog(this, "Valor a convertir", "Convertir Temperatura", JOptionPane.QUESTION_MESSAGE,
                null, null, null);
        String to = (String) JOptionPane.showInputDialog(this,"Convertir a:", "Convertir Temperatura", 
                JOptionPane.QUESTION_MESSAGE, null, temp, null);
        if(from == null || to == null || !validacion(fromValue)){
            JOptionPane.showMessageDialog(null, "Debe seleccionar ambas unidades y proporcionar un valor correcto", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            NumberFormat ft = new DecimalFormat("#.## " + to);
            float resultConvert = this.formTemperature(from, Float.parseFloat(fromValue), to);
            return fromValue + " " + from + " equivalen a: " + ft.format(resultConvert);
        }
        return null;
    }
    
    private void continuar(){
        int option = JOptionPane.showConfirmDialog(this, "Desea continuar?");
        if(option != JOptionPane.YES_OPTION){
            this.dispose();
        }
    }
    
    private float formTemperature(String from, float fromValue, String to){
        float value;
        switch (from + " " + to) {
            case "CELCIUS KELVIN" -> {
                value = fromValue + 273.15F;
            }
            case "CELCIUS FAHRENHEIT" -> {
                value = fromValue*1.8F + 32F;
            }
            case "KELVIN FAHRENHEIT" -> {
                value = (fromValue - 273.15F)*1.8F + 32F;
            }
            case "KELVIN CELCIUS" -> {
                value = fromValue - 273.15F;
            }
            case "FAHRENHEIT CELCIUS" -> {
                value = (fromValue - 32F)*0.555556F;
            }
            case "FAHRENHEIT KELVIN" -> {
                value = (fromValue - 32F)*0.555556F + 273.15F;
            }
            default -> value = fromValue;
        }
        return value;
    }
    
    private boolean validacion(String valor){
        if(valor == null || valor.isBlank()){
            return false;
        } else{
            try{
                Float.parseFloat(valor);
                return true;
            }catch(NumberFormatException ex){
                return false;
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         Base LookAndFeel obtained from FormDev Software (FlatLaf): www.formdev.com/flatlaf/
         */
        FlatDarkLaf.registerCustomDefaultsSource("style");
        FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
             new Conversor().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
