import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{

    static int N;
    static long[] dp;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new long[N+1];
        for (int i = 1; i <= N; i++){

            if(i <= 6){
                dp[i] = i;
                continue;
            }

            for (int j = 2; j <= 5; j++){
                dp[i] = Math.max(dp[i], dp[i-j] *(j-1));
            }





        }
        System.out.println(dp[N]);
    }


}