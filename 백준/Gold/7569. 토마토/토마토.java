import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Main{




        static int M, N, H;

        static int[][][] map;

        static int result = Integer.MIN_VALUE;

        static int[] rowdx ={-1,0,1,0,0,0};

        static int[] coldy = {0,1,0,-1,0,0};

        static int[] dh = {0,0,0,0,1,-1};
        static Deque<Tomato> deque = new ArrayDeque<>();

        static class Tomato{
            int height;
            int row;
            int col;
            Tomato(int row, int col , int h){

                this.row = row;
                this.col = col;
                this.height = h;
            }
        }

        static int bfs(){



            while(!deque.isEmpty()){

                Tomato tomato = deque.poll();
                int col = tomato.col;
                int height = tomato.height;
                int row = tomato.row;

                for(int i = 0 ; i<6; i++){
                    int next_row = row + rowdx[i];
                    int next_col = col + coldy[i];
                    int next_height = height + dh[i];

                    if (next_height >=1 && next_height <= H && next_col >=1 && next_col <=M && next_row>=1 && next_row <=N &&map[next_height][next_row][next_col] == 0){
                        deque.add(new Tomato(next_row,next_col,next_height));
                        map[next_height][next_row][next_col] = map[height][row][col] + 1;
                    }
                }

            }

            for(int h= 1 ; h<= H; h++){
                for(int i = 1; i<= N; i++){
                    for(int j = 1; j<= M; j++){
                        if (map[h][i][j] == 0){
                            return -1;
                        }
                        result = Math.max(result, map[h][i][j]);
                    }
                }
            }

            if (result == 1){
                return 0;
            }
            else{
                return result -1;
            }
        }


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());//열
            N = Integer.parseInt(st.nextToken());//행
            H = Integer.parseInt(st.nextToken());

            map = new int[H+1][N+1][M+1];


            for(int h = 1; h <= H; h++) {
                for (int i = 1; i <=N; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 1; j <= M; j++) {
                        map[h][i][j] = Integer.parseInt(st.nextToken());
                        if (map[h][i][j] == 1) {
                            deque.add(new Tomato(i,j,h));
                        }
                    }
                }
            }

            System.out.println(bfs());













    }



}