package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DichVu;
import model.Thuoc;
import service.ServiceThuoc;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuaThuoc extends JFrame {

	private JPanel contentPane;
	private JTextField matextField;
	private JTextField giatextField_1;
	private JTextField tentextField_2;
	private JTextField xxtextField_3;
	Thuoc t;
	ServiceThuoc serviceThuoc;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SuaThuoc frame = new SuaThuoc();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param xuatXu 
	 * @param giaThuoc 
	 * @param tenThuoc 
	 * @param maThuoc 
	 */
	public SuaThuoc(String maThuoc, String tenThuoc, Float giaThuoc, String xuatXu) {
		t = new Thuoc();
		serviceThuoc = new ServiceThuoc();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 442, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SỬA THÔNG TIN THUỐC");
		lblNewLabel.setBounds(162, 5, 117, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThongTinThuoc().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(0, 1, 89, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 67, 462, 106);
		contentPane.add(panel_2);
		
		JLabel malblNewLabel_1 = new JLabel("Mã Thuốc");
		malblNewLabel_1.setBounds(10, 11, 46, 14);
		panel_2.add(malblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giá thuốc");
		lblNewLabel_1_1.setBounds(10, 64, 61, 14);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel tenlblNewLabel_2 = new JLabel("Tên thuốc");
		tenlblNewLabel_2.setBounds(228, 11, 61, 14);
		panel_2.add(tenlblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Xuất xứ");
		lblNewLabel_3.setBounds(228, 64, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		matextField = new JTextField();
		matextField.setColumns(10);
		matextField.setBounds(85, 8, 105, 20);
		panel_2.add(matextField);
		
		giatextField_1 = new JTextField();
		giatextField_1.setColumns(10);
		giatextField_1.setBounds(81, 58, 105, 20);
		panel_2.add(giatextField_1);
		
		tentextField_2 = new JTextField();
		tentextField_2.setColumns(10);
		tentextField_2.setBounds(294, 5, 105, 20);
		panel_2.add(tentextField_2);
		
		xxtextField_3 = new JTextField();
		xxtextField_3.setColumns(10);
		xxtextField_3.setBounds(294, 61, 105, 20);
		panel_2.add(xxtextField_3);
		
		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maThuoc = matextField.getText();
				String tenThuoc = tentextField_2.getText();
				String giaThuocText = giatextField_1.getText();
				Float giaThuoc = null;
				if (!giaThuocText.isEmpty()) {
				    try {
				    	giaThuoc = Float.valueOf(giaThuocText);
				    } catch (NumberFormatException e1) {
				        System.err.println("Invalid donGia value: " + giaThuocText);
				        return;
				    }
				}
				String xuatXu = xxtextField_3.getText();

				Thuoc existingUser = serviceThuoc.selectById(maThuoc);
				existingUser.setTenThuoc(tenThuoc);
				existingUser.setGiaThuoc(giaThuoc);
				existingUser.setXuatXu(xuatXu);

				serviceThuoc.updateT(existingUser);

				new ThongTinThuoc().setVisible(true);
			}
			
		});
		btnNewButton.setBounds(177, 200, 89, 23);
		matextField.setText(maThuoc);
		tentextField_2.setText(tenThuoc);
		if (giaThuoc != null) {
		    giatextField_1.setText(String.valueOf(giaThuoc));
		} else {
		    giatextField_1.setText(""); 
		}
		xxtextField_3.setText(xuatXu);
		contentPane.add(btnNewButton);
	}

}
