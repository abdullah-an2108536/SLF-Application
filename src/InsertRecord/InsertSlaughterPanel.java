package insertRecord;

import javax.swing.*;

import utility.Utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InsertSlaughterPanel extends JPanel {

	/**
	 * Create the panel.
	 *
	 * @param donor_CB
	 * @param vaccinater_CB
	 * @param date_TF
	 * @param season_CB
	 * @param year_CB
	 * @param fName_TF
	 */
	public InsertSlaughterPanel(JTextField bName_TF, JTextField fName_TF, JComboBox year_CB, JComboBox season_CB,
			JComboBox month_CB, JComboBox day_CB, JComboBox vaccinater_CB, JComboBox donor_CB) {

		setLayout(null);

		JComboBox smallAnimalCB = new JComboBox();
		smallAnimalCB.setBounds(38, 113, 176, 27);
		for (int i = 0; i < 99; i++) {
			smallAnimalCB.addItem(i);
		}
		add(smallAnimalCB);

		JLabel lblNewLabel_2_1 = new JLabel("Slaughter Record");
		lblNewLabel_2_1.setBounds(194, 6, 115, 16);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Small Animals Slaughtered");
		lblNewLabel_1_1_1_1_1_1.setBounds(41, 75, 176, 16);
		add(lblNewLabel_1_1_1_1_1_1);

		JLabel tf = new JLabel("Big Animals Slaughtered");
		tf.setBounds(277, 75, 160, 16);
		add(tf);

		JComboBox bigAnimalCB = new JComboBox();
		bigAnimalCB.setBounds(277, 113, 160, 27);
		for (int i = 0; i < 99; i++) {
			bigAnimalCB.addItem(i);
		}
		add(bigAnimalCB);

		JButton submitButton = new JButton("Submit Slaughter Record");
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
						
						String date=year_CB.getSelectedItem().toString()+month_CB.getSelectedItem().toString()+day_CB.getSelectedItem().toString();
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
					sql = "UPDATE VACCINATION_RECORD\n" + "SET BAnimalSlaughtered=?,SAnimalSlaughtered=?\n"
							+ "WHERE RID=?;";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, bigAnimalCB.getSelectedItem().toString());
					ut.pstmt.setString(2, smallAnimalCB.getSelectedItem().toString());
					ut.pstmt.setString(3, rid);
					ut.pstmt.executeUpdate();
					int x = JOptionPane.showConfirmDialog(null, "Do you wish to add a new Slaughter Record",
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
		submitButton.setBounds(144, 170, 204, 29);

		add(submitButton);

	}



}
