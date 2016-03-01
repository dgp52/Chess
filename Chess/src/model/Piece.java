package model;

import java.awt.Point;

import view.Board;

/**
 * Chess Game
 * @author hassan and deep
 *
 */
public interface Piece {
	/**
	 * needs to be implemented to check if a given move is allowed
	 * @return boolean
	 */
	boolean isMoveAllowed(Point beg, Point end, Board b);
}