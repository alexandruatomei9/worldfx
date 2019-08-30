package view;

import javafx.scene.image.Image;
import model.element.Element;
import model.element.ElementType;

public interface ImageLoader {

	Image load(ElementType e);

	Image load(Element e);
}
