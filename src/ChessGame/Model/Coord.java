package ChessGame.Model;

public class Coord
{
	private int x;
	private int y;
	
	public Coord (int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Coord (int arrayIndex)
	{
		this.x = arrayIndex % 8;
		this.y = arrayIndex / 8;
	}
	
	public int getX ()
	{
		return this.x;
	}
	
	public int getY ()
	{
		return this.y;
	}
}
