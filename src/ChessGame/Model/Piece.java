package ChessGame.Model;

import java.util.*;

public abstract class Piece
{
	private PieceColor color;
	protected Coord coord;

	public Piece (PieceColor color, Coord coord)
	{
		this.color = color;
		this.coord = coord;
	}
	
	public PieceColor getColor ()
	{
		return this.color;
	}
	
	public Coord getCoord ()
	{
		return this.coord;
	}
	
	public boolean changeCoord (Coord newCoord)
	{
		this.coord = newCoord;
		return true;
	}
	
	public abstract Set <Move> getValidMoves (Board curBoard);
	
	public abstract PieceType getType ();
}
