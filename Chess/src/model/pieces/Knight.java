/**Chess Game
 * @author hassan and deep
 *
 */

package model.pieces;

import java.awt.Point;

import model.AbstractPiece;
import view.Board;

public class Knight extends AbstractPiece {

	/**Constructor for Knight
	 * @param piecename
	 * @param color
	 */
	public Knight(String piecename, String color) {
		super(piecename, color);
		// TODO Auto-generated constructor stub
	}

	/**check if the Knight move is allowed or not
	 * @param beg
	 * @param end
	 * @param b
	 * @return boolean
	 */
	@Override
	public boolean isMoveAllowed(Point beg, Point end, Board b) {
		if (beg.x == end.x || beg.y == end.y) {
			return false;
		} else if ((end.x+1==beg.x || end.x-1==beg.x) && 
				(end.y-2==beg.y ||end.y+2==beg.y) && (b.ps[end.x][end.y]==null ||
						!(b.ps[end.x][end.y].getColor().equals(b.ps[beg.x][beg.y].getColor())))){
			return true;
		} else if ((end.x+2==beg.x || end.x-2==beg.x) &&
				(end.y-1==beg.y ||end.y+1==beg.y) && (b.ps[end.x][end.y]==null || 
				!(b.ps[end.x][end.y].getColor().equals(b.ps[beg.x][beg.y].getColor())))){
			return true;
		} else {
			return false;
		}
	}

}