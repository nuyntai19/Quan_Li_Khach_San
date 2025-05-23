package UI;

import BLL.DanhSachTamCTPhieuThuePhong;
import DTO.ChiTietPhieuThuePhongDTO;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class ChiTietPhieuThuePhong extends javax.swing.JFrame {

    private DefaultTableModel model;
    
    public ChiTietPhieuThuePhong() {
        initComponents();
        model = (DefaultTableModel) tblDSCHIPHIETPHIEUTHUEPHONGTA.getModel();
        loadData();
        
        JTableHeader header = tblDSCHIPHIETPHIEUTHUEPHONGTA.getTableHeader(); 
        header.setFont(new Font("Arial", Font.BOLD, 12));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        
    }
    
    private void loadData() {
        try {
            List<ChiTietPhieuThuePhongDTO> danhSachChiTiet = DanhSachTamCTPhieuThuePhong.getDanhSachChiTiet();
            model.setRowCount(0); // Xóa bảng trước khi cập nhật

            for (ChiTietPhieuThuePhongDTO chiTiet : danhSachChiTiet) {
                model.addRow(new Object[] {
                    chiTiet.getMaThuePhong(), chiTiet.getMaPhong(), chiTiet.getNgayDatPhong(),
                    chiTiet.getNgayTraPhong(), chiTiet.getGiaPhong(), chiTiet.getThanhTien()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        lbDangNhap = new javax.swing.JLabel();
        TXDangNhap = new javax.swing.JTextField();
        TXMK = new javax.swing.JTextField();
        NutDangNhap = new javax.swing.JButton();
        labelMK = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DSPhong = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        bGNam_Nu = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePhongTrong = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lbHo1 = new javax.swing.JLabel();
        lbGioiTinh = new javax.swing.JLabel();
        RBNu = new javax.swing.JRadioButton();
        RBNam = new javax.swing.JRadioButton();
        TXKhachHang1 = new javax.swing.JTextField();
        lbHo = new javax.swing.JLabel();
        TXKhachHang2 = new javax.swing.JTextField();
        TXKhachHang3 = new javax.swing.JTextField();
        lbKH1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        lbNgaySinh = new javax.swing.JLabel();
        DCNgaySinh = new com.toedter.calendar.JDateChooser();
        TXEmail = new javax.swing.JTextField();
        TXTenLP1 = new javax.swing.JTextField();
        lbTenLP1 = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbSoGiuong1 = new javax.swing.JLabel();
        TXSoGiuong1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDSCHIPHIETPHIEUTHUEPHONGTA = new javax.swing.JTable();
        ButtonThoat = new javax.swing.JButton();
        ButtonXoa = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        jButton9.setText("jButton3");

        jLabel2.setBackground(new java.awt.Color(102, 204, 0));
        jLabel2.setText(".ftyghb");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        menu5.setLabel("File");
        menuBar3.add(menu5);

        menu6.setLabel("Edit");
        menuBar3.add(menu6);

        lbDangNhap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbDangNhap.setText("Tên đăng nhập:");

        NutDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NutDangNhap.setText("Đăng Nhập");

        labelMK.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelMK.setText("Mật khẩu: ");
        labelMK.setPreferredSize(new java.awt.Dimension(90, 17));

        jLabel3.setText("jLabel3");

        DSPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DSPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/room.png"))); // NOI18N
        DSPhong.setText("Danh Sách Phòng");
        DSPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        TablePhongTrong.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablePhongTrong);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        lbHo1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbHo1.setText("Tên:");

        lbGioiTinh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbGioiTinh.setText("Giới tính:");

        bGNam_Nu.add(RBNu);
        RBNu.setText("Nữ");

        bGNam_Nu.add(RBNam);
        RBNam.setText("Nam");
        RBNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBNamActionPerformed(evt);
            }
        });

        TXKhachHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXKhachHang1ActionPerformed(evt);
            }
        });

        lbHo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbHo.setText("Họ:");

        TXKhachHang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXKhachHang2ActionPerformed(evt);
            }
        });

        TXKhachHang3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXKhachHang3ActionPerformed(evt);
            }
        });

        lbKH1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbKH1.setText("Số điện thoại:");

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(52, 152, 219));
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField2.setEnabled(false);

        lbNgaySinh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbNgaySinh.setText("Ngày sinh:");

        TXEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXEmailActionPerformed(evt);
            }
        });

        TXTenLP1.setEditable(false);
        TXTenLP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTenLP1ActionPerformed(evt);
            }
        });

        lbTenLP1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTenLP1.setText("Mô tả phòng:");

        lbEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbEmail.setText("Email:");

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
        jScrollPane2.setViewportView(jTable1);

        lbSoGiuong1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbSoGiuong1.setText("Giá phòng thuê:");

        TXSoGiuong1.setEditable(false);
        TXSoGiuong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXSoGiuong1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DatPhong");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 152, 219));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHI TIẾT ĐẶT PHÒNG");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(52, 152, 219));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField1.setEnabled(false);

        tblDSCHIPHIETPHIEUTHUEPHONGTA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã đặt phòng", "Mã phòng", "Ngày đặt phòng", "Ngày trả phòng", "Giá phòng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblDSCHIPHIETPHIEUTHUEPHONGTA);

        ButtonThoat.setBackground(new java.awt.Color(52, 152, 219));
        ButtonThoat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonThoat.setForeground(new java.awt.Color(255, 255, 255));
        ButtonThoat.setText("Thoát");
        ButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonThoatActionPerformed(evt);
            }
        });

        ButtonXoa.setBackground(new java.awt.Color(52, 152, 219));
        ButtonXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonXoa.setForeground(new java.awt.Color(255, 255, 255));
        ButtonXoa.setText("Xóa");
        ButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTextField1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(362, 362, 362))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonThoat)
                    .addComponent(ButtonXoa))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXSoGiuong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXSoGiuong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXSoGiuong1ActionPerformed

    private void TXTenLP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTenLP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTenLP1ActionPerformed

    private void TXKhachHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXKhachHang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXKhachHang1ActionPerformed

    private void TXKhachHang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXKhachHang2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXKhachHang2ActionPerformed

    private void TXKhachHang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXKhachHang3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXKhachHang3ActionPerformed

    private void TXEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXEmailActionPerformed

    private void RBNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBNamActionPerformed

    private void ButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonThoatActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose(); // Đóng cửa sổ hiện tại
        }

    }//GEN-LAST:event_ButtonThoatActionPerformed

    private void ButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonXoaActionPerformed
        try {
        int selectedRow = tblDSCHIPHIETPHIEUTHUEPHONGTA.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng muốn đặt cần xóa.");
            return;
        }

        int maPhong = (int) tblDSCHIPHIETPHIEUTHUEPHONGTA.getValueAt(selectedRow, 1); 
        int maDatPhong = (int) tblDSCHIPHIETPHIEUTHUEPHONGTA.getValueAt(selectedRow, 0); 

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa phòng cần đặt có mã phòng: " + maPhong + "?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Xóa khỏi danh sách tạm
            List<ChiTietPhieuThuePhongDTO> ds = BLL.DanhSachTamCTPhieuThuePhong.getDanhSachChiTiet();
            ds.removeIf(ct -> ct.getMaPhong() == maPhong && ct.getMaThuePhong() == maDatPhong);

            // Xóa khỏi bảng giao diện
            DefaultTableModel model = (DefaultTableModel) tblDSCHIPHIETPHIEUTHUEPHONGTA.getModel();
            model.removeRow(selectedRow);

            JOptionPane.showMessageDialog(this, "Đã xóa phòng cần đặt khỏi danh sách tạm.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
    }
    }//GEN-LAST:event_ButtonXoaActionPerformed

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
            java.util.logging.Logger.getLogger(ChiTietPhieuThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietPhieuThuePhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonThoat;
    private javax.swing.JButton ButtonXoa;
    private com.toedter.calendar.JDateChooser DCNgaySinh;
    private javax.swing.JButton DSPhong;
    private javax.swing.JButton NutDangNhap;
    private javax.swing.JRadioButton RBNam;
    private javax.swing.JRadioButton RBNu;
    private javax.swing.JTextField TXDangNhap;
    private javax.swing.JTextField TXEmail;
    private javax.swing.JTextField TXKhachHang1;
    private javax.swing.JTextField TXKhachHang2;
    private javax.swing.JTextField TXKhachHang3;
    private javax.swing.JTextField TXMK;
    private javax.swing.JTextField TXSoGiuong1;
    private javax.swing.JTextField TXTenLP1;
    private javax.swing.JTable TablePhongTrong;
    private javax.swing.ButtonGroup bGNam_Nu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelMK;
    private javax.swing.JLabel lbDangNhap;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbHo;
    private javax.swing.JLabel lbHo1;
    private javax.swing.JLabel lbKH1;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbSoGiuong1;
    private javax.swing.JLabel lbTenLP1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    private javax.swing.JTable tblDSCHIPHIETPHIEUTHUEPHONGTA;
    // End of variables declaration//GEN-END:variables
}
