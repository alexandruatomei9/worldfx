package manager;

import model.element.Element;

/**
 * defines an Element Manager
 *
 * @author Softvision
 * @since 31/03/2018
 */
public interface ElementManager {
	/**
	 * Decrements the life of an {@link Element}
	 *
	 * @param element
	 */
	void decrementLife(Element element);

	/**
	 * Increments the life of an {@link Element}
	 *
	 * @param element
	 */
	void incrementLife(Element element);

	/**
	 * Augments the life of an {@link Element} by the specified quantity
	 *
	 * @param element
	 * @param quantity
	 */
	void augmentLifeBy(Element element, int quantity);

	/**
	 * Reduces the life of an {@link Element} by the specified quantity
	 *
	 * @param element
	 * @param quantity
	 */
	void reduceLifeBy(Element element, int quantity);

	/**
	 * Checks if an {@link Element} is still alive
	 *
	 * @param element
	 */
	boolean isAlive(Element element);

	/**
	 * Adds an {@link Element} to the list of managed elements
	 *
	 * @param element
	 */
	void add(Element element);

	/**
	 * Removes an {@link Element} from the list of managed elements
	 *
	 * @param element
	 */
	void remove(Element element);

	/**
	 * Checks wheter an {@link Element} is managed
	 *
	 * @param element
	 * @return
	 */
	boolean isManaged(Element element);

	/**
	 * Gets the remaining life of an {@link Element}
	 *
	 * @param element
	 * @return
	 */
	int getLife(Element element);

	/**
	 * Creates a space {@link Element}. What a space is exactly depends on the concrete implementation,
	 * but conceptually is an {@link Element} that can be overlapped without any consequence on that {@link Element}.
	 *
	 * @return A space {@link Element}
	 */
	Element space();

	/**
	 * Creates a wall {@link Element}. What a wall is exactly depends on the concrete implementation,
	 * but conceptually a wall is an {@link Element} that cannot be surpassed.
	 *
	 * @return A wall {@link Element}
	 */
	Element wall();

	/**
	 * Returns the sum of all elements (except the walls) of the world to which this {@link Element} belongs.
	 *
	 * @param element
	 * @return capacity of the world to which {@link Element} belongs to
	 */
	int getWorldCapacityBy(Element element);

	/**
	 * Returns the number of elements of the same kind as the given {@link Element}.
	 *
	 * @param element
	 * @return
	 */
	int populationCount(Element element);
}