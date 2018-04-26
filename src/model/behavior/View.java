package model.behavior;

import model.element.ElementType;
import view.Direction;
import view.Vector;
import view.WorldView;

import java.util.Optional;
import java.util.Set;

public interface View {

	Optional<Direction> find(WorldView world, Vector position, ElementType element);

	Optional<Direction> findRandom(WorldView world, Vector position, ElementType element);

	Optional<Direction> find(WorldView world, Vector position, Set<ElementType> element);

	Set<Direction> findAll(WorldView world, Vector position, ElementType element);

}
