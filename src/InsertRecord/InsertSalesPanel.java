package insertRecord;

import javax.swing.*;

import utility.Utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InsertSalesPanel extends JPanel {

	public InsertSalesPanel(JTextField bName_TF, JTextField fName_TF, JComboBox year_CB, JComboBox season_CB,
			JComboBox month_CB, JComboBox day_CB, JComboBox vaccinater_CB, JComboBox donor_CB) {

		setLayout(null);

		JComboBox sheepCB = new JComboBox();
		sheepCB.setBounds(41, 99, 109, 27);
		for (int i = 0; i < 99; i++) {
			sheepCB.addItem(i);
		}
		add(sheepCB);

		JLabel lblNewLabel_2_1 = new JLabel("Sales Record");
		lblNewLabel_2_1.setBounds(190, 23, 115, 16);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Sheep Sold");
		lblNewLabel_1_1_1_1_1_1.setBounds(62, 75, 75, 16);
		add(lblNewLabel_1_1_1_1_1_1);
		

		JComboBox cattleCB = new JComboBox();
		cattleCB.setBounds(185, 99, 109, 27);
		for (int i = 0; i < 99; i++) {
			cattleCB.addItem(i);
		}
		add(cattleCB);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Cattle Sold");
		lblNewLabel_1_1_1_1_1_1_1.setBounds(206, 75, 75, 16);
		add(lblNewLabel_1_1_1_1_1_1_1);

		JComboBox goatCB = new JComboBox();
		goatCB.setBounds(335, 99, 109, 27);
		for (int i = 0; i < 99; i++) {
			goatCB.addItem(i);
		}
		add(goatCB);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Goat Sold");
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(356, 75, 75, 16);
		add(lblNewLabel_1_1_1_1_1_1_1_1);

		JLabel lblNewLabel = new JLabel("Per Animal Cost (PKR)");
		lblNewLabel.setBounds(78, 157, 140, 16);
		add(lblNewLabel);

		JTextField animalCostTF = new JTextField();
		animalCostTF.setBounds(241, 152, 166, 26);
		add(animalCostTF);
		animalCostTF.setColumns(10);

		JButton submitButton = new JButton("Submit Sales Record");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Utility ut = new Utility();

					// get the BID using bname and fathername
					String bid = null;
					String sql = "SELECT BID FROM BENEFICIARY WHERE BNAME=? AND FATHERNAME=?";
					ut.pstmt = ut.conn.prepareStatement(sql);

					ut.pstmt.setString(1, bName_TF.getText());
					ut.pstmt.setString(2, fName_TF.getText());

					ut.rs = ut.pstmt.executeQuery();
					while (ut.rs.next()) {
						bid = ut.rs.getString(1);
					}
					if (bid == null) {
						JOptionPane.showMessageDialog(null,
								"Problem with Beneficiary Name or Father Name. Try adding a new Beneficiary if this one doesn't exist");
					}

					// Add a new RECORD if record doesn't already exist
					sql = "SELECT * FROM VACCINATION_RECORD WHERE VYEAR=? AND season=? AND BID=?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, year_CB.getSelectedItem().toString());
					ut.pstmt.setString(2, season_CB.getSelectedItem().toString());
					ut.pstmt.setString(3, bid);

					ut.rs = ut.pstmt.executeQuery();
					// If no Vaccination_Record found for this Beneficiary
					ut.conn.setAutoCommit(false);
					if (!ut.rs.next()) {
						sql = "INSERT INTO VACCINATION_RECORD (VYEAR,season,VDATE,VACCINATER,DONOR,BID,BANIMALSLAUGHTERED,\n"
								+ "SANIMALSLAUGHTERED,\n" + "SHEEPSOLD,\n" + "CATTLESOLD,\n" + "GOATSOLD,\n"
								+ "PERANIMALCOST) VALUES (?,?,?,?,?,?,0,0,0,0,0,0)"; // temp value of 0 for some
																						// attributes
						ut.pstmt = ut.conn.prepareStatement(sql);
						ut.pstmt.setString(1, year_CB.getSelectedItem().toString());
						ut.pstmt.setString(2, season_CB.getSelectedItem().toString());

						String date = year_CB.getSelectedItem().toString() + month_CB.getSelectedItem().toString()
								+ day_CB.getSelectedItem().toString();
						ut.pstmt.setString(3, date);
						ut.pstmt.setString(4, vaccinater_CB.getSelectedItem().toString());
						ut.pstmt.setString(5, donor_CB.getSelectedItem().toString());
						ut.pstmt.setString(6, bid);
						ut.pstmt.executeUpdate();

						int x = JOptionPane.showConfirmDialog(null, "Do you wish to add a new RECORD",
								"Press Yes or No", JOptionPane.YES_NO_OPTION);

						if (x == JOptionPane.YES_OPTION) {
							ut.conn.commit();
							JOptionPane.showMessageDialog(null, "Transaction is Succesful");
						} else {
							ut.conn.rollback();
							JOptionPane.showMessageDialog(null, "Transaction not Saved");
						}
					}

					// GET new RID

					String rid = null;
					sql = "SELECT RID FROM VACCINATION_RECORD WHERE VYEAR=? AND season=? AND BID=?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, year_CB.getSelectedItem().toString());
					ut.pstmt.setString(2, season_CB.getSelectedItem().toString());
					ut.pstmt.setString(3, bid);
					ut.rs = ut.pstmt.executeQuery();
					while (ut.rs.next()) {
						rid = ut.rs.getString(1);
					}

					// Add Slaughter Values
					sql = "UPDATE VACCINATION_RECORD\n" + "SET SHEEPSOLD=?,CATTLESOLD=?,GOATSOLD=?,PERANIMALCOST=?\n"
							+ "WHERE RID=?;";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, sheepCB.getSelectedItem().toString());
					ut.pstmt.setString(2, cattleCB.getSelectedItem().toString());
					ut.pstmt.setString(3, goatCB.getSelectedItem().toString());
					ut.pstmt.setString(4, animalCostTF.getText());
					ut.pstmt.setString(5, rid);
					ut.pstmt.executeUpdate();
					int x = JOptionPane.showConfirmDialog(null, "Do you wish to add a new Sales Record",
							"Press Yes or No", JOptionPane.YES_NO_OPTION);

					if (x == JOptionPane.YES_OPTION) {
						ut.conn.commit();
						JOptionPane.showMessageDialog(null, "Transaction is Succesful");
					} else {
						ut.conn.rollback();
						JOptionPane.showMessageDialog(null, "Transaction not Saved");
					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "An error occurred while inserting: " + e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		submitButton.setBounds(149, 203, 204, 29);

		add(submitButton);


	}

}
