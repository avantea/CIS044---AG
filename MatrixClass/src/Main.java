public class Main {
    public static void main(String[] args) {
        // Create two 2x2 matrices
        Matrix m1 = new Matrix(2, 2);
        Matrix m2 = new Matrix(2, 2);

        m1.populateRandom();
        m2.populateRandom();

        System.out.println("Matrix m1:");
        System.out.println(m1);
        System.out.println("Matrix m2:");
        System.out.println(m2);

        // Add
        try {
            Matrix sum = m1.add(m2);
            System.out.println("m1 + m2:");
            System.out.println(sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Multiply (2x2 * 2x2 works)
        try {
            Matrix product = m1.multiply(m2);
            System.out.println("m1 * m2:");
            System.out.println(product);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Example of exception
        Matrix bad = new Matrix(3, 3);
        try {
            m1.add(bad); // wrong size
        } catch (IllegalArgumentException e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}
