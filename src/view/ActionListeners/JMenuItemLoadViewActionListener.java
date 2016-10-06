/**
 * This file is part of loweralpha, an interactive development environment for alpha-notation.

 * Copyright (C) 2016 Jan Müller (muellerj@informatik.uni-bonn.de)

 * loweralpha is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * loweralpha is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with loweralpha.  If not, see <http://www.gnu.org/licenses/>.

 * Authores: Sirko Höer, Jan Müller, Ashley Stirling
 */

package view.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileInputStream;


import javax.swing.JFileChooser;

import view.JAlphaNotationGUI;

public class JMenuItemLoadViewActionListener implements ActionListener {

	private JAlphaNotationGUI gui;
	public JMenuItemLoadViewActionListener(JAlphaNotationGUI gui) {
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(fc);
		
		try {
			File file = new File(fc.getSelectedFile().getPath());
			FileInputStream fs = new FileInputStream(file);
			
			byte[] bField = new byte[(int)file.length()];
			fs.read(bField);
			
			String source = new String(bField, "UTF-8");
			
			fs.close();			
			
			gui.SetTextSource(source);
			
		} catch (Exception e2) {
			
		}
		
	}
}
