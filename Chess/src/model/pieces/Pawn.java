package model.pieces;

import java.awt.Point;

import model.AbstractPiece;
import view.Board;

public class Pawn extends AbstractPiece {
	boolean firstmove = true;
	boolean pawnStartMove = false;

	/**has rule for pawn
	 * @param piecename
	 * @param color
	 */
	public Pawn(String piecename, String color) {
		super(piecename, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		// isMoveAllowed();

	}
	
	public boolean getPawnStartMove(int endX, int endY, Board b){
		if(b.ps[endX][endY] instanceof Pawn){
			Pawn p = (Pawn) b.ps[endX][endY];
			return p.pawnStartMove;
		} else {
			return false;
		}
	}

	@Override
	public boolean isMoveAllowed(Point beg, Point end, Board b) {
		// System.out.println("Beginning Point getx: " + beg.getX());
		// System.out.println("Beginning Point gety: " + beg.getY());
		// System.out.println("Ending Point getx: " + end.getX());
		// System.out.println("Ending Point gety: " + end.getY());

		if (super.getColor().equalsIgnoreCase("white")) {
			// Check if its the first time
			if (firstmove) {
				if (end.getX() >= 4 && end.getX() < 6 && beg.getY() == end.getY()) {
					double d = beg.getX() - end.getX();
					if (d == 2.0 && b.ps[beg.x - 1][beg.y] == null && b.ps[beg.x - 2][beg.y] == null) {
						firstmove = false;
						pawnStartMove = true;
						return true;
					} else {
						if (d == 1.0 && b.ps[beg.x - 1][beg.y] == null) {
							firstmove = false;
							pawnStartMove = false;
							return true;
						} else {
							firstmove = true;
							System.out.println("Try again");
							return false;
						}
					}
				} else if (end.getX() >= 4 && end.getX() < 6 && end.getY() == beg.getY() - 1
						&& end.getX() == beg.getX() - 1 && b.ps[end.x][end.y] != null
						&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("white"))) {
					//System.out.println("First time Left is good");
					pawnStartMove = false;
					firstmove = false;
					return true;
				} else if (end.getX() >= 4 && end.getX() < 6 && end.getY() == beg.getY() + 1
						&& end.getX() == beg.getX() - 1 && b.ps[end.x][end.y] != null
						&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("white"))) {
					//System.out.println("First time right is good");
					pawnStartMove = false;
					firstmove = false;
					return true;
				} else {
					firstmove = true;
					return false;
				}
			} else {
				// System.out.println("Check all the following conditions for
				// White");
				// Check if moving straight
				if (beg.getY() == end.getY()) {
					//System.out.println("Its moving straight");
					if (end.getX() == beg.getX() - 1 && b.ps[end.x][end.y] == null) {
						return true;
					} else {
						return false;
					}

					// Not moving straight
				} else {
					//System.out.println("Not moving straight");
					// Check if moving on null object
					if (b.ps[end.x][end.y] == null) {
						//System.out.println("Diagonal but null, try again");
						if(b.ps[end.x+1][end.y].getColor().equalsIgnoreCase("black") &&
								getPawnStartMove(end.x+1,end.y,b) && 
								((end.x+1==beg.x && end.y-1==beg.y) || (end.x+1==beg.x&& end.y+1==beg.y))){
							b.ps[end.x+1][end.y]=null;
							System.out.println("En passant");
							return true;
						} else {
							return false;
						}
											
					} else {
						// check if its diagonal and not something else:
						// Check if left of right
						if (end.getY() < beg.getY()) {
							// Left Side
							if (end.getY() == beg.getY() - 1 && end.getX() == beg.getX() - 1
									&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("white"))) {
								//System.out.println("Left is good");
								return true;
							} else {
								//System.out.println("Left is no good");
								return false;
							}
						} else {
							// Right side
							if (end.getY() == beg.getY() + 1 && end.getX() == beg.getX() - 1
									&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("white"))) {
								//System.out.println("Right is good");
								return true;
							} else {
								//System.out.println("Right is no good");
								return false;
							}
						}

						// System.out.println("Theres something there.");
					}
				}
			}

		} else {
			// Its black pawn:
			if (firstmove) {
				if (end.getX() <= 3 && end.getX() > 1 && beg.getY() == end.getY()) {
					double dd = end.getX() - beg.getX();
					if (dd == 2.0 && b.ps[beg.x + 1][beg.y] == null && b.ps[beg.x + 2][beg.y] == null) {
						firstmove = false;
						pawnStartMove = true;
						return true;
					} else {
						if (dd == 1.0 && b.ps[beg.x + 1][beg.y] == null) {
							firstmove = false;
							pawnStartMove = false;
							return true;
						} else {
							firstmove = true;
							System.out.println("Try again");
							return false;
						}
					}
				} else if (end.getX() <= 3 && end.getX() > 1 && end.getY() == beg.getY() - 1
						&& end.getX() == beg.getX() + 1 && b.ps[end.x][end.y] != null
						&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("black"))) {
					//System.out.println("First time Left is good");
					pawnStartMove = false;
					firstmove = false;
					return true;
				} else if (end.getX() <= 3 && end.getX() > 1 && end.getY() == beg.getY() + 1
						&& end.getX() == beg.getX() + 1 && b.ps[end.x][end.y] != null
						&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("black"))) {
					//System.out.println("First time right is good");
					pawnStartMove = false;
					firstmove = false;
					return true;
				} else {
					firstmove = true;
					return false;
				}
			} else {
				// System.out.println("Check all the following conditions for
				// White");
				// Check if moving straight
				if (beg.getY() == end.getY()) {
					//System.out.println("Its moving straight");
					if (end.getX() == beg.getX() + 1 && b.ps[end.x][end.y] == null) {
						return true;
					} else {
						return false;
					}

					// Not moving straight
				} else {
					//System.out.println("Not moving straight");
					// Check if moving on null object
					if (b.ps[end.x][end.y] == null) {
						//System.out.println("Diagonal but null, try again");
						//En Passant
						if(b.ps[end.x-1][end.y].getColor().equalsIgnoreCase("white") &&
								getPawnStartMove(end.x-1,end.y,b) && 
								((end.x-1==beg.x && end.y+1==beg.y) || (end.x-1==beg.x&& end.y-1==beg.y))){
							b.ps[end.x-1][end.y]=null;
							System.out.println("En passant");
							return true;
						} else {
							return false;
						}
						
						
					} else {
						// check if its diagonal and not something else:
						// Check if left of right
						if (end.getY() < beg.getY()) {
							// Left Side
							if (end.getY() == beg.getY() - 1 && end.getX() == beg.getX() + 1
									&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("black")) ) {
								//System.out.println("Left is good");
								return true;
							} else {
								//System.out.println("Left is no good");
								return false;
							}
						} else {
							// Right side
							if (end.getY() == beg.getY() + 1 && end.getX() == beg.getX() + 1
									&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("black"))) {
								//System.out.println("Right is good");
								return true;
							} else {
								//System.out.println("Right is no good");
								return false;
							}
						}
					}
				}
			}
		}
		// return false;
	}

}