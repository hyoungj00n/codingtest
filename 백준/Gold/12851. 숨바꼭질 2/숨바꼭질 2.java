import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static private int count = 0;
    static private int[] total = new int[1000001];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(total,0);
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        if(N >= K){
            System.out.println(N-K);
            System.out.println(1);
            return;
        }
        bfs(N,K);
        System.out.println(min);
        System.out.println(count);
    }

    public static void bfs(int start,int end){
        Queue<Integer> queue = new ArrayDeque();
        total[start] = 1;
        queue.add(start);

        while(!queue.isEmpty()){

            int node = queue.poll();

            if(min < total[node]){
                return;
            }
            for (int i = 0; i<3; i++){
                int next;
                if (i==2){
                     next= node * 2;
                }
                else if(i == 1){
                    next = 1+node;
                }else{
                    next = node - 1;
                }

                if (next < 0 || next >100000){
                    continue;
                }
                if (next == end){
                    min = total[node];
                    count++;
                }
                if (total[next] == 0 || total[next] == total[node] + 1){
                    total[next] = total[node] +1;
                    queue.add(next);
                }
            }

        }
    }
}