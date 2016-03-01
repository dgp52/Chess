package controller;

import java.util.Scanner;

import model.Player;
import view.Board;

public class Game {
	Player player1 = new Player("White");
	Player player2 = new Player("Black");
	boolean gamended = false;
	
	public Game() {
		new Board(player1, player2);
		
		System.out.println(parseInput());
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
		}
		return input;
	}
	
	public void game() {
		while (!gamended){
			System.out.println(parseInput());
			player1.turn = !player1.turn;
			player2.turn = !player2.turn;
		}
	}
}
