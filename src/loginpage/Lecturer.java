/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginpage;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.rendering.PDFRenderer;
/**
 *
 * @author Basudewa
 */
public class Lecturer extends javax.swing.JFrame {

    private DefaultTableModel materiModel;
    private DefaultTableModel diskusiModel;
    private DefaultTableModel diskusiSayaModel;
    
    private FileInputStream fis;
    private File selectedFile;
    
    Login login = new Login();
    /**
     * Creates new form Lecturer
     */
    public Lecturer() {
        initComponents();
        
        materiModel = new DefaultTableModel();
        MateriTable.setModel(materiModel);
        materiModel.addColumn("Id Materi");
        materiModel.addColumn("Nama Materi");
        
        loadMateriData();
        
        diskusiModel = new DefaultTableModel();
        DiskusiSayaTable.setModel(diskusiModel);
        diskusiModel.addColumn("Id Diskusi");
        diskusiModel.addColumn("Nama Diskusi");
        diskusiModel.addColumn("Topik Diskusi");
        
        loadDiskusiData();
        
        diskusiSayaModel = new DefaultTableModel();
        DiskusiTable.setModel(diskusiModel);
        diskusiSayaModel.addColumn("Id Diskusi");
        diskusiSayaModel.addColumn("Nama Diskusi");
        diskusiSayaModel.addColumn("Topik Diskusi");
        
        loadDiskusiDataSaya();
        
        usernameLabel.setText(login.currentUser.getUsername());
    }
    
    private void loadMateriData() {
        materiModel.getDataVector().removeAllElements();
        materiModel.fireTableDataChanged();
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM materi WHERE id_lecturer = ?";
            // TODO : Query materi yang dimiliki lecturer ini saja
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setInt(1, login.currentUser.getId());
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Object[] o = new Object[3];
                o[0] = resultSet.getString("id_materi");
                o[1] = resultSet.getString("judul_materi");
                
                materiModel.addRow(o);
            }
            
            resultSet.close();            
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void loadDiskusiData() {
        diskusiModel.getDataVector().removeAllElements();
        diskusiModel.fireTableDataChanged();
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM materi WHERE id_materi = ?");
            statement.setInt(1, login.currentUser.getId());
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Object[] o = new Object[3];
                o[0] = resultSet.getString("id_diskusi");
                o[1] = resultSet.getString("nama_diskusi");
                
                diskusiModel.addRow(o);
            }
            
            resultSet.close();            
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void loadDiskusiDataSaya() {
        diskusiSayaModel.getDataVector().removeAllElements();
        diskusiSayaModel.fireTableDataChanged();
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM diskusi";
            // TODO : query diskusi yang dimiliki lecturer ini saja
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()) {
                Object[] o = new Object[3];
                o[0] = resultSet.getString("id_diskusi");
                o[1] = resultSet.getString("nama_diskusi");
                o[2] = resultSet.getString("topik_diskusi");
                
                diskusiSayaModel.addRow(o);
            }
            
            resultSet.close();            
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void CleanUpMateri() {
        NamaMateriField.setText("");
        FileNameField.setText("");
        NamaMateriUpdateField.setText("");
        ReferensiMateriUpdateField.setText("");
        IdMateriUpdateField.setText("");
        IdHapusMateriField.setText("");
    }
    
    private void CleanUpDiskusi() {
        NamaDiskusiField.setText("");
        TopikDiskusiField.setText("");
        NamaDiskusiUpdateField.setText("");
        TopikDiskusiUpdateField.setText("");
        IdDiskusiUpdateField.setText("");
        IdDiskusiHapusField.setText("");
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
        jLabel2 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        TabPane = new javax.swing.JTabbedPane();
        AddMateriPanel = new javax.swing.JPanel();
        ReferensiMateri = new javax.swing.JLabel();
        JudulMateriLabel1 = new javax.swing.JLabel();
        NamaMateriField = new javax.swing.JTextField();
        AddMateriButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MateriTable = new javax.swing.JTable();
        materiSayaLabel = new javax.swing.JLabel();
        penambahanMateriLabel = new javax.swing.JLabel();
        modifikasiMaterilabel = new javax.swing.JLabel();
        JudulMateriLabel2 = new javax.swing.JLabel();
        ReferensiMateri1 = new javax.swing.JLabel();
        NamaMateriUpdateField = new javax.swing.JTextField();
        ReferensiMateriUpdateField = new javax.swing.JTextField();
        UpdateMateriButton = new javax.swing.JButton();
        ReferensiMateri2 = new javax.swing.JLabel();
        IdMateriUpdateField = new javax.swing.JTextField();
        hapusMateriLabel = new javax.swing.JLabel();
        ReferensiMateri3 = new javax.swing.JLabel();
        IdHapusMateriField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        HapusMateriButton = new javax.swing.JButton();
        PilihMateriButton = new javax.swing.JButton();
        FileNameField = new javax.swing.JTextField();
        pdfScrollPane = new javax.swing.JScrollPane();
        pdfPanel = new javax.swing.JPanel();
        AddDiskusiPanel = new javax.swing.JPanel();
        TopikDiskusiLabel = new javax.swing.JLabel();
        TopikDiskusiField = new javax.swing.JTextField();
        NamaDiskusiLabel = new javax.swing.JLabel();
        NamaDiskusiField = new javax.swing.JTextField();
        AddDiskusiButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        DiskusiSayaTable = new javax.swing.JTable();
        penambahanDiskusiLabel = new javax.swing.JLabel();
        DiskusiLabel = new javax.swing.JLabel();
        DiskusiSayaLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DiskusiTable = new javax.swing.JTable();
        penambahanDiskusiLabel1 = new javax.swing.JLabel();
        NamaDiskusiLabel1 = new javax.swing.JLabel();
        TopikDiskusiLabel1 = new javax.swing.JLabel();
        TopikDiskusiLabel2 = new javax.swing.JLabel();
        NamaDiskusiUpdateField = new javax.swing.JTextField();
        TopikDiskusiUpdateField = new javax.swing.JTextField();
        IdDiskusiUpdateField = new javax.swing.JTextField();
        UpdateDiskusiButton = new javax.swing.JButton();
        penambahanDiskusiLabel2 = new javax.swing.JLabel();
        TopikDiskusiLabel3 = new javax.swing.JLabel();
        IdDiskusiHapusField = new javax.swing.JTextField();
        HapusDiskusiButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        DiskusiNavigator = new javax.swing.JButton();
        MateriNavigator = new javax.swing.JButton();
        ProfileNavigator = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1442, 870));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1450, 70));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DISTUDY");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginpage/Rectangle 77.png"))); // NOI18N

        usernameLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 863, Short.MAX_VALUE)
                .addComponent(usernameLabel)
                .addGap(205, 205, 205))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(usernameLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, -1));

        TabPane.setBackground(new java.awt.Color(255, 255, 255));

        AddMateriPanel.setBackground(new java.awt.Color(255, 255, 255));

        ReferensiMateri.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        ReferensiMateri.setForeground(new java.awt.Color(51, 153, 255));
        ReferensiMateri.setText("Path Materi");

        JudulMateriLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        JudulMateriLabel1.setForeground(new java.awt.Color(51, 153, 255));
        JudulMateriLabel1.setText("Nama Materi");

        NamaMateriField.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        NamaMateriField.setForeground(new java.awt.Color(51, 153, 255));
        NamaMateriField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaMateriFieldActionPerformed(evt);
            }
        });

        AddMateriButton.setBackground(new java.awt.Color(51, 153, 255));
        AddMateriButton.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        AddMateriButton.setForeground(new java.awt.Color(255, 255, 255));
        AddMateriButton.setText("Add Materi");
        AddMateriButton.setBorder(null);
        AddMateriButton.setBorderPainted(false);
        AddMateriButton.setFocusPainted(false);
        AddMateriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMateriButtonActionPerformed(evt);
            }
        });

        MateriTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MateriTable.setForeground(new java.awt.Color(51, 153, 255));
        MateriTable.setModel(new javax.swing.table.DefaultTableModel(
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
        MateriTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MateriTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MateriTable);

        materiSayaLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        materiSayaLabel.setForeground(new java.awt.Color(51, 153, 255));
        materiSayaLabel.setText("Materi Saya");

        penambahanMateriLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        penambahanMateriLabel.setForeground(new java.awt.Color(51, 153, 255));
        penambahanMateriLabel.setText("Penambahan Materi");

        modifikasiMaterilabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        modifikasiMaterilabel.setForeground(new java.awt.Color(51, 153, 255));
        modifikasiMaterilabel.setText("Modifikasi Materi");

        JudulMateriLabel2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        JudulMateriLabel2.setForeground(new java.awt.Color(51, 153, 255));
        JudulMateriLabel2.setText("Nama Materi");

        ReferensiMateri1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        ReferensiMateri1.setForeground(new java.awt.Color(51, 153, 255));
        ReferensiMateri1.setText("Path Materi");

        NamaMateriUpdateField.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        NamaMateriUpdateField.setForeground(new java.awt.Color(51, 153, 255));
        NamaMateriUpdateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaMateriUpdateFieldActionPerformed(evt);
            }
        });

        ReferensiMateriUpdateField.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        ReferensiMateriUpdateField.setForeground(new java.awt.Color(51, 153, 255));
        ReferensiMateriUpdateField.setEnabled(false);
        ReferensiMateriUpdateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReferensiMateriUpdateFieldActionPerformed(evt);
            }
        });

        UpdateMateriButton.setBackground(new java.awt.Color(51, 153, 255));
        UpdateMateriButton.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        UpdateMateriButton.setForeground(new java.awt.Color(255, 255, 255));
        UpdateMateriButton.setText("Update Materi");
        UpdateMateriButton.setBorder(null);
        UpdateMateriButton.setBorderPainted(false);
        UpdateMateriButton.setFocusPainted(false);
        UpdateMateriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateMateriButtonActionPerformed(evt);
            }
        });

        ReferensiMateri2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        ReferensiMateri2.setForeground(new java.awt.Color(51, 153, 255));
        ReferensiMateri2.setText("ID Materi");

        IdMateriUpdateField.setEditable(false);
        IdMateriUpdateField.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        IdMateriUpdateField.setForeground(new java.awt.Color(51, 153, 255));
        IdMateriUpdateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdMateriUpdateFieldActionPerformed(evt);
            }
        });

        hapusMateriLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        hapusMateriLabel.setForeground(new java.awt.Color(51, 153, 255));
        hapusMateriLabel.setText("Hapus Materi");

        ReferensiMateri3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        ReferensiMateri3.setForeground(new java.awt.Color(51, 153, 255));
        ReferensiMateri3.setText("ID Materi");

        IdHapusMateriField.setEditable(false);
        IdHapusMateriField.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        IdHapusMateriField.setForeground(new java.awt.Color(51, 153, 255));
        IdHapusMateriField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdHapusMateriFieldActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Rectangle 79.png"))); // NOI18N
        jLabel4.setText("BG");

        HapusMateriButton.setBackground(new java.awt.Color(51, 153, 255));
        HapusMateriButton.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        HapusMateriButton.setForeground(new java.awt.Color(255, 255, 255));
        HapusMateriButton.setText("Delete Materi");
        HapusMateriButton.setBorder(null);
        HapusMateriButton.setBorderPainted(false);
        HapusMateriButton.setFocusPainted(false);
        HapusMateriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusMateriButtonActionPerformed(evt);
            }
        });

        PilihMateriButton.setBackground(new java.awt.Color(51, 153, 255));
        PilihMateriButton.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        PilihMateriButton.setForeground(new java.awt.Color(255, 255, 255));
        PilihMateriButton.setText("Get File");
        PilihMateriButton.setBorder(null);
        PilihMateriButton.setBorderPainted(false);
        PilihMateriButton.setFocusPainted(false);
        PilihMateriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PilihMateriButtonActionPerformed(evt);
            }
        });

        FileNameField.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        FileNameField.setForeground(new java.awt.Color(51, 153, 255));
        FileNameField.setEnabled(false);
        FileNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileNameFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pdfPanelLayout = new javax.swing.GroupLayout(pdfPanel);
        pdfPanel.setLayout(pdfPanelLayout);
        pdfPanelLayout.setHorizontalGroup(
            pdfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );
        pdfPanelLayout.setVerticalGroup(
            pdfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        pdfScrollPane.setViewportView(pdfPanel);

        javax.swing.GroupLayout AddMateriPanelLayout = new javax.swing.GroupLayout(AddMateriPanel);
        AddMateriPanel.setLayout(AddMateriPanelLayout);
        AddMateriPanelLayout.setHorizontalGroup(
            AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddMateriPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddMateriPanelLayout.createSequentialGroup()
                        .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JudulMateriLabel1)
                            .addComponent(ReferensiMateri)
                            .addComponent(penambahanMateriLabel)
                            .addComponent(modifikasiMaterilabel)
                            .addComponent(JudulMateriLabel2)
                            .addComponent(ReferensiMateri1)
                            .addComponent(ReferensiMateri2)
                            .addComponent(hapusMateriLabel)
                            .addComponent(ReferensiMateri3)
                            .addGroup(AddMateriPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NamaMateriField, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                .addComponent(NamaMateriUpdateField, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                .addComponent(FileNameField))
                            .addComponent(ReferensiMateriUpdateField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdMateriUpdateField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdHapusMateriField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HapusMateriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(UpdateMateriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddMateriPanelLayout.createSequentialGroup()
                        .addComponent(PilihMateriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddMateriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddMateriPanelLayout.createSequentialGroup()
                        .addComponent(materiSayaLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(AddMateriPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pdfScrollPane)))
                .addContainerGap())
        );
        AddMateriPanelLayout.setVerticalGroup(
            AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddMateriPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(materiSayaLabel)
                    .addComponent(penambahanMateriLabel))
                .addGap(14, 14, 14)
                .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddMateriPanelLayout.createSequentialGroup()
                        .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddMateriPanelLayout.createSequentialGroup()
                                .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NamaMateriField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JudulMateriLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ReferensiMateri)
                                    .addComponent(FileNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(AddMateriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PilihMateriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(modifikasiMaterilabel)
                                .addGap(18, 18, 18)
                                .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JudulMateriLabel2)
                                    .addComponent(NamaMateriUpdateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ReferensiMateri1)
                                    .addComponent(ReferensiMateriUpdateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ReferensiMateri2)
                                    .addComponent(IdMateriUpdateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(UpdateMateriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(hapusMateriLabel)
                        .addGap(18, 18, 18)
                        .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ReferensiMateri3)
                            .addComponent(IdHapusMateriField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddMateriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddMateriPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(40, 40, 40))
                            .addGroup(AddMateriPanelLayout.createSequentialGroup()
                                .addComponent(HapusMateriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(AddMateriPanelLayout.createSequentialGroup()
                        .addComponent(pdfScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        TabPane.addTab("tab1", AddMateriPanel);

        AddDiskusiPanel.setBackground(new java.awt.Color(255, 255, 255));
        AddDiskusiPanel.setLayout(null);

        TopikDiskusiLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        TopikDiskusiLabel.setForeground(new java.awt.Color(51, 153, 255));
        TopikDiskusiLabel.setText("Topik Diskusi");
        AddDiskusiPanel.add(TopikDiskusiLabel);
        TopikDiskusiLabel.setBounds(36, 143, 147, 29);

        TopikDiskusiField.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        TopikDiskusiField.setForeground(new java.awt.Color(51, 153, 255));
        TopikDiskusiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopikDiskusiFieldActionPerformed(evt);
            }
        });
        AddDiskusiPanel.add(TopikDiskusiField);
        TopikDiskusiField.setBounds(228, 140, 304, 35);

        NamaDiskusiLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        NamaDiskusiLabel.setForeground(new java.awt.Color(51, 153, 255));
        NamaDiskusiLabel.setText("Nama Diskusi");
        AddDiskusiPanel.add(NamaDiskusiLabel);
        NamaDiskusiLabel.setBounds(36, 87, 149, 29);

        NamaDiskusiField.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        NamaDiskusiField.setForeground(new java.awt.Color(51, 153, 255));
        NamaDiskusiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaDiskusiFieldActionPerformed(evt);
            }
        });
        AddDiskusiPanel.add(NamaDiskusiField);
        NamaDiskusiField.setBounds(228, 84, 304, 35);

        AddDiskusiButton.setBackground(new java.awt.Color(51, 153, 255));
        AddDiskusiButton.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        AddDiskusiButton.setForeground(new java.awt.Color(255, 255, 255));
        AddDiskusiButton.setText("Add Diskusi");
        AddDiskusiButton.setBorder(null);
        AddDiskusiButton.setBorderPainted(false);
        AddDiskusiButton.setFocusPainted(false);
        AddDiskusiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDiskusiButtonActionPerformed(evt);
            }
        });
        AddDiskusiPanel.add(AddDiskusiButton);
        AddDiskusiButton.setBounds(391, 196, 141, 41);

        DiskusiSayaTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DiskusiSayaTable.setForeground(new java.awt.Color(51, 153, 255));
        DiskusiSayaTable.setModel(new javax.swing.table.DefaultTableModel(
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
        DiskusiSayaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DiskusiSayaTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(DiskusiSayaTable);

        AddDiskusiPanel.add(jScrollPane2);
        jScrollPane2.setBounds(571, 84, 348, 402);

        penambahanDiskusiLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        penambahanDiskusiLabel.setForeground(new java.awt.Color(51, 153, 255));
        penambahanDiskusiLabel.setText("Penambahan Diskusi");
        AddDiskusiPanel.add(penambahanDiskusiLabel);
        penambahanDiskusiLabel.setBounds(36, 34, 226, 29);

        DiskusiLabel.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        DiskusiLabel.setForeground(new java.awt.Color(51, 153, 255));
        DiskusiLabel.setText("Diskusi Saya");
        AddDiskusiPanel.add(DiskusiLabel);
        DiskusiLabel.setBounds(571, 34, 138, 29);

        DiskusiSayaLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        DiskusiSayaLabel1.setForeground(new java.awt.Color(51, 153, 255));
        DiskusiSayaLabel1.setText("Diskusi");
        AddDiskusiPanel.add(DiskusiSayaLabel1);
        DiskusiSayaLabel1.setBounds(925, 34, 80, 29);

        DiskusiTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DiskusiTable.setForeground(new java.awt.Color(51, 153, 255));
        DiskusiTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(DiskusiTable);

        AddDiskusiPanel.add(jScrollPane3);
        jScrollPane3.setBounds(925, 84, 348, 402);

        penambahanDiskusiLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        penambahanDiskusiLabel1.setForeground(new java.awt.Color(51, 153, 255));
        penambahanDiskusiLabel1.setText("Modifikasi Diskusi");
        AddDiskusiPanel.add(penambahanDiskusiLabel1);
        penambahanDiskusiLabel1.setBounds(36, 243, 201, 29);

        NamaDiskusiLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        NamaDiskusiLabel1.setForeground(new java.awt.Color(51, 153, 255));
        NamaDiskusiLabel1.setText("Nama Diskusi");
        AddDiskusiPanel.add(NamaDiskusiLabel1);
        NamaDiskusiLabel1.setBounds(36, 296, 149, 29);

        TopikDiskusiLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        TopikDiskusiLabel1.setForeground(new java.awt.Color(51, 153, 255));
        TopikDiskusiLabel1.setText("Topik Diskusi");
        AddDiskusiPanel.add(TopikDiskusiLabel1);
        TopikDiskusiLabel1.setBounds(36, 352, 147, 29);

        TopikDiskusiLabel2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        TopikDiskusiLabel2.setForeground(new java.awt.Color(51, 153, 255));
        TopikDiskusiLabel2.setText("Id Diskusi");
        AddDiskusiPanel.add(TopikDiskusiLabel2);
        TopikDiskusiLabel2.setBounds(36, 408, 107, 29);

        NamaDiskusiUpdateField.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        NamaDiskusiUpdateField.setForeground(new java.awt.Color(51, 153, 255));
        NamaDiskusiUpdateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaDiskusiUpdateFieldActionPerformed(evt);
            }
        });
        AddDiskusiPanel.add(NamaDiskusiUpdateField);
        NamaDiskusiUpdateField.setBounds(228, 293, 304, 35);

        TopikDiskusiUpdateField.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        TopikDiskusiUpdateField.setForeground(new java.awt.Color(51, 153, 255));
        TopikDiskusiUpdateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopikDiskusiUpdateFieldActionPerformed(evt);
            }
        });
        AddDiskusiPanel.add(TopikDiskusiUpdateField);
        TopikDiskusiUpdateField.setBounds(228, 349, 304, 35);

        IdDiskusiUpdateField.setEditable(false);
        IdDiskusiUpdateField.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        IdDiskusiUpdateField.setForeground(new java.awt.Color(51, 153, 255));
        IdDiskusiUpdateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdDiskusiUpdateFieldActionPerformed(evt);
            }
        });
        AddDiskusiPanel.add(IdDiskusiUpdateField);
        IdDiskusiUpdateField.setBounds(228, 405, 304, 35);

        UpdateDiskusiButton.setBackground(new java.awt.Color(51, 153, 255));
        UpdateDiskusiButton.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        UpdateDiskusiButton.setForeground(new java.awt.Color(255, 255, 255));
        UpdateDiskusiButton.setText("Update Diskusi");
        UpdateDiskusiButton.setBorder(null);
        UpdateDiskusiButton.setBorderPainted(false);
        UpdateDiskusiButton.setFocusPainted(false);
        UpdateDiskusiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateDiskusiButtonActionPerformed(evt);
            }
        });
        AddDiskusiPanel.add(UpdateDiskusiButton);
        UpdateDiskusiButton.setBounds(356, 461, 176, 38);

        penambahanDiskusiLabel2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        penambahanDiskusiLabel2.setForeground(new java.awt.Color(51, 153, 255));
        penambahanDiskusiLabel2.setText("Hapus Diskusi");
        AddDiskusiPanel.add(penambahanDiskusiLabel2);
        penambahanDiskusiLabel2.setBounds(36, 509, 155, 29);

        TopikDiskusiLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        TopikDiskusiLabel3.setForeground(new java.awt.Color(51, 153, 255));
        TopikDiskusiLabel3.setText("Id Diskusi");
        AddDiskusiPanel.add(TopikDiskusiLabel3);
        TopikDiskusiLabel3.setBounds(36, 562, 107, 29);

        IdDiskusiHapusField.setEditable(false);
        IdDiskusiHapusField.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        IdDiskusiHapusField.setForeground(new java.awt.Color(51, 153, 255));
        IdDiskusiHapusField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdDiskusiHapusFieldActionPerformed(evt);
            }
        });
        AddDiskusiPanel.add(IdDiskusiHapusField);
        IdDiskusiHapusField.setBounds(228, 559, 304, 35);

        HapusDiskusiButton.setBackground(new java.awt.Color(51, 153, 255));
        HapusDiskusiButton.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        HapusDiskusiButton.setForeground(new java.awt.Color(255, 255, 255));
        HapusDiskusiButton.setText("Hapus Diskusi");
        HapusDiskusiButton.setBorder(null);
        HapusDiskusiButton.setBorderPainted(false);
        HapusDiskusiButton.setFocusPainted(false);
        HapusDiskusiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusDiskusiButtonActionPerformed(evt);
            }
        });
        AddDiskusiPanel.add(HapusDiskusiButton);
        HapusDiskusiButton.setBounds(366, 615, 155, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Rectangle 79.png"))); // NOI18N
        AddDiskusiPanel.add(jLabel6);
        jLabel6.setBounds(0, 6, 1290, 800);

        TabPane.addTab("tab1", AddDiskusiPanel);

        getContentPane().add(TabPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, 840));

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));

        DiskusiNavigator.setBackground(new java.awt.Color(0, 0, 51));
        DiskusiNavigator.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DiskusiNavigator.setForeground(new java.awt.Color(255, 255, 255));
        DiskusiNavigator.setText("Diskusi");
        DiskusiNavigator.setBorder(null);
        DiskusiNavigator.setBorderPainted(false);
        DiskusiNavigator.setContentAreaFilled(false);
        DiskusiNavigator.setFocusPainted(false);
        DiskusiNavigator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiskusiNavigatorActionPerformed(evt);
            }
        });

        MateriNavigator.setBackground(new java.awt.Color(51, 153, 255));
        MateriNavigator.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MateriNavigator.setForeground(new java.awt.Color(255, 255, 255));
        MateriNavigator.setText("Materi");
        MateriNavigator.setBorder(null);
        MateriNavigator.setBorderPainted(false);
        MateriNavigator.setFocusPainted(false);
        MateriNavigator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MateriNavigatorActionPerformed(evt);
            }
        });

        ProfileNavigator.setBackground(new java.awt.Color(0, 0, 51));
        ProfileNavigator.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ProfileNavigator.setForeground(new java.awt.Color(255, 255, 255));
        ProfileNavigator.setText("Profile");
        ProfileNavigator.setBorder(null);
        ProfileNavigator.setBorderPainted(false);
        ProfileNavigator.setContentAreaFilled(false);
        ProfileNavigator.setFocusPainted(false);
        ProfileNavigator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileNavigatorActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MENU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MateriNavigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ProfileNavigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DiskusiNavigator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfileNavigator, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MateriNavigator, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DiskusiNavigator, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(628, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NamaDiskusiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaDiskusiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaDiskusiFieldActionPerformed

    private void TopikDiskusiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopikDiskusiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TopikDiskusiFieldActionPerformed

    private void NamaMateriFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaMateriFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaMateriFieldActionPerformed

    private void AddMateriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMateriButtonActionPerformed
        if(NamaMateriField.getText().isEmpty() || FileNameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill all fields");
            return;
        }
        // TODO add foreign key to lecturer. Perlu yang buat login 😊.
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO materi(judul_materi, data_materi, id_lecturer) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, NamaMateriField.getText());
            statement.setBinaryStream(2, fis, (int) selectedFile.length());
            statement.setInt(3, login.currentUser.getId());

            statement.execute();
            fis.close();
            selectedFile = null;
            
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Berhasil menambahkan materi");
            loadMateriData();
            
            CleanUpMateri();
        }
        catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_AddMateriButtonActionPerformed

    private void AddDiskusiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDiskusiButtonActionPerformed
        if(NamaDiskusiField.getText().isEmpty() || TopikDiskusiField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill all fields");
            return;
        }
        // TODO add foreign key to lecturer. Perlu yang buat login 😊.
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO diskusi(nama_diskusi, topik_diskusi) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, NamaDiskusiField.getText());
            statement.setString(2, TopikDiskusiField.getText());

            statement.execute();
            
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Berhasil menambahkan diskusi");
            loadDiskusiData();
            loadDiskusiDataSaya();
            CleanUpDiskusi();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_AddDiskusiButtonActionPerformed

    private void MateriTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MateriTableMouseClicked
        int i = MateriTable.getSelectedRow();
        TableModel model = MateriTable.getModel();
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM materi WHERE id_materi = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setInt(1, Integer.parseInt(model.getValueAt(i, 0).toString()));

            
            ResultSet resultSet = statement.executeQuery();
            

            if (resultSet.next()) {
                Blob blob = resultSet.getBlob("data_materi");
                InputStream inputStream = blob.getBinaryStream();

                PDDocument document = PDDocument.load(inputStream);
                PDFRenderer pdfRenderer = new PDFRenderer(document);

                int numPages = document.getNumberOfPages();
                pdfPanel.removeAll();
                pdfPanel.setLayout(new GridLayout(numPages, 1));

                for (int j = 0; j < numPages; j++) {
                    BufferedImage image = pdfRenderer.renderImageWithDPI(j, 100);
                    JLabel label = new JLabel(new ImageIcon(image));
                    pdfPanel.add(label);
                }

                pdfScrollPane.revalidate();
                pdfScrollPane.repaint();
            } else {
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        
        NamaMateriUpdateField.setText(model.getValueAt(i, 1).toString());
        IdMateriUpdateField.setText(model.getValueAt(i, 0).toString());
        
        IdHapusMateriField.setText(model.getValueAt(i, 0).toString());
    }//GEN-LAST:event_MateriTableMouseClicked

    private void NamaMateriUpdateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaMateriUpdateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaMateriUpdateFieldActionPerformed

    private void ReferensiMateriUpdateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReferensiMateriUpdateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReferensiMateriUpdateFieldActionPerformed

    private void UpdateMateriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateMateriButtonActionPerformed
        if(NamaMateriUpdateField.getText().isEmpty() || ReferensiMateriUpdateField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill all fields");
            return;
        }
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "UPDATE materi SET judul_materi = ?, referensi_materi = ? WHERE id_materi = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, NamaMateriUpdateField.getText());
            statement.setString(2,ReferensiMateriUpdateField.getText());
            statement.setString(3, IdMateriUpdateField.getText());

            statement.execute();
            
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Berhasil memperbarui materi");
            loadMateriData();
            CleanUpMateri();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_UpdateMateriButtonActionPerformed

    private void IdMateriUpdateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdMateriUpdateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdMateriUpdateFieldActionPerformed

    private void IdHapusMateriFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdHapusMateriFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdHapusMateriFieldActionPerformed

    private void NamaDiskusiUpdateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaDiskusiUpdateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaDiskusiUpdateFieldActionPerformed

    private void TopikDiskusiUpdateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopikDiskusiUpdateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TopikDiskusiUpdateFieldActionPerformed

    private void IdDiskusiUpdateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdDiskusiUpdateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdDiskusiUpdateFieldActionPerformed

    private void UpdateDiskusiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateDiskusiButtonActionPerformed
        if(NamaDiskusiUpdateField.getText().isEmpty() || TopikDiskusiUpdateField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill all fields");
            return;
        }
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "UPDATE diskusi SET nama_diskusi = ?, topik_diskusi = ? WHERE id_diskusi= ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, NamaDiskusiUpdateField.getText());
            statement.setString(2,TopikDiskusiUpdateField.getText());
            statement.setString(3, IdDiskusiUpdateField.getText());

            statement.execute();
            
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Berhasil memperbarui diskusi");
            loadDiskusiDataSaya();
            loadDiskusiData();
            CleanUpDiskusi();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_UpdateDiskusiButtonActionPerformed

    private void DiskusiSayaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DiskusiSayaTableMouseClicked
        int i = DiskusiSayaTable.getSelectedRow();
        TableModel model = DiskusiSayaTable.getModel();
        
        NamaDiskusiUpdateField.setText(model.getValueAt(i, 1).toString());
        TopikDiskusiUpdateField.setText(model.getValueAt(i, 2).toString());
        IdDiskusiUpdateField.setText(model.getValueAt(i, 0).toString());
        
        IdDiskusiHapusField.setText(model.getValueAt(i, 0).toString());
    }//GEN-LAST:event_DiskusiSayaTableMouseClicked

    private void IdDiskusiHapusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdDiskusiHapusFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdDiskusiHapusFieldActionPerformed

    private void HapusDiskusiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusDiskusiButtonActionPerformed
        int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus diskusi?");
        
        if(pilihan != 0) return;
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "DELETE FROM diskusi WHERE id_diskusi = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, IdDiskusiHapusField.getText());
            
            statement.execute();
            
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Berhasil menghapus diskusi");
            loadDiskusiData();
            loadDiskusiDataSaya();
            CleanUpDiskusi();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_HapusDiskusiButtonActionPerformed

    private void MateriNavigatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MateriNavigatorActionPerformed
        TabPane.setSelectedIndex(0);
        ProfileNavigator.setContentAreaFilled(false);
        ProfileNavigator.setBackground(new Color(0, 0, 51));
        
        DiskusiNavigator.setContentAreaFilled(false);
        DiskusiNavigator.setBackground(new Color(0, 0, 51));
        
        MateriNavigator.setContentAreaFilled(true);
        MateriNavigator.setBackground(new Color(51, 153, 255));
    }//GEN-LAST:event_MateriNavigatorActionPerformed

    private void DiskusiNavigatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiskusiNavigatorActionPerformed
        TabPane.setSelectedIndex(1);
        ProfileNavigator.setContentAreaFilled(false);
        ProfileNavigator.setBackground(new Color(0, 0, 51));
        
        DiskusiNavigator.setContentAreaFilled(true);
        DiskusiNavigator.setBackground(new Color(51, 153, 255));
        
        MateriNavigator.setContentAreaFilled(false);
        MateriNavigator.setBackground(new Color(0, 0, 51));
    }//GEN-LAST:event_DiskusiNavigatorActionPerformed

    private void ProfileNavigatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileNavigatorActionPerformed
        ProfileNavigator.setContentAreaFilled(true);
        ProfileNavigator.setBackground(new Color(51, 153, 255));
        
        DiskusiNavigator.setContentAreaFilled(false);
        DiskusiNavigator.setBackground(new Color(0, 0, 51));
        
        MateriNavigator.setContentAreaFilled(false);
        MateriNavigator.setBackground(new Color(0, 0, 51));
    }//GEN-LAST:event_ProfileNavigatorActionPerformed

    private void HapusMateriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusMateriButtonActionPerformed
        int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus materi?");

        if(pilihan != 0) return;

        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "DELETE FROM materi WHERE id_materi = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, IdHapusMateriField.getText());

            statement.execute();

            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Berhasil menghapus materi");
            loadMateriData();
            CleanUpMateri();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_HapusMateriButtonActionPerformed

    private void PilihMateriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PilihMateriButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int option = fileChooser.showOpenDialog(this);
        
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                fis = new FileInputStream(selectedFile);
                
                FileNameField.setText(selectedFile.getAbsolutePath());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        }
    }//GEN-LAST:event_PilihMateriButtonActionPerformed

    private void FileNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileNameFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lecturer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddDiskusiButton;
    private javax.swing.JPanel AddDiskusiPanel;
    private javax.swing.JButton AddMateriButton;
    private javax.swing.JPanel AddMateriPanel;
    private javax.swing.JLabel DiskusiLabel;
    private javax.swing.JButton DiskusiNavigator;
    private javax.swing.JLabel DiskusiSayaLabel1;
    private javax.swing.JTable DiskusiSayaTable;
    private javax.swing.JTable DiskusiTable;
    private javax.swing.JTextField FileNameField;
    private javax.swing.JButton HapusDiskusiButton;
    private javax.swing.JButton HapusMateriButton;
    private javax.swing.JTextField IdDiskusiHapusField;
    private javax.swing.JTextField IdDiskusiUpdateField;
    private javax.swing.JTextField IdHapusMateriField;
    private javax.swing.JTextField IdMateriUpdateField;
    private javax.swing.JLabel JudulMateriLabel1;
    private javax.swing.JLabel JudulMateriLabel2;
    private javax.swing.JButton MateriNavigator;
    private javax.swing.JTable MateriTable;
    private javax.swing.JTextField NamaDiskusiField;
    private javax.swing.JLabel NamaDiskusiLabel;
    private javax.swing.JLabel NamaDiskusiLabel1;
    private javax.swing.JTextField NamaDiskusiUpdateField;
    private javax.swing.JTextField NamaMateriField;
    private javax.swing.JTextField NamaMateriUpdateField;
    private javax.swing.JButton PilihMateriButton;
    private javax.swing.JButton ProfileNavigator;
    private javax.swing.JLabel ReferensiMateri;
    private javax.swing.JLabel ReferensiMateri1;
    private javax.swing.JLabel ReferensiMateri2;
    private javax.swing.JLabel ReferensiMateri3;
    private javax.swing.JTextField ReferensiMateriUpdateField;
    private javax.swing.JTabbedPane TabPane;
    private javax.swing.JTextField TopikDiskusiField;
    private javax.swing.JLabel TopikDiskusiLabel;
    private javax.swing.JLabel TopikDiskusiLabel1;
    private javax.swing.JLabel TopikDiskusiLabel2;
    private javax.swing.JLabel TopikDiskusiLabel3;
    private javax.swing.JTextField TopikDiskusiUpdateField;
    private javax.swing.JButton UpdateDiskusiButton;
    private javax.swing.JButton UpdateMateriButton;
    private javax.swing.JLabel hapusMateriLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel materiSayaLabel;
    private javax.swing.JLabel modifikasiMaterilabel;
    private javax.swing.JPanel pdfPanel;
    private javax.swing.JScrollPane pdfScrollPane;
    private javax.swing.JLabel penambahanDiskusiLabel;
    private javax.swing.JLabel penambahanDiskusiLabel1;
    private javax.swing.JLabel penambahanDiskusiLabel2;
    private javax.swing.JLabel penambahanMateriLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
