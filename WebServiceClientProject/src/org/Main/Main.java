package org.Main;

import org.Viewer.FileViewer;

public class Main {
	public static void main(String [ ] args){
		FileViewer fileViewer = new FileViewer();
		fileViewer.initialize();
		fileViewer.frame.setVisible(true);
	}
}
