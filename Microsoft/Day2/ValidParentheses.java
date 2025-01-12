package Microsoft.Day2;

public class ValidParentheses {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) {
            return false; // Odd length cannot be balanced
        }

        int opening = 0, closing = 0, wildCard = 0;

        // Left to right pass
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                wildCard++;
            } else if (s.charAt(i) == '(') {
                opening++;
            } else {
                closing++;
            }
            if (wildCard < (closing - opening)) {
                return false;
            }
        }

        opening = closing = wildCard = 0;

        // Right to left pass
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                wildCard++;
            } else if (s.charAt(i) == '(') {
                opening++;
            } else {
                closing++;
            }
            if (wildCard < (opening - closing)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();

        // Test cases
        String s1 = "((()))";
        String locked1 = "111111";
        System.out.println("Test Case 1: " + vp.canBeValid(s1, locked1)); // Expected: true

        String s2 = "(()))";
        String locked2 = "11001";
        System.out.println("Test Case 2: " + vp.canBeValid(s2, locked2)); // Expected: true

        String s3 = "()())";
        String locked3 = "11110";
        System.out.println("Test Case 3: " + vp.canBeValid(s3, locked3)); // Expected: false

        String s4 = "())((";
        String locked4 = "000000";
        System.out.println("Test Case 4: " + vp.canBeValid(s4, locked4)); // Expected: true
    }
}
