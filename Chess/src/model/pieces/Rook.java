/**Chess Game
 * @author hassan and deep
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
	}

	@Override
	public boolean isMoveAllowed(Point beg, Point end, Board b) {

		if (beg.x != end.x && beg.y != end.y) 
			return false;

		if (beg.x == end.x && beg.y == end.y) 
			return false;

		String c = b.ps[beg.x][beg.y].getColor();
		if (beg.x == end.x) {
			if (beg.y < end.y) {
				//left side
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
				//right side
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
			if (beg.x < end.x) {
				//upward with respect to white
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
				//downward with respect to white
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