import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;

class addHistoryFrame extends JFrame implements ActionListener {

	Container container = getContentPane();
//	String dadm;
	JLabel lMain = new JLabel("Patient's File Name");
	JTextArea t = new JTextArea();
	JTextField tMain = new JTextField();
	

	JButton submit = new JButton("SHOW");
	JButton resetButton = new JButton("RESET");
	JButton menu = new JButton("MENU");

	addHistoryFrame() {
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
		t.setBounds(50, 100, 400, 400);
		submit.setBounds(100, 520, 100, 30);
		resetButton.setBounds(330, 520, 100, 30);
		menu.setBounds(215, 520, 100, 30);
//		scroll.setSize(100,100);
	}

	public void addComponentsToContainer() {
		t.setLineWrap(true);
		t.setEditable(false);
		t.setVisible(true);
		container.add(lMain);
		container.add(tMain);
//		container.add(scroll);
//		container.add(t);
		JScrollPane js = new JScrollPane(t, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setBounds(50,100,400,400);
		container.add(js);

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

			if (tMain.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Fill up every detail");
			} else {
				try {

					FileReader reader = new FileReader(tMain.getText() + ".txt");
					BufferedReader br = new BufferedReader(reader);
					t.read(br, null);
					br.close();
					t.requestFocus();

					// Always close files.
//					bufferedWriter.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "No patient found named " + tMain.getText());
				}
			}

		}

		if (e.getSource() == resetButton) {
			tMain.setText("");
			t.setText("");
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

public class addHistory {
	public static void main(String[] a) {
		addHistoryFrame frame = new addHistoryFrame();
		frame.setTitle("Add Patient");
//        frame.pack();
//        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBounds(10, 10, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}

}