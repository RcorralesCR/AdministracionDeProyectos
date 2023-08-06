/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import Clases.EjecutarOperaciones;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Ronald
 */
public class formularioMovimientoCrear extends javax.swing.JFrame {

    /**
     * Creates new form formularioMovimientoCrear
     */
    public formularioMovimientoCrear() {
        initComponents();
        SpinnerNumberModel num = new SpinnerNumberModel();
        num.setMinimum(0);
        num.setMaximum(1000000);
        num.setStepSize(1);
        spinCantidad.setModel(num);

        EjecutarOperaciones.llenarComboSucursal(jComboBoxsucursal_destino);
        EjecutarOperaciones.llenarComboNombreProducto(jComboBoxsucursal_Producto);
        this.setLocationRelativeTo(null);
        txtFechaEnvio.setDateFormatString("dd/MM/yyyy"); // Sirve para mostrar el formato en el date chooser
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jComboBoxsucursal_Producto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDetalles = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtFechaEnvio = new com.toedter.calendar.JDateChooser();
        jComboBoxsucursal_destino = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblCodigoProducto = new javax.swing.JLabel();
        lblDetalles = new javax.swing.JLabel();
        spinCantidad = new javax.swing.JSpinner();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBoxsucursal_Producto.setToolTipText("");
        jComboBoxsucursal_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxsucursal_ProductoActionPerformed(evt);
            }
        });

        jLabel2.setText("Sucursal Destino");

        jLabel3.setText("Producto");

        jLabel4.setText("cantidad");

        jLabel5.setText("fecha_envio");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jComboBoxsucursal_destino.setToolTipText("");

        jLabel6.setText("Codigo Producto");

        lblDetalles.setText("Detalles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(100, 100, 100)
                .addComponent(btnRegresar))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxsucursal_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxsucursal_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(lblDetalles))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)))
                .addGap(0, 76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(btnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBoxsucursal_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxsucursal_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(lblCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDetalles))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(spinCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtFechaEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addComponent(btnAgregar)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        int sucursal_destino = (jComboBoxsucursal_destino.getSelectedIndex() + 1);

        String codigo_producto = lblCodigoProducto.getText();
        int cantidad = (int) spinCantidad.getValue();

        String fecha_envio = "" + txtFechaEnvio.getDate();
        String nombre_producto = (jComboBoxsucursal_Producto.getSelectedItem().toString());
        String[] productoNuevo = EjecutarOperaciones.obtenerProducto(nombre_producto);
        int sucursal_origen = Integer.parseInt(productoNuevo[5]);

        int cantidadProducto = EjecutarOperaciones.calcularCantidadProducto(nombre_producto);

        if (cantidad <= cantidadProducto) {
            EjecutarOperaciones.crearMovimiento(sucursal_origen, sucursal_destino, nombre_producto, codigo_producto, cantidad, fecha_envio);
            int cantidadTotal = cantidadProducto - cantidad;
            EjecutarOperaciones.restarUnidades(cantidadTotal, nombre_producto);
            //trae los datos del producto

            String nombreProducto = productoNuevo[0];
            int precioUnitario = Integer.parseInt(productoNuevo[2]);

            String descripcion = txtDetalles.getText();
            String idSucursal = "" + (jComboBoxsucursal_destino.getSelectedIndex() + 1);

            EjecutarOperaciones.agregarProductoaMovimiento(codigo_producto, nombreProducto, cantidad, precioUnitario, descripcion, idSucursal);
            JOptionPane.showMessageDialog(null, "Movimiento realizado con éxito");
            int cantidadesRestantes = EjecutarOperaciones.calcularCantidadProducto(nombre_producto);
            if (cantidadesRestantes <= 20) {
                JOptionPane.showMessageDialog(null, "Hay menos de 20 unidades del producto en la sucursal de Origen.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay suficiente cantidad del producto en la sucursal de origen");
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        formularioMenuMovimientos obj = new formularioMenuMovimientos();

        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void jComboBoxsucursal_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxsucursal_ProductoActionPerformed
        String nombre_producto = (jComboBoxsucursal_Producto.getSelectedItem().toString());
        EjecutarOperaciones.llenarComboNombreProducto(nombre_producto, lblCodigoProducto);
    }//GEN-LAST:event_jComboBoxsucursal_ProductoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> jComboBoxsucursal_Producto;
    private javax.swing.JComboBox<String> jComboBoxsucursal_destino;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCodigoProducto;
    private javax.swing.JLabel lblDetalles;
    private javax.swing.JSpinner spinCantidad;
    private javax.swing.JTextField txtDetalles;
    private com.toedter.calendar.JDateChooser txtFechaEnvio;
    // End of variables declaration//GEN-END:variables
}
