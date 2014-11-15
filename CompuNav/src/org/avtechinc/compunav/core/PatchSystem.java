package org.avtechinc.compunav.core;

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
