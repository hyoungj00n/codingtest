import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int M = Integer.parseInt(br.readLine());

        int[] arrM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(A);

        int[] result = new int[arrM.length];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arrM.length; i++){
            int start = 0;
            int end = A.length-1;
            int flag = 0;

            while(start <= end){
                int mid = (start+end) / 2;

                if(A[mid] == arrM[i]){
                    flag = 1;
                    break;
                }
                if(A[mid] > arrM[i]){
                    end = mid-1;
                }else{
                    start = mid + 1;
                }
            }
            if(flag == 1){
                sb.append(1).append('\n');
            }else{
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);
    }



}
