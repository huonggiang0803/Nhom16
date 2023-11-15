package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.JDBCUtil;
import model.DichVu;
import model.NhanVien;
import model.Thuoc;
import model.bacSi;
import model.benhNhan;
import service.ServiceBacSi;
import service.ServiceDichVu;
import service.ServicebenhNhan;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ThuTucKhamBenh extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTable table;
	benhNhan bn;
	ServicebenhNhan serviceBN;
	bacSi bs;
	ServiceBacSi serviceBS;
	DefaultTableModel model;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_19;
	private JTable table_1;
	private JTextField textField_18;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThuTucKhamBenh frame = new ThuTucKhamBenh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThuTucKhamBenh() {
		ServiceDichVu serviceDV = new ServiceDichVu();
		bn = new benhNhan();
		serviceBN = new ServicebenhNhan();
		bs = new bacSi();
		serviceBS = new ServiceBacSi();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 589, 436);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 588, 436);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Thủ tục khám bệnh", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 22, 492, 132);
		panel_1.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("STT");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		panel_1_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã BN");
		lblNewLabel_2.setBounds(10, 43, 46, 14);
		panel_1_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Đối tượng");
		lblNewLabel_3.setBounds(10, 68, 58, 14);
		panel_1_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày sinh");
		lblNewLabel_4.setBounds(10, 95, 58, 14);
		panel_1_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ngày ĐK");
		lblNewLabel_5.setBounds(273, 11, 59, 14);
		panel_1_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tên BN");
		lblNewLabel_6.setBounds(273, 43, 46, 14);
		panel_1_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mã BH");
		lblNewLabel_7.setBounds(273, 68, 46, 14);
		panel_1_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("TTSK");
		lblNewLabel_8.setBounds(273, 95, 46, 14);
		panel_1_1.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(95, 8, 127, 20);
		panel_1_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(342, 40, 127, 20);
		panel_1_1.add(textField_8);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(342, 8, 127, 20);
		panel_1_1.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(342, 65, 127, 20);
		panel_1_1.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(342, 92, 127, 20);
		panel_1_1.add(textField_13);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(95, 39, 127, 22);
		panel_1_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 165, 492, 106);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 493, 95);
		panel_2.add(scrollPane);
		 
		table = new JTable();
        scrollPane.setViewportView(table);
        model = new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null},
                },
                new String[]{
                        "STT", "Mã BN", "Tên BN", "Ngày sinh", "Ngày ĐK", "Đối tượng", "Mã BH", "Ngày sinh"
                }
        );
        table.setModel(model);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Bảo hiểm", "Không bảo hiểm"}));
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedDoiTuong = (String) comboBox_1.getSelectedItem();
		        
				if (selectedDoiTuong.equals("Bảo hiểm")) {
					textField_12.setVisible(true); // Hiển thị trường mã BH khi chọn "Bảo hiểm y tế"
		        } else {
		        	textField_12.setVisible(false); // Ẩn trường mã BH khi chọn "Không bảo hiểm y tế"
		        }
			}
		});
		comboBox_1.setBounds(95, 64, 127, 22);
		panel_1_1.add(comboBox_1);

		List<benhNhan> danhSachBenhNhan = serviceBN.getAllBN();
				// Convert benhNhan objects to BenhNhanComboBoxItem objects
		benhNhan[] comboBoxItems = danhSachBenhNhan.toArray(new benhNhan[0]);
		// Create a DefaultComboBoxModel with the array of BenhNhanComboBoxItem
		DefaultComboBoxModel<benhNhan> comboBoxModel = new DefaultComboBoxModel<>(comboBoxItems);

		// Set the model to your JComboBox
		comboBox.setModel(comboBoxModel);
		comboBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Lấy đối tượng được chọn từ comboBox (trong trường hợp này là benhNhan)
		        benhNhan selectedObject = (benhNhan) comboBox.getSelectedItem();

		        // Hiển thị tên bệnh nhân lên textField_8
		        textField_8.setText(selectedObject.getTenBN());
		        
		        // Format ngày sinh và hiển thị lên textField_9
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        String formattedNgaySinh = dateFormat.format(selectedObject.getNgaySinh());
		        textField_9.setText(formattedNgaySinh);
		    }
		});
	    
	    textField_9 = new JTextField();
	    textField_9.setColumns(10);
	    textField_9.setBounds(95, 92, 127, 20);
	    panel_1_1.add(textField_9);
	    
	    JButton btnNewButton_2 = new JButton("Xóa");
	    btnNewButton_2.setBounds(207, 296, 89, 23);
	    panel_1.add(btnNewButton_2);
	    
	    JButton btnNewButton_1 = new JButton("Refresh");
	    btnNewButton_1.setBounds(108, 296, 89, 23);
	    panel_1.add(btnNewButton_1);
	    
	    JButton btnNewButton = new JButton("Thêm");
	    btnNewButton.setBounds(10, 296, 89, 23);
	    panel_1.add(btnNewButton);
	    
	    JButton btnNewButton_4 = new JButton("Thoát");
	    btnNewButton_4.setBounds(420, 296, 82, 23);
	    panel_1.add(btnNewButton_4);
	    
	    JButton btnNewButton_3 = new JButton("Tìm kiếm");
	    btnNewButton_3.setBounds(318, 294, 89, 26);
	    panel_1.add(btnNewButton_3);
	    btnNewButton_3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String stt = textField_7.getText();
	            searchRecords(stt);
	    	}
	    });
	    btnNewButton_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new DangNhapHeThong().setVisible(true);
	    	}
	    });
	    btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String STT = textField_7.getText();
                    String maBN = ((benhNhan) comboBox.getSelectedItem()).getMaBN();
                    String tenBN = textField_8.getText();
                    String ngaySinh = textField_9.getText();
                    String selectedDoiTuong = comboBox_1.getSelectedItem().toString();
                    String maBH = (selectedDoiTuong.equals("Bảo hiểm")) ? textField_12.getText() : null;
                    String ngayDK = textField_11.getText();
                    String TTSK = textField_13.getText();

                    Connection con = JDBCUtil.getConnection();

                    String insertOrUpdateSql = "INSERT INTO ttkb (STT, maBN, tenBN, ngaySinh, doiTuong, maBH, ngayDK, TTSK) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?) " +
                            "ON DUPLICATE KEY UPDATE " +
                            "STT = VALUES(STT), maBN = VALUES(maBN), tenBN = VALUES(tenBN), " +
                            "ngaySinh = VALUES(ngaySinh), doiTuong = VALUES(doiTuong), " +
                            "maBH = VALUES(maBH), ngayDK = VALUES(ngayDK), TTSK = VALUES(TTSK)";

                    PreparedStatement insertOrUpdateSt = con.prepareStatement(insertOrUpdateSql);
                    insertOrUpdateSt.setString(1, STT);
                    insertOrUpdateSt.setString(2, maBN);
                    insertOrUpdateSt.setString(3, tenBN);
                    insertOrUpdateSt.setString(4, ngaySinh);
                    insertOrUpdateSt.setString(5, selectedDoiTuong);
                    insertOrUpdateSt.setString(6, maBH);
                    insertOrUpdateSt.setString(7, ngayDK);
                    insertOrUpdateSt.setString(8, TTSK);

                    int result = insertOrUpdateSt.executeUpdate();
                    if (result > 0) {
                        System.out.println("Thêm thông tin thành công!");
                    } else {
                        System.out.println("Thêm thông tin thất bại!");
                    }

                    // Đóng tài nguyên
                    insertOrUpdateSt.close();
                    JDBCUtil.closeConnection(con);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
	    
            model.setRowCount(0);

           

	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Connection con = JDBCUtil.getConnection();

                // Truy vấn SELECT để lấy dữ liệu từ bảng TTKB
                String selectSql = "SELECT * FROM ttkb";
                try {
                    PreparedStatement selectSt = con.prepareStatement(selectSql);
                    ResultSet resultSet = selectSt.executeQuery();

                    // Clear existing rows in the table
                    model.setRowCount(0);

                    // Populate the table with the fetched data
                    while (resultSet.next()) {
                        Vector<Object> row = new Vector<>();
                        row.add(resultSet.getString("STT"));
                        row.add(resultSet.getString("maBN"));
                        row.add(resultSet.getString("tenBN"));
                        row.add(resultSet.getString("ngaySinh"));
                        row.add(resultSet.getString("ngayDK"));
                        row.add(resultSet.getString("doiTuong"));
                        row.add(resultSet.getString("maBH"));
                        row.add(resultSet.getString("ngaySinh"));
                        model.addRow(row);
                    }

                    // Đóng tài nguyên
                    resultSet.close();
                    selectSt.close();
                    JDBCUtil.closeConnection(con);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
	    	}
	    });
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Chọn một dòng để xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String maBNToDelete = model.getValueAt(selectedRow, 1).toString();
                deleteRecord(maBNToDelete);
	    	}
	    });
	    
	    JPanel panel_4 = new JPanel();
	    tabbedPane.addTab("Kết quả khám bệnh", null, panel_4, null);
	    panel_4.setLayout(null);
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBounds(10, 11, 551, 201);
	    panel_4.add(panel_3);
	    panel_3.setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("Mã KQKB");
	    lblNewLabel.setBounds(10, 11, 67, 14);
	    panel_3.add(lblNewLabel);
	    
	    JLabel lblNewLabel_9 = new JLabel("Mã BN");
	    lblNewLabel_9.setBounds(10, 48, 46, 14);
	    panel_3.add(lblNewLabel_9);
	    
	    JLabel lblNewLabel_10 = new JLabel("Tên BS");
	    lblNewLabel_10.setBounds(256, 90, 46, 14);
	    panel_3.add(lblNewLabel_10);
	    
	    JLabel lblNewLabel_11 = new JLabel("Khoa");
	    lblNewLabel_11.setBounds(10, 131, 46, 14);
	    panel_3.add(lblNewLabel_11);
	    
	    JLabel lblNewLabel_12 = new JLabel("Dịch Vụ");
	    lblNewLabel_12.setBounds(256, 11, 46, 14);
	    panel_3.add(lblNewLabel_12);
	    
	    JLabel lblNewLabel_13 = new JLabel("Tên BN");
	    lblNewLabel_13.setBounds(256, 48, 46, 14);
	    panel_3.add(lblNewLabel_13);
	    
	    JLabel lblNewLabel_14 = new JLabel("Mã BS");
	    lblNewLabel_14.setBounds(10, 90, 46, 14);
	    panel_3.add(lblNewLabel_14);
	    
	    JLabel lblNewLabel_15 = new JLabel("Ngày khám");
	    lblNewLabel_15.setBounds(256, 131, 65, 14);
	    panel_3.add(lblNewLabel_15);
	    
	    JLabel lblNewLabel_16 = new JLabel("Kết luận");
	    lblNewLabel_16.setBounds(10, 167, 46, 14);
	    panel_3.add(lblNewLabel_16);
	    
	    textField_10 = new JTextField();
	    textField_10.setBounds(87, 8, 134, 20);
	    panel_3.add(textField_10);
	    textField_10.setColumns(10);
	    
	    textField_15 = new JTextField();
	    textField_15.setColumns(10);
	    textField_15.setBounds(337, 45, 134, 20);
	    panel_3.add(textField_15);
	    
	    textField_16 = new JTextField();
	    textField_16.setColumns(10);
	    textField_16.setBounds(337, 87, 134, 20);
	    panel_3.add(textField_16);
	    
	    textField_17 = new JTextField();
	    textField_17.setColumns(10);
	    textField_17.setBounds(337, 128, 134, 20);
	    panel_3.add(textField_17);
	    
	    textField_19 = new JTextField();
	    textField_19.setColumns(10);
	    textField_19.setBounds(87, 164, 384, 20);
	    panel_3.add(textField_19);
	    
	    JComboBox comboBox_2 = new JComboBox();
	    comboBox_2.setBounds(87, 44, 134, 22);
	    panel_3.add(comboBox_2);
	    
	    JComboBox comboBox_2_1 = new JComboBox();
	    comboBox_2_1.setBounds(87, 86, 134, 22);
	    panel_3.add(comboBox_2_1);
	    
	    JPanel panel_5 = new JPanel();
	    panel_5.setBounds(10, 223, 551, 121);
	    panel_4.add(panel_5);
	    panel_5.setLayout(null);
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(0, 0, 553, 122);
	    panel_5.add(scrollPane_1);
	    
	    table_1 = new JTable();
	    scrollPane_1.setViewportView(table_1);
	    model = new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null, null, null, null, null, null},
	    	},
	    	new String[] {
	    		"M\u00E3 PKQKB", "M\u00E3 BN", "T\u00EAn BN", "M\u00E3 BS", "T\u00EAn BS", "Khoa", "Ng\u00E0y kh\u00E1m", "D\u1ECBch v\u1EE5", "K\u1EBFt lu\u1EADn"
	    	}
	    );
	    table_1.setModel(model);
	    JComboBox comboBox_3 = new JComboBox();
	     comboBox_3.setBounds(337, 7, 134, 22);
	     panel_3.add(comboBox_3);
	    JButton btnNewButton_5 = new JButton("Thêm");
	    btnNewButton_5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	                String maPhieuKetQua = textField_10.getText();
	                String maBN = comboBox_2.getSelectedItem().toString();
	                String tenBN = textField_15.getText();
	                String maBS = comboBox_2_1.getSelectedItem().toString();
	                String tenBS = textField_16.getText();
	                String khoa = textField_18.getText();
	                java.sql.Date ngayKham = null; // Initialize it to null
	                try {
	                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                    java.util.Date utilDate = dateFormat.parse(textField_17.getText());
	                    ngayKham = new java.sql.Date(utilDate.getTime());
	                } catch (ParseException ex) {
	                    ex.printStackTrace();
	                }
	                String maDV = comboBox_3.getSelectedItem().toString(); // You need to provide the actual value for dichVu
	                String ketLuan = textField_19.getText(); // Assuming this is the area where you input ketLuan

	                Connection con = JDBCUtil.getConnection();

	                // Truy vấn INSERT hoặc UPDATE vào bảng KQKB
	                String insertOrUpdateSql = "INSERT INTO phieuketqua (maPhieuKetQua, maBN, tenBN, maBS, tenBS, khoa, ngayKham, maDV, ketLuan) " +
	                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) " +
	                        "ON DUPLICATE KEY UPDATE " +
	                        "maPhieuKetQua = VALUES(maPhieuKetQua), maBN = VALUES(maBN), tenBN = VALUES(tenBN), " +
	                        "maBS = VALUES(maBS), tenBS = VALUES(tenBS), " +
	                        "khoa = VALUES(khoa), ngayKham = VALUES(ngayKham), " +
	                        "maDV = VALUES(maDV), ketLuan = VALUES(ketLuan)";

	                try (PreparedStatement insertOrUpdateSt = con.prepareStatement(insertOrUpdateSql)) {
	                    insertOrUpdateSt.setString(1, maPhieuKetQua);
	                    insertOrUpdateSt.setString(2, maBN);
	                    insertOrUpdateSt.setString(3, tenBN);
	                    insertOrUpdateSt.setString(4, maBS);
	                    insertOrUpdateSt.setString(5, tenBS);
	                    insertOrUpdateSt.setString(6, khoa);
	                    insertOrUpdateSt.setDate(7, ngayKham);
	                    insertOrUpdateSt.setString(8, maDV);
	                    insertOrUpdateSt.setString(9, ketLuan);

	                    int result = insertOrUpdateSt.executeUpdate();
	                    if (result > 0) {
	                        System.out.println("Thêm thông tin thành công!");
	                    } else {
	                        System.out.println("Thêm thông tin thất bại!");
	                    }
	                }

	                // Đóng tài nguyên
	                JDBCUtil.closeConnection(con);

	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	    	}
	    });
	    btnNewButton_5.setBounds(24, 374, 89, 23);
	    panel_4.add(btnNewButton_5);
	    
	    JButton btnNewButton_6 = new JButton("Refresh");
	    btnNewButton_6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		 Connection con = JDBCUtil.getConnection();

	    	        // Truy vấn SELECT để lấy dữ liệu từ bảng TTKB
	    	        String selectSql = "SELECT * FROM phieuKetQua";
	    	        try {
	    	            PreparedStatement selectSt = con.prepareStatement(selectSql);
	    	            ResultSet resultSet = selectSt.executeQuery();

	    	            // Clear existing rows in the table
	    	            model.setRowCount(0);

	    	            // Populate the table with the fetched data
	    	            while (resultSet.next()) {
	    	                Vector<Object> row = new Vector<>();
	    	                row.add(resultSet.getString("maPhieuKetQua"));
	    	                row.add(resultSet.getString("maBN"));
	    	                row.add(resultSet.getString("tenBN"));
	    	                row.add(resultSet.getString("maBS"));
	    	                row.add(resultSet.getString("tenBS"));
	    	                row.add(resultSet.getString("khoa"));
	    	                row.add(resultSet.getString("ngayKham"));
	    	                row.add(resultSet.getString("maDV"));
	    	                row.add(resultSet.getString("ketLuan"));

	    	                model.addRow(row);
	    	            }

	    	            // Đóng tài nguyên
	    	            resultSet.close();
	    	            selectSt.close();
	    	            JDBCUtil.closeConnection(con);

	    	        } catch (SQLException ex) {
	    	            ex.printStackTrace();
	    	        
                }
	    	}
	    });
	    btnNewButton_6.setBounds(138, 374, 89, 23);
	    panel_4.add(btnNewButton_6);
	    
	    JButton btnNewButton_7 = new JButton("Xóa");
	    btnNewButton_7.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int selectedRow = table_1.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Chọn một dòng để xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String maBNToDelete1 = model.getValueAt(selectedRow, 1).toString();
                delete(maBNToDelete1);
	    	}
	    });
	    btnNewButton_7.setBounds(260, 374, 89, 23);
	    panel_4.add(btnNewButton_7);
	    
	    JButton btnNewButton_8 = new JButton("Tìm kiếm");
	    btnNewButton_8.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String stt = textField_10.getText();
	            search(stt);
	    	}
	    });
	    btnNewButton_8.setBounds(389, 374, 89, 23);
	    panel_4.add(btnNewButton_8);

//Thêm sự kiện lắng nghe cho comboBox
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// Lấy đối tượng được chọn từ comboBox (trong trường hợp này là BenhNhanInfo)
				benhNhan selectedObject = (benhNhan) comboBox.getSelectedItem();

// Hiển thị tên bệnh nhân lên textField_1
				textField_8.setText(selectedObject.getTenBN());
			}
});
		List<benhNhan> danhSachBenhNhan1 = serviceBN.getAllBN();
		// Convert benhNhan objects to BenhNhanComboBoxItem objects
		benhNhan[] comboBoxItems1 = danhSachBenhNhan.toArray(new benhNhan[0]);
// Create a DefaultComboBoxModel with the array of BenhNhanComboBoxItem
		DefaultComboBoxModel<benhNhan> comboBoxModel1 = new DefaultComboBoxModel<>(comboBoxItems1);

// Set the model to your JComboBox
		comboBox_2.setModel(comboBoxModel);
		comboBox_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        // Lấy đối tượng được chọn từ comboBox (trong trường hợp này là benhNhan)
        benhNhan selectedObject = (benhNhan) comboBox_2.getSelectedItem();

        // Hiển thị tên bệnh nhân lên textField_8
        textField_15.setText(selectedObject.getTenBN());
        
        // Format ngày sinh và hiển thị lên textField_9
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedNgaySinh = dateFormat.format(selectedObject.getNgaySinh());

    }
});
		 List<bacSi> danhSachbs = serviceBS.getAllBS();
		bacSi[] bsInfoArray = danhSachbs.stream()
	             .map(bacSi -> new bacSi(bacSi.getMaBS(), bacSi.getTenBS(), bacSi.getKhoa()))
	             .toArray(bacSi[]::new);

	     DefaultComboBoxModel<bacSi> comboBoxModel2 = new DefaultComboBoxModel<>(bsInfoArray);

	     comboBox_2_1.setModel(comboBoxModel2);
	     
	     textField_18 = new JTextField();
	     textField_18.setColumns(10);
	     textField_18.setBounds(87, 125, 134, 20);
	     panel_3.add(textField_18);
	     
	    

	     // Thêm sự kiện lắng nghe cho comboBox
	     comboBox_2_1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             // Lấy đối tượng được chọn từ comboBox (trong trường hợp này là Thuoc)
	             bacSi selectedObject = (bacSi) comboBox_2_1.getSelectedItem();
	             textField_16.setText(selectedObject.getTenBS());
	             textField_18.setText(selectedObject.getKhoa());
	         }
	     });
	     List<DichVu> danhSachDichVu = serviceDV.getAllDV();

	        String[] dichVuArray = danhSachDichVu.stream()
	                                                    .map(DichVu::getMaDV)
	                                                    .toArray(String[]::new);

	        comboBox_3.setModel(new DefaultComboBoxModel<>(dichVuArray));
	        
	        JButton btnNewButton_9 = new JButton("Thoát");
	        btnNewButton_9.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		new DangNhapHeThong().setVisible(true);
	        	}
	        });
	        btnNewButton_9.setBounds(484, 374, 89, 23);
	        panel_4.add(btnNewButton_9);
	}
	private void deleteRecord(String maBNToDelete) {
        Connection con = JDBCUtil.getConnection();

        // Truy vấn DELETE để xóa bản ghi từ bảng TTKB
        String deleteSql = "DELETE FROM ttkb WHERE maBN = ?";
        try {
            PreparedStatement deleteSt = con.prepareStatement(deleteSql);
            deleteSt.setString(1, maBNToDelete);

            int result = deleteSt.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thông tin thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thông tin thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	private void delete(String maBNToDelete1) {
		Connection con = JDBCUtil.getConnection();

        // Truy vấn DELETE để xóa bản ghi từ bảng TTKB
        String deleteSql1 = "DELETE FROM phieuketqua WHERE maBN = ?";
        try {
            PreparedStatement deleteSt = con.prepareStatement(deleteSql1);
            deleteSt.setString(1, maBNToDelete1);

            int result = deleteSt.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thông tin thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thông tin thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	private void searchRecords(String stt) {
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String selectSql = "SELECT STT, maBN, tenBN, ngaySinh, ngayDK, doiTuong, maBH, ngaySinh FROM ttkb " +
	                "WHERE STT = ?";
	        PreparedStatement selectSt = con.prepareStatement(selectSql);
	        selectSt.setString(1, stt);
	        ResultSet rs = selectSt.executeQuery();

	        // Clear existing data from the table model
	        model.setRowCount(0);

	        // Populate the table model with the search results
	        while (rs.next()) {
	            Vector<Object> rowData = new Vector<>();
	            rowData.add(rs.getString("STT"));
	            rowData.add(rs.getString("maBN"));
	            rowData.add(rs.getString("tenBN"));
	            rowData.add(rs.getString("ngaySinh"));
	            rowData.add(rs.getString("ngayDK"));
	            rowData.add(rs.getString("doiTuong"));
	            rowData.add(rs.getString("maBH"));
	            rowData.add(rs.getString("ngaySinh"));
	            model.addRow(rowData);
	        }
	        
	        // Đóng tài nguyên
	        rs.close();
	        selectSt.close();
	        JDBCUtil.closeConnection(con);

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	private void search(String stt) {
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String selectSql = "SELECT maPhieuKetQua, maBN, tenBN, maBS, tenBS, khoa, ngayKham, maDV, ketLuan FROM phieuketqua " +
	                "WHERE maPhieuKetQua = ?";
	        PreparedStatement selectSt = con.prepareStatement(selectSql);
	        selectSt.setString(1, stt);
	        ResultSet rs = selectSt.executeQuery();

	        // Clear existing data from the table model
	        model.setRowCount(0);

	        // Populate the table model with the search results
	        while (rs.next()) {
	            Vector<Object> rowData = new Vector<>();
	            rowData.add(rs.getString("maPhieuKetQua"));
	            rowData.add(rs.getString("maBN"));
	            rowData.add(rs.getString("tenBN"));
	            rowData.add(rs.getString("maBS"));
	            rowData.add(rs.getString("tenBS"));
	            rowData.add(rs.getString("khoa"));
	            rowData.add(rs.getString("ngayKham"));
	            rowData.add(rs.getString("maDV"));
	            rowData.add(rs.getString("ketLuan"));

	            model.addRow(rowData);
	        }
	        
	        // Đóng tài nguyên
	        rs.close();
	        selectSt.close();
	        JDBCUtil.closeConnection(con);

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
    }}


    


