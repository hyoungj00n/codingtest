import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] power = new String[N];
        int[] powerLevel = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            power[i] = st.nextToken();
            powerLevel[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i < M; i++){
            int start = 0;
            int end = power.length-1;
            int tmp = Integer.parseInt(br.readLine());

            while(start <= end){
                int mid = (start + end) / 2;

                if(tmp > powerLevel[mid]){
                    start = mid +1;
                }else{
                    end = mid - 1;
                }


            }

            sb.append(power[start]).append("\n");


        }

        System.out.println(sb.toString());

    }


}
