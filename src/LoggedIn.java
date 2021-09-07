import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class LoggedInFrame extends JFrame implements ActionListener {

	Container container = getContentPane();
	JButton b1 = new JButton("Add New Patient Record");
	JButton b2 = new JButton("Add Diagnosis Information");
	JButton b3 = new JButton("History of the Patient");
	JButton b4 = new JButton("Bill of the Patient");

//    JCheckBox showPassword = new JCheckBox("Show Password");

	LoggedInFrame() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {

		b1.setBounds(50, 100, 250, 30);
		b2.setBounds(50, 150, 250, 30);
		b3.setBounds(50, 200, 250, 30);
		b4.setBounds(50, 250, 250, 30);

	}

	public void addComponentsToContainer() {

		container.add(b1);
		container.add(b2);
		container.add(b3);
		container.add(b4);
	}

	public void addActionEvent() {
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			this.hide();
			addPatientFrame addP = new addPatientFrame();
			addP.setTitle("Add Patient");
			addP.setVisible(true);
			addP.setBounds(10, 10, 500, 600);
			addP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			addP.setResizable(false);

		}

		if (e.getSource() == b2) {
			this.hide();
			addDiagnosisFrame frame = new addDiagnosisFrame();
			frame.setTitle("Add Diagnosis");
			frame.setVisible(true);
			frame.setBounds(10, 10, 500, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
		}

		if (e.getSource() == b3) {
			this.hide();
			addHistoryFrame frame = new addHistoryFrame();
			frame.setTitle("Add Patient");
//	        frame.pack();
//	        frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setBounds(10, 10, 500, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
		}

		if (e.getSource() == b4) {
			this.hide();
			addBillFrame frame = new addBillFrame();
			frame.setTitle("Add Patient");
//	        frame.pack();
//	        frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setBounds(10, 10, 500, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
		}
	}

}

public class LoggedIn {
	public static void main(String[] a) {
		LoggedInFrame frame = new LoggedInFrame();
		frame.setTitle("Menu");
//        frame.pack();
//        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBounds(10, 10, 370, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}

}