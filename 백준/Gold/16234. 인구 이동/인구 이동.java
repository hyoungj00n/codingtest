import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Location{
    int x,y;
    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {


    static int[][] map;
    static boolean[][] visited;
    static boolean move;
    static int[] dx = {1,-1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, L, R;


    static void bfs(int x, int y){


       Queue<Location> queue = new LinkedList<>();
       queue.add(new Location(x,y));
       visited[x][y] = true;
       int sum = map[x][y];
       List<Location> locations = new ArrayList<>();

       locations.add(new Location(x,y));

       while(!queue.isEmpty()){
           Location cl = queue.poll();
           int cx = cl.x;
           int cy = cl.y;

           for(int i = 0; i < 4; i++){
               int nx = cx + dx[i];
               int ny = cy + dy[i];

               if(nx>= 0 && nx < N && ny >= 0 && ny <N){
                   if(!visited[nx][ny] && checkMove(cx,cy, nx, ny)){
                       queue.add(new Location(nx, ny));
                       locations.add(new Location(nx,ny));
                       visited[nx][ny] =true;
                       sum += map[nx][ny];
                       move = true;
                   }
               }
           }

       }
       if(move) {
           for (int i = 0; i < locations.size(); i++) {

               Location l = locations.get(i);

               map[l.x][l.y] = sum / locations.size();

           }
       }


    }

    static boolean checkMove(int cx, int cy, int nx, int ny){
        int compare = Math.abs(map[cx][cy] - map[nx][ny]);

        if(compare >= L && compare <= R){
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int count = 0;

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        while(true){

            visited = new boolean[N][N];
            move = false;

            for(int i = 0; i<N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        bfs(i,j);
                    }
                }
            }

            if(!move){
                break;
            }
            else{
                count++;
            }


        }
        System.out.println(count);

    }
}
