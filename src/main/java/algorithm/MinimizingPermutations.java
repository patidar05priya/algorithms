package algorithm;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimizingPermutations {

    public static void main(String[] args) {
        int n_1 = 5;
        int[] arr_1 = {7, 1, 3, 2, 4, 5, 6};
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        System.out.println(output_1);
    }

    static int minOperations(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> position = new HashMap<>();

        for (int i = 0; i < n; i++) {
            position.put(arr[i], i);
        }

        int ans = 0;

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (visited[i] || position.get(i + 1) == i) {
                continue;
            }

            int cycle = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = position.get(j + 1);
                cycle++;
            }

            ans += (cycle - 1);


        }
        return ans;
    }
}
