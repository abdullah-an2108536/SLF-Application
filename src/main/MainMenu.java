package main;

import insertRecord.AddRecordFrame;
import viewData.ViewDataFrame;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainMenu frame = new MainMenu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 753, 410);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(118, 179, 221));
        contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) SystemColor.activeCaption));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnInsertRecord = new JButton("Insert Data");
        btnInsertRecord.setVerticalAlignment(SwingConstants.BOTTOM);
        btnInsertRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddRecordFrame.main(null);
            }
        });
        btnInsertRecord.setBackground(new Color(130, 189, 217));
        btnInsertRecord.setFont(new Font("Bangla Sangam MN", Font.PLAIN, 20));
        btnInsertRecord.setBounds(78, 267, 196, 43);
        contentPane.add(btnInsertRecord);

        JButton btnViewData = new JButton("View Data");
        btnViewData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewDataFrame.main(null);
            }
        });
        btnViewData.setVerticalAlignment(SwingConstants.BOTTOM);
        btnViewData.setBackground(new Color(130, 189, 217));
        btnViewData.setFont(new Font("Bangla Sangam MN", Font.PLAIN, 20));
        btnViewData.setBounds(306, 267, 196, 43);
        contentPane.add(btnViewData);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("SLF-Logo.png"));
        lblNewLabel.setBounds(243, 35, 281, 150);
        contentPane.add(lblNewLabel);
        
        JButton btnDeleteData = new JButton("Delete Data");
        btnDeleteData.setVerticalAlignment(SwingConstants.BOTTOM);
        btnDeleteData.setFont(new Font("Bangla Sangam MN", Font.PLAIN, 20));
        btnDeleteData.setBackground(new Color(130, 189, 217));
        btnDeleteData.setBounds(527, 267, 196, 43);
        contentPane.add(btnDeleteData);
    }
}
