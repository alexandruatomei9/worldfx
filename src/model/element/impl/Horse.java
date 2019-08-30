package model.element.impl;

import model.action.Action;
import model.behavior.ActionChooser;
import model.behavior.ActionValidator;
import model.behavior.View;
import model.element.ElementType;
import model.element.SimpleElement;
import view.Direction;
import view.StandardDirections;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Horse extends SimpleElement {
	private static final List<Direction> horseDirections = Arrays.asList(StandardDirections.horseDirections());

	public Horse(int life, View view, int tick, ActionChooser chooser, ActionValidator validator) {
		super(life, view, tick, chooser, validator);
	}

	@Override
	public ElementType getElementType() {
		return ElementType.HORSE;
	}

	@Override
	public List<Direction> possibleDirections(ElementType element) {
		return element == ElementType.SPACE ? horseDirections : defaultDirections;
	}

	@Override
	public Set<ElementType> consumes() {
		return Herbivorous.consumes;
	}

	@Override
	public Set<Action> possibleActions() {
		return Herbivorous.actions;
	}

}
