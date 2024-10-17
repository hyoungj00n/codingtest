import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {




    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[] city = new int[n];
    st = new StringTokenizer(br.readLine());
    int start = 0;
    int end = -1;

    for(int i = 0; i < n; i++){
        city[i] = Integer.parseInt(st.nextToken());
        end = Math.max(end, city[i]);
    }

    int max = Integer.parseInt(br.readLine());



    while(start <=end){
        int mid = (start+end) / 2;

        long sum = 0;

        for(int i = 0; i < n; i++){
            if(mid < city[i]){
                sum += mid;
            }else{
                sum += city[i];
            }
        }

        if(sum > max){
            end = mid - 1;
        }else{
            start = mid+1;
        }

    }
    System.out.println(end);





    }
}
