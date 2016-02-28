package pieces;

import model.AbstractPiece;

public class King extends AbstractPiece {
	
	/**
	 * @param piecename
	 * @param color
	 */
	public King(String piecename, String color){
		super(piecename, color);
	}
	@Override
	public boolean isMoveAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

}
