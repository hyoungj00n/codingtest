import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int n;
    static int[][] map;
    static boolean[] visited;

    static void dfs(int idx, int depth){
        if(depth == n/2){
            cal();
            return;
        }

        for(int i = idx; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }

    }

    static void cal(){
        int star = 0;
        int link = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (visited[i] && visited[j]) {
                    star += map[i][j];
                    star += map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        int result = Math.abs(star - link);

        if(result ==0){
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(result,min);
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0,0);
        System.out.println(min);

    }
}
