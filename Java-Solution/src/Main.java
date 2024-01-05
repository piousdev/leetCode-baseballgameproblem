import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        class Solution {
            public int calPoints(String[] operations) {
                int output = 0;
                int[] list = new int[operations.length];

                for (int i = 0, j = -1; i < operations.length; i++) {
                    switch (operations[i]) {
                        case "C" -> {
                            list[j] = 0;
                            j--;
                        }
                        case "D" -> {
                            j++;
                            list[j] = 2 * (list[j - 1]);
                        }
                        case "+" -> {
                            j++;
                            list[j] = (list[j - 1] + list[j - 2]);
                        }
                        default -> {
                            j++;
                            list[j] = (Integer.parseInt(operations[i]));
                        }
                    }
                }

                for (int n : list) {
                    System.out.print(n);
                    output += n;
                }

                return output;
            }
        }

        Solution solution = new Solution();
        String[][] operationsArray = {
                {"5","2","C","D","+"},
                {"5","-2","4","C","D","9","+","+"},
                {"1","C"}
        };

        for (String[] operations : operationsArray) {
            int result = solution.calPoints(operations);
            System.out.println("The result for operations " + Arrays.toString(operations) + " is: " + result);
        }
    }
}