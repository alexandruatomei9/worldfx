package model.element;

/**
 * Defines an element type along with it's associated character
 *
 * @author Softvision
 */
public enum ElementType {
	SPACE(" "),
	WALL("#"),
	HERBIVOROUS("o"),
	PREDATOR("*"),
	SUPER_PREDATOR("@"),
	PLANT("~"),
	BIRD("p"),
	HORSE("h");

	private final String element;

	ElementType(String s) {
		this.element = s;
	}

	public static ElementType of(String type) {
		for (ElementType elementType : ElementType.values()) {
			if (elementType.getElement().equals(type)) {
				return elementType;
			}
		}
		throw new IllegalArgumentException("Invalid character:" + type);
	}

	public String getElement() {
		return element;
	}
}
