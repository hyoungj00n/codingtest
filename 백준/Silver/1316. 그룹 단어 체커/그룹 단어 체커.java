import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N+1];
        for (int i = 0; i < N; i++){
            words[i] = br.readLine();
        }
        int count = N;
        for(int i = 0; i < N; i++){
            String temp = words[i];
            int[] check = new int[26];

            for (int j = 0; j < temp.length(); j++){
                if(check[temp.charAt(j) -'a'] == 0){
                    check[temp.charAt(j)-'a']++;
                } else if (j>0 && temp.charAt(j)!=temp.charAt(j-1)) {
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);

    }

}




