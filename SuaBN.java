package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.benhNhan;
import service.ServicebenhNhan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class SuaBN extends JFrame {

	private JPanel contentPane;
	private JTextField matextField;
	private JTextField SDTtextField_1;
	private JTextField tentextField_2;
	private JTextField datetextField_3;
	private JTextField maBHtextField_4;
	private JTextField addresstextField_5;
	ServicebenhNhan serviceBN;
	benhNhan bn;
	private Object options;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SuaBN frame = new SuaBN();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SuaBN(String maBN,String tenBN,String gioiTinhBN,Date ngaySinh,String doiTuong,String maBH,String diaChiBN,String SĐTBN) {
		bn = new benhNhan();
		serviceBN = new ServicebenhNhan();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(140, 11, 414, 30);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("SỬA THÔNG TIN BỆNH NHÂN");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 68, 637, 222);
		contentPane.add(panel_1);
		
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
		
		matextField = new JTextField();
		matextField.setColumns(10);
		matextField.setBounds(113, 18, 179, 20);
		panel_1.add(matextField);
		
		SDTtextField_1 = new JTextField();
		SDTtextField_1.setColumns(10);
		SDTtextField_1.setBounds(113, 175, 179, 20);
		panel_1.add(SDTtextField_1);
		
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
		dtcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Bảo hiểm", "Không bảo hiểm"}));
		dtcomboBox.setBounds(113, 117, 179, 22);
		panel_1.add(dtcomboBox);
		
		JRadioButton namRadioButton = new JRadioButton("Nam");
		namRadioButton.setBounds(125, 61, 71, 23);
		panel_1.add(namRadioButton);
		
		JRadioButton nuRadioButton_1 = new JRadioButton("Nữ");
		nuRadioButton_1.setBounds(221, 61, 57, 23);
		panel_1.add(nuRadioButton_1);
		
		 ButtonGroup genderButtonGroup = new ButtonGroup();
	     genderButtonGroup.add(namRadioButton);
	     genderButtonGroup.add(nuRadioButton_1);
	        
		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String maBN = matextField.getText();
		        String tenBN = tentextField_2.getText();
		       
		        String gioiTinh;
		        if (namRadioButton.isSelected()) {
		            gioiTinh = "Nam";
		        } else if (nuRadioButton_1.isSelected()) {
		            gioiTinh = "Nữ";
		        }

		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        java.util.Date ngaySinh = null;
		        try {
		            ngaySinh = dateFormat.parse(datetextField_3.getText());
		        } catch (ParseException e1) {
		            e1.printStackTrace();
		        }

		        String doiTuong = (String) dtcomboBox.getSelectedItem();
		        String maBH = maBHtextField_4.getText();
		        String diaChiBN = addresstextField_5.getText();
		        String SĐTBN = SDTtextField_1.getText();
		        benhNhan existingUser = serviceBN.selectById(maBN);

		        // Update the attributes
		        existingUser.setTenBN(tenBN);
		        existingUser.setGioiTinhBN(gioiTinhBN);
		        existingUser.setNgaySinh(new java.sql.Date(ngaySinh.getTime()));
		        existingUser.setDoiTuong(doiTuong);
		        existingUser.setMaBH(maBH);
		        existingUser.setDiaChiBN(diaChiBN);
		        existingUser.setSĐTBN(SĐTBN);
		        if (!tentextField_2.getText().isEmpty()) {
		        	existingUser.setTenBN(tenBN); 
		        }
		        if (ngaySinh != null) {
		            existingUser.setNgaySinh(new java.sql.Date(ngaySinh.getTime()));
		        }
		        if (!doiTuong.isEmpty()) {
		            existingUser.setDoiTuong(doiTuong);
		        }
		        if (!maBH.isEmpty()) {
		            existingUser.setMaBH(maBH);
		        }
		        if (!diaChiBN.isEmpty()) {
		            existingUser.setDiaChiBN(diaChiBN);
		        }
		        if (!SĐTBN.isEmpty()) {
		            existingUser.setSĐTBN(SĐTBN);
		        }
				serviceBN.updateBN(existingUser);
                // Hiển thị lại frame danh sách người dùng
                new ThongTinBenhNhan().setVisible(true);

		}});
		btnNewButton.setBounds(254, 298, 89, 23);
		contentPane.add(btnNewButton);
		matextField.setText(maBN);
		tentextField_2.setText(tenBN);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(ngaySinh);
		datetextField_3.setText(formattedDate);
		maBHtextField_4.setText(maBH);
		addresstextField_5.setText(diaChiBN);
		SDTtextField_1.setText(SĐTBN);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThongTinBenhNhan().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
