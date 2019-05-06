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
	public HashSet <Move> getValidMoves (Board curBoard)
	{
		HashSet <Move> validMoves = new HashSet<Move> ();
		if (this.getColor () == PieceColor.WHITE)
		{
			if (this.coord.getY () == 6) //2 линия
			{
				Move doubleMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () - 2));
				Move ordMove    = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () - 1));
				if ( !(curBoard.isOccupied (ordMove.getDest ())) )
				{
					validMoves.add (ordMove);
					if ( !(curBoard.isOccupied (doubleMove.getDest ())) )
					{
						validMoves.add (doubleMove);
					}
				}
			}
			else if (this.coord.getY () < 6 && this.coord.getY () > 1)
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () - 1));
				if ( !(curBoard.isOccupied (ordMove.getDest ())) )
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
				
				if ( !(curBoard.isOccupied (ordMove.getDest ())) )
				{
					validMoves.add (ordMove);
					if ( !(curBoard.isOccupied (doubleMove.getDest ())) )
					{
						validMoves.add (doubleMove);
					}
				}
			}
			else if (this.coord.getY () < 6 && this.coord.getY () > 1)
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () + 1));
				if ( !(curBoard.isOccupied (ordMove.getDest ())) )
				{
					validMoves.add (ordMove);
				}
			}
		}
		return validMoves;
	}
	
	@Override
	public PieceType getType ()
	{
		return PieceType.PAWN;
	}
	
	@Override
	public String toString ()
	{
		String result = "";
		if (this.getColor () == PieceColor.WHITE)
		{
			result += "W ";
		}
		else
		{
			result += "B ";
		}
		result += "P";
		return result;
	}
}
