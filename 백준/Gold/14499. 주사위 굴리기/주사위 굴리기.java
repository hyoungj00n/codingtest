import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dice;
    static void roll(int dir, int x, int y){
        int[] tmpDice = Arrays.copyOf(dice, dice.length);
        switch(dir){
            //1,3,6,4
            case 1:
                dice[1] = tmpDice[3];
                dice[3] = tmpDice[6];
                dice[6] = tmpDice[4];
                dice[4] = tmpDice[1];
                break;
            //4,6,3,1
            case 2:
                dice[1] = tmpDice[4];
                dice[3] = tmpDice[1];
                dice[6] = tmpDice[3];
                dice[4] = tmpDice[6];
                break;
            //2,1,5,6
            case 3:
                dice[2] = tmpDice[1];
                dice[1] = tmpDice[5];
                dice[5] = tmpDice[6];
                dice[6] = tmpDice[2];
                break;
            case 4:
                dice[2] = tmpDice[6];
                dice[1] = tmpDice[2];
                dice[5] = tmpDice[1];
                dice[6] = tmpDice[5];
                break;
        }
        if (map[x][y] == 0) {
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        dice = new int[7];
        Arrays.fill(dice, 0);

        int[] dx = {0, 0, -1, 1};  // 동, 서, 북, 남
        int[] dy = {1, -1, 0, 0};

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String[] game = br.readLine().split(" ");

        dice[1] = map[x][y];

        for(int i = 0; i < game.length; i++){
            int dir = Integer.parseInt(game[i]);
            int tmpX = x + dx[dir - 1];
            int tmpY = y + dy[dir - 1];

            if(tmpX >= 0 && tmpY >= 0 && tmpX < N && tmpY < M){
                x = tmpX;
                y = tmpY;
                roll(dir, tmpX, tmpY);
                System.out.println(dice[1]);
            }
        }




    }
}
