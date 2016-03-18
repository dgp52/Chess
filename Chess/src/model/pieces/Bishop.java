/**Chess Game
 * @author hassan and deep
 *
 */

package model.pieces;

import java.awt.Point;

import model.AbstractPiece;
import view.Board;

public class Bishop extends AbstractPiece {

	/**Constructor for Bishop
	 * @param piecename
	 * @param color
	 */
	public Bishop(String piecename, String color) {
		super(piecename, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveAllowed(Point beg, Point end, Board b) {
		int dif = Math.abs(beg.x - end.x);
		int n = Math.abs(beg.y - end.y);

		if(beg.x == end.x && beg.y == end.y)
			return false;
		if (dif != n)
			return false;

		String c = b.ps[beg.x][beg.y].getColor();
		if (beg.x > end.x) {
			if (beg.y < end.y) {
				for (int i = 1; i <= dif; i++) {
					if (b.ps[beg.x - i][beg.y + i] != null) {
						if (!(b.ps[beg.x - i][beg.y + i].getColor().equalsIgnoreCase(c))) {
							if (beg.x - i == end.x && beg.y + i == end.y) {
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
				for (int i = 1; i <= dif; i++) {
					if (b.ps[beg.x - i][beg.y - i] != null) {
						if (!(b.ps[beg.x - i][beg.y - i].getColor().equalsIgnoreCase(c))) {
							if (beg.x - i == end.x && beg.y - i == end.y) {
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
			if (beg.y < end.y) {
				for (int i = 1; i <= dif; i++) {
					if (b.ps[beg.x + i][beg.y + i] != null) {
						if (!(b.ps[beg.x + i][beg.y + i].getColor().equalsIgnoreCase(c))) {
							if (beg.x + i == end.x && beg.y + i == end.y) {
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
				for (int i = 1; i <= dif; i++) {
					if (b.ps[beg.x + i][beg.y - i] != null) {
						if (!(b.ps[beg.x + i][beg.y - i].getColor().equalsIgnoreCase(c))) {
							if (beg.x + i == end.x && beg.y - i == end.y) {
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