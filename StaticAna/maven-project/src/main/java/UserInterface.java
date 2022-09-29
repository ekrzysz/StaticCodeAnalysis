
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//creates GUI
public class UserInterface{
	
	String directoryPath = "false";
	String input;
	private JFrame frame;
	public UserInterface() {
		init();
	}
	private void init() {
		frame = new JFrame("Static Analysis");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	    body();
	    frame.setLayout(null);
	    frame.setPreferredSize(new Dimension(450, 250));
	    frame.pack();
	    frame.setVisible(true);
	}
	private void body() {
		//adding buttons, textfields, and text and setting sizes and locations
		JButton buttonStart = new JButton("Select Folder");
		buttonStart.setSize(150, 50);
		buttonStart.setLocation(280, 50);
		JButton buttonSubmit = new JButton("Clone and Run");
		buttonSubmit.setSize(150, 50);
		buttonSubmit.setLocation(280, 120);
		final JTextField inputFields = new JTextField(15);
		inputFields.setBounds(60, 50, 180, 30);
		inputFields.setLocation(90, 50);
	    final JTextField outputField = new JTextField(15);
	    outputField.setEditable(false);
	    outputField.setBounds(60, 50, 180, 30);
	    outputField.setLocation(90, 140);
	    JLabel title = new JLabel("PMD Static Analysis");
	    title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	    title.setBounds(100, 0, 300, 50);
	    title.setLocation(0, 0);
	    JLabel linkLabel = new JLabel("Github HTTPS:");
	    linkLabel.setBounds(100, 0, 300, 50);
	    linkLabel.setLocation(0, 40);
	    JLabel resultsLabel = new JLabel("Results in:");
	    
	    resultsLabel.setBounds(100, 0, 300, 50);
	    resultsLabel.setLocation(0, 120);
	    
	    //adding components to frame
	    frame.add(inputFields);
		frame.add(buttonStart);
		frame.add(buttonSubmit);
		frame.add(outputField);
		frame.add(title);
		frame.add(linkLabel);
		frame.add(resultsLabel);
		
		//action performed when click folder button
		ActionListener buttonListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OpenFolder open = new OpenFolder();
					directoryPath = open.openWindowsExplorer();
					System.out.println(directoryPath);
		}
		};
		
		//action performed when click clone + results button
		ActionListener buttonListenerSubmit = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(directoryPath);
				System.out.println(inputFields.getText());
				Clone c = new Clone();
				boolean cloned = c.cloner(inputFields.getText(), directoryPath);
				if(cloned) {
					PmdAnalysis p = new PmdAnalysis();
					String resultDirectory = p.makePmd(directoryPath);
					outputField.setText(resultDirectory);
				}
				else {
					outputField.setText("invalid link");
				}
				
				
	}
	};

		//add action to buttons
    	buttonStart.addActionListener(buttonListener);
		buttonSubmit.addActionListener(buttonListenerSubmit);
		
		
	}
}