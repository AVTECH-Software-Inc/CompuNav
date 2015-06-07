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

package org.avtechinc.compunav.action;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Action implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fileDir;

	public Action() {
	}

	public Action(String dir) {
		fileDir = dir;
	}

	public void action() {
		try {
			Desktop.getDesktop().open(new File(fileDir));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
