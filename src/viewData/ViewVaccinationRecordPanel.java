package viewData;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import utility.Utility;

import java.awt.*;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewVaccinationRecordPanel extends JPanel {
	private JTable table;
	private JTextField nameTF;
	private JTextField fatherTF;

	/**
	 * Create the panel.
	 */
	public ViewVaccinationRecordPanel() {
		setBackground(SystemColor.menu);
		setLayout(null);
		setPreferredSize(new Dimension(889, 717));

		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(null);

		// Wrap the table in a JScrollPane to make it scrollable
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 81, 863, 630);
		add(scrollPane);

		nameTF = new JTextField();
		nameTF.setBounds(92, 43, 217, 26);
		add(nameTF);
		nameTF.setColumns(10);

		fatherTF = new JTextField();
		fatherTF.setBounds(321, 43, 208, 26);
		add(fatherTF);
		fatherTF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Beneficiary Name");
		lblNewLabel.setBounds(149, 15, 108, 16);
		add(lblNewLabel);

		JLabel s = new JLabel("Father Name");
		s.setBounds(387, 15, 87, 16);
		add(s);

		JButton submitBTN = new JButton("View Records for this Beneficiary");
		submitBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Utility ut = new Utility();
					String sql = "SELECT BID FROM BENEFICIARY WHERE BNAME=? AND FatherNAME=?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, nameTF.getText());
					ut.pstmt.setString(2, fatherTF.getText());
					ut.rs = ut.pstmt.executeQuery();

					if (ut.rs.next()) {
						String BID = ut.rs.getString(1);
						System.out.println("BID: " + BID);

						sql = "    SELECT RID AS \"Record Id\",VYEAR AS \"Year\",SEASON As \"Season\",Vdate as \"Date\",Vaccinater,DONOR as \"Donor\" FROM VACCINATION_RECORD WHERE BID =?;\n"
								+ "";
						ut.pstmt = ut.conn.prepareStatement(sql);
						ut.pstmt.setString(1, BID);
						ut.rs = ut.pstmt.executeQuery();

						// Populate the JTable using DbUtils
						table.setModel(DbUtils.resultSetToTableModel(ut.rs));
					} else {
						JOptionPane.showMessageDialog(null, "No matching records found");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		submitBTN.setBounds(562, 40, 249, 29);
		add(submitBTN);

	}
}
