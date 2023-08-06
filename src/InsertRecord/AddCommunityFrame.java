package insertRecord;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddCommunityFrame extends JFrame {

    private JPanel contentPane;
    private JTextField beneficiaryTF;
    private JTextField fatherTF;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddCommunityFrame frame = new AddCommunityFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AddCommunityFrame() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 513, 513);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(118, 179, 220));
        panel.setBounds(6, 6, 501, 473);
        contentPane.add(panel);

        JLabel lblNewLabel_2 = new JLabel("Insert Community");
        lblNewLabel_2.setFont(new Font("Songti TC", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(183, 21, 172, 35);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_1_1 = new JLabel("Country");
        lblNewLabel_1_1.setBounds(47, 130, 61, 16);
        panel.add(lblNewLabel_1_1);
        lblNewLabel_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));

        JComboBox villageCB = new JComboBox();
        villageCB.setBounds(169, 125, 203, 27);
        panel.add(villageCB);

        JLabel lblNewLabel_1_2 = new JLabel("Province");
        lblNewLabel_1_2.setBounds(47, 158, 118, 16);
        panel.add(lblNewLabel_1_2);
        lblNewLabel_1_2.setFont(new Font("Helvetica", Font.PLAIN, 13));

        JComboBox communityCB = new JComboBox();
        communityCB.setBounds(169, 151, 204, 27);
        panel.add(communityCB);

        JLabel lblNewLabel_1 = new JLabel("Alias");
        lblNewLabel_1.setBounds(47, 102, 118, 16);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Helvetica", Font.PLAIN, 13));

        JLabel lblNewLabel = new JLabel("Community Name");
        lblNewLabel.setBounds(47, 74, 130, 16);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));

        fatherTF = new JTextField();
        fatherTF.setBounds(169, 96, 279, 26);
        panel.add(fatherTF);
        fatherTF.setColumns(10);

        beneficiaryTF = new JTextField();
        beneficiaryTF.setBounds(169, 68, 279, 26);
        panel.add(beneficiaryTF);
        beneficiaryTF.setColumns(10);

        JButton submitBTN = new JButton("Submit");
        submitBTN.setBounds(219, 425, 117, 29);
        panel.add(submitBTN);

        JLabel lblNewLabel_1_2_1 = new JLabel("District");
        lblNewLabel_1_2_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
        lblNewLabel_1_2_1.setBounds(47, 183, 118, 16);
        panel.add(lblNewLabel_1_2_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(169, 177, 279, 26);
        panel.add(textField);

        JLabel lblNewLabel_1_2_1_1 = new JLabel("GPS Lat");
        lblNewLabel_1_2_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
        lblNewLabel_1_2_1_1.setBounds(47, 217, 118, 16);
        panel.add(lblNewLabel_1_2_1_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(169, 211, 279, 26);
        panel.add(textField_1);

        JLabel lblNewLabel_1_2_1_1_1 = new JLabel("GPS Long");
        lblNewLabel_1_2_1_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
        lblNewLabel_1_2_1_1_1.setBounds(47, 251, 118, 16);
        panel.add(lblNewLabel_1_2_1_1_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(169, 245, 279, 26);
        panel.add(textField_2);

        JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Area");
        lblNewLabel_1_2_1_1_2.setFont(new Font("Helvetica", Font.PLAIN, 13));
        lblNewLabel_1_2_1_1_2.setBounds(47, 285, 118, 16);
        panel.add(lblNewLabel_1_2_1_1_2);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(169, 279, 138, 26);
        panel.add(textField_4);

        JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Forest Area");
        lblNewLabel_1_2_1_1_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
        lblNewLabel_1_2_1_1_1_1.setBounds(47, 319, 118, 16);
        panel.add(lblNewLabel_1_2_1_1_1_1);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(169, 313, 138, 26);
        panel.add(textField_5);

        JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Pasture Land");
        lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
        lblNewLabel_1_2_1_1_1_1_1.setBounds(47, 353, 118, 16);
        panel.add(lblNewLabel_1_2_1_1_1_1_1);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(169, 347, 138, 26);
        panel.add(textField_6);

        JLabel lblNewLabel_1_1_1 = new JLabel("Protection Status");
        lblNewLabel_1_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
        lblNewLabel_1_1_1.setBounds(47, 386, 110, 16);
        panel.add(lblNewLabel_1_1_1);

        JComboBox villageCB_1 = new JComboBox();
        villageCB_1.setBounds(169, 381, 203, 27);
        panel.add(villageCB_1);
    }
}
