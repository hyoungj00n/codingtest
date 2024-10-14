import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {




    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] medal = new int[n][4];

    for(int i = 0; i < n; i++){
        st = new StringTokenizer(br.readLine());
        medal[i][0] = Integer.parseInt(st.nextToken());
        medal[i][1] = Integer.parseInt(st.nextToken());
        medal[i][2] = Integer.parseInt(st.nextToken());
        medal[i][3] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(medal, (o1, o2) -> {
        if(o1[1] == o2[1]){
            if(o1[2] == o2[2]){
                return o1[3] - o2[3];
            }
            else{
                return o1[2] - o2[2];
            }
        }else{
            return o1[1] - o2[1];
        }
    });
    int rank = 1;
    for(int i = 0; i < medal.length; i++){
        if(medal[i][0] == k){
            System.out.println(rank);
        }

        if(i!=0 && medal[i][1] == medal[i-1][1] && medal[i][2] == medal[i-1][2] && medal[i][3] == medal[i-1][3]){
            continue;
        }else{
            rank = i+1;
        }

    }


    }
}
