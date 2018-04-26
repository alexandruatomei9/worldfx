package model.behavior;

import model.action.Action;
import model.element.SimpleElement;
import view.Direction;

import java.util.Optional;

/**
 * Validates a given {@link Action}
 *
 * @author Softvision
 */
public interface ActionValidator {
	Optional<Direction> validateAction(Action action,
									   SimpleElement element,
									   Optional<Direction> actionDirection);
}
