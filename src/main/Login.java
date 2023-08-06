package main;

import utility.Utility;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class Login extends JFrame {

    private JPanel contentPane;
    private JLabel loginInstructionLabel;


    private JTextField usernameTF;
    private JPasswordField passwordTF;


    private JLabel logoImageLabel;
    ImageIcon logoImage = new ImageIcon("SLF-Logo.png");


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
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
    public Login() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 733, 453);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.menu);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        loginInstructionLabel = new JLabel("Login to SLF Database");
        loginInstructionLabel.setFont(new Font("Heiti SC", Font.PLAIN, 25));
        loginInstructionLabel.setBounds(413, 71, 320, 38);
        contentPane.add(loginInstructionLabel);

        usernameTF = new JTextField();
        usernameTF.setColumns(10);
        usernameTF.setBounds(534, 146, 136, 26);
        contentPane.add(usernameTF);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.BLACK);
        usernameLabel.setFont(new Font("Heiti SC", Font.PLAIN, 13));
        usernameLabel.setBackground(new Color(244, 255, 236));
        usernameLabel.setBounds(427, 151, 91, 16);
        contentPane.add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setFont(new Font("Heiti SC", Font.PLAIN, 13));
        passwordLabel.setBounds(427, 220, 79, 16);
        contentPane.add(passwordLabel);

        JButton loginBTN = new JButton("LOGIN");
        loginBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                try {
//                    Utility ut = new Utility();
//                    String sql = "SELECT USERNAME,USERPASSWORD FROM LOGIN WHERE USERNAME=? AND USERPASSWORD=?";
//                    ut.pstmt = ut.conn.prepareStatement(sql);
//                    ut.pstmt.setString(1, usernameTF.getText());
//                    ut.pstmt.setString(2, passwordTF.getPassword().toString());
//                    ut.rs = ut.pstmt.executeQuery();
//                    if (ut.rs.next()) {
                        MainMenu.main(null);
                        dispose();
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Username or Password is incorrect, please try again");
//                        ut.conn.close();
//                    }
//
//                } catch (SQLException e1) {
//                    JOptionPane.showMessageDialog(null, "Username or Password is incorrect, TRY AGAIN");
//                }

            }
        });
        loginBTN.setBounds(482, 279, 117, 29);
        contentPane.add(loginBTN);

        JPanel logoPane = new JPanel();
        logoPane.setLayout(null);
        logoPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        logoPane.setBackground(new Color(118, 180, 221));
        logoPane.setBounds(0, 0, 375, 425);
        contentPane.add(logoPane);

        logoImageLabel = new JLabel("");
        logoImageLabel.setBounds(54, 123, 267, 164);
        logoPane.add(logoImageLabel);

        logoImageLabel.setIcon(logoImage);

        passwordTF = new JPasswordField();
        passwordTF.setBounds(534, 215, 136, 26);
        contentPane.add(passwordTF);
    }
}
