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
		if(beg.x != end.x && beg.y != end.y)
			return false;
		if(beg.x == end.x && beg.y == end.y)
			return false;
		String c = b.ps[beg.x][beg.y].getColor();
		if(beg.x == end.x){
			for(int i = beg.y; i <= end.y; i++){
				if(b.ps[beg.x][i] != null){
					if(!(b.ps[beg.x][i].getColor().equals(c)) && i == end.y) {
						return true;
					}else {
						//return false;
					}
				}
			}
			return true;
		} else {
			for(int i = beg.x; i <= end.x; i++){
				if(b.ps[i][beg.y] != null){
					if(!(b.ps[i][beg.y].getColor().equals(c)) && i == end.x) {
						return true;
					}else {
						return true;
					}
				}
			}
		}
		return false;
	}
}