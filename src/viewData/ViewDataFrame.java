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

        JButton button1 = new JButton("View Beneficiary Data");
        button1.setBounds(6, 126, 178, 34);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToPanel(new ViewBeneficiaryDataPanel());
            }
        });
        sidePanel.setLayout(null);
        sidePanel.add(button1);

        JButton button2 = new JButton("View Community Data");
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
        
        JButton button2_1 = new JButton(" View Record Data");
        button2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        button2_1.setBounds(6, 199, 178, 34);
        sidePanel.add(button2_1);
        
        JButton button2_1_1 = new JButton(" ");
        button2_1_1.setBounds(6, 341, 178, 60);
        sidePanel.add(button2_1_1);
        
        JButton button2_1_1_1 = new JButton(" ");
        button2_1_1_1.setBounds(6, 413, 178, 60);
        sidePanel.add(button2_1_1_1);
        
        JButton button2_1_1_1_1 = new JButton(" ");
        button2_1_1_1_1.setBounds(6, 485, 178, 60);
        sidePanel.add(button2_1_1_1_1);
        
        JButton logoBTN = new JButton("Logo Button");
        logoBTN.setBounds(6, 6, 178, 108);
        logoBTN.setIcon(new ImageIcon("SLF-Logo.png"));
        sidePanel.add(logoBTN);
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
