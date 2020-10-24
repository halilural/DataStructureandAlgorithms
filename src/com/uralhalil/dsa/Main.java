package com.uralhalil.dsa;

import java.util.Stack;
import java.util.Vector;

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

        // Fizz Buzz Algorithm
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));

        // Evaluate Pos Notation

        System.out.println(evalPostNotation(new String[]{"2", "3", "4", "+", "*"})); // Infix Notation = ( (3 + 4 ) * 2)
        System.out.println(evalPostNotation(new String[]{"2", "1", "+", "3", "*"})); // Infix Notation = ( (2 + 1) * 3)

        // Palindrome String

        System.out.println(isPalindromeString("abc"));
        System.out.println(isPalindromeString("aba"));
        System.out.println(isPalindromeString("abad"));
        System.out.println(isPalindromeString("ababa"));
        System.out.println(isPalindromeString("ab a ba"));
        System.out.println(isPalindromeString("ab a bA"));

        // Remove all adjacent duplicates from given string
        System.out.println(removeAllAdjacentDuplicates("aab"));
        System.out.println(removeAllAdjacentDuplicates("ababdfdf"));
        System.out.println(removeAllAdjacentDuplicates("Mississippi"));
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

    // Fizz Buzz

    static Vector<String> fizzBuzz(int n) {

        // Time Complexity is T = O(n), because we are iterating the n number and if it increases,
        // the runtime execution time will also increase.
        // Space Complexity is S = O(1), because ans is not taken extra space, we need it for returning Vector<String>.
        // This is basically required.

        Vector<String> ans = new Vector<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }

    // Evaluate Expression Algorithm

    static int evalPostNotation(String[] tokens) {
        // Time Complexity is T = O(n), we are iterationg the array.
        // Space Complexity is S = O(n), we are using stack as an extra memory to calculate return.
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "/" || tokens[i] == "*") {
                // 2 elements pop from the stack and do operations between them using operator
                Integer v1 = st.peek();
                st.pop();
                Integer v2 = st.peek();
                st.pop();
                if (tokens[i] == "+") {
                    st.push(v1 + v2);
                } else if (tokens[i] == "-") {
                    st.push(v1 - v2);
                } else if (tokens[i] == "/") {
                    st.push(v1 / v2);
                } else if (tokens[i] == "*") {
                    st.push(v1 * v2);
                }
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.peek();
    }

    // Excel Sheet Column Number

    // given column title, find column number

    static int findExcelSheetColumnNumber(String title) {
        // TC ->>> T = O(n)
        // SC ->> S = O(1)
        int ans = 0;
        long pow = 1;
        int n = title.length();
        //AAA
        for (int i = n - 1; i >= 0; i--) {
            ans = (int) (ans + 26 * pow);
            pow *= 26;
        }
        return ans;
    }

    // Palindrome String

    // abc's reverse is cba, so this is not palindrome string
    // aba's reverse is aba, so this is a palindrome string


    static boolean isPalindromeString(String word) {
        // Time complexity is a  T = O(n)
        // Space complexity is a S = O(1)
        int start = 0;
        int end = word.length() - 1;

        while (start <= end) {

            // Skipping non digit or alphabetic character in the word

            while (start < end && !Character.isLetterOrDigit(word.charAt(start))) start++;
            while (start < end && !Character.isLetterOrDigit(word.charAt(end))) end--;

            // Converting the character which in index start and end

            if (Character.toUpperCase(word.charAt(start)) != Character.toUpperCase(word.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Valid Palindrome String

    // Given a non-empty string, you may delete at most one character,jusge whether you can make it  a palindrome.

    //For example, you have abca and delete the 'c' character from the given string and you have 'aba' word, so it is palindrome string

    static boolean checkPalindrome(String word, int start, int end) {
        while (start <= end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    static boolean validPalindrome(String word) {
        // T = O(n)
        // S = O(1)
        int start = 0;
        int end = word.length() - 1;

        while (start <= end) {
            if (Character.toUpperCase(word.charAt(start)) != Character.toUpperCase(word.charAt(end))) {
                //2 cases
                //delete s check for word[s+1....e]
                //delete e check for word[s......e-1]
                if (checkPalindrome(word, start + 1, end) || checkPalindrome(word, start, end - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
            start++;
            end--;
        }
        return true;
    }

    // Remove all adjacent duplicates from given word

    // Return string will not contain duplicate characters

    // For instance, the given string is "aab", so the final result is "b",
    // Another example is the given string is "Mississippi", so the final result is "M".

    static String removeAllAdjacentDuplicates(String word) {
        // T = O(n)
        // S = O(n), because we are creating stack to solve the problem.
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            if (st.empty()) {
                st.push(word.charAt(i));
            } else {
                Stack<Character> tempst = (Stack<Character>) st.clone();
                Boolean isFound = false;
                while (!tempst.empty()) {
                    if (tempst.peek() == word.charAt(i)) {
                        st.pop();
                        isFound = true;
                        break;
                    }
                    tempst.pop();
                }
                if (!isFound) st.push(word.charAt(i));
            }
        }
        char[] answer = new char[st.size()];
        int n = st.size();
        for (int i = 0; i < n; i++) {
            answer[i] = st.peek();
            st.pop();
        }
        // Reverse String
        reverseString(answer);
        // Convert char[] to string
        String ans = "";
        for (int i = 0; i < answer.length; i++) {
            ans += answer[i];
        }

        if (ans.length() == 0) {
            return "Empty String";
        }

        return ans;
    }

}
