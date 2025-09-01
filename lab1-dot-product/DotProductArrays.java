import java.util.Arrays;

public class DotProductArrays {
    public static void main(String[] args) {
        int n = 5;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];


        for (int i = 0; i < n; i++) {
            a[i] = (int)(Math.random() * 10);
            b[i] = (int)(Math.random() * 10);
        }

        for (int i = 0; i < n; i++) {
            c[i] = a[i]*b[i];
        }

        System.out.println("Array a: " + Arrays.toString(a));
        System.out.println("Array b: " + Arrays.toString(b));
        System.out.println("Array c (a[i] * b[i]): " + Arrays.toString(c));

    }
}