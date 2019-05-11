package ChessGame.Model;

import java.io.Serializable;

public class Square implements Serializable
{
	private Coord coord;
	
	public Square (Coord coord)
	{
		this.coord = coord;
	}
	
	/*public boolean isOccupied ()
	{
		
		return false; //@@@@
	}*/
	
	//public boolean isAttacked -- нужна ли???
}
