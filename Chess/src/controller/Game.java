/**Chess Game
 * @author hassan and deep
 *
 */

package controller;

import java.awt.Point;
import java.util.Scanner;

import model.Player;
import model.pieces.Bishop;
import model.pieces.King;
import model.pieces.Knight;
import model.pieces.Pawn;
import model.pieces.Queen;
import model.pieces.Rook;
import view.Board;

public class Game {
	Point beg = new Point();
	Point end = new Point();
	Player player1;
	Player player2;
	boolean gamended = false;
	boolean pawnPromotion = false;
	boolean gameDraw = false;
	Board b;
	//AbstractPiece pi;

	/**
	 * sets up the board and players
	 */
	public Game() {
		b = new Board();
		player1 = new Player("White", b);
		player2 = new Player("Black", b);
		player1.addPieces();
		player2.addPieces();
		b.update();
		play();
	}

	/** main 
	 * @param sa
	 */
	public static void main(String[] sa) {
		new Game();
	}

	/** checks if user input is valid
	 * @return boolean
	 */
	public boolean parseInput() {
		if (player1.turn) {
			System.out.print(player1.getName() + "'s move: ");
		} else {
			System.out.print(player2.getName() + "'s move: ");
		}
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		
		if (input.matches("[r][e][s][i][g][n]")) {
			if(player1.turn){
				gamended = true;
				System.out.println(player1.getName() + " resigns");
				player2.hasWon = true;
				return false;
			} else {
				gamended = true;
				System.out.println(player2.getName() + " resigns");
				player1.hasWon = true;
				return false;
			}
		}
		
		if (input.matches("[d][r][a][w]")){
			if(player1.turn && player2.draw){
				gameDraw = true;
				return false;
			} else if (player2.turn && player1.draw) {
				gameDraw = true;
				return false;
			} else {
				return false;
			}
		}

		if (input.matches("[a-h][1-8]\\s[a-h][1-8](\\s[d][r][a][w][?])*(\\s[N|R|B|Q])*")) {
			input = input.trim().replaceAll("\\s", "");
			
			if (input.length() == 9 && input.charAt(8)=='?' && !player1.draw && !player2.draw) {
				if(player1.turn){
					player1.draw = true;
				} else {
					player2.draw = true;
				}
			} else if ((player1.draw || player2.draw) && input.length() == 9 && input.charAt(8)=='?') {
				return false;
			} 
			
			char x, y;
			x = input.charAt(0);
			y = input.charAt(2);
			beg.setLocation(8 - Character.getNumericValue(input.charAt(1)), Character.getNumericValue(x) - 10);
			end.setLocation(8 - Character.getNumericValue(input.charAt(3)), Character.getNumericValue(y) - 10);
			if (b.ps[beg.x][beg.y] == null)
				return false;

			if (input.length() == 5 || input.length() == 4) {
				if (b.ps[beg.x][beg.y] instanceof Pawn) {
					Pawn p = (Pawn) b.ps[beg.x][beg.y];
					if (p.getColor().equalsIgnoreCase("white") && beg.x == 1 && end.x == 0) {

						if (end.x + 1 == beg.x && end.y == beg.y && b.ps[end.x][end.y] == null && end.x == 0
								&& beg.x == 1) {
							if (input.length() == 4) {
								pawnPromote('Q', beg, end, b, "White");
								pawnPromotion = true;
								return false;
							} else if (input.length() == 5) {
								pawnPromote(input.charAt(4), beg, end, b, "White");
								pawnPromotion = true;
								return false;
							} else {
								pawnPromotion = false;
								return true;
							}
						} else if (end.x + 1 == beg.x && end.y + 1 == beg.y && !(b.ps[end.x][end.y] == null)
								&& b.ps[end.x][end.y].getColor().equalsIgnoreCase("Black") && end.x == 0
								&& beg.x == 1) {
							if (input.length() == 4) {
								pawnPromote('Q', beg, end, b, "White");
								pawnPromotion = true;
								return false;
							} else if (input.length() == 5) {
								pawnPromote(input.charAt(4), beg, end, b, "White");
								pawnPromotion = true;
								return false;
							} else {
								pawnPromotion = false;
								return true;
							}
						} else if (end.x + 1 == beg.x && end.y - 1 == beg.y && !(b.ps[end.x][end.y] == null)
								&& b.ps[end.x][end.y].getColor().equalsIgnoreCase("Black") && end.x == 0
								&& beg.x == 1) {
							if (input.length() == 4) {
								pawnPromote('Q', beg, end, b, "White");
								pawnPromotion = true;
								return false;
							} else if (input.length() == 5) {
								pawnPromote(input.charAt(4), beg, end, b, "White");
								pawnPromotion = true;
								return false;
							} else {
								pawnPromotion = false;
								return true;
							}

						} else {
							pawnPromotion = false;
							return true;
						}

					} else if (p.getColor().equalsIgnoreCase("Black") && beg.x == 6 && end.x == 7) {

						if (end.x - 1 == beg.x && end.y == beg.y && b.ps[end.x][end.y] == null && end.x == 7
								&& beg.x == 6) {
							if (input.length() == 4) {
								pawnPromote('Q', beg, end, b, "Black");
								pawnPromotion = true;
								return false;
							} else if (input.length() == 5) {
								pawnPromote(input.charAt(4), beg, end, b, "Black");
								pawnPromotion = true;
								return false;
							} else {
								pawnPromotion = false;
								return true;
							}
						} else if (end.x - 1 == beg.x && end.y + 1 == beg.y && !(b.ps[end.x][end.y] == null)
								&& b.ps[end.x][end.y].getColor().equalsIgnoreCase("White") && end.x == 7
								&& beg.x == 6) {
							if (input.length() == 4) {
								pawnPromote('Q', beg, end, b, "Black");
								pawnPromotion = true;
								return false;
							} else if (input.length() == 5) {
								pawnPromote(input.charAt(4), beg, end, b, "Black");
								pawnPromotion = true;
								return false;
							} else {
								pawnPromotion = false;
								return true;
							}
						} else if (end.x - 1 == beg.x && end.y - 1 == beg.y && !(b.ps[end.x][end.y] == null)
								&& b.ps[end.x][end.y].getColor().equalsIgnoreCase("White") && end.x == 7
								&& beg.x == 6) {
							if (input.length() == 4) {
								pawnPromote('Q', beg, end, b, "Black");
								pawnPromotion = true;
								return false;
							} else if (input.length() == 5) {
								pawnPromote(input.charAt(4), beg, end, b, "Black");
								pawnPromotion = true;
								return false;
							} else {
								pawnPromotion = false;
								return true;
							}

						} else {
							pawnPromotion = false;
							return true;
						}

					} else {
						if (input.length() == 5) {
							pawnPromotion = false;
							return false;
						} else {
							pawnPromotion = false;
							return true;
						}
					}
				} else {
					pawnPromotion = false;
					return true;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	/**promotes the pawn
	 *
	 */
	public void pawnPromote(char c, Point beg, Point end, Board b, String color) {
		char s = color.toLowerCase().charAt(0);
		switch (c) {
		case 'B':
			b.ps[end.x][end.y] = new Bishop(s + "B", color);
			b.ps[beg.x][beg.y] = null;
			b.update();
			break;
		case 'N':
			b.ps[end.x][end.y] = new Knight(s + "N", color);
			b.ps[beg.x][beg.y] = null;
			b.update();
			break;
		case 'Q':
			b.ps[end.x][end.y] = new Queen(s + "Q", color);
			b.ps[beg.x][beg.y] = null;
			b.update();
			break;
		case 'R':
			b.ps[end.x][end.y] = new Rook(s + "R", color);
			b.ps[beg.x][beg.y] = null;
			b.update();
			break;
		}
	}

	/** check who's turn it is
	 * @param p
	 * @return
	 */
	public boolean turn(Player p) {
		if (p.turn) {
			if (b.ps[beg.x][beg.y].getColor().equalsIgnoreCase(p.getName()))
				return true;
		}
		return false;
	}

	/** starts the game
	 * 
	 */
	public void play() {
		while (!gamended) {
			if (parseInput()) {
				if (player1.turn && castle(player2)) {
					player1.turn = !player1.turn;
					player2.turn = !player2.turn;
					b.update();
				}else if (player2.turn && castle(player1)) {
					player1.turn = !player1.turn;
					player2.turn = !player2.turn;
					b.update();

				} else if (b.ps[beg.x][beg.y] != null && b.ps[beg.x][beg.y].isMoveAllowed(beg, end, b)
						&& (turn(player1) || turn(player2))) {
					b.ps[end.x][end.y] = b.ps[beg.x][beg.y];
					b.ps[beg.x][beg.y] = null;
					b.update();
					player1.turn = !player1.turn;
					player2.turn = !player2.turn;
				} else {
					System.out.println("illegal move, try again\n");
				}
			} else if (pawnPromotion) {
				player1.turn = !player1.turn;
				player2.turn = !player2.turn;
				pawnPromotion = false;
			} else if (gamended) {
			} else if (gameDraw) {
				gamended = true;
			} else {
				System.out.println("illegal move, try again\n");
			}

			getKing("bk");
			if (check(player1)) {
				System.out.println("Check\n");
				if (checkmate("bk", player1) && !intervene(player2)) {
					gamended = true;
					player1.hasWon = true;
				}
			}

			getKing("wk");
			if (check(player2)) {
				System.out.println("Check\n");
				if (checkmate("wk", player2) && !intervene(player1)) {
					gamended = true;
					player2.hasWon = true;
				}
			}
		}
		
		if(gamended && gameDraw) {
			System.out.println("Game Drawn!");
		} else {
			System.out.println(player1.hasWon ? player1.getName() + " has won " : "");
			System.out.println(player2.hasWon ? player2.getName() + " has won " : "");	
		}
	}

	/** for a player checks for any piece that can be move to specific location
	 * @param p
	 * @return boolean
	 */
	public boolean check(Player p) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (b.ps[i][j] != null) {
					if (b.ps[i][j].getColor().equalsIgnoreCase(p.getName())) {
						beg.setLocation(i, j);
						if (b.ps[i][j].isMoveAllowed(beg, end, b)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/** for a given player checks if a checkmate can be prevented by moving any other piece than the king it self
	 * @param p
	 * @return boolean
	 */
	public boolean intervene(Player p) {
		Point d = new Point();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (b.ps[i][j] != null) {
					if (b.ps[i][j].getColor().equalsIgnoreCase(p.getName())) {
						d.setLocation(i, j);
						if (b.ps[i][j].isMoveAllowed(d, beg, b)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/** checks for a checkmate
	 * @param k
	 * @param p
	 * @return boolean
	 */
	public boolean checkmate(String k, Player p) {
		getKing(k);

		int x = end.x - 1;
		int y = end.y - 1;
		int x3 = x + 3;
		int y3 = y + 3;
		int x2 = x + 2;
		int y2 = y + 2;
		int y1 = y + 1;
		int x1 = x + 1;
		Point dummy = new Point(end.x, end.y); 
		if (x >= 0) {
			if (x3 < 8) {
				if (y >= 0) {
					if (y3 < 8) {
						return helper(x, y, x3, y3, dummy, b, p);
					} else if (y2 < 8) {
						return helper(x, y, x3, y2, dummy, b, p);
					} else {
						return helper(x, y, x3, y1, dummy, b, p);
					}
				}
			} else if (x2 < 8) {
				if (y >= 0) {
					if (y3 < 8) {
						return helper(x, y, x2, y3, dummy, b, p);
					} else if (y2 < 8) {
						return helper(x, y, x2, y2, dummy, b, p);
					} else {
						return helper(x, y, x2, y1, dummy, b, p);
					}
				}
			} else if (x1 < 8) {
				if (y >= 0) {
					if (y3 < 8) {
						return helper(x, y, x1, y3, dummy, b, p);
					} else if (y2 < 8) {
						return helper(x, y, x1, y2, dummy, b, p);
					} else {
						return helper(x, y, x1, y1, dummy, b, p);
					}
				}
			}
		}
		return false;
	}

	/**helper method for checkmate
	 * @param x
	 * @param y
	 * @param xx
	 * @param yy
	 * @param dummy
	 * @param b
	 * @param p
	 * @return boolean
	 */
	public boolean helper(int x, int y, int xx, int yy, Point dummy, Board b, Player p) {
		for (int i = x; i < xx; i++) {
			for (int j = y; j < yy; j++) {
				end.setLocation(i, j);
				if (b.ps[dummy.x][dummy.y].isMoveAllowed(dummy, end, b)) {
					if (!check(p)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**provides the location of the king
	 * @param k
	 */
	public void getKing(String k) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (b.ps[i][j] != null) {
					if (b.ps[i][j].getPiece().equalsIgnoreCase(k))
						end.setLocation(i, j);
				}
			}
		}
	}

	/** checks if castling is allowed
	 * @param p
	 * @return boolean
	 */
	public boolean castle(Player p) {
		if (b.ps[beg.x][beg.y] instanceof King && b.ps[beg.x][beg.y].isMoveAllowed(beg, end, b)) {
			King king = (King) b.ps[beg.x][beg.y];
			
			
			if (king.castle && !king.hasmoved) {
				int x = beg.x;
				int y = beg.y;
				if (check(p)) {
					return false;
				}
				beg.setLocation(x, y);
				if (king.getColor().equalsIgnoreCase("white")) {
					
					if ((beg.y < end.y && b.ps[7][7] instanceof Rook)) {
						Rook rook = (Rook) b.ps[7][7];
						if (!rook.hasmoved) {
							for (int i = beg.y + 1; i <= end.y; i++) {
								end.setLocation(beg.x, i);
								if (check(p)) {
									return false;
								}
							}
							b.ps[7][6] = b.ps[7][4];
							b.ps[7][4] = null;
							b.ps[7][5] = b.ps[7][7];
							b.ps[7][7] = null;
							return true;
						} else {
							return false;
						}

					} else {
						if (beg.y > end.y && b.ps[7][0] instanceof Rook) {
							Rook rook = (Rook) b.ps[7][0];
							if (!rook.hasmoved) {
								for (int i = beg.y - 1; i <= end.y; i--) {
									end.setLocation(beg.x, i);
									if (check(p)) {
										return false;
									}
								}
								b.ps[7][2] = b.ps[7][4];
								b.ps[7][4] = null;
								b.ps[7][3] = b.ps[7][0];
								b.ps[7][0] = null;
								return true;
							} else {
								return false;
							}
						}
					}
				} else {
					if ((beg.y < end.y && b.ps[0][7] instanceof Rook)) {
						Rook rook = (Rook) b.ps[0][7];
						if (!rook.hasmoved) {
							for (int i = beg.y + 1; i <= end.y; i++) {
								end.setLocation(beg.x, i);
								if (check(p)) {
									return false;
								}
							}
							b.ps[0][6] = b.ps[0][4];
							b.ps[0][4] = null;
							b.ps[0][5] = b.ps[0][7];
							b.ps[0][7] = null;
							return true;
						} else {
							return false;
						}

					} else {
						if (beg.y > end.y && b.ps[0][0] instanceof Rook) {
							Rook rook = (Rook) b.ps[0][0];
							if (!rook.hasmoved) {
								for (int i = beg.y - 1; i <= end.y; i--) {
									end.setLocation(beg.x, i);
									if (check(p)) {
										return false;
									}
								}
								b.ps[0][2] = b.ps[0][4];
								b.ps[0][4] = null;
								b.ps[0][3] = b.ps[0][0];
								b.ps[0][0] = null;
								return true;
							} else {
								return false;
							}
						}
					}
				}
			}
		}

		return false;
	}
}