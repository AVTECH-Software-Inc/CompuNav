/*
* CompuNav
* Created by Austin VanAlstyne
* Open Source with Related GitHub Repo
*
* Copyright© 2015 Austin VanAlstyne
*/

/*
*This file is part of CompuNav.
*
*CompuNav is free software: you can redistribute it and/or modify
*it under the terms of the GNU General Public License as published by
*the Free Software Foundation, either version 3 of the License, or
*(at your option) any later version.
*
*CompuNav is distributed in the hope that it will be useful,
*but WITHOUT ANY WARRANTY; without even the implied warranty of
*MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*GNU General Public License for more details.
*
*You should have received a copy of the GNU General Public License
*along with CompuNav.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.avtechinc.compunav.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import org.avtechinc.compunav.action.Action;

public class Button extends JButton implements Serializable {
	private static final long serialVersionUID = 1L;

	public static List<Button> buttons = new ArrayList<Button>();

	private String name;
	private Action action;
	private PopupMenu popupMenu;
	private boolean menu;

	public static final String saveDir = "C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\compunav_config.cpconfig";

	public Button(String name, Action action, boolean menu) {
		this.name = name;
		this.action = action;
		this.menu = menu;

		this.setText(name);
		startActionListener();

		if (menu) addButton(this);

		setUpMenu();

		save();
	}

	public static void save() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(saveDir)));
			oos.writeObject(buttons);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		setUpMenu();
		setAction(action);
	}

	private void setUpMenu() {
		if (!menu) return;
		popupMenu = new PopupMenu(this);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				checkForTriggerEvent(e);
			}

			public void mouseReleased(MouseEvent e) {
				checkForTriggerEvent(e);
			}

			private void checkForTriggerEvent(MouseEvent e) {
				if (e.isPopupTrigger()) popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void setAction(Action action) {
		this.action = action;
		startActionListener();
		save();
	}

	private void startActionListener() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action.action();
			}
		});
	}

	public void setName(String name) {
		this.name = name;
		setText(name);
		save();
	}

	public String getName() {
		return name;
	}

	public Action getActionAssignment() {
		return action;
	}

	public PopupMenu getPopupMenu() {
		return popupMenu;
	}

	public static void addButton(Button button) {
		buttons.add(button);
	}

	public static void removeButton(Button button) {
		buttons.remove(button);
		Main.panel.paintButtons();
		save();
	}

	public static Button getButton(int index) {
		return buttons.get(index);
	}
}
