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
		//System.out.println("Beginning Point getx: " + beg.getX());
		//System.out.println("Beginning Point gety: " + beg.getY());
		//System.out.println("Ending Point getx: " + end.getX());
		//System.out.println("Ending Point gety: " + end.getY());

		boolean tf = false;
		if(super.getColor().equalsIgnoreCase("white")){
			//Check if its the first time
			if(firstmove){
				if(end.getX()>=4 && end.getX()<6 && beg.getY()==end.getY()){
					firstmove = false;
					return true;
				} else {
					System.out.println("Illegal move, try again");
					firstmove = true;
					return false;
				}
			} else {
				//System.out.println("Check all the following conditions for White");
				//Check if moving straight
				if (beg.getY()==end.getY()) {
					System.out.println("Its moving straight");
					if(end.getX()==beg.getX()-1){
						return true;
					} else {
						System.out.println("Illegal move, try again");
						return false;
					}
					
				} else {
					System.out.println("Not moving straight");
				}
			}
			
		} else {
			//Its blacks turn:
		}
		return tf;
	}

}