package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.DichVu;
import model.NhanVien;
import model.Thuoc;
import model.bacSi;
import model.benhNhan;
import model.phieuDonThuoc;
import service.ServiceBacSi;
import service.ServiceNhanVien;
import service.ServiceThuoc;
import service.ServicebenhNhan;
import service.servicePDT;

import javax.swing.JScrollPane;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class ThongTinThuoc extends JFrame {

	private JPanel contentPane;
	private JTextField matextField;
	private JTextField giatextField_1;
	private JTextField tentextField_2;
	private JTextField xxtextField_3;
	private JTable table;
	Thuoc t;
	ServiceThuoc serviceT;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField mattextField_6;
	private JTextField cdtextField_7;
	private JTextField tenthuoctextField_9;
	private JTextField dvttextField_10;
	private JTable table_1;
	private JTextField sltextField_11;
	private JTextField textField_5;
	benhNhan bn;
	ServicebenhNhan serviceBN;
	NhanVien nv;
	ServiceNhanVien serviceNV;
	bacSi bs;
	ServiceBacSi serviceBS;
	phieuDonThuoc pdt;
	servicePDT servicePDT;
	private JTextField textField;
	private AbstractButton comboBox_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinThuoc frame = new ThongTinThuoc();
					frame.setTitle("Quản lý thuốc");
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
	public ThongTinThuoc() {
		DefaultTableModel model;
		pdt = new phieuDonThuoc();
		servicePDT = new servicePDT();
		bn = new benhNhan();
		serviceBN = new ServicebenhNhan();
		nv = new NhanVien();
		serviceNV = new ServiceNhanVien();
		t = new Thuoc();
		serviceT = new ServiceThuoc();
		bs = new bacSi();
		serviceBS = new ServiceBacSi();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 565, 528);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 565, 524);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Thông tin thuốc", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 516, 106);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Thuốc");
		lblNewLabel.setBounds(10, 11, 61, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Giá thuốc");
		lblNewLabel_1.setBounds(10, 64, 61, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên thuốc");
		lblNewLabel_2.setBounds(253, 11, 79, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Xuất xứ");
		lblNewLabel_3.setBounds(253, 64, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		matextField = new JTextField();
		matextField.setBounds(81, 8, 141, 20);
		panel_2.add(matextField);
		matextField.setColumns(10);
		
		giatextField_1 = new JTextField();
		giatextField_1.setColumns(10);
		giatextField_1.setBounds(81, 58, 141, 20);
		panel_2.add(giatextField_1);
		
		tentextField_2 = new JTextField();
		tentextField_2.setColumns(10);
		tentextField_2.setBounds(330, 8, 141, 20);
		panel_2.add(tentextField_2);
		
		xxtextField_3 = new JTextField();
		xxtextField_3.setColumns(10);
		xxtextField_3.setBounds(330, 61, 141, 20);
		panel_2.add(xxtextField_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 128, 516, 132);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 516, 132);
		panel_3.add(scrollPane);
		
		DefaultTableModel model1;
		table = new JTable();
		scrollPane.setViewportView(table);
		model1 = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 Thu\u1ED1c", "T\u00EAn Thu\u1ED1c", "Gi\u00E1 Thu\u1ED1c", "Xu\u1EA5t X\u1EE9"
			}
		);
		table.setModel(model1);
		model1.setRowCount(0);
	     List<Thuoc> T = serviceT.getAllT();
	     for (Thuoc thuoc : T) {
	    	 model1.addRow(new Object[]{thuoc.getMaThuoc(), thuoc.getTenThuoc(), thuoc.getTenThuoc(), thuoc.getXuatXu()});
	     }
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 t.setMaThuoc(matextField.getText());
				 t.setTenThuoc(tentextField_2.getText());
				 String giaThuocText = giatextField_1.getText();
			     try {
			    	 Float giaThuoc = Float.parseFloat(giaThuocText);
			            t.setGiaThuoc(giaThuoc);
			     } catch (NumberFormatException ex) {
			            System.err.println("Invalid donGia value: " + giaThuocText);
			            return;
			        }
			     t.setXuatXu(xxtextField_3.getText());
			     serviceT.addT(t);
			     model1.setRowCount(0);
			     List<Thuoc> T = serviceT.getAllT();
			     for (Thuoc thuoc : T) {
			    	 model1.addRow(new Object[]{thuoc.getMaThuoc(), thuoc.getTenThuoc(), thuoc.getTenThuoc(), thuoc.getXuatXu()});
			     }
			}
		});
		btnNewButton.setBounds(10, 282, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 model1.setRowCount(0);
			     List<Thuoc> T = serviceT.getAllT();
			     for (Thuoc thuoc : T) {
			    	 model1.addRow(new Object[]{thuoc.getMaThuoc(), thuoc.getTenThuoc(), thuoc.getTenThuoc(), thuoc.getXuatXu()});
			     }
			}
		});
		btnNewButton_1.setBounds(112, 282, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1){
					JOptionPane.showMessageDialog(ThongTinThuoc.this,"Vui lòng chọn bác sĩ trước khi xóa","Lỗi",JOptionPane.ERROR_MESSAGE);
				}
				else {
					int confirm = JOptionPane.showConfirmDialog(ThongTinThuoc.this, "Bạn có chắc muốn xóa !");
					if (confirm == JOptionPane.YES_OPTION) {
						String maThuoc = String.valueOf(table.getValueAt(row, 0));
						serviceT.DeleteT(maThuoc);
						model1.setRowCount(0);
						List<Thuoc> T = serviceT.getAllT();
						for (Thuoc thuoc : T) {
							model1.addRow(new Object[] {thuoc.getMaThuoc(), thuoc.getTenThuoc(), thuoc.getGiaThuoc(), thuoc.getXuatXu()});
						}
					}
				}
			}
		});
		btnNewButton_2.setBounds(211, 282, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
		            // Display a message if no row is selected
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn thuốc cần sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        } else {
		        	 String maThuoc = String.valueOf(table.getValueAt(selectedRow, 0));
		        	 String tenThuoc = String.valueOf(table.getValueAt(selectedRow, 1));
		        	 Float giaThuoc =  Float.valueOf(table.getValueAt(selectedRow,2).toString());
		        	 String xuatXu = String.valueOf(table.getValueAt(selectedRow,3));
		             Thuoc T = serviceT.selectById(maThuoc);
		             new SuaThuoc (maThuoc, tenThuoc, giaThuoc,xuatXu).setVisible(true);
		             dispose();
		        }
			}
		});
		btnNewButton_3.setBounds(324, 282, 89, 23);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Tìm kiếm");
		btnNewButton_4.setBounds(436, 282, 89, 23);
		panel_1.add(btnNewButton_4);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Đơn thuốc", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 11, 540, 32);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("PHIẾU ĐƠN THUỐC");
		lblNewLabel_4.setBounds(223, 5, 115, 14);
		panel_5.add(lblNewLabel_4);
		
		JButton btnNewButton_6 = new JButton("Thoát");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DangNhapHeThong().setVisible(true);
			}
		});
		btnNewButton_6.setBounds(0, 1, 89, 23);
		panel_5.add(btnNewButton_6);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 60, 540, 250);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Mã đơn thuốc");
		lblNewLabel_5.setBounds(10, 132, 85, 14);
		panel_6.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Mã BN");
		lblNewLabel_5_1.setBounds(10, 11, 46, 14);
		panel_6.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Mã NV");
		lblNewLabel_5_2.setBounds(10, 47, 46, 14);
		panel_6.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Mã Thuốc");
		lblNewLabel_5_3.setBounds(10, 164, 65, 14);
		panel_6.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("Tên BN");
		lblNewLabel_5_4.setBounds(285, 11, 46, 14);
		panel_6.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("Số lượng");
		lblNewLabel_5_5.setBounds(285, 195, 65, 14);
		panel_6.add(lblNewLabel_5_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phòng Khám");
		lblNewLabel_6.setBounds(285, 47, 87, 14);
		panel_6.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cách dùng");
		lblNewLabel_7.setBounds(285, 132, 65, 14);
		panel_6.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ngày kê");
		lblNewLabel_8.setBounds(10, 84, 46, 14);
		panel_6.add(lblNewLabel_8);
		
		JLabel label = new JLabel("New label");
		label.setBounds(261, 157, -9, 14);
		panel_6.add(label);
		
		JLabel lblNewLabel_9 = new JLabel("Tên Thuốc");
		lblNewLabel_9.setBounds(285, 164, 65, 14);
		panel_6.add(lblNewLabel_9);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(403, 8, 110, 20);
		panel_6.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(403, 81, 110, 20);
		panel_6.add(textField_3);
		
		mattextField_6 = new JTextField();
		mattextField_6.setColumns(10);
		mattextField_6.setBounds(105, 129, 110, 20);
		panel_6.add(mattextField_6);
		
		cdtextField_7 = new JTextField();
		cdtextField_7.setColumns(10);
		cdtextField_7.setBounds(403, 129, 110, 20);
		panel_6.add(cdtextField_7);
		
		tenthuoctextField_9 = new JTextField();
		tenthuoctextField_9.setColumns(10);
		tenthuoctextField_9.setBounds(403, 161, 110, 20);
		panel_6.add(tenthuoctextField_9);
		
		dvttextField_10 = new JTextField();
		dvttextField_10.setColumns(10);
		dvttextField_10.setBounds(105, 192, 110, 20);
		panel_6.add(dvttextField_10);
		
		JLabel lblNewLabel_11 = new JLabel("ĐVT");
		lblNewLabel_11.setBounds(10, 200, 65, 14);
		panel_6.add(lblNewLabel_11);
		
		sltextField_11 = new JTextField();
		sltextField_11.setColumns(10);
		sltextField_11.setBounds(403, 192, 110, 20);
		panel_6.add(sltextField_11);
		
		JLabel lblNewLabel_12 = new JLabel("Bệnh mắc phải");
		lblNewLabel_12.setBounds(285, 84, 87, 14);
		panel_6.add(lblNewLabel_12);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(105, 11, 110, 22);
		panel_6.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(105, 43, 110, 22);
		panel_6.add(comboBox_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 112, 540, 9);
		panel_6.add(separator);
		
		JComboBox mathuoccomboBox_2 = new JComboBox();
		mathuoccomboBox_2.setBounds(105, 160, 110, 22);
		panel_6.add(mathuoccomboBox_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 332, 540, 125);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 540, 114);
		panel_7.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		model =  new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 \u0110T", "M\u00E3 Thu\u1ED1c", "T\u00EAn Thu\u1ED1c", "\u0110VT", "S\u1ED1 l\u01B0\u1EE3ng", "C\u00E1ch d\u00F9ng"
			}
		);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 \u0110T", "M\u00E3 Thu\u1ED1c", "T\u00EAn Thu\u1ED1c", "\u0110VT", "S\u1ED1 l\u01B0\u1EE3ng", "C\u00E1ch d\u00F9ng"
			}
		));
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
        textField_1.setText(selectedObject.getTenBN());
        
        // Format ngày sinh và hiển thị lên textField_9
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedNgaySinh = dateFormat.format(selectedObject.getNgaySinh());
//        textField_9.setText(formattedNgaySinh);
    }
});
		List<NhanVien> danhSachNhanVien = serviceNV.getAllNV();

        // Tạo một mảng chứa mã bệnh nhân
        String[] maNhanVienArray = danhSachNhanVien.stream()
                                                    .map(NhanVien::getMaNV)
                                                    .toArray(String[]::new);

        // Thêm mảng mã bệnh nhân vào comboBox
        comboBox_1.setModel(new DefaultComboBoxModel<>(maNhanVienArray));
        
        JComboBox comboBox_1_1 = new JComboBox();
        comboBox_1_1.setBounds(403, 43, 110, 22);
        panel_6.add(comboBox_1_1);
		JLabel lblNewLabel_13_1 = new JLabel("Thành tiền");
		lblNewLabel_13_1.setBounds(301, 471, 65, 14);
		panel_4.add(lblNewLabel_13_1);
		
        List<bacSi> danhSachBacSi = serviceBS.getAllBS();

        String[] khoaBacSiArray = danhSachBacSi.stream()
                                                    .map(bacSi::getKhoa)
                                                    .toArray(String[]::new);

        comboBox_1_1.setModel(new DefaultComboBoxModel<>(khoaBacSiArray));
        
        List<Thuoc> danhSachThuoc = serviceT.getAllT();

     // Tạo một mảng chứa mã và tên bệnh nhân
     Thuoc[] thuocInfoArray = danhSachThuoc.stream()
             .map(thuoc -> new Thuoc(thuoc.getMaThuoc(), thuoc.getTenThuoc()))
             .toArray(Thuoc[]::new);

     // Tạo mô hình cho comboBox với thông tin thuốc
     DefaultComboBoxModel<Thuoc> comboBoxModel1 = new DefaultComboBoxModel<>(thuocInfoArray);

     // Thêm mô hình vào comboBox
     mathuoccomboBox_2.setModel(comboBoxModel1);

     // Thêm sự kiện lắng nghe cho comboBox
     mathuoccomboBox_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Lấy đối tượng được chọn từ comboBox (trong trường hợp này là Thuoc)
             Thuoc selectedObject = (Thuoc) mathuoccomboBox_2.getSelectedItem();
             tenthuoctextField_9.setText(selectedObject.getTenThuoc());
         }
     });
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(105, 81, 110, 20);
        panel_6.add(textField);
        
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(388, 468, 110, 20);
		panel_4.add(textField_5);
		
		JButton btnNewButton_7 = new JButton("Thêm");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				benhNhan selectedBenhNhan = (benhNhan) comboBox.getSelectedItem();
			//	bacSi selectedBacSi = (bacSi) comboBox_1_1.getSelectedItem();
		        Thuoc selectedThuoc = (Thuoc) mathuoccomboBox_2.getSelectedItem();
		        String selectedNhanVienId = (String) comboBox_1.getSelectedItem();
		        NhanVien selectedNhanVien = serviceNV.selectById(selectedNhanVienId);
		        String selectedBacSiId = (String) comboBox_1_1.getSelectedItem();
		        bacSi selectedBacSi = serviceBS.selectById(selectedBacSiId);
		        
		       
		        String maDonThuoc = mattextField_6.getText();
		        String ngayKe = textField.getText();
		        String cachDung = cdtextField_7.getText();
		        String soLuongText = sltextField_11.getText();
		        String benhMacPhai = textField_3.getText();
		        String ĐVT = dvttextField_10.getText();
		     //   String thanhTien = textField_5.getSelectedText().t
		        // Validate input
		        if (maDonThuoc.isEmpty() || ngayKe.isEmpty() || cachDung.isEmpty() || soLuongText.isEmpty()) {
		            JOptionPane.showMessageDialog(ThongTinThuoc.this, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Parse the values
		        int soLuong = Integer.parseInt(soLuongText);

		        // Create a new phieuDonThuoc object
		        phieuDonThuoc newPhieuDonThuoc = new phieuDonThuoc();
		        newPhieuDonThuoc.setMaDonThuoc(maDonThuoc);
		        newPhieuDonThuoc.setTenBN(selectedBenhNhan.getTenBN());
		        newPhieuDonThuoc.setMaBN(selectedBenhNhan.getMaBN());
		        newPhieuDonThuoc.setMaNV(selectedNhanVien.getMaNV());
		        newPhieuDonThuoc.setMaThuoc(selectedThuoc.getMaThuoc());
		        newPhieuDonThuoc.setTenThuoc(selectedThuoc.getTenThuoc());
		        newPhieuDonThuoc.setNgayKeDon(Date.valueOf(ngayKe));
		        newPhieuDonThuoc.setBenhMacPhai(benhMacPhai);
		        newPhieuDonThuoc.setCachDung(cachDung);
		        newPhieuDonThuoc.setSoLuong(soLuong);
		        newPhieuDonThuoc.setĐVT(ĐVT);
		    //    newPhieuDonThuoc.setThanhTien();
		        if (selectedBacSi != null) {
		            newPhieuDonThuoc.setPhongKham(selectedBacSi.getKhoa());
		        } else {
		            // Handle the case where selectedBacSi is null, e.g., show an error message.
		            JOptionPane.showMessageDialog(ThongTinThuoc.this, "Please select a valid bacSi.", "Error", JOptionPane.ERROR_MESSAGE);
		            return; // or take appropriate action
		        }
		        // Add the new phieuDonThuoc to the database
		       servicePDT.addPDT(newPhieuDonThuoc);

		        // Refresh the table_1 to display the updated data
		        refreshTable1();
		    }
			
		});
		
		btnNewButton_7.setBounds(20, 467, 89, 23);
		panel_4.add(btnNewButton_7);
		
		JButton btnNewButton_5 = new JButton("Refresh");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 model.setRowCount(0);
			        phieuDonThuoc newPhieuDonThuoc = new phieuDonThuoc();

//			     List<phieuDonThuoc> T = servicePDT.getAllPDT();
//			     for (phieuDonThuoc pdt : T) {
//			    	 model.addRow(new Object[]{pdt.getMaDonThuoc(), pdt.getMaThuoc(), pdt.getTenThuoc(), pdt.getSoLuong(),pdt.getMaBN(),pdt.getTenBN(),pdt.getPhongKham(),pdt.getMaNV(),pdt.getBenhMacPhai(),pdt.getCachDung(),pdt.getNgayKeDon(),pdt.getĐVT(),pdt.getThanhTien()});
//			     }
				 servicePDT.addPDT(newPhieuDonThuoc);
				 
			     refreshTable1();
			}
		});
		btnNewButton_5.setBounds(130, 467, 89, 23);
		panel_4.add(btnNewButton_5);
	}
	
	private void refreshTable1() {
	    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	    model.setRowCount(0);
	    List<phieuDonThuoc> listPhieuDonThuoc = servicePDT.getAllPDT();
	    System.out.println(listPhieuDonThuoc);
	    for (phieuDonThuoc pdt : listPhieuDonThuoc) {
	        model.addRow(new Object[]{pdt.getMaDonThuoc(), pdt.getMaThuoc(), pdt.getTenThuoc(), pdt.getĐVT(), pdt.getSoLuong(), pdt.getCachDung()});
	    }
	      //  servicePDT.addPDT(pdt);
	    }
	}
	
	

