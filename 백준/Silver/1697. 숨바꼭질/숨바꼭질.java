import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Main{

    static int N, K;
    static int[] check= new int[100001];
    static void bfs(int start){

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        check[start] = 1;


        while(!deque.isEmpty()){
            int temp = deque.poll();

            for(int i = 0; i<3; i++){
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    System.out.println(check[temp]);
                    return;
                }
                if (next >= 0 && next < check.length && check[next] == 0) {
                    deque.add(next);
                    check[next] = check[temp] + 1;
                }

            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    
        if(N==K){
            System.out.println(0);
        }else{
            bfs(N);    
        }
        




    }



}