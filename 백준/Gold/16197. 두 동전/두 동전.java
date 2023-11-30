import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main{

    static int N , M;
    static String[][] board;


    static int flag=0;
    static int coin1_x,coin1_y, coin2_x, coin2_y;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int count=0;

    static int answer;

    static boolean[][][][] visited;

    static int b=0;

    public static void bfs(Deque<int[][]> queue) {

        while (!queue.isEmpty()) {

            if (count>10){
                return;
            }

            int[][] coin = queue.poll();
            int c1y_t = coin[0][0];
            int c1x_t = coin[0][1];
            int c2y_t = coin[1][0];
            int c2x_t = coin[1][1];
            int c = coin[2][0];
            if (coin[2][0] >= 10) {
                break;
            }
            if (c1y_t==c2y_t && c1x_t == c2x_t){
                continue;
            }
            visited[c1y_t][c1x_t][c2y_t][c2x_t]= true;

            for (int i = 0; i < 4; i++) {
                int temp = 0;
                int c1y = c1y_t + dy[i];
                int c1x = c1x_t + dx[i];
                int c2y = c2y_t + dy[i];
                int c2x = c2x_t + dx[i];

                if (c1y < 1 || c1y > N || c1x < 1 || c1x > M) {
                    temp++;
                }
                if (c2y < 1 || c2y > N || c2x < 1 || c2x > M) {
                    temp++;
                }

                if (temp == 2) {
                    continue;
                }
                if (temp == 1) {
                    answer = Math.min(answer, c + 1);
                    b =1;
                    return;
                }
                if (board[c1y][c1x].equals("#")) {
                    c1y -= dy[i];
                    c1x -= dx[i];

                }
                if (board[c2y][c2x].equals("#")) {
                    c2y -= dy[i];
                    c2x -= dx[i];
                }
                if (visited[c1y][c1x][c2y][c2x] == false) {
                    visited[c1y][c1x][c2y][c2x]= true;
                    int[][] tmp = {{c1y, c1x}, {c2y, c2x}, {c+1}};
                    queue.add(tmp);
                }
            }

        }



    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N+1][M+1];
        visited = new boolean[N+1][M+1][N+1][M+1];

        for (int i = 1; i <= N; i++){
            String[] s = br.readLine().split("");
            for(int j = 1; j <= M; j++){
                board[i][j] = s[j-1];
                if (flag==0 && s[j-1].equals("o")){
                    coin1_y = i;
                    coin1_x = j;
                    flag = 1;

                } else if (flag == 1 && s[j-1].equals("o")) {
                    coin2_y = i;
                    coin2_x = j;
                }
            }
        }

        Deque<int[][]> queue = new ArrayDeque<>();
        int[][] loc= {{coin1_y,coin1_x},{coin2_y,coin2_x},{count}};
        queue.add(loc);
        answer = 999999999;

        bfs(queue);

        if (b == 0){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }

    }

}