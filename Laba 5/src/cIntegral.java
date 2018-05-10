import Scala_objects.Integral;

public class cIntegral {
    public static void main(String[] args) {

        double a = 1;
        double b = 2;
        double deltaX = 0.02;

        double result = Integral.integral(0, deltaX, a, b);
        System.out.println(result);
    }
}
