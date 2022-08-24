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
public class FormPerpanjangan extends javax.swing.JFrame {

    /**
     * Creates new form FormPerpanjangan
     */
    
    private String SQL;
    private void load_table(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Id Perpanjangan");
        model.addColumn("Id Penilaian");
        model.addColumn("Nama Karyawan");
        model.addColumn("Jabatan");
        model.addColumn("Rata Rata");
        model.addColumn("Keterangan");
        model.addColumn("Tanggal Perpanjangan");
        model.addColumn("Tanggal Masuk Kerja");
        model.addColumn("Tanggal Selesai");
        model.addColumn("Gaji");
        tablePerpanjangan.setModel(model);
        // Disable input for Nama karyawan, Jabatan, and Text tanggal
        textNamaKaryawan.disable();
        textJabatan.disable();
        textRataRata.disable();
        textKeterangan.disable();
        Connection conn = SistemKehadiran.getConnection();
        //menampilkan data database kedalam tabel
       try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "select perpanjangan.id, perpanjangan.id_penilaian, karyawan.nama, karyawan.jabatan, penilaian.rata_rata, penilaian.keterangan, "
                    + "perpanjangan.tgl_perpanjangan, perpanjangan.tgl_kerja, perpanjangan.tgl_selesai, perpanjangan.gaji "
                    + "from perpanjangan INNER join penilaian on perpanjangan.id_penilaian = penilaian.id INNER join karyawan on penilaian.id_karyawan = karyawan.id;";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            int no=1;
            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    "PRPJ-" + res.getString(1),
                    "PEN-" + res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9),
                    res.getString(10),
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    void load_comboPenilaian(){
        Connection conn = SistemKehadiran.getConnection();        
        try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "SELECT id from penilaian;";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                comboPenilaian.addItem("PEN-" + res.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    String errorInput(){
        if (textTanggalPerpanjangan.getText().equals("")){
            return "Text Tanggal Perpanjangan tidak boleh kosong !";
        }else if(textTanggalMasukKerja.getText().equals("")){
            return "Text Tanggal Masuk Kerja tidak boleh kosong !";
        }else if(textTanggalSelesai.getText().equals("")){
            return "Text Tanggal Selesai tidak boleh kosong !";
        }else if(textGaji.getText().equals("")){
            return "Text Gaji tidak boleh kosong !";
        }
        return null;
    }
    
    void clearInput(){
        textTanggalMasukKerja.setText("");
        textTanggalPerpanjangan.setText("");
        textTanggalSelesai.setText("");
        textGaji.setText("");
        textNamaKaryawan.setText("");
        textJabatan.setText("");
        textKeterangan.setText("");
        textRataRata.setText("");
    }
    
    public FormPerpanjangan() {
        initComponents();
        load_table();
        load_comboPenilaian();

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
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textJabatan = new javax.swing.JTextField();
        buttonSimpan = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePerpanjangan = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        textNamaKaryawan = new javax.swing.JTextField();
        textRataRata = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textTanggalPerpanjangan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textTanggalMasukKerja = new javax.swing.JTextField();
        textTanggalSelesai = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textGaji = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        textKeterangan = new javax.swing.JTextField();
        comboPenilaian = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Perpanjangan");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkehadiran/promotion.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jLabel2.setText("ID Penilaian");

        jLabel5.setText("Nama Karyawan");

        jLabel6.setText("Jabatan");

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

        tablePerpanjangan.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePerpanjangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePerpanjanganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablePerpanjangan);

        jLabel8.setText("Cari karyawan");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        textNamaKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaKaryawanActionPerformed(evt);
            }
        });

        textRataRata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textRataRataActionPerformed(evt);
            }
        });

        jLabel11.setText("Tanggal Perpanjang");

        textTanggalPerpanjangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTanggalPerpanjanganActionPerformed(evt);
            }
        });

        jLabel12.setText("Tanggal Masuk Kerja");

        textTanggalMasukKerja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTanggalMasukKerjaActionPerformed(evt);
            }
        });

        textTanggalSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTanggalSelesaiActionPerformed(evt);
            }
        });

        jLabel13.setText("Tanggal Selesai ");

        textGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textGajiActionPerformed(evt);
            }
        });

        jLabel14.setText("Gaji");

        jLabel16.setText("Rata-rata");

        jLabel17.setText("Keterangan");

        textKeterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textKeteranganActionPerformed(evt);
            }
        });

        comboPenilaian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboPenilaianMouseClicked(evt);
            }
        });
        comboPenilaian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPenilaianActionPerformed(evt);
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
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(buttonUbah)
                                .addGap(18, 18, 18)
                                .addComponent(buttonHapus)
                                .addGap(18, 18, 18)
                                .addComponent(buttonBatal)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addComponent(textKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textRataRata, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textNamaKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(comboPenilaian, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(143, 143, 143)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(textTanggalPerpanjangan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textTanggalMasukKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textTanggalSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(104, 104, 104)
                                .addComponent(textGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboPenilaian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNamaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(textRataRata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(textKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(textTanggalPerpanjangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(textTanggalMasukKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(textTanggalSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSimpan)
                            .addComponent(buttonUbah)
                            .addComponent(buttonHapus)
                            .addComponent(buttonBatal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                String[] splitted_id_penilaian = comboPenilaian.getSelectedItem().toString().split("-");
                int id_penilaian = Integer.parseInt(splitted_id_penilaian[1]);
                PreparedStatement stmt = conn.prepareStatement("insert into perpanjangan(id_penilaian, tgl_perpanjangan, "
                        + "tgl_kerja, tgl_selesai, gaji) values(?, ?, ?, ?, ?)");
                stmt.setInt(1, id_penilaian);
                stmt.setString(2, textTanggalPerpanjangan.getText());
                stmt.setString(3, textTanggalMasukKerja.getText());
                stmt.setString(4, textTanggalSelesai.getText());
                stmt.setFloat(5, Float.parseFloat(textGaji.getText()));
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                load_table();
                clearInput();
            } catch (Exception e) {
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
                String[] splitted_id_penilaian = comboPenilaian.getSelectedItem().toString().split("-");
                int id_penilaian = Integer.parseInt(splitted_id_penilaian[1]);
                int baris = tablePerpanjangan.getSelectedRow();
                String[] splitted_id_perpanjangan = tablePerpanjangan.getValueAt(baris, 1).toString().split("-");
                int id_perpanjangan = Integer.parseInt(splitted_id_perpanjangan[1]);
                PreparedStatement stmt = conn.prepareStatement("update perpanjangan set id_penilaian=?, tgl_perpanjangan=?, tgl_kerja=?, tgl_selesai=?, gaji=? where id=?");
                stmt.setInt(1, id_penilaian);
                stmt.setString(2, textTanggalPerpanjangan.getText());
                stmt.setString(3, textTanggalMasukKerja.getText());
                stmt.setString(4, textTanggalSelesai.getText());
                stmt.setFloat(5, Float.parseFloat(textGaji.getText()));
                stmt.setInt(6, id_perpanjangan);
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

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
        if (errorInput() != null){
            JOptionPane.showMessageDialog(null, errorInput(), "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                int baris = tablePerpanjangan.getSelectedRow();
                String[] splitted_id_perpanjangan = tablePerpanjangan.getValueAt(baris, 1).toString().split("-");
                int id = Integer.parseInt(splitted_id_perpanjangan[1]);
                Connection conn = SistemKehadiran.getConnection();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data tersebut?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirm == 0){
                    PreparedStatement stmt = conn.prepareStatement("delete from perpanjangan where id=?");
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
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        // TODO add your handling code here:
        clearInput();
        buttonSimpan.setEnabled(true);
    }//GEN-LAST:event_buttonBatalActionPerformed

    private void textNamaKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNamaKaryawanActionPerformed

    private void textRataRataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textRataRataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textRataRataActionPerformed

    private void textTanggalPerpanjanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTanggalPerpanjanganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTanggalPerpanjanganActionPerformed

    private void textTanggalMasukKerjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTanggalMasukKerjaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTanggalMasukKerjaActionPerformed

    private void textTanggalSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTanggalSelesaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTanggalSelesaiActionPerformed

    private void textGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textGajiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textGajiActionPerformed

    private void textKeteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textKeteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textKeteranganActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void comboPenilaianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboPenilaianMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboPenilaianMouseClicked

    private void comboPenilaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPenilaianActionPerformed
        // TODO add your handling code here:
        Connection conn = SistemKehadiran.getConnection();        
        try {
            java.sql.Statement stmt = conn.createStatement();
            String[] splitted_id_penilaian = comboPenilaian.getSelectedItem().toString().split("-");
            int id = Integer.parseInt(splitted_id_penilaian[1]);
            SQL = "select karyawan.nama, karyawan.jabatan, penilaian.rata_rata, penilaian.keterangan "
                    + "from penilaian INNER join karyawan on penilaian.id_karyawan = karyawan.id where penilaian.id='" + id + "' ";

            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                textNamaKaryawan.setText(res.getString(1));
                textJabatan.setText(res.getString(2));
                textRataRata.setText(res.getString(3));
                textKeterangan.setText(res.getString(4).toUpperCase());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_comboPenilaianActionPerformed

    private void tablePerpanjanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePerpanjanganMouseClicked
        // TODO add your handling code here:
        buttonSimpan.setEnabled(false);
        int baris = tablePerpanjangan.getSelectedRow();
        comboPenilaian.setSelectedItem(tablePerpanjangan.getValueAt(baris, 2).toString());
        textNamaKaryawan.setText(tablePerpanjangan.getValueAt(baris, 3).toString());
        textJabatan.setText(tablePerpanjangan.getValueAt(baris, 4).toString());
        textRataRata.setText(tablePerpanjangan.getValueAt(baris, 5).toString());
        textKeterangan.setText(tablePerpanjangan.getValueAt(baris, 6).toString());
        textTanggalPerpanjangan.setText(tablePerpanjangan.getValueAt(baris, 7).toString());
        textTanggalMasukKerja.setText(tablePerpanjangan.getValueAt(baris, 8).toString());
        textTanggalSelesai.setText(tablePerpanjangan.getValueAt(baris, 9).toString());
        textGaji.setText(tablePerpanjangan.getValueAt(baris, 10).toString());
    }//GEN-LAST:event_tablePerpanjanganMouseClicked

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
            java.util.logging.Logger.getLogger(FormPerpanjangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPerpanjangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPerpanjangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPerpanjangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPerpanjangan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JComboBox<String> comboPenilaian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tablePerpanjangan;
    private javax.swing.JTextField textGaji;
    private javax.swing.JTextField textJabatan;
    private javax.swing.JTextField textKeterangan;
    private javax.swing.JTextField textNamaKaryawan;
    private javax.swing.JTextField textRataRata;
    private javax.swing.JTextField textTanggalMasukKerja;
    private javax.swing.JTextField textTanggalPerpanjangan;
    private javax.swing.JTextField textTanggalSelesai;
    // End of variables declaration//GEN-END:variables
}
