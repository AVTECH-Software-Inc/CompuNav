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
