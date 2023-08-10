package insertRecord;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import utility.Utility;

import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddCommunityFrame extends JFrame {

	private JPanel contentPane;
	private JTextField CNameTF;
	private JTextField aliasTF;
	private JTextField latTF;
	private JTextField longTF;
	private JTextField areaTF;
	private JTextField forestAreaTF;
	private JTextField pastureLandTF;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		lblNewLabel_2.setBounds(201, 16, 147, 35);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Country");
		lblNewLabel_1_1.setBounds(47, 130, 61, 16);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));

		JLabel lblNewLabel_1_2 = new JLabel("Province");
		lblNewLabel_1_2.setBounds(47, 158, 118, 16);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Helvetica", Font.PLAIN, 13));

		JComboBox districtCB = new JComboBox();
		districtCB.setBounds(169, 178, 279, 27);
		panel.add(districtCB);

		JComboBox provinceCB = new JComboBox();
		provinceCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedProvince = (String) provinceCB.getSelectedItem();
				districtCB.removeAllItems(); // Clear existing items

				if (selectedProvince.equals("Gilgit-Baltistan")) {
					String[] districtsGilgitBaltistan = { "Ghanche", "Skardu", "Shigar", "Kharmang", "Roundu", "Ghizer",
							"Gupis-Yasin", "Gilgit", "Hunza", "Nagar", "Astore", "Diamer", "Darel", "Tangir" };
					for (String district : districtsGilgitBaltistan) {
						districtCB.addItem(district);
					}
				} else if (selectedProvince.equals("Punjab")) {
					String[] districtsPunjab = { "Attock", "Bahawalnagar", "Bahawalpur", "Bhakkar", "Chakwal",
							"Chiniot", "Dera Ghazi Khan", "Faisalabad", "Gujranwala", "Gujrat", "Hafizabad", "Jampur",
							"Jhang", "Jhelum", "Khanewal", "Khushab", "Kot Addu", "Lahore", "Layyah", "Lodhran",
							"Mandi Bahauddin", "Mianwali", "Murree", "Multan", "Muzaffargarh", "Nankana Sahib",
							"Narowal", "Okara", "Pakpattan", "Kasur", "Rahim Yar Khan", "Rajanpur", "Rawalpindi",
							"Sahiwal", "Sargodha", "Sheikhupura", "Sialkot", "Talagang", "Taunsa", "Toba Tek Singh",
							"Vehari", "Wazirabad" };

					// Clear and populate the districtCB combo box
					districtCB.removeAllItems();
					for (String district : districtsPunjab) {
						districtCB.addItem(district);
					}
				} else if (selectedProvince.equals("Sindh")) {
					String[] districtsSindh = { "Badin", "Dadu", "Ghotki", "Hyderabad", "Jacobabad", "Jamshoro",
							"Karachi Central", "Karachi East", "Karachi South", "Karachi West", "Kashmore", "Keamari",
							"Khairpur", "Korangi", "Larkana", "Malir", "Matiari", "Mirpur Khas", "Naushahro Feroze",
							"Qambar Shahdadkot", "Sanghar", "Shaheed Benazirabad", "Shikarpur", "Sujawal", "Sukkur",
							"Tando Allahyar", "Tando Muhammad Khan", "Tharparkar", "Thatta", "Umerkot" };

					// Clear and populate the districtCB combo box
					districtCB.removeAllItems();
					for (String district : districtsSindh) {
						districtCB.addItem(district);
					}

				} else if (selectedProvince.equals("Khyber Pakhtunkhwa")) {
					String[] districtsKPK = { "Abbottabad", "Bajaur", "Bannu", "Battagram", "Buner", "Charsadda",
							"Dera Ismail Khan", "Hangu", "Haripur", "Karak", "Khyber", "Kohat", "Kolai-Palas", "Kurram",
							"Lakki Marwat", "Lower Chitral", "Lower Dir", "Lower Kohistan", "Lower South Waziristan",
							"Malakand", "Mansehra", "Mardan", "Mohmand", "North Waziristan", "Nowshera", "Orakzai",
							"Peshawar", "Shangla", "Swabi", "Swat", "Tank", "Torghar", "Upper Chitral", "Upper Dir",
							"Upper Kohistan", "Upper South Waziristan" };

					// Clear and populate the districtCB combo box
					districtCB.removeAllItems();
					for (String district : districtsKPK) {
						districtCB.addItem(district);

					}
				} else if (selectedProvince.equals("Balochistan")) {
					String[] districtsBalochistan = { "Awaran", "Barkhan", "Kachhi", "Chagai", "Chaman", "Dera Bugti",
							"Duki", "Gwadar", "Harnai", "Hub", "Jafarabad", "Jhal Magsi", "Kalat", "Kech", "Kharan",
							"Kohlu", "Khuzdar", "Lasbela", "Loralai", "Mastung", "Musakhel", "Nasirabad", "Nushki",
							"Qila Abdullah", "Qila Saifullah", "Panjgur", "Pishin", "Quetta", "Sherani", "Sibi",
							"Sohbatpur", "Surab", "Washuk", "Zhob", "Ziarat" };

					// Clear and populate the districtCB combo box
					districtCB.removeAllItems();
					for (String district : districtsBalochistan) {
						districtCB.addItem(district);
					}
				} else if (selectedProvince.equals("Azad Jammu and Kashmir")) {
					String[] districtsAJK = { "Muzaffarabad", "Hattian Bala", "Neelam Valley", "Mirpur", "Bhimber",
							"Kotli", "Poonch", "Bagh", "Haveli", "Sudhanoti" };

					// Clear and populate the districtCB combo box
					districtCB.removeAllItems();
					for (String district : districtsAJK) {
						districtCB.addItem(district);
					}
				} else if (selectedProvince.equals("Islamabad Capital Territory")) {
					districtCB.removeAllItems();
					districtCB.addItem("Islamabad");

				}
			}
		});

		String[] provincesPakistan = { "Punjab", "Sindh", "Khyber Pakhtunkhwa", "Balochistan", "Gilgit-Baltistan",
				"Azad Jammu and Kashmir", "Islamabad Capital Territory" };
		for (int i = 0; i < provincesPakistan.length; i++) {
			provinceCB.addItem(provincesPakistan[i]);
		}

		provinceCB.setBounds(169, 151, 279, 27);
		panel.add(provinceCB);

		JComboBox countryCB = new JComboBox();
		countryCB.setEnabled(false);

		countryCB.setBounds(169, 125, 279, 27);
		String[] countries = { "Pakistan" };
//		"Afghanistan", "Albania", "Algeria", "Andorra", "Angola",
//				"Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas",
//				"Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia",
//				"Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
//				"Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China",
//				"Colombia", "Comoros", "Congo, Democratic Republic of the", "Congo, Republic of the", "Costa Rica",
//				"Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica",
//				"Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia",
//				"Eswatini", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana",
//				"Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary",
//				"Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan",
//				"Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, North", "Korea, South", "Kosovo", "Kuwait",
//				"Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania",
//				"Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
//				"Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro",
//				"Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand",
//				"Nicaragua", "Niger", "Nigeria", "North Macedonia", "Norway", "Oman", "Palau", "Palestine", "Panama",
//				"Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania",
//				"Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa",
//				"San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles",
//				"Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
//				"South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan",
//				"Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia",
//				"Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom",
//				"United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen",
//				"Zambia", "Zimbabwe" };
		for (int i = 0; i < countries.length; i++) {
			countryCB.addItem(countries[i]);
		}
		panel.add(countryCB);

		JLabel lblNewLabel_1 = new JLabel("Alias");
		lblNewLabel_1.setBounds(47, 102, 118, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Helvetica", Font.PLAIN, 13));

		JLabel lblNewLabel = new JLabel("Community Name");
		lblNewLabel.setBounds(47, 74, 130, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));

		aliasTF = new JTextField();
		aliasTF.setText("alias");
		aliasTF.setHorizontalAlignment(SwingConstants.CENTER);
		aliasTF.setBounds(169, 96, 279, 26);
		panel.add(aliasTF);
		aliasTF.setColumns(10);

		CNameTF = new JTextField();
		CNameTF.setToolTipText("unique");
		CNameTF.setHorizontalAlignment(SwingConstants.CENTER);
		CNameTF.setBounds(169, 68, 279, 26);
		panel.add(CNameTF);
		CNameTF.setColumns(10);

		JComboBox protectionCB = new JComboBox();
		protectionCB.setBounds(169, 381, 279, 27);
		String[] protectionArray = { "Protected", "Not Protected" };
		for (int i = 0; i < protectionArray.length; i++) {
			protectionCB.addItem(protectionArray[i]);
		}
		panel.add(protectionCB);

		JButton submitBTN = new JButton("Submit");
		submitBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utility ut = new Utility();

				String communityName = CNameTF.getText();
				String alias = aliasTF.getText();
				String country = (String) countryCB.getSelectedItem();
				String province = (String) provinceCB.getSelectedItem();
				String district = (String) districtCB.getSelectedItem();
				String lat = latTF.getText();
				String lon = longTF.getText();
				String area = areaTF.getText();
				String forestArea = forestAreaTF.getText();
				String pastureLand = pastureLandTF.getText();
				String protectionStatus = (String) protectionCB.getSelectedItem();

				// Show a confirmation dialog
				int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to add a new community?",
						"Confirmation", JOptionPane.YES_NO_OPTION);

				if (confirmation == JOptionPane.YES_OPTION) {

					String query = "INSERT INTO COMMUNITY (CName, Alias, Country, Province, District, GPSLat, GPSLong, Area, ForestArea, PastureLand, Protection_Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try {
						PreparedStatement preparedStatement = ut.conn.prepareStatement(query);
						preparedStatement.setString(1, communityName);
						preparedStatement.setString(2, alias);
						preparedStatement.setString(3, country);
						preparedStatement.setString(4, province);
						preparedStatement.setString(5, district);
						preparedStatement.setBigDecimal(6, new BigDecimal(lat));
						preparedStatement.setBigDecimal(7, new BigDecimal(lon));
						preparedStatement.setBigDecimal(8, new BigDecimal(area));
						preparedStatement.setBigDecimal(9, new BigDecimal(forestArea));
						preparedStatement.setBigDecimal(10, new BigDecimal(pastureLand));
						preparedStatement.setString(11, protectionStatus);

						int rowsInserted = preparedStatement.executeUpdate();
						if (rowsInserted > 0) {
							JOptionPane.showMessageDialog(null, "A new community was inserted successfully.");
						}

					} catch (SQLException sqle) {
						if (sqle.getSQLState().equals("23000")) {
							JOptionPane.showMessageDialog(null,
									"Community with this name already exists.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}

					catch (Exception ex) {
						JOptionPane.showMessageDialog(null,
								"An error occurred while inserting the community: " + ex.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});
		submitBTN.setBounds(219, 425, 117, 29);
		panel.add(submitBTN);

		JLabel lblNewLabel_1_2_1 = new JLabel("District");
		lblNewLabel_1_2_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(47, 183, 118, 16);
		panel.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("GPS Lat");
		lblNewLabel_1_2_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(47, 217, 118, 16);
		panel.add(lblNewLabel_1_2_1_1);

		latTF = new JTextField();
		latTF.setHorizontalAlignment(SwingConstants.CENTER);
		latTF.setColumns(10);
		latTF.setBounds(169, 211, 279, 26);
		panel.add(latTF);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("GPS Long");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(47, 251, 118, 16);
		panel.add(lblNewLabel_1_2_1_1_1);

		longTF = new JTextField();
		longTF.setHorizontalAlignment(SwingConstants.CENTER);
		longTF.setColumns(10);
		longTF.setBounds(169, 245, 279, 26);
		panel.add(longTF);

		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Area");
		lblNewLabel_1_2_1_1_2.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_2.setBounds(47, 285, 118, 16);
		panel.add(lblNewLabel_1_2_1_1_2);

		areaTF = new JTextField();
		areaTF.setHorizontalAlignment(SwingConstants.CENTER);
		areaTF.setColumns(10);
		areaTF.setBounds(169, 279, 279, 26);
		panel.add(areaTF);

		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Forest Area");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1_1.setBounds(47, 319, 118, 16);
		panel.add(lblNewLabel_1_2_1_1_1_1);

		forestAreaTF = new JTextField();
		forestAreaTF.setHorizontalAlignment(SwingConstants.CENTER);
		forestAreaTF.setColumns(10);
		forestAreaTF.setBounds(169, 313, 279, 26);
		panel.add(forestAreaTF);

		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Pasture Land");
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1_1_1.setBounds(47, 353, 118, 16);
		panel.add(lblNewLabel_1_2_1_1_1_1_1);

		pastureLandTF = new JTextField();
		pastureLandTF.setHorizontalAlignment(SwingConstants.CENTER);
		pastureLandTF.setColumns(10);
		pastureLandTF.setBounds(169, 347, 279, 26);
		panel.add(pastureLandTF);

		JLabel lblNewLabel_1_1_1 = new JLabel("Protection Status");
		lblNewLabel_1_1_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(47, 386, 110, 16);
		panel.add(lblNewLabel_1_1_1);

	}
}
