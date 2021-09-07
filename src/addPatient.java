import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

class addPatientFrame extends JFrame implements ActionListener {

	Container container = getContentPane();
	String dadm;
	JLabel lMain = new JLabel("File Name");
	JLabel l1 = new JLabel("Name");
	JLabel l2 = new JLabel("Address");
	JLabel l3 = new JLabel("Contact No.");
	JLabel l4 = new JLabel("Age");
	JLabel l5 = new JLabel("Sex");
	JLabel l6 = new JLabel("Blood Group");
	JTextField tMain = new JTextField();
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	JTextField t5 = new JTextField();
	JTextField t6 = new JTextField();
	JButton submit = new JButton("SUBMIT");
	JButton resetButton = new JButton("RESET");
	JButton menu = new JButton("MENU");

	addPatientFrame() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {

		lMain.setBounds(50, 50, 100, 30);
		tMain.setBounds(150, 50, 200, 30);
		l1.setBounds(50, 100, 100, 30);
		t1.setBounds(150, 100, 200, 30);
		l2.setBounds(50, 150, 100, 30);
		t2.setBounds(150, 150, 200, 30);
		l3.setBounds(50, 200, 100, 30);
		t3.setBounds(150, 200, 200, 30);
		l4.setBounds(50, 250, 100, 30);
		t4.setBounds(150, 250, 200, 30);
		l5.setBounds(50, 300, 100, 30);
		t5.setBounds(150, 300, 200, 30);
		l6.setBounds(50, 350, 100, 30);
		t6.setBounds(150, 350, 200, 30);
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
		container.add(l6);
		container.add(tMain);
		container.add(t1);
		container.add(t2);
		container.add(t3);
		container.add(t4);
		container.add(t5);
		container.add(t6);
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
					|| t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("")
					|| t6.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Fill up every detail");
			} else {
				File f = new File(tMain.getText() + ".txt");
				if (!f.exists()) {
					try {
						FileWriter fileWriter = new FileWriter(tMain.getText() + ".txt");

						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
						this.getCurrentTimeUsingDate();

						bufferedWriter
								.write("\n********************************************************************\n");
						bufferedWriter.write("Date of admission: " + dadm);
						bufferedWriter.newLine();
						bufferedWriter.write("Name : " + t1.getText());
						bufferedWriter.newLine();
						bufferedWriter.write("Address : " + t2.getText());
						bufferedWriter.newLine();
						bufferedWriter.write("Contact Number : " + t3.getText());
						bufferedWriter.newLine();
						bufferedWriter.write("Age : " + t4.getText());
						bufferedWriter.newLine();
						bufferedWriter.write("Sex : " + t5.getText());
						bufferedWriter.newLine();
						bufferedWriter.write("Blood Group : " + t6.getText());
						bufferedWriter.newLine();
						bufferedWriter
								.write("\n********************************************************************\n\n");
						bufferedWriter.newLine();
						JOptionPane.showMessageDialog(this, "Information saved successfully !! ");
						System.out.print("\nInformation Saved Successfully\n");

						// Always close files.
						bufferedWriter.close();
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(this, "Error writing to file " + tMain.getText());
					}
				}else {
					JOptionPane.showMessageDialog(this, "Patient with name " + tMain.getText() + " already exists");
				}
			}

		}

		if (e.getSource() == resetButton) {
			tMain.setText("");
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
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

public class addPatient {
	public static void main(String[] a) {
		addPatientFrame frame = new addPatientFrame();
		frame.setTitle("Add Patient");
//        frame.pack();
//        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBounds(10, 10, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}

}