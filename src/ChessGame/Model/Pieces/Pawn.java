package ChessGame.Model.Pieces;

import ChessGame.Model.*;

import java.util.*;

public class Pawn extends Piece
{
	public Pawn (PieceColor color, Coord coord)
	{
		super (color, coord);
	}
	
	@Override
	public Set <Move> getValidMoves (Board curBoard)
	{
		Set <Move> validMoves = new HashSet<Move> ();
		if (this.getColor () == PieceColor.WHITE)
		{
			if (this.coord.getY () == 6) //2 линия
			{
				Move doubleMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () - 2));
				Move ordMove    = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () - 1));
				Square secondSquare = curBoard.getSquare (doubleMove.getDest ());
				Square firstSquare  = curBoard.getSquare (ordMove.getDest ());
				if ( !(curBoard.isOccupied (doubleMove.getDest ()) && curBoard.getPiece (doubleMove.getDest ()).getColor () == PieceColor.BLACK) &&
					 !(curBoard.isOccupied (ordMove.getDest ())    && curBoard.getPiece (ordMove.getDest ()).getColor ()    == PieceColor.BLACK)
				   )
				{
					validMoves.add (doubleMove);
				}
				
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (ordMove);
				}
				
			}
			else if (this.coord.getY () > 6 && this.coord.getY () < 1)
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () - 1));
				Square firstSquare = curBoard.getSquare (ordMove.getDest ());
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (ordMove);
				}
			}
		}
		else
		{
			if (this.coord.getY () == 1) //2 линия
			{
				Move doubleMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () + 2));
				Move ordMove    = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () + 1));
				Square secondSquare = curBoard.getSquare (doubleMove.getDest ());
				Square firstSquare  = curBoard.getSquare (ordMove.getDest ());
				if ( !(curBoard.isOccupied (doubleMove.getDest ()) && curBoard.getPiece (doubleMove.getDest ()).getColor () == PieceColor.WHITE) &&
					 !(curBoard.isOccupied (ordMove.getDest ())  && curBoard.getPiece (ordMove.getDest ()).getColor ()    == PieceColor.WHITE)
				)
				{
					validMoves.add (doubleMove);
				}
				
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (ordMove);
				}
				
			}
			else if (this.coord.getY () > 6 && this.coord.getY () < 1)
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () + 1));
				Square firstSquare = curBoard.getSquare (ordMove.getDest ());
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (ordMove);
				}
			}
		
		}
		return null;
	}
	
	@Override
	public PieceType getType ()
	{
		return PieceType.PAWN;
	}
}
