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

import model.bacSi;
import model.benhNhan;
import service.ServiceBacSi;

import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;

public class ThongTinBacSi extends JFrame {

	private JPanel contentPane;
	private JTextField matextField;
	private JTextField khoatextField_1;
	private JTextField tentextField_2;
	private JTextField sdttextField_3;
	private JTable table;
	bacSi bs;
	ServiceBacSi serviceBS;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinBacSi frame = new ThongTinBacSi();
					frame.setTitle("Thông tin bác sĩ");
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
	public ThongTinBacSi() {
		bs =  new bacSi();
		serviceBS = new ServiceBacSi();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 500, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN BÁC SĨ");
		lblNewLabel.setBounds(204, 5, 115, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DangNhapHeThong().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(0, 1, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel maBSNewLabel_1 = new JLabel("Mã BS");
		maBSNewLabel_1.setBounds(10, 75, 46, 14);
		contentPane.add(maBSNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Giới tính");
		lblNewLabel_2.setBounds(10, 126, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Khoa");
		lblNewLabel_3.setBounds(10, 180, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tên BS");
		lblNewLabel_4.setBounds(267, 75, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SĐT BS");
		lblNewLabel_5.setBounds(267, 126, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		matextField = new JTextField();
		matextField.setBounds(85, 72, 160, 20);
		contentPane.add(matextField);
		matextField.setColumns(10);
		
		khoatextField_1 = new JTextField();
		khoatextField_1.setBounds(85, 177, 160, 20);
		khoatextField_1.setColumns(10);
		contentPane.add(khoatextField_1);
		
		tentextField_2 = new JTextField();
		tentextField_2.setBounds(323, 72, 176, 20);
		tentextField_2.setColumns(10);
		contentPane.add(tentextField_2);
		
		sdttextField_3 = new JTextField();
		sdttextField_3.setBounds(323, 123, 176, 20);
		sdttextField_3.setColumns(10);
		contentPane.add(sdttextField_3);
		
		JRadioButton NamrdbtnNewRadioButton = new JRadioButton("Nam");
		NamrdbtnNewRadioButton.setBounds(87, 122, 69, 23);
		contentPane.add(NamrdbtnNewRadioButton);
		
		JRadioButton NurdbtnNewRadioButton_1 = new JRadioButton("Nữ");
		NurdbtnNewRadioButton_1.setBounds(158, 122, 69, 23);
		contentPane.add(NurdbtnNewRadioButton_1);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(NurdbtnNewRadioButton_1);
		bg.add(NamrdbtnNewRadioButton);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 221, 500, 125);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 500, 125);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 BS", "T\u00EAn BS", "Gi\u1EDBi t\u00EDnh", "S\u0110T BS", "Khoa"
			}
		);
		 model.setRowCount(0);
			List<bacSi> bsi = serviceBS.getAllBS();
			for (bacSi bacsi : bsi) {
				model.addRow(new Object[] {bacsi.getMaBS(), bacsi.getTenBS(), bacsi.getGioiTinhBS(), bacsi.getSĐTBS(), bacsi.getKhoa()});
			}
		table.setModel(model);
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bs.setMaBS(matextField.getText());
				bs.setTenBS(tentextField_2.getText());
				if (NamrdbtnNewRadioButton.isSelected()) {
					bs.setGioiTinhBS("Nam");
				}
				else if (NurdbtnNewRadioButton_1.isSelected()) {
					bs.setGioiTinhBS("Nữ");
				}
				bs.setKhoa(khoatextField_1.getText());
				bs.setSĐTBS(sdttextField_3.getText());
				serviceBS.addBS(bs);
				 model.setRowCount(0);
				List<bacSi> bsi = serviceBS.getAllBS();
				for (bacSi bacsi : bsi) {
					model.addRow(new Object[] {bacsi.getMaBS(), bacsi.getTenBS(), bacsi.getGioiTinhBS(), bacsi.getSĐTBS(), bacsi.getKhoa()});
				}
			}
		});
		btnNewButton.setBounds(10, 357, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				List<bacSi> bsi = serviceBS.getAllBS();
				for (bacSi bacsi : bsi) {
					model.addRow(new Object[] {bacsi.getMaBS(), bacsi.getTenBS(), bacsi.getGioiTinhBS(), bacsi.getSĐTBS(), bacsi.getKhoa()});
				}
			}
		});
		btnRefresh.setBounds(109, 357, 89, 23);
		contentPane.add(btnRefresh);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1){
					JOptionPane.showMessageDialog(ThongTinBacSi.this,"Vui lòng chọn bác sĩ trước khi xóa","Lỗi",JOptionPane.ERROR_MESSAGE);
				}
				else {
					int confirm = JOptionPane.showConfirmDialog(ThongTinBacSi.this, "Bạn có chắc muốn xóa !");
					if (confirm == JOptionPane.YES_OPTION) {
						String maBS = String.valueOf(table.getValueAt(row, 0));
						serviceBS.DeleteBS(maBS);
						model.setRowCount(0);
						List<bacSi> bsi = serviceBS.getAllBS();
						for (bacSi bacsi : bsi) {
							model.addRow(new Object[] {bacsi.getMaBS(), bacsi.getTenBS(), bacsi.getGioiTinhBS(), bacsi.getSĐTBS(), bacsi.getKhoa()});
						}
					}
				}
			}
			
		});
		btnXa.setBounds(208, 357, 89, 23);
		contentPane.add(btnXa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
					if (selectedRow == -1) {
			            // Display a message if no row is selected
			            JOptionPane.showMessageDialog(null, "Vui lòng chọn bác sĩ cần sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
			            return;
			        } else {
			        	 String maBS = String.valueOf(table.getValueAt(selectedRow, 0));
			        	 String tenBS = String.valueOf(table.getValueAt(selectedRow, 1));
			        	 String gioiTinhBS = String.valueOf(table.getValueAt(selectedRow, 2));
			        	 String SĐTBS = String.valueOf(table.getValueAt(selectedRow, 3));
			        	 String Khoa = String.valueOf(table.getValueAt(selectedRow, 4));

			             bacSi bs = serviceBS.selectById(maBS);
			            new SuaBS (maBS,tenBS,gioiTinhBS,SĐTBS,Khoa).setVisible(true);
			            
			            dispose();
			        }
			}
		});
		btnSa.setBounds(321, 357, 89, 23);
		contentPane.add(btnSa);
		
		JButton btnNewButton_4 = new JButton("Tìm kiếm");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenBacSi = tentextField_2.getText();
                // Thực hiện tìm kiếm
                List<bacSi> result = serviceBS.search(tenBacSi);
                // Kiểm tra và cập nhật model nếu cần
                if (table.getModel() != model) {
                    table.setModel(model);
                }
                // Xóa tất cả dữ liệu cũ trong bảng
                model.setRowCount(0);
                // Hiển thị kết quả tìm kiếm trong bảng
                for (bacSi user : result) {
                    model.addRow(new Object[]{user.getMaBS(), user.getTenBS(), user.getGioiTinhBS(), user.getSĐTBS(),user.getKhoa()});
                }
			}
		});
		btnNewButton_4.setBounds(420, 357, 89, 23);
		contentPane.add(btnNewButton_4);
	}
}
