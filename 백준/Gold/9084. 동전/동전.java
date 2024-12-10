import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // dp[1] = 1, dp[2] = 2, dp[3] = 3, dp[4] = 1, dp[5] = 2, dp[6] = 3

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            int coinCount = Integer.parseInt(br.readLine());
            int[] coins = new int[coinCount];

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < coinCount; j++){
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int price = Integer.parseInt(br.readLine());

            int[] dp = new int[price+1];

            dp[0] = 1;

            for(int coin : coins){
                for(int p = coin; p <= price; p++){
                    dp[p] += dp[p - coin];
                }
            }

            sb.append(dp[price]).append("\n");
        }

        System.out.println(sb);

    }



}
