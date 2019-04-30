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
		g.drawLine (0, 0, 100, 100);
		
		drawPieces (modelBoard, g);
		
		this.addMouseListener (new MouseAdapter () {
			@Override
			public void mouseClicked (MouseEvent e)
			{
				Graphics g = getGraphics ();
				super.mouseClicked (e);
				if (isMouseClicked)
				{
					to = e.getPoint ();
					int fromX = (from.x - 20) / 60;
					int fromY = (from.y - 50) / 60;
					int toX = (to.x - 20) / 60;
					int toY = (to.y - 50) / 60;
					if ( (fromY+9*fromX) % 2 == 0) g.setColor (Color.lightGray);
					else g.setColor (Color.darkGray);
					g.fillRect (20 + fromX * 60, 50 + fromY * 60, 60, 60);
					modelBoard.makeMove (new Move (new Coord (fromX, fromY), new Coord (toX, toY)));
					drawPieces (modelBoard, g);
					isMouseClicked = false;
				}
				else {
					g.setColor (Color.green);
					from = e.getPoint ();
					int fromX = (from.x - 20) / 60;
					int fromY = (from.y - 50) / 60;
					if (modelBoard.isOccupied (new Coord (fromX, fromY)))
					{
						g.fillRect (20 + fromX * 60, 50 + fromY * 60, 60, 60);
						isMouseClicked = true;
						drawPieces (modelBoard, g);
					}
				}
			}
		});
		
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
