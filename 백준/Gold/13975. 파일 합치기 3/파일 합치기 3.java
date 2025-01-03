import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            PriorityQueue<Long> pq = new PriorityQueue<>();
            int K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < K; j++){
                pq.add(Long.parseLong(st.nextToken()));
            }
            long result = 0;
            while(pq.size() > 1){
                long a = pq.poll();
                long b = pq.poll();

                result += (a+b);
                pq.add(a+b);
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);

        
    }



}
