package viewData;

import javax.swing.*;

import panels.ViewBeneficiaryDataPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewDataFrame extends JFrame {

	private JPanel currentPanel;
	private JPanel contentPanel;

	public ViewDataFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(928, 665);

		JPanel sidePanel = new JPanel();
		sidePanel.setPreferredSize(new Dimension(190, getHeight()));
		sidePanel.setBackground(new Color(118, 185, 255));

		JButton button1 = new JButton("View Beneficiary Data");
		button1.setBounds(6, 126, 178, 60);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchToPanel(new ViewBeneficiaryDataPanel());
			}
		});
		sidePanel.setLayout(null);
		sidePanel.add(button1);

		JButton button2 = new JButton("View Community Data");
		button2.setBounds(6, 198, 178, 60);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchToPanel(new JPanel());
			}
		});
		sidePanel.add(button2);

		currentPanel = new JPanel();
		currentPanel.setBackground(new Color(254, 255, 255));
		currentPanel.setLayout(null); // AbsoluteLayout

		contentPanel = new JPanel(new BorderLayout());
		contentPanel.add(currentPanel, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		add(sidePanel, BorderLayout.WEST);
		add(contentPanel, BorderLayout.CENTER);

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
