package ChessGame.Controller;

import ChessGame.Model.*;
import ChessGame.View.BoardView;
import ChessGame.View.GameView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.Socket;

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
	
	
	public Controller (Game model, GameView view)
	{
		this.model = model;
		this.view = view;
		
		MListener mL = new MListener ();//view.chessBoard);
		view.chessBoard.addMouseListener (mL);
		
		ButtonListener bL = new ButtonListener ();
		this.view.newGameBut.addActionListener  (bL);
		this.view.saveGameBut.addActionListener (bL);
		this.view.loadGameBut.addActionListener (bL);
	}
	
	
	public static void main (String[] s)
	{
		Game game = new Game ("player1", "player2");
		GameView gameview = new GameView (game);
		//GameView gamevi = new GameView (game);
		Controller chessgame = new Controller (game, gameview);
		//Controller chessga = new Controller (game, gamevi);
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
							
							
							
							
							
							Graphics g = view.chessBoard.getGraphics ();
							
							if (view.chessBoard.isMouseClicked)
							{
								view.chessBoard.to = e.getPoint ();
								int fromX = (view.chessBoard.from.x - 20) / 60;
								int fromY = (view.chessBoard.from.y - 50) / 60;
								int toX = (view.chessBoard.to.x - 20) / 60;
								int toY = (view.chessBoard.to.y - 50) / 60;
								
								boolean correctMove = model.gameBoard.makeMove (new Move (new Coord (fromX, fromY), new Coord (toX, toY)));;
								
								view.update (model);
								view.chessBoard.isMouseClicked = false;
							}
							else {
								g.setColor (Color.green);
								view.chessBoard.from = e.getPoint ();
								int fromX = (view.chessBoard.from.x - 20) / 60;
								int fromY = (view.chessBoard.from.y - 50) / 60;
								if (model.gameBoard.isOccupied (new Coord (fromX, fromY)))
								{
									g.drawRect (20 + fromX * 60, 50 + fromY * 60, 60, 60);
									view.chessBoard.isMouseClicked = true;
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
	}
	
	/*class NetworkListener extends MListener
	{
		int portNumber;
		private PieceColor playerColor;
		Socket sendrecv;
		
		public NetworkListener (BoardView thisView)
		{
			//super (thisView);
			portNumber = 9200;
			playerColor = PieceColor.WHITE;
			
			
		}
	}*/
	
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
				} catch (IOException e2) {
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
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace ();
				}
			}
		}
	}
	
}

