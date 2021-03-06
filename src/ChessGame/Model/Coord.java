package ChessGame.Model;

import java.awt.*;
import java.io.Serializable;

public class Coord implements Serializable
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
	
	public Coord (String inp)
	{
		if (inp.length () > 3)
		{
			System.out.println ("Not correct coord STRING!!!!\n");
			return;
		}
		
		int fromX = (int) inp.charAt (0);
		int fromY = (int) inp.charAt (2);
		this.body = new Point (fromX, fromY);
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
