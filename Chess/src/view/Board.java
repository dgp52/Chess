package view;

import model.Piece;
import model.Player;

public class Board {
	public static Piece[][] ps = new Piece[8][8]; 
	int counter = 8;
	public Board(Player p1, Player p2) {
		p1.addPieces();
		p2.addPieces();
		for(int i = 0; i< ps.length; i++){
			for(int j= 0; j<ps.length; j++){
				if(ps[i][j] == null){
					if((i+j)%2 != 0){
						System.out.print("##" + " ");
					}else {
						System.out.print("   ");
					}
				} else {
					System.out.print(ps[i][j] + " ");
				}
			}
			System.out.print(counter--);
			System.out.println();
		}
		System.out.print(" a  b  c  d  e  f  g  h");
		System.out.println("\n");
	}
}
