package org.avtechinc.compunav.core;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.avtechinc.compunav.action.HelpAction;
import org.avtechinc.compunav.action.NewAction;

public class Main extends JPanel {
	private static final long serialVersionUID = 1L;
	public static Main panel;
	public JFrame frame;
	private Button helpButton = new Button("Help", new HelpAction(), false);
	private Button newButton = new Button("New Button", new NewAction(), false);

	private String title = "CompuNav AVTECH Inc.";
	private static String version = "﻿0.0.1";

	public static int width = 260, height = 100;

	public Main() {
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
	}

	public void paintButtons() {
		this.removeAll();
		revalidate();
		for (int i = 0; i < Button.buttons.size(); i++) {
			add(Button.getButton(i));
		}
		add(newButton);
		add(helpButton);
		frame.pack();
		panel.repaint();
	}

	private static String loadVersion() {
		String v = "";

		try {
			FileReader fr = new FileReader("C:\\version.txt");
			BufferedReader br = new BufferedReader(fr);
			v = br.readLine();
			fr.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return v;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args0) {
		// see if there is that save file
		File file = new File(Button.saveDir);
		if (file.exists()) {
			try {
				@SuppressWarnings("resource")
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				Button.buttons = (List<Button>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			for (int i = 0; i < Button.buttons.size(); i++) {
				Button.buttons.get(i).load();
			}
		}

		PatchSystem ps = new PatchSystem();
		String newVersion = loadVersion();
		if (!newVersion.equals(version)) {
			JOptionPane.showMessageDialog(null,
					"There is a new version of CompuNav available for download.\nUpdating will NOT remove your current setup.\nTo download, please visit http://bit.ly/compunav");
		}
		File f = new File("C:\\version.txt");
		f.delete();

		panel = new Main();
		panel.frame = new JFrame();
		panel.frame.setResizable(true);
		panel.frame.setTitle(panel.title);
		panel.frame.add(panel);
		panel.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.frame.setVisible(true);

		panel.paintButtons();
		panel.frame.setLocationRelativeTo(null);
	}
}
