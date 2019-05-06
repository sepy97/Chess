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
	
	public void enterGameLoop (int currentPlayer)
	{
		boolean checkmate = false;
		boolean stalemate = false;
		
		do {
			
			Move tm;// = new Move ();
			/*boolean success = this.gameBoard.makeMove (tm);
			if (success)
			{
				currentPlayer = (currentPlayer+1)%2;
				checkmate = gameBoard.isCheckmate ();
				stalemate = gameBoard.isStalemate ();
			}*/
		} while (!checkmate && !stalemate);
	}
	
	@Override
	public String toString ()
	{
		String result = "";
		result += player1 + "\n";
		result += player2 + "\n";
		result += gameBoard.toString ();
		return result;
	}
}
