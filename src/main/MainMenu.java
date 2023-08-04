package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import InsertRecord.AddRecordFrame;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(118, 179, 221));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) SystemColor.activeCaption));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsertRecord = new JButton("Insert Record");
		btnInsertRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRecordFrame.main(null);
			}
		});
		btnInsertRecord.setBackground(new Color(130, 189, 217));
		btnInsertRecord.setFont(new Font("Bangla Sangam MN", Font.PLAIN, 20));
		btnInsertRecord.setBounds(151, 268, 196, 57);
		contentPane.add(btnInsertRecord);
		
		JButton btnViewData = new JButton("View Data");
		btnViewData.setBackground(new Color(130, 189, 217));
		btnViewData.setFont(new Font("Bangla Sangam MN", Font.PLAIN, 20));
		btnViewData.setBounds(433, 268, 196, 57);
		contentPane.add(btnViewData);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("SLF-Logo.png"));
		lblNewLabel.setBounds(243, 35, 281, 150);
		contentPane.add(lblNewLabel);
	}
}
