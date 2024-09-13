import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dust {
    int x, y, dust;

    Dust(int x, int y, int dust){
        this.x = x;
        this.y = y;
        this.dust = dust;
    }
}

public class Main {

    static int[][] map;
    static Queue<Dust> queue = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int machine;

    static void checkVisit(int x, int y){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(map[i][j] != 0 && map[i][j] != -1){
                    queue.add(new Dust(i,j, map[i][j]));
                }
            }
        }
    }
    static void spread(int x, int y){

        int[][] tempMap = new int[x][y];

        while(!queue.isEmpty()){

            Dust dust = queue.poll();

            if(dust.dust < 5) continue; // 확산할 양이 없으면 건너뜀

            int spreadAmount = dust.dust / 5;
            int spreadCount = 0;

            for(int i = 0; i < 4; i++){
                int nx = dust.x + dx[i];
                int ny = dust.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < x && ny < y && map[nx][ny] != -1){
                    tempMap[nx][ny] += spreadAmount;
                    spreadCount++;
                }
            }

            map[dust.x][dust.y] -= spreadAmount * spreadCount;
        }

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(map[i][j] != -1){
                    map[i][j] += tempMap[i][j];
                }

            }
        }

    }

    static void machine(int x, int y){

        int top = machine -1;
        int bottom = machine;
        //아래
        for(int i = top-1; i > 0; i--){
            map[i][0] = map[i-1][0];
        }
        //왼쪽
        for(int i = 0; i < y-1; i++){
            map[0][i] = map[0][i+1];
        }
        //위
        for(int i = 0; i < top; i++){
            map[i][y-1] = map[i+1][y-1];
        }
        //오른쪽
        for(int i = y-1; i > 1; i--){
            map[top][i] = map[top][i-1];
        }
        map[top][1] = 0;


        for (int i = bottom+1; i < x-1; i++) {
            map[i][0] = map[i + 1][0];
        }

        for (int i = 0; i < y-1; i++) {
            map[x-1][i] = map[x-1][i+1];
        }

        for (int i = x-1; i > bottom; i--) {
            map[i][y-1] = map[i-1][y-1];
        }

        for (int i = y-1; i > 1; i--) {
            map[bottom][i] = map[bottom][i-1];
        }

        map[bottom][1] = 0;








    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    machine = i;
                }
            }
        }

        for(int i = 0; i < T; i++){
            checkVisit(R,C);
            spread(R,C);
            machine(R,C);
        }
        int sum = 0;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] > 0) sum += map[i][j];
            }
        }
        System.out.println(sum);

    }
}
