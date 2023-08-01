package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import panels.AddRecordPanel;
import panels.SearchBeneficiaryDataPanel;
import panels.ViewBeneficiaryDataPanel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Canvas;

public class Menu extends JFrame {

	private JPanel contentPane;
	ImageIcon logoImage = new ImageIcon("SLF-Logo.png");
	private JPanel mainPanel;
	private ViewBeneficiaryDataPanel beneficiaryDataPanel;
	private SearchBeneficiaryDataPanel searchBeneficiaryDataPanel;
	private AddRecordPanel addRecordPanel;
	private JPanel currentPanel; // New variable to keep track of the currently displayed panel

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		setResizable(false);
		setForeground(new Color(40, 40, 40));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1161, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(118, 179, 221));
		buttonPanel.setPreferredSize(new Dimension(265, 704));
		buttonPanel.setLayout(null);

		contentPane.add(buttonPanel, BorderLayout.WEST);
		
		JButton ViewBeneficiaryDataButton = new JButton("View Beneficiary Data");
		ViewBeneficiaryDataButton.setBounds(6, 356, 253, 29);
		ViewBeneficiaryDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCurrentPanel();
				beneficiaryDataPanel = new ViewBeneficiaryDataPanel();
				beneficiaryDataPanel.setBackground(new Color(255, 255, 255));
				currentPanel = beneficiaryDataPanel; // Update the currentPanel reference
				contentPane.add(beneficiaryDataPanel, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		buttonPanel.add(ViewBeneficiaryDataButton);
		
		JButton SearchBeneficiaryDataButton_1 = new JButton("Search Beneficiary Data");
		SearchBeneficiaryDataButton_1.setBounds(6, 384, 253, 29);
		SearchBeneficiaryDataButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCurrentPanel();
				searchBeneficiaryDataPanel = new SearchBeneficiaryDataPanel();
				searchBeneficiaryDataPanel.setBackground(new Color(255, 255, 255));
				currentPanel = searchBeneficiaryDataPanel; // Update the currentPanel reference
				contentPane.add(searchBeneficiaryDataPanel, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		buttonPanel.add(SearchBeneficiaryDataButton_1);
		
		JButton InsertBeneficiaryDataButton = new JButton("Insert Beneficiary Data");
		InsertBeneficiaryDataButton.setBounds(6, 414, 253, 29);
		buttonPanel.add(InsertBeneficiaryDataButton);
		
		JButton AddVaccinationRecordButton = new JButton("Insert Vaccination Record");
		AddVaccinationRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCurrentPanel();
				addRecordPanel = new AddRecordPanel();
				addRecordPanel.setBackground(new Color(255, 255, 255));
				currentPanel = addRecordPanel; // Update the currentPanel reference
				contentPane.add(addRecordPanel, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
						
			}
		});
		AddVaccinationRecordButton.setBounds(6, 194, 247, 29);
		buttonPanel.add(AddVaccinationRecordButton);
		
		JButton AddDiseaseRecordButton = new JButton("Insert Disease Record");
		AddDiseaseRecordButton.setBounds(6, 221, 247, 29);
		buttonPanel.add(AddDiseaseRecordButton);
		
		JLabel lblVaccination = new JLabel("--------- LiveStock ---------");
		lblVaccination.setHorizontalAlignment(SwingConstants.CENTER);
		lblVaccination.setBounds(6, 166, 241, 16);
		buttonPanel.add(lblVaccination);
		
		JButton AddPredationRecordButton = new JButton("Insert Predation Record");
		AddPredationRecordButton.setBounds(6, 248, 247, 29);
		buttonPanel.add(AddPredationRecordButton);
		
		JButton AddVaccinationRecordButton_1_1_1 = new JButton("Insert Slaughter Record");
		AddVaccinationRecordButton_1_1_1.setBounds(6, 276, 247, 29);
		buttonPanel.add(AddVaccinationRecordButton_1_1_1);
		
		JButton AddVaccinationRecordButton_1_1_1_1 = new JButton("Insert Sold Record");
		AddVaccinationRecordButton_1_1_1_1.setBounds(6, 302, 247, 29);
		buttonPanel.add(AddVaccinationRecordButton_1_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("--------- Beneficiary ---------");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(6, 333, 253, 16);
		buttonPanel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCurrentPanel();

				currentPanel = mainPanel; // Update the currentPanel reference
				contentPane.add(mainPanel, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
				
			}
		});
		btnNewButton.setBounds(6, 6, 253, 125);
		btnNewButton.setIcon(logoImage);
		buttonPanel.add(btnNewButton);
		
		JButton ViewCommunityButton = new JButton("View Communities");
		ViewCommunityButton.setBounds(6, 466, 253, 29);
		buttonPanel.add(ViewCommunityButton);
		
		JLabel Community = new JLabel("--------- Community ---------");
		Community.setHorizontalAlignment(SwingConstants.CENTER);
		Community.setBounds(6, 442, 253, 16);
		buttonPanel.add(Community);
		
		JButton SearchBeneficiaryDataButton_1_1_1_1 = new JButton("Insert Vaccine Type");
		SearchBeneficiaryDataButton_1_1_1_1.setBounds(6, 540, 253, 29);
		buttonPanel.add(SearchBeneficiaryDataButton_1_1_1_1);
		
		JButton SearchBeneficiaryDataButton_1_1_1_1_1 = new JButton("Insert Donor");
		SearchBeneficiaryDataButton_1_1_1_1_1.setBounds(6, 566, 253, 29);
		buttonPanel.add(SearchBeneficiaryDataButton_1_1_1_1_1);
		
		JButton ViewBeneficiaryDataButton_1_1 = new JButton("Insert Disease Type");
		ViewBeneficiaryDataButton_1_1.setBounds(6, 594, 253, 29);
		buttonPanel.add(ViewBeneficiaryDataButton_1_1);
		
		JButton SearchBeneficiaryDataButton_1_2_1 = new JButton("Insert Predator Type");
		SearchBeneficiaryDataButton_1_2_1.setBounds(6, 621, 253, 29);
		buttonPanel.add(SearchBeneficiaryDataButton_1_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("--------- Other ---------");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(6, 524, 253, 16);
		buttonPanel.add(lblNewLabel_1_1_1);
		
		JButton InsertCommunityDataButton = new JButton("Insert Community Data");
		InsertCommunityDataButton.setBounds(6, 492, 253, 29);
		buttonPanel.add(InsertCommunityDataButton);
		


		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(mainPanel, BorderLayout.CENTER);
		currentPanel = mainPanel;

		// Add a WindowAdapter to handle the closing event manually
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
						"Confirm Exit", javax.swing.JOptionPane.YES_NO_OPTION);
				if (confirm == javax.swing.JOptionPane.YES_OPTION) {
					System.exit(0); // Terminate the program
				}
				
			}
		});
	}
	// Method to remove the current panel from the contentPane
	private void removeCurrentPanel() {
		if (currentPanel != null) {
			contentPane.remove(currentPanel);
		}
	}
}