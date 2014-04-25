package org.avtechinc.compunav.core;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FileChooser {
	public static String chooseFile() {
		LookAndFeel previousLF = UIManager.getLookAndFeel();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		JFileChooser jfc = new JFileChooser();

		try {
			UIManager.setLookAndFeel(previousLF);
		} catch (UnsupportedLookAndFeelException e) {
		}

		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		if (jfc.showDialog(null, "Select") == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			return file.getPath();
		} else {
			return "";
		}
	}
}
