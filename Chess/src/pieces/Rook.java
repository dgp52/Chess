package pieces;

import java.awt.Point;

import model.AbstractPiece;
import view.Board;

public class Rook extends AbstractPiece {

	/**
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
		// TODO Auto-generated method stub
		return false;
	}

}