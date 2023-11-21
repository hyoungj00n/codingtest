import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] arr = new int[N+1];

        for (int i =0; i< N; i++){
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int total = 0;
        while(start <= N && end <= N){
            if (total >= S && min > end - start){
                min = end - start;
            }
            if(total < S) {
                total += arr[end++];
            } else {
                total -= arr[start++];
            }
        }

        if (min == Integer.MAX_VALUE){
            System.out.println("0");
        } else System.out.println(min);


    }
}
