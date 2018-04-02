package model.element;

import java.util.Set;
import java.util.UUID;

import model.action.Action;
import view.Vector;
import view.WorldView;

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
}
