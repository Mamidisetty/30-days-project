package Microsoft.Day1;

import java.util.Arrays;

public class ModifyArray {
    public int[] getModifiedArray(int length, int[][] updates) {
        // Initialize the array with length+1 (to handle the +1 indexing trick)
        int[] arr = new int[length + 1];

        // Process each update
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int increment = update[2];

            // Add the increment at the start index
            arr[start] += increment;

            // Subtract the increment at the index after end
            if (end + 1 < arr.length) {
                arr[end + 1] -= increment;
            }
        }

        // Apply the prefix sum to accumulate values
        for (int i = 1; i < length; i++) {
            arr[i] += arr[i - 1];
        }

        // Copy the result into a new array of size 'length' (ignore the last element)
        return Arrays.copyOf(arr, length);
    }

    public static void main(String[] args) {
        ModifyArray solution = new ModifyArray ();
        int length = 5;
        int[][] updates = { {1, 3, 2}, {2, 4, 3}, {0, 2, -2} };

        int[] result = solution.getModifiedArray(length, updates);
        System.out.println(Arrays.toString(result)); // Output: [-2, 0, 3, 5, 3]
    }
}
