package pieces;

import java.awt.Point;

import model.AbstractPiece;
import view.Board;

public class Pawn extends AbstractPiece {
	boolean firstmove = true;
	/**
	 * @param piecename
	 * @param color
	 */
	public Pawn(String piecename, String color) {
		super(piecename, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		//isMoveAllowed();
		
	}

	@Override
	public boolean isMoveAllowed(Point beg, Point end, Board b) {
		if(firstmove){
	//		b.ps[end.x][end.y] = b.ps[beg.x][beg.y];
		//	b.ps[beg.x][beg.y]= null;
		}
		// TODO Auto-generated method stub
		return true;
	}

}