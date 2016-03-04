package controller;

import java.awt.Point;
import java.util.Scanner;

import model.Player;
import view.Board;

public class Game {
	Point beg;
	Point end;
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
			beg = new Point(8 - Character.getNumericValue(input.charAt(1)), Character.getNumericValue(x) - 10);
			end = new Point(8 - Character.getNumericValue(input.charAt(3)), Character.getNumericValue(y) - 10);
			// System.out.println("beg x " + beg.x + " beg y "+beg.y + " end x "
			// + end.x + " end y " + end.y + " cdh " +
			// Character.getNumericValue('b'));
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
		}
	}
}