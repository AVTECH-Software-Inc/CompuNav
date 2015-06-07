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

package core;

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
