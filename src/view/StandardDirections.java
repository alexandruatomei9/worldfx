package view;

public final class StandardDirections {
	//N(0, 1), NE(1, 1), E(1, 0), SE(1, -1), S(0, -1), SW(-1, -1), W(-1, 0), NW(-1, 1);
	public static final Direction N = new Direction(0, 1);
	public static final Direction NE = new Direction(1, 1);
	public static final Direction E = new Direction(1, 0);
	public static final Direction SE = new Direction(1, -1);
	public static final Direction S = new Direction(0, -1);
	public static final Direction SW = new Direction(-1, -1);
	public static final Direction W = new Direction(-1, 0);
	public static final Direction NW = new Direction(-1, 1);

	public static Direction[] defaultDirections() {
		return new Direction[]{N, NE, E, SE, S, SW, W, NW};
	}

	/*
	HORSE1(-2, -1),
	HORSE2(-2, 1),
	HORSE3(-1, -2),
	HORSE4(-1, 2),
	HORSE5(1, -2),
	HORSE6(1, 2),
	HORSE7(2, -1),
	HORSE8(2, 1);
	 */

	public static final Direction HORSE1 = new Direction(-2, -1);
	public static final Direction HORSE2 = new Direction(-2, 1);
	public static final Direction HORSE3 = new Direction(-1, -2);
	public static final Direction HORSE4 = new Direction(-1, 2);
	public static final Direction HORSE5 = new Direction(1, -2);
	public static final Direction HORSE6 = new Direction(1, 2);
	public static final Direction HORSE7 = new Direction(2, -1);
	public static final Direction HORSE8 = new Direction(2, 1);

	public static Direction[] horseDirections() {
		return new Direction[]{HORSE1, HORSE2, HORSE3, HORSE4, HORSE5, HORSE6, HORSE7, HORSE8};
	}

	private StandardDirections() {}
}
