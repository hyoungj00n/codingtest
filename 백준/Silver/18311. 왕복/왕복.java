import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int N;
    static long K;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        distance = new int[N+1];
        boolean flag = false;
        for(int i = 0; i<N; i++){
            distance[i] =Integer.parseInt(st.nextToken());
            K -= distance[i];
            if(K < 0){
                System.out.println(i+1);
                flag = true;
                break;
            }
        }
        if(!flag){
        for(int i =N-1;i>=0; i--) {
            K -= distance[i];
            if (K < 0) {
                System.out.println(i + 1);
                break;
            }
        }
        }






    }

}




