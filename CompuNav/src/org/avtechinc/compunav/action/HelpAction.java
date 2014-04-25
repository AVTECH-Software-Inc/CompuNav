package org.avtechinc.compunav.action;

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
