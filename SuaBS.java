package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bacSi;
import model.benhNhan;
import service.ServiceBacSi;
import service.ServicebenhNhan;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class SuaBS extends JFrame {

	private JPanel contentPane;
	private JTextField khoatextField_1;
	private JTextField tentextField_2;
	private JTextField sdttextField_3;
	private JTextField matextField_4;
	bacSi bs;
	ServiceBacSi serviceBS;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SuaBS frame = new SuaBS();
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
	public SuaBS(String maBS,String tenBS,String gioiTinhBS,String SĐTBS, String Khoa) {
		bs = new bacSi();
		serviceBS = new ServiceBacSi();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SỬA THÔNG TIN BÁC SĨ");
		lblNewLabel.setBounds(149, 5, 115, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThongTinBacSi().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(0, 1, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel MANewLabel_1 = new JLabel("Mã BS");
		MANewLabel_1.setBounds(10, 69, 46, 14);
		contentPane.add(MANewLabel_1);
		
		JLabel gtNewLabel_2 = new JLabel("Giới tính");
		gtNewLabel_2.setBounds(10, 122, 62, 14);
		contentPane.add(gtNewLabel_2);
		
		JLabel khoalblNewLabel_3 = new JLabel("Khoa");
		khoalblNewLabel_3.setBounds(10, 175, 46, 14);
		contentPane.add(khoalblNewLabel_3);
		
		JLabel TENNewLabel_4 = new JLabel("Tên BS");
		TENNewLabel_4.setBounds(226, 69, 62, 14);
		contentPane.add(TENNewLabel_4);
		
		JLabel sdtlblNewLabel_5 = new JLabel("SĐT BS");
		sdtlblNewLabel_5.setBounds(226, 122, 46, 14);
		contentPane.add(sdtlblNewLabel_5);
		
		khoatextField_1 = new JTextField();
		khoatextField_1.setColumns(10);
		khoatextField_1.setBounds(66, 172, 126, 20);
		contentPane.add(khoatextField_1);
		
		tentextField_2 = new JTextField();
		tentextField_2.setColumns(10);
		tentextField_2.setBounds(298, 66, 126, 20);
		contentPane.add(tentextField_2);
		
		sdttextField_3 = new JTextField();
		sdttextField_3.setColumns(10);
		sdttextField_3.setBounds(298, 119, 126, 20);
		contentPane.add(sdttextField_3);
		
		matextField_4 = new JTextField();
		matextField_4.setColumns(10);
		matextField_4.setBounds(66, 66, 126, 20);
		contentPane.add(matextField_4);
		
		JRadioButton namRadioButton = new JRadioButton("Nam");
		namRadioButton.setBounds(66, 118, 53, 23);
		contentPane.add(namRadioButton);
		
		JRadioButton nujradiobutton = new JRadioButton("Nữ");
		nujradiobutton.setBounds(139, 118, 53, 23);
		contentPane.add(nujradiobutton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(nujradiobutton);
		bg.add(namRadioButton);
		
		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maBS = matextField_4.getText();
		        String tenBS = tentextField_2.getText();
		        String gioiTinh;
		        if (namRadioButton.isSelected()) {
		            gioiTinh = "Nam";
		        } else if (nujradiobutton.isSelected()) {
		            gioiTinh = "Nữ";
		        } else {
		            // Handle the case where neither radio button is selected
		            gioiTinh = ""; // Or set a default value
		        }
		        String SĐTBS = sdttextField_3.getText();
		        String Khoa = khoatextField_1.getText();

		        bacSi existingUser = serviceBS.selectById(maBS);

		        existingUser.setTenBS(tenBS);
		        existingUser.setGioiTinhBS(gioiTinh);  
		        existingUser.setSĐTBS(SĐTBS);
		        existingUser.setKhoa(Khoa);

		        // Check for non-empty values and set them again
		        if (!tentextField_2.getText().isEmpty()) {
		            existingUser.setTenBS(tenBS);
		        }
		        if (!SĐTBS.isEmpty()) {
		            existingUser.setSĐTBS(SĐTBS);
		        }
		        if (!Khoa.isEmpty()) {
		            existingUser.setKhoa(Khoa);
		        }

		        serviceBS.updateBS(existingUser);

		        new ThongTinBacSi().setVisible(true);

			}
		});
		btnNewButton.setBounds(183, 227, 89, 23);
		matextField_4.setText(maBS);
		tentextField_2.setText(tenBS);
		sdttextField_3.setText(SĐTBS);
		khoatextField_1.setText(Khoa);
		contentPane.add(btnNewButton);
	}

}
