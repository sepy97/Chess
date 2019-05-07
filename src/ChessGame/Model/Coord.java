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
	
	@Override
	public int hashCode(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.getX ());
		buffer.append(this.getY ());
		buffer.append(this.getX ());
		buffer.append(this.getY ());
		return buffer.toString().hashCode();
	}
	
	@Override
	public boolean equals (Object obj)
	{
		boolean result = this.getX () == ((Coord)obj).getX () &&
				this.getY () == ((Coord)obj).getY () &&
				this.getX () == ((Coord)obj).getX () &&
				this.getY () == ((Coord)obj).getY () &&
				obj instanceof Coord;
		
		return result;
	}
}
