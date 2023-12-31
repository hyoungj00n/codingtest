import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int M;
    static boolean[] visit;
    static int[] arr;

    static StringBuilder sb =new StringBuilder();

    public static void dfs(int depth, int start){

        if(M == depth){
            for(int a : arr){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i+1;
                dfs(depth+1,i+1);
                visit[i] = false;

            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

         visit = new boolean[N];
         arr = new int[M];
         dfs(0,0);
        System.out.println(sb);



    }

}