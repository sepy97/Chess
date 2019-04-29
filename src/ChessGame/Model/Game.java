package ChessGame.Model;

public class Game
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
}
