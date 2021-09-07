import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

class addDiagnosisFrame extends JFrame implements ActionListener {

	Container container = getContentPane();
	String dadm;
	JLabel lMain = new JLabel("Patient's file name");
	JLabel l1 = new JLabel("Doctor Appointed");
	JLabel l2 = new JLabel("Symptoms");
	JLabel l3 = new JLabel("Diagnosis");
	JLabel l4 = new JLabel("Medicines");
	JLabel l5 = new JLabel("Addmission Required?");

	JTextField tMain = new JTextField();
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();

	JButton submit = new JButton("SUBMIT");
	JButton resetButton = new JButton("RESET");
	JButton menu = new JButton("MENU");

	addDiagnosisFrame() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {

		lMain.setBounds(50, 50, 200, 30);
		tMain.setBounds(200, 50, 200, 30);
		l1.setBounds(50, 100, 200, 30);
		t1.setBounds(200, 100, 200, 30);
		l2.setBounds(50, 150, 100, 30);
		t2.setBounds(200, 150, 200, 30);
		l3.setBounds(50, 200, 100, 30);
		t3.setBounds(200, 200, 200, 30);
		l4.setBounds(50, 250, 100, 30);
		t4.setBounds(200, 250, 200, 30);
		submit.setBounds(100, 430, 100, 30);
		resetButton.setBounds(230, 430, 100, 30);
		menu.setBounds(165, 480, 100, 30);

	}

	public void addComponentsToContainer() {
		container.add(lMain);
		container.add(l1);
		container.add(l2);
		container.add(l3);
		container.add(l4);
		container.add(l5);

		container.add(tMain);
		container.add(t1);
		container.add(t2);
		container.add(t3);
		container.add(t4);

		container.add(submit);
		container.add(resetButton);
		container.add(menu);

	}

	public void getCurrentTimeUsingDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		dadm = dtf.format(now);

	}

	public void addActionEvent() {
		submit.addActionListener(this);
		resetButton.addActionListener(this);
		menu.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {

			if (t1.getText().equals("") || tMain.getText().equals("") || t2.getText().equals("")
					|| t3.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Fill up every detail");
			} else {
				try {
					this.getCurrentTimeUsingDate();
					File f = new File(tMain.getText() + ".txt");
//					System.out.println(f.exists());
					if (f.exists()) {
						PrintWriter out = new PrintWriter(
								new BufferedWriter(new FileWriter(tMain.getText() + ".txt", true)));

						out.println("Description of the day:" + dadm);
						out.println("Doctor appointed: " + t1.getText());
						out.println("Symptoms : " + t2.getText());
						out.println("Diagnosis : " + t3.getText());
						out.println("Medicines : " + t4.getText());

						out.println();
						out.println("*************************************************************************\n");

						JOptionPane.showMessageDialog(this, "Information saved successfully !! ");
						System.out.print("\nInformation Saved Successfully\n");

						// Always close files.
						out.close();
					}else {
						JOptionPane.showMessageDialog(this, "No patient registered '" + tMain.getText() + "'");
					}
				} catch (FileNotFoundException ex) {
					JOptionPane.showMessageDialog(this, "Unable to open file '" + tMain.getText() + "'");
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(this, "Error writing or Reading to file '" + tMain.getText() + "'");
				}
			}

		}

		if (e.getSource() == resetButton) {
			tMain.setText("");
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
		}

		if (e.getSource() == menu) {
			LoggedInFrame sc = new LoggedInFrame();
			this.hide();
			sc.setTitle("Menu");
			sc.setBounds(10, 10, 370, 600);
			sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			sc.setResizable(false);
//            sc.pack();
//            sc.setLocationRelativeTo(null);
			sc.setVisible(true);
		}

	}

}

public class addDiagnosis {
	public static void main(String[] a) {
		addDiagnosisFrame frame = new addDiagnosisFrame();
		frame.setTitle("Add Diagnosis");
//        frame.pack();
//        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBounds(10, 10, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}

}