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
	public HashSet <Move> getValidMoves (Board curBoard)
	{
		HashSet <Move> validMoves = new HashSet<Move> ();
		if (this.getColor () == PieceColor.WHITE)
		{
			if (this.getCoord ().getX () > 1 && this.getCoord ().getX () < 6 && this.getCoord ().getY () > 1 && this.getCoord ().getY () < 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () == 1 && this.getCoord ().getY () > 1 && this.getCoord ().getY () < 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (fivthMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () == 6 && this.getCoord ().getY () > 1 && this.getCoord ().getY () < 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (firstMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () > 1 && this.getCoord ().getX () < 6 && this.getCoord ().getY () == 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (thirdMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () > 1 && this.getCoord ().getX () < 6 && this.getCoord ().getY () == 1)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (seventhMove);
				}
			}
			else if (this.getCoord ().getX () == 1 && this.getCoord ().getY () == 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (thirdMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () == 1 && this.getCoord ().getY () == 1)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (fivthMove);
				}
			}
			else if (this.getCoord ().getX () == 6 && this.getCoord ().getY () == 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (firstMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.BLACK))
				{
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () == 6 && this.getCoord ().getY () == 1)
			{
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (seventhMove);
				}
			}
			else if (this.getCoord ().getX () > 1 && this.getCoord ().getX () < 6 && this.getCoord ().getY () == 7)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (secondMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () > 1 && this.getCoord ().getX () < 6 && this.getCoord ().getY () == 0)
			{
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (sixthMove);
				}
			}
			else if (this.getCoord ().getX () == 0 && this.getCoord ().getY () > 1 && this.getCoord ().getY () < 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (fourthMove);
				}
			}
			else if (this.getCoord ().getX () == 7 && this.getCoord ().getY () > 1 && this.getCoord ().getY () < 6)
			{
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () == 0 && this.getCoord ().getY () == 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (thirdMove);
				}
			}
			else if (this.getCoord ().getX () == 7 && this.getCoord ().getY () == 6)
			{
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () == 7 && this.getCoord ().getY () == 1)
			{
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (seventhMove);
				}
			}
			else if (this.getCoord ().getX () == 0 && this.getCoord ().getY () == 1)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (fourthMove);
				}
			}
			else if (this.getCoord ().getX () == 6 && this.getCoord ().getY () == 7)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (fourthMove);
				}
			}
			else if (this.getCoord ().getX () == 1 && this.getCoord ().getY () == 7)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (fourthMove);
				}
			}
			else if (this.getCoord ().getX () == 1 && this.getCoord ().getY () == 0)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (fourthMove);
				}
			}
			else if (this.getCoord ().getX () == 6 && this.getCoord ().getY () == 0)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (fourthMove);
				}
			}
			else if (this.getCoord ().getX () == 0 && this.getCoord ().getY () == 7)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (secondMove);
				}
			}
			else if (this.getCoord ().getX () == 7 && this.getCoord ().getY () == 7)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (secondMove);
				}
			}
			else if (this.getCoord ().getX () == 7 && this.getCoord ().getY () == 0)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (secondMove);
				}
			}
			else if (this.getCoord ().getX () == 0 && this.getCoord ().getY () == 0)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.BLACK)) {
					validMoves.add (secondMove);
				}
			}
		}
		else
		{
			if (this.getCoord ().getX () > 1 && this.getCoord ().getX () < 6 && this.getCoord ().getY () > 1 && this.getCoord ().getY () < 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () == 1 && this.getCoord ().getY () > 1 && this.getCoord ().getY () < 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (fivthMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () == 6 && this.getCoord ().getY () > 1 && this.getCoord ().getY () < 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (firstMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () > 1 && this.getCoord ().getX () < 6 && this.getCoord ().getY () == 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (thirdMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () > 1 && this.getCoord ().getX () < 6 && this.getCoord ().getY () == 1)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (seventhMove);
				}
			}
			else if (this.getCoord ().getX () == 1 && this.getCoord ().getY () == 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (thirdMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () == 1 && this.getCoord ().getY () == 1)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (fivthMove);
				}
			}
			else if (this.getCoord ().getX () == 6 && this.getCoord ().getY () == 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (firstMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.WHITE))
				{
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () == 6 && this.getCoord ().getY () == 1)
			{
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (seventhMove);
				}
			}
			else if (this.getCoord ().getX () > 1 && this.getCoord ().getX () < 6 && this.getCoord ().getY () == 7)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (secondMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () > 1 && this.getCoord ().getX () < 6 && this.getCoord ().getY () == 0)
			{
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (fourthMove);
				}
				
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (sixthMove);
				}
			}
			else if (this.getCoord ().getX () == 0 && this.getCoord ().getY () > 1 && this.getCoord ().getY () < 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (fourthMove);
				}
			}
			else if (this.getCoord ().getX () == 7 && this.getCoord ().getY () > 1 && this.getCoord ().getY () < 6)
			{
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () == 0 && this.getCoord ().getY () == 6)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (thirdMove);
				}
			}
			else if (this.getCoord ().getX () == 7 && this.getCoord ().getY () == 6)
			{
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (seventhMove);
				}
				
				Move eighthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (eighthMove.getDest ()) && curBoard.getPiece (eighthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (eighthMove);
				}
			}
			else if (this.getCoord ().getX () == 7 && this.getCoord ().getY () == 1)
			{
				Move fivthMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fivthMove.getDest ()) && curBoard.getPiece (fivthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (fivthMove);
				}
				
				Move sixthMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (sixthMove.getDest ()) && curBoard.getPiece (sixthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (sixthMove);
				}
				
				Move seventhMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (seventhMove.getDest ()) && curBoard.getPiece (seventhMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (seventhMove);
				}
			}
			else if (this.getCoord ().getX () == 0 && this.getCoord ().getY () == 1)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (fourthMove);
				}
			}
			else if (this.getCoord ().getX () == 6 && this.getCoord ().getY () == 7)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (fourthMove);
				}
			}
			else if (this.getCoord ().getX () == 1 && this.getCoord ().getY () == 7)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (fourthMove);
				}
			}
			else if (this.getCoord ().getX () == 1 && this.getCoord ().getY () == 0)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (fourthMove);
				}
			}
			else if (this.getCoord ().getX () == 6 && this.getCoord ().getY () == 0)
			{
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (secondMove);
				}
				
				Move thirdMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (thirdMove.getDest ()) && curBoard.getPiece (thirdMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (thirdMove);
				}
				
				Move fourthMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (fourthMove.getDest ()) && curBoard.getPiece (fourthMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (fourthMove);
				}
			}
			else if (this.getCoord ().getX () == 0 && this.getCoord ().getY () == 7)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (secondMove);
				}
			}
			else if (this.getCoord ().getX () == 7 && this.getCoord ().getY () == 7)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () + 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () + 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (secondMove);
				}
			}
			else if (this.getCoord ().getX () == 7 && this.getCoord ().getY () == 0)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () - 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () - 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (secondMove);
				}
			}
			else if (this.getCoord ().getX () == 0 && this.getCoord ().getY () == 0)
			{
				Move firstMove = new Move (this.coord, new Coord (this.coord.getX () + 1, this.coord.getY () - 2));
				if (!(curBoard.isOccupied (firstMove.getDest ()) && curBoard.getPiece (firstMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (firstMove);
				}
				
				Move secondMove = new Move (this.coord, new Coord (this.coord.getX () + 2, this.coord.getY () - 1));
				if (!(curBoard.isOccupied (secondMove.getDest ()) && curBoard.getPiece (secondMove.getDest ()).getColor () == PieceColor.WHITE)) {
					validMoves.add (secondMove);
				}
			}
		}
		return validMoves;
	}
	
	@Override
	public PieceType getType ()
	{
		return PieceType.KNIGHT;
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
		result += "N";
		return result;
	}
}
