package doPosprzatania.kolekcje;

public class GenereticClass {

    public static void main(String[] args) {
        BoxForFigures<Circle> circleBox = new BoxForFigures<Circle>(new Circle());
        System.out.println(circleBox.getElementName());
    }


}

interface Figure {
    String getName();
    int jakisInt();
}

class Circle implements Figure {
    public String getName() {
        return "circle";
    }

    public int jakisInt() {
        return 0;
    }

}

class BoxForFigures<T extends Figure> {
    private T element;

    public BoxForFigures(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public String getElementName() {
        return element.getName();
    }
}