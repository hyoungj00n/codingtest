import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE ;
    static int[] num;
    static int[] sign;

    static int n;
    static int flag = 1;

    static void dfs(int depth, int result, int plus, int minus, int mul, int div){

        if(depth == n-1){
            if(flag ==1){
                flag = 0;
                minResult = result;
                maxResult = result;
            }else{
                minResult = Math.min(minResult, result);
                maxResult = Math.max(maxResult, result);
            }

            return;
        }
        if(plus > 0) {
            dfs(depth + 1, result + num[depth+1], plus - 1, minus, mul, div);
        }
        if(minus > 0) {
            dfs(depth + 1, result - num[depth+1], plus, minus-1, mul, div);
        }
        if(mul > 0) {
            dfs(depth + 1, result * num[depth+1], plus, minus, mul-1, div);
        }
        if(div > 0) {
            dfs(depth + 1, result / num[depth + 1], plus, minus, mul, div-1);
        }

    }


    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    sign = new int[4];

    n = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());

    num = new int[n];

    for(int i = 0; i < n; i++){
        num[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < 4; i++){
        sign[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0,num[0], sign[0], sign[1],sign[2], sign[3]);


    System.out.println(maxResult);
    System.out.println(minResult);




    }
}
