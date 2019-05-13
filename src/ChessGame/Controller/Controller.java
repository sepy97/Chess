package ChessGame.Controller;

import ChessGame.Model.Coord;
import ChessGame.Model.Game;
import ChessGame.Model.Move;
import ChessGame.View.BoardView;
import ChessGame.View.GameView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		MListener mL = new MListener (view.chessBoard);
		view.chessBoard.addMouseListener (mL);
		
		this.view.newGameBut.addActionListener (new ButtonListener());
	}
	
	
	public static void main (String[] s)
	{
		Game game = new Game ("player1", "player2");
		GameView gameview = new GameView (game);
		Controller chessgame = new Controller (game, gameview);
	}
	
	public static class MListener extends MouseAdapter
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
				if (new Rectangle (e.getComponent().getLocationOnScreen(), e.getComponent().getSize())
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
								
								boolean correctMove = curView.modelBoard.makeMove (new Move (new Coord (fromX, fromY), new Coord (toX, toY)));
								curView.repaint ();
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
	
	class ButtonListener implements ActionListener
	{
		
		@Override
		public void actionPerformed (ActionEvent e)
		{
			if (e.getSource () == view.newGameBut) {
				System.out.println ("You clicked a newGame button!");
				
				startGame ();
				//Здесь должна начинаться новая игра
				
				//view.chessBoard.update (model.gameBoard);// thisGame.gameBoard);
				
			}
		}
	}
	
}

