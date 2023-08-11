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


    /**
     * Create the panel.
     */
    public WelcomePanel() {
        setBackground(SystemColor.menu);
        setLayout(null);
        setPreferredSize(new Dimension(889, 717));

        try {
            Utility ut = new Utility();
            String sql = "SELECT BID AS \"ID\", BNAME AS \"Name\", FATHERNAME AS \"Father Name\", VILLAGE AS \"Village\", CNAME AS \"Community\" FROM BENEFICIARY";
            ut.pstmt = ut.conn.prepareStatement(sql);  // Use PreparedStatement instead of Statement
            ut.rs = ut.pstmt.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
}
