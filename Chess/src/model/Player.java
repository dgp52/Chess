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
	public Player(String name, Board b) {
		this.name = name;
		this.b = b;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addPieces() {
		if(name.equals("Black")){
			b.ps[2][0] = new Rook(name.charAt(0)+"R", name);
			b.ps[0][1] = new Knight(name.charAt(0)+"K", name);
			b.ps[0][2] = new Bishop(name.charAt(0)+"B", name);
			b.ps[0][3] = new Queen(name.charAt(0)+"Q", name);
			b.ps[0][4] = new King(name.charAt(0)+"K", name);
			b.ps[0][5] = new Bishop(name.charAt(0)+"B", name);
			b.ps[0][6] = new Knight(name.charAt(0)+"K", name);
			b.ps[0][7] = new Rook(name.charAt(0)+"R", name);
			
//			for(int i =0; i < b.ps[1].length; i++){
	//			b.ps[1][i] = new Pawn(name.charAt(0)+"p", name);
		//	}	
		}else {
			b.ps[7][0] = new Rook(name.charAt(0)+"R", name);
			b.ps[7][1] = new Knight(name.charAt(0)+"K", name);
			b.ps[7][2] = new Bishop(name.charAt(0)+"B", name);
			b.ps[7][4] = new Queen(name.charAt(0)+"Q", name);
			b.ps[7][3] = new King(name.charAt(0)+"K", name);
			b.ps[7][5] = new Bishop(name.charAt(0)+"B", name);
			b.ps[7][6] = new Knight(name.charAt(0)+"K", name);
			b.ps[7][7] = new Rook(name.charAt(0)+"R", name);
			
			for(int i =0; i < b.ps[6].length; i++){
				b.ps[6][i] = new Pawn(name.charAt(0)+"p", name);
			}
			turn = true;
		}
	}

}
