package pieces;

import java.awt.Point;

import model.AbstractPiece;
import view.Board;

public class Knight extends AbstractPiece {

	/**
	 * @param piecename
	 * @param color
	 */
	public Knight(String piecename, String color) {
		super(piecename, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isMoveAllowed(Point beg, Point end, Board b) {
		if (beg.x == end.getX() || beg.getY() == end.getY()) {
			System.out.println("Knight moving straight! no no");
			return false;
		} else if ((end.getX()+1==beg.getX() || end.getX()-1==beg.getX()) && 
				(end.getY()-2==beg.getY() ||end.getY()+2==beg.getY())){
			System.out.println("Knight 1 up +2 -2 left right");
			return true;
		} else if ((end.getX()+2==beg.getX() || end.getX()-2==beg.getX()) &&
				(end.getY()-1==beg.getY() ||end.getY()-1==beg.getY())){
			System.out.println("Knight 2 up +1 -1 left right");
			return true;
		} else {
			System.out.println("Knight failed");
			return false;
		}
	}

}