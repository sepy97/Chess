package ChessGame.Model;

import java.util.*;

public class Clock
{
	class Tick extends TimerTask
	{
		int numOfTicks;
		
		public Tick (int time)
		{
			numOfTicks = time;
		}
		
		@Override
		public void run ()
		{
			if (numOfTicks < 0)
			{
				remainingTime [currentPlayer.ordinal ()].cancel ();
			}
			//ЗДЕСЬ ЧТО_ТО НУЖНО ДЕЛАТЬ, ЧТОБЫ ОБНОВЛЯТЬ ЧАСЫ И ПРОВЕРЯТЬ НЕ РУХНУЛ ЛИ ФЛАГ
		}
	}
	
	enum player
	{
		whitePlayer, blackPlayer
	};
	
	Timer remainingTime [];
	player currentPlayer;
	
	public Clock (int whiteTime, int blackTime)
	{
		remainingTime = new Timer [2];
		remainingTime [player.whitePlayer.ordinal ()].schedule (new Tick (whiteTime), 1000, 1000);
		remainingTime [player.blackPlayer.ordinal ()].schedule (new Tick (blackTime), 1000, 1000);
		currentPlayer = player.whitePlayer;
	}
	
	public void runClock ()
	{
		//remainingTime [currentPlayer.ordinal ()].
	}
	
}

