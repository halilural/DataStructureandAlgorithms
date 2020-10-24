package com.uralhalil.dsa;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // Length of the Last Word in the String
        System.out.println("'Hello World' last word's length is " + lengthOfLastWord("Hello World"));
        System.out.println("'Hello World   ' last word's length is " + lengthOfLastWord("Hello World   "));
        System.out.println("'Hello World I am going to Space !' last word's length is " + lengthOfLastWord("Hello World I am going to Space !"));

        // Reverse String with Stack

        char[] characters = {'H', 'E', 'L', 'L', 'O'};
        reverseStringwithStack(characters); // Output is "OLLEH"
        reverseString(characters); // Output is "HELLO"

        // Longest Common Prefix
        System.out.println(longestCommonPrefix(new String[]{"Hello", "Hello123", "Hello1234"}));

        // Majority Element

        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{1, 2, 3}));
        System.out.println(majorityElement(new int[]{1, 2, 3, 4}));
        System.out.println(majorityElement(new int[]{1, 2, 2, 4}));
        System.out.println(majorityElement(new int[]{2, 2, 2, 4}));

    }

      /*

        ** Length of the Last Word in the String **

       Given a string s consists of upper/lower case alphabets and empty
    space characters ' ', return the length of the last word in the string.
     */

    public static int lengthOfLastWord(String s) {

        // Space Complexity  S = O(1)
        /* Time Complexity, T = O(n), because we are iterating the length of string, and if it increases,
         The runtime working time in milliseconds will also increase.
         * */

        int count = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) != ' ') {
                count++;
                i++;
            } else {
                while (i < n && s.charAt(i) == ' ') i++;
                if (i == n) {
                    return count;
                } else {
                    count = 0;
                }
            }
        }
        return count;
    }

    /*

     ** Reverse String with **

    Write a function that reverses a string. The input string is given as an array of characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.

     */

    // It is allocated with stack, we used extra memory for this stack, that's why wrong answer.
    static void reverseStringwithStack(char[] s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            //pushing every character inside stack
            st.push(s[i]);
        }
        //pop every character
        for (int i = 0; i < s.length; i++) {
            s[i] = st.peek();
            st.pop();
        }
    }

    // It is not allocated extra memory, that's why this is the correct answer, O(1)
    static void reverseString(char[] s) {
        // Space Complexity  S = O(1)
        /* Time Complexity, T = O(n), because we are iterating the length of string, and if it increases,
         The runtime working time in milliseconds will also increase.
         * */
        int f = 0;
        int e = s.length - 1;
        char temp;
        while (f <= e) {
            temp = s[f];
            s[f] = s[e];
            s[e] = temp;
            f++;
            e--;
        }
    }

     /*

     ** Longest Common Prefix **

    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

      */

    static String longestCommonPrefix(String[] strs) {

        // Time Complexity T = O(mn)
        // m = length of the smallest string
        // n is length of the strs's array size
        // Space Complexity
        // Space taken is ans string, that's why the space complexity is big of m.
        // s = O(m).

        String ans = "";
        int minLength;
        String minString = "";
        // find minimum string
        if (strs.length == 0) {
            return "";
        }
        minLength = strs[0].length();
        minString = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (minLength > strs[i].length()) {
                minString = strs[i];
                minLength = strs[i].length();
            }
        }
        // find longest Common Prefix
        for (int i = 0; i < minString.length(); i++) {
            for (int k = 0; k < strs.length; k++) {
                if (minString.charAt(i) != strs[k].charAt(i)) {
                    return ans;
                }
            }
            ans += minString.charAt(i);
        }
        return ans;
    }

    // Find Majority Element

    static int majorityElement(int[] nums) {
        // Time Complexity, we are iterating over the array, that's why it is T = O(n)
        // Space Complexity,  S= O(1), we are not using any array or space-taken variables in this algorithm.
        if (nums.length == 0) {
            return -1;
        }
        int cand = nums[0];
        int count = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == cand) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    cand = nums[i];
                    count = 1;
                }
            }
        }
        // we can not assume, so we check
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == cand) {
                count2++;
            }
        }
        if (count2 > n / 2) return cand;
        else return -1;
    }

}
