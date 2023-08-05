package panels;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils;
import utility.Utility;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewBeneficiaryDataPanel extends JPanel {
    private JTable table;
    private SearchBeneficiaryDataPanel searchBeneficiaryDataPanel;


    /**
     * Create the panel.
     */
    public ViewBeneficiaryDataPanel() {
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setPreferredSize(new Dimension(709, 559));

        table = new JTable();
        table.setForeground(new Color(0, 0, 0));
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setBorder(null);

        // Wrap the table in a JScrollPane to make it scrollable
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(35, 105, 631, 424);
        add(scrollPane);

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
