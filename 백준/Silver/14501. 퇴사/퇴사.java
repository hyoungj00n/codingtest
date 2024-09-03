import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int day = Integer.parseInt(br.readLine());
        int[][] work = new int[day+1][2];
        int[] dp = new int[day+2];

        for(int i = 1; i <= day; i++){
            st = new StringTokenizer(br.readLine());
            work[i][0] = Integer.parseInt(st.nextToken());
            work[i][1] = Integer.parseInt(st.nextToken());

        }
        Arrays.fill(dp, 0);
        for(int j = day; j > 0; j--){
            if(j + work[j][0] > day+1){
                dp[j] = dp[j + 1];
                continue;
            }
            dp[j] = Math.max(dp[j+work[j][0]] + work[j][1],dp[j+1]);
        }

        System.out.println(dp[1]);
        
    }
}
