package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.NhanVien;
import model.bacSi;
import service.ServiceBacSi;
import service.ServiceNhanVien;

import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ThongTinNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField tentextField_1;
	private JTextField sdttextField_2;
	private JTextField matextField_3;
	private JTable table;
	NhanVien nv;
	ServiceNhanVien serviceNV;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinNhanVien frame = new ThongTinNhanVien();
					frame.setTitle("Thông tin nhân viên");
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
	public ThongTinNhanVien() {
		nv = new NhanVien();
		serviceNV = new ServiceNhanVien();
		DefaultTableModel model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 436, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblNewLabel.setBounds(168, 5, 144, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("Thoát");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DangNhapHeThong().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(0, 1, 89, 23);
		panel.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("Mã NV");
		lblNewLabel_1.setBounds(10, 78, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Giới tính");
		lblNewLabel_2.setBounds(10, 122, 56, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tên NV");
		lblNewLabel_3.setBounds(224, 78, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SĐTNV");
		lblNewLabel_4.setBounds(224, 122, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		tentextField_1 = new JTextField();
		tentextField_1.setColumns(10);
		tentextField_1.setBounds(301, 75, 145, 20);
		contentPane.add(tentextField_1);
		
		sdttextField_2 = new JTextField();
		sdttextField_2.setColumns(10);
		sdttextField_2.setBounds(301, 119, 145, 20);
		contentPane.add(sdttextField_2);
		
		matextField_3 = new JTextField();
		matextField_3.setColumns(10);
		matextField_3.setBounds(66, 78, 145, 20);
		contentPane.add(matextField_3);
		
		JRadioButton namRadioButton = new JRadioButton("Nam");
		namRadioButton.setBounds(62, 118, 63, 23);
		contentPane.add(namRadioButton);
		
		JRadioButton nurdbtnN = new JRadioButton("Nữ");
		nurdbtnN.setBounds(156, 118, 62, 23);
		contentPane.add(nurdbtnN);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(namRadioButton);
		bg.add(nurdbtnN);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 164, 470, 123);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 470, 123);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 NV", "T\u00EAn NV", "Gi\u1EDBi t\u00EDnh", "S\u0110TNV"
			}
		);
		model.setRowCount(0);
		List<NhanVien> NVi = serviceNV.getAllNV();
		for (NhanVien nhanvien : NVi) {
			model.addRow(new Object[] {nhanvien.getMaNV(), nhanvien.getTenNV(), nhanvien.getGioiTinhNV(), nhanvien.getSĐTNV()});
		}
	table.setModel(model);
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nv.setMaNV(matextField_3.getText());
				nv.setTenNV(tentextField_1.getText());
				if (namRadioButton.isSelected()) {
					nv.setGioiTinhNV("Nam");
				}
				else if (nurdbtnN.isSelected()) {
					nv.setGioiTinhNV("Nữ");
				}
				nv.setSĐTNV(sdttextField_2.getText());
				serviceNV.addnv(nv);
				 model.setRowCount(0);
				List<NhanVien> NVi = serviceNV.getAllNV();
				for (NhanVien nhanvien : NVi) {
					model.addRow(new Object[] {nhanvien.getMaNV(), nhanvien.getTenNV(), nhanvien.getGioiTinhNV(), nhanvien.getSĐTNV()});
				}
			}
		});
		btnNewButton.setBounds(10, 302, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.setBounds(107, 302, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1){
					JOptionPane.showMessageDialog(ThongTinNhanVien.this,"Vui lòng chọn bác sĩ trước khi xóa","Lỗi",JOptionPane.ERROR_MESSAGE);
				}
				else {
					int confirm = JOptionPane.showConfirmDialog(ThongTinNhanVien.this, "Bạn có chắc muốn xóa !");
					if (confirm == JOptionPane.YES_OPTION) {
						String maNV = String.valueOf(table.getValueAt(row, 0));
						serviceNV.DeleteNV(maNV);
						model.setRowCount(0);
						List<NhanVien> nVI = serviceNV.getAllNV();
						for (NhanVien nhanvien : nVI) {
							model.addRow(new Object[] {nhanvien.getMaNV(), nhanvien.getTenNV(), nhanvien.getGioiTinhNV(), nhanvien.getSĐTNV()});
						}
					}
				}
			}
		});
		btnNewButton_2.setBounds(206, 302, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
					if (selectedRow == -1) {
			            // Display a message if no row is selected
			            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
			            return;
			        } else {
			        	 String maNV = String.valueOf(table.getValueAt(selectedRow, 0));
			        	 String tenNV = String.valueOf(table.getValueAt(selectedRow, 1));
			        	 String gioiTinhNV = String.valueOf(table.getValueAt(selectedRow, 2));
			        	 String SĐTNV = String.valueOf(table.getValueAt(selectedRow, 3));

			             NhanVien NV = serviceNV.selectById(maNV);
			             new SuaNV (maNV,tenNV,gioiTinhNV,SĐTNV).setVisible(true);
			             dispose();
			        }
			}
		});
		btnNewButton_3.setBounds(301, 302, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Tìm kiếm");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenNhanVien = tentextField_1.getText();
                List<NhanVien> result = serviceNV.search(tenNhanVien);
                if (table.getModel() != model) {
                    table.setModel(model);
                }
                model.setRowCount(0);
                for (NhanVien user : result) {
                    model.addRow(new Object[]{user.getMaNV(), user.getTenNV(), user.getGioiTinhNV(), user.getSĐTNV()});
                }
			}
		});
		btnNewButton_4.setBounds(400, 302, 80, 23);
		contentPane.add(btnNewButton_4);
	}
}
