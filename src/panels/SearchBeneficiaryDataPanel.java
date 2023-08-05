package panels;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import utility.Utility;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SearchBeneficiaryDataPanel extends JPanel {
	private JTextField textField;
	private JTable table;

    /**
     * Create the panel.
     */
    public SearchBeneficiaryDataPanel() {
    	setForeground(new Color(255, 255, 255));
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setPreferredSize(new Dimension(882, 701));
        
        JLabel lblNewLabel = new JLabel("Beneficiary Name");
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel.setBounds(151, 29, 189, 19);
        add(lblNewLabel);
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBounds(380, 21, 415, 41);
        add(textField);
        textField.setColumns(10);
        

        
        JButton Search = new JButton("SEARCH");
        Search.setForeground(Color.BLACK);
        Search.setBackground(new Color(118, 179, 221));
        Search.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        Search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		/*try {
                    Utility ut = new Utility();
                    String sql = "SELECT BID AS \"ID\", BNAME AS \"Name\", FATHERNAME AS \"Father Name\", VILLAGE AS \"Village\", CNAME AS \"Community\" FROM BENEFICIARY WHERE BNAME = ?";
                    ut.pstmt=ut.conn.prepareStatement(sql);
                    ut.pstmt.setString(1, textField.getText());
                    ut.rs = ut.pstmt.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(ut.rs));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }*/
        		
        	}
        });
        Search.setBounds(394, 102, 189, 41);
        add(Search);
        
        // Create a JScrollPane and add the JTable to it
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 203, 868, 235);
        add(scrollPane);

        table = new JTable();
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setBorder(null);
        table.setFont(new Font("Courier New", Font.PLAIN, 14));
        // Add the table to the JScrollPane
        scrollPane.setViewportView(table);

    }


}

