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

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class PatchSystem {

	public PatchSystem() {
		String url = "https://docs.google.com/document/d/16d2nJ-daXD7-dbog6XE2aADgsH8nyH8tV8sFzjqFhXw/export?format=txt&id=16d2nJ-daXD7-dbog6XE2aADgsH8nyH8tV8sFzjqFhXw&token=AC4w5Vjh_8ZoN-lvJmyQ0i4BiiU3FqgtzQ%3A1407188816429";
		String filename = "C:\\version.txt";

		downloadFile(url, filename);
	}

	public void downloadFile(String url, String filename) {
		try {
			URL download = new URL(url);
			ReadableByteChannel rbc = Channels.newChannel(download.openStream());
			FileOutputStream fileOut = new FileOutputStream(filename);
			fileOut.getChannel().transferFrom(rbc, 0, 1 << 24);
			fileOut.flush();
			fileOut.close();
			rbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
