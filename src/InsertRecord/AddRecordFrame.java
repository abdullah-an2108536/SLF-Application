package InsertRecord;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import panels.AddRecordPanel;

@SuppressWarnings("serial")
public class AddRecordFrame extends JFrame {

	public AddRecordFrame() {
		setTitle("Add Record");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(615, 765);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		AddRecordPanel addRecordPanel = new AddRecordPanel();
		addRecordPanel.setBounds(0, 0, 609, 737);
		getContentPane().add(addRecordPanel);

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new AddRecordFrame(); 
		});
	}
}
