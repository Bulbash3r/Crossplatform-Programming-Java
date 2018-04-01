import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double a[] = new double[n];
        double b[] = new double[n];
        double b_all=0;


        for (int i=0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            b_all+=b[i];
        }
        double result=0;

        for (int i=0; i<n; i++) {
            result = (a[i]/(100-a[i]))*(b[i]/b_all);
            System.out.println(result);
        }
    }
}
