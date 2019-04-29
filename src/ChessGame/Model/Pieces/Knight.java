package ChessGame.Model.Pieces;

import ChessGame.Model.*;

import java.util.*;

public class Knight extends Piece
{
	
	public Knight (PieceColor color, Coord coord)
	{
		super (color, coord);
	}
	
	@Override
	public Set <Move> getValidMoves (Board curBoard)
	{
		Set <Move> validMoves;
		
		return null;
	}
	
	@Override
	public PieceType getType ()
	{
		return PieceType.KNIGHT;
	}
}
