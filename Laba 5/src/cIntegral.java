public class cIntegral {
    public static void main(String[] args) {

        double a = 1;
        double b = 2;
        double result = 0;
        double DeltaX = 0.02;

        for (; a<=b; a+=DeltaX) {
            result += Integral.integral(DeltaX, a, b);
        }
        System.out.println(result);
    }
}
