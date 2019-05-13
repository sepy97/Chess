package ChessGame.View;

import ChessGame.Controller.Controller;
import ChessGame.Model.Board;
import ChessGame.Model.Coord;
import ChessGame.Model.Piece;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class BoardView extends Canvas
{
	public boolean isMouseClicked;
	public Board modelBoard;
	//boolean isMouseClicked;
	public Point from;
	public Point to;
	
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
		/*Controller.MListener mL = new Controller.MListener (this);
		this.addMouseListener (mL);*/
		
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

	public void update (Board mB)
	{
		this.modelBoard = mB;
		this.repaint ();
		// = new BoardView (mB);
	}
}
