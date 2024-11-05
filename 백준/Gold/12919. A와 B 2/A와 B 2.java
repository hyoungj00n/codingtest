import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int flag = 0;
    public static void dfs(String T, String S){

        if(S.length() == T.length()){
            if(S.equals(T)){
                flag = 1;
            }
            return;
        }
        if (T.charAt(T.length() - 1) == 'A') {
            dfs(T.substring(0,T.length()-1), S);
        }
        if (T.charAt(0) == 'B') {
            StringBuffer sb = new StringBuffer(T.substring(1));
            dfs(sb.reverse().toString(),S);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String S = br.readLine();
        String T = br.readLine();

        dfs(T,S);

        System.out.println(flag);
    }


}
