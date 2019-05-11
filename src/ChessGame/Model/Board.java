package ChessGame.Model;

import ChessGame.Model.Pieces.*;

import java.io.Serializable;
import java.util.*;

public class Board implements Serializable
{
	private Square[] gameBoard;
	private int boardSize = 8;
	private ArrayList <Piece> gamePieces;
	PieceColor current;
	
	public Board ()
	{
		int numOfSquares = boardSize*boardSize;
		current = PieceColor.WHITE;
		gameBoard = new Square [numOfSquares];
		for (int i = 0; i < numOfSquares; i++)
		{
			gameBoard [i] = new Square (new Coord (i));
		}
		
		generateGamePieces ();
	}
	
	public Board (String inp)
	{
		int numOfSquares = boardSize*boardSize;
		current = PieceColor.WHITE;
		gameBoard = new Square [numOfSquares];
		for (int i = 0; i < numOfSquares; i++)
		{
			gameBoard [i] = new Square (new Coord (i));
		}
		
		generateGamePieces (inp);
	}
	
	private void generateGamePieces (String inp)
	{
		gamePieces = new ArrayList <Piece> ();
		for (int i = 0; i < inp.length (); i++)
		{
			char tmp = inp.charAt (i);
			switch (tmp)
			{
				case 'p':
				{
					gamePieces.add (new Pawn (PieceColor.WHITE, new Coord (i)));
					break;
				}
				case 'n':
				{
					gamePieces.add (new Knight (PieceColor.WHITE, new Coord (i)));
					break;
				}
				case 'b':
				{
					gamePieces.add (new Bishop (PieceColor.WHITE, new Coord (i)));
					break;
				}
				case 'r':
				{
					gamePieces.add (new Rook (PieceColor.WHITE, new Coord (i)));
					break;
				}
				case 'q':
				{
					gamePieces.add (new Queen (PieceColor.WHITE, new Coord (i)));
					break;
				}
				case 'k':
				{
					gamePieces.add (new King (PieceColor.WHITE, new Coord (i)));
					break;
				}
				case 'P':
				{
					gamePieces.add (new Pawn (PieceColor.BLACK, new Coord (i)));
					break;
				}
				case 'N':
				{
					gamePieces.add (new Knight (PieceColor.BLACK, new Coord (i)));
					break;
				}
				case 'B':
				{
					gamePieces.add (new Bishop (PieceColor.BLACK, new Coord (i)));
					break;
				}
				case 'R':
				{
					gamePieces.add (new Rook (PieceColor.BLACK, new Coord (i)));
					break;
				}
				case 'Q':
				{
					gamePieces.add (new Queen (PieceColor.BLACK, new Coord (i)));
					break;
				}
				case 'K':
				{
					gamePieces.add (new King (PieceColor.BLACK, new Coord (i)));
					break;
				}
			}
		}
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
	
	public void removePiece (Piece toRemove)
	{
		gamePieces.remove (toRemove);
	}
	
	public Square getSquare (Coord coord)
	{
		return gameBoard [coord.getX() + boardSize * coord.getY()];
	}
	
	public Piece getPiece (Coord coord)
	{
		for (Piece i:gamePieces)
		{
			if (i.coord.equals (coord)) return i;
		}
		return null;
	}
	
	public boolean makeMove (Move toMake)
	{
		Piece pieceToMove = null;
		
		for (int i = 0; i < gamePieces.size (); i++)
		{
			pieceToMove = gamePieces.get (i);
			if (pieceToMove.getCoord ().getX () == toMake.getFrom ().getX () && pieceToMove.getCoord ().getY () == toMake.getFrom ().getY ())
			{
				break;
			}
			if (i == gamePieces.size () - 1 ) return false;
		}
		
		HashSet <Move> validMoves = pieceToMove.getValidMoves (this);
		
		if (!validMoves.contains (toMake))
		{
			return false;
		}
		else
		{
			//НУЖНА ПРОВЕРКА ВЗЯТИЯ ФИГУРЫ
			if (this.isOccupied (toMake.getDest ()) )
			{
				for (Piece i: gamePieces)
				{
					if (i.getCoord ().equals (toMake.getDest ()) && i.getColor () != pieceToMove.getColor () && i.getType () != PieceType.KING)
					{
						gamePieces.remove (i);
						break;
					}
				}
			}
			pieceToMove.changeCoord (toMake.getDest ());
		}
		
		if (current == PieceColor.WHITE) current = PieceColor.BLACK;
		else current = PieceColor.WHITE;
		return true;
	}
	
	public HashSet <Move> getAllValidMoves (PieceColor color)
	{
		HashSet <Move> validMoves = new HashSet <Move> ();
		for (Piece i:gamePieces)
		{
			if (i.getColor () == color)
			{
				validMoves.addAll (i.getPossibleMoves (this));
			}
		}
		
		return validMoves;
	}
	
	public boolean isOccupied (Coord coord)
	{
		return (getPiece (coord) != null); //@@@@
	}
	
	public boolean hasCheck (PieceColor color)
	{
		for (Piece i:gamePieces)
		{
			if (i.getColor () == color && i.getType () == PieceType.KING)
			{
				King K = (King)i;
				return K.isChecked (this);
			}
		}
		return false;
	}
	
	public boolean checkMated (PieceColor color)
	{
		if (hasCheck (color) )
		{
			HashSet <Move> validMoves = getAllValidMoves (color);
			return validMoves.isEmpty ();
		}
		return false;
	}
	
	public boolean staleMated (PieceColor color)
	{
		if (!hasCheck (color))
		{
			HashSet <Move> validMoves = getAllValidMoves (color);
			return validMoves.isEmpty ();
		}
		return false;
	}
	
	@Override
	public String toString ()
	{
		String result = "";
		for (int i = 0; i < 64; i++)
		{
			if (this.isOccupied (new Coord (i)) )
			{
				result += this.getPiece (new Coord (i)).toString ();
			}
			else
			{
				result += "@";
			}
		}
		
		return result;
	}
	
	public void loadFromString (String inp)
	{
		this.gamePieces.clear ();
		//this.gameBoard
		if (inp.length () > 64)
		{
			System.out.println ("Not correct STRING!!!!\n");
			return;
		}
		
		for (int i = 0; i < 64; i++)
		{
			switch (inp.charAt (i))
			{
				case 'p':
				{
					this.gamePieces.add (new Pawn (PieceColor.WHITE, new Coord (i)));
					break;
				}
				case 'P':
				{
					this.gamePieces.add (new Pawn (PieceColor.BLACK, new Coord (i)));
					break;
				}
				case 'n':
				{
					this.gamePieces.add (new Knight (PieceColor.WHITE, new Coord (i)));
					break;
				}
				case 'N':
				{
					this.gamePieces.add (new Knight (PieceColor.BLACK, new Coord (i)));
					break;
				}
				case 'b':
				{
					this.gamePieces.add (new Bishop (PieceColor.WHITE, new Coord (i)));
					break;
				}
				case 'B':
				{
					this.gamePieces.add (new Bishop (PieceColor.BLACK, new Coord (i)));
					break;
				}
				case 'r':
				{
					this.gamePieces.add (new Rook (PieceColor.WHITE, new Coord (i)));
					break;
				}
				case 'R':
				{
					this.gamePieces.add (new Rook (PieceColor.BLACK, new Coord (i)));
					break;
				}
				case 'q':
				{
					this.gamePieces.add (new Queen (PieceColor.WHITE, new Coord (i)));
					break;
				}
				case 'Q':
				{
					this.gamePieces.add (new Queen (PieceColor.BLACK, new Coord (i)));
					break;
				}
				case 'k':
				{
					this.gamePieces.add (new King (PieceColor.WHITE, new Coord (i)));
					break;
				}
				case 'K':
				{
					this.gamePieces.add (new King (PieceColor.BLACK, new Coord (i)));
					break;
				}
				default: break;
			}
			
		}
	}
}
