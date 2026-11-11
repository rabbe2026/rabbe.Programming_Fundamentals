/**
 * Task 3: Recursive sum of the digits of a natural number.
 * Example: 1342 -> 1 + 3 + 4 + 2 = 10
 */
public class DigitSum {

    public static int digitSum(int x) {
        if (x < 10) {            // base case: a single digit
            return x;
        }
        return (x % 10) + digitSum(x / 10);  // last digit + sum of the rest
    }

    public static void main(String[] args) {
        System.out.println(digitSum(1342));  // 10
        System.out.println(digitSum(7));     // 7
        System.out.println(digitSum(99999)); // 45
    }
}
