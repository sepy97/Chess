package ChessGame.Controller;

import ChessGame.Model.*;
import ChessGame.View.GameView;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Controller
{
	public Game model;
	public GameView view;
	
	
	public void startGame ()
	{
		model = new Game ("player1", "player2");
		view.chessBoard.update (model.gameBoard);
		//view = new GameView (model);
		//this = new Controller (model, view);
	}
	
	
	public Controller () //Game model, GameView view)
	{
		this.model = new Game ("player1", "player2");// model;
		this.view = new GameView (this.model);// view;
		
		MListener mL = new MListener ();//view.chessBoard);
		view.chessBoard.addMouseListener (mL);
		
		ButtonListener bL = new ButtonListener ();
		this.view.newGameBut.addActionListener  (bL);
		this.view.saveGameBut.addActionListener (bL);
		this.view.loadGameBut.addActionListener (bL);
		this.view.update (this.model);
	}
	
	
	public static void main (String[] s)
	{
		Controller chessgame = new Controller ();
		
	}
	
	public class MListener extends MouseAdapter
	{
		public MListener ()
		{
		
		}
		
		public void mouseReleased (MouseEvent e)
		{
			if (downer) {
				downer = false;
				if (new Rectangle (e.getComponent().getLocationOnScreen(), e.getComponent().getSize())
						.contains(e.getLocationOnScreen())) {
					downer = false;
					// CODE
					new Thread(new Runnable(){
						public void run(){
							//Your Listener code
							
							
							
							
							if (view.chessBoard.isMouseClicked)
							{
								view.chessBoard.to = e.getPoint ();
								int fromX = (view.chessBoard.from.x - 20) / 60;
								int fromY = (view.chessBoard.from.y - 50) / 60;
								int toX = (view.chessBoard.to.x - 20) / 60;
								int toY = (view.chessBoard.to.y - 50) / 60;
								
								boolean correctMove = model.gameBoard.makeMove (new Move (new Coord (fromX, fromY), new Coord (toX, toY)));;
								//if (correctMove) return new Move (new Coord (fromX, fromY), new Coord (toX, toY))
								
								view.update (model);
								view.chessBoard.isMouseClicked = false;
							}
							else {
								view.chessBoard.from = e.getPoint ();
								int fromX = (view.chessBoard.from.x - 20) / 60;
								int fromY = (view.chessBoard.from.y - 50) / 60;
								if (model.gameBoard.isOccupied (new Coord (fromX, fromY)))
								{
									view.paintSquare (fromX, fromY);
								}
								view.chessBoard.isMouseClicked = true;
								
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
	}
	
	class ButtonListener implements ActionListener
	{
		
		@Override
		public void actionPerformed (ActionEvent e)
		{
			if (e.getSource () == view.newGameBut) {
				System.out.println ("You clicked a newGame button!");
				
				startGame ();
			}
			else if (e.getSource () == view.saveGameBut)
			{
				System.out.println("You clicked a save button!");
				
				FileDialog fileDialog = new FileDialog(view.gameWindow, "Enter filename", FileDialog.SAVE);
				fileDialog.setFilenameFilter(new FilenameFilter () {
					public boolean accept(File dir, String name) {
						return name.endsWith(".chess");
					}
				});
				fileDialog.setFile("Untitled.chess");
				fileDialog.setVisible(true);
				try {
					ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream (fileDialog.getFile ()));
					
					out.writeObject (model);
					
					out.close ();
				}
				/*catch (InvalidClassException e1)
				{
					Dialog errorDialog = new Dialog (view.gameWindow, "ERROR", true);
					errorDialog.add (new Label ("Object in file is not compatible!!!", Label.CENTER));
					errorDialog.setLocationRelativeTo (view.gameWindow);
					errorDialog.setLocation (150, 150);
					errorDialog.setSize (400, 100);
					errorDialog.addWindowListener (new WindowAdapter () {
						
						public void windowClosing (WindowEvent myEvent)
						{
							errorDialog.dispose ();
						}
					});
					errorDialog.setVisible (true);
				}*/
				catch (IOException e2) {
					e2.printStackTrace ();
				}
			}
			else if (e.getSource () == view.loadGameBut)
			{
				System.out.println("You clicked a load button!");
				
				FileDialog fd = new FileDialog(view.gameWindow, "Choose a file", FileDialog.LOAD);
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
					
					model.loadObject (in.readObject ());
					view.update (model);
					
					in.close ();
				}
				catch (InvalidClassException e1)
				{
					Dialog errorDialog = new Dialog (view.gameWindow, "ERROR", true);
					errorDialog.add (new Label ("Object in file is not compatible!!!", Label.CENTER));
					errorDialog.addWindowListener (new WindowAdapter () {
					
					public void windowClosing (WindowEvent myEvent)
					{
						errorDialog.dispose ();
					}
					});
					errorDialog.setLocationRelativeTo (view.gameWindow);
					errorDialog.setLocation (50, 50);
					errorDialog.setSize (400, 100);
					errorDialog.setVisible (true);
				}
				catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace ();
				}
			}
		}
	}
	
}


