import java.util.*;
import java.io.*;
 
class Solution {
    static int answer;
    static int N;
    
 
    public int solution(int[] number) {
        N = 3;
        dfs(0, 0, 0, number);
        return answer;
    }
 
    public static void dfs(int cur, int cnt, int sum, int[] number) {
        if (cnt == N) {
            if (sum == 0)
                answer++;
            return;
        }
 
        for (int i = cur; i < number.length; i++) {
            dfs(i + 1, cnt + 1, sum + number[i], number);
        }
    }
}