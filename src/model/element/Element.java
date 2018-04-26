package model.element;

import model.action.Action;
import view.Direction;
import view.Vector;
import view.WorldView;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface Element {
	public ElementType getElementType();

	public void init(WorldView world, Vector pos);

	public Vector getPosition();

	public void setPosition(Vector vector);

	public UUID getId();

	public Set<ElementType> consumes();

	public WorldView getWorld();

	public boolean isEternal();

	public int getLife();

	Set<Action> possibleActions();

	public Action getLastAction();

	List<Direction> possibleDirections(ElementType element);
}
