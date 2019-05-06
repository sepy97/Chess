package ChessGame.Model.Pieces;

import ChessGame.Model.*;

import java.util.*;

public class Queen extends Piece
{
	
	public Queen (PieceColor color, Coord coord)
	{
		super (color, coord);
	}
	
	@Override
	public HashSet <Move> getValidMoves (Board curBoard)
	{
		return null;
	}
	
	@Override
	public PieceType getType ()
	{
		return PieceType.QUEEN;
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
		result += "Q";
		return result;
	}
}
