package InsertRecord;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;

public class AddBeneficiaryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField beneficiaryTF;
	private JTextField fatherTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBeneficiaryFrame frame = new AddBeneficiaryFrame();
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
	public AddBeneficiaryFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 513, 324);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(118, 179, 220));
		panel.setBounds(6, 6, 501, 284);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Insert Beneficiary");
		lblNewLabel_2.setFont(new Font("Songti TC", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(191, 21, 150, 35);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Village");
		lblNewLabel_1_1.setBounds(47, 153, 61, 16);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		JComboBox villageCB = new JComboBox();
		villageCB.setBounds(169, 148, 203, 27);
		panel.add(villageCB);
		
		JLabel lblNewLabel_1_2 = new JLabel("Community Name");
		lblNewLabel_1_2.setBounds(47, 192, 118, 16);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		JComboBox communityCB = new JComboBox();
		communityCB.setBounds(169, 187, 204, 27);
		panel.add(communityCB);
		
		JButton newCommunityBTN = new JButton("New Community");
		newCommunityBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCommunityFrame.main(null);
			}
		});
		newCommunityBTN.setBounds(367, 186, 128, 29);
		panel.add(newCommunityBTN);
		
		JLabel lblNewLabel_1 = new JLabel("Father Name");
		lblNewLabel_1.setBounds(47, 125, 118, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("Beneficiary Name");
		lblNewLabel.setBounds(47, 97, 130, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		fatherTF = new JTextField();
		fatherTF.setBounds(169, 119, 279, 26);
		panel.add(fatherTF);
		fatherTF.setColumns(10);
		
		beneficiaryTF = new JTextField();
		beneficiaryTF.setBounds(169, 91, 279, 26);
		panel.add(beneficiaryTF);
		beneficiaryTF.setColumns(10);
		
		JButton submitBTN = new JButton("Submit");
		submitBTN.setBounds(211, 235, 117, 29);
		panel.add(submitBTN);
		
		JButton newVillageBTN = new JButton("new");
		newVillageBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVillageFrame addVillageFrame=new AddVillageFrame(villageCB);
				addVillageFrame.setVisible(true);
				
			}
		});
		newVillageBTN.setBounds(367, 147, 78, 29);
		panel.add(newVillageBTN);
	}
}
