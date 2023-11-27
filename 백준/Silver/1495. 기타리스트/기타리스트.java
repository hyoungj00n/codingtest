import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int[] volume;
    static int count = 0;

    static int max =1;

    static int N, S, M;
    static int[][] dp;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer string = new StringTokenizer(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(string.nextToken());
        S = Integer.parseInt(string.nextToken());
        M = Integer.parseInt(string.nextToken());
        volume = new int[N+1];
        for (int i= 1; i<=N; i++){
            volume[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1][M+1];

        func(1,S);
        boolean flag = true;
        for(int i=M; i>=0; i--){
            if (dp[N][i] == 1){
                flag = false;
                System.out.println(i);
                break;
            }
        }
        if(flag) System.out.println(-1);



    }

    static void func(int i, int start){
        if(i == N+1) return;
        if( start + volume[i] <= M){
                if(dp[i][start+volume[i]]==0){
                    dp[i][start+volume[i]]=1;
                    func(i+1,start+volume[i]);
                }
        }
        if( start - volume[i] >=0){
            if(dp[i][start-volume[i]]==0){
                dp[i][start-volume[i]]=1;
                func(i+1,start-volume[i]);
            }
        }
    }

}