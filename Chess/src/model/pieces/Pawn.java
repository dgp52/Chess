package model.pieces;

import java.awt.Point;

import model.AbstractPiece;
import view.Board;

public class Pawn extends AbstractPiece {
	boolean firstmove = true;
	boolean pawnStartMove = false;

	/**Constructor for Pawn
	 * @param piecename
	 * @param color
	 */
	public Pawn(String piecename, String color) {
		super(piecename, color);
		// TODO Auto-generated constructor stub
	}
	
	/**gets pawn starting move
	 * @param endX
	 * @param endY
	 * @param b
	 * @return boolean
	 */
	public boolean getPawnStartMove(int endX, int endY, Board b){
		if(b.ps[endX][endY] instanceof Pawn){
			Pawn p = (Pawn) b.ps[endX][endY];
			return p.pawnStartMove;
		} else {
			return false;
		}
	}

	/**check if the pawn move is allowed or not
	 * @param beg
	 * @param end
	 * @param b
	 * @return boolean
	 */
	@Override
	public boolean isMoveAllowed(Point beg, Point end, Board b) {
		if (super.getColor().equalsIgnoreCase("white")) {
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
					pawnStartMove = false;
					firstmove = false;
					return true;
				} else if (end.getX() >= 4 && end.getX() < 6 && end.getY() == beg.getY() + 1
						&& end.getX() == beg.getX() - 1 && b.ps[end.x][end.y] != null
						&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("white"))) {
					pawnStartMove = false;
					firstmove = false;
					return true;
				} else {
					firstmove = true;
					return false;
				}
			} else {
				if (beg.getY() == end.getY()) {
					if (end.getX() == beg.getX() - 1 && b.ps[end.x][end.y] == null) {
						return true;
					} else {
						return false;
					}
				} else {
					if (b.ps[end.x][end.y] == null) {
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
						if (end.getY() < beg.getY()) {
							if (end.getY() == beg.getY() - 1 && end.getX() == beg.getX() - 1
									&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("white"))) {
								return true;
							} else {
								return false;
							}
						} else {
							if (end.getY() == beg.getY() + 1 && end.getX() == beg.getX() - 1
									&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("white"))) {
								return true;
							} else {
								return false;
							}
						}
					}
				}
			}

		} else {
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
					pawnStartMove = false;
					firstmove = false;
					return true;
				} else if (end.getX() <= 3 && end.getX() > 1 && end.getY() == beg.getY() + 1
						&& end.getX() == beg.getX() + 1 && b.ps[end.x][end.y] != null
						&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("black"))) {
					pawnStartMove = false;
					firstmove = false;
					return true;
				} else {
					firstmove = true;
					return false;
				}
			} else {
				if (beg.getY() == end.getY()) {
					if (end.getX() == beg.getX() + 1 && b.ps[end.x][end.y] == null) {
						return true;
					} else {
						return false;
					}
				} else {
					if (b.ps[end.x][end.y] == null) {
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
						if (end.getY() < beg.getY()) {
							if (end.getY() == beg.getY() - 1 && end.getX() == beg.getX() + 1
									&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("black")) ) {
								return true;
							} else {
								return false;
							}
						} else {
							if (end.getY() == beg.getY() + 1 && end.getX() == beg.getX() + 1
									&& !(b.ps[end.x][end.y].getColor().equalsIgnoreCase("black"))) {
								return true;
							} else {
								return false;
							}
						}
					}
				}
			}
		}
	}
}