package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TongHopGia extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TongHopGia frame = new TongHopGia();
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
	public TongHopGia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 618, 29);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("TỔNG HÓA ĐƠN");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 63, 618, 152);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã HĐ");
		lblNewLabel_1.setBounds(10, 11, 66, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã BN");
		lblNewLabel_1_1.setBounds(10, 43, 46, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã Thuốc");
		lblNewLabel_1_2.setBounds(10, 71, 66, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tên NV");
		lblNewLabel_1_3.setBounds(10, 96, 46, 14);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mã DV");
		lblNewLabel_1_4.setBounds(346, 11, 46, 14);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tên BN");
		lblNewLabel_1_5.setBounds(344, 43, 99, 14);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Ngày thu");
		lblNewLabel_1_6.setBounds(346, 71, 64, 14);
		panel_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Tổng thanh toán");
		lblNewLabel_1_7.setBounds(344, 96, 99, 14);
		panel_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_2 = new JLabel("Tiền phải đóng");
		lblNewLabel_2.setBounds(346, 127, 99, 14);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(119, 8, 130, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(119, 40, 130, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(119, 68, 130, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(119, 93, 130, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(452, 8, 138, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(452, 40, 138, 20);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(452, 68, 138, 20);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(452, 93, 138, 20);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(455, 124, 135, 20);
		panel_1.add(textField_8);
		
		JLabel lblNewLabel_3 = new JLabel("BH thanh toán");
		lblNewLabel_3.setBounds(10, 127, 115, 14);
		panel_1.add(lblNewLabel_3);
		
		textField_9 = new JTextField();
		textField_9.setBounds(119, 124, 130, 20);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 236, 618, 152);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 618, 152);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 618, 152);
		panel_3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"H\u011001", "BN04", "T\u00F4n Th\u1EA3o", "V\u00F5 Thu Hi\u1EC1n", "T05", "DV03", "2023-10-16", new Integer(213000), new Integer(0), new Integer(213000)},
				{"H\u011002", "LHBN02", "\u0110o\u00E0n H\u1ED3ng", "T\u00F4n S\u00E1ng", "T06", "DV02,DV04", "2023-12-14", new Integer(130000), new Integer(39000), new Integer(91000)},
				{"H\u011003", "BN02", "Tr\u1EA7n Huy H\u1EA3o", "V\u00F5 Thu Hi\u1EC1n", "T03", "DV04", "2023-09-02", new Integer(120000), new Integer(0), new Integer(120000)},
				{"H\u011004", "BN01", "Nguy\u1EC5n V\u0103n Nam", "T\u00F4n Kh\u00E1nh Ly", "T02", "DV02", "2023-10-17", new Integer(125000), new Integer(37500), new Integer(87500)},
				{"H\u011005", "BN03", "Nguy\u1EC5n Giang", "V\u00F5 Thu Hi\u1EC1n", "T04", "DV03", "2023-09-15", new Integer(178000), new Integer(53400), new Integer(124600)},
				{"H\u011006", "LHBN01", "Nguy\u1EC5n My", "V\u00F5 Thu Hi\u1EC1n", "T01", "DV01", "2023-10-17", new Integer(450000), new Integer(135000), new Integer(315000)},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u0110", "M\u00E3 BN", "T\u00EAn BN", "T\u00EAn NV", "M\u00E3 Thu\u1ED1c", "M\u00E3 DV", "Ng\u00E0y thu", "T\u1ED5ng ti\u1EC1n", "BHTT", "STP\u0110"
			}
		));
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(10, 403, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setBounds(118, 403, 89, 23);
		contentPane.add(btnXa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setBounds(223, 403, 89, 23);
		contentPane.add(btnSa);
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.setBounds(336, 403, 89, 23);
		contentPane.add(btnTmKim);
		
		JButton btnLu = new JButton("Lưu");
		btnLu.setBounds(445, 403, 89, 23);
		contentPane.add(btnLu);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DangNhapHeThong().setVisible(true);
				dispose();
			}
		});
		btnThot.setBounds(549, 403, 89, 23);
		contentPane.add(btnThot);
	}

}
