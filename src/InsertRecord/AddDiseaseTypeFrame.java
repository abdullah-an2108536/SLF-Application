package insertRecord;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDiseaseTypeFrame extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddDiseaseTypeFrame frame = new AddDiseaseTypeFrame(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     *
     * @param donor_CB
     */
    public AddDiseaseTypeFrame(JComboBox type_CB) {
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAddNewDonor = new JLabel("Add New Disease");
        lblAddNewDonor.setBounds(172, 33, 117, 16);
        contentPane.add(lblAddNewDonor);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type_CB.addItem(textField.getText());
                dispose();
            }
        });
        btnSubmit.setBounds(172, 195, 117, 29);
        contentPane.add(btnSubmit);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(103, 110, 252, 26);
        contentPane.add(textField);
    }

}
