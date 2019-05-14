package ChessGame.Controller;


import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


import ChessGame.Model.*;
import ChessGame.View.GameView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Arrays;

public class Server
{
	public Game model;
	public GameView view;
	
	ServerSocket srvr;
	Socket clnt;
	
	private InputStream sin;
	private OutputStream sout;
	
	public void startGame ()
	{
		model = new Game ("player1", "player2");
		view.chessBoard.update (model.gameBoard);
	}
	
	public Server () //Game model, GameView view)
	{
		this.model = new Game ("player1", "player2");// model;
		this.view = new GameView (this.model);// view;
		
		MListener mL = new MListener ();//view.chessBoard);
		view.chessBoard.addMouseListener (mL);
		
		ButtonListener bL = new ButtonListener ();
		this.view.newGameBut.addActionListener  (bL);
		this.view.saveGameBut.addActionListener (bL);
		this.view.loadGameBut.addActionListener (bL);
		
		try {
			srvr = new ServerSocket (6666);
		} catch (IOException e) {
			e.printStackTrace ();
		}
		
		try {
			clnt = srvr.accept ();
		} catch (IOException e) {
			e.printStackTrace ();
		}
		
		try {
			sin = clnt.getInputStream ();
		} catch (IOException e) {
			e.printStackTrace ();
		}
		
		try {
			sout = clnt.getOutputStream ();
		} catch (IOException e) {
			e.printStackTrace ();
		}
		
	}
	
	
	public static void main (String[] s)
	{
		Server chess = new Server ();
	}
	
	public class MListener extends MouseAdapter
	{
		public MListener ()
		{
		
		}
		
		public void mouseReleased (MouseEvent e)
		{
			if (downer) {
				downer = false;
				if (new Rectangle (e.getComponent().getLocationOnScreen(), e.getComponent().getSize())
						.contains(e.getLocationOnScreen())) {
					downer = false;
					// CODE
					new Thread(new Runnable(){
						public void run(){
							//Your Listener code
							
							
							
							
							
							Graphics g = view.chessBoard.getGraphics ();
							
							if (view.chessBoard.isMouseClicked)
							{
								view.chessBoard.to = e.getPoint ();
								int fromX = (view.chessBoard.from.x - 20) / 60;
								int fromY = (view.chessBoard.from.y - 50) / 60;
								int toX = (view.chessBoard.to.x - 20) / 60;
								int toY = (view.chessBoard.to.y - 50) / 60;
								
								boolean correctMove = model.gameBoard.makeMove (new Move (new Coord (fromX, fromY), new Coord (toX, toY)));;
								//if (correctMove) return new Move (new Coord (fromX, fromY), new Coord (toX, toY))
								if (correctMove) sendMove (new Move (new Coord (fromX, fromY), new Coord (toX, toY)));
								view.update (model);
								view.chessBoard.isMouseClicked = false;
								
								Move toMake = recvMove ();
								model.gameBoard.makeMove (toMake);
								view.update (model);
							}
							else {
								g.setColor (Color.green);
								view.chessBoard.from = e.getPoint ();
								int fromX = (view.chessBoard.from.x - 20) / 60;
								int fromY = (view.chessBoard.from.y - 50) / 60;
								if (model.gameBoard.isOccupied (new Coord (fromX, fromY)))
								{
									g.drawRect (20 + fromX * 60, 50 + fromY * 60, 60, 60);
									view.chessBoard.isMouseClicked = true;
								}
							}
							
							
							
							
							
						}
					}).start();
					
					/// COde
				}
			}
		}
		
		boolean downer = false;
		
		public void mousePressed (MouseEvent e)
		{
			downer = true;
		}
	}
	
	private void sendMove (Move move)
	{
		System.out.println ("sending move");
		try {
			sout.write (move.toString ().getBytes ());
		} catch (IOException e) {
			e.printStackTrace ();
		}
	}
	
	private Move recvMove ()
	{
		Move toRecv = null;// = new Move ();
		try {
			byte [] torecv = new byte[7];
			sin.read (torecv);
			String inp = new String (torecv);
			toRecv = new Move (inp);
		} catch (IOException e) {
			e.printStackTrace ();
		}
		
		return toRecv;
	}
	
	
	
	class ButtonListener implements ActionListener
	{
		
		@Override
		public void actionPerformed (ActionEvent e)
		{
			if (e.getSource () == view.newGameBut) {
				System.out.println ("You clicked a newGame button!");
				
				startGame ();
			}
			else if (e.getSource () == view.saveGameBut)
			{
				System.out.println("You clicked a save button!");
				
				FileDialog fileDialog = new FileDialog(view.gameWindow, "Enter filename", FileDialog.SAVE);
				fileDialog.setFilenameFilter(new FilenameFilter () {
					public boolean accept(File dir, String name) {
						return name.endsWith(".chess");
					}
				});
				fileDialog.setFile("Untitled.chess");
				fileDialog.setVisible(true);
				try {
					ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream (fileDialog.getFile ()));
					
					out.writeObject (model);
					
					out.close ();
				} catch (IOException e2) {
					e2.printStackTrace ();
				}
			}
			else if (e.getSource () == view.loadGameBut)
			{
				System.out.println("You clicked a load button!");
				
				FileDialog fd = new FileDialog(view.gameWindow, "Choose a file", FileDialog.LOAD);
				fd.setDirectory("/Users/sepy/Documents/JAVA/ChessGame/");
				fd.setFile("*.chess");
				fd.setVisible(true);
				String filename = fd.getFile();
				if (filename == null)
					System.out.println("You cancelled the choice");
				else
					System.out.println("You chose " + filename);
				
				try {
					ObjectInputStream in = new ObjectInputStream (new FileInputStream (filename));
					
					model.loadObject (in.readObject ());
					view.update (model);
					
					in.close ();
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace ();
				}
			}
		}
	}
	
}



/*
public class Server
{
	
	public Server ()
	{
		ctrl = new Controller ();
		
		
	}
	
	public void startServer ()
	{
		while (ctrl.view.isOpened () )
		{
		
		}
	}
	
	public static void main (String[] s)
	{
	
	}
}*/
