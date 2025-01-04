package Microsoft.Day1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class PalindromeSubSequences {

    public static void main(String[] args) {
        PalindromeSubSequences obj=new PalindromeSubSequences();
        // Test cases
        String test1 = "abca";
        String test2 = "aabaa";
        String test3 = "abc";
        String test4 = "aaa";

        // Call the method and print the results
        System.out.println("Input: " + test1 + " | Count: " + obj.countPalindromeSubSequences(test1));
        System.out.println("Input: " + test2 + " | Count: " + obj.countPalindromeSubSequences(test2));
        System.out.println("Input: " + test3 + " | Count: " + obj.countPalindromeSubSequences(test3));
        System.out.println("Input: " + test4 + " | Count: " + obj.countPalindromeSubSequences(test4));
    }

    public int countPalindromeSubSequences(String s){
        int n = s.length();
        Map<Character, int[]> firstLast = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!firstLast.containsKey(c)) {
                firstLast.put(c, new int[]{i, i});
            } else {
                firstLast.get(c)[1] = i;
            }
        }
        int count = 0;
        for (Map.Entry<Character, int[]> entry : firstLast.entrySet()) {
            int[] range = entry.getValue();
            if (range[0] == range[1]) continue;

            HashSet<Character> uniqueChars = new HashSet<>();
            for (int i = range[0] + 1; i < range[1]; i++) {
                uniqueChars.add(s.charAt(i));
            }
            count += uniqueChars.size();
        }
        return count;
    }

}
