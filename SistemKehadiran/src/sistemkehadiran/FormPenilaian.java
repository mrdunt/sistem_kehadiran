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
public class FormPenilaian extends javax.swing.JFrame {

    /**
     * Creates new form FormPenilaian
     */
    
    private String SQL;
    private void load_table(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Id Penilaian");
        model.addColumn("Id Karyawan");
        model.addColumn("Nama Karyawan");
        model.addColumn("Jabatan");
        model.addColumn("Id Kehadiran");
        model.addColumn("Tanggal Kehadiran");
        model.addColumn("Kemampuan Kerja");
        model.addColumn("Loyalitas");
        model.addColumn("Disiplin");
        model.addColumn("Prestasi");
        model.addColumn("Perilaku");
        model.addColumn("Rata-Rata");
        model.addColumn("Keterangan");
        tablePenilaian.setModel(model);
        // Disable input for Nama karyawan, Jabatan, and Text tanggal
        textNamaKaryawan.disable();
        textJabatan.disable();
        textTanggalKehadiran.disable();
        textRata.disable();
        textKeterangan.disable();
        Connection conn = SistemKehadiran.getConnection();
        //menampilkan data database kedalam tabel
       try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "select penilaian.id, penilaian.id_karyawan, karyawan.nama, karyawan.jabatan, penilaian.id_kehadiran, kehadiran.tgl_kehadiran, "
                    + "penilaian.kemampuan, penilaian.loyalitas, penilaian.disiplin, penilaian.prestasi, penilaian.perilaku, penilaian.rata_rata, "
                    + "penilaian.keterangan from penilaian INNER join karyawan on penilaian.id_karyawan = karyawan.id INNER JOIN kehadiran on penilaian.id_kehadiran = kehadiran.id;";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            int no=1;
            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    "PEN-" + res.getString(1),
                    "KAR-" + res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    "HDR-" + res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9),
                    res.getString(10),
                    res.getString(11),
                    res.getString(12),
                    res.getString(13).toUpperCase(),
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
    
    void load_comboKehadiran(){
        Connection conn = SistemKehadiran.getConnection();        
        try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "SELECT id, tgl_kehadiran from kehadiran;";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                comboKehadiran.addItem("HDR-" + res.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    String errorInput(){

        if (textKemampuanKerja.getText().equals("")){
            return "Text Kemampuan Kerja tidak boleh kosong !";
        }else if(textLoyalitas.getText().equals("")){
            return "Text Loyalitas tidak boleh kosong !";
        }else if(textDisiplin.getText().equals("")){
            return "Text Disiplin tidak boleh kosong !";
        }else if(textPrestasi.getText().equals("")){
            return "Text Prestasi tidak boleh kosong !";
        }else if(textPerilaku.getText().equals("")){
            return "Text Perilaku tidak boleh kosong !";
        }else if(textRata.getText().equals("")){
            return "Text Rata Rata tidak boleh kosong !";
        }else if(textKeterangan.getText().equals("")){
            return "Text Keterangan tidak boleh kosong !";
        }
        return null;
    }
    
    void clearInput(){
        textKemampuanKerja.setText("");
        textLoyalitas.setText("");
        textDisiplin.setText("");
        textPrestasi.setText("");
        textPerilaku.setText("");
        textRata.setText("");
        textKeterangan.setText("");
    }
    
    public FormPenilaian() {
        initComponents();
        this.load_table();
        load_comboKaryawan();
        load_comboKehadiran();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textNamaKaryawan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePenilaian = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        textCari = new javax.swing.JTextField();
        textTanggalKehadiran = new javax.swing.JTextField();
        textJabatan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textKemampuanKerja = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textLoyalitas = new javax.swing.JTextField();
        textDisiplin = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textPrestasi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        textPerilaku = new javax.swing.JTextField();
        buttonHitung = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        textRata = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        textKeterangan = new javax.swing.JTextField();
        buttonSimpan = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();
        comboKehadiran = new javax.swing.JComboBox<>();
        comboKaryawan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Penilaian");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkehadiran/document.png"))); // NOI18N

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

        jLabel2.setText("ID Kehadiran");

        jLabel3.setText("Tanggal Kehadiran");

        jLabel5.setText("Id Karyawan");

        jLabel6.setText("Nama Karyawan");

        jLabel7.setText("Jabatan");

        textNamaKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaKaryawanActionPerformed(evt);
            }
        });

        tablePenilaian.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePenilaian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenilaianMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablePenilaian);

        jLabel8.setText("Cari Penilaian");

        textCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCariKeyPressed(evt);
            }
        });

        textTanggalKehadiran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTanggalKehadiranActionPerformed(evt);
            }
        });

        textJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textJabatanActionPerformed(evt);
            }
        });

        jLabel11.setText("Kemampuan Kerja");

        textKemampuanKerja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textKemampuanKerjaActionPerformed(evt);
            }
        });

        jLabel12.setText("Loyalitas");

        textLoyalitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLoyalitasActionPerformed(evt);
            }
        });

        textDisiplin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDisiplinActionPerformed(evt);
            }
        });

        jLabel13.setText("Disiplin");

        textPrestasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPrestasiActionPerformed(evt);
            }
        });

        jLabel14.setText("Prestasi");

        jLabel15.setText("Perilaku");

        textPerilaku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPerilakuActionPerformed(evt);
            }
        });

        buttonHitung.setText("Hitung");
        buttonHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHitungActionPerformed(evt);
            }
        });

        jLabel16.setText("Rata-rata");

        textRata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textRataActionPerformed(evt);
            }
        });

        jLabel17.setText("Keterangan");

        textKeterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textKeteranganActionPerformed(evt);
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

        comboKehadiran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKehadiranActionPerformed(evt);
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
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(buttonSimpan)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonUbah)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonHapus)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonBatal))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2))
                                                .addGap(39, 39, 39)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(textTanggalKehadiran, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                    .addComponent(textNamaKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                    .addComponent(textJabatan, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                    .addComponent(comboKehadiran, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(comboKaryawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(textKemampuanKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(textLoyalitas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(textDisiplin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(textPrestasi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(156, 156, 156)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textPerilaku, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textRata, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonHitung)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(comboKehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(textTanggalKehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(comboKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(textPerilaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addComponent(buttonHitung)
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(textRata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(textKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(textNamaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(textKemampuanKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(textLoyalitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(textDisiplin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(textPrestasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonUbah)
                    .addComponent(buttonHapus)
                    .addComponent(buttonBatal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
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

    private void textNamaKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNamaKaryawanActionPerformed

    private void textTanggalKehadiranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTanggalKehadiranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTanggalKehadiranActionPerformed

    private void textJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textJabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textJabatanActionPerformed

    private void textKemampuanKerjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textKemampuanKerjaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textKemampuanKerjaActionPerformed

    private void textLoyalitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLoyalitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLoyalitasActionPerformed

    private void textDisiplinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDisiplinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDisiplinActionPerformed

    private void textPrestasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPrestasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPrestasiActionPerformed

    private void textPerilakuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPerilakuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPerilakuActionPerformed

    private void buttonHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHitungActionPerformed
        // TODO add your handling code here:
        try{
            float rata = (Integer.parseInt(textKemampuanKerja.getText()) + Integer.parseInt(textLoyalitas.getText()) + 
                Integer.parseInt(textDisiplin.getText()) + Integer.parseInt(textPrestasi.getText()) + 
                Integer.parseInt(textPerilaku.getText())) / 5  ;
            textRata.setText(Float.toString(rata));
            if (rata>=80){
                textKeterangan.setText("Perpanjang");
            }else{
                textKeterangan.setText("Tidak Perpanjang");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_buttonHitungActionPerformed

    private void textRataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textRataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textRataActionPerformed

    private void textKeteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textKeteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textKeteranganActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // TODO add your handling code here:
        if (errorInput() != null){
            JOptionPane.showMessageDialog(null, errorInput(), "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                Connection conn = SistemKehadiran.getConnection();
                String[] splitted_id_karyawan = comboKaryawan.getSelectedItem().toString().split("-");
                int id_karyawan = Integer.parseInt(splitted_id_karyawan[1]);
                String[] splitted_id_kehadiran = comboKehadiran.getSelectedItem().toString().split("-");
                int id_kehadiran = Integer.parseInt(splitted_id_kehadiran[1]);
                PreparedStatement stmt = conn.prepareStatement("insert into penilaian(id_karyawan, id_kehadiran, kemampuan, loyalitas, disiplin, "
                        + "prestasi, perilaku, rata_rata, keterangan) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                stmt.setInt(1, id_karyawan);
                stmt.setInt(2, id_kehadiran);
                stmt.setString(3, textKemampuanKerja.getText());
                stmt.setString(4, textLoyalitas.getText());
                stmt.setString(5, textDisiplin.getText());
                stmt.setString(6, textPrestasi.getText());
                stmt.setString(7, textPerilaku.getText());
                stmt.setFloat(8, Float.parseFloat(textRata.getText()));
                stmt.setString(9, textKeterangan.getText().toLowerCase());
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
                String[] splitted_id_kehadiran = comboKehadiran.getSelectedItem().toString().split("-");
                int id_kehadiran = Integer.parseInt(splitted_id_kehadiran[1]);
                int baris = tablePenilaian.getSelectedRow();
                String[] splitted_id_penilaian = tablePenilaian.getValueAt(baris, 1).toString().split("-");
                int id_penilaian = Integer.parseInt(splitted_id_penilaian[1]);
                PreparedStatement stmt = conn.prepareStatement("update penilaian set id_kehadiran=?, id_karyawan=?, kemampuan=?, loyalitas=?, disiplin=?, prestasi=?, perilaku=?, rata_rata=?, keterangan=? where id=?");
                stmt.setInt(1, id_kehadiran);
                stmt.setInt(2, id_karyawan);
                stmt.setInt(3, Integer.parseInt(textKemampuanKerja.getText()));
                stmt.setInt(4, Integer.parseInt(textLoyalitas.getText()));
                stmt.setInt(5, Integer.parseInt(textDisiplin.getText()));
                stmt.setInt(6, Integer.parseInt(textPrestasi.getText()));
                stmt.setInt(7, Integer.parseInt(textPerilaku.getText()));
                stmt.setFloat(8, Float.parseFloat(textRata.getText()));
                stmt.setString(9, textKeterangan.getText());
                stmt.setInt(10, id_penilaian);
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
                int baris = tablePenilaian.getSelectedRow();
                String[] splitted_id_penilaian = tablePenilaian.getValueAt(baris, 1).toString().split("-");
                int id = Integer.parseInt(splitted_id_penilaian[1]);
                Connection conn = SistemKehadiran.getConnection();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data tersebut?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirm == 0){
                    PreparedStatement stmt = conn.prepareStatement("delete from penilaian where id=?");
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

    private void comboKehadiranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKehadiranActionPerformed
        // TODO add your handling code here:
        Connection conn = SistemKehadiran.getConnection();        
        try {
            java.sql.Statement stmt = conn.createStatement();
            String[] splitted_id_kehadiran = comboKehadiran.getSelectedItem().toString().split("-");
            int id = Integer.parseInt(splitted_id_kehadiran[1]);
            SQL = "SELECT tgl_kehadiran from kehadiran where id='" + id + "' ";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                textTanggalKehadiran.setText(res.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_comboKehadiranActionPerformed

    private void tablePenilaianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenilaianMouseClicked
        // TODO add your handling code here:
        buttonSimpan.setEnabled(false);
        int baris = tablePenilaian.getSelectedRow();
        comboKaryawan.setSelectedItem(tablePenilaian.getValueAt(baris, 2).toString());
        textNamaKaryawan.setText(tablePenilaian.getValueAt(baris, 3).toString());
        textJabatan.setText(tablePenilaian.getValueAt(baris, 4).toString());
        comboKehadiran.setSelectedItem(tablePenilaian.getValueAt(baris, 5).toString());
        textTanggalKehadiran.setText(tablePenilaian.getValueAt(baris, 6).toString());
        textKemampuanKerja.setText(tablePenilaian.getValueAt(baris, 7).toString());
        textLoyalitas.setText(tablePenilaian.getValueAt(baris, 8).toString());
        textDisiplin.setText(tablePenilaian.getValueAt(baris, 9).toString());
        textPrestasi.setText(tablePenilaian.getValueAt(baris, 10).toString());
        textPerilaku.setText(tablePenilaian.getValueAt(baris, 11).toString());
        textRata.setText(tablePenilaian.getValueAt(baris, 12).toString());
        textKeterangan.setText(tablePenilaian.getValueAt(baris, 13).toString());


    }//GEN-LAST:event_tablePenilaianMouseClicked

    private void textCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCariKeyPressed
        // TODO add your handling code here:
        if (textCari.getText().equals("")){
            load_table();
        }else{
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Id Penilaian");
            model.addColumn("Id Karyawan");
            model.addColumn("Nama Karyawan");
            model.addColumn("Jabatan");
            model.addColumn("Id Kehadiran");
            model.addColumn("Tanggal Kehadiran");
            model.addColumn("Kemampuan Kerja");
            model.addColumn("Loyalitas");
            model.addColumn("Disiplin");
            model.addColumn("Prestasi");
            model.addColumn("Perilaku");
            model.addColumn("Rata-Rata");
            model.addColumn("Keterangan");
            tablePenilaian.setModel(model);
            // Disable input for Nama karyawan, Jabatan, and Text tanggal
            textNamaKaryawan.disable();
            textJabatan.disable();
            textTanggalKehadiran.disable();
            textRata.disable();
            textKeterangan.disable();
            Connection conn = SistemKehadiran.getConnection();
            //menampilkan data database kedalam tabel
           try {
                java.sql.Statement stmt = conn.createStatement();
                SQL = "select penilaian.id, penilaian.id_karyawan, karyawan.nama, karyawan.jabatan, penilaian.id_kehadiran, kehadiran.tgl_kehadiran, "
                        + "penilaian.kemampuan, penilaian.loyalitas, penilaian.disiplin, penilaian.prestasi, penilaian.perilaku, penilaian.rata_rata, "
                        + "penilaian.keterangan from penilaian INNER join karyawan on penilaian.id_karyawan = karyawan.id INNER JOIN kehadiran on penilaian.id_kehadiran = kehadiran.id "
                        + "where karyawan.nama like '%" + textCari.getText() + "%' or karyawan.jabatan like '%" + textCari.getText()+ "%' or kehadiran.tgl_kehadiran like '%" + textCari.getText()+ "%' "
                        + "or penilaian.rata_rata like '%" + textCari.getText()+ "%' or penilaian.keterangan like '%" + textCari.getText()+ "%' ";
                java.sql.ResultSet res = stmt.executeQuery(SQL);
                int no=1;
                while (res.next()) {
                    model.addRow(new Object[]{
                        no++,
                        "PEN-" + res.getString(1),
                        "KAR-" + res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        "HDR-" + res.getString(5),
                        res.getString(6),
                        res.getString(7),
                        res.getString(8),
                        res.getString(9),
                        res.getString(10),
                        res.getString(11),
                        res.getString(12),
                        res.getString(13).toUpperCase(),
                    });
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_textCariKeyPressed

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
            java.util.logging.Logger.getLogger(FormPenilaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPenilaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPenilaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPenilaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPenilaian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonHitung;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JComboBox<String> comboKaryawan;
    private javax.swing.JComboBox<String> comboKehadiran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablePenilaian;
    private javax.swing.JTextField textCari;
    private javax.swing.JTextField textDisiplin;
    private javax.swing.JTextField textJabatan;
    private javax.swing.JTextField textKemampuanKerja;
    private javax.swing.JTextField textKeterangan;
    private javax.swing.JTextField textLoyalitas;
    private javax.swing.JTextField textNamaKaryawan;
    private javax.swing.JTextField textPerilaku;
    private javax.swing.JTextField textPrestasi;
    private javax.swing.JTextField textRata;
    private javax.swing.JTextField textTanggalKehadiran;
    // End of variables declaration//GEN-END:variables
}
