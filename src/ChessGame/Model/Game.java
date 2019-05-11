package ChessGame.Model;

import java.io.Serializable;

public class Game implements Serializable
{
	public Board gameBoard;
	String player1;
	String player2;
	
	public Game (String player1, String player2)
	{
		gameBoard = new Board ();
		this.player1 = player1;
		this.player2 = player2;
		//chessNotation = "Game of " + player1 + " vs " + player2 + " ";
	}
	
	@Override
	public String toString ()
	{
		String result = "";
		//result += player1 + "\n";
		//result += player2 + "\n";
		result += gameBoard.toString ();
		return result;
	}
	
	public void loadFromString (String inp)
	{
		this.gameBoard.loadFromString (inp);
	}
	
	public void loadObject (Object readObject)
	{
		//this = (Game) readObject;
		this.gameBoard = ((Game) readObject).gameBoard;
		this.player1 = ((Game) readObject).player1;
		this.player2 = ((Game) readObject).player2;
	}
}
