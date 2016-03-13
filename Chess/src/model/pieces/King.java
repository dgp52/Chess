/**
 * @author hassan and deep
 *
 */
package model.pieces;

import java.awt.Point;

import model.AbstractPiece;
import view.Board;


public class King extends AbstractPiece {

	public boolean hasmoved = false;
	public boolean castle = false;
	private Rook r = new Rook(super.getPiece(), super.getColor());
	private Bishop bs = new Bishop(super.getPiece(), super.getColor());

	/**
	 * Constructor for King
	 * 
	 * @param piecename
	 * @param color
	 */
	public King(String piecename, String color) {
		super(piecename, color);
	}

	@Override
	public boolean isMoveAllowed(Point beg, Point end, Board b) {
		int x = Math.abs(beg.x - end.x);
		int y = Math.abs(beg.y - end.y);

		if (beg.x == end.x && y == 2 && !hasmoved) {
			if (b.ps[beg.x][beg.y].getColor().equalsIgnoreCase("wite")) {
				if (beg.y < end.y) {
					//right side
					if (b.ps[beg.x][beg.y + 1] == null && b.ps[beg.x][beg.y + 2] == null) {
						if (b.ps[7][7] != null && b.ps[7][7] instanceof Rook) {
							Rook k = (Rook) b.ps[7][7];
							if (!k.hasmoved) {
								castle = true;
								return true;
							} else {
								return false;
							}
						}
					}
				} else {
					//left side
					if (b.ps[beg.x][beg.y - 1] == null && b.ps[beg.x][beg.y - 2] == null) {
						if (b.ps[7][0] != null && b.ps[7][0] instanceof Rook) {
							Rook k = (Rook) b.ps[7][0];
							if (!k.hasmoved) {
								castle = true;
								return true;
							} else {
								return false;
							}
						}
					}
				}
			} else {
				//right side for blace piece
				if (beg.y < end.y) {
					if (b.ps[beg.x][beg.y + 1] == null && b.ps[beg.x][beg.y + 2] == null) {
						if (b.ps[0][7] != null && b.ps[0][7] instanceof Rook) {
							Rook k = (Rook) b.ps[0][7];
							if (!k.hasmoved) {
								castle = true;
								return true;
							} else {
								return false;
							}
						}
					}
				} else {
					//left side
					if (b.ps[beg.x][beg.y - 1] == null && b.ps[beg.x][beg.y - 2] == null) {
						if (b.ps[0][0] != null && b.ps[0][0] instanceof Rook) {
							Rook k = (Rook) b.ps[0][0];
							if (!k.hasmoved) {
								castle = true;
								return true;
							} else {
								return false;
							}
						}
					}
				}
			}
		}

		if (x != 1 && y != 1) {
			return false;
		}
		if (r.isMoveAllowed(beg, end, b) || bs.isMoveAllowed(beg, end, b)) {
			hasmoved = true;
			return true;
		} else {
			return false;
		}
	}

}