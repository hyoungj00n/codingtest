import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static boolean[] visited;
    static int[][] graph;

    static int N;
    static void dfs(int i){
        if(visited[i]){
            return;
        }
        visited[i] = true;

        for(int j = 1; j <= N; j++){
            if(graph[i][j] == 1){
                dfs(j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        int count = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);




        


        
    }



}
