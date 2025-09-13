import java.util.Scanner;

// Step 1: Define the interface
interface Polygon {
    double area();
    double perimeter();
}

// Step 2: Implement a base class for a specific shape
class Quadrilateral implements Polygon {
    // What attributes do all quadrilaterals have?
    // In this simple model we won’t define attributes here.

    @Override
    public double area() {
        // To be implemented by subclasses
        return 0;
    }

    @Override
    public double perimeter() {
        // To be implemented by subclasses
        return 0;
    }
}

// Step 3: Create a subclass using inheritance
class Rectangle extends Quadrilateral {
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

// Step 4: Create a more specific subclass
class Square extends Rectangle {
    public Square(double side) {
        // Call the Rectangle constructor with side, side
        super(side, side);
    }
}

// Triangle
class Triangle implements Polygon {
    protected double a,b,c;
    public Triangle(double a, double b, double c) {
        this.a=a; this.b=b; this.c=c;
    }
    @Override
    public double area() {
        double s=(a+b+c)/2.0;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    @Override
    public double perimeter() {
        return a+b+c;
    }
}

// triangle subclasses
class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double side, double base) {
        super(side, side, base);
    }
}
class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double side){
        super(side, side, side);
    }
    @Override
    public double area() {
        return (Math.sqrt(3)/4.0)*a*a;
    }
}

// Base class for regular polygons (Pentagon/Hexagon/Octagon)
class RegularPolygon implements Polygon {
    protected int n; protected double side;
    public RegularPolygon(int n, double side) {
        this.n = n; this.side = side;
    }
    @Override
    public double perimeter() { return n * side; }
    @Override
    public double area() { return (n * side * side) / (4.0 * Math.tan(Math.PI / n)); }
}
class Pentagon extends RegularPolygon {
    public Pentagon(double side){ super(5,side); }
}
class Hexagon extends RegularPolygon {
    public Hexagon(double side){ super(6,side); }
}
class Octagon extends RegularPolygon {
    public Octagon(double side){ super(8,side); }
}

// Main class for user interface
public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCreate a polygon:");
            System.out.println("1) Triangle   2) Rectangle   3) Square   4) Pentagon   5) Hexagon   6) Octagon");
            System.out.print("Choice (or type quit to stop): ");

            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting... Goodbye!");
                break;
            }

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Enter a number from the menu.");
                continue;
            }

            Polygon p = null;
            String label = "";

            try {
                switch (choice) {
                    case 1: {
                        System.out.print("Enter sides a b c: ");
                        double a = scanner.nextDouble(), b = scanner.nextDouble(), c = scanner.nextDouble();
                        scanner.nextLine();
                        if (a==b && b==c) { p = new EquilateralTriangle(a); label="Equilateral Triangle"; }
                        else if (a==b || a==c || b==c) { p = new IsoscelesTriangle(a, c); label="Isosceles Triangle"; }
                        else { p = new Triangle(a,b,c); label="Triangle"; }
                        break;
                    }
                    case 2: {
                        System.out.print("Enter length and width: ");
                        double L = scanner.nextDouble(), W = scanner.nextDouble();
                        scanner.nextLine();
                        p = new Rectangle(L,W);
                        label="Rectangle";
                        break;
                    }
                    case 3: {
                        System.out.print("Enter side: ");
                        double s = scanner.nextDouble();
                        scanner.nextLine();
                        p = new Square(s);
                        label="Square";
                        break;
                    }
                    case 4: {
                        System.out.print("Enter side: ");
                        double s = scanner.nextDouble();
                        scanner.nextLine();
                        p = new Pentagon(s);
                        label="Pentagon";
                        break;
                    }
                    case 5: {
                        System.out.print("Enter side: ");
                        double s = scanner.nextDouble();
                        scanner.nextLine();
                        p = new Hexagon(s);
                        label="Hexagon";
                        break;
                    }
                    case 6: {
                        System.out.print("Enter side: ");
                        double s = scanner.nextDouble();
                        scanner.nextLine();
                        p = new Octagon(s);
                        label="Octagon";
                        break;
                    }
                    default:
                        System.out.println("Invalid choice.");
                }

                if (p != null) {
                    System.out.println("\n" + label);
                    System.out.printf("Perimeter: %.6f%n", p.perimeter());
                    System.out.printf("Area     : %.6f%n", p.area());
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }

            System.out.println("Press Enter to reset or type quit to stop.");
            String again = scanner.nextLine().trim();
            if (again.equalsIgnoreCase("quit")) {
                System.out.println("Exiting... Goodbye!");
                break;
            }
        }
    }
}
