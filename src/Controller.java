import ChessGame.Model.Coord;
import ChessGame.Model.Game;
import ChessGame.Model.Move;
import ChessGame.View.BoardView;
import ChessGame.View.GameView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller
{
	private Game model;
	private GameView view;
	
	public Controller (Game model, GameView view)
	{
		this.model = model;
		this.view = view;
	}
	
	public void StartGame ()
	{
		model = new Game ("player1", "player2");
	}
	
	
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
							/*if ( (fromY+9*fromX) % 2 == 0) g.setColor (Color.lightGray);
							else g.setColor (Color.darkGray);
							g.drawRect (20 + fromX * 60, 50 + fromY * 60, 60, 60);
							g.fillRect (20 + fromX * 60, 50 + fromY * 60, 60, 60);*/
								curView.modelBoard.makeMove (new Move (new Coord (fromX, fromY), new Coord (toX, toY)));
								curView.repaint ();// .drawPieces (curView.modelBoard, g);
								curView.isMouseClicked = false;
								
								//if (curView.modelBoard.hasCheck (PieceColor.WHITE)) System.out.println ("White are checked!");
								//if (curView.modelBoard.hasCheck (PieceColor.BLACK)) System.out.println ("Black are checked!");
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
	}
}
