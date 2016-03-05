package model.pieces;

import java.awt.Point;

import model.AbstractPiece;
import view.Board;

public class King extends AbstractPiece {
	
	private Rook r = new Rook(super.getPiece(), super.getColor());
	private Bishop bs = new Bishop(super.getPiece(), super.getColor());
	
	/**
	 * @param piecename
	 * @param color
	 */
	public King(String piecename, String color){
		super(piecename, color);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isMoveAllowed(Point beg, Point end, Board b) {
		int x = Math.abs(beg.x - end.x);
		int y = Math.abs(beg.y - end.y);
		if(x != 1 && y != 1){
			return false;
		}
		if(r.isMoveAllowed(beg, end, b) || bs.isMoveAllowed(beg, end, b)){
			return true;
		}else {
			return false;
		}
	}

}