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
	public Set <Move> getValidMoves (Board curBoard)
	{
		return null;
	}
	
	@Override
	public PieceType getType ()
	{
		return PieceType.KING;
	}
}
