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

		if(super.getColor().equalsIgnoreCase("white")){
			//Check if its the first time
			if(firstmove){
				if(end.getX()>=4 && end.getX()<6 && beg.getY()==end.getY()){
					double d = beg.getX()-end.getX();
					if(d==2.0 && b.ps[beg.x-1][beg.y]==null && b.ps[beg.x-2][beg.y]==null){
						firstmove = false;
						return true;
					}else {
						if(d==1.0 && b.ps[beg.x-1][beg.y]==null){
							firstmove = false;
							return true;
						} else {
							firstmove = true;
							System.out.println("Try again");
							return false;
						}
					}
				} else if(end.getX()>=4 && end.getX()<6 && end.getY()==beg.getY()-1 && end.getX()==beg.getX()-1){
					System.out.println("First time Left is good");
					firstmove = false;
					return true;
				} else if (end.getX()>=4 && end.getX()<6 && end.getY()==beg.getY()+1 && end.getX()==beg.getX()-1) {
					System.out.println("First time right is good");
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
					if(end.getX()==beg.getX()-1 && b.ps[end.x][end.y]==null){
						return true;
					} else {
						System.out.println("Illegal move, try again");
						return false;
					}
					
					//Not moving straight
				} else {
					System.out.println("Not moving straight");
					//Check if moving on null object
					if(b.ps[end.x][end.y]==null){
						System.out.println("Diagonal but null, try again");
						return false;
					} else {
						//check if its diagonal and not something else:
						//Check if left of right
						if(end.getY()<beg.getY()) {
							//Left Side
							if(end.getY()==beg.getY()-1 && end.getX()==beg.getX()-1){
								System.out.println("Left is good");
								return true;
							} else {
								System.out.println("Left is no good");
								return false;
							}
						} else {
							//Right side
							if(end.getY()==beg.getY()+1 && end.getX()==beg.getX()-1){
								System.out.println("Right is good");
								return true;
							} else {
								System.out.println("Right is no good");
								return false;
							}
						}
						
						//System.out.println("Theres something there.");
					}
				}
			}
			
		} else {
			//Its black pawn:
			if(firstmove){
				if(end.getX()<=3 && end.getX()>1 && beg.getY()==end.getY()){
					double dd = end.getX()-beg.getX();
					if(dd==2.0 && b.ps[beg.x+1][beg.y]==null && b.ps[beg.x+2][beg.y]==null){
						firstmove = false;
						return true;
					}else {
						if(dd==1.0 && b.ps[beg.x+1][beg.y]==null){
							firstmove = false;
							return true;
						} else {
							firstmove = true;
							System.out.println("Try again");
							return false;
						}
					}
				} else if(end.getX()<=3 && end.getX()>1 && end.getY()==beg.getY()-1 && end.getX()==beg.getX()+1){
					System.out.println("First time Left is good");
					firstmove = false;
					return true;
				} else if (end.getX()<=3 && end.getX()>1 && end.getY()==beg.getY()+1 && end.getX()==beg.getX()+1) {
					System.out.println("First time right is good");
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
					if(end.getX()==beg.getX()+1 && b.ps[end.x][end.y]==null){
						return true;
					} else {
						System.out.println("Illegal move, try again");
						return false;
					}
					
					//Not moving straight
				} else {
					System.out.println("Not moving straight");
					//Check if moving on null object
					if(b.ps[end.x][end.y]==null){
						System.out.println("Diagonal but null, try again");
						return false;
					} else {
						//check if its diagonal and not something else:
						//Check if left of right
						if(end.getY()<beg.getY()) {
							//Left Side
							if(end.getY()==beg.getY()-1 && end.getX()==beg.getX()+1){
								System.out.println("Left is good");
								return true;
							} else {
								System.out.println("Left is no good");
								return false;
							}
						} else {
							//Right side
							if(end.getY()==beg.getY()+1 && end.getX()==beg.getX()+1){
								System.out.println("Right is good");
								return true;
							} else {
								System.out.println("Right is no good");
								return false;
							}
						}
					}
				}
			}
		}
		//return false;
	}
	
}