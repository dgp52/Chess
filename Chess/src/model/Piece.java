/**Chess Game
 * @author hassan and deep
 *
 */

package model;

import java.awt.Point;

import view.Board;

public interface Piece {
	/**
	 * checks if a given move is allowed or not
	 * @return boolean
	 */
	boolean isMoveAllowed(Point beg, Point end, Board b);
}