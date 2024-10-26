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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i =0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int end = 0;
        int min = Integer.MAX_VALUE;


        for(int start = 0; start < n; start++){

            while(end < n-1 && arr[end] - arr[start] < m){
                end++;
            }
            if(arr[end] - arr[start] >= m){
                min = Math.min(arr[end] - arr[start], min);
            }


        }

        System.out.println(min);

    }


}
