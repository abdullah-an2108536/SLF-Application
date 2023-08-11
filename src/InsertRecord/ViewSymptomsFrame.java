package insertRecord;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import utility.Utility;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSymptomsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField symptomTF;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSymptomsFrame frame = new ViewSymptomsFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewSymptomsFrame(String diseaseName) {
		setTitle("View Disease Symptoms");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 683, 437);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(118, 180, 221));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Symptoms For : ");
		lblNewLabel.setBounds(144, 11, 108, 16);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setBounds(293, 6, 264, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		table = new JTable();
		table.setBounds(6, 39, 671, 322);
		contentPane.add(table);

		textField.setText(diseaseName);
		populateSymptomsTable(diseaseName);


		JButton addSymptomBTN = new JButton("Add Symptom");
		addSymptomBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="INSERT INTO Disease_Record_Symptoms VALUES(?,(SELECT top(1) diseaseID from DISEASE_RECORD WHERE DiseaseType=?))";
				Utility ut = new Utility();
				try {
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, symptomTF.getText());
					ut.pstmt.setString(2, diseaseName);

					ut.pstmt.executeUpdate();
					populateSymptomsTable(diseaseName);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			
			}
		});
		addSymptomBTN.setBounds(404, 373, 137, 29);
		contentPane.add(addSymptomBTN);

		symptomTF = new JTextField();
		symptomTF.setBounds(186, 373, 206, 26);
		contentPane.add(symptomTF);
		symptomTF.setColumns(10);
	}
	
	public void populateSymptomsTable(String diseaseName) {
		Utility ut = new Utility();
		String sql = "SELECT SYMPTOM AS Symptom FROM Disease_Record_Symptoms WHERE DiseaseID = (SELECT TOP(1) DiseaseID from DISEASE_RECORD WHERE DiseaseType=?);\n"
				+ " ";
		try {
			ut.pstmt = ut.conn.prepareStatement(sql);
			ut.pstmt.setString(1, diseaseName);
			ut.rs = ut.pstmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(ut.rs));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

