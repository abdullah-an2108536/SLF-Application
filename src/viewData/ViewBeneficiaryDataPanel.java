package viewData;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import utility.Utility;

import java.awt.*;
import java.sql.SQLException;

public class ViewBeneficiaryDataPanel extends JPanel {
    private JTable table;
    private JTextField txtV;


    /**
     * Create the panel.
     */
    public ViewBeneficiaryDataPanel() {
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
        txtV.setText("View Beneficiary Data");
        txtV.setBounds(339, 30, 250, 26);
        add(txtV);
        txtV.setColumns(10);

        try {
            Utility ut = new Utility();
            String sql = "SELECT BID AS \"ID\", BNAME AS \"Name\", FATHERNAME AS \"Father Name\", VILLAGE AS \"Village\", CNAME AS \"Community\" FROM BENEFICIARY";
            ut.pstmt = ut.conn.prepareStatement(sql);  // Use PreparedStatement instead of Statement
            ut.rs = ut.pstmt.executeQuery();  // Just executeQuery() without passing the SQL query

            table.setModel(DbUtils.resultSetToTableModel(ut.rs));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
}
