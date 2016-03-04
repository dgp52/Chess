package controller;

import java.awt.Point;
import java.util.Scanner;

import model.Player;
import view.Board;

public class Game {
	Point beg = new Point();
	Point end = new Point();
	Player player1;// = new Player("White");
	Player player2;// = new Player("Black");
	boolean gamended = false;
	Board b;

	public Game() {
		b = new Board();
		player1 = new Player("White", b);
		player2 = new Player("Black", b);
		player1.addPieces();
		player2.addPieces();
		b.update();
		game();
	}

	public static void main(String[] sa) {
		new Game();
	}

	public boolean parseInput() {
		if (player1.turn) {
			System.out.print(player1.getName() + "'s move: ");
		} else {
			System.out.print(player2.getName() + "'s move: ");
		}
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();// .trim().replaceAll("\\s","");

		if (input.matches("[a-h][1-8]\\s[a-h][1-8]")) {
			input = input.trim().replaceAll("\\s", "");
			char x, y;
			x = input.charAt(0);
			y = input.charAt(2);
			beg.setLocation(8 - Character.getNumericValue(input.charAt(1)), Character.getNumericValue(x) - 10);
			end.setLocation(8 - Character.getNumericValue(input.charAt(3)), Character.getNumericValue(y) - 10);
//			 System.out.println("beg x " + beg.x + " beg y "+beg.y + " end x "
//			 + end.x + " end y " + end.y + " cdh " +
//			 Character.getNumericValue('b'));
			//s.close();
			return true;
		} else {
			//s.close();
			return false;
		}
	}

	public void game() {
		while (!gamended) {
			if (parseInput()) {
				if (b.ps[beg.x][beg.y].isMoveAllowed(beg, end, b) && b.ps[beg.x][beg.y] != null) {
					// System.out.println("hello");
					b.ps[end.x][end.y] = b.ps[beg.x][beg.y];
					b.ps[beg.x][beg.y] = null;
					b.update();
					player1.turn = !player1.turn;
					player2.turn = !player2.turn;
				}else {
					System.out.println("illegal move, try again\n");
				}
			}
			checkmate("BK", player1);
			checkmate("wk",player2);
		}
		System.out.println(player1.hasWon ? player1.getName() + " has won " : "");
		System.out.println(player2.hasWon ? player2.getName() + " has won " : "");
	}
	
	public void checkmate(String k, Player p) {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(b.ps[i][j] != null){
					if(b.ps[i][j].getPiece().equalsIgnoreCase(k))
						end.setLocation(i, j);
				}
			}
		}
		for(int i = 0; i < b.ps.length; i++){
			for(int j = 0; j < b.ps.length; j++){
				if(b.ps[i][j] != null){
					if(b.ps[i][j].getColor().equalsIgnoreCase(p.getName())){
						beg.setLocation(i, j);
						if(b.ps[i][j].isMoveAllowed(beg, end, b)){
							gamended = true;
							p.hasWon = true;
						}
					}
				}
			}
		}
	}
}