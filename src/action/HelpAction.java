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

package action;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class HelpAction extends Action implements Serializable {
	private static final long serialVersionUID = 1L;

	private String helpString = "";

	public HelpAction() {
	}

	public void action() {
		JOptionPane.showMessageDialog(null, helpString);
	}
}
