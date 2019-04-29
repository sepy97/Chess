package ChessGame.View;

import ChessGame.Model.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

class BoardView extends Canvas implements MouseListener
{
	Board modelBoard;
	public BoardView (Board mB)
	{
		this.modelBoard = mB;
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
	
	@Override
	public void mouseClicked (MouseEvent e)
	{
	
	}
	
	@Override
	public void mousePressed (MouseEvent e)
	{
	
	}
	
	@Override
	public void mouseReleased (MouseEvent e)
	{
	
	}
	
	@Override
	public void mouseEntered (MouseEvent e)
	{
	
	}
	
	@Override
	public void mouseExited (MouseEvent e)
	{
	
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
