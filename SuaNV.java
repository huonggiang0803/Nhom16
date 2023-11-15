package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.nhanVienDao;
import model.NhanVien;
import model.bacSi;
import service.ServiceBacSi;
import service.ServiceNhanVien;

import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuaNV extends JFrame {

	private JPanel contentPane;
	private JTextField matextField;
	private JTextField tentextField_1;
	private JTextField sdttextField_2;
	NhanVien nv;
	ServiceNhanVien serviceNV;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SuaNV frame = new SuaNV();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param sĐTNV 
	 * @param gioiTinhNV 
	 * @param tenNV 
	 * @param maNV 
	 */
	public SuaNV(String maNV, String tenNV, String gioiTinhNV, String sĐTNV) {
		nv = new NhanVien();
		serviceNV = new ServiceNhanVien();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SỬA THÔNG TIN  NHÂN VIÊN");
		lblNewLabel.setBounds(137, 5, 139, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThongTinNhanVien().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(0, 1, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel MALabel_1 = new JLabel("Mã NV");
		MALabel_1.setBounds(10, 86, 46, 14);
		contentPane.add(MALabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Giới tính");
		lblNewLabel_2.setBounds(10, 147, 56, 14);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton namradiobutton = new JRadioButton("Nam");
		namradiobutton.setBounds(72, 143, 56, 23);
		contentPane.add(namradiobutton);
		
		JRadioButton nurdbtnN = new JRadioButton("Nữ");
		nurdbtnN.setBounds(146, 143, 56, 23);
		contentPane.add(nurdbtnN);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(namradiobutton);
		bg.add(nurdbtnN);
		
		JLabel TENlblNewLabel_3 = new JLabel("Tên NV");
		TENlblNewLabel_3.setBounds(236, 86, 46, 14);
		contentPane.add(TENlblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SĐTNV");
		lblNewLabel_4.setBounds(236, 147, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maNV = matextField.getText();
		        String tenNV = tentextField_1.getText();
		        String gioiTinh;
		        if (namradiobutton.isSelected()) {
		            gioiTinh = "Nam";
		        } else if (nurdbtnN.isSelected()) {
		            gioiTinh = "Nữ";
		        } else {
		            // Handle the case where neither radio button is selected
		            gioiTinh = ""; // Or set a default value
		        }
		        String SĐTNV = sdttextField_2.getText();
		        NhanVien existingUser = serviceNV.selectById(maNV);

		        existingUser.setTenNV(tenNV);
		        existingUser.setGioiTinhNV(gioiTinh);  
		        existingUser.setSĐTNV(SĐTNV);
		        if (!tentextField_1.getText().isEmpty()) {
		            existingUser.setTenNV(tenNV);
		        }
		        if (!SĐTNV.isEmpty()) {
		            existingUser.setSĐTNV(SĐTNV);
		        }
		        serviceNV.updateNV(existingUser);

		        new ThongTinNhanVien().setVisible(true);
			}
		});
		btnNewButton.setBounds(157, 210, 89, 23);
		contentPane.add(btnNewButton);
		
		matextField = new JTextField();
		matextField.setBounds(69, 83, 133, 20);
		contentPane.add(matextField);
		matextField.setColumns(10);
		
		tentextField_1 = new JTextField();
		tentextField_1.setColumns(10);
		tentextField_1.setBounds(292, 83, 132, 20);
		contentPane.add(tentextField_1);
		
		sdttextField_2 = new JTextField();
		sdttextField_2.setColumns(10);
		sdttextField_2.setBounds(292, 144, 132, 20);
		contentPane.add(sdttextField_2);
		
		matextField.setText(maNV);
		tentextField_1.setText(tenNV);
		sdttextField_2.setText(sĐTNV);
	}

}
