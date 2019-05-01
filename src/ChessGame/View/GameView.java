package ChessGame.View;

import ChessGame.Model.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import static ChessGame.Model.PieceColor.WHITE;

public class GameView
{
	private Frame gameWindow;
	private BoardView chessBoard;
	private Label [] pieces;
	
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
		chessBoard.setBounds (10, 10, 660, 660);
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
		
		
	}
	
	public static void main (String[] s)
	{
		Game game = new Game ("player1", "player2");
		GameView gameview = new GameView (game);
	}
}

class BoardView extends Canvas
{
	Board modelBoard;
	boolean isMouseClicked;
	Point from;
	Point to;
	
	public BoardView (Board mB)
	{
		this.modelBoard = mB;
		isMouseClicked = false;
		MListener mL = new MListener (this);
		this.addMouseListener (mL);
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
		
		drawPieces (modelBoard, g);
		
		
	}
	
	public void drawPieces (Board mB, Graphics g)
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				Piece toDraw = mB.getPiece (new Coord (i, j));
				if (toDraw != null)
				{
					if (toDraw.getColor () == WHITE)
					{
						switch (toDraw.getType ())
						{
							case PAWN:
								try {
									g.drawImage (ImageIO.read (getClass ().getResource ("/ChessGame/View/images/white_pawn.png")), 20+i*60, 50+j*60, 60, 60, null);
								} catch (IOException e) {
									e.printStackTrace ();
								}
								break;
							case KNIGHT:
								try {
									g.drawImage (ImageIO.read (getClass ().getResource ("/ChessGame/View/images/white_knight.png")), 20+i*60, 50+j*60, 60, 60, null);
								} catch (IOException e) {
									e.printStackTrace ();
								}
								break;
							case BISHOP:
								try {
									g.drawImage (ImageIO.read (getClass ().getResource ("/ChessGame/View/images/white_bishop.png")), 20+i*60, 50+j*60, 60, 60, null);
								} catch (IOException e) {
									e.printStackTrace ();
								}
								break;
							case ROOK:
								try {
									g.drawImage (ImageIO.read (getClass ().getResource ("/ChessGame/View/images/white_rook.png")), 20+i*60, 50+j*60, 60, 60, null);
								} catch (IOException e) {
									e.printStackTrace ();
								}
								break;
							case QUEEN:
								try {
									g.drawImage (ImageIO.read (getClass ().getResource ("/ChessGame/View/images/white_queen.png")), 20+i*60, 50+j*60, 60, 60, null);
								} catch (IOException e) {
									e.printStackTrace ();
								}
								break;
							case KING:
								try {
									g.drawImage (ImageIO.read (getClass ().getResource ("/ChessGame/View/images/white_king.png")), 20+i*60, 50+j*60, 60, 60, null);
								} catch (IOException e) {
									e.printStackTrace ();
								}
								break;
							default:
								break;
						}
					}
					else
					{
						switch (toDraw.getType ())
						{
							case PAWN:
								try {
									g.drawImage (ImageIO.read (getClass ().getResource ("/ChessGame/View/images/black_pawn.png")), 20+i*60, 50+j*60, 60, 60, null);
								} catch (IOException e) {
									e.printStackTrace ();
								}
								break;
							case KNIGHT:
								try {
									g.drawImage (ImageIO.read (getClass ().getResource ("/ChessGame/View/images/black_knight.png")), 20+i*60, 50+j*60, 60, 60, null);
								} catch (IOException e) {
									e.printStackTrace ();
								}
								break;
							case BISHOP:
								try {
									g.drawImage (ImageIO.read (getClass ().getResource ("/ChessGame/View/images/black_bishop.png")), 20+i*60, 50+j*60, 60, 60, null);
								} catch (IOException e) {
									e.printStackTrace ();
								}
								break;
							case ROOK:
								try {
									g.drawImage (ImageIO.read (getClass ().getResource ("/ChessGame/View/images/black_rook.png")), 20+i*60, 50+j*60, 60, 60, null);
								} catch (IOException e) {
									e.printStackTrace ();
								}
								break;
							case QUEEN:
								try {
									g.drawImage (ImageIO.read (getClass ().getResource ("/ChessGame/View/images/black_queen.png")), 20+i*60, 50+j*60, 60, 60, null);
								} catch (IOException e) {
									e.printStackTrace ();
								}
								break;
							case KING:
								try {
									g.drawImage (ImageIO.read (getClass ().getResource ("/ChessGame/View/images/black_king.png")), 20+i*60, 50+j*60, 60, 60, null);
								} catch (IOException e) {
									e.printStackTrace ();
								}
								break;
							default:
								break;
						}
					}
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


class MListener extends MouseAdapter
{
	BoardView curView;
	
	public MListener (BoardView thisView)
	{
		curView = thisView;
	}
	
	/*@Override
	public void mouseClicked (MouseEvent e)
	{
		Graphics g = curView.getGraphics ();
		super.mouseClicked (e);
		if (curView.isMouseClicked)
		{
			curView.to = e.getPoint ();
			int fromX = (curView.from.x - 20) / 60;
			int fromY = (curView.from.y - 50) / 60;
			int toX = (curView.to.x - 20) / 60;
			int toY = (curView.to.y - 50) / 60;
			if ( (fromY+9*fromX) % 2 == 0) g.setColor (Color.lightGray);
			else g.setColor (Color.darkGray);
			g.fillRect (20 + fromX * 60, 50 + fromY * 60, 60, 60);
			curView.modelBoard.makeMove (new Move (new Coord (fromX, fromY), new Coord (toX, toY)));
			curView.drawPieces (curView.modelBoard, g);
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
				curView.drawPieces (curView.modelBoard, g);
			}
		}
	}*/
	
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
							if ( (fromY+9*fromX) % 2 == 0) g.setColor (Color.lightGray);
							else g.setColor (Color.darkGray);
							g.drawRect (20 + fromX * 60, 50 + fromY * 60, 60, 60);
							g.fillRect (20 + fromX * 60, 50 + fromY * 60, 60, 60);
							curView.modelBoard.makeMove (new Move (new Coord (fromX, fromY), new Coord (toX, toY)));
							curView.drawPieces (curView.modelBoard, g);
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
								curView.drawPieces (curView.modelBoard, g);
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