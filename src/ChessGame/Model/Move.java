package ChessGame.Model;

public class Move
{
	private Coord from;
	private Coord dest;
	
	public Move (Coord from, Coord dest)
	{
		this.from = from;
		this.dest = dest;
	}
	
	public Coord getFrom ()
	{
		return this.from;
	}
	
	public Coord getDest ()
	{
		return this.dest;
	}
}
