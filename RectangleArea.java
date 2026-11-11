/**
 * Task 1: Area of a rectangle.
 *
 * Method overloading is used so that:
 *  - int inputs    -> int result
 *  - double inputs -> double result
 */
public class RectangleArea {

    // Called when both arguments are int
    public static int area(int a, int b) {
        return a * b;
    }

    // Called when both arguments are double
    public static double area(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        int intResult = area(5, 4);              // int version
        double doubleResult = area(5.5, 2.0);    // double version

        System.out.println("Area (int)    : " + intResult);
        System.out.println("Area (double) : " + doubleResult);
    }
}
