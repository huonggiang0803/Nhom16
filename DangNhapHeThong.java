package view;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.Icon;

public class DangNhapHeThong extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapHeThong frame = new DangNhapHeThong();
					frame.setTitle("Hệ thống quản lý khám bệnh");
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
	public DangNhapHeThong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 102);
		contentPane.add(panel);
		
		VeHinh vh = new VeHinh("Quản lý thông tin bệnh nhân",new ImageIcon("D:\\Picture\\-Users-2.24.png"),SwingConstants.CENTER);
		vh.setBounds(24, 24, 80, 65);
		vh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ThongTinBenhNhan().setVisible(true);
				dispose();
			}
		});
		panel.setLayout(null);
		vh.setText("<html><center>Thông tin <br/>\r\nbệnh nhân </center></html>");
		vh.setBackgroundColor(Color.green);
		panel.add(vh);
		
		JLabel label = new JLabel("");
		label.setBounds(104, 33, 0, 0);
		panel.add(label);
		
		VeHinh vh6 = new VeHinh("Thông tin nhân viên",new ImageIcon("D:\\Picture\\Hopstarter-Sleek-Xp-Basic-Preppy.24.png"),SwingConstants.CENTER);
		vh6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ThongTinNhanVien().setVisible(true);
				dispose();
			}
		});
		vh6.setBounds(129, 24, 80, 65);
		panel.add(vh6);
		vh6.setText("<html><center>Thông tin <br/>\r\nnhân viên </center></html>");
		vh6.setBackgroundColor(Color.green);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(209, 33, 0, 0);
		panel.add(label_2);
		
		VeHinh vh4 = new VeHinh("Quản lý bác sĩ",new ImageIcon("D:\\Picture\\Icons-Land-Medical-People-Doctor-Male.24.png"),SwingConstants.CENTER);
		vh4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ThongTinBacSi().setVisible(true);
				dispose();
			}
		});
		vh4.setBounds(232, 24, 80, 65);
		vh4.setText("<html><center>Thông tin <br/>\r\nbác sĩ </center></html>");
		vh4.setBackgroundColor(Color.green);
		panel.add(vh4);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(365, 33, 0, 0);
		panel.add(label_1);
		
		VeHinh vh5 = new VeHinh("Quản lý dịch vụ",new ImageIcon("D:\\Picture\\Custom-Icon-Design-Flatastic-11-Customer-service.24.png"),SwingConstants.CENTER);
		vh5.setBounds(324, 24, 80, 65);
		panel.add(vh5);
		vh5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ThongTinDichVu().setVisible(true);
				dispose();
			}
		});
		vh5.setText("<html><center>Thông tin <br/>\r\ndịch vụ </center></html>");
		vh5.setBackgroundColor(Color.green);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 124, 414, 126);
        contentPane.add(panel_1);
        
        VeHinh vh3 = new VeHinh("Thanh toán",new ImageIcon("D:\\\\Picture\\\\card-2-front-fill.32.png"),SwingConstants.CENTER);
        vh3.setBounds(56, 33, 80, 65);
        vh3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		dispose();
        	}
        });
        panel_1.setLayout(null);
        panel_1.add(vh3);
        vh3.setText("<html><center>Thanh toán</center></html>");
        vh3.setBackgroundColor(Color.green);
        
        VeHinh vh7 = new VeHinh("Quản lý thuốc",new ImageIcon("D:\\Picture\\Pictogrammers-Material-Medication.24.png"),SwingConstants.CENTER);
        vh7.setBounds(157, 33, 80, 65);
        vh7.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		new ThongTinThuoc().setVisible(true);
        		dispose();
        	}
        });
        panel_1.add(vh7);
        vh7.setText("<html><center>Quản lý <br/>\r\nthuốc </center></html>");
        vh7.setBackgroundColor(Color.green);
        
        VeHinh vhnhsKhmBnh = new VeHinh("Thông tin nhân viên", (Icon) null, 0);
        vhnhsKhmBnh.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		new ThuTucKhamBenh().setVisible(true);
        	}
        });
        vhnhsKhmBnh.setBounds(267, 37, 80, 65);
        vhnhsKhmBnh.setIcon(new ImageIcon("D:\\Picture\\Dapino-Medical-People-Medical-book.24.png"));
        vhnhsKhmBnh.setText("<html><center>Sổ khám bệnh</center></html>");
        vhnhsKhmBnh.setBackgroundColor(Color.GREEN);
        panel_1.add(vhnhsKhmBnh);
        
        
	}
}
