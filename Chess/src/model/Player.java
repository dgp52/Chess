package model;

import pieces.*;
import view.Board;

public class Player {
	String name;
	public boolean turn = false;
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addPieces() {
		if(name.equals("Black")){
			Board.ps[0][0] = new Rook(name.charAt(0)+"R", name);
			Board.ps[0][1] = new Knight(name.charAt(0)+"K", name);
			Board.ps[0][2] = new Bishop(name.charAt(0)+"B", name);
			Board.ps[0][3] = new Queen(name.charAt(0)+"Q", name);
			Board.ps[0][4] = new King(name.charAt(0)+"K", name);
			Board.ps[0][5] = new Bishop(name.charAt(0)+"B", name);
			Board.ps[0][6] = new Knight(name.charAt(0)+"K", name);
			Board.ps[0][7] = new Rook(name.charAt(0)+"R", name);
			
			for(int i =0; i < Board.ps[1].length; i++){
				Board.ps[1][i] = new Pawn(name.charAt(0)+"p", name);
			}	
		}else {
			Board.ps[7][0] = new Rook(name.charAt(0)+"R", name);
			Board.ps[7][1] = new Knight(name.charAt(0)+"K", name);
			Board.ps[7][2] = new Bishop(name.charAt(0)+"B", name);
			Board.ps[7][4] = new Queen(name.charAt(0)+"Q", name);
			Board.ps[7][3] = new King(name.charAt(0)+"K", name);
			Board.ps[7][5] = new Bishop(name.charAt(0)+"B", name);
			Board.ps[7][6] = new Knight(name.charAt(0)+"K", name);
			Board.ps[7][7] = new Rook(name.charAt(0)+"R", name);
			
			for(int i =0; i < Board.ps[6].length; i++){
				Board.ps[6][i] = new Pawn(name.charAt(0)+"p", name);
			}
			turn = true;
		}
	}

}
