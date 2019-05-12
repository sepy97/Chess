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
	private Frame gameWindow;
	private BoardView chessBoard;
	
	public Button newGameBut;
	public Button loadGameBut;
	public Button saveGameBut;
	
	
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
		
		gameWindow.add (newGameBut);
		gameWindow.add (loadGameBut);
		gameWindow.add (saveGameBut);
		
		newGameBut.setSize  (100, 50);
		loadGameBut.setSize (100, 50);
		saveGameBut.setSize (100, 50);
		
		newGameBut.setLocation  (660, 60);
		loadGameBut.setLocation (660, 120);
		saveGameBut.setLocation (660, 180);
		
		newGameBut.setLabel  ("New Game");
		loadGameBut.setLabel ("Load Game");
		saveGameBut.setLabel ("Save Game");
		
		newGameBut.addActionListener (
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
				} catch (IOException e2) {
					e2.printStackTrace ();
				} catch (ClassNotFoundException e2) {
					e2.printStackTrace ();
				}
				
				//chessBoard.repaint ();
				//здесь нужно сохранить в filename game.toString()
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

					out.writeObject (thisGame);//.toString ());
					
					out.close ();
				} catch (IOException e2) {
					e2.printStackTrace ();
				}
				
			}
		});
		
		System.out.println (thisGame.toString ());
	}
	
	public void update (Game toUpdate)
	{
		this.chessBoard.update (toUpdate.gameBoard);// = toUpdate.gameBoard;
	}
	
}


/*String outputFile = "/Users/sepy/Desktop/BOX.txt";
				try {
						ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream (filename));
      
      
      
						out.writeObject (thisGame.toString ());
						
						out.close ();
						} catch (IOException e2) {
						e2.printStackTrace ();
						}*/
				
	/*String inputFile = "/Users/sepy/Desktop/BOX.txt";
				try {
						ObjectInputStream in = new ObjectInputStream (new FileInputStream (inputFile));
						
						System.out.println (in.readObject ());
						
						
						} catch (IOException e) {
						e.printStackTrace ();
						} catch (ClassNotFoundException e) {
						e.printStackTrace ();
						}*/

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

/*
class MListener extends MouseAdapter
{
	BoardView curView;
	
	public MListener (BoardView thisView)
	{
		curView = thisView;
	}
	
	public void mouseReleased (MouseEvent e)
	{
		if (downer) {
			downer = false;
			if (new Rectangle(e.getComponent().getLocationOnScreen(), e.getComponent().getSize())
					.contains(e.getLocationOnScreen())) {
				downer = false;
				// CODE
				new Thread(new Runnable(){
					public void run(){
						//Your Listener code
						Graphics g = curView.getGraphics ();
						if (curView.isMouseClicked)
						{
							curView.to = e.getPoint ();
							int fromX = (curView.from.x - 20) / 60;
							int fromY = (curView.from.y - 50) / 60;
							int toX = (curView.to.x - 20) / 60;
							int toY = (curView.to.y - 50) / 60;
							
							curView.modelBoard.makeMove (new Move (new Coord (fromX, fromY), new Coord (toX, toY)));
							curView.repaint ();// .drawPieces (curView.modelBoard, g);
							curView.isMouseClicked = false;
							
						}
						else {
							g.setColor (Color.green);
							curView.from = e.getPoint ();
							int fromX = (curView.from.x - 20) / 60;
							int fromY = (curView.from.y - 50) / 60;
							if (curView.modelBoard.isOccupied (new Coord (fromX, fromY)))
							{
								g.drawRect (20 + fromX * 60, 50 + fromY * 60, 60, 60);
								curView.isMouseClicked = true;
								//curView.drawPieces (curView.modelBoard, g);
							}
						}
					}
				}).start();
				
				/// COde
			}
		}
	}
	
	boolean downer = false;
	
	public void mousePressed (MouseEvent e)
	{
		downer = true;
	}
}*/