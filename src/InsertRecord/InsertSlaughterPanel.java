package insertRecord;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertSlaughterPanel extends JPanel {

//	private JTextField bName_TF;

    /**
     * Create the panel.
     *
     * @param donor_CB
     * @param vaccinater_CB
     * @param date_TF
     * @param season_CB
     * @param year_CB
     * @param fName_TF
     */
    public InsertSlaughterPanel(JTextField bName_TF, JTextField fName_TF, JComboBox year_CB, JComboBox season_CB,
                                JTextField date_TF, JComboBox vaccinater_CB, JComboBox donor_CB) {

//		this.bName_TF=bName_TF;

        setLayout(null);

        JComboBox smallAnimalCB = new JComboBox();
        smallAnimalCB.setBounds(38, 113, 176, 27);
        for (int i = 0; i < 99; i++) {
            smallAnimalCB.addItem(i);
        }
        add(smallAnimalCB);

        JLabel lblNewLabel_2_1 = new JLabel("Slaughter Record");
        lblNewLabel_2_1.setBounds(194, 6, 115, 16);
        add(lblNewLabel_2_1);

        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Small Animals Slaughtered");
        lblNewLabel_1_1_1_1_1_1.setBounds(41, 75, 176, 16);
        add(lblNewLabel_1_1_1_1_1_1);

        JLabel tf = new JLabel("Big Animals Slaughtered");
        tf.setBounds(277, 75, 160, 16);
        add(tf);

        JComboBox bigAnimalCB = new JComboBox();
        bigAnimalCB.setBounds(277, 113, 160, 27);
        for (int i = 0; i < 99; i++) {
            bigAnimalCB.addItem(i);
        }
        add(bigAnimalCB);

        JButton submitButton = new JButton("Submit Slaughter Record");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = bName_TF.getText();
                System.out.println(text);

            }
        });
        submitButton.setBounds(144, 170, 204, 29);
        /*
         * try { Utility ut = new Utility(); ut.conn.setAutoCommit(false);
         *
         * // get the BID using bname and fathername String bid = null; String sql =
         * "SELECT BID FROM BENEFICIARY WHERE BNAME=? AND FATHERNAME=?"; ut.pstmt =
         * ut.conn.prepareStatement(sql);
         *
         * ut.pstmt.setString(1, bName_TF.getText()); ut.pstmt.setString(2,
         * fName_TF.getText());
         *
         * try { ut.rs = ut.pstmt.executeQuery(); while (ut.rs.next()) { bid =
         * ut.rs.getString(1); } } catch (Exception e2) {
         * JOptionPane.showMessageDialog(null,
         * "Problem with Beneficiary Name or Father Name. Try adding a new Beneficiary if this one doesn't exist"
         * );
         *
         * }
         *
         *
         * // Add a new RECORD if record doesn't already exist sql =
         * "SELECT * FROM VACCINATION_RECORD WHERE VYEAR=? AND QUATER=? AND BID=?";
         * ut.pstmt = ut.conn.prepareStatement(sql); ut.pstmt.setString(1,
         * year_CB.getSelectedItem().toString()); ut.pstmt.setString(2,
         * quater_CB.getSelectedItem().toString()); ut.pstmt.setString(3, bid);
         *
         * ut.rs = ut.pstmt.executeQuery(); if (!ut.rs.next()) { sql =
         * "INSERT INTO VACCINATION_RECORD (VYEAR,QUATER,VDATE,VACCINATER,DONOR,BID,BANIMALSLAUGHTERED,\n"
         * + "SANIMALSLAUGHTERED,\n" + "SHEEPSOLD,\n" + "CATTLESOLD,\n" + "GOATSOLD,\n"
         * + "PERANIMALCOST) VALUES (?,?,?,?,?,?,0,0,0,0,0,0)"; ut.pstmt =
         * ut.conn.prepareStatement(sql); ut.pstmt.setString(1,
         * year_CB.getSelectedItem().toString()); ut.pstmt.setString(2,
         * quater_CB.getSelectedItem().toString()); ut.pstmt.setString(3,
         * date_TF.getText()); ut.pstmt.setString(4,
         * Vaccinater_CB.getSelectedItem().toString()); ut.pstmt.setString(5,
         * Donor_CB.getSelectedItem().toString()); ut.pstmt.setString(6, bid);
         * ut.pstmt.executeUpdate();
         *
         * int x = JOptionPane.showConfirmDialog(null,
         * "Do you wish to add a new RECORD", "Press Yes or No",
         * JOptionPane.YES_NO_OPTION);
         *
         * if (x == JOptionPane.YES_OPTION) { ut.conn.commit();
         * JOptionPane.showMessageDialog(null, "Transaction is Succesful"); } else {
         * ut.conn.rollback(); JOptionPane.showMessageDialog(null,
         * "Transaction not Saved"); } }
         *
         * // GET new RID
         *
         * String rid = null; sql =
         * "SELECT RID FROM VACCINATION_RECORD WHERE VYEAR=? AND QUATER=? AND BID=?";
         * ut.pstmt = ut.conn.prepareStatement(sql); ut.pstmt.setString(1,
         * year_CB.getSelectedItem().toString()); ut.pstmt.setString(2,
         * quater_CB.getSelectedItem().toString()); ut.pstmt.setString(3, bid); ut.rs =
         * ut.pstmt.executeQuery(); while (ut.rs.next()) { rid = ut.rs.getString(1); }
         *
         * // Add a new Vaccination_Record sql = "INSERT INTO VRECORD (VSHEEP,\n" +
         * "VGOAT,\n" + "VCATTLE,\n" + "VDOZOO_YAK,\n" + "VOTHERS,\n" +
         * "VACCINATIONTYPE,\n" + "RID) VALUES (?,?,?,?,?,?,?)"; ut.pstmt =
         * ut.conn.prepareStatement(sql); ut.pstmt.setString(1,
         * sheepCB.getSelectedItem().toString()); ut.pstmt.setString(2,
         * goatCB.getSelectedItem().toString()); ut.pstmt.setString(3,
         * cattleCB.getSelectedItem().toString()); ut.pstmt.setString(4,
         * yakCB.getSelectedItem().toString()); ut.pstmt.setString(5,
         * otherCB.getSelectedItem().toString()); ut.pstmt.setString(6,
         * type_CB.getSelectedItem().toString()); ut.pstmt.setString(7, rid);
         * ut.pstmt.executeUpdate(); int x = JOptionPane.showConfirmDialog(null,
         * "Do you wish to add a new Vaccination Record", "Press Yes or No",
         * JOptionPane.YES_NO_OPTION);
         *
         * if (x == JOptionPane.YES_OPTION) { ut.conn.commit();
         * JOptionPane.showMessageDialog(null, "Transaction is Succesful"); } else {
         * ut.conn.rollback(); JOptionPane.showMessageDialog(null,
         * "Transaction not Saved"); }
         *
         * } catch (SQLException e1) { // JOptionPane.showMessageDialog(null, "error");
         *
         * e1.printStackTrace(); }
         *
         * }
         */
        add(submitButton);

    }

}
