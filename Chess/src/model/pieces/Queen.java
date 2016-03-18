/**Chess Game
 * @author hassan and deep
 *
 */

package model.pieces;

import java.awt.Point;

import model.AbstractPiece;
import view.Board;

public class Queen extends AbstractPiece {
	
	private Rook r = new Rook(super.getPiece(), super.getColor());
	private Bishop bs = new Bishop(super.getPiece(), super.getColor());

	/**Constructor for Queen
	 * @param piecename
	 * @param color
	 */
	public Queen(String piecename, String color) {
		super(piecename, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveAllowed(Point beg, Point end, Board b) {
		if(beg.x == end.x && beg.y == end.y)
			return false;
		if(r.isMoveAllowed(beg, end, b) || bs.isMoveAllowed(beg, end, b)){
			return true;
		}else {
			return false;
		}
	}

}