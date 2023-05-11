package week1;

import java.util.Arrays;
import java.util.Collections;

/*https://leetcode.com/problems/single-number/*/
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int number: nums) {
            xor = number ^ xor;
        }
        return xor;
    }

    public static void main(String[] args) {

        System.out.println(singleNumber((new int[]{1,2,1}))); // output 1
        System.out.println(singleNumber((new int[]{4,1,2,1,2, 3, 3}))); // output 4
        System.out.println(singleNumber((new int[]{1}))); // output 1
    }
}
