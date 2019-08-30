package model.element;

import model.action.Action;
import view.Direction;
import view.Vector;
import view.WorldView;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface Element {
	ElementType getElementType();

	void init(WorldView world, Vector pos);

	Vector getPosition();

	void setPosition(Vector vector);

	UUID getId();

	Set<ElementType> consumes();

	WorldView getWorld();

	boolean isEternal();

	int getLife();

	Set<Action> possibleActions();

	Action getLastAction();

	List<Direction> possibleDirections(ElementType element);
}
