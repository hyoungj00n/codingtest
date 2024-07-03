import java.util.*;
class Solution {
    static int answer;
    
    public int solution(int n, int k, int[] enemy) {
        answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < enemy.length; i++){
            n -= enemy[i];
            queue.add(enemy[i]);
            
            if(n < 0 && k == 0){
                break;
            }
            if(n < 0 && k > 0){
                int tmp = queue.poll();
                n += tmp;
                k--;
            }
            
            answer = i+1;
        }
        
        return answer;
    }
}