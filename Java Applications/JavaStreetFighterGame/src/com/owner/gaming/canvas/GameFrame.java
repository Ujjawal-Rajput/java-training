package com.owner.gaming.canvas;

import com.owner.gaming.utils.GameConstants;
import java.io.IOException;
import javax.swing.JFrame;


public class GameFrame extends JFrame implements GameConstants  {
	
	public GameFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(TITLE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(GWIDTH, GHEIGHT);
		setLocationRelativeTo(null); // frame will be in middle of the screen 
		
		Board board = new Board();
		add(board);
		setVisible(true);
	}
}