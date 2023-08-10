package viewData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewDataFrame extends JFrame {

    private JPanel currentPanel;
    private JPanel contentPanel;

    public ViewDataFrame() {
    	setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1082, 751);

        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(190, getHeight()));
        sidePanel.setBackground(new Color(118, 185, 255));

        JButton button1 = new JButton("Beneficiaries");
        button1.setBounds(6, 126, 178, 34);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToPanel(new ViewBeneficiaryDataPanel());
            }
        });
        sidePanel.setLayout(null);
        sidePanel.add(button1);

        JButton button2 = new JButton("Communities");
        button2.setBounds(6, 162, 178, 34);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToPanel(new ViewCommunityDataPanel());
            }
        });
        sidePanel.add(button2);

        currentPanel = new JPanel();
        currentPanel.setBackground(new Color(254, 255, 255));
        currentPanel.setLayout(null);

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(currentPanel, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(sidePanel, BorderLayout.WEST);
        
        JButton button2_1 = new JButton("Beneficiary and Records");
        button2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        button2_1.setBounds(6, 199, 178, 34);
        sidePanel.add(button2_1);
        
        JButton logoBTN = new JButton("Logo Button");
        logoBTN.setBounds(6, 6, 178, 108);
        logoBTN.setIcon(new ImageIcon("SLF-Logo.png"));
        sidePanel.add(logoBTN);
        
        JButton button2_1_1 = new JButton("Vaccination Record");
        button2_1_1.setBounds(6, 232, 178, 34);
        sidePanel.add(button2_1_1);
        
        JButton button2_1_1_1 = new JButton("Sales Record");
        button2_1_1_1.setBounds(6, 267, 178, 34);
        sidePanel.add(button2_1_1_1);
        
        JButton button2_1_1_1_1 = new JButton("Predation Record");
        button2_1_1_1_1.setBounds(6, 303, 178, 34);
        sidePanel.add(button2_1_1_1_1);
        
        JButton button2_1_1_1_1_1 = new JButton("Disease Record");
        button2_1_1_1_1_1.setBounds(6, 338, 178, 34);
        sidePanel.add(button2_1_1_1_1_1);
        
        JButton button2_1_1_1_1_1_1 = new JButton("Slaughter Record");
        button2_1_1_1_1_1_1.setBounds(6, 372, 178, 34);
        sidePanel.add(button2_1_1_1_1_1_1);
        
        JButton button1_1 = new JButton(" ");
        button1_1.setBounds(6, 405, 178, 34);
        sidePanel.add(button1_1);
        
        JButton button2_2 = new JButton(" ");
        button2_2.setBounds(6, 441, 178, 34);
        sidePanel.add(button2_2);
        
        JButton button2_1_2 = new JButton(" ");
        button2_1_2.setBounds(6, 478, 178, 34);
        sidePanel.add(button2_1_2);
        
        JButton button2_1_1_2 = new JButton(" ");
        button2_1_1_2.setBounds(6, 511, 178, 34);
        sidePanel.add(button2_1_1_2);
        
        JButton button2_1_1_1_2 = new JButton(" ");
        button2_1_1_1_2.setBounds(6, 546, 178, 34);
        sidePanel.add(button2_1_1_1_2);
        
        JButton button2_1_1_1_1_2 = new JButton(" ");
        button2_1_1_1_1_2.setBounds(6, 582, 178, 34);
        sidePanel.add(button2_1_1_1_1_2);
        
        JButton button2_1_1_1_1_1_2 = new JButton(" ");
        button2_1_1_1_1_1_2.setBounds(6, 617, 178, 34);
        sidePanel.add(button2_1_1_1_1_1_2);
        
        JButton button2_1_1_1_1_1_1_1 = new JButton(" ");
        button2_1_1_1_1_1_1_1.setBounds(6, 651, 178, 34);
        sidePanel.add(button2_1_1_1_1_1_1_1);
        
        JButton button2_1_1_1_1_1_1_1_1 = new JButton(" ");
        button2_1_1_1_1_1_1_1_1.setBounds(6, 683, 178, 34);
        sidePanel.add(button2_1_1_1_1_1_1_1_1);
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void switchToPanel(JPanel panel) {
        contentPanel.remove(currentPanel);
        currentPanel = panel;
        contentPanel.add(currentPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewDataFrame());
    }
}
