import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

class addBillFrame extends JFrame implements ActionListener {

	Container container = getContentPane();
	String dadm;
	JLabel lMain = new JLabel("Patient's File Name");
	JLabel l1 = new JLabel("Days Patient Stayed");
	JLabel l2 = new JLabel("Ward Charges");
	JLabel l3 = new JLabel("Doctor's fee");
	JLabel l4 = new JLabel("Service Charges");
	JLabel l5 = new JLabel("Total Charges");

	JTextField tMain = new JTextField();
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	JTextField t5 = new JTextField();

	JButton submit = new JButton("CACULATE");
	JButton resetButton = new JButton("RESET");
	JButton menu = new JButton("MENU");


	addBillFrame() {
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
		l2.setBounds(50, 150, 200, 30);
		t2.setBounds(200, 150, 200, 30);
		l3.setBounds(50, 200, 200, 30);
		t3.setBounds(200, 200, 200, 30);
		l4.setBounds(50, 250, 200, 30);
		t4.setBounds(200, 250, 200, 30);
		l5.setBounds(50, 300, 200, 30);
		t5.setBounds(200, 300, 200, 30);
		t5.setEditable(false);

		submit.setBounds(100, 430, 150, 30);
		resetButton.setBounds(280, 430, 100, 30);
		menu.setBounds(190, 480, 100, 30);

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
		container.add(t5);

		container.add(submit);
		container.add(resetButton);
		container.add(menu);

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
					|| t3.getText().equals("") || t4.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Fill up every detail");
			} else {
				try {
					PrintWriter out = new PrintWriter(
							new BufferedWriter(new FileWriter(tMain.getText() + ".txt", true)));
					
					int days = Integer.parseInt(t1.getText());
					int wardCharges = Integer.parseInt(t2.getText());
					int docCharge = Integer.parseInt(t3.getText());
					int serviceCharge = Integer.parseInt(t4.getText());
					int total = (wardCharges*days)+docCharge+serviceCharge;
					
					t5.setText(Integer.toString(total));
					
					out.println("Total Bill: " + t5.getText());

					JOptionPane.showMessageDialog(this, "Information saved successfully !! ");
					System.out.print("\nInformation Saved Successfully\n");
					out.close();
					// Always close files.
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(this, "Error writing to file " + tMain.getText());
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

public class addBill {
	public static void main(String[] a) {
		addBillFrame frame = new addBillFrame();
		frame.setTitle("Add Patient");
//        frame.pack();
//        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBounds(10, 10, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}

}