package model.behavior;

import model.element.Element;
import model.element.ElementType;
import util.Util;
import view.Direction;
import view.Grid;
import view.Vector;
import view.WorldView;

import java.util.*;

public class SimpleView implements View {

	private static List<Direction> elementPossibleDirections(WorldView world, Vector position, ElementType element) {
		Element currentElement = world.getGrid().getGridContent(position);
		return new ArrayList<>(currentElement.possibleDirections(element));
	}

	private static boolean isValidForChoosing(WorldView world, Vector currentPosition, ElementType element) {
		Grid grid = world.getGrid();
		return grid.isInside(currentPosition) && grid.getGridContent(currentPosition).getElementType() == element;
	}

	@Override
	public Optional<Direction> find(WorldView world, Vector position, ElementType element) {
		List<Direction> directions = elementPossibleDirections(world, position, element);
		Collections.shuffle(directions);

		for (Direction direction : directions) {
			Vector v = direction.toVector();
			if (isValidForChoosing(world, position.plus(v), element)) {
				return Optional.of(direction);
			}
		}
		return Optional.empty();
	}


	@Override
	public Set<Direction> findAll(WorldView world, Vector position, ElementType element) {
		Set<Direction> possibleDirections = new HashSet<>();
		for (Direction direction : elementPossibleDirections(world, position, element)) {
			Vector v = direction.toVector();
			if (isValidForChoosing(world, position.plus(v), element)) {
				possibleDirections.add(direction);
			}
		}
		return possibleDirections;
	}

	@Override
	public Optional<Direction> find(WorldView world, Vector position, Set<ElementType> elements) {
		Iterator<ElementType> iterator = elements.iterator();
		Optional<Direction> direction = Optional.empty();
		while (iterator.hasNext()) {
			direction = find(world, position, iterator.next());
			if (direction.isPresent()) {
				return direction;
			}
		}
		return direction;
	}


	@Override
	public Optional<Direction> findRandom(WorldView world, Vector position, ElementType element) {
		List<Direction> possibleDirections = elementPossibleDirections(world, position, element);
		Direction direction = possibleDirections.get(Util.randomInRange(0, possibleDirections.size()));
		Vector v = direction.toVector();
		if (isValidForChoosing(world, position.plus(v), element)) {
			return Optional.of(direction);
		}
		return Optional.empty();
	}

}
