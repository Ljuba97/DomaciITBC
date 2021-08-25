public class Triangle extends Shape{
    private double a, b, c;

    public Triangle(String name, double a, double b, double c) {
        super(name);
        if (a > 0 && b > 0 && c > 0) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else
            System.out.println("Sides must be bigger than 0!");
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double circumference() {
        return a + b + c;
    }

    @Override
    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
