package panels;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import utility.Utility;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class AddRecordPanel extends JPanel {
	
	
	private JPanel contentPanel;
	private JTextField bName_TF;
	private JTextField vaccinater_TF;
	private JTextField donor_TF;
	private JTextField fName_TF;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JTextField date_TF;
	private JPanel currentPanel=new JPanel(); // New variable to keep track of the currently displayed panel


	/**
	 * Create the panel.
	 */
	public AddRecordPanel() {

		setBorder(new MatteBorder(0, 1, 1, 1, (Color) Color.WHITE));
		setBackground(new Color(254, 255, 255));
		setPreferredSize(new Dimension(882, 733));
		setLayout(null);
		setLayout(null);
		
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBounds(260, 507, 480, 240);

		contentPanel.setBorder(null);
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(currentPanel);
		add(contentPanel);
		
		


		bName_TF = new JTextField();
		bName_TF.setBounds(432, 123, 249, 26);
		add(bName_TF);
		bName_TF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Beneficiary Name");
		lblNewLabel.setBounds(294, 128, 130, 16);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Father Name");
		lblNewLabel_1.setBounds(294, 160, 118, 16);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Year");
		lblNewLabel_1_1.setBounds(294, 228, 61, 16);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Vaccinater Name");
		lblNewLabel_1_1_1.setBounds(294, 347, 129, 16);
		add(lblNewLabel_1_1_1);

		vaccinater_TF = new JTextField();
		vaccinater_TF.setColumns(10);
		vaccinater_TF.setBounds(432, 342, 249, 26);
		add(vaccinater_TF);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Donor");
		lblNewLabel_1_1_1_1.setBounds(294, 385, 61, 16);
		add(lblNewLabel_1_1_1_1);

		donor_TF = new JTextField();
		donor_TF.setColumns(10);
		donor_TF.setBounds(432, 380, 249, 26);
		add(donor_TF);

		fName_TF = new JTextField();
		fName_TF.setColumns(10);
		fName_TF.setBounds(432, 155, 249, 26);
		add(fName_TF);

		lblNewLabel_1_2 = new JLabel("Quater");
		lblNewLabel_1_2.setBounds(294, 267, 61, 16);

		add(lblNewLabel_1_2);

		lblNewLabel_1_3 = new JLabel("Date");
		lblNewLabel_1_3.setBounds(294, 308, 61, 16);
		add(lblNewLabel_1_3);

		date_TF = new JTextField();
		date_TF.setToolTipText("MM/DD/YYYY");
		date_TF.setColumns(10);
		date_TF.setBounds(432, 303, 249, 26);
		add(date_TF);

		// Populate Quater Combo Box
		JComboBox quater_CB = new JComboBox();
		quater_CB.setBounds(432, 263, 161, 27);
		for (int i = 1; i <= 4; i++) {
			quater_CB.addItem(i);
		}
		add(quater_CB);

		// Populate Year Combo Box
		JComboBox year_CB = new JComboBox();
		year_CB.setBounds(432, 224, 161, 27);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int year = currentYear; year <= currentYear + 10; year++) {
			year_CB.addItem(year);
		}

		add(year_CB);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(118, 179, 220));
		panel.setBounds(260, 44, 472, 399);
		add(panel);

		JLabel lblNewLabel_1_1_2 = new JLabel("Record Type");
		lblNewLabel_1_1_2.setBounds(341, 459, 83, 16);
		add(lblNewLabel_1_1_2);

		JComboBox record_CB = new JComboBox();
		record_CB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (record_CB.getSelectedItem() == "Vaccination") {
					removeCurrentPanel();
					InsertVaccinationPanel vpanel = new InsertVaccinationPanel();
					currentPanel=vpanel;
					contentPanel.add(vpanel);
				}
				else {
					removeCurrentPanel();
				}
			}
		});
		record_CB.setBounds(436, 455, 245, 27);

		String[] recordsArr = { "","Vaccination", "Predation", "Slaughter", "Sales" };
		for (int i = 0; i < recordsArr.length; i++) {
			record_CB.addItem(recordsArr[i]);
		}
		add(record_CB);
		

	}
	private void removeCurrentPanel() {
		if (currentPanel != null) {
			contentPanel.remove(currentPanel);
			contentPanel.revalidate();
            contentPanel.repaint();
		}
	}
}
