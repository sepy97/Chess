package ChessGame.Model;

import java.io.Serializable;
import java.util.*;

public abstract class Piece implements Serializable
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
	
	public abstract HashSet <Move> getPossibleMoves (Board curBoard);
	public HashSet <Move> getValidMoves (Board curBoard)
	{
		HashSet <Move> result = getPossibleMoves (curBoard);
		HashSet <Move> validMoves = getPossibleMoves (curBoard);
		if (result.isEmpty ()) return validMoves;
		for (Move i: validMoves)
		{
			if (curBoard.getPiece (i.getFrom ()).getColor () != curBoard.current)
			{
				result.remove (i);
				continue;
			}
			Board copyBoard = new Board (curBoard.toString ());
			
			Piece toMove = copyBoard.getPiece (i.getFrom ());
			if (copyBoard.isOccupied (i.getDest ()) && copyBoard.getPiece (i.getDest ()).getColor () != this.getColor () )
			{
				//attacking move
				copyBoard.removePiece (copyBoard.getPiece (i.getDest ()));
			}
			toMove.changeCoord (i.getDest ());
			
			//System.out.println (curBoard.toString ());
			//System.out.println (copyBoard.toString ());
			
			if (copyBoard.hasCheck (this.getColor ())) result.remove (i);
		}
		
		return result;
	}
	
	public abstract PieceType getType ();
	
	@Override
	public abstract String toString();
}
