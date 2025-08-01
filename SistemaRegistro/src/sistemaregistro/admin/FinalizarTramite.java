/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemaregistro.admin;

import Clases.Expediente;
import Clases.GestionExpediente;
import Clases.Nodo;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class FinalizarTramite extends javax.swing.JFrame {
    
    private GestionExpediente gestionExp;
    private Expediente exp;
    
    public void cargarExpedientesNoFinalizados(){
        DefaultTableModel modelo_tabla = new DefaultTableModel();
        this.jTable1.setModel(modelo_tabla);
        modelo_tabla.addColumn("Identificador");
        modelo_tabla.addColumn("DNI");
        modelo_tabla.addColumn("Asunto");
        
        Expediente aux;
        Nodo actual = gestionExp.getPrimero();
        int contador = 0;
        if (actual != null) {
            while (actual != null) {
                aux = (Expediente) actual.getElemento();
                if (aux.getFechaFinal() == null){
                    modelo_tabla.insertRow(contador, new Object[]{
                        aux.getIdentificador(),
                        aux.getDni(),
                        aux.getAsunto()
                    });
                    contador++;
                }
            System.out.println("Revisando expediente: " + actual.getElemento());
            actual = actual.getSiguiente();
            }
        System.out.println("Termino de cargar los expedientes.");
        }
    }

    /**
     * Creates new form FinalizarTramite
     */
    public FinalizarTramite(GestionExpediente gestionExp) {
        this.gestionExp = gestionExp;
        initComponents();
        cargarExpedientesNoFinalizados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFinalizar = new javax.swing.JButton();
        jCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Finalizar Expedientes");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jFinalizar.setText("Finalizar");
        jFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFinalizarActionPerformed(evt);
            }
        });

        jCancelar.setText("Cancelar");
        jCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFinalizar)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFinalizar)
                    .addComponent(jCancelar))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jCancelarActionPerformed

    private void jFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFinalizarActionPerformed
        // TODO add your handling code here:
        
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un expediente para finalizar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String dniExspediente = jTable1.getValueAt(filaSeleccionada, 1).toString();
        
        Expediente exp = gestionExp.buscarPorDNI(dniExspediente);
        if (exp == null) {
            JOptionPane.showMessageDialog(this, "No se pudo encontrar el expediente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String documentoGenerado = JOptionPane.showInputDialog(this, "Ingrese el documento generado:");
        if (documentoGenerado == null || documentoGenerado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un documento generado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        exp.setDocumentoResultado(documentoGenerado);
        exp.setFechaFinal(java.time.LocalDateTime.now());
        
        cargarExpedientesNoFinalizados();
        
        JOptionPane.showMessageDialog(this, "El expediente ha sido finalizado exitosamente.");
    }//GEN-LAST:event_jFinalizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCancelar;
    private javax.swing.JButton jFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
