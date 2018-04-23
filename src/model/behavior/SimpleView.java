package model.behavior;

import model.element.ElementType;
import util.Util;
import view.Direction;
import view.Vector;
import view.WorldView;

import java.util.*;

public class SimpleView implements View {

	@Override
	public Optional<Direction> find(WorldView world, Vector position, ElementType element) {
		List<Direction> directions = Arrays.asList(Direction.values());
		Collections.shuffle(directions);
		for (Direction direction : directions) {
			Vector v = direction.toVector();
			if (world.getGrid().getGridContent(position.plus(v)).getElementType() == element) {
				return Optional.of(direction);
			}
		}
		return Optional.empty();
	}


	@Override
	public Set<Direction> findAll(WorldView world, Vector position, ElementType element) {
		Set<Direction> possibleDirections = new HashSet<>();
		for (Direction direction : Direction.values()) {
			Vector v = direction.toVector();
			if (world.getGrid().getGridContent(position.plus(v)).getElementType() == element) {
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
		int max = Direction.values().length;
		Direction direction = Direction.values()[Util.randomInRange(0, max)];
		Vector v = direction.toVector();
		if (world.getGrid().getGridContent(position.plus(v)).getElementType() == element) {
			return Optional.of(direction);
		}
		return Optional.empty();
	}

}
