package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import model.element.Element;
import model.element.ElementType;

public class SimpleImageLoader implements ImageLoader {

    private final Map<ElementType, Image> images = new HashMap<>();

    public SimpleImageLoader() throws Exception {
        loadImage(ElementType.PLANT, "res/plant2.jpg");
        loadImage(ElementType.HERBIVOROUS, "res/herbiv2.jpg");
        loadImage(ElementType.SPACE,"res/space1.png");
        loadImage(ElementType.WALL, "res/wall1.jpg");
        loadImage(ElementType.PREDATOR, "res/predator2.jpg");
        loadImage(ElementType.SUPER_PREDATOR, "res/superpred1.jpg");
        loadImage(ElementType.BIRD, "res/bird.jpg");
    }

    private void loadImage(ElementType type, String path) throws IOException {
        FileInputStream input = new FileInputStream(path);
        Image image = new Image(input);
        input.close();
        images.put(type, image);
    }

    @Override
    public Image load(ElementType e) {
        return images.get(e);
    }

    @Override
    public Image load(Element e) {
        return images.get(e.getElementType());
    }

}
