package view;

import manager.ElementManager;
import model.element.Element;

public interface WorldView {
	Grid getGrid();

	ElementManager getManager();

	void eat(Element element, Vector from, Direction to);

	void move(Element element, Vector from, Direction to);

	void reproduce(Element element, Vector from, Direction to);

	int getTick();
}
