package org.Viewer;

import java.awt.EventQueue;
import java.awt.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.Controller.Controller;
import org.WebServices.WebServiceSoapProxy;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.Font;

public class FileViewer {

	public JFrame frame;

	Controller controller = new Controller();
	WebServiceSoapProxy client = new WebServiceSoapProxy();
	public String filename = null;
	DefaultListModel listModel = new DefaultListModel();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.PINK);
		panel.setBorder(new CompoundBorder());
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnCommitChanges = new JButton("Commit changes");
		btnCommitChanges.setFont(new Font("Magneto", Font.PLAIN, 17));
		btnCommitChanges.setBackground(Color.RED);
		btnCommitChanges.setBounds(10, 85, 264, 30);
		panel.add(btnCommitChanges);
		
		JButton btnShowFiles = new JButton("Show files");
		btnShowFiles.setFont(new Font("Magneto", Font.PLAIN, 14));
		btnShowFiles.setBackground(Color.RED);
		btnShowFiles.setBounds(10, 11, 119, 30);
		panel.add(btnShowFiles);
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 126, 264, 125);
		panel.add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		DefaultListModel<String> model = new DefaultListModel();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(138, 11, 136, 59);
		panel.add(scrollPane_1);
		JList list = new JList(model);
		scrollPane_1.setViewportView(list);
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				editorPane.setText(controller.getTextFile(list.getSelectedValue().toString()));
			}
		});
		
		btnShowFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String [] files = controller.getFiles();
				
				model.removeAllElements();
				
				for(String file : files){
					model.addElement(file);
				}
			}
		});
		
		btnCommitChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setFileText(editorPane.getText(), list.getSelectedValue().toString());
			}
		});
	}
}
