/**
 * @author hassan deep
 *
 */
package model.pieces;

import java.awt.Point;

import model.AbstractPiece;
import view.Board;

public class Rook extends AbstractPiece {

	public boolean hasmoved = false;
	/**Constructor for Rook
	 * @param piecename
	 * @param color
	 */
	public Rook(String piecename, String color) {
		super(piecename, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveAllowed(Point beg, Point end, Board b) {

		if (beg.x != end.x && beg.y != end.y) 
			return false;

		if (beg.x == end.x && beg.y == end.y) 
			return false;

		String c = b.ps[beg.x][beg.y].getColor();
		if (beg.x == end.x) {
			//right side
			if (beg.y < end.y) {
				for (int i = beg.y + 1; i <= end.y; i++) {
					if (b.ps[beg.x][i] != null) {
						if (!(b.ps[beg.x][i].getColor().equalsIgnoreCase(c))) {
							if (i == end.y) {
								hasmoved = true;
								return true;
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				}
				hasmoved = true;
				return true;
			} else {
				//left side
				for (int i = beg.y - 1; i >= end.y; i--) {
					if (b.ps[beg.x][i] != null) {
						if (!(b.ps[beg.x][i].getColor().equalsIgnoreCase(c))) {
							if (i == end.y) {
								hasmoved = true;
								return true;
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				}
				hasmoved = true;
				return true;
			}
		} else {
			//downward with respect to black piece
			if (beg.x < end.x) {
				for (int i = beg.x + 1; i <= end.x; i++) {
					if (b.ps[i][beg.y] != null) {
						if (!(b.ps[i][beg.y].getColor().equalsIgnoreCase(c))) {
							if (i == end.x) {
								hasmoved = true;
								return true;
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				}
				hasmoved = true;
				return true;
			} else {
				//upward with respect to black piece
				for (int i = beg.x - 1; i >= end.x; i--) {
					if (b.ps[i][beg.y] != null) {
						if (!(b.ps[i][beg.y].getColor().equalsIgnoreCase(c))) {
							if (i == end.x) {
								hasmoved = true;
								return true;
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				}
				hasmoved = true;
				return true;
			}
		}
	}
}