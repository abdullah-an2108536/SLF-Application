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
	private JTextField yearTF;
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

		JComboBox XCB = new JComboBox();
		XCB.setBounds(67, 46, 259, 27);
		XCB.addItem("Community");
		XCB.addItem("Vaccination");
		XCB.addItem("Predation");
		XCB.addItem("Disease");
		XCB.addItem("Sales");
		XCB.addItem("none");
		add(XCB);

		JComboBox YCB = new JComboBox();
		YCB.setBounds(377, 46, 259, 27);
		YCB.addItem("Vaccination");
		YCB.addItem("Predation");
		YCB.addItem("Disease");
		YCB.addItem("Sales");
		YCB.addItem("Community");
		YCB.addItem("none");
		add(YCB);

		yearTF = new JTextField();
		yearTF.setBounds(338, 8, 158, 26);
		add(yearTF);
		yearTF.setColumns(10);

		JButton submitBTN = new JButton("Generate Summary");
		submitBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utility ut = new Utility();
				String sql;
				if ( (XCB.getSelectedItem().equals("Community") && YCB.getSelectedItem().equals("Vaccination")) || (XCB.getSelectedItem().equals("Vaccination") && YCB.getSelectedItem().equals("Community"))  ) {
					try {

						sql = "SELECT C.CNAME as 'Community',\n"
								+ "       SUM(V.VSHEEP) AS 'Sheep',\n"
								+ "       SUM(V.VGOAT) AS Goat,\n"
								+ "       SUM(V.VCATTLE) AS Cattle,\n"
								+ "       SUM(V.VDozoo_Yak) AS Dozoo_Yak\n"
								+ "FROM COMMUNITY C\n"
								+ "JOIN BENEFICIARY B ON C.CNAME = B.CNAME\n"
								+ "JOIN VACCINATION_RECORD VR ON B.BID = VR.BID\n"
								+ "JOIN VRECORD V ON VR.RID = V.RID\n"
								+ "WHERE VR.VYear = ?\n"
								+ "GROUP BY C.CNAME;";
						ut.pstmt = ut.conn.prepareStatement(sql);
						ut.pstmt.setString(1, yearTF.getText());
						ut.rs = ut.pstmt.executeQuery();

						table.setModel(DbUtils.resultSetToTableModel(ut.rs));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if ( (XCB.getSelectedItem().equals("Community") && YCB.getSelectedItem().equals("Predation")) || (XCB.getSelectedItem().equals("Predation") && YCB.getSelectedItem().equals("Community"))  ) {
					try {

						sql = "SELECT C.CNAME,\n"
								+ "       SUM(P.PSHEEP) AS TotalSheep,\n"
								+ "       SUM(P.PGOAT) AS TotalGoat,\n"
								+ "       SUM(P.PCATTLE) AS TotalCattle,\n"
								+ "       SUM(P.PDozoo_Yak) AS TotalDozoo_Yak,\n"
								+ "       SUM(P.PerPreyAnimalCost) AS TotalPreyAnimalCost\n"
								+ "FROM COMMUNITY C\n"
								+ "JOIN BENEFICIARY B ON C.CNAME = B.CNAME\n"
								+ "JOIN VACCINATION_RECORD VR ON B.BID = VR.BID\n"
								+ "JOIN Predation_Record P ON VR.RID = P.RID\n"
								+ "WHERE VR.VYear = ?\n"
								+ "GROUP BY C.CNAME;";
						ut.pstmt = ut.conn.prepareStatement(sql);
						ut.pstmt.setString(1, yearTF.getText());
						ut.rs = ut.pstmt.executeQuery();

						table.setModel(DbUtils.resultSetToTableModel(ut.rs));
						table.getColumnModel().getColumn(0).setPreferredWidth(200);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		submitBTN.setBounds(684, 26, 172, 29);
		add(submitBTN);

		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setBounds(43, 46, 27, 16);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Y");
		lblNewLabel_1.setBounds(338, 50, 27, 16);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Year");
		lblNewLabel_2.setBounds(297, 13, 36, 16);
		add(lblNewLabel_2);

	}
}
