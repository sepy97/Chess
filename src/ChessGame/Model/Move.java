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
	
	public Move (String inp)
	{
		if (inp.length () > 7)
		{
			System.out.println ("Not correct move STRING!!!!\n");
			return;
		}
		
		int fromX = (int) inp.charAt (0);
		int fromY = (int) inp.charAt (2);
		this.from = new Coord (fromX, fromY);
		
		int destX = (int) inp.charAt (4);
		int destY = (int) inp.charAt (6);
		this.dest = new Coord (destX, destY);
	}
	
	public Coord getFrom ()
	{
		return this.from;
	}
	
	public Coord getDest ()
	{
		return this.dest;
	}
	
	@Override
	public int hashCode(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.from.getX ());
		buffer.append(this.from.getY ());
		buffer.append(this.dest.getX ());
		buffer.append(this.dest.getY ());
		return buffer.toString().hashCode();
	}
	
	@Override
	public boolean equals (Object obj)
	{
		boolean result = this.from.getX () == ((Move)obj).from.getX () &&
				this.from.getY () == ((Move)obj).from.getY () &&
				this.dest.getX () == ((Move)obj).dest.getX () &&
				this.dest.getY () == ((Move)obj).dest.getY () &&
				obj instanceof Move;
		
		return result;
	}
	
	@Override
	public String toString ()
	{
		String result = "";
		result += from.toString ();
		result += " ";
		result += dest.toString ();
		return result;
	}
}
