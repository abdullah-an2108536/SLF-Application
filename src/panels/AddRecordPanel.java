package panels;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import utility.Utility;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class AddRecordPanel extends JPanel {
	private JTextField bName_TF;
	private JTextField vaccinater_TF;
	private JTextField donor_TF;
	private JTextField fName_TF;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JTextField date_TF;

	/**
	 * Create the panel.
	 */
	public AddRecordPanel() {
		setBorder(new MatteBorder(0, 1, 1, 1, (Color) Color.WHITE));
		setBackground(new Color(254, 255, 255));
		setPreferredSize(new Dimension(882, 587));
		setLayout(null);
		setLayout(null);

		JComboBox goatCB = new JComboBox();
		goatCB.setBounds(272, 601, 83, 27);
		for (int i = 0; i < 100; i++) {
			goatCB.addItem(i);
		}
		add(goatCB);

		bName_TF = new JTextField();
		bName_TF.setBounds(432, 123, 249, 26);
		add(bName_TF);
		bName_TF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Beneficiary Name");
		lblNewLabel.setBounds(294, 128, 130, 16);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Father Name");
		lblNewLabel_1.setBounds(294, 160, 118, 16);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Year");
		lblNewLabel_1_1.setBounds(294, 228, 61, 16);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Vaccinater Name");
		lblNewLabel_1_1_1.setBounds(294, 347, 129, 16);
		add(lblNewLabel_1_1_1);

		vaccinater_TF = new JTextField();
		vaccinater_TF.setColumns(10);
		vaccinater_TF.setBounds(432, 342, 249, 26);
		add(vaccinater_TF);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Donor");
		lblNewLabel_1_1_1_1.setBounds(294, 385, 61, 16);
		add(lblNewLabel_1_1_1_1);

		donor_TF = new JTextField();
		donor_TF.setColumns(10);
		donor_TF.setBounds(432, 380, 249, 26);
		add(donor_TF);

		fName_TF = new JTextField();
		fName_TF.setColumns(10);
		fName_TF.setBounds(432, 155, 249, 26);
		add(fName_TF);

		lblNewLabel_1_2 = new JLabel("Quater");
		lblNewLabel_1_2.setBounds(294, 267, 61, 16);

		add(lblNewLabel_1_2);

		lblNewLabel_1_3 = new JLabel("Date");
		lblNewLabel_1_3.setBounds(294, 308, 61, 16);
		add(lblNewLabel_1_3);

		date_TF = new JTextField();
		date_TF.setToolTipText("MM/DD/YYYY");
		date_TF.setColumns(10);
		date_TF.setBounds(432, 303, 249, 26);
		add(date_TF);

		JComboBox quater_CB = new JComboBox();
		quater_CB.setBounds(432, 263, 161, 27);
		for (int i=1;i<=4;i++) {
			quater_CB.addItem(i);
		}
		add(quater_CB);

		JComboBox year_CB = new JComboBox();
		year_CB.setBounds(432, 224, 161, 27);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int year = currentYear; year <= currentYear + 10; year++) {
			year_CB.addItem(year);
		}

		add(year_CB);

		JLabel lblNewLabel_2_1 = new JLabel("Vaccination Record");
		lblNewLabel_2_1.setBounds(426, 455, 167, 16);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Vaccination Type");
		lblNewLabel_1_1_2.setBounds(294, 499, 107, 16);
		add(lblNewLabel_1_1_2);

		JComboBox type_CB = new JComboBox();
		type_CB.setBounds(432, 495, 249, 27);
		try {
			Utility ut = new Utility();

			String sql = "SELECT UNIQUE VACCINATIONTYPE FROM VRECORD";
			ut.stmt = ut.conn.prepareStatement(sql);

			ut.rs = ut.stmt.executeQuery(sql);
			while (ut.rs.next()) {
				type_CB.addItem(ut.rs.getString(1));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		add(type_CB);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Sheep");
		lblNewLabel_1_1_1_1_1.setBounds(568, 573, 37, 16);
		add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Goat");
		lblNewLabel_1_1_1_1_1_1.setBounds(294, 573, 61, 16);
		add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Cattle");
		lblNewLabel_1_1_1_1_1_2.setBounds(375, 573, 61, 16);
		add(lblNewLabel_1_1_1_1_1_2);

		JLabel lblNewLabel_1_1_1_1_1_3 = new JLabel("Dozoo or Yak");
		lblNewLabel_1_1_1_1_1_3.setBounds(448, 573, 85, 16);
		add(lblNewLabel_1_1_1_1_1_3);

		JLabel lblNewLabel_2_1_1 = new JLabel("# Livestock Vaccinated");
		lblNewLabel_2_1_1.setBounds(408, 541, 167, 16);
		add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_1_1_1_1_1_4 = new JLabel("Other");
		lblNewLabel_1_1_1_1_1_4.setBounds(640, 573, 61, 16);
		add(lblNewLabel_1_1_1_1_1_4);

		JLabel lblNewLabel_2_1_2 = new JLabel("Vaccination Record");
		lblNewLabel_2_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2_1_2.setBounds(432, 58, 167, 16);
		add(lblNewLabel_2_1_2);

		JComboBox cattleCB = new JComboBox();
		cattleCB.setBounds(353, 601, 83, 27);
		for (int i = 0; i < 100; i++) {
			cattleCB.addItem(i);
		}
		add(cattleCB);

		JComboBox yakCB = new JComboBox();
		yakCB.setBounds(448, 601, 83, 27);
		for (int i = 0; i < 100; i++) {
			yakCB.addItem(i);
		}
		add(yakCB);

		JComboBox sheepCB = new JComboBox();
		sheepCB.setBounds(543, 601, 83, 27);
		for (int i = 0; i < 100; i++) {
			sheepCB.addItem(i);
		}
		add(sheepCB);

		JComboBox otherCB = new JComboBox();
		otherCB.setBounds(628, 601, 83, 27);
		for (int i = 0; i < 100; i++) {
			otherCB.addItem(i);
		}
		add(otherCB);

		JButton submitButton = new JButton("Submit Vaccination Record");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Utility ut = new Utility();
					ut.conn.setAutoCommit(false);

					// get the BID using bname and fathername
					String bid = null;
					String sql = "SELECT BID FROM BENEFICIARY WHERE BNAME=? AND FATHERNAME=?";
					ut.pstmt = ut.conn.prepareStatement(sql);

					ut.pstmt.setString(1, bName_TF.getText());
					ut.pstmt.setString(2, fName_TF.getText());

					try {
						ut.rs = ut.pstmt.executeQuery();
						while (ut.rs.next()) {
							bid = ut.rs.getString(1);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Problem with Beneficiary Name or Father Name");
						
					}
					

					// Add a new RECORD if record doesn't already exist
					sql = "SELECT * FROM VACCINATION_RECORD WHERE VYEAR=? AND QUATER=? AND BID=?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, year_CB.getSelectedItem().toString());
					ut.pstmt.setString(2, quater_CB.getSelectedItem().toString());
					ut.pstmt.setString(3, bid);

					ut.rs = ut.pstmt.executeQuery();
					if (!ut.rs.next()) {
						sql = "INSERT INTO VACCINATION_RECORD (VYEAR,QUATER,VDATE,VACCINATER,DONOR,BID,BANIMALSLAUGHTERED,\n"
								+ "SANIMALSLAUGHTERED,\n" + "SHEEPSOLD,\n" + "CATTLESOLD,\n" + "GOATSOLD,\n"
								+ "PERANIMALCOST) VALUES (?,?,?,?,?,?,0,0,0,0,0,0)";
						ut.pstmt = ut.conn.prepareStatement(sql);
						ut.pstmt.setString(1, year_CB.getSelectedItem().toString());
						ut.pstmt.setString(2, quater_CB.getSelectedItem().toString());
						ut.pstmt.setString(3, date_TF.getText());
						ut.pstmt.setString(4, vaccinater_TF.getText());
						ut.pstmt.setString(5, donor_TF.getText());
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
					sql = "SELECT RID FROM VACCINATION_RECORD WHERE VYEAR=? AND QUATER=? AND BID=?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, year_CB.getSelectedItem().toString());
					ut.pstmt.setString(2, quater_CB.getSelectedItem().toString());
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
//					JOptionPane.showMessageDialog(null, "error");

					e1.printStackTrace();
				}

			}
		});
		submitButton.setBounds(389, 648, 204, 29);
		add(submitButton);

		// Set the preferred size of the panel to the content size
		setPreferredSize(new Dimension(882, 800));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(118, 179, 220));
		panel.setBounds(260, 44, 472, 646);
		add(panel);

	}
}
