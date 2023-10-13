import java.lang.Math;


public class LabOne {
    static double powrt(double num, int power) {
        if ((num < 0) && (power % 2 != 0)) {
            return -Math.pow(Math.abs(num), 1.0 / power);
        } else {
            return Math.pow(num, 1.0 / power);
        }
    }

    public static void main(String[] arr) {
        long[] a = new long[7];
        for (long i = 0; i < 7; i++) {
            a[(int) i] = i * 2 + 6;
        }
        double[] x = new double[10];
        for (int i = 0; i < 10; i++) {
            x[i] = Math.random() * 17 - 11;
        }
        double[][] twoDimArr = new double[7][10];
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 10; j++) {
                if (a[i] == 6) {
                    twoDimArr[i][j] = Math.tan(Math.pow(Math.cos(x[j]), (1.0 / 3.0 + Math.pow(Math.E, x[j])) / (powrt(x[j], 3))));
                } else if (a[i] == 8 || a[i] == 10 || a[i] == 18) {
                    twoDimArr[i][j] = Math.tan(Math.tan(Math.pow(2 * x[j], 2)));
                } else {
                    twoDimArr[i][j] = Math.cos(Math.atan(Math.pow(Math.E, powrt(-Math.pow(2 * Math.PI * Math.abs(x[j]), x[j]), 3))));
                }
            }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(String.format("%.4f\t", twoDimArr[i][j]));
            }
            System.out.println();
        }
    }
}
