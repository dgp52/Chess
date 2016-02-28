package pieces;

import model.AbstractPiece;

public class Pawn extends AbstractPiece {

	/**
	 * @param piecename
	 * @param color
	 */
	public Pawn(String piecename, String color) {
		super(piecename, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		//isMoveAllowed();
		
	}

}
