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
	
	public String parseInput() {
		if(player1.turn){
			System.out.print(player1.getName() + "'s move: ");
		} else {
			System.out.print(player2.getName() + "'s move: ");
		}
		Scanner s = new Scanner(System.in);
		String input = s.nextLine().trim().replaceAll("\\s","");
		if(input.length()>4) {
			return "Illegal move, try again";
		} else if (!(input.charAt(0)>= 'a' && input.charAt(0) <= 'h')){
			return "Illegal move, try again";
		} else if (!(input.charAt(1) >= '1' && input.charAt(1) <= '8')){
			return "Illegal move, try again";
		} else if (!(input.charAt(2)>= 'a' && input.charAt(2) <= 'h')){
			return "Illegal move, try again";
		} else if (!(input.charAt(3) >= '1' && input.charAt(3) <= '8')){
			return "Illegal move, try again";
		} else {
			char x, y= ' ';
			x = input.charAt(0);
			y = input.charAt(2);
			input = Integer.toString(Character.getNumericValue(x)-10) + input.charAt(1)
				   +Integer.toString(Character.getNumericValue(y)-10) + input.charAt(3);
			beg = new Point(8-Character.getNumericValue(input.charAt(1)), Character.getNumericValue(x)-10);
			end = new Point(8-Character.getNumericValue(input.charAt(3)), Character.getNumericValue(y)-10);
			//System.out.println("beg x " + beg.x + " beg y "+beg.y + "end x " + end.x + " end y " + end.y);
			if(b.ps[beg.x][beg.y]==null){
				return "Illegal move, try again";
			}
		}
		
		return input;
	}
	
	public void game() {
		while (!gamended){
			if(!parseInput().equalsIgnoreCase("Illegal move, try again")){
			if(b.ps[beg.x][beg.y].isMoveAllowed(beg, end, b)){
				//System.out.println("hello");
				b.ps[end.x][end.y] = b.ps[beg.x][beg.y];
				b.ps[beg.x][beg.y] = null;
				b.update();
				}
			} else {
				System.out.println("Illegal move, try again");
			}
			player1.turn = !player1.turn;
			player2.turn = !player2.turn;
			
		}
	}
}