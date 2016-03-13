package model;

import model.pieces.Bishop;
import model.pieces.King;
import model.pieces.Knight;
import model.pieces.Pawn;
import model.pieces.Queen;
import model.pieces.Rook;
import view.Board;

/**
 * @author hassan and deep
 *
 */
public class Player {
	String name;
	Board b;
	public boolean turn = false;
	public boolean hasWon = false;
	/** constructer for plater
	 * @param name
	 * @param b
	 */
	public Player(String name, Board b) {
		this.name = name;
		this.b = b;
	}
	
	/**
	 * sets up pieces for the player
	 */
	public void addPieces() {
		if(name.equals("Black")){
			b.ps[0][0] = new Rook("bR", name);
			b.ps[0][1] = new Knight("bN", name);
			b.ps[0][2] = new Bishop("bB", name);
			b.ps[0][3] = new Queen("bQ", name);
			b.ps[0][4] = new King("bK", name);
			b.ps[0][5] = new Bishop("bB", name);
			b.ps[0][6] = new Knight("bN", name);
			b.ps[0][7] = new Rook("bR", name);
			
			for(int i =0; i < b.ps[1].length; i++){
				b.ps[1][i] = new Pawn("bp", name);
			}	
		}else {
			b.ps[7][0] = new Rook("wR", name);
			b.ps[7][1] = new Knight("wN", name);
			b.ps[7][2] = new Bishop("wB", name);
			b.ps[7][3] = new Queen("wQ", name);
			b.ps[7][4] = new King("wK", name);
			b.ps[7][5] = new Bishop("wB", name);
			b.ps[7][6] = new Knight("wN", name);
			b.ps[7][7] = new Rook("wR", name);
			
			for(int i =0; i < b.ps[6].length; i++){
				b.ps[6][i] = new Pawn("wp", name);
			}
			turn = true;
		}
	}
	
	/** returns player name
	 * @return String
	 */
	public String getName() {
		return this.name;
	}

}