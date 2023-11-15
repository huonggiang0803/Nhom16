package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DichVu;
import model.NhanVien;
import service.ServiceDichVu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ThongTinDichVu extends JFrame {

	private JPanel contentPane;
	private JTextField matextField;
	private JTextField tentextField_1;
	private JTextField donGiatextField_2;
	private JTable table;
	DichVu dv;
	ServiceDichVu serviceDV;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinDichVu frame = new ThongTinDichVu();
					frame.setTitle("Thông tin dịch vụ");
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
	public ThongTinDichVu() {
		dv = new DichVu();
		serviceDV = new ServiceDichVu();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 432, 30);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN DỊCH VỤ");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 52, 458, 126);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã DV");
		lblNewLabel_1.setBounds(10, 11, 52, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên DV");
		lblNewLabel_2.setBounds(10, 55, 52, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Đơn giá");
		lblNewLabel_3.setBounds(10, 101, 58, 14);
		panel_1.add(lblNewLabel_3);
		
		matextField = new JTextField();
		matextField.setBounds(73, 8, 126, 20);
		panel_1.add(matextField);
		matextField.setColumns(10);
		
		tentextField_1 = new JTextField();
		tentextField_1.setBounds(74, 52, 125, 20);
		panel_1.add(tentextField_1);
		tentextField_1.setColumns(10);
		
		donGiatextField_2 = new JTextField();
		donGiatextField_2.setBounds(73, 98, 126, 20);
		panel_1.add(donGiatextField_2);
		donGiatextField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 458, 119);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 189, 458, 119);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"M\u00E3 DV", "T\u00EAn DV", "\u0110\u01A1n gi\u00E1"
			}
		);
		table.setModel(model);
		model.setRowCount(0);
	     List<DichVu> DV = serviceDV.getAllDV();
	     for (DichVu dichvu : DV) {
	    	 model.addRow(new Object[]{dichvu.getMaDV(), dichvu.getTenDV(), dichvu.getDonGia()});
	     }
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dv.setMaDV(matextField.getText());
				 dv.setTenDV(tentextField_1.getText());

				 String donGiaText = donGiatextField_2.getText();
			     try {
			    	 Float donGia = Float.parseFloat(donGiaText);
			            dv.setDonGia(donGia);
			     } catch (NumberFormatException ex) {
			            System.err.println("Invalid donGia value: " + donGiaText);
			            return;
			        }
			     serviceDV.addDV(dv);
			     model.setRowCount(0);
			     List<DichVu> DV = serviceDV.getAllDV();
			     for (DichVu dichvu : DV) {
			    	 model.addRow(new Object[]{dichvu.getMaDV(), dichvu.getTenDV(), dichvu.getDonGia()});
			     }
			}
		});
		
		btnNewButton.setBounds(240, 7, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1){
					JOptionPane.showMessageDialog(ThongTinDichVu.this,"Vui lòng chọn bác sĩ trước khi xóa","Lỗi",JOptionPane.ERROR_MESSAGE);
				}
				else {
					int confirm = JOptionPane.showConfirmDialog(ThongTinDichVu.this, "Bạn có chắc muốn xóa !");
					if (confirm == JOptionPane.YES_OPTION) {
						String maDV = String.valueOf(table.getValueAt(row, 0));
						serviceDV.DeleteDV(maDV);
						model.setRowCount(0);
						List<DichVu> DV = serviceDV.getAllDV();
						for (DichVu dichvu : DV) {
							model.addRow(new Object[] {dichvu.getMaDV(), dichvu.getTenDV(), dichvu.getDonGia()});
						}
					}
				}
			}
		});
		btnNewButton_1.setBounds(240, 51, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tìm kiếm");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenDichVu = tentextField_1.getText();
                List<DichVu> result = serviceDV.search(tenDichVu);
                if (table.getModel() != model) {
                    table.setModel(model);
                }
                model.setRowCount(0);
                for (DichVu dichvu : result) {
                    model.addRow(new Object[]{dichvu.getMaDV(), dichvu.getTenDV(), dichvu.getDonGia()});
                }
			}
		});
		btnNewButton_2.setBounds(240, 97, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Refresh");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
			     List<DichVu> DV = serviceDV.getAllDV();
			     for (DichVu dichvu : DV) {
			    	 model.addRow(new Object[]{dichvu.getMaDV(), dichvu.getTenDV(), dichvu.getDonGia()});
			     }
			}
		});
		btnNewButton_3.setBounds(350, 7, 89, 23);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sửa");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
		            // Display a message if no row is selected
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ cần sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        } else {
		        	 String maDV = String.valueOf(table.getValueAt(selectedRow, 0));
		        	 String tenDV = String.valueOf(table.getValueAt(selectedRow, 1));
		        	 Float donGia =  Float.valueOf(table.getValueAt(selectedRow,2).toString());
		        	 
		             DichVu DV = serviceDV.selectById(maDV);
		             new SuaDV (maDV, tenDV, donGia).setVisible(true);
		             dispose();
		        }
			}
		});
		btnNewButton_4.setBounds(350, 51, 89, 23);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Thoát");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DangNhapHeThong().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(350, 97, 89, 23);
		panel_1.add(btnNewButton_5);
		
	
		
		
	}

}
