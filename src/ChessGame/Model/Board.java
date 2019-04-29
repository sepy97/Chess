package ChessGame.Model;

import ChessGame.Model.Pieces.*;

import java.util.*;

public class Board
{
	private Square[] gameBoard;
	private int boardSize = 8;
	private ArrayList <Piece> gamePieces;
	
	public Board ()
	{
		int numOfSquares = boardSize*boardSize;
		gameBoard = new Square [numOfSquares];
		for (int i = 0; i < numOfSquares; i++)
		{
			gameBoard [i] = new Square (new Coord (i));
		}
		
		generateGamePieces ();
	}
	
	private void generateGamePieces ()
	{
		gamePieces = new ArrayList <Piece> ();
		for (int i = 0; i < boardSize; i++)
		{
			gamePieces.add (new Pawn (PieceColor.BLACK, new Coord (i, 1)));
			gamePieces.add (new Pawn (PieceColor.WHITE, new Coord (i, 6)));
		}
		
		gamePieces.add (new King (PieceColor.BLACK, new Coord (4, 0)));
		gamePieces.add (new King (PieceColor.WHITE, new Coord (4, 7)));
		
		
		gamePieces.add (new Queen (PieceColor.BLACK, new Coord (3, 0)));
		gamePieces.add (new Queen (PieceColor.WHITE, new Coord (3, 7)));
		
		gamePieces.add (new Rook (PieceColor.BLACK, new Coord (0, 0)));
		gamePieces.add (new Rook (PieceColor.WHITE, new Coord (0, 7)));
		gamePieces.add (new Rook (PieceColor.BLACK, new Coord (7, 0)));
		gamePieces.add (new Rook (PieceColor.WHITE, new Coord (7, 7)));
		
		gamePieces.add (new Bishop (PieceColor.BLACK, new Coord (2, 0)));
		gamePieces.add (new Bishop (PieceColor.WHITE, new Coord (2, 7)));
		gamePieces.add (new Bishop (PieceColor.BLACK, new Coord (5, 0)));
		gamePieces.add (new Bishop (PieceColor.WHITE, new Coord (5, 7)));
		
		gamePieces.add (new Knight (PieceColor.BLACK, new Coord (1, 0)));
		gamePieces.add (new Knight (PieceColor.WHITE, new Coord (1, 7)));
		gamePieces.add (new Knight (PieceColor.BLACK, new Coord (6, 0)));
		gamePieces.add (new Knight (PieceColor.WHITE, new Coord (6, 7)));
	}
	
	public Square getSquare (Coord coord)
	{
		return gameBoard [coord.getX() + boardSize * coord.getY()];
	}
	
	public Piece getPiece (Coord coord)
	{
		//if (gameBoard[coord.getX() + boardSize * coord.getY()].isOccupied ())
		{
			//Piece toreturn = new Piece;
			for (Piece i:gamePieces)
			{
				if (i.coord.getY () == coord.getY () && i.coord.getX () == coord.getX ()) return i;
			}
			//return gamePieces.get
		}
		return null;
	}
	
	public boolean makeMove (Move toMake)
	{
		Piece pieceToMove = null;
		
		for (int i = 0; i < gamePieces.size (); i++)
		{
			pieceToMove = gamePieces.get (i);
			if (pieceToMove.getCoord () == toMake.getFrom ())
			{
				break;
			}
			if (i == gamePieces.size () - 1 ) return false;
		}
		
		Set <Move> validMoves = pieceToMove.getValidMoves (this);
		
		/*if (!validMoves.contains (toMake))
		{
			return false;
		}
		else*/
		{
			//НУЖНА ПРОВЕРКА ВАЛИДНОСТИ ХОДА
			pieceToMove.changeCoord (toMake.getDest ());
		}
		
		return true;
	}
}
