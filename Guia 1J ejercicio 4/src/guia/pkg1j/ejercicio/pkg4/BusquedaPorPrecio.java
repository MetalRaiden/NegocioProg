
package guia.pkg1j.ejercicio.pkg4;

import javax.swing.table.DefaultTableModel;


public class BusquedaPorPrecio extends javax.swing.JInternalFrame {
 private DefaultTableModel modelo = new DefaultTableModel();
    
    public boolean isCellEditable(int f, int c){
        return false;
    }
  
    public BusquedaPorPrecio() {
        initComponents();
        cabecera();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_precio1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_Precio2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("Listado por precio");

        jLabel2.setText("Entre $:");

        tf_precio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_precio1KeyReleased(evt);
            }
        });

        jLabel3.setText("Y");

        tf_Precio2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_Precio2KeyReleased(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(122, 122, 122)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tf_precio1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_Precio2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_precio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tf_Precio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_precio1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_precio1KeyReleased
       borrarFilas();
       try{
        for(Producto prod:NewJFrame.listaProductos){
           if(prod.getPrecio() >= Integer.parseInt(tf_precio1.getText()) && prod.getPrecio() <= Integer.parseInt(tf_Precio2.getText())){
               modelo.addRow(new Object[]{
                   prod.getCodigo(),
                   prod.getDescripcion(),
                   prod.getPrecio(),
                   prod.getStock()
               });
           }
       }
       } catch(NumberFormatException e){
           return;
       }
    }//GEN-LAST:event_tf_precio1KeyReleased

    private void tf_Precio2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_Precio2KeyReleased
           borrarFilas();
           try{
        for(Producto prod:NewJFrame.listaProductos){
           if(prod.getPrecio() >= Double.parseDouble(tf_precio1.getText()) && prod.getPrecio() <= Double.parseDouble(tf_Precio2.getText())){
               modelo.addRow(new Object[]{
                   prod.getCodigo(),
                   prod.getDescripcion(),
                   prod.getPrecio(),
                   prod.getStock()
               });
           }
       }
           } catch(NumberFormatException e){
               return;
           }
        
    }//GEN-LAST:event_tf_Precio2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tf_Precio2;
    private javax.swing.JTextField tf_precio1;
    // End of variables declaration//GEN-END:variables
   private void cabecera(){
        modelo.addColumn("codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        jTable1.setModel(modelo);
    }

       private void borrarFilas(){
        int f=jTable1.getRowCount()-1;
        for(;f>=0; f--){
            modelo.removeRow(f);
        }
    }
}
