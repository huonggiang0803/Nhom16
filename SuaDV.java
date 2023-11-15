package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DichVu;
import model.NhanVien;
import service.ServiceDichVu;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuaDV extends JFrame {

	private JPanel contentPane;
	private JTextField matextField;
	private JTextField tentextField_1;
	private JTextField dgtextField_2;
	DichVu dv;
	ServiceDichVu serviceDV;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SuaDV frame = new SuaDV();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param donGia 
	 * @param tenDV 
	 * @param maDV 
	 */
	public SuaDV(String maDV, String tenDV, Float donGia) {
		dv = new DichVu();
		serviceDV = new ServiceDichVu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SỬA THÔNG TIN DỊCH VỤ");
		lblNewLabel.setBounds(145, 5, 123, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.setBounds(0, 1, 89, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 66, 414, 126);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã DV");
		lblNewLabel_1.setBounds(53, 11, 52, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên DV");
		lblNewLabel_2.setBounds(53, 55, 52, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Đơn giá");
		lblNewLabel_3.setBounds(53, 101, 58, 14);
		panel_1.add(lblNewLabel_3);
		
		matextField = new JTextField();
		matextField.setEditable(false);
		matextField.setColumns(10);
		matextField.setBounds(160, 8, 126, 20);
		panel_1.add(matextField);
		
		tentextField_1 = new JTextField();
		tentextField_1.setColumns(10);
		tentextField_1.setBounds(160, 52, 125, 20);
		panel_1.add(tentextField_1);
		
		dgtextField_2 = new JTextField();
		dgtextField_2.setColumns(10);
		dgtextField_2.setBounds(160, 98, 126, 20);
		panel_1.add(dgtextField_2);
		
		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maDV = matextField.getText();
				String tenDV = tentextField_1.getText();
				String donGiaText = dgtextField_2.getText();
				Float donGia = null;
				if (!donGiaText.isEmpty()) {
				    try {
				        donGia = Float.valueOf(donGiaText);
				    } catch (NumberFormatException e1) {
				        System.err.println("Invalid donGia value: " + donGiaText);
				        return;
				    }
				}
				DichVu existingUser = serviceDV.selectById(maDV);
				existingUser.setTenDV(tenDV);
				existingUser.setDonGia(donGia);

				serviceDV.updateDV(existingUser);

				new ThongTinDichVu().setVisible(true);
			}
		});
		btnNewButton.setBounds(158, 216, 89, 23);
		matextField.setText(maDV);
		tentextField_1.setText(tenDV);
		if (donGia != null) {
		    dgtextField_2.setText(String.valueOf(donGia));
		} else {
		    dgtextField_2.setText(""); 
		}
		contentPane.add(btnNewButton);
		
	}

}
