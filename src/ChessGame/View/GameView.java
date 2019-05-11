package ChessGame.View;

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
	
	private Button newGameBut;
	private Button loadGameBut;
	private Button saveGameBut;
	
	
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
		chessBoard.setVisible (true);
		gameWindow.add (chessBoard);
		
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
					thisGame.loadObject (in.readObject ());// FromString (in.readObject ().toString ());
				} catch (IOException e2) {
					e2.printStackTrace ();
				} catch (ClassNotFoundException e2) {
					e2.printStackTrace ();
				}
				
				chessBoard.repaint ();
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
	
	public static void main (String[] s)
	{
		Game game = new Game ("player1", "player2");
		GameView gameview = new GameView (game);
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
				
class BoardView extends Canvas
{
	Board modelBoard;
	boolean isMouseClicked;
	Point from;
	Point to;
	
	private Image WHITE_PAWN;
	private Image WHITE_KNIGHT;
	private Image WHITE_BISHOP;
	private Image WHITE_ROOK;
	private Image WHITE_QUEEN;
	private Image WHITE_KING;
	private Image BLACK_PAWN;
	private Image BLACK_KNIGHT;
	private Image BLACK_BISHOP;
	private Image BLACK_ROOK;
	private Image BLACK_QUEEN;
	private Image BLACK_KING;
	
	public BoardView (Board mB)
	{
		this.modelBoard = mB;
		isMouseClicked = false;
		MListener mL = new MListener (this);
		this.addMouseListener (mL);
		
		try {
			WHITE_PAWN = ImageIO.read (getClass ().getResource ("/ChessGame/View/images/WHITE_PAWN.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
		try {
			WHITE_KNIGHT = ImageIO.read (getClass ().getResource ("/ChessGame/View/images/WHITE_KNIGHT.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
		try {
			WHITE_BISHOP = ImageIO.read (getClass ().getResource ("/ChessGame/View/images/WHITE_BISHOP.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
		try {
			WHITE_ROOK = ImageIO.read (getClass ().getResource ("/ChessGame/View/images/WHITE_ROOK.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
		try {
			WHITE_QUEEN = ImageIO.read (getClass ().getResource ("/ChessGame/View/images/WHITE_QUEEN.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
		try {
			WHITE_KING = ImageIO.read (getClass ().getResource ("/ChessGame/View/images/WHITE_KING.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
		try {
			BLACK_PAWN = ImageIO.read (getClass ().getResource ("/ChessGame/View/images/BLACK_PAWN.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
		try {
			BLACK_KNIGHT = ImageIO.read (getClass ().getResource ("/ChessGame/View/images/BLACK_KNIGHT.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
		try {
			BLACK_BISHOP = ImageIO.read (getClass ().getResource ("/ChessGame/View/images/BLACK_BISHOP.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
		try {
			BLACK_ROOK = ImageIO.read (getClass ().getResource ("/ChessGame/View/images/BLACK_ROOK.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
		try {
			BLACK_QUEEN = ImageIO.read (getClass ().getResource ("/ChessGame/View/images/BLACK_QUEEN.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
		try {
			BLACK_KING = ImageIO.read (getClass ().getResource ("/ChessGame/View/images/BLACK_KING.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
		
	}
	
	@Override
	public void paint (Graphics g)
	{
		super.paint (g);
		//цикл по modelBoard отрисовать клетки и если есть фигуры
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if ( (j+9*i) % 2 == 0) g.setColor (Color.lightGray);
				else g.setColor (Color.darkGray);
				g.fillRect (20+i*60, 50+j*60, 60, 60);
				
			}
		}
		
		drawLabels (g);
		drawPieces (modelBoard, g);
	}
	
	public void drawLabels (Graphics g)
	{
		g.setColor (Color.BLACK);
		g.drawString ("8", 10, 50  + 35);
		g.drawString ("7", 10, 110 + 35);
		g.drawString ("6", 10, 170 + 35);
		g.drawString ("5", 10, 230 + 35);
		g.drawString ("4", 10, 290 + 35);
		g.drawString ("3", 10, 350 + 35);
		g.drawString ("2", 10, 410 + 35);
		g.drawString ("1", 10, 470 + 35);
		
		g.drawString ("a", 10  + 35, 545);
		g.drawString ("b", 70  + 35, 545);
		g.drawString ("c", 130 + 35, 545);
		g.drawString ("d", 190 + 35, 545);
		g.drawString ("e", 250 + 35, 545);
		g.drawString ("f", 310 + 35, 545);
		g.drawString ("g", 370 + 35, 545);
		g.drawString ("h", 430 + 35, 545);
	}
	
	public void drawPieces (Board mB, Graphics g)
	{
		System.out.println (mB.toString ());
		
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				Piece toDraw = mB.getPiece (new Coord (i, j));
				if (toDraw != null)
				{
					Object instance = null;
					try {
						instance = getClass().getDeclaredField(toDraw.getColor ().name () + "_" + toDraw.getType ().name ()).get(this);
					} catch (IllegalAccessException e) {
						e.printStackTrace ();
					} catch (NoSuchFieldException e) {
						e.printStackTrace ();
					}
					g.drawImage ( (Image) instance, 20+i*60, 50+j*60, 60, 60, null);
				
				}
			}
		}
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