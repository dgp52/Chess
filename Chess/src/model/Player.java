package model;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;
import view.Board;

public class Player {
	String name;
	Board b;
	public boolean turn = false;
	public boolean hasWon = false;
	public Player(String name, Board b) {
		this.name = name;
		this.b = b;
	}
	
	public String getName() {
		return this.name;
	}
	
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
			b.ps[7][4] = new Queen("wQ", name);
			b.ps[7][3] = new King("wK", name);
			b.ps[7][5] = new Bishop("wB", name);
			b.ps[7][6] = new Knight("wN", name);
			b.ps[7][7] = new Rook("wR", name);
			
			for(int i =0; i < b.ps[6].length; i++){
				b.ps[6][i] = new Pawn("wp", name);
			}
			turn = true;
		}
	}

}
