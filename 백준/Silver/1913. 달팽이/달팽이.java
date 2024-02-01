import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int N,K;


    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());
       K = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        int row = N/2+1;
        int column = N/2+1;
        int count = 1;
        //4,4 -> 3,4 -> 3,5 -> 4,5 ->5,5
        int limit = 1;
        while(true) {
            for(int i=0; i<limit; i++) {
                map[row--][column] = count++;
            }
            if(count-1 == N*N) break;
            for(int i=0; i<limit; i++) {
                map[row][column++] = count++;
            }
            limit++;
            for(int i=0; i<limit; i++) {
                map[row++][column] = count++;
            }

            for(int i=0; i<limit; i++) {
                map[row][column--] = count++;
            }
            limit++;
        }

        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        for(int i = 1; i<N+1; i++){
            for(int j = 1; j<N+1; j++){
                sb.append(map[i][j]+" ");
                if(map[i][j]==K){
                    x=i;
                    y=j;
                }
            }
            sb.append("\n");
        }
        sb.append(x+" "+y);
        System.out.println(sb.toString());












    }

}




