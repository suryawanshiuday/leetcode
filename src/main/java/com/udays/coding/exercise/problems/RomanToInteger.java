package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 13
 * Problem statement:
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */

public class RomanToInteger {

    public int romanToInt(String s) {
        //answer
        int sum = 0;

        for(int i=0; i<s.length(); i++){

            //read first char
            String c = ""+s.charAt(i);

            //read second char to see if it is 2 char number like IV vs V
            String nc = "";
            if(i!=s.length()-1){
                nc = ""+s.charAt(i+1);
            }

            //increment i only if its a 2 char number so we evaluated both chars
            boolean incrementi = false;
            //IX or IV
            if(c.equals("I")){
                if(nc.equals("V") || nc.equals("X")){
                    incrementi=true;
                }
            }
            //XL or XC
            else if(c.equals("X")){
                if(nc.equals("L") || nc.equals("C")){
                    incrementi=true;
                }
            }
            //CD or CM
            else if(c.equals("C")){
                if(nc.equals("D") || nc.equals("M")){
                    incrementi=true;
                }
            }

            //2 char number, increment i and join both chars to run through switch case to find the value
            if(incrementi){
                System.out.println("incrementi:"+incrementi);
                i=i+1;
                c=c+nc;
            }

            //answer
            int value = 0;
            switch(c){
                case "I": value=1; break;
                case "IV": value=4; break;
                case "IX": value=9; break;
                case "V": value=5; break;
                case "X": value=10; break;
                case "XL": value=40; break;
                case "XC": value=90; break;
                case "L": value=50; break;
                case "C": value=100; break;
                case "CD": value=400; break;
                case "CM": value=900; break;
                case "D": value=500; break;
                case "M": value=1000; break;
                default: value=0;
            }
            sum+=value;
        }
        return sum;
    }

}
