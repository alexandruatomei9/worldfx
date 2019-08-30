package model.element;

import model.action.Action;
import model.action.Actions;
import util.Util;
import view.Direction;
import view.StandardDirections;
import view.Vector;
import view.WorldView;

import java.util.*;

public abstract class AbstractElement implements Element {

	private static final Set<Action> defaultActions = new HashSet<>();
	protected static final List<Direction> defaultDirections = Arrays.asList(StandardDirections.defaultDirections());

	static {
		defaultActions.add(Actions.pause());
	}

	private final int life;
	private final boolean eternal;
	private final UUID id;
	private Vector position;
	private WorldView world;
	private volatile boolean initialized;

	protected AbstractElement(boolean eternal) {
		this(eternal, Integer.MAX_VALUE);
	}

	protected AbstractElement(int life) {
		this(false, life);
	}

	private AbstractElement(boolean eternal, int life) {
		this.life = life;
		this.eternal = eternal;
		this.id = Util.generateRandomUUID();
	}

	protected static Set<Action> defaultActions() {
		return defaultActions;
	}

	@Override
	public final void init(WorldView world, Vector pos) {
		if (initialized) {
			throw new IllegalStateException("World already initialized");
		}
		this.world = world;
		this.position = pos;
		afterInit(world, pos);
	}

	@Override
	public final Vector getPosition() {
		return position;
	}

	@Override
	public final void setPosition(Vector vector) {
		this.position = vector;
	}

	@Override
	public final UUID getId() {
		return id;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other instanceof SimpleElement) {
			return getId().equals(((SimpleElement) other).getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public final WorldView getWorld() {
		return world;
	}

	@Override
	public Set<ElementType> consumes() {
		return Collections.emptySet();
	}

	/**
	 * Hook method
	 *
	 * @param world
	 * @param pos
	 */
	public void afterInit(WorldView world, Vector pos) {

	}

	@Override
	public final boolean isEternal() {
		return eternal;
	}

	@Override
	public final int getLife() {
		return life;
	}

	@Override
	public Set<Action> possibleActions() {
		return Collections.emptySet();
	}

	@Override
	public Action getLastAction() {
		return Actions.pause();
	}

	@Override
	public String toString() {
		return "Element " + getElementType() + " {" + getPosition() + "}";
	}

	@Override
	public List<Direction> possibleDirections(ElementType element) {
		return defaultDirections;
	}
}
