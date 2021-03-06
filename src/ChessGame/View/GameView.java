package ChessGame.View;

import ChessGame.Controller.Controller;
import ChessGame.Model.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class GameView
{
	public Frame gameWindow;
	public BoardView chessBoard;
	
	public Button newGameBut;
	public Button loadGameBut;
	public Button saveGameBut;
	public Button connectBut;
	
	
	public GameView (Game thisGame)
	{
		gameWindow = new Frame ();
		gameWindow.setLayout (null);
		gameWindow.setSize (1000, 800);
		
		WinListener thisWin = new WinListener (gameWindow);
		gameWindow.addWindowListener (thisWin);
		
		gameWindow.setVisible (true);
		
		chessBoard = new BoardView (thisGame.gameBoard);
		chessBoard.setBounds (10, 10, 500, 600);
		gameWindow.add (chessBoard);
		chessBoard.setVisible (true);
		
		newGameBut  = new Button ();
		loadGameBut = new Button ();
		saveGameBut = new Button ();
		//connectBut  = new Button ();
		
		gameWindow.add (newGameBut);
		gameWindow.add (loadGameBut);
		gameWindow.add (saveGameBut);
		//gameWindow.add (connectBut);
		
		newGameBut.setSize  (100, 50);
		loadGameBut.setSize (100, 50);
		saveGameBut.setSize (100, 50);
		//connectBut.setSize  (100, 50);
		
		newGameBut.setLocation  (660, 60);
		loadGameBut.setLocation (660, 120);
		saveGameBut.setLocation (660, 180);
		//connectBut.setLocation  (660, 240);
		
		newGameBut.setLabel  ("New Game");
		loadGameBut.setLabel ("Load Game");
		saveGameBut.setLabel ("Save Game");
		//connectBut.setLabel  ("Connect");
		
		/*newGameBut.addActionListener (
				new ActionListener ()
		{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("You clicked a newGame button!");
						
						//Здесь должна начинаться новая игра
						
						chessBoard.update (thisGame.gameBoard);
					}
		});
		
		loadGameBut.addActionListener(
				new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("You clicked a load button!");
				
				FileDialog fd = new FileDialog(gameWindow, "Choose a file", FileDialog.LOAD);
				fd.setDirectory("/Users/sepy/Documents/JAVA/ChessGame/");
				fd.setFile("*.chess");
				fd.setVisible(true);
				String filename = fd.getFile();
				if (filename == null)
					System.out.println("You cancelled the choice");
				else
					System.out.println("You chose " + filename);
				
				try {
					ObjectInputStream in = new ObjectInputStream (new FileInputStream (filename));
					
					thisGame.loadObject (in.readObject ());
					chessBoard.update (thisGame.gameBoard);
					
					in.close ();
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace ();
				}
				
			}
		});
		
		saveGameBut.addActionListener(
				new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("You clicked a save button!");
				
				FileDialog fileDialog = new FileDialog(gameWindow, "Enter filename", FileDialog.SAVE);
				fileDialog.setFilenameFilter(new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return name.endsWith(".chess");
					}
				});
				fileDialog.setFile("Untitled.chess");
				fileDialog.setVisible(true);
				try {
					ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream (fileDialog.getFile ()));

					out.writeObject (thisGame);
					
					out.close ();
				} catch (IOException e2) {
					e2.printStackTrace ();
				}
				
			}
		});*/
		
		System.out.println (thisGame.toString ());
	}
	
	public void update (Game toUpdate)
	{
		this.chessBoard.update (toUpdate.gameBoard);
		
		if (toUpdate.gameBoard.staleMated ())
		{
			//show dialog that informs about stalemate
			Dialog stlmt = new Dialog (this.gameWindow, "Stalemate", true);
			stlmt.add (new Label ("Stalemate!", Label.CENTER));
			stlmt.addWindowListener (new WinListener (stlmt));
			stlmt.setLocationRelativeTo (gameWindow);
			stlmt.setLocation (50, 50);
			stlmt.setSize (200, 100);
			stlmt.setVisible (true);
		}
		
		if (toUpdate.gameBoard.checkMated ())
		{
			//show dialog that informs about checkmate
			Dialog chkmt = new Dialog (this.gameWindow, "Checkmate", true);
			chkmt.add (new Label ("Checkmate!", Label.CENTER));
			chkmt.addWindowListener (new WinListener (chkmt));
			chkmt.setLocationRelativeTo (gameWindow);
			chkmt.setLocation (50, 50);
			chkmt.setSize (200, 100);
			chkmt.setVisible (true);
		}
	}
	
	public boolean isOpened ()
	{
		if (gameWindow.isVisible ())
		{
			return true;
		}
		return false;
	}
	
	public void paintSquare (int fromX, int fromY)
	{
		Graphics g = chessBoard.getGraphics ();
		g.setColor (Color.green);                               ///выделить в функцию подсветки клетки VIEW
		
		g.drawRect (20 + fromX * 60, 50 + fromY * 60, 60, 60);
	}
}


class WinListener extends WindowAdapter //implements WindowListener
{
	Window curWin;
	
	public WinListener (Window that)
	{
		curWin = that;
	}
	
	public void windowClosing (WindowEvent myEvent)
	{
		curWin.dispose ();
	}
	
	
}
