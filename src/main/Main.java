package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

import utility.Utility;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	
	ImageIcon logoImage=new ImageIcon("SLF-Logo.png");
	private JLabel lblNewLabel_3;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 453);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Login to SLF Database");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(467, 53, 241, 38);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(543, 145, 136, 26);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel.setBackground(new Color(244, 255, 236));
		lblNewLabel.setBounds(436, 150, 91, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1.setBounds(436, 219, 79, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Utility ut = new Utility();
					String sql = "SELECT USERNAME,USERPASSWORD FROM LOGIN WHERE USERNAME=? AND USERPASSWORD=?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, textField.getText());
					ut.pstmt.setString(2, textField_1.getText());
					ut.rs = ut.pstmt.executeQuery();
					if (ut.rs.next()) {
						System.out.println("hi");
						System.out.println("opening menu");
						Menu.main(null);
						
						dispose();
					} else {
						System.out.println("no");

						JOptionPane.showMessageDialog(null, "Username or Password is incorrect, TRY AGAIN");
						ut.conn.close();
					}

				} catch (SQLException e1) {
//					JOptionPane.showMessageDialog(null, "Username or Password is incorrect, TRY AGAIN");
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(491, 278, 117, 29);
		contentPane.add(btnNewButton);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(118, 180, 221));
		contentPane_1.setBounds(0, 0, 375, 425);
		contentPane.add(contentPane_1);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(54, 112, 267, 189);
		contentPane_1.add(lblNewLabel_3);
		
		lblNewLabel_3.setIcon(logoImage);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(543, 214, 136, 26);
		contentPane.add(textField_1);
	}
}
