public class Square extends Rectangle{

    public Square(String name, double a, double b) {
        super(name, a, b);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double circumference() {
        if (getA() == getB())
            return super.circumference();
        else {
            System.out.println("Square must have equal sides!");
            return -1;
        }
    }

    @Override
    public double area() {
        if (getA() == getB())
            return super.area();
        else {
            System.out.println("Square must have equal sides!");
            return -1;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
