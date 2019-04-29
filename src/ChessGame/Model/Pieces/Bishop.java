package ChessGame.Model.Pieces;

import ChessGame.Model.*;

import java.util.*;

public class Bishop extends Piece
{
	
	public Bishop (PieceColor color, Coord coord)
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
		return PieceType.BISHOP;
	}
}
