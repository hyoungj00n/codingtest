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
        int S = Integer.parseInt(st.nextToken());

        String[] arr = br.readLine().split(" ");
        int[] num = new int[N+1];

        for(int i= 0; i < arr.length; i++){
            num[i] = Integer.parseInt(arr[i]);
        }

        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        int sum = 0;

        while(start <= N && end <= N){
            if( sum >= S && length > end-start){
                length = end - start;
            }
            if(sum < S){
                sum += num[end++];
            }else{
                sum -= num[start++];
            }

        }

        if (length == Integer.MAX_VALUE){
            System.out.println("0");
        } else System.out.println(length);

    }


}
