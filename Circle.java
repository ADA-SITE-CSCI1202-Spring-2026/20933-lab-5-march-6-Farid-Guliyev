interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

// Part b: Point class implementing Movable
class Point implements Movable {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveUp() {
        y += 1;
    }

    @Override
    public void moveDown() {
        y -= 1;
    }

    @Override
    public void moveLeft() {
        x -= 1;
    }

    @Override
    public void moveRight() {
        x += 1;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// Part d: Circle class implementing Movable
class Circle implements Movable {
    Point center;
    int radius;

    public Circle(int x, int y, int radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public String toString() {
        return "Circle(center=" + center + ", radius=" + radius + ")";
    }
}

// Simple test
public class Main {
    public static void main(String[] args) {
        Point p = new Point(2, 3);
        Circle c = new Circle(5, 5, 3);

        System.out.println("Before moving:");
        System.out.println(p); // (2,3)
        System.out.println(c); // Circle(center=(5,5), radius=3)

        p.moveUp();
        c.moveRight();

        System.out.println("After moving:");
        System.out.println(p); // (2,4)
        System.out.println(c); // Circle(center=(6,5), radius=3)
    }
}