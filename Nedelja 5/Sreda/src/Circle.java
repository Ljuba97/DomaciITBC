public class Circle extends Shape{
    private double r;

    public Circle(String name, double r) {
        super(name);
        if (r > 0)
            this.r = r;
        else
            System.out.println("Radius must be bigger than 0!");
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double circumference() {
        return 2 * r * Math.PI;
    }

    @Override
    public double area() {
        return Math.pow(r, 2) * Math.PI;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
