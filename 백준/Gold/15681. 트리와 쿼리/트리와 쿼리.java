import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] leaf;
    static boolean[] visited;

    static int dfs(int R){


        visited[R] = true;
        int count = 1;

        for(int node : tree[R]){
            if(visited[node]){
                continue;
            }
            count += dfs(node);
        }

        leaf[R] = count;

        return leaf[R];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+1];
        leaf = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i <= N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i <N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(R);

        StringBuffer sb = new StringBuffer();
        while(Q-- > 0) {
            int query = Integer.parseInt(br.readLine());
            sb.append(leaf[query]).append("\n");
        }
        System.out.println(sb);


    }



}
