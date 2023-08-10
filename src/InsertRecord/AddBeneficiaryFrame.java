package insertRecord;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import utility.Utility;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class AddBeneficiaryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField beneficiaryTF;
	private JTextField fatherTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBeneficiaryFrame frame = new AddBeneficiaryFrame();
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
	public AddBeneficiaryFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 513, 324);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(118, 179, 220));
		panel.setBounds(6, 6, 501, 284);
		contentPane.add(panel);

		JLabel lblNewLabel_2 = new JLabel("Insert Beneficiary");
		lblNewLabel_2.setFont(new Font("Songti TC", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(191, 21, 150, 35);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Village");
		lblNewLabel_1_1.setBounds(47, 153, 61, 16);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));

		JComboBox villageCB = new JComboBox();
		villageCB.setBounds(169, 148, 203, 27);
		panel.add(villageCB);

		JLabel lblNewLabel_1_2 = new JLabel("Community Name");
		lblNewLabel_1_2.setBounds(47, 192, 118, 16);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Helvetica", Font.PLAIN, 13));

		JComboBox communityCB = new JComboBox();
		communityCB.setBounds(169, 187, 204, 27);
		panel.add(communityCB);

		JButton newCommunityBTN = new JButton("New Community");
		newCommunityBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCommunityFrame.main(null);
				dispose();
			}
		});
		newCommunityBTN.setBounds(367, 186, 128, 29);
		panel.add(newCommunityBTN);

		JLabel lblNewLabel_1 = new JLabel("Father Name");
		lblNewLabel_1.setBounds(47, 125, 118, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Helvetica", Font.PLAIN, 13));

		JLabel lblNewLabel = new JLabel("Beneficiary Name");
		lblNewLabel.setBounds(47, 97, 130, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));

		fatherTF = new JTextField();
		fatherTF.setBounds(169, 119, 279, 26);
		panel.add(fatherTF);
		fatherTF.setColumns(10);

		beneficiaryTF = new JTextField();
		beneficiaryTF.setBounds(169, 91, 279, 26);
		panel.add(beneficiaryTF);
		beneficiaryTF.setColumns(10);

		JButton submitBTN = new JButton("Submit");
		submitBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utility ut = new Utility();
				String beneficiaryName = beneficiaryTF.getText();
				String fatherName = fatherTF.getText();
				String selectedVillage = (String) villageCB.getSelectedItem();
				String selectedCommunity = (String) communityCB.getSelectedItem();

				try {
					String insertQuery = "INSERT INTO BENEFICIARY (BName, FatherName, Village, CName) VALUES (?, ?, ?, ?)";
					ut.pstmt = ut.conn.prepareStatement(insertQuery);
					ut.pstmt.setString(1, beneficiaryName);
					ut.pstmt.setString(2, fatherName);
					ut.pstmt.setString(3, selectedVillage);
					ut.pstmt.setString(4, selectedCommunity);

					int rowsAffected = ut.pstmt.executeUpdate();
					if (rowsAffected > 0) {
						JOptionPane.showMessageDialog(null, "Beneficiary added successfully.");
					} else {
						JOptionPane.showMessageDialog(null, "Failed to add beneficiary.");
					}

					ut.pstmt.close();
				} catch (SQLException sqle) {
					if (sqle.getSQLState().equals("23505")) {
						JOptionPane.showMessageDialog(null,
								"Duplicate entry: Beneficiary with the same name, father name, village, and community already exists.",
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"An error occurred while inserting the community: " + ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		submitBTN.setBounds(211, 235, 117, 29);
		panel.add(submitBTN);

		JButton newVillageBTN = new JButton("new");
		newVillageBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVillageFrame addVillageFrame = new AddVillageFrame(villageCB);
				addVillageFrame.setVisible(true);

			}
		});
		newVillageBTN.setBounds(367, 147, 78, 29);
		panel.add(newVillageBTN);

		// Populate village and community combo boxes
		Utility ut = new Utility();
		List<String> villageNames = ut.getUniqueVillages();
		for (String village : villageNames) {
			villageCB.addItem(village);
		}

		List<String> communityNames = ut.getUniqueCommunities();
		for (String community : communityNames) {
			communityCB.addItem(community);
		}
	}
}


