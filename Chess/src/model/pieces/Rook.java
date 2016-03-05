package model.pieces;

import java.awt.Point;

import model.AbstractPiece;
import view.Board;

public class Rook extends AbstractPiece {

	/**has rule for rook
	 * @param piecename
	 * @param color
	 */
	public Rook(String piecename, String color) {
		super(piecename, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isMoveAllowed(Point beg, Point end, Board b) {

		// if(b.ps[beg.x][beg.y] == null){
		// System.out.println("illegal move, try again");
		// return false;
		// }

		if (beg.x != end.x && beg.y != end.y) 
			return false;

		if (beg.x == end.x && beg.y == end.y) 
			return false;

		String c = b.ps[beg.x][beg.y].getColor();
		if (beg.x == end.x) {
			if (beg.y < end.y) {
				for (int i = beg.y + 1; i <= end.y; i++) {
					if (b.ps[beg.x][i] != null) {
						if (!(b.ps[beg.x][i].getColor().equalsIgnoreCase(c))) {
							if (i == end.y) {
								return true;
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				}
				return true;
			} else {
				for (int i = beg.y - 1; i >= end.y; i--) {
					if (b.ps[beg.x][i] != null) {
						if (!(b.ps[beg.x][i].getColor().equalsIgnoreCase(c))) {
							if (i == end.y) {
								return true;
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				}
				return true;
			}
		} else {
			if (beg.x < end.x) {
				for (int i = beg.x + 1; i <= end.x; i++) {
					if (b.ps[i][beg.y] != null) {
						if (!(b.ps[i][beg.y].getColor().equalsIgnoreCase(c))) {
							if (i == end.x) {
								return true;
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				}
				return true;
			} else {
				for (int i = beg.x - 1; i >= end.x; i--) {
					if (b.ps[i][beg.y] != null) {
						if (!(b.ps[i][beg.y].getColor().equalsIgnoreCase(c))) {
							if (i == end.x) {
								return true;
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				}
				return true;
			}
		}
	}
}