package model;

/**
 * Chess Game
 * @author hassan and deep
 *
 */
public abstract class AbstractPiece implements Piece {
	private final String piecename;
	private final String color;
	
	/**
	 * needs implementation to move the current piece to specified location
	 */
	public abstract void move();
	
	/**
	 * constructor is provided to ease the process for subclasses
	 * @param piecename
	 * @param color
	 */
	public AbstractPiece(String piecename, String color){
		this.piecename = piecename;
		this.color = color;
	}
	
	/**
	 * returns name of the piece as String
	 * @return piecename
	 */
	public String getPiece(){
		return piecename;
	}
	
	/**
	 * returns color of the piece as String
	 * @return color
	 */
	public String getColor() {
		return color;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getPiece();
	}
}