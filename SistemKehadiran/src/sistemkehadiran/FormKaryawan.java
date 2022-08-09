/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemkehadiran;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author itsupport
 */
public class FormKaryawan extends javax.swing.JFrame {

    /**
     * Creates new form FormKaryawan
     */
    private String SQL;
    private void load_table(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Id Karyawan");
        model.addColumn("Nama");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Jabatan");
        model.addColumn("Phone");
        model.addColumn("Alamat");
        tableKaryawan.setModel(model);


        Connection conn = SistemKehadiran.getConnection();

        //menampilkan data database kedalam tabel
       try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "select * from karyawan";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            int no=1;
            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    "KAR-"+res.getString("id"),
                    res.getString("nama"),
                    res.getString("jenis_kelamin"),
                    res.getString("jabatan"),
                    res.getString("no_telp"),
                    res.getString("alamat")
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    String getGender(){
        if(radioPria.isSelected()){
            return "pria";
        }
        else if(radioWanita.isSelected()){
            return "wanita";
        }else{
            return null;
        }
    }
    
    public FormKaryawan() {
        initComponents();
        this.load_table();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        radioPria = new javax.swing.JRadioButton();
        radioWanita = new javax.swing.JRadioButton();
        comboJabatan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textNoTelp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAlamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKaryawan = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        buttonSimpan = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Karyawan");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkehadiran/employee.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jLabel3.setText("Nama Karyawan");

        jLabel4.setText("Jenis Kelamin");

        jLabel5.setText("Jabatan");

        textNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaActionPerformed(evt);
            }
        });

        radioPria.setText("Pria");
        radioPria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPriaActionPerformed(evt);
            }
        });

        radioWanita.setText("Wanita");
        radioWanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioWanitaActionPerformed(evt);
            }
        });

        comboJabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HRD", "Manager", "Sekretaris", "Karyawan" }));
        comboJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboJabatanActionPerformed(evt);
            }
        });

        jLabel6.setText("No Telepon");

        jLabel7.setText("Alamat");

        textNoTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNoTelpActionPerformed(evt);
            }
        });

        textAlamat.setColumns(20);
        textAlamat.setRows(5);
        jScrollPane1.setViewportView(textAlamat);

        tableKaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableKaryawan);

        jLabel8.setText("Cari karyawan");

        buttonSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkehadiran/plus.png"))); // NOI18N
        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkehadiran/edit.png"))); // NOI18N
        buttonUbah.setText("Ubah");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });

        buttonHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkehadiran/trash.png"))); // NOI18N
        buttonHapus.setText("Hapus");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        buttonBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkehadiran/close.png"))); // NOI18N
        buttonBatal.setText("Batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(radioPria)
                                            .addGap(18, 18, 18)
                                            .addComponent(radioWanita))
                                        .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(49, 49, 49)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)))
                                .addComponent(comboJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(408, 408, 408)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField4))
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(buttonUbah)
                        .addGap(18, 18, 18)
                        .addComponent(buttonHapus)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBatal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(radioPria)
                            .addComponent(radioWanita))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonUbah)
                    .addComponent(buttonHapus)
                    .addComponent(buttonBatal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNamaActionPerformed

    private void comboJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboJabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboJabatanActionPerformed

    private void textNoTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNoTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNoTelpActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // TODO add your handling code here:
        
        String jabatan = (String) comboJabatan.getSelectedItem();
        try {
            Connection conn = SistemKehadiran.getConnection();
            PreparedStatement stmt = conn.prepareStatement("insert into karyawan(nama, jenis_kelamin, jabatan, no_telp, alamat) values(?,?,?,?,?)");
            stmt.setString(1, textNama.getText());
            stmt.setString(2, getGender());
            stmt.setString(3, jabatan);
            stmt.setString(4, textNoTelp.getText());
            stmt.setString(5, textAlamat.getText());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            load_table();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBatalActionPerformed

    private void radioWanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioWanitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioWanitaActionPerformed

    private void radioPriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPriaActionPerformed

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
            java.util.logging.Logger.getLogger(FormKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JComboBox<String> comboJabatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JRadioButton radioPria;
    private javax.swing.JRadioButton radioWanita;
    private javax.swing.JTable tableKaryawan;
    private javax.swing.JTextArea textAlamat;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textNoTelp;
    // End of variables declaration//GEN-END:variables
}
