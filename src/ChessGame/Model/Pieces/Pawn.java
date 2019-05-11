package ChessGame.Model.Pieces;

import ChessGame.Model.*;

import java.io.Serializable;
import java.util.*;

public class Pawn extends Piece //implements Serializable
{
	public Pawn (PieceColor color, Coord coord)
	{
		super (color, coord);
	}
	
	@Override
	public HashSet <Move> getPossibleMoves (Board curBoard)
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
			
			Move leftAttack  = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 1));
			if ( (this.coord.getX () > 0 && this.coord.getY () > 0) && (curBoard.isOccupied (leftAttack.getDest ())) && (curBoard.getPiece (leftAttack.getDest ()).getColor () != this.getColor ()) )
			{
				validMoves.add (leftAttack);
			}
			Move rightAttack = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 1));
			if ( (this.coord.getX () < 7 && this.coord.getY () > 0) && (curBoard.isOccupied (rightAttack.getDest ())) && (curBoard.getPiece (rightAttack.getDest ()).getColor () != this.getColor ()) )
			{
				validMoves.add (rightAttack);
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
			
			Move leftAttack  = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 1));
			if ( (this.coord.getX () > 0 && this.coord.getY () < 7) && (curBoard.isOccupied (leftAttack.getDest ())) && (curBoard.getPiece (leftAttack.getDest ()).getColor () != this.getColor ()) )
			{
				validMoves.add (leftAttack);
			}
			Move rightAttack = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 1));
			if ( (this.coord.getX () < 7 && this.coord.getY () < 7) && (curBoard.isOccupied (rightAttack.getDest ())) && (curBoard.getPiece (rightAttack.getDest ()).getColor () != this.getColor ()) )
			{
				validMoves.add (rightAttack);
			}
		}
		return validMoves;
	}
	
	/*@Override
	public HashSet <Move> getValidMoves (Board curBoard)
	{
		return null;
	}*/
	
	@Override
	public PieceType getType ()
	{
		return PieceType.PAWN;
	}
	
	@Override
	public String toString ()
	{
		if (this.getColor () == PieceColor.WHITE)
		{
			return "p";
		}
		else
		{
			return "P";
		}
	}
}
