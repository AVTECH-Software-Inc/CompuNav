package org.avtechinc.compunav.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import org.avtechinc.compunav.action.Action;

public class PopupMenu extends JPopupMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	private Button button;

	public PopupMenu(Button b) {
		button = b;

		JMenuItem deleteButton = new JMenuItem("Delete Button");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Button.removeButton(button);
			}
		});
		add(deleteButton);

		JMenuItem renameButton = new JMenuItem("Rename Button");
		renameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setName(JOptionPane.showInputDialog("New Name:"));
			}
		});
		add(renameButton);

		JMenuItem changeAction = new JMenuItem("Change Action");
		changeAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String act = FileChooser.chooseFile();
				if (act.equals("")) return;
				Action action = new Action(act);
				button.setAction(action);
			}
		});
		add(changeAction);
	}
}
