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
		if (this.getColor () == PieceColor.WHITE)
		{
			if (this.coord.getY () != 7) // не 1 линия
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () + 1));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (ordMove);
				}
			}
			if (this.coord.getY () != 0) //не 8 линия
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () - 1));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (ordMove);
				}
			}
			if (this.coord.getX () != 0) //не a-линия
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY ()));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (ordMove);
				}
			}
			if (this.coord.getX () != 7) //не h-линия
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY ()));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (ordMove);
				}
			}
			if (! (this.coord.getX () == 0 && this.coord.getY () == 0)) //не a8
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (ordMove);
				}
			}
			if (! (this.coord.getX () == 0 && this.coord.getY () == 7)) //не a1
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (ordMove);
				}
			}
			if (! (this.coord.getX () == 7 && this.coord.getY () == 0)) //не h8
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (ordMove);
				}
			}
			if (! (this.coord.getX () == 7 && this.coord.getY () == 7)) //не a8
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (ordMove);
				}
			}
		}
		else
		{
			if (this.coord.getY () != 7) // не 1 линия
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () + 1));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (ordMove);
				}
			}
			if (this.coord.getY () != 0) //не 8 линия
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX (), this.coord.getY () - 1));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (ordMove);
				}
			}
			if (this.coord.getX () != 0) //не a-линия
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY ()));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (ordMove);
				}
			}
			if (this.coord.getX () != 7) //не h-линия
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY ()));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (ordMove);
				}
			}
			if (! (this.coord.getX () == 0 && this.coord.getY () == 0)) //не a8
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (ordMove);
				}
			}
			if (! (this.coord.getX () == 0 && this.coord.getY () == 7)) //не a1
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (ordMove);
				}
			}
			if (! (this.coord.getX () == 7 && this.coord.getY () == 0)) //не h8
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (ordMove);
				}
			}
			if (! (this.coord.getX () == 7 && this.coord.getY () == 7)) //не a8
			{
				Move ordMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (ordMove.getDest ()) && curBoard.getPiece (ordMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (ordMove);
				}
			}
		}
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
