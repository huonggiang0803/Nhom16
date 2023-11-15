package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.benhNhan;
import service.ServicebenhNhan;

import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ThongTinBenhNhan extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField sđttextField_1;
	private JTextField tentextField_2;
	private JTextField datetextField_3;
	private JTextField maBHtextField_4;
	private JTextField addresstextField_5;
	private JTable table;
	ServicebenhNhan serviceBN;
	benhNhan bn;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinBenhNhan frame = new ThongTinBenhNhan();
					frame.setTitle("Thông tin bệnh nhân");
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
	public ThongTinBenhNhan() {
		bn = new benhNhan();
		serviceBN = new ServicebenhNhan();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 637, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN BỆNH NHÂN");
		lblNewLabel.setBounds(261, 5, 160, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("Thoát");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DangNhapHeThong().setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(10, 1, 89, 23);
		panel.add(btnNewButton_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 61, 637, 222);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã BN");
		lblNewLabel_1.setBounds(21, 21, 71, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1.setBounds(21, 65, 71, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Đối tượng");
		lblNewLabel_1_2.setBounds(21, 117, 71, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("SĐT BN");
		lblNewLabel_1_3.setBounds(21, 178, 71, 14);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("Tên BN");
		lblNewLabel_2.setBounds(317, 21, 71, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_2_1.setBounds(317, 65, 71, 14);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Mã BH");
		lblNewLabel_3.setBounds(317, 117, 71, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Địa chỉ");
		lblNewLabel_4.setBounds(317, 178, 71, 14);
		panel_1.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(113, 18, 179, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		sđttextField_1 = new JTextField();
		sđttextField_1.setColumns(10);
		sđttextField_1.setBounds(113, 175, 179, 20);
		panel_1.add(sđttextField_1);
		
		tentextField_2 = new JTextField();
		tentextField_2.setColumns(10);
		tentextField_2.setBounds(398, 18, 200, 20);
		panel_1.add(tentextField_2);
		
		datetextField_3 = new JTextField();
		datetextField_3.setColumns(10);
		datetextField_3.setBounds(398, 62, 200, 20);
		panel_1.add(datetextField_3);
		
		maBHtextField_4 = new JTextField();
		maBHtextField_4.setColumns(10);
		maBHtextField_4.setBounds(398, 114, 200, 20);
		panel_1.add(maBHtextField_4);
		
		addresstextField_5 = new JTextField();
		addresstextField_5.setColumns(10);
		addresstextField_5.setBounds(396, 175, 202, 20);
		panel_1.add(addresstextField_5);
		
		JComboBox dtcomboBox = new JComboBox();
		dtcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedDoiTuong = (String) dtcomboBox.getSelectedItem();
		        
				if (selectedDoiTuong.equals("Bảo hiểm")) {
					maBHtextField_4.setVisible(true); // Hiển thị trường mã BH khi chọn "Bảo hiểm y tế"
		        } else {
		        	maBHtextField_4.setVisible(false); // Ẩn trường mã BH khi chọn "Không bảo hiểm y tế"
		        }
			}
		});
		dtcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Bảo hiểm", "Không bảo hiểm"}));
		dtcomboBox.setBounds(113, 117, 179, 22);
		panel_1.add(dtcomboBox);
		
		JRadioButton namRadioButton = new JRadioButton("Nam");
		namRadioButton.setBounds(125, 61, 71, 23);
		panel_1.add(namRadioButton);
		
		JRadioButton nuRadioButton_1 = new JRadioButton("Nữ");
		nuRadioButton_1.setBounds(221, 61, 57, 23);
		panel_1.add(nuRadioButton_1);
		
		ButtonGroup bt = new ButtonGroup();
		bt.add(namRadioButton);
		bt.add(nuRadioButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 299, 637, 159);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 637, 159);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 BN", "T\u00EAn BN", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "\u0110\u1ED1i t\u01B0\u1EE3ng", "M\u00E3 BH", "\u0110\u1ECBa ch\u1EC9", "S\u0110T"
			}
		);
		table.setModel(model);
		List<benhNhan> benhn = serviceBN.getAllBN();
		for (benhNhan user : benhn) {
			model.addRow(new Object[] {user.getMaBN(), user.getTenBN(),  user.getGioiTinhBN(), user.getNgaySinh(), user.getDoiTuong(), user.getMaBH(), user.getDiaChiBN(), user.getSĐTBN()});
		}
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bn.setMaBN(textField.getText());
				bn.setTenBN(tentextField_2.getText());
				if (namRadioButton.isSelected()) {
					bn.setGioiTinhBN("Nam");
				}
				else if (nuRadioButton_1.isSelected()) {
					bn.setGioiTinhBN("Nữ");
				}
				try {
				    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				    java.util.Date utilDate = dateFormat.parse(datetextField_3.getText());
				    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				    bn.setNgaySinh(sqlDate);
				} catch (ParseException ex) {
				    bn.setNgaySinh(null); 
				}
				bn.setDoiTuong(dtcomboBox.getSelectedItem().toString());
				 String selectedDoiTuong = dtcomboBox.getSelectedItem().toString();
				 bn.setDoiTuong(selectedDoiTuong);
				 if ("Bảo hiểm".equals(selectedDoiTuong)) {
					    bn.setMaBH(maBHtextField_4.getText());
				} else {
					    bn.setMaBH(null);
				}
				 bn.setDiaChiBN(addresstextField_5.getText());
				 bn.setSĐTBN(sđttextField_1.getText());
				 serviceBN.addBN(bn);
				 model.setRowCount(0);
					List<benhNhan> benhn = serviceBN.getAllBN();
					for (benhNhan user : benhn) {
						model.addRow(new Object[] {user.getMaBN(), user.getTenBN(),  user.getGioiTinhBN(), user.getNgaySinh(), user.getDoiTuong(), user.getMaBH(), user.getDiaChiBN(), user.getSĐTBN()});
					}
			}
		});
		btnNewButton.setBounds(10, 488, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				List<benhNhan> benhn = serviceBN.getAllBN();
				for (benhNhan user : benhn) {
					model.addRow(new Object[] {user.getMaBN(), user.getTenBN(),  user.getGioiTinhBN(), user.getNgaySinh(), user.getDoiTuong(), user.getMaBH(), user.getDiaChiBN(), user.getSĐTBN()});
				}
			}
		});
		btnNewButton_1.setBounds(140, 488, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1){
					JOptionPane.showMessageDialog(ThongTinBenhNhan.this,"Vui lòng chọn bệnh nhân trước khi xóa","Lỗi",JOptionPane.ERROR_MESSAGE);
				}
				else {
					int confirm = JOptionPane.showConfirmDialog(ThongTinBenhNhan.this, "Bạn có chắc muốn xóa !");
					if (confirm == JOptionPane.YES_OPTION) {
						String maBN = String.valueOf(table.getValueAt(row, 0));
						serviceBN.DeleteBN(maBN);
						model.setRowCount(0);
						List<benhNhan> benhn = serviceBN.getAllBN();
						for (benhNhan user : benhn) {
							model.addRow(new Object[] {user.getMaBN(), user.getTenBN(),  user.getGioiTinhBN(), user.getNgaySinh(), user.getDoiTuong(), user.getMaBH(), user.getDiaChiBN(), user.getSĐTBN()});
						}
					}
				}
			}
		});
		btnNewButton_2.setBounds(282, 488, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
					if (selectedRow == -1) {
			            // Display a message if no row is selected
			            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân cần sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
			            return;
			        } else {
			        	 String maBN = String.valueOf(table.getValueAt(selectedRow, 0));
			        	    String tenBN = String.valueOf(table.getValueAt(selectedRow, 1));
			        	    String gioiTinhBN = String.valueOf(table.getValueAt(selectedRow, 2));

			        	    // Convert the string date to java.sql.Date
			        	    String dateString = String.valueOf(table.getValueAt(selectedRow, 3));
			        	    java.sql.Date ngaySinh = null;
			        	    try {
			        	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			        	        java.util.Date parsedDate = dateFormat.parse(dateString);
			        	        ngaySinh = new java.sql.Date(parsedDate.getTime());
			        	    } catch (ParseException q) {
			        	        q.printStackTrace();
			        	    }

			        	    String doiTuong = String.valueOf(table.getValueAt(selectedRow, 4));
			        	    String maBH = String.valueOf(table.getValueAt(selectedRow, 5));
			        	    String diaChiBN = String.valueOf(table.getValueAt(selectedRow, 6));
			        	    String SĐTBN = String.valueOf(table.getValueAt(selectedRow, 7));
			            benhNhan user = serviceBN.selectById(maBN);
			            new SuaBN (maBN,tenBN,gioiTinhBN,ngaySinh,doiTuong,maBH,diaChiBN,SĐTBN).setVisible(true);
			            
			            dispose();
			        }
			}
		});
		btnNewButton_3.setBounds(419, 488, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Tìm kiếm");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenBenhNhan = tentextField_2.getText();

                // Thực hiện tìm kiếm
                List<benhNhan> result = serviceBN.search(tenBenhNhan);

                // Kiểm tra và cập nhật model nếu cần
                if (table.getModel() != model) {
                    table.setModel(model);
                }
                // Xóa tất cả dữ liệu cũ trong bảng
                model.setRowCount(0);

                // Hiển thị kết quả tìm kiếm trong bảng
                for (benhNhan user : result) {
                    model.addRow(new Object[]{user.getMaBN(), user.getTenBN(), user.getGioiTinhBN(), user.getNgaySinh(), user.getDoiTuong(), user.getMaBH(), user.getDiaChiBN(), user.getSĐTBN()});
                }
			}
		});
		btnNewButton_4.setBounds(558, 488, 89, 23);
		contentPane.add(btnNewButton_4);
	}
}
