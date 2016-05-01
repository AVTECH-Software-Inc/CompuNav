/*
 *  CompuNav, the Computer Navigation Software
 *  
 *  Copyright (C) 2014 Austin VanAlstyne
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import action.Action;

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
				if (act.equals(""))
					return;
				Action action = new Action(act);
				button.setAction(action);
			}
		});
		add(changeAction);
	}
}
