package org.avtechinc.compunav.action;

import java.io.Serializable;

import javax.swing.JOptionPane;

import org.avtechinc.compunav.core.Button;
import org.avtechinc.compunav.core.FileChooser;
import org.avtechinc.compunav.core.Main;

public class NewAction extends Action implements Serializable {
	private static final long serialVersionUID = 1L;

	public NewAction() {
	}

	public void action() {
		setUpButton();
		Main.panel.paintButtons();
	}

	private void setUpButton() {
		String act = FileChooser.chooseFile();
		if (act.equals("")) return;
		Action action = new Action(act);
		String name = JOptionPane.showInputDialog("Name the button:");
		if (name.equals("")) return;

		new Button(name, action, true);
	}
}
