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
		HashSet <Move> validMoves = new HashSet<Move> ();
		for (int i = 1; i < 8; i++) {
			Move downMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () + i));
			if ( (curBoard.isOccupied (downMove.getDest ()) && curBoard.getPiece (downMove.getDest ()).getColor () == this.getColor ())
					|| (downMove.getDest ().getX () > 7 || downMove.getDest ().getY () > 7 || downMove.getDest ().getX () < 0 || downMove.getDest ().getY () < 0) )
			{
				break;
			}
			else if (curBoard.isOccupied (downMove.getDest ()) && curBoard.getPiece (downMove.getDest ()).getColor () != this.getColor ())
			{
				validMoves.add (downMove);
				break;
			}
			validMoves.add (downMove);
		}
		for (int i = 1; i < 8; i++) {
			Move upMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () - i));
			if ( (curBoard.isOccupied (upMove.getDest ()) && curBoard.getPiece (upMove.getDest ()).getColor () == this.getColor ())
					|| (upMove.getDest ().getX () > 7 || upMove.getDest ().getY () > 7 || upMove.getDest ().getX () < 0 || upMove.getDest ().getY () < 0) )
			{
				break;
			}
			else if (curBoard.isOccupied (upMove.getDest ()) && curBoard.getPiece (upMove.getDest ()).getColor () != this.getColor ())
			{
				validMoves.add (upMove);
				break;
			}
			validMoves.add (upMove);
		}
		for (int i = 1; i < 8; i++) {
			Move leftMove = new Move (this.coord, new Coord (this.coord.getX () - i, this.coord.getY ()));
			if ( (curBoard.isOccupied (leftMove.getDest ()) && curBoard.getPiece (leftMove.getDest ()).getColor () == this.getColor ())
					|| (leftMove.getDest ().getX () > 7 || leftMove.getDest ().getY () > 7 || leftMove.getDest ().getX () < 0 || leftMove.getDest ().getY () < 0) )
			{
				break;
			}
			else if (curBoard.isOccupied (leftMove.getDest ()) && curBoard.getPiece (leftMove.getDest ()).getColor () != this.getColor ())
			{
				validMoves.add (leftMove);
				break;
			}
			validMoves.add (leftMove);
		}
		for (int i = 1; i < 8; i++) {
			Move rightMove = new Move (this.coord, new Coord (this.coord.getX () + i, this.coord.getY ()));
			if ( (curBoard.isOccupied (rightMove.getDest ()) && curBoard.getPiece (rightMove.getDest ()).getColor () == this.getColor ())
					|| (rightMove.getDest ().getX () > 7 || rightMove.getDest ().getY () > 7 || rightMove.getDest ().getX () < 0 || rightMove.getDest ().getY () < 0) )
			{
				break;
			}
			else if (curBoard.isOccupied (rightMove.getDest ()) && curBoard.getPiece (rightMove.getDest ()).getColor () != this.getColor ())
			{
				validMoves.add (rightMove);
				break;
			}
			validMoves.add (rightMove);
		}
		for (int i = 1; i < 8; i++) {
			Move downMove = new Move (this.coord, new Coord (this.coord.getX () + i, this.coord.getY () + i));
			if ( (curBoard.isOccupied (downMove.getDest ()) && curBoard.getPiece (downMove.getDest ()).getColor () == this.getColor ())
					|| (downMove.getDest ().getX () > 7 || downMove.getDest ().getY () > 7 || downMove.getDest ().getX () < 0 || downMove.getDest ().getY () < 0) )
			{
				break;
			}
			else if (curBoard.isOccupied (downMove.getDest ()) && curBoard.getPiece (downMove.getDest ()).getColor () != this.getColor ())
			{
				validMoves.add (downMove);
				break;
			}
			validMoves.add (downMove);
		}
		for (int i = 1; i < 8; i++) {
			Move upMove = new Move (this.coord, new Coord (this.coord.getX () + i, this.coord.getY () - i));
			if ( (curBoard.isOccupied (upMove.getDest ()) && curBoard.getPiece (upMove.getDest ()).getColor () == this.getColor ())
					|| (upMove.getDest ().getX () > 7 || upMove.getDest ().getY () > 7 || upMove.getDest ().getX () < 0 || upMove.getDest ().getY () < 0) )
			{
				break;
			}
			else if (curBoard.isOccupied (upMove.getDest ()) && curBoard.getPiece (upMove.getDest ()).getColor () != this.getColor ())
			{
				validMoves.add (upMove);
				break;
			}
			validMoves.add (upMove);
		}
		for (int i = 1; i < 8; i++) {
			Move leftMove = new Move (this.coord, new Coord (this.coord.getX () - i, this.coord.getY () - i));
			if ( (curBoard.isOccupied (leftMove.getDest ()) && curBoard.getPiece (leftMove.getDest ()).getColor () == this.getColor ())
					|| (leftMove.getDest ().getX () > 7 || leftMove.getDest ().getY () > 7 || leftMove.getDest ().getX () < 0 || leftMove.getDest ().getY () < 0) )
			{
				break;
			}
			else if (curBoard.isOccupied (leftMove.getDest ()) && curBoard.getPiece (leftMove.getDest ()).getColor () != this.getColor ())
			{
				validMoves.add (leftMove);
				break;
			}
			validMoves.add (leftMove);
		}
		for (int i = 1; i < 8; i++) {
			Move rightMove = new Move (this.coord, new Coord (this.coord.getX () - i, this.coord.getY () + i));
			if ( (curBoard.isOccupied (rightMove.getDest ()) && curBoard.getPiece (rightMove.getDest ()).getColor () == this.getColor ())
					|| (rightMove.getDest ().getX () > 7 || rightMove.getDest ().getY () > 7 || rightMove.getDest ().getX () < 0 || rightMove.getDest ().getY () < 0) )
			{
				break;
			}
			else if (curBoard.isOccupied (rightMove.getDest ()) && curBoard.getPiece (rightMove.getDest ()).getColor () != this.getColor ())
			{
				validMoves.add (rightMove);
				break;
			}
			validMoves.add (rightMove);
		}
		return validMoves;
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
