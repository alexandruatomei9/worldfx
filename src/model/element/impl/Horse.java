package model.element.impl;

import model.behavior.ActionChooser;
import model.behavior.ActionValidator;
import model.behavior.View;
import model.element.ElementType;
import model.element.SimpleElement;

public class Horse extends SimpleElement {
	public Horse(int life, View view, int tick, ActionChooser chooser, ActionValidator validator) {
		super(life, view, tick, chooser, validator);
	}

	@Override
	public ElementType getElementType() {
		return ElementType.HORSE;
	}
}
