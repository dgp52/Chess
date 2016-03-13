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
	Player player1;// = new Player("White");
	Player player2;// = new Player("Black");
	boolean gamended = false;
	boolean pawnPromotion = false;
	Board b;

	public Game() {
		b = new Board();
		player1 = new Player("White", b);
		player2 = new Player("Black", b);
		player1.addPieces();
		player2.addPieces();
		b.update();
		play();
	}

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
		String input = s.nextLine();// .trim().replaceAll("\\s","");

		if (input.matches("[a-h][1-8]\\s[a-h][1-8](\\s[N|R|B|Q])*")) {
			input = input.trim().replaceAll("\\s", "");
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
							System.out.println("Illegal error");
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

			System.out.println("beg x " + beg.x + " beg y " + beg.y + " end x " + end.x + " end y " + end.y + " cdh "
					+ Character.getNumericValue('b'));
			// s.close();
			return true;
		} else {
			// s.close();
			return false;
		}
	}

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

					//System.out.println("whaaat " + b.ps[7][7]);
				}
				if (player2.turn && castle(player1)) {
					player1.turn = !player1.turn;
					player2.turn = !player2.turn;
					b.update();

				} else if (b.ps[beg.x][beg.y] != null && b.ps[beg.x][beg.y].isMoveAllowed(beg, end, b)
						&& (turn(player1) || turn(player2))) {
					// System.out.println("hello");
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

				System.out.println("Pawn got Promoted");
			} else {
				System.out.println("try again \n");
			}

			getKing("bk");
			if (check(player1)) {
				System.out.println("bkk");
				System.out.print("Check\n");
				if (checkmate("bk", player1) && !intervene(player2)) {
					gamended = true;
					player1.hasWon = true;
				}
			}

			getKing("wk");
			if (check(player2)) {
				System.out.print("Check\n" + "in pl2");
				if (checkmate("wk", player2) && !intervene(player1)) {
					gamended = true;
					player2.hasWon = true;
				}
			}
		}
		System.out.println(player1.hasWon ? player1.getName() + " has won " : "");
		System.out.println(player2.hasWon ? player2.getName() + " has won " : "");
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
							System.out.println("check ");
							System.out.println(b.ps[i][j]);
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
							System.out.println("check ");
							System.out.println(b.ps[i][j]);
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
		System.out.println("end in chemat " + end.x + " y " + end.y);
		int y = end.y - 1;
		int x3 = x + 3;
		int y3 = y + 3;
		int x2 = x + 2;
		int y2 = y + 2;
		int y1 = y + 1;
		int x1 = x + 1;
		Point dummy = new Point(end.x, end.y); // king coordinates
		if (x >= 0) {
			if (x3 < 8) {
				if (y >= 0) {
					if (y3 < 8) {
						System.out.println("in x3 " + x3 + " y3 " + y3);
						return helper(x, y, x3, y3, dummy, b, p);
					} else if (y2 < 8) {
						System.out.println("in x3y2");
						return helper(x, y, x3, y2, dummy, b, p);
					} else {
						System.out.println("in x3y1");
						return helper(x, y, x3, y1, dummy, b, p);
					}
				}
			} else if (x2 < 8) {
				if (y >= 0) {
					if (y3 < 8) {
						// System.out.println("in x2y3 x " + x +" y "+y + " x2 "
						// +x2+" y3 " + y3 );
						return helper(x, y, x2, y3, dummy, b, p);
					} else if (y2 < 8) {
						System.out.println("in x2y2");
						return helper(x, y, x2, y2, dummy, b, p);
					} else {
						System.out.println("in x2y1");
						return helper(x, y, x2, y1, dummy, b, p);
					}
				}
			} else if (x1 < 8) {
				if (y >= 0) {
					if (y3 < 8) {
						System.out.println("in x1y3 x " + x + " y " + y + " x1 " + x1 + " y3 " + y3);
						return helper(x, y, x1, y3, dummy, b, p);
					} else if (y2 < 8) {
						System.out.println("in x1y2");
						return helper(x, y, x1, y2, dummy, b, p);
					} else {
						System.out.println("in x1y1");
						return helper(x, y, x1, y1, dummy, b, p);
					}
				}
			}
		} else {
			// if (y >= 0) {
			// if (y3 < 8) {
			// System.out.println("in xy3");
			// return helper(x,y,dummy.x,y3,dummy,b,p);
			// } else if (y2 < 8) {
			// System.out.println("in xy2");
			// return helper(x,y,dummy.x,y2,dummy,b,p);
			// } else {
			// System.out.println("in xy1");
			// return helper(x,y,dummy.x,y1,dummy,b,p);
			// }
			// }
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
					System.out.println("pass nullity" + "end x end y " + end.x + " " + end.y);
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
				if (king.getColor().equalsIgnoreCase("white")) {
					// check right side
					if ((beg.y < end.y && b.ps[7][7] instanceof Rook)) {
						System.out.println("in castlingrook  ");
						Rook rook = (Rook) b.ps[7][7];
						if (!rook.hasmoved) {
							System.out.println("in castlingrook not  ");
							for (int i = beg.y + 1; i <= end.y; i++) {
								end.setLocation(beg.x, i);
								if (check(p)) {
									System.out.println("move not allowed");
									return false;
								}
							}
							b.ps[7][6] = b.ps[7][4];
							b.ps[7][4] = null;
							b.ps[7][5] = b.ps[7][7];
							b.ps[7][7] = null;
							return true;
						} else {
							System.out.println("move not allowed");
							return false;
						}

					} else {
						//lest side
						if (beg.y > end.y && b.ps[7][0] instanceof Rook) {
							Rook rook = (Rook) b.ps[7][0];
							if (!rook.hasmoved) {
								for (int i = beg.y - 1; i <= end.y; i--) {
									end.setLocation(beg.x, i);
									if (check(p)) {
										System.out.println("move not allowed");
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
								// System.out.println("move not allowed");
							}
						}
					}
				} else {
					// right side
					if ((beg.y < end.y && b.ps[0][7] instanceof Rook)) {
						System.out.println("in castlingrook  ");
						Rook rook = (Rook) b.ps[0][7];
						if (!rook.hasmoved) {
							System.out.println("in castlingrook not  ");
							for (int i = beg.y + 1; i <= end.y; i++) {
								end.setLocation(beg.x, i);
								if (check(p)) {
									System.out.println("move not allowed");
									return false;
								}
							}
							b.ps[0][6] = b.ps[0][4];
							b.ps[0][4] = null;
							b.ps[0][5] = b.ps[0][7];
							b.ps[0][7] = null;
							return true;
						} else {
							System.out.println("move not allowed");
							return false;
						}

					} else {
						// left side
						if (beg.y > end.y && b.ps[0][0] instanceof Rook) {
							Rook rook = (Rook) b.ps[0][0];
							if (!rook.hasmoved) {
								for (int i = beg.y - 1; i <= end.y; i--) {
									end.setLocation(beg.x, i);
									if (check(p)) {
										System.out.println("move not allowed");
										return false;
									}
								}
								b.ps[0][2] = b.ps[0][4];
								b.ps[0][4] = null;
								b.ps[0][3] = b.ps[0][0];
								b.ps[0][0] = null;
								return true;
							} else {
								System.out.println("move not allowed");
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