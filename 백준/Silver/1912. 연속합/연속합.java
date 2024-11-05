import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Integer[] arr = Arrays.stream(input)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = arr[0];

        for(int i = 1; i < n; i++){

            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);

        }

        System.out.println(max);
    }


}
