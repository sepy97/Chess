package ChessGame.Model.Pieces;

import ChessGame.Model.*;

import java.util.*;

public class King extends Piece
{
	
	public King (PieceColor color, Coord coord)
	{
		super (color, coord);
	}
	
	@Override
	public HashSet <Move> getValidMoves (Board curBoard)
	{
		HashSet <Move> validMoves = new HashSet<Move> ();
		return validMoves;
	}
	
	@Override
	public PieceType getType ()
	{
		return PieceType.KING;
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
		result += "K";
		return result;
	}
}
