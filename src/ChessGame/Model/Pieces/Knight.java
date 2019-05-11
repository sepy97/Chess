package ChessGame.Model.Pieces;

import ChessGame.Model.*;

import java.io.Serializable;
import java.util.*;

public class Knight extends Piece  //implements Serializable
{
	
	public Knight (PieceColor color, Coord coord)
	{
		super (color, coord);
	}
	
	@Override
	public HashSet <Move> getPossibleMoves (Board curBoard)
	{
		HashSet <Move> validMoves = new HashSet<Move> ();
		//if (this.getColor () == PieceColor.WHITE)
		
		Move knightMoves[] = new Move[8];
		knightMoves[0] = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
		knightMoves[1] = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
		knightMoves[2] = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
		knightMoves[3] = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
		knightMoves[4] = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
		knightMoves[5] = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
		knightMoves[6] = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
		knightMoves[7] = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
		
		for (int i = 0; i < 8; i++)
		{
			if (knightMoves[i].getDest ().getY () >= 0 &&
				knightMoves[i].getDest ().getY () <= 7 &&
				knightMoves[i].getDest ().getX () >= 0 &&
				knightMoves[i].getDest ().getX () <= 7)
			{
				if ( !(curBoard.isOccupied (knightMoves[i].getDest ()) && curBoard.getPiece (knightMoves[i].getDest ()).getColor () == this.getColor ()) )
				{
					validMoves.add (knightMoves[i]);
				}
			}
		}
		return validMoves;
	}
	
	/*@Override
	public HashSet <Move> getValidMoves (Board curBoard)
	{
		HashSet <Move> validMoves = getPossibleMoves (curBoard);
		for (Move i: validMoves)
		{
			Board copyBoard = new Board (curBoard);
			copyBoard.getPiece (i.getFrom ()).changeCoord (i.getDest ());
			
			if (copyBoard.hasCheck (this.getColor ())) validMoves.remove (i);
		}
		
		return validMoves;
	}*/
	
	@Override
	public PieceType getType ()
	{
		return PieceType.KNIGHT;
	}
	
	@Override
	public String toString ()
	{
		if (this.getColor () == PieceColor.WHITE)
		{
			return "n";
		}
		else
		{
			return "N";
		}
	}
}
