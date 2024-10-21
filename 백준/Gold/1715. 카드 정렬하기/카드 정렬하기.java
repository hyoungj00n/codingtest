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

        Queue<Integer> queue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        while(queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();

            queue.add(a+b);
            sum += (a+b);
        }
        System.out.println(sum);

    }


}
