package org.ju.cse.gobinda.ai.faceDetection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private DrawingPanel inputPanel;
	private DrawingPanel outputPanel;
	private JPanel controlPanel;

	public MainFrame() {
		setTitle("Character Recognition");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JPanel display = new JPanel();
		display.setLayout(new GridLayout(1, 2));

		inputPanel = new DrawingPanel();
		inputPanel.setBorder(new LineBorder(Color.BLACK));
		display.add(inputPanel);

		outputPanel = new DrawingPanel();
		outputPanel.setBorder(new LineBorder(Color.BLACK));
		display.add(outputPanel);

		contentPane.add(display, BorderLayout.CENTER);

		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(1, 3));

		JButton btnSelectInput = new JButton("select one input and generate output");
		btnSelectInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Only", "png", "jpg");
				fileChooser.addChoosableFileFilter(imageFilter);
				fileChooser.setCurrentDirectory(new File("C:\\Users\\User\\Desktop"));
				fileChooser.setFileFilter(imageFilter);
				fileChooser.setAcceptAllFileFilterUsed(false);

				int result = fileChooser.showOpenDialog(new JFrame());
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					System.out.println("Selected file: " + selectedFile.getAbsolutePath());

					inputPanel.setImage(selectedFile.getAbsolutePath());
					outputPanel.setImage(FaceDetector.detectFace(selectedFile.getAbsolutePath()));

				}

			}
		});
		controlPanel.add(btnSelectInput);

		contentPane.add(controlPanel, BorderLayout.SOUTH);

	}
}