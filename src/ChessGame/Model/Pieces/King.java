package ChessGame.Model.Pieces;

import ChessGame.Model.*;

import java.io.Serializable;
import java.util.*;

public class King extends Piece //implements Serializable
{
	
	public King (PieceColor color, Coord coord)
	{
		super (color, coord);
	}
	
	@Override
	public HashSet <Move> getPossibleMoves (Board curBoard)
	{
		HashSet <Move> validMoves = new HashSet<Move> ();
		
		Move kingMoves[] = new Move[8];
		kingMoves[0] = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () - 1));
		kingMoves[1] = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () + 1));
		kingMoves[2] = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY ()));
		kingMoves[3] = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY ()));
		kingMoves[4] = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 1));
		kingMoves[5] = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 1));
		kingMoves[6] = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 1));
		kingMoves[7] = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 1));
		
		
		for (int i = 0; i < 8; i++)
		{
			if (kingMoves[i].getDest ().getY () >= 0 &&
				kingMoves[i].getDest ().getY () <= 7 &&
				kingMoves[i].getDest ().getX () >= 0 &&
				kingMoves[i].getDest ().getX () <= 7)
			{
				if ( !(curBoard.isOccupied (kingMoves[i].getDest ()) && curBoard.getPiece (kingMoves[i].getDest ()).getColor () == this.getColor ()) )
				{
					validMoves.add (kingMoves[i]);
				}
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
		return PieceType.KING;
	}
	
	@Override
	public String toString ()
	{
		if (this.getColor () == PieceColor.WHITE)
		{
			return "k";
		}
		else
		{
			return "K";
		}
	}
	
	public boolean isChecked (Board curBoard)
	{
		if (this.getColor () == PieceColor.WHITE)
		{
			for (Move i: curBoard.getAllValidMoves (PieceColor.BLACK))
			{
				if (i.getDest ().equals (this.getCoord ())) return true;
			}
		}
		else
		{
			for (Move i: curBoard.getAllValidMoves (PieceColor.WHITE))
			{
				if (i.getDest ().equals (this.getCoord ())) return true;
			}
		}
		return false;
	}
}
