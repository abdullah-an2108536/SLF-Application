package viewData;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import utility.Utility;

import java.awt.*;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class WelcomePanel extends JPanel {
    private JTextField txtV;


    /**
     * Create the panel.
     */
    public WelcomePanel() {
        setBackground(SystemColor.menu);
        setLayout(null);
        setPreferredSize(new Dimension(889, 717));
        
        txtV = new JTextField();
        txtV.setEditable(false);
        txtV.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 35));
        txtV.setText("Welcome");
        txtV.setBounds(361, 36, 169, 51);
        add(txtV);
        txtV.setColumns(10);
        
        JButton facebookBTN = new JButton("FaceBook");
        facebookBTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                openLinkInBrowser("https://www.facebook.com");

        	}
        });
        facebookBTN.setBounds(54, 116, 117, 84);
        
        add(facebookBTN);
        
        JButton btnEmail = new JButton("Website");
        btnEmail.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                openLinkInBrowser("https://slf.org.pk");

        	}
        });
        btnEmail.setBounds(197, 116, 117, 84);
        add(btnEmail);
        
        JButton btnNewButton_1_1 = new JButton("Mail");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        	}
        });
        btnNewButton_1_1.setBounds(344, 116, 117, 84);
        add(btnNewButton_1_1);
        
        JButton btnNewButton_1_1_1 = new JButton("Location");
        btnNewButton_1_1_1.setBounds(494, 116, 117, 84);
        add(btnNewButton_1_1_1);
        
        JButton btnNewButton_1_1_1_1 = new JButton("Twitter");
        btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1_1_1_1.setBounds(623, 116, 117, 84);
        add(btnNewButton_1_1_1_1);

        try {
            Utility ut = new Utility();
            String sql = "SELECT BID AS \"ID\", BNAME AS \"Name\", FATHERNAME AS \"Father Name\", VILLAGE AS \"Village\", CNAME AS \"Community\" FROM BENEFICIARY";
            ut.pstmt = ut.conn.prepareStatement(sql);  // Use PreparedStatement instead of Statement
            ut.rs = ut.pstmt.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
    
    // Method to open a link in the default browser
    private void openLinkInBrowser(String link) {
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
}
