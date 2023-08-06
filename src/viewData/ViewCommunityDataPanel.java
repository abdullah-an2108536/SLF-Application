package viewData;

import javax.swing.*;
import java.awt.*;

public class ViewCommunityDataPanel extends JPanel {
    private JTable table;
    private JTextField txtV;


    /**
     * Create the panel.
     */
    public ViewCommunityDataPanel() {
        setBackground(SystemColor.menu);
        setLayout(null);
        setPreferredSize(new Dimension(739, 637));

        table = new JTable();
        table.setForeground(new Color(0, 0, 0));
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setBorder(null);

        // Wrap the table in a JScrollPane to make it scrollable
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 81, 702, 539);
        add(scrollPane);
        
        txtV = new JTextField();
        txtV.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
        txtV.setText("View Community Data");
        txtV.setBounds(247, 30, 250, 26);
        add(txtV);
        txtV.setColumns(10);

//        try {
//            Utility ut = new Utility();
//            String sql = "SELECT BID AS \"ID\", BNAME AS \"Name\", FATHERNAME AS \"Father Name\", VILLAGE AS \"Village\", CNAME AS \"Community\" FROM BENEFICIARY";
//            ut.stmt=ut.conn.prepareStatement(sql);
//            ut.rs = ut.stmt.executeQuery(sql);
//            table.setModel(DbUtils.resultSetToTableModel(ut.rs));
//            
//            JLabel lblNewLabel = new JLabel("Beneficiary Data");
//            lblNewLabel.setBackground(new Color(0, 0, 0));
//            lblNewLabel.setFont(new Font("Andale Mono", Font.PLAIN, 35));
//            lblNewLabel.setBounds(303, 20, 403, 60);
//            add(lblNewLabel);
//        } catch (SQLException e1) {
//            e1.printStackTrace();
//        }
    }
}
