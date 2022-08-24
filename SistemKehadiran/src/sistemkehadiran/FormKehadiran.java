/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemkehadiran;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author itsupport
 */
public class FormKehadiran extends javax.swing.JFrame {

    /**
     * Creates new form FormKehadiran
     */
    
    private String SQL;
    private void load_table(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Id Kehadiran");
        model.addColumn("Id Karyawan");
        model.addColumn("Nama Karyawan");
        model.addColumn("Jabatan");
        model.addColumn("Tanggal Kehadiran");
        model.addColumn("Keterangan");
        tableKehadiran.setModel(model);
        // Disable input for Nama karyawan, Jabatan, and Text tanggal
        textNamaKaryawan.disable();
        textJabatan.disable();
        textTanggal.disable();
        // Set text tanggal to auto date now
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        textTanggal.setText(dateFormat.format(date));

        Connection conn = SistemKehadiran.getConnection();

        //menampilkan data database kedalam tabel
       try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "SELECT kehadiran.id, kehadiran.id_karyawan, karyawan.nama, "
                    + "karyawan.jabatan, kehadiran.tgl_kehadiran, "
                    + "kehadiran.keterangan from kehadiran "
                    + "inner join karyawan on karyawan.id = kehadiran.id_karyawan;";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            int no=1;
            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    "HDR-" + res.getString(1),
                    "KAR-" + res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6)
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    void load_comboKaryawan(){
        Connection conn = SistemKehadiran.getConnection();        
        try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "SELECT id, nama, jabatan from karyawan;";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                comboKaryawan.addItem("KAR-" + res.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void clearInput(){
        textNamaKaryawan.setText("");
        textJabatan.setText("");
    }
    
    String errorInput(){

        if (textNamaKaryawan.getText().equals("")){
            return "Text nama karyawan tidak boleh kosong !";
        }else if(textTanggal.getText().equals("")){
            return "Text Tanggal Kehadiran tidak boleh kosong !";
        }else if(comboKaryawan.getSelectedItem().equals("")){
            return "Combobox Id Karyawan tidak boleh kosong !";
        }
        return null;
    }
    
    public FormKehadiran() {
        initComponents();
        this.load_table();
        load_comboKaryawan();
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
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textNamaKaryawan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKehadiran = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        textTanggal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        comboKeterangan = new javax.swing.JComboBox<>();
        textJabatan = new javax.swing.JTextField();
        buttonSimpan = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();
        comboKaryawan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Kehadiran");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkehadiran/checklist.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jLabel3.setText("Tanggal Kehadiran");

        jLabel5.setText("Id Karyawan");

        jLabel6.setText("Nama Karyawan");

        jLabel7.setText("Jabatan");

        textNamaKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaKaryawanActionPerformed(evt);
            }
        });

        tableKehadiran.setModel(new javax.swing.table.DefaultTableModel(
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
        tableKehadiran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKehadiranMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableKehadiran);

        jLabel8.setText("Cari Tanggal Kehadiran");

        textTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTanggalActionPerformed(evt);
            }
        });

        jLabel9.setText("Keterangan");

        comboKeterangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hadir", "Tidak Hadir" }));

        textJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textJabatanActionPerformed(evt);
            }
        });

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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkehadiran/trash.png"))); // NOI18N
        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkehadiran/close.png"))); // NOI18N
        buttonBatal.setText("Batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });

        comboKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKaryawanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(buttonSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(buttonUbah)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(buttonBatal)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(comboKaryawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNamaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textNamaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(comboKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(textTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonUbah)
                    .addComponent(jButton3)
                    .addComponent(buttonBatal))
                .addGap(36, 36, 36)
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

    private void textNamaKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNamaKaryawanActionPerformed

    private void textTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTanggalActionPerformed

    private void textJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textJabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textJabatanActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // TODO add your handling code here:
        if (errorInput() != null){
            JOptionPane.showMessageDialog(null, errorInput(), "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                Connection conn = SistemKehadiran.getConnection();
                String[] splitted_id_karyawan = comboKaryawan.getSelectedItem().toString().split("-");
                int id = Integer.parseInt(splitted_id_karyawan[1]);
                PreparedStatement stmt = conn.prepareStatement("insert into kehadiran(id_karyawan, tgl_kehadiran, keterangan) values(?,?,?)");
                stmt.setInt(1, id);
                stmt.setString(2, textTanggal.getText());
                stmt.setString(3, comboKeterangan.getSelectedItem().toString());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                load_table();
                clearInput();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Pesan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        // TODO add your handling code here:
        if (errorInput() != null){
            JOptionPane.showMessageDialog(null, errorInput(), "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                Connection conn = SistemKehadiran.getConnection();
                String[] splitted_id_karyawan = comboKaryawan.getSelectedItem().toString().split("-");
                int id_karyawan = Integer.parseInt(splitted_id_karyawan[1]);
                int baris = tableKehadiran.getSelectedRow();
                String[] splitted_id_kehadiran = tableKehadiran.getValueAt(baris, 1).toString().split("-");
                int id_kehadiran = Integer.parseInt(splitted_id_kehadiran[1]);
                PreparedStatement stmt = conn.prepareStatement("update kehadiran set id_karyawan=?, keterangan=? where id=?");
                stmt.setInt(1, id_karyawan);
                stmt.setString(2, comboKeterangan.getSelectedItem().toString());
                stmt.setInt(3, id_kehadiran);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                load_table();
                clearInput();
                buttonSimpan.setEnabled(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Pesan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (errorInput() != null){
            JOptionPane.showMessageDialog(null, errorInput(), "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                int baris = tableKehadiran.getSelectedRow();
                String[] splitted_id_kehadiran = tableKehadiran.getValueAt(baris, 1).toString().split("-");
                int id = Integer.parseInt(splitted_id_kehadiran[1]);
                Connection conn = SistemKehadiran.getConnection();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data tersebut?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirm == 0){
                    PreparedStatement stmt = conn.prepareStatement("delete from kehadiran where id=?");
                    stmt.setInt(1, id);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                    load_table();
                    clearInput();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Pesan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        // TODO add your handling code here:
        clearInput();
        buttonSimpan.setEnabled(true);
    }//GEN-LAST:event_buttonBatalActionPerformed

    private void comboKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKaryawanActionPerformed
        // TODO add your handling code here:
       Connection conn = SistemKehadiran.getConnection();        
        try {
            java.sql.Statement stmt = conn.createStatement();
            String[] splitted_id_karyawan = comboKaryawan.getSelectedItem().toString().split("-");
            int id = Integer.parseInt(splitted_id_karyawan[1]);
            SQL = "SELECT nama, jabatan from karyawan where id='" + id + "' ";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                textNamaKaryawan.setText(res.getString(1));
                textJabatan.setText(res.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_comboKaryawanActionPerformed

    private void tableKehadiranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKehadiranMouseClicked
        // TODO add your handling code here
        buttonSimpan.setEnabled(false);
        int baris = tableKehadiran.getSelectedRow();
        comboKaryawan.setSelectedItem(tableKehadiran.getValueAt(baris, 2).toString());
        textNamaKaryawan.setText(tableKehadiran.getValueAt(baris, 3).toString());
        textJabatan.setText(tableKehadiran.getValueAt(baris, 4).toString());
        textTanggal.setText(tableKehadiran.getValueAt(baris, 5).toString());
        comboKeterangan.setSelectedItem(tableKehadiran.getValueAt(baris, 6).toString());
    }//GEN-LAST:event_tableKehadiranMouseClicked

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
            java.util.logging.Logger.getLogger(FormKehadiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKehadiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKehadiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKehadiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKehadiran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JComboBox<String> comboKaryawan;
    private javax.swing.JComboBox<String> comboKeterangan;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tableKehadiran;
    private javax.swing.JTextField textJabatan;
    private javax.swing.JTextField textNamaKaryawan;
    private javax.swing.JTextField textTanggal;
    // End of variables declaration//GEN-END:variables
}
