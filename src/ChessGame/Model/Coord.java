package ChessGame.Model;

import java.awt.*;

public class Coord
{
	private Point body;
	
	public Coord (int x, int y)
	{
		this.body = new Point (x, y);
	}
	
	public Coord (int arrayIndex)
	{
		this.body = new Point (arrayIndex % 8, arrayIndex / 8);
	}
	
	public int getX ()
	{
		return body.x;
	}
	
	public int getY ()
	{
		return body.y;
	}
	
	@Override
	public String toString ()
	{
		String result = "";
		result += body.x + "." + body.y;
		return result;
	}
}
