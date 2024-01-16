package viewData;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import utility.Utility;

import java.awt.*;
import java.sql.SQLException;

public class ViewCommunityDataPanel extends JPanel {
	private JTable table;
	private JTextField txtV;

	/**
	 * Create the panel.
	 */
	public ViewCommunityDataPanel() {
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

		txtV = new JTextField();
		txtV.setEditable(false);
		txtV.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		txtV.setText("View Community Data");
		txtV.setBounds(339, 30, 250, 26);
		add(txtV);
		txtV.setColumns(10);

		try {
			Utility ut = new Utility();
			String sql = "SELECT\n"
					+ "    CName AS \"Name\",\n"
					+ "    Alias AS \"Alias\",\n"
					+ "    Province,\n"
					+ "    GPSLat AS \"Latitude\",\n"
					+ "    GPSLong AS \"Longitude\",\n"
					+ "    Area AS \"Total Area\",\n"
					+ "    PastureLand AS \"Pasture Land Area\",\n"
					+ "    Protection_Status AS \"Protection Status\"\n"
					+ "FROM COMMUNITY ORDER BY CName ASC;\n"
					+ "";
			ut.pstmt = ut.conn.prepareStatement(sql);
			ut.rs = ut.pstmt.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(ut.rs));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
