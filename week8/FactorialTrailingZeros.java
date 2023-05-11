package week8;

import java.math.BigInteger;
import java.util.stream.LongStream;

// https://leetcode.com/problems/factorial-trailing-zeroes/
public class FactorialTrailingZeros {

    /*
    * As trailing zero mean number of 0 => multiply of 10
    * each 10 consist of 5X2 = 10, as there is plenty of 2, so
    * we need to count number of 5. (count = count + n) instead of (count++)
    * because 25 consist itself 2 of 5, 125 itself consist 3 of 5
    * so only ( count ++ ) will not calculate 25 or 125 .....
    * Thats why need to add (count = count + n)
    * */
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 5;
            count = count + n;
        }

        return count;
    }


    public static void main(String[] args) {

        System.out.println(trailingZeroes(30));
    }
}
