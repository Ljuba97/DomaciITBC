public class Rectangle extends Shape{
    private double a, b;

    public Rectangle(String name, double a, double b) {
        super(name);
        if (a > 0 && b > 0) {
            this.a = a;
            this.b = b;
        }
        else
            System.out.println("Sides must be bigger than 0!");
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double circumference() {
        return 2 * a + 2 * b;
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
