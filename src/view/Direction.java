package view;

public class Direction {
	private int x;
	private int y;

	public Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Vector toVector() {
		return new Vector(x, y);
	}
}