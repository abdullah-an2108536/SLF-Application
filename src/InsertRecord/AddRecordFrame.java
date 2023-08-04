package InsertRecord;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class AddRecordFrame extends JFrame {

	public AddRecordFrame() {
		setResizable(false);
		setTitle("Add Record");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(497, 725);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		AddRecordPanel addRecordPanel = new AddRecordPanel();
		addRecordPanel.setBounds(-250, -42, 769, 731);
		getContentPane().add(addRecordPanel);

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new AddRecordFrame(); 
		});
	}
}
