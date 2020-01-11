package Design.Facade;

interface Shape {
    void draw();
}
class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
class ShapeMaker {
    private Shape circle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawSquare();
    }
}
