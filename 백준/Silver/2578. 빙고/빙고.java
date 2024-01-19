import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Main{

    static int[][] bingo_map= new int[5][5];
    static int bingo_count;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                bingo_map[i][j] =Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<5; i++){
            st =new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                count++;
                bingo(Integer.parseInt(st.nextToken()));
                bingo_check();
                if(bingo_count>=3){
                    System.out.println(count);
                    return;
                }
            }
        }




    }

    public static void bingo(int n){
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(bingo_map[i][j] == n) {
                    bingo_map[i][j] = -1;
                    return;
                }
            }
        }
    }

    public static void bingo_check() {
        bingo_count=0;
        int row = 0;
        int col = 0;
        int diag_right = 0;
        int diag_left = 0;
        int index = 0;
        for (int i = 0; i < 5; i++) {
            row = 0;
            col = 0;
            for (int j = 0; j < 5; j++) {
                row += bingo_map[i][j];
                col += bingo_map[j][i];

                if (i == j) {
                    diag_left += bingo_map[i][j];
                }
                if (i == index && j == 4 - index) {
                    diag_right += bingo_map[i][j];
                    index++;
                }
            }
            if (row == -5) {
                bingo_count++;
            }
            if (col == -5) {
                bingo_count++;
            }
            if (diag_left == -5) {
                bingo_count++;
            }
            if (diag_right == -5) {
                bingo_count++;
            }
        }

    }

}
