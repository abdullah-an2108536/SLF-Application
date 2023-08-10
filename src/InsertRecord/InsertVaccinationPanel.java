package insertRecord;

import javax.swing.*;

import utility.Utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class InsertVaccinationPanel extends JPanel {

	public InsertVaccinationPanel(JTextField bName_TF, JTextField fName_TF, JComboBox year_CB, JComboBox season_CB,
			JComboBox month_CB, JComboBox day_CB, JComboBox vaccinater_CB, JComboBox donor_CB) {

		setLayout(null);

		JComboBox goatCB = new JComboBox();
		goatCB.setBounds(19, 152, 83, 27);
		for (int i = 0; i < 99; i++) {
			goatCB.addItem(i);
		}
		add(goatCB);

		JLabel lblNewLabel_2_1 = new JLabel("Vaccination Record");
		lblNewLabel_2_1.setBounds(173, 6, 167, 16);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Vaccination Type");
		lblNewLabel_1_1_2.setBounds(41, 50, 107, 16);
		add(lblNewLabel_1_1_2);

		JComboBox type_CB = new JComboBox();
		type_CB.setBounds(179, 46, 229, 27);
		Utility ut = new Utility();
		List<String> villageNames = ut.getUniqueDvtype();
		for (String village : villageNames) {
			type_CB.addItem(village);
		}
		add(type_CB);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Sheep");
		lblNewLabel_1_1_1_1_1.setBounds(315, 124, 37, 16);
		add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Goat");
		lblNewLabel_1_1_1_1_1_1.setBounds(41, 124, 61, 16);
		add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Cattle");
		lblNewLabel_1_1_1_1_1_2.setBounds(122, 124, 61, 16);
		add(lblNewLabel_1_1_1_1_1_2);

		JLabel lblNewLabel_1_1_1_1_1_3 = new JLabel("Dozoo or Yak");
		lblNewLabel_1_1_1_1_1_3.setBounds(195, 124, 85, 16);
		add(lblNewLabel_1_1_1_1_1_3);

		JLabel lblNewLabel_2_1_1 = new JLabel("# Livestock Vaccinated");
		lblNewLabel_2_1_1.setBounds(155, 92, 167, 16);
		add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_1_1_1_1_1_4 = new JLabel("Other");
		lblNewLabel_1_1_1_1_1_4.setBounds(387, 124, 61, 16);
		add(lblNewLabel_1_1_1_1_1_4);

		JComboBox cattleCB = new JComboBox();
		cattleCB.setBounds(100, 152, 83, 27);
		for (int i = 0; i < 99; i++) {
			cattleCB.addItem(i);
		}
		add(cattleCB);

		JComboBox yakCB = new JComboBox();
		yakCB.setBounds(195, 152, 83, 27);
		for (int i = 0; i < 99; i++) {
			yakCB.addItem(i);
		}
		add(yakCB);

		JComboBox sheepCB = new JComboBox();
		sheepCB.setBounds(290, 152, 83, 27);
		for (int i = 0; i < 99; i++) {
			sheepCB.addItem(i);
		}
		add(sheepCB);

		JComboBox otherCB = new JComboBox();
		otherCB.setBounds(375, 152, 83, 27);
		for (int i = 0; i < 99; i++) {
			otherCB.addItem(i);
		}
		add(otherCB);

		JButton submitButton = new JButton("Submit Vaccination Record");
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

					// Add a new Vaccination_Record
					sql = "INSERT INTO VRECORD (VSHEEP,\n" + "VGOAT,\n" + "VCATTLE,\n" + "VDOZOO_YAK,\n" + "VOTHERS,\n"
							+ "VACCINATIONTYPE,\n" + "RID) VALUES (?,?,?,?,?,?,?)";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, sheepCB.getSelectedItem().toString());
					ut.pstmt.setString(2, goatCB.getSelectedItem().toString());
					ut.pstmt.setString(3, cattleCB.getSelectedItem().toString());
					ut.pstmt.setString(4, yakCB.getSelectedItem().toString());
					ut.pstmt.setString(5, otherCB.getSelectedItem().toString());
					ut.pstmt.setString(6, type_CB.getSelectedItem().toString());
					ut.pstmt.setString(7, rid);
					ut.pstmt.executeUpdate();
					int x = JOptionPane.showConfirmDialog(null, "Do you wish to add a new Vaccination Record",
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
		submitButton.setBounds(136, 199, 204, 29);

		add(submitButton);

		JButton btnNewButton = new JButton("new");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVaccinationTypeFrame addVaccinationTypeFrame = new AddVaccinationTypeFrame(type_CB);
				addVaccinationTypeFrame.setVisible(true);

			}
		});
		btnNewButton.setBounds(404, 45, 70, 29);
		add(btnNewButton);

	}



}
